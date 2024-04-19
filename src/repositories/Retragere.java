package repositories;

import exceptions.ExceptionInsufficientSold;
import models.ContBancar;

public class Retragere extends AbstractTranzactie {

    public Retragere(ContBancar cont, int suma) {
        super(cont, suma);
    }

    @Override
    public void realizareTranzactie(ContBancar contCurent) throws ExceptionInsufficientSold {
        if(suma > 0) {
            if (cont.getSoldDisponibil() - suma >= 0) {
                cont.setSoldDisponibil(cont.getSoldDisponibil() - suma);
            } else {
                throw new ExceptionInsufficientSold();
            }
        }
        else
        {
            System.out.println("Nu puteti introduce sume ca valori negative !");
        }
    }

    public String toString()
    {
        return super.toString() + "Retragere: " + "-" + suma;
    }

}
