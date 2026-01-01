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
    public static final int nb = 6;

    private int nLig;

    public int getnLig()
    {
        return this.nLig;
    }

    private void setnLig(int nLig)
    {
        this.nLig = nLig;
    }

    private int nCol;

    public int getnCol()
    {
        return this.nCol;
    }

    private void setnCol(int nCol)
    {
        this.nCol = nCol;
    }
    

    public Passage(Plateau plateau, int lig, int col,int dLig, int dCol)
    {
        super(plateau, lig, col);
        this.setnLig(dLig);
        this.setnCol(dCol);
    }
    public Passage(Plateau plateau, int lig, int col)
    {
        this(plateau, lig, col,(int)(Math.random()*plateau.getNbLig()+1),(int)(Math.random()*plateau.getNbCol()+1));
    }    

    @Override
    public Case getSuivante(Direction d)
    {
        return this.getPlateau().get(this.getnLig(), this.getnCol());
    }
    
    @Override
    public void place(Joueur j)
    {
        this.setVisible(true);
        Case suivante = this.getSuivante(j.getDirectionCourante());
        if(this == suivante)
            j.perd("Tourbillon. "+j.getNom()+" ne peut plus sortir !");
        else
            suivante.place(j);
    } 

    @Override
    public String getSymbole()
    {
        return "↻";
    }
    @Override
    public String toString()
    {
        if(isVisible())return ""+getSuivante(null).getLigchar()+getSuivante(null).getColchar();
        else return "  ";
    }

}
