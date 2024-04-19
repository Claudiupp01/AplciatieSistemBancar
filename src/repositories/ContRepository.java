package repositories;

import exceptions.ExceptionInsufficientSold;
import models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContRepository implements IRepository {

    private ArrayList<ContBancar> conturi;
    private ArrayList<AbstractTranzactie> tranzactii;

    private String filePathCont = "conturi.txt";
    private String filePathTranzactie = "extrasDeCont.txt";

    public void saveToFileCont() throws IOException {
        FileWriter writer = new FileWriter(filePathCont);
        for (ContBancar cont : conturi) {
            writer.write(cont + "\n");
        }
        writer.close();
    }

    public void saveToFileTranzactii() throws IOException {
        FileWriter writer = new FileWriter(filePathTranzactie);
        for (AbstractTranzactie tranzactie : tranzactii) {
            writer.write(tranzactie + "\n");
        }
        writer.close();
    }

    public ContRepository() {
        conturi = new ArrayList<>();
        tranzactii = new ArrayList<>();
    }

    @Override
    public void creazaCont(ContBancar cont) throws IOException {

        conturi.add(cont);
        saveToFileCont();
    }

    public void creazaTranzactie(String iban, int caz, int suma) throws ExceptionInsufficientSold, IOException {

        AbstractTranzactie tranzactieNoua = null;

        String ibanContCarePrimesteBani = "";
        
        for(ContBancar cont : conturi) {

            if (cont.getIban().equals(iban)) {
                if (caz == 1) {
                    tranzactieNoua = new Depunere(cont, suma);
                    tranzactieNoua.realizareTranzactie(cont);
                    cont.getTranzactiileUnuiCont().add(tranzactieNoua);
                    break;
                }
                else if (caz == 2) {
                    tranzactieNoua = new Retragere(cont, suma);
                    tranzactieNoua.realizareTranzactie(cont);
                    cont.getTranzactiileUnuiCont().add(tranzactieNoua);
                    break;
                }
                else if (caz == 3) {
                    Scanner in = new Scanner(System.in); // Nu ar fi trebuit sa aducem un Scanner si aici insa acum doar asa a vrut sa iasa ...
                    System.out.println("IBAN cont care primeste bani: ");
                    ibanContCarePrimesteBani = in.nextLine();
                    System.out.println(ibanContCarePrimesteBani);
                    for(ContBancar cont1 : conturi) {

                        if (cont1.getIban().equals(ibanContCarePrimesteBani)) {
                            //cont.getSoldDisponibil();
                            tranzactieNoua = new Transfer(cont, suma, cont1);
                            //cont.getSoldDisponibil();
                            tranzactieNoua.realizareTranzactie(cont);
                            cont.getTranzactiileUnuiCont().add(tranzactieNoua);
                            cont1.getTranzactiileUnuiCont().add(tranzactieNoua);
                            //cont.getSoldDisponibil();
                            //tranzactii.add(tranzactieNoua);
                            //cont.getSoldDisponibil();
                        }
                    }
                    //tranzactieNoua = new Transfer(cont, suma);
                    break;
                }
            }
        }

        saveToFileTranzactii();
    }

    @Override
    public ArrayList<ContBancar> listareConturiBancare() {
        return conturi;
    }

    public ArrayList<AbstractTranzactie> listareTranzactiiAUnuiCont(String iban) {

        for(ContBancar cont : conturi) {

            if (cont.getIban().equals(iban)) {
                return cont.getTranzactiileUnuiCont();
            }
        }

        return null;
    }

    @Override
    public void stergeCont(String iban, String pin) {
        if((conturi.removeIf(contCurent -> contCurent.getIban().equals(iban) && contCurent.getPin().equals(pin))) == false)
        {
            System.out.println("Asigurati-va ca ati introdus un IBAN existent si pin-ul curent pentru acest IBAN !");
        }
    }

    @Override
    public void modificaNumeTitularCont(String iban, String numeNou) {
        for(ContBancar cont : conturi)
        {
            if(cont.getIban().equals(iban))
            {
                cont.setNumeTitular(numeNou);
                break;
            }
        }
    }

    @Override
    public void modificaAdresaTitularCont(String iban, String adresaNoua) {
        for(ContBancar cont : conturi)
        {
            if(cont.getIban().equals(iban))
            {
                cont.setAdresaTitular(adresaNoua);
                break;
            }
        }
    }

    /*
    public void faTranzactie(int suma, String iban) throws ExceptionInsufficientSold {
        for (int i = 0; i < tranzactii.size(); i++)
        {
            if(tranzactii.get(i).getCont().getIban().equals(iban))
            {
                tranzactii.get(i).realizareTranzactie(suma, tranzactii.get(i).getCont());
            }
        }
    }
     */

}
