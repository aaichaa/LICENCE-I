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
    private int resistance;
    
    public Obstacle(Plateau plateau, int lig, int col, int resistanceMax)
    {
        super(plateau, lig, col);
        this.setResistance((int)(Math.random()*resistanceMax+1));
    }

    public Obstacle(Plateau plateau, int lig, int col)
    {
        this(plateau,lig,col,4);
    }

    public int getResistance()
    {
        return this.resistance;
    }

    private void setResistance(int resistance)
    {
        this.resistance = resistance;
    }
    public void decResistance()
    {
        if(this.isActif()){this.setResistance(this.getResistance()-1);}
    }
    
    public boolean isActif(){return this.getResistance()>0;}
    
    @Override
    public void place(Joueur j)
    {
        if(this.isActif())
        {
            this.setVisible(true);
            System.out.println("Obstacle : accès à la case impossible !");
        }
        else super.place(j);
    }
    
    @Override
    public void propagePierre(Joueur j, Direction d)
    {
        if(this.isActif())
        {
            System.out.println("Pierre arrêtée par un obstacle de résistance "+this.getResistance()+". Elle est perdue");
            this.decResistance();
            j.decNbPierres();
        }
        else super.propagePierre(j, d);
    }

    @Override
    public String getSymbole()
    {
        return "░";
    }
    
}
