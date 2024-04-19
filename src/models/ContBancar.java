package models;

import repositories.AbstractTranzactie;

import java.util.ArrayList;

public class ContBancar {

    private String numeTitular;
    private String adresaTitular;
    private String CNPtitular;
    private String seriaBuletinTitular;
    private String numarulBuletinTitular;
    private String iban;
    private String pin;
    private int soldDisponibil;

    private ArrayList<AbstractTranzactie> tranzactiileUnuiCont;


    public ContBancar(String iban, String numeTitular, String CNPtitular, String adresaTitular, String seriaBuletinTitular, String numarulBuletinTitular, String pin) {
        this.iban = iban;
        this.numeTitular = numeTitular;
        this.CNPtitular = CNPtitular;
        this.adresaTitular = adresaTitular;
        this.seriaBuletinTitular = seriaBuletinTitular;
        this.numarulBuletinTitular = numarulBuletinTitular;
        this.pin = pin;
        this.soldDisponibil = 0;
        this.tranzactiileUnuiCont = new ArrayList<>();
    }


    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNumeTitular() {
        return numeTitular;
    }

    public void setNumeTitular(String numeTitular) {
        this.numeTitular = numeTitular;
    }

    public String getCNPtitular() {
        return CNPtitular;
    }

    public void setCNPtitular(String CNPtitular) {
        this.CNPtitular = CNPtitular;
    }

    public String getAdresaTitular() {
        return adresaTitular;
    }

    public void setAdresaTitular(String adresaTitular) {
        this.adresaTitular = adresaTitular;
    }

    public String getSeriaBuletinTitular() {
        return seriaBuletinTitular;
    }

    public void setSeriaBuletinTitular(String seriaBuletinTitular) {
        this.seriaBuletinTitular = seriaBuletinTitular;
    }

    public String toString()
    {
        return "IBAN: " + iban + "\n" + " Nume titular: " + numeTitular + "\n" + "  Adresa titular: " + adresaTitular + "\n" + "   Seria buletin titular: " + seriaBuletinTitular + "\n" + "    Numar buletin titular: " + numarulBuletinTitular + "\n" + "     Sold disponibil: " + soldDisponibil;
    }

    public String getNumarulBuletinTitular() {
        return numarulBuletinTitular;
    }

    public void setNumarulBuletinTitular(String numarulBuletinTitular) {
        this.numarulBuletinTitular = numarulBuletinTitular;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getSoldDisponibil() {
        return soldDisponibil;
    }

    public void setSoldDisponibil(int soldDisponibil) {
        this.soldDisponibil = soldDisponibil;
    }

    public ArrayList<AbstractTranzactie> getTranzactiileUnuiCont() {
        return tranzactiileUnuiCont;
    }

    public void setTranzactiileUnuiCont(ArrayList<AbstractTranzactie> tranzactiileUnuiCont) {
        this.tranzactiileUnuiCont = tranzactiileUnuiCont;
    }
}
