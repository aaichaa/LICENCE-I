/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Carte
{
    private String numero;
    private Compte referent;
    private Date expiration;

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public Compte getReferent()
    {
        return referent;
    }

    public void setReferent(Compte referent)
    {
        this.referent = referent;
    }

    public Date getExpiration()
    {
        return expiration;
    }

    private void setExpiration(Date expiration)
    {
        this.expiration = expiration;
    }
    
    public Client getTitulaire(){return this.getReferent().getTitulaire();}
    public String getPrenom(){return this.getTitulaire().getPrenom();}
    public String getNom(){return this.getTitulaire().getNom();}

    public Carte(String numero, Compte referent)
    {
        this.setNumero(numero);
        this.setReferent(referent);
        Date aujourdhui=new Date();
        this.setExpiration(new Date
                (
                    aujourdhui.getNumJour(),
                    aujourdhui.getNumMois(),
                    aujourdhui.getNumAnnee()+2// expiration deux ans après la création
                )
        );
    }
    public Carte(Compte referent)
    {
        this(Lire.S("Numéro de la carte"),referent);
    }
    @Override
    public String toString()
    {
        return  "Carte n° "+this.getNumero()+"\n"+
                "Titulaire : "+this.getPrenom()+" "+this.getNom()+"\n"+
                "Expire le : "+this.getExpiration()+"\n"+
                "Associée au compte :"+"\n"+this.getReferent().getNumCompte();
    }        
}
