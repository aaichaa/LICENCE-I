/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Versement extends Operation
{
    public Versement(Compte support,double montant,String descriptif)
    {
        super(support,montant,descriptif);
        this.setBaseDescriptif("Versement de "+montant+"€");
    }
    public Versement(Compte support,double montant)
    {
        this(support,montant,null);
    }    
    
    @Override
    public void execute()
    {
        this.getCaisse().versement(this.getMontant());
    }
    
}
