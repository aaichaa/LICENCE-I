
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sb241966
 */
class Joueur {
    private String pseudo;
    private String famillePref;
    private ImageIcon photo;
    private LesPersonnages paquet; 
    public int getScore(){ 
        return this.paquet.getScore();
    }
    public Joueur(){
        this.famillePref="";
        this.pseudo="";
        this.photo= new ImageIcon(getClass().getResource("/Img/joueurDefaut.png"));
        this.paquet=new LesPersonnages();
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setFamillePref(String famillePref) {
        this.famillePref = famillePref;
    }

    public void setPaquet(LesPersonnages paquet) {
        this.paquet = paquet;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getFamillePref() {
        return famillePref;
    }

    public LesPersonnages getPaquet() {
        return paquet;
    }
    public Joueur(String n, String f){
        this.pseudo=n;
        this.famillePref=f;
        this.paquet = new LesPersonnages();
        this.photo = new ImageIcon(getClass().getResource("Img/joueurDefaut.png"));
    }

    public Joueur(String pseudo, String famillePref, ImageIcon photo, LesPersonnages paquet) {
        this.pseudo = pseudo;
        this.famillePref = famillePref;
        this.photo = photo;
        this.paquet = paquet;
    }
    public int getNbCartes(){
        return this.paquet.getTaille();
    }

    @Override
    public String toString() {
        return "Joueur "+this.pseudo+"\n famille préférée : "+this.famillePref+"\n en possession des personnages :\n"+this.paquet+"\n score: "+this.getScore()+"\n\n";
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
    

    public ImageIcon getPhoto() {
        return photo;
    }
    public void ajoutePersoPaquet(Personnage p){
        this.paquet.ajoutePerso(p);
    }
    public void initPaquetTest(){
        ajoutePersoPaquet(new Personnage("communs","assault-trooper",10));
        ajoutePersoPaquet(new Personnage("communs","commando",20));
        ajoutePersoPaquet(new Personnage("rares","absolute-zero",10));
    }
    
    
}
