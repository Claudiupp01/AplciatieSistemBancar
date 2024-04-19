package repositories;

import exceptions.ExceptionInsufficientSold;
import models.ContBancar;

public abstract class AbstractTranzactie {
    protected ContBancar cont;
    protected int suma;

    public AbstractTranzactie(ContBancar cont, int suma) {
        this.cont = cont;
        this.suma = suma;
    }

    public abstract void realizareTranzactie(ContBancar cont) throws ExceptionInsufficientSold;

    public String toString()
    {
        return "Tip tranzactie: ";
    }

    public ContBancar getCont() {
        return cont;
    }

    public void setCont(ContBancar cont) {
        this.cont = cont;
    }
}
