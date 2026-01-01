/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Cloture extends Operation
{
    public Cloture(Compte support)
    {
        super(support,support.getSolde());
        this.setBaseDescriptif("Cloture. Retrait en liquide du solde : "+this.getMontant()+"€");
    }
    
    @Override
    public void execute()
    {        
        this.getCaisse().retrait(this.getMontant());
        this.getCompte().setClos(true);
    }
    
}
