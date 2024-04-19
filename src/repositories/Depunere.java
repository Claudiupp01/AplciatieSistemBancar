package repositories;

import models.ContBancar;

public class Depunere extends AbstractTranzactie {

    public Depunere(ContBancar cont, int suma) {
        super(cont, suma);
    }

    @Override
    public void realizareTranzactie(ContBancar contCurent) {
        if(suma >= 0) {
            cont.setSoldDisponibil(cont.getSoldDisponibil() + suma);
        }
        else
        {
            System.out.println("Nu puteti introduce sume ca valori negative !");
        }
    }

    public String toString()
    {
        return super.toString() + "Depunere: " + "+" + suma;
    }
}
