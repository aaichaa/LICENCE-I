
import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author BOBO
 */
public class LesJoueurs {

    private ArrayList<Joueur> lstj;

    public LesJoueurs() {
        this.lstj = new ArrayList<Joueur>();
    }

    public Joueur getJoueur(int i) {
        return lstj.get(i);
    }

    public int getIndiceJoueur(Joueur j) {
        return this.lstj.indexOf(j);
    }

    public int getNbJoueurs() {
        return this.lstj.size();
    }

    public void ajouteJoueur(Joueur j) {
        if (rechJoueur(j.getPseudo()) == null) {
            this.lstj.add(j);
        }
    }

    public Joueur rechJoueur(String p) {
        Joueur j = null;
        for (int i = 0; i < this.lstj.size(); i++) {
            if (this.lstj.get(i).getPseudo().equals(p)) {
                j = this.lstj.get(i);
                return j;
            } else {
                j = null;
            }

        }
        return j;

    }

    public void supprimeJoueur(Joueur j) {
        if (rechJoueur(j.getPseudo()) != null) {
            this.lstj.remove(getIndiceJoueur(j));
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < getNbJoueurs(); i++) {
            s += getJoueur(i).toString() + "\n";
        }
        return s;
    }

    public void creationJoueursTest(LesParties lp) {

        Joueur jm = new Joueur("Mario"); // expert
        jm.setPhoto(new ImageIcon(getClass().getResource("/Img/mario.png")));

        Joueur jma = new Joueur("Marcus"); // débutant
        jma.setPhoto(new ImageIcon(getClass().getResource("/Img/marcus.jpg")));

        Joueur jp = new Joueur("Pikatchu"); //intermédiaire
        jp.setPhoto(new ImageIcon(getClass().getResource("/Img/pikatchu.png")));
        Joueur jh = new Joueur("Halo");//intermediaire
        jh.setPhoto(new ImageIcon(getClass().getResource("/Img/halo.jpg")));

        Joueur js = new Joueur("Sonic");
        js.setPhoto(new ImageIcon(getClass().getResource("/Img/sonic.png")));
        Partie p;
        jm.ajoutPartieJoue(jma, 1);
        jma.ajoutPartieJoue(jm, 0);
        p = new Partie(jm, jma, 10, 1);
        lp.ajoutePartie(p);
        jm.ajoutPartieJoue(jma, 1);
        jma.ajoutPartieJoue(jm, 0);
        p = new Partie(jm, jma, 12, 1);
        lp.ajoutePartie(p);
        jm.ajoutPartieJoue(jma, 1);
        jma.ajoutPartieJoue(jm, 0);
        jm.ajoutPartieJoue(jma, 1);
        jma.ajoutPartieJoue(jm, 0);

        jm.ajoutPartieJoue(jp, 1);
        jp.ajoutPartieJoue(jm, 0);
        p = new Partie(jm, jp, 14, 1);
        lp.ajoutePartie(p);

        jm.ajoutPartieJoue(jp, 1);
        jp.ajoutPartieJoue(jm, 0);
        p = new Partie(jm, jp, 8, 1);
        lp.ajoutePartie(p);

        jma.ajoutPartieJoue(jp, 1);
        jp.ajoutPartieJoue(jma, 0);
        p = new Partie(jma, jp, 18, 1);
        lp.ajoutePartie(p);

        jm.ajoutPartieJoue(jh, 1);
        jh.ajoutPartieJoue(jm, 0);
        p = new Partie(jm, jh, 12, 1);
        lp.ajoutePartie(p);

        jm.ajoutPartieJoue(js, 1);
        js.ajoutPartieJoue(jm, 0);
        p = new Partie(jm, js, 8, 1);
        lp.ajoutePartie(p);

        jma.ajoutPartieJoue(jp, 1);
        jp.ajoutPartieJoue(jma, 0);
        p = new Partie(jma, jp, 8, 1);
        lp.ajoutePartie(p);
        jp.ajoutPartieJoue(jh, 1);
        jh.ajoutPartieJoue(jp, 0);
        p = new Partie(jp, jh, 8, 1);
        lp.ajoutePartie(p);
        jp.ajoutPartieJoue(jh, 1);
        jh.ajoutPartieJoue(jp, 0);
        p = new Partie(jp, jh, 8, 1);
        lp.ajoutePartie(p);
        jp.ajoutPartieJoue(jh, 1);
        jh.ajoutPartieJoue(jp, 0);
        p = new Partie(jp, jh, 8, 1);
        lp.ajoutePartie(p);

        this.ajouteJoueur(jm);
        this.ajouteJoueur(js);
        this.ajouteJoueur(jma);
        this.ajouteJoueur(jp);
        this.ajouteJoueur(jh);
        // this.ajouteJoueur(js);

    }
}
