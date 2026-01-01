/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public abstract class Operation
{  
    private double tarif;
    public double getTarif(){return this.tarif;}
    public void setTarif(double tarif){this.tarif = tarif;}
    
    private double montant;
    
    public double getMontant(){return this.montant;}
    protected final void setMontant(double montant){this.montant = montant;}

    private boolean ok;
    public final void setOK(boolean b){this.ok=b;}
    public boolean isOk(){return this.ok;}

    private double solde;
    public double getSolde(){return this.solde;}
    protected void setSolde(double solde){this.solde = solde;}

    private Date date;
    public Date getDate(){return this.date;}

    private void setDate(Date date) {this.date = date;}

    private Compte compte;    
    protected Compte getCompte(){return this.compte;}
    protected final void setCompte(Compte compte){this.compte = compte;}
    protected Caisse getCaisse(){return this.compte.getSupport();}

    private String descriptif;
    public String getDescriptif()
    {
        if(this.descriptif!=null) return this.descriptif;
        else return this.getBaseDescriptif();
    }
    public void setDescriptif(String descriptif){this.descriptif = descriptif;}

    private void setIncident(String libelleIncident)
    {
        this.setOK(false);
        this.setDescriptif(this.getBaseDescriptif()+". OPÉRATION NON EFFECTUÉE ("+libelleIncident+")");
    }
    
    public void opere()
    {
        this.getCompte().getListeOperations().add(this);
        if(this.getCompte().isClos()) setIncident("compte cloturé");
        else
        {
            this.execute();
            this.setSolde(this.getCaisse().getSolde());
            if(this.getCaisse().isIncident())
            {
                setIncident(this.getCaisse().getIncident());
                this.getCaisse().supprIncident();
            }
        }
    }
 
    private String baseDescriptif;
    public String getBaseDescriptif(){return this.baseDescriptif;}
    public void setBaseDescriptif(String baseDescriptif)
    {
        this.baseDescriptif = baseDescriptif;
    }
        
    public Operation(Compte compte,double montant, String descriptif)
    {
        this.setDate(new Date());
        this.setCompte(compte);
        this.setMontant(montant);
        this.setOK(true);
        this.setDescriptif(descriptif);
    }    
    
    public Operation(Compte compte,double montant)
    {
        this(compte,montant,null);
    }   
    
    protected abstract void execute();

    @Override
    public String toString()
    {
        return this.getDate().toStringCourtNum()+" à "+this.getDate().getHeure()+"h"+this.getDate().getMinutes()+ " : "+this.getDescriptif()+". Solde : "+this.getSolde()+"€";
    }
}
