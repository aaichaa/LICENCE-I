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
public class Depart extends Case
{
    @Override
    public Case getSuivante(Direction d)
    {
        Case suivante = super.getSuivante(d);
        if(suivante == null)suivante = this;
        return suivante;
    }
    
    
    @Override
    public void place(Joueur j)
    {
        super.place(j);
        System.out.println("Retour à la case départ ; qu'est-ce que tu fous ?");
    }

    @Override
    public void propagePierre(Joueur j,Direction d)
    {
        if(this.getSuivante(d)!=this)super.propagePierre(j, d);
        else
            System.out.println("La pierre est revenue au point de départ : elle est perdue");
    }
    
    @Override
    public String getSymbole()
    {
        return "▶";
    }

    public Depart(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
        this.setVisible(true);
    }
    
}
