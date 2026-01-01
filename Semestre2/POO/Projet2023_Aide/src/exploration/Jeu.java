/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Jeu
{

    private Joueur joueur;

    /**
     *
     * @return
     */
    public Joueur getJoueur()
    {
        return this.joueur;
    }

    /**
     *
     * @param joueur
     */
    public void setJoueur(Joueur joueur)
    {
        this.joueur = joueur;
    }

    private Plateau grille;

    /**
     *
     * @return
     */
    public Plateau getGrille()
    {
        return grille;
    }

    /**
     *
     * @param grille
     */
    public void setGrille(Plateau grille)
    {
        this.grille = grille;
    }

    /**
     *
     * @return
     */
    public Plateau getPlateau()
    {
        return grille;
    }

    /**
     *
     * @param plateau
     */
    public void setPlateau(Plateau plateau)
    {
        this.grille = plateau;
    }  
    
    /**
     * Restitue vrai si le jeu est terminé, c'est-à-dire si le joueur a gagné ou perdu
     * @return un booléen
     */
    public boolean isFini(){return this.getJoueur().isGagnant()||this.getJoueur().isPerdant();}

    /**
     * À chaque tour, on demande au joueur s'il veut avancer ou lancer une pierre.
     * Cela se termine quand le joueur gagne ou perd
     */
    public void joue()
    {
        /* ajout de code */
    }
    
    /**
     *
     * @param nbLig
     * @param nbCol
     * @param nbPierres nombre de pierres du joueur en pourcentage du nombre de cases du plateau
     * @param liste liste des catégories de cases - qui inclut le pourcentage voulu de cette catégorie
     */
    public Jeu(int nbLig, int nbCol, int nbPierres,Categorie... liste)
    {
        this.setPlateau(new Plateau(nbCol,nbLig,this,liste));
        /*
         * On crée un joueur avec :
         * - un nom demandé à l'utilisateur,
         * - une case de départ à la ligne 1 et la colonne 0 (case du bord haut droit)
         * - un nombre de pierres initial calculé par rapport au nombre de pierres en pourcentage et au nombre de cases du plateau
         */
        this.setJoueur(new Joueur(Lire.S("Nom du joueur"),this.getPlateau().get(1, 0),nbPierres*nbCol*nbLig/100));
    }

}
