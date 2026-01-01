/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Mine extends Case
{

    public Mine(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
        /* ajout de code éventuel */
    }

    @Override
    public void arrive(Joueur j)
    {        
        /* La mine explose et le joueur perd */
    }

    @Override
    public void propage(Joueur j, Direction d)
    {
        /* La mine explose, la case devient visible, et le joueur perd la pierre */
    }

}
