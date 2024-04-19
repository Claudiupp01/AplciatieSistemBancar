package repositories;

import exceptions.ExceptionInsufficientSold;
import models.ContBancar;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepository {

    public void creazaCont(ContBancar cont) throws IOException;
    public ArrayList<ContBancar> listareConturiBancare();
    public void stergeCont(String iban, String pin);
    public void modificaNumeTitularCont(String iban, String numeNou);
    public void modificaAdresaTitularCont(String iban, String adresaNoua);
    public void creazaTranzactie(String iban, int caz, int suma) throws ExceptionInsufficientSold, IOException;
    public ArrayList<AbstractTranzactie> listareTranzactiiAUnuiCont(String iban);

}
