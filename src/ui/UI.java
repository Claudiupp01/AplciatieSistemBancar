package ui;

import exceptions.ExceptionInsufficientSold;
import models.*;
import repositories.AbstractTranzactie;
import services.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class UI {

    private Service service;

    public UI(Service _service){
        service = _service;
    }

    public void afisareMeniu(){
        System.out.println("1.) Creare cont bancar");
        System.out.println("2.) Sterge un cont");
        System.out.println("3.) Afisare conturi bancare existente");
        System.out.println("4.) Modificare nume titular cont");
        System.out.println("5.) Modificare adresa titular cont");
        System.out.println("6.) Gestionare tranzactii");
        System.out.println("7.) Extras de cont");
        System.out.println("8.) Exit");
    }

    public void comandaCreareCont() throws IOException {
        String nume, cnp, adresa, serie, numar, pin;
        Scanner in = new Scanner(System.in);

        System.out.println("Nume titular cont: ");
        nume = in.nextLine();
        System.out.println("CNP titular cont: ");
        cnp = in.nextLine();
        System.out.println("Adresa titular cont: ");
        adresa = in.nextLine();
        System.out.println("Serie titular cont: ");
        serie = in.nextLine();
        System.out.println("Numar titular cont: ");
        numar = in.nextLine();
        System.out.println("Pin titular cont: ");
        pin = in.nextLine();


        service.creareCont(nume, cnp, adresa, serie, numar, pin);
    }

    public void comandaStergeCont(){
        String iban, pin;
        Scanner in = new Scanner(System.in);
        System.out.println("Alegeti un IBAN: ");
        iban = in.nextLine();
        System.out.println("Pin-ul contului pe care doriti sa il stergeti este: ");
        pin = in.nextLine();

        service.stergeCont(iban, pin);
    }


    public void comandaAfisareConturi() {
        ArrayList<ContBancar> conturi = service.getAllConturiBancare();

        for(ContBancar cont : conturi)
        {
            System.out.println(cont);
        }

    }


    /*
    private HashSet<String> savedContIbans = new HashSet<>();

    public void comandaAfisareConturi() {
        ArrayList<ContBancar> conturi = service.getAllConturiBancare();

        for (ContBancar cont : conturi) {
            System.out.println(cont);
            if (!savedContIbans.contains(cont.getIban())) {
                saveToFile(cont.toString(), "conturi.txt", true);

                savedContIbans.add(cont.getIban());
            }
        }
    }
    */

    public void comandaModificareNumeTitularCont(){
        String iban, numeNou;
        Scanner in = new Scanner(System.in);
        System.out.println("IBAN cont: ");
        iban = in.nextLine();
        System.out.println("Nume nou titular: ");
        numeNou = in.nextLine();


        service.modificaNumeTitular(iban, numeNou);
    }

    public void comandaModificareAdresaTitularCont(){
        String iban, adresaNoua;
        Scanner in = new Scanner(System.in);
        System.out.println("IBAN cont: ");
        iban = in.nextLine();
        System.out.println("Adresa noua titular: ");
        adresaNoua = in.nextLine();


        service.modificaAdresaTitular(iban, adresaNoua);
    }

    /*
    private void afisareTranzactii(ArrayList<AbstractTranzactie> tranzactii)
    {
        for(AbstractTranzactie tranzactie : tranzactii)
        {
            System.out.println(tranzactie.toString()); // speciale
        }
    }
    */




    public void comandaRealizareTranzactie() throws ExceptionInsufficientSold, IOException {
        String iban;
        int suma;
        AbstractTranzactie tranzactie;

        Scanner in = new Scanner(System.in);
        System.out.println("IBAN cont: ");
        iban = in.nextLine();
        System.out.println("Suma: ");
        suma = in.nextInt();

        System.out.println("Tipul tranzactiei: ");
        System.out.println("1.) Depunere");
        System.out.println("2.) Retragere");
        System.out.println("3.) Transfer");

        int opt = 0;

        opt = in.nextInt();

        service.creareTranzactie(iban, opt, suma);
    }

    public void comandaExtrasDeCont() throws IOException {

        String iban;

        Scanner in = new Scanner(System.in);
        System.out.println("IBAN cont pentru care doriti sa generati extrasul de cont: ");
        iban = in.nextLine();

        System.out.println(service.getAllTranzactiiAUnuiCont(iban));
        FileWriter writer = new FileWriter("extrasDeCont.txt");

        ArrayList<AbstractTranzactie> tranzactii = service.getAllTranzactiiAUnuiCont(iban);

        for(AbstractTranzactie tranzactie : tranzactii)
        {
            System.out.println(tranzactie);
            writer.write(tranzactie + "\n");
        }
        writer.close();
    }


    public void run(){

        while(true)
        {
            afisareMeniu();
            Scanner in = new Scanner(System.in);
            System.out.println("\nAlegeti o optiune: ");
            int optiune = in.nextInt();

            try
            {
                switch(optiune)
                {
                    case 1:
                    {
                        comandaCreareCont();
                        break;
                    }
                    case 2:
                    {
                        comandaStergeCont();
                        break;
                    }
                    case 3:
                    {
                        comandaAfisareConturi();
                        break;
                    }
                    case 4:
                    {
                        comandaModificareNumeTitularCont();
                        break;
                    }
                    case 5:
                    {
                        comandaModificareAdresaTitularCont();
                        break;
                    }
                    case 6:
                    {
                        comandaRealizareTranzactie();
                        break;
                    }
                    case 7:
                    {
                        comandaExtrasDeCont();
                        break;
                    }
                    case 8:
                    {
                        return;
                    }
                    default:
                    {
                        System.out.println("Optiunea introdusa nu exista !");
                        break;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Exceptie !");
            }

        }



    }




}
