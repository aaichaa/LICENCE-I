/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Caisse
{
    private double solde;
    public double getSolde(){return this.solde;}
    public void setSolde(double nSolde)
    {
        if(nSolde>=0) this.solde = nSolde;
    }
    private String incident;
    public String getIncident()
    {
        return this.incident;
    }
    public boolean isIncident()
    {
        return this.getIncident()!=null;
    }
    private void setIncident(String raison){this.incident = raison;}
    public void supprIncident(){this.setIncident(null);}
    
    public Caisse()
    {
        setSolde(0);
        this.setIncident(null);
    }    
    public void versement(double montant)
    {
        if(montant < 0) this.setIncident("Montant négatif");
        else setSolde(getSolde()+montant);
    }
    public void versement()
    {
        versement(Lire.d("Montant du versement"));
    }
    
    public void retrait(double montant)
    {
        if(!this.isIncident())
            if(montant <= 0) this.setIncident("Montant négatif");
            else
                if(montant>this.getSolde()) this.setIncident("Solde insuffisant");
                else setSolde(this.getSolde()-montant); 
    }
    public void retrait()
    {
        retrait(Lire.d("Montant du retrait"));
    }
    
    public boolean isVide(){return getSolde()==0;}
    public void vide()
    {
        setSolde(0);
    }
    public String toString()
    {
        String affichage="";
        if(isIncident()) affichage = "Caisse bloquée suite à l'incident suivant :\n"+this.getIncident();
        if(isVide()) return affichage+"\nCaisse vide !";
        else return affichage+"\nSolde : "+getSolde();
    }

}

