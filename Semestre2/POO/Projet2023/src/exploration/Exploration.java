package exploration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author jo
 */
public class Exploration
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Categorie
                gouffres = new Categorie(4, "Gouffre"),
                pierres = new Categorie(3, "Pierres"),
                mines = new Categorie(8, "Mine"),
                transferts = new Categorie(10, "Transfert"),
                obstacles = new Categorie(6, "Obstacle"),
                rebonds = new Categorie(6, "Rebond");
        Jeu p = new Jeu(10, 20, 4, pierres, mines, transferts, obstacles,rebonds,gouffres);
    }
}
