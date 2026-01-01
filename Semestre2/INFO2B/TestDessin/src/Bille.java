
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author BOBO
 */
public class Bille {
    private int posX;
    private int posY;
    private int rayon;
    private Color couleur;
    
    public Bille(){
        this.posX = 50;
        this.posY = 50;
        this.rayon = 20;
        
    }
    public Bille(int px, int py,int r){
         this.posX = px;
        this.posY = py;
        this.rayon = r;
        this.couleur = Color.red;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    public void deplaceBille(int dx, int dy){
        this.posX += dx;
        this.posY += dy;
        
    }
    public void dessineBille(JPanel pan){
        Graphics g = pan.getGraphics();
        g.setColor(this.couleur);
        g.fillOval(posX-rayon, posY-rayon, 2*rayon, 2*rayon);
        
    }
    
}
