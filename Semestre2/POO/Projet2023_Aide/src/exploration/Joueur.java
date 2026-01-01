/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Joueur
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

    private Case position;

    /**
     * Restitue la position courante du joueur
     * @return la référence à la case où se trouve le joueur
     */
    public Case getPosition()
    {
        return position;
    }

    public void setPosition(Case position)
    {
        this.position = position;
        /* ajout de code éventuel */
    }

    private int nbPierres;

    /**
     * Restitue le nombre de pierres actuellement en possession du joueur
     * @return un entier qui représente un nombre de pierres
     */
    public int getNbPierres()
    {
        return this.nbPierres;
    }

    public void setNbPierres(int nbPierres)
    {
        this.nbPierres = nbPierres;
    }

    private boolean gagnant;

    /**
     * Restitue vrai si le joueur est gagnant (il est arrivé en bas à droite du plateau)
     * @return un booléen qui indique si le joueur a gagné
     */
    public boolean isGagnant()
    {
        return this.gagnant;
    }

    private void setGagnant(boolean gagnant)
    {
        this.gagnant = gagnant;
    }
    private boolean perdant;

    /**
     * Restitue vrai si le joueur a perdu (explosion sur une mine)
     * @return un booléen qui indique si le joueur a perdu
     */
    public boolean isPerdant()
    {
        return this.perdant;
    }

    private void setPerdant(boolean perdant)
    {
        this.perdant = perdant;
    }
    

    public Joueur(String nom, Case depart, int nbPierres)
    {
        this.setNom(nom);
        this.setPosition(depart);
        this.setNbPierres(nbPierres);
        // Au départ, le joueur n'a ni perdu, ni gagné
        this.setGagnant(false);
        this.setPerdant(false);
    }

    public void avance()
    {
        // le joueur avance à la position qui suit sa position courante en fonction de sa direction
    }

    public void lancePierre(Direction d)
    {
        // le joueur lance une pierre dans la case voisine à partir de sa position dans la direction d
    }

    /**
     * Incrémentation du nombre de pierres de n unités
     * Sert quand le joueur arrive dans une case qui contient des pierres
     * @param n entier qui représente le nombre de pierres à ajouter
     */
    public void incNbPierres(int n)
    {
        this.setNbPierres(this.getNbPierres() + n);
    }

    /**
     * Décrémentation du nombre de pierres d'une unité lorsqu'une pierre est perdue
     */
    public void decNbPierres()
    {
        this.setNbPierres(this.getNbPierres() - 1);
    }

    public void perd()
    {
        this.setPerdant(true);
    }

    public void gagne()
    {
        this.setGagnant(true);
    }

}
