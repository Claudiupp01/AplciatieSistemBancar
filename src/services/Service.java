package services;

import exceptions.ExceptionInsufficientSold;
import models.*;
import repositories.AbstractTranzactie;
import repositories.IRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Service {

    private IRepository repository;

    public Service(IRepository _repository) throws IOException {
        this.repository = _repository;
        init();
    }

    void init() throws IOException {
        creareCont("Popescu Ion", "5240418028612", "strada Marului nr. 10", "AR", "000000", "000");
        creareCont("Ionescu Alexandru", "5240101016210", "strada Perei nr. 100", "AB", "010101", "000");
        creareCont("Georgescu Andrei", "5150202058211", "strada Nucii nr. 1", "BH", "123456", "000");
        creareCont("Marcescu Mihai", "5100503129200", "strada Piersicii nr. 20", "CJ", "102030", "000");
        creareCont("Pop Vlad", "5090605358222", "strada Portocalei nr. 150", "TM", "132798", "000");

    }

    public String randomIbanGenerator()
    {
        Random rand = new Random();
        String card = "RO";
        for (int i = 0; i < 14; i++)
        {
            int n = rand.nextInt(10) + 0;
            card += Integer.toString(n);
        }
        return card;
    }

    public void creareCont(String nume, String cnp, String adresa, String serie, String numar, String pin) throws IOException {
        ContBancar contNou = new ContBancar(randomIbanGenerator(), nume, cnp, adresa, serie, numar, pin);

        repository.creazaCont(contNou);

    }

    public void creareTranzactie(String iban, int caz, int suma) throws ExceptionInsufficientSold, IOException {
        repository.creazaTranzactie(iban, caz, suma);
    }

    public ArrayList<ContBancar> getAllConturiBancare()
    {
        return repository.listareConturiBancare();
    }

    public ArrayList<AbstractTranzactie> getAllTranzactiiAUnuiCont(String iban)
    {
        return repository.listareTranzactiiAUnuiCont(iban);
    }

    public void stergeCont(String iban, String pin)
    {
        repository.stergeCont(iban, pin);
    }

    public void modificaNumeTitular(String iban, String numeNou)
    {
        repository.modificaNumeTitularCont(iban, numeNou);
    }

    public void modificaAdresaTitular(String iban, String adresaNoua)
    {
        repository.modificaAdresaTitularCont(iban, adresaNoua);
    }



}
