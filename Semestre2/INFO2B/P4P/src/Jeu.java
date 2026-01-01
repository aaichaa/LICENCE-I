/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author BOBO
 */
public class Jeu {

    private Plateau platJeu;

    public Jeu() {
        this.platJeu = new Plateau();
        this.platJeu.initPlateauJeu();
        this.platJeu.afficheValPlateau();
    }

    public Plateau getPlateau() {
        return this.platJeu;
    }

    public boolean gagne(int valj) {
        int compt;
        boolean gain = false;
        // Vérification des lignes
        int i = 0;
        while (!gain && i < 4) {
            compt = 0;
            for (int j = 0; j < 4; j++) {
                int sommet = this.platJeu.getCase(i, j).getSommetCase();
                if (sommet == valj) {
                    compt++;
                }
            }
            if (compt == 4) {
                gain = true;
            } else {
                i++;
            }
        }
        // Vérification des colonnes
        int col = 0;
        while (!gain && col < 4) {
            compt = 0;
            for (int lig = 0; lig < 4; lig++) {
                int sommet = this.platJeu.getCase(lig, col).getSommetCase();
                if (sommet == valj) {
                    compt++;
                }
            }
            if (compt == 4) {
                gain = true;
            } else {
                col++;
            }
        }
        // Diagonale principale
        if (!gain) {
            compt = 0;
            for (int x = 0; x < 4; x++) {
                int sommet = this.platJeu.getCase(x, x).getSommetCase();
                if (sommet == valj) {
                    compt++;
                }
            }
            if (compt == 4) {
                gain = true;
            }
        }

        // Diagonale secondaire
        if (!gain) {
            compt = 0;
            for (int y = 0; y < 4; y++) {
                int sommet = this.platJeu.getCase(y, 3 - y).getSommetCase();
                if (sommet == valj) {
                    compt++;
                }
            }
            if (compt == 4) {
                gain = true;
            }
        }
        return gain;
    }

    
    //verification que deux cases sont adjacentes
    public boolean adjacent(int xd, int yd, int xa, int ya) {
        return ((xa == xd - 1 && ya == yd)
                || (xa == xd + 1 && ya == yd)
                || (xa == xd && ya == yd - 1)
                || (xa == xd && ya == yd + 1));
    }

    public int jouePion(int pxd, int pyd, int xd, int yd, int xa, int ya, int valp) {
        int code = 0;

        // 1. Interdire le retour sur la case précédente (celle juste avant)
        if (xa == pxd && ya == pyd) {
            System.out.println("Mouvement interdit : retour arrière !");
            code = 1;
        } // 2. Interdire les mouvements non adjacents
        else if (!adjacent(xd, yd, xa, ya)) {
            System.out.println("Interdit : case non adjacente !");
            code = 2;
        } // 3. Mouvement autorisé : on dépose le pion
        else {
            this.platJeu.deposePionCase(valp, xa, ya);
        }

        return code;
    }

}
