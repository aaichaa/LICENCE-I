
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sb241966
 */
public class LesJoueurs {
    private ArrayList<Joueur> lstJ;
   
    public Joueur getJoueur(int i){
        if (i>=0 && i<this.lstJ.size())
             return this.lstJ.get(i);
        else return null;
    }
    public int getIndiceJoueur(Joueur j){
        return lstJ.indexOf(j);
    }
    public int getNbJoueurs(){
        int s=0;
        for(int i=0;i<lstJ.size();i++){
            s=s+1;
        }
        return s;
    }

    public LesJoueurs(ArrayList<Joueur> lstJ) {
        this.lstJ = lstJ;
    }
    public LesJoueurs(){
        this.lstJ=new ArrayList<Joueur>();
     }
    public void ajouteJoueur(Joueur j){
        this.lstJ.add(j);
    }
    public Joueur rechJoueur(String p){
        for(int i=0;i<lstJ.size();i++){
            if(this.getJoueur(i).getPseudo().equals(p));
                return this.getJoueur(i);
        }
        return null;
    }
    public void supprimeJoueur(Joueur j){
        for(int i=0;i<lstJ.size();i++){
            if(this.getJoueur(i).getPseudo().equals(j.getPseudo()));
                this.lstJ.remove(j);
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i=0; i<lstJ.size(); i++)
            s+=i+"- "+getJoueur(i).toString();
       return s;
    }
    public LesJoueurs getGagnants()
    {
        int max=getJoueur(0).getScore();
        for(int i=1; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()>max)
                max=this.getJoueur(i).getScore();
        LesJoueurs lst=new LesJoueurs();
        for(int i=0; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()==max)
                lst.ajouteJoueur(getJoueur(i));
        return lst;
    }

}