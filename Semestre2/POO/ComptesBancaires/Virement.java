/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Virement extends Operation
{
    private Compte beneficiaire;

    public Compte getBeneficiaire()
    {
        return beneficiaire;
    }

    public final void setBeneficiaire(Compte beneficiaire)
    {
        this.beneficiaire = beneficiaire;
    }
    
    public Virement(Compte support, Compte beneficiaire, double montant)
    {
        super(support,montant);
        this.setBeneficiaire(beneficiaire);
        this.setBaseDescriptif("Virement de "+montant+"€ vers le compte "+this.getBeneficiaire().getNumCompte());
    }
    
    @Override
    public void execute()
    {
         this.getCaisse().retrait(this.getMontant());
         if(!this.getCaisse().isIncident())
         {
             Versement versementBeneficiaire=
                     new Versement
                     (
                             this.getBeneficiaire(),
                             this.getMontant(),
                             "Virement de "+this.getMontant()+"€ à partir du compte "+this.getCompte().getNumCompte()
                     );
             versementBeneficiaire.opere();
         }
    }

}
