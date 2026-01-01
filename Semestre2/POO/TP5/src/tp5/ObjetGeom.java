/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5;

/**
 *
 * @author BOBO
 */
public class ObjetGeom {
    private String nom;
    
    public String getNom(){
        return this.nom;
    }
    public void setNom(String n){
        this.nom = n;
    }
    public ObjetGeom(String nom){
        this.nom = nom;
    }
    
    public String toString(){
        return this.nom + " " + this.getClass().getSimpleName();
    }
    
    
}
