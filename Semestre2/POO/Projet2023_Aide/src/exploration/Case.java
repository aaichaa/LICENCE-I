/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public abstract class Case
{
         
    // permet de restituer un numéro de ligne ou de colonne sous forme d'une lettre à partir de A
    private static char getNumChar(int num){return (char)('A'+num-1);}
    
    private Plateau plateau;
    
    /**
     * Restitue la référence à l'instance de plateau qui contient la case.
     * C'est utile parce que le plateau est l'environnement commun à toutes les cases. 
     * Une case peut connaître et « communiquer » avec les autres cases via leur plateau commun
     * @return l'adresse de l'instance de plateau qui contient la case
     */
    public Plateau getPlateau()
    {
        return this.plateau;
    }

    private void setPlateau(Plateau plateau)
    {
        this.plateau = plateau;
    }

    private int lig;

    /**
     * Restitue le numéro de ligne de la case dans son plateau.
     * @return un entier entre 0 et this.plateau.getNbLig()
     */
    public int getLig()
    {
        return this.lig;
    }

    /**
     * Restitue le numéro de la ligne de la case sous forme d'une lettre 1->A, 2->B…
     * @return un char qui représente un numéro de ligne
     */
    public char getLigchar(){return Case.getNumChar(this.getLig());}

    private void setLig(int lig)
    {
        this.lig = lig;
    }

    private int col;

    /**
     * Restitue le numéro de colonne de la case
     * @return un nombre entier positif
     */
    public int getCol()
    {
        return this.col;
    }

    /**
     * Restitue le numéro de la colonne de la case sous forme d'une lettre 1->A, 2->B…
     * @return un char qui représente un numéro de colonne
     */
    public char getColchar(){return Case.getNumChar(this.getCol());}

    private void setCol(int col)
    {
        this.col = col;
    }

    /**
     * Ce qui doit être fait de général ou par défaut lorsque le joueur arrive dans la case
     * Par exemple, par défaut, l'emplacement du joueur devient la case courante — mais ça n'est pas vrai pour toutes les cases
     * @param j référence un joueur
     */
    public void arrive(Joueur j)
    {
        /* ajout de code */
    }

    /**
     * Ce qui doit être fait de général ou par défaut lorsque la pierre transite par la case
     * Par exemple, par défaut, la pierre est transmise à la case suivante dans la même direction — mais ce n'est pas vrai pour toutes les cases
     * @param j référence le joueur qui lance la pierre (pour lui ajouter ou enlever des pierres)
     * @param d la direction du déplacement
     */
    public void propage(Joueur j,Direction d)
    {
        /* ajout de code */
    }    
    
    /**
     * Restitue au format (X,Y) les coordonnées de la case (X et Y sont des caractères commençant à "A")
     * @return
     */
    public String getCoord(){return "("+this.getLigchar()+","+this.getColchar()+")";}
    
    /**
     * Restitue la case suivante de la case courante dans la direction référencée en paramètre
     * @param d
     * @return une case qui suit la case courante
     */
    public Case getSuivante(Direction d)
    {
        return null; /* à remplacer par une méthode abstraite ou par le calcul de la case suivante par défaut */
    }

    /**
     *
     * @param plateau
     * @param lig
     * @param col
     */
    public Case(Plateau plateau, int lig, int col)
    {
        this.setPlateau(plateau);
        this.setLig(lig);
        this.setCol(col);
        /* ajout de code éventuel */
    }
    
}
