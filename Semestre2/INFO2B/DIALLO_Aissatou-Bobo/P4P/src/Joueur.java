/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author BOBO
 */
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Joueur {

    private String pseudo;
    private ImageIcon photo;
    private int niveau;
    private ArrayList<Joueur> adversaires;
    private ArrayList<Integer> resultats;

//constructeur par défaut
    public Joueur() {
        this.pseudo = "pseudo";
        this.niveau = 1;
        this.adversaires = new ArrayList<>();
        this.resultats = new ArrayList<>();
        this.photo = new ImageIcon(getClass().getResource("/Img/joueurDefaut.png"));
    }
    //costructeur avec pseudo

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        this.niveau = 1;
        this.adversaires = new ArrayList<>();
        this.resultats = new ArrayList<>();
        this.photo = new ImageIcon(getClass().getResource("/Img/joueurDefaut.png"));
    }
//Getters et Setters pour le pseudo

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
//Getters et Setters pour la photo

    public ImageIcon getPhoto() {
        return this.photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
//Getters et Setters pour le niveau

    public int getNiveau() {
        return this.niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    // Retourne le nombre d'adversaires rencontrés
    public int getNba() {
        return this.adversaires.size();
    }

    // Retourne un adversaire spécifique selon l'index donné
    public Joueur getAdversaire(int i) {
        if (i >= 0 && i < this.adversaires.size()) {
            return this.adversaires.get(i);
        } else {
            return null;
        }
    }

    public void ajoutPartieJoue(Joueur j, int res) // res vaut -1,0 ou 1
    {
        this.adversaires.add(j);
        this.resultats.add(res);
        if (res == 1) {
            if (this.niveau != 10) {
                this.niveau += 1; // le niveau du joueur augmente de 1 s'il gagne une partie,
            }                //et s'il n'a pas déjà le niveau 10 (expert)
        }
    }

    // Retourne la liste des résultats des matchs contre un adversaire donné
    public ArrayList<Integer> getResultatsAdv(String adv) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < this.adversaires.size(); i++) {
            if (this.adversaires.get(i).pseudo.equals(adv)) {
                lst.add(this.resultats.get(i));
            }
        }
        return lst;
    }
    // Retourne une liste des adversaires uniques rencontrés par le joueur

    public LesJoueurs getAdversaires() {
        LesJoueurs lj = new LesJoueurs();
        for (int i = 0; i < this.adversaires.size(); i++) {
            Joueur jo = this.adversaires.get(i);
            boolean trouve = false;
            for (int j = 0; j < lj.getNbJoueurs(); j++) {
                if (lj.getJoueur(i).pseudo.equals(jo.pseudo)) {
                    trouve = true;
                }
            }
            if (!trouve) {
                lj.ajouteJoueur(jo);
            }
        }
        return lj;
    }

    // Retourne le nombre de parties gagnées
    public int getNbpartiesGagnees() {
        int compt = 0;
        for (int i = 0; i < this.resultats.size(); i++) {
            if (this.resultats.get(i) == 1) {
                compt++;
            }
        }
        return compt;
    }
    // Retourne le nombre de parties perdues 

    public int getNbpartiesPerdues() {
        int compt = 0;
        for (int i = 0; i < this.resultats.size(); i++) {
            if (this.resultats.get(i) == -1) {
                compt++;
            }
        }
        return compt;
    }

    // Retourne le nombre de parties nulles
    public int getNbpartiesNul() {
        int compt = 0;
        for (int i = 0; i < this.resultats.size(); i++) {
            if (this.resultats.get(i) == 0) {
                compt++;
            }
        }
        return compt;
    }
    // Retourne une représentation textuelle du joueur

    @Override
    public String toString() {
        String s = "";
        s += "Pseudo :" + this.pseudo + "\n";
        s += "Niveau :" + this.niveau + "\n";
        return s;

    }

    /*@Override
    public String toString() {
	String s = "";
        s += "Pseudo: " + this.pseudo+"\n";
        s+= "Niveau: " + this.niveau + "\n";
       /* for(int i = 0; i < this.adversaires.size();i++){
            Joueur j = this.adversaires.get(i);
            int res = this.resultats.get(i);
            s += j.pseudo + " ";
            switch(res){
                case 1: s += " gagné"; break;
                case -1: s += " perdu"; break;
                case 0: s += " nul"; break;
            }
            s += "\n";
           
        }*/
    //  return s;
    //  }
}
