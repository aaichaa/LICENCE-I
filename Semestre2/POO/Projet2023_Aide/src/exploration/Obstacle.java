/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Obstacle extends Case
{
    
    public Obstacle(Plateau plateau, int lig, int col)
    {
        super(plateau,lig,col);
        /* ajout de code éventuel */
    }

    @Override
    public void arrive(Joueur j)
    {        
        /* Le joueur ne peut pas arriver dans cette case */
    }

    @Override
    public void propage(Joueur j, Direction d)
    {
        /* La pierre lancée est perdue */
    }
    
}
