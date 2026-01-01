/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialloaissatoubobo;

/**
 *
 * @author BOBO
 */
public class Personnage {
    private int inertie;
    private int energie;
    private Salle position;

    public int getInertie() {
        return inertie;
    }

    public void setInertie(int inertie) {
        this.inertie = inertie;
    }

    public int getEnergie() {
        return energie;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public Salle getPosition() {
        return position;
    }

    public void setPosition(Salle position) {
        this.position = position;
    }
    
    
     
    public int getForce() {
        return inertie * energie;
    }
    
}
