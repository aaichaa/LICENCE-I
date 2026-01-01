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

    public static boolean VISIBLE = false;
    private Jeu jeu;
    private Case[][] grille;
    private int nbCol;
    private int nbLig;

    public Jeu getJeu()
    {
        return this.jeu;
    }

    public void setJeu(Jeu jeu)
    {
        this.jeu = jeu;
    }

    public Case get(int lig, int col)
    {
        if(lig < 0 || lig > this.getNbLig() + 1 || col < 0 || col > this.getNbCol() + 1)
            return null;
        else
            return this.grille[lig][col];
    }

    public void set(int lig, int col, Case c)
    {
        this.grille[lig][col] = c;
    }

    public int getNbCol()
    {
        return this.nbCol;
    }

    private void setNbCol(int nbCol)
    {
        this.nbCol = nbCol;
    }

    public int getNbLig()
    {
        return this.nbLig;
    }

    private void setNbLig(int nbLig)
    {
        this.nbLig = nbLig;
    }

    private void initBordure()
    {
        int nbCol = this.getNbCol();
        int nbLig = this.getNbLig();
        this.grille = new Case[nbLig + 2][nbCol + 2];
        int colMin = 0;
        int colMax = nbCol + 1;
        for(int lig = 1; lig <= this.getNbLig(); lig++)
        {
            this.set(lig, colMin, new Bord(this, lig, colMin));
            this.set(lig, colMax, new Bord(this, lig, colMax));
        }
        int ligMin = 0, ligMax = nbLig + 1;
        for(int col = colMin; col <= colMax; col++)
        {
            this.set(ligMin, col, new Bord(this, ligMin, col));
            this.set(ligMax, col, new Bord(this, ligMax, col));

        }
        this.set(1, 0, new Depart(this, 1, 0));
        this.set(nbLig, nbCol+1, new Arrivee(this, nbLig, nbCol+1));
        this.set(nbLig, nbCol, new exploration.Vide(this, nbLig, nbCol));
    }

    private void initContenu(Categorie[] liste)
    {
        double ratio = (double) this.getNbLig() * this.getNbCol() / 100;
        for(Categorie courante : liste)
        {
            int nbAPlacer = (int) (courante.getProportion() * ratio);

            for(int cpte = 1; cpte <= nbAPlacer; cpte++)
            {
                boolean vide;
                do
                {
                    int col = (int) (Math.random() * this.getNbCol() + 1);
                    int lig = (int) (Math.random() * this.getNbLig() + 1);
                    vide = this.get(lig, col) == null;
                    if(vide)
                        this.set(lig, col, courante.getCase(this, lig, col));
                } while(!vide);
            }
        }
        // remplissage des cases vides avec des cases simples
        for(int lig = 1; lig <= this.getNbLig(); lig++)
            for(int col = 1; col <= this.getNbCol(); col++)
                if(this.get(lig, col) == null)
                    this.set(lig, col, new Vide(this, lig, col));
    }

    private void initGrille(Categorie[] liste)
    {
        initBordure();
        initContenu(liste);
    }

    public boolean isVisible()
    {
        return true;
    }

    @Override
    public String toString()
    {
        String ligne;
        String res = "";
        for(int lig = 0; lig < this.getNbLig() + 2; lig++)
        {
            ligne = "";
            for(int col = 0; col < this.getNbCol() + 2; col++)
                ligne = ligne + this.get(lig, col);
            res = res + ligne + "\n";
        }
        return res;
    }

    public Plateau(int nbCol, int nbLig, Jeu jeu, Categorie... liste)
    {
        this.setNbCol(nbCol);
        this.setNbLig(nbLig);
        this.setJeu(jeu);
        this.initGrille(liste);
    }
}
