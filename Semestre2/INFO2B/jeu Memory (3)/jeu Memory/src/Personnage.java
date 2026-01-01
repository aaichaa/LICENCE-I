/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sb241966
 */
import java.awt.* ;
import javax.swing.* ;
public class Personnage {
    private String famille;
    private String nom;
    private int valeur;

    public Image getPhoto() {
        return photo;
    }
    private Image photo;
    public Personnage() {
        this.famille = "anonyme";
        this.nom = "anonyme";
        this.valeur= 0;
        this.photo = new ImageIcon(getClass().getResource("Img/anonyme.png")).getImage();
    }
    public Personnage(String f, String n,int v ) {
        this.famille = f;
        this.nom = n;
        this.valeur= v;
        this.photo = new ImageIcon(getClass().getResource("Img/"+n+".jpg")).getImage();
    }
    public String getFamille(){
        return this.famille;
    }
    public String getNom(){
        return this.nom;
    }
    public int getValeur(){
        return this.valeur;
    }
    public void setImgBouton(JButton jb) {
        Image img = photo.getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        jb.setIcon(new ImageIcon(img));
    }
    
    public String toString() {
        return  this.nom+ " de la famille " + this.famille + ", valeur " + this.valeur+"\n";
    }
    
    
}
