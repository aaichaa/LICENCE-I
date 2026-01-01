/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Client
{
    private String prenom;
    private String nom;
    private String numTel;
    private Adresse adressePrincipale;
    private Adresse adresseSecondaire;
    private LesComptes comptes;

    public String getPrenom()
    {
        return prenom;
    }
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    public void setPrenom()
    {
        System.out.print("Entrez le prénom : ");
        setPrenom(Lire.S());
    }

    public String getNom()
    {
        return nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    public void setNom()
    {
        System.out.print("Entrez le nom : ");
        setNom(Lire.S());
    }

    public String getNumTel()
    {
        return numTel;
    }
    public void setNumTel(String numTel)
    {
        if(numTel.length()==10)this.numTel = numTel;
    }
    public void setNumTel()
    {
        System.out.print("Entrez le numéro de téléphone à 10 chiffres : ");
        setNumTel(Lire.S());
    }
    
    public Adresse getAdressePrincipale()
    {
        return adressePrincipale;
    }
    public void setAdressePrincipale(Adresse adressePrincipale)
    {
        this.adressePrincipale = adressePrincipale;
    }
    public void setAdressePrincipale()
    {
        System.out.print("Entrez une adresse : ");
        setAdressePrincipale(new Adresse());
    }

    public Adresse getAdresseSecondaire()
    {
        return adresseSecondaire;
    }
    public void setAdresseSecondaire(Adresse adresseSecondaire)
    {
        this.adresseSecondaire = adresseSecondaire;
    }
    public void setAdresseSecondaire()
    {
        System.out.print("Entrez une adresse : ");
        setAdresseSecondaire(new Adresse());
    }
    
    public Compte getComptes(int rang)
    {
        return comptes.get(rang);
    }
    public Compte nouveauCompte(String numero,double versementInitial)
    {
        Compte nouveau=new Compte(numero,this,versementInitial);
        this.comptes.add(nouveau);
        return nouveau;
    }
    public Compte nouveauCompte(String numero)
    {
        return nouveauCompte(numero,0);
    }
    
    public void setComptes()
    {
        this.comptes = new LesComptes();
    }
    
    public Client(String prenom, String nom, String numTel, Adresse adressePrincipale, Adresse adresseSecondaire)
    {
        this.setPrenom(prenom);
        this.setNom(nom);
        this.setNumTel(numTel);
        this.setAdressePrincipale(adressePrincipale);
        this.setAdresseSecondaire(adresseSecondaire);
        this.setComptes();
    }
    
    public Client(String prenom, String nom, String numTel, Adresse adressePrincipale)
    {
        this(prenom,nom,numTel,adressePrincipale,null);
    }
    
    public Client()
    {
        this(Lire.S("Prénom"),Lire.S("Nom"),Lire.S("Numéro de téléphone"),new Adresse(),null);
    }    

    @Override
    public String toString()
    {
        String affichage =
                this.getPrenom()+" "+this.getNom()+"\n"+
                this.getNumTel()+"\n"+
                this.getAdressePrincipale()+"\n";
        if(this.getAdresseSecondaire()!=null) affichage+=this.getAdresseSecondaire()+"\n";
        return affichage+this.comptes;
    }
}
