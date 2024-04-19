package repositories;

import exceptions.ExceptionInsufficientSold;
import models.ContBancar;

public class Transfer extends AbstractTranzactie {

    private ContBancar contCarePrimesteBani;
    public Transfer(ContBancar cont, int suma, ContBancar contCarePrimesteBani) {
        super(cont, suma);
        this.contCarePrimesteBani = contCarePrimesteBani;
    }

    @Override
    public void realizareTranzactie(ContBancar contBancar) throws ExceptionInsufficientSold {
        if(cont.getSoldDisponibil() - suma >= 0)
        {
            cont.setSoldDisponibil(cont.getSoldDisponibil() - suma);
            contCarePrimesteBani.setSoldDisponibil(contCarePrimesteBani.getSoldDisponibil() + suma);
        }
        else
        {
            throw new ExceptionInsufficientSold();
        }
    }

    public String toString()
    {
        return super.toString() + "Transfer: " + suma;
    }

}
