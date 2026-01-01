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
public class Arrivee extends Bord
{    
    @Override
    public void place(Joueur j)
    {
        j.gagne();
    }

    @Override
    public String getSymbole()
    {
        return "▷";
    }

    public Arrivee(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
        this.setVisible(true);
    }    
}
