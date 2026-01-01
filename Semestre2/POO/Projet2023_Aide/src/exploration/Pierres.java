/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Pierres extends Case
{

    /**
     *
     * @param plateau
     * @param lig
     * @param col
     * @param quantiteMax
     */
    public Pierres(Plateau plateau, int lig, int col, int quantiteMax)
    {
        super(plateau, lig, col);
        /* ajout de code éventuel
        * Le nombre de pierres réel est tiré entre 1 et quantitéMax
        */
    }

    /**
     *
     * @param plateau
     * @param lig
     * @param col
     */
    public Pierres(Plateau plateau, int lig, int col)
    {
        this(plateau,lig,col,4); //4 pierres maximum par défaut
    }
    
    /**
     *
     * @param j
     */
    @Override
    public void arrive(Joueur j)
    {        
        /* à son arrivée, le joueur est placé dans la case et récupère le pierre qu'elle contient */
    }

    /**
     *
     * @param j
     * @param d
     */
    @Override
    public void propage(Joueur j, Direction d)
    {
        /* la pierre s'ajoute aux pierres de la case et est perdue — temporairement — pour le joueur */
    }
}
