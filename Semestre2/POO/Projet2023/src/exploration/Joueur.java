/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Joueur extends Mobile
{

    private String nom;

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    private int nbPierres;

    public int getNbPierres()
    {
        return nbPierres;
    }

    public void setNbPierres(int nbPierres)
    {
        this.nbPierres = nbPierres;
    }

    private boolean gagnant;

    public boolean isGagnant()
    {
        return this.gagnant;
    }

    private void setGagnant(boolean gagnant)
    {
        this.gagnant = gagnant;
    }
    private boolean perdant;

    public boolean isPerdant()
    {
        return this.perdant;
    }

    private void setPerdant(boolean perdant)
    {
        this.perdant = perdant;
    }
    
    public String mode;
        public String getMode()
    {
        return this.mode;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }
    public static final String LANCE_PIERRE = "lancer une pierre";
    public static final String JOUEUR_AVANCE = "avance";
   
    public void alterneMode()
    {
        if (mode.equals(LANCE_PIERRE)) this.setMode(JOUEUR_AVANCE);
        else this.setMode(LANCE_PIERRE);
    }

    public Joueur(String nom, Case depart, int nbPierres)
    {
        super(depart);
        this.setNom(nom);
        this.setNbPierres(nbPierres);
        this.setGagnant(false);
        this.setPerdant(false);
        this.setDirectionCourante(null);
        this.setMode(LANCE_PIERRE);
    }

    public void avance()
    {
        if (this.getDirectionCourante() != null)
        {
            Case depart = this.getPosition();
            depart.getSuivante(this.getDirectionCourante()).place(this);
            if (depart != this.getPosition())
            {
                depart.setOccupee(false);
            }
        }
    }

    public void lancePierre(Direction d)
    {
        if (this.getNbPierres() > 0)
        {
            this.getPosition().getSuivante(d).propagePierre(this, d);
        } else
        {
            System.out.println("Plus de pierres disponibles !");
        }
    }
    
    public void joue()
    {
        System.out.println("<Entrée>........ "+this.getMode()+" dans la direction "+this.getDirectionCourante());
        System.out.println("");
    }

    public void incNbPierres(int n)
    {
        this.setNbPierres(this.getNbPierres() + n);
    }

    public void decNbPierres()
    {
        this.setNbPierres(this.getNbPierres() - 1);
    }

    public void perd()
    {
        this.setPerdant(true);
    }
    public void perd(String raison)
    {
        this.setPerdant(true);
        System.out.println(raison+" ! "+this.getNom()+" a perdu !");
    }

    public void gagne()
    {
        System.out.println(this.getNom()+" est arrivé à bon port !");
        this.setGagnant(true);
    }

    @Override
    public String toString()
    {
        return "Le joueur " + this.getNom() + " a " + this.getNbPierres() + " pierres";
    }

}
