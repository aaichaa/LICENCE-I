/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Bord extends Case
{

    private String getIndicationLig()
    {
        if(this.getLig() == 0)
            return "haut";
        if(this.getLig() > this.getPlateau().getNbLig())
            return "bas";
        return "ligne " + this.getLigchar();
    }

    private String getIndicationCol()
    {
        if(this.getCol() == 0)
            return "gauche";
        if(this.getCol() > this.getPlateau().getNbCol())
            return "droit";
        return "colonne " + this.getColchar();
    }

    @Override
    public String getSymbole()
    {
        return "░";
    }

    public Bord(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
        this.setVisible(true);
    }

    public boolean isGauche()
    {
        return this.getCol() == 0;
    }

    public boolean isDroit()
    {
        return this.getCol() == this.getPlateau().getNbCol() + 1;
    }

    public boolean isHaut()
    {
        return this.getLig() == 0;
    }

    public boolean isBas()
    {
        return this.getLig() == this.getPlateau().getNbLig() + 1;
    }
    
    @Override
    public String getNom()
    {
        return "Bord " + getIndicationLig() + " " + getIndicationCol();
    }

    @Override
    public String toString()
    {
        String droite=this.getSymbole();
        if(this.isHaut() && !this.isGauche() && !isDroit())
            droite = ""+this.getColchar();
        else if(this.isDroit() & !this.isHaut() && !this.isBas())
            droite = ""+this.getLigchar();
        String base = getSymbole();
        if(droite.equals("")) droite = base;
        return base+droite;
    }
    
    @Override
    public void place(Joueur j)
    {
        System.out.println(this.getNom()+" atteint ! Progression impossible.");
    }
    @Override
    public void propagePierre(Joueur j, Direction d)
    {
        System.out.println(this.getNom() + " atteint. Pierre perdue");
        j.decNbPierres();
    }

}
