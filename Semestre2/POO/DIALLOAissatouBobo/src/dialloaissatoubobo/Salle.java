/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialloaissatoubobo;

/**
 *
 * @author BOBO
 */
public class Salle {
    private int lig;
    private int col;
    private Plateau plateau;
    private Bidon bidon;
    private Personnage personnage;

    public int getLig() {
        return lig;
    }

    public int getCol() {
        return col;
    }

    public Bidon getBidon() {
        return bidon;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setLig(int lig) {
        this.lig = lig;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public void setBidon(Bidon bidon) {
        this.bidon = bidon;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }
    
    
    
    
    
    
}
