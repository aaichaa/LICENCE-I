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
public class Vide extends Case
{
    
    public Vide(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
    }

    @Override
    public String getSymbole()
    {
        return ".";
    }
    
}
