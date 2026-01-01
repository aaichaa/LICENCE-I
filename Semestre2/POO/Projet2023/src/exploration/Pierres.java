/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Pierres extends Case
{
    public static final int nb = 10;

    private int quantite;

    public int getQuantite()
    {
        return this.quantite;
    }

    private void setQuantite(int quantite)
    {
        this.quantite = quantite;
    }
 
    public Pierres(Plateau plateau, int lig, int col, int quantiteMax)
    {
        super(plateau, lig, col);
        this.setQuantite((int)(Math.random()*quantiteMax+1));
    }
    public Pierres(Plateau plateau, int lig, int col)
    {
        this(plateau,lig,col,4);
    }
    
    @Override
    public void place(Joueur j)
    {
        super.place(j);
        System.out.println(this.getQuantite()+" pierres récupérées");
        j.incNbPierres(this.getQuantite());
        System.out.println(j.getNom()+" en a désormais "+j.getNbPierres());
        this.setQuantite(0);
    } 
    @Override
    public void propagePierre(Joueur j, Direction d)
    {
        System.out.println("Tas de pierres. Pierre stockée.");
        j.decNbPierres();
        this.setQuantite(this.getQuantite()+1);
    }

    @Override
    public String getSymbole()
    {
        return "▒";
    }
}
