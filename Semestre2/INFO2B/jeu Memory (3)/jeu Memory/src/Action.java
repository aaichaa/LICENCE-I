/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Millimouno
 */
public abstract class Action {
    private Joueur j; // joueur à l'origine de l'action
    private String descriptif; //nature de l'action
    private String deroulement;
    public abstract int execute();
    public Action(Joueur sc, String s) {
    this.j=sc;
    this.descriptif=s;
    this.deroulement="";
    }
    public Joueur getJoueurCourant() { return j; }
    public void setJoueur(Joueur j) { this.j = j; }
    public String getDescriptif() { return descriptif; }
    public void setDescriptif(String d) { this.descriptif = d; }

    public String getDeroulement() { return deroulement; }
    public void setDeroulement(String d) { this.deroulement = d; }
    public String toString()
    {
        return "Action effectuée par "+j.getPseudo()+ " : " +descriptif+"\n"+this.deroulement+"\n"; 
    }
}
