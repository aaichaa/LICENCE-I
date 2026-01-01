/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Passage extends Case
{
    /* Le passage renvoie à une autre case du plateau*/
    public Passage(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
        /* ajout de code éventuel
         * il faut définir une case de destination aléatoire
         */
    }

    @Override
    public void arrive(Joueur j)
    {        
        /* Réexpédition du joueur à la case de destination quand il arrive */
    }

    @Override
    public void propage(Joueur j, Direction d)
    {
        /* la pierre continue son chemin à la case de destination */
    }

}
