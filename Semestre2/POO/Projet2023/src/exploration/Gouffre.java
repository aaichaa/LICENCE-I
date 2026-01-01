/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Gouffre extends Case
{
    public Gouffre(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
    }
    
    @Override
    public void place(Joueur j)
    {
        super.place(j);
        j.perd("Chute dans un gouffre");
    }
    
    @Override
    public Case getSuivante(Direction d){return this;}
    
    @Override
    public void propagePierre(Joueur j, Direction d)
    {
        System.out.println("Pierre disparue dans un gouffre.");
        j.decNbPierres();
    }

    @Override
    public String getSymbole()
    {
        return "█";
    }
}
