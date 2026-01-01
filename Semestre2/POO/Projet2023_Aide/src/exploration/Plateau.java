/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Plateau
{

    private Case[][] grille;
    private int nbCol;
    private int nbLig;

    /**
     * Restitue la case du plateau de numéro de ligne lig et de numéro de colonne col
     * @param lig Le numéro de la ligne entre 0 (case du bord haut) et this.getNbLig()+1 (case du bord bas)
     * @param col Le numéro de la colonne entre 0 (case du bord gauche) et this.getNbLig()+1 (case du bord droite)
     * @return La référence à une case ou null
     */
    public Case get(int lig, int col)
    {
        // restitue null quand les numéros de ligne ou de colonne sortent du plateau
        if(lig < 0 || lig > this.getNbLig() + 1 || col < 0 || col > this.getNbCol() + 1)
            return null;
        else
            return this.grille[lig][col];
    }

    /**
     * Conceptuellement, place une case dans la grille du plateau (En fait, c'est l'adresse de la case qui est placée)
     * @param lig un numéro de ligne
     * @param col un numéro de colonne
     * @param c une référence à une case à placer
     */
    public void set(int lig, int col, Case c)
    {
        this.grille[lig][col] = c;
    }

    /**
     * Restitue le nombre de colonnes à l'intérieur du plateau.
     * Il faut y ajouter les bords gauche et droit pour obtenir la taille horizontale de la grille
     * @return un entier supérieur ou égal à 1.
     */
    public int getNbCol()
    {
        return this.nbCol;
    }

    private void setNbCol(int nbCol)
    {
        this.nbCol = nbCol;
    }

    /**
     * Restitue le nombre de lignes à l'intérieur du plateau.
     * Il faut y ajouter les bords haut et bas pour obtenir la taille verticale de la grille
     * @return un entier supérieur ou égal à 1.
     */
    public int getNbLig()
    {
        return this.nbLig;
    }

    private void setNbLig(int nbLig)
    {
        this.nbLig = nbLig;
    }


    private void initContenu(Categorie[] liste)
    {
        // Le ratio est le nombre de cases du plateau (nbLig*nbCol) divisé par 100
        double ratio = (double) this.getNbLig() * this.getNbCol() / 100;
        for(Categorie courante : liste) // Pour chaque catégorie de la liste des catégories
        {
            /* Le nombre de cases de la catégorie à placer effectivement dans le plateau est calculé (règle de trois) à partir
            *  du Categorie de cases à placer divisé par 100 et multiplié par le nombre de cases du plateau
            */
            int nbAPlacer = (int) (courante.getPourcentage() * ratio);

            for(int cpte = 1; cpte <= nbAPlacer; cpte++)
            {
                boolean vide;
                do
                {
                    int col = (int) (Math.random() * this.getNbCol() + 1);
                    int lig = (int) (Math.random() * this.getNbLig() + 1);
                    vide = this.get(lig, col) == null; // rien n'est encore placé là
                    if(vide)
                        this.set(lig, col, courante.getCase(this, lig, col)); // la case est placée
                } while(!vide);
            }
        }
        // remplissage des cases vides avec des cases simples (qui ont un comportement par défaut pour les pierres et le joueur)
        for(int lig = 1; lig <= this.getNbLig(); lig++)
            for(int col = 1; col <= this.getNbCol(); col++)
                if(this.get(lig, col) == null)
                    this.set(lig, col, new Simple(this, lig, col));
    }


    public Plateau(int nbCol, int nbLig, Jeu jeu, Categorie... liste)
    {
        this.setNbCol(nbCol);
        this.setNbLig(nbLig);
        /* à compléter */
    }
}
