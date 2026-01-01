    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Adresse
{
    private int numero;
    private String modaliteNumero;
    private String typeVoie;
    private String nomVoie;
    private int codePostal;
    private String nomVille;

    public int getNumero()
    {
        return this.numero;
    }
    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public String getNomVoie()
    {
        return this.nomVoie;
    }
    public void setNomVoie(String nomVoie)
    {
        this.nomVoie = nomVoie;
    }
    
    public int getCodePostal()
    {
        return this.codePostal;
    }
    public void setCodePostal(int codePostal)
    {
        this.codePostal = codePostal;
    }

    public String getModaliteNumero()
    {
        return this.modaliteNumero;
    }
    public void setModaliteNumero(String modaliteNumero)
    {
        this.modaliteNumero = modaliteNumero;
    }

    public String getTypeVoie()
    {
        return this.typeVoie;
    }
    public void setTypeVoie(String typeVoie)
    {
        this.typeVoie = typeVoie;
    }

    public String getNomVille()
    {
        return this.nomVille;
    }
    public void setNomVille(String nomVille)
    {
        this.nomVille = nomVille;
    }

    public Adresse(int numero, String modaliteNumero, String typeVoie, String nomVoie, int codePostal, String nomVille)
    {
        this.setNumero(numero);
        this.setModaliteNumero(modaliteNumero);// bis, ter…
        this.setTypeVoie(typeVoie);
        this.setNomVoie(nomVoie);
        this.setCodePostal(codePostal);
        this.setNomVille(nomVille);
    }
    public Adresse(int numero, String typeVoie, String nomVoie, int codePostal, String nomVille)
    {
        this(numero,"",typeVoie,nomVoie,codePostal,nomVille);
    }
    public Adresse()
    {
        this
        (
             Lire.i("Numéro dans la voie"),
             Lire.S("Modalité numéro (bis/ter… laisser vide sinon)"),
             Lire.S("Type de voie (rue, avenue, boulevard…)"),
             Lire.S("Nom de la voie"),
             Lire.i("Code postal"),
             Lire.S("Ville")
        );
    }

    @Override
    public String toString()
    {
        return this.getNumero() + " "+this.getModaliteNumero()+" "+this.getTypeVoie()+ " " + this.getNomVoie()+"\n" +
               this.getCodePostal() + ", "  + this.getNomVille();
    }
    
}
