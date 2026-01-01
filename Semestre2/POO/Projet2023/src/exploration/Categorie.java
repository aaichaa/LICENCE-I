/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Categorie
{
    private int proportion;
    public int getProportion()
    {
        return proportion;
    }

    private void setProportion(int proportion)
    {
        this.proportion = proportion;
    }

    private String nom;
    public String getNom()
    {
        return this.nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public Categorie(int proportion, String categorie)
    {
        this.setProportion(proportion);
        this.setNom(categorie);
    }

    public Case getCase(Plateau p,int lig,int col)
    {
        switch(this.getNom())
        {
            case "Bord":return new Bord(p,lig,col);
            case "Gouffre":return new Gouffre(p,lig,col);
            case "Obstacle":return new Obstacle(p,lig,col);
            case "Mine":return new Mine(p,lig,col);
            case "Rebond":return new Rebond(p,lig,col);
            case "Transfert":return new Passage(p,lig,col);
            case "Simple":return new Vide(p,lig,col);
            case "Pierres":return new Pierres(p,lig,col);
        }
        System.out.println("Échec pour la catégorie "+this);
        return null;
    }
}
