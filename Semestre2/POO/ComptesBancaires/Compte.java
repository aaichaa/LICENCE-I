/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Compte
{    
    private String numCompte;
    public String getNumCompte(){return numCompte;}
    private void setNumCompte(String numCompte){this.numCompte = numCompte;}

    private Caisse support;
    public Caisse getSupport(){return support;}
    private void setSupport(Caisse support){this.support = support;}

    private Client titulaire;
    public Client getTitulaire(){return titulaire;}
    public void setTitulaire(Client titulaire){this.titulaire = titulaire;}

    private Carte carte;
    public Carte getCarte(){return carte;}
    public void setCarte(Carte carte){this.carte=carte;}
    
    public LesOperations listeOperations;
    public LesOperations getListeOperations(){return this.listeOperations;}
    private void setListeOperations(LesOperations listeOperations)
    {
        this.listeOperations = listeOperations;
    }
    
    private boolean clos;
    public boolean isClos(){return this.clos;}
    public void setClos(boolean actif){this.clos = actif;}      

    public double getSolde(){return this.getSupport().getSolde();}

    public void versement(double montant)
    {
        new Versement(this,montant).opere();
    }

    public void retrait(double montant)
    {
        new Retrait(this,montant).opere();
    }
    
    public void virement(Compte beneficiaire, double montant)
    {
        new Virement(this,beneficiaire,montant).opere();
    }
    
    public void cloture()
    {
        new Cloture(this).opere();
    }
            
    public boolean isVide(){return this.getSupport().isVide();}

    public Compte(String numCompte, Client titulaire, double montant)
    {
        this.setNumCompte(numCompte);
        this.setTitulaire(titulaire);
        this.setSupport(new Caisse());
        this.setListeOperations(new LesOperations());
        this.getSupport().versement(montant);
        this.setClos(false);
    }
    public Compte(String numCompte, Client titulaire)
    {
        this(numCompte,titulaire,0);
    }

    @Override
    public String toString()
    {
        String affichage = "Compte numéro " + this.getNumCompte() + " possédé par " + this.getTitulaire().getPrenom()+" "+this.getTitulaire().getNom();
        if(this.getCarte()!=null) affichage = affichage + "\nCarte associée :\n"+this.getCarte();
        return affichage+"\n" + this.getListeOperations();
    }
}
