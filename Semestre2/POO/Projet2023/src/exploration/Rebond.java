/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Rebond extends Case
{
    public static final int nb = 6;


    private Direction direction;
    private Direction getDirection()
    {
        return this.direction;
    }
    private void setDirection(Direction direction)
    {
        this.direction = direction;
    }   
    public int getdLig(){return this.getDirection().getdLig();}
    public int getdCol(){return this.getDirection().getdCol();}
    
    public Rebond(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
        this.setDirection(Direction.getDirectionAlea());
    }
    @Override
    public void place(Joueur j)
    {
        this.setVisible(true);
        this.getSuivante(this.getDirection()).place(j);
    }

    @Override
    public Case getSuivante(Direction d)
    {
        return super.getSuivante(this.getDirection());
    }
    
    @Override
    public void propagePierre(Joueur j, Direction d)
    {
        super.propagePierre(j, this.getDirection());
    }

    @Override
    public String getSymbole()
    {
        return this.getDirection().toString();
    }

}
