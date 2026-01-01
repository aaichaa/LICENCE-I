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
     * Lance un jeu avec quatre catégories de cases : "Pierres", "Mines",…. Pour chaque catégorie,
     * le nombre représente le nombre d'éléments de la catégorie pour 100 cases du plateau.
     * Si le plateau comporte 200 cases, il y aura 6 cases contenant des pierres, 16 cases comportant des mines,…
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Categorie
                pierres = new Categorie(3, "Pierres"),
                mines = new Categorie(8, "Mine"),
                transferts = new Categorie(10, "Transfert"),
                obstacles = new Categorie(6, "Obstacle");
        Jeu jeu = new Jeu(10, 20, 4, pierres, mines, transferts, obstacles);
        jeu.joue();
    }
}
