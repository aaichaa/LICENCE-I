/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exploration;

/**
 *
 * @author jo
 */
public class Simple extends Case
{
    
    /**
     *
     * @param plateau
     * @param lig
     * @param col
     */
    public Simple(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
        /* ajout de code éventuel */
    }
    /**
     *
     * @param j
     */
    @Override
    public void arrive(Joueur j)
    {        
        /* À son arrivée, le joueur est positionné dans cette case */
    }

    /**
     *
     * @param j
     * @param d
     */
    @Override
    public void propage(Joueur j, Direction d)
    {
        /* la pierre est propagée à la case voisine dans la direction d */
    }
    
}
