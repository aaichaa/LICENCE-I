/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Retrait extends Operation
{
    public Retrait(Compte support,double montant)
    {
        super(support,montant);
        this.setBaseDescriptif("Retrait de "+montant+"€");
    }
    
    @Override
    public void execute()
    {
        this.getCaisse().retrait(this.getMontant());
    }

}
