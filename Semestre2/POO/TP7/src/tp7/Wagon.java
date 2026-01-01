/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp7;

/**
 *
 * @author BOBO
 */
public abstract class Wagon {
    private int masse; //pour que ca ne soit pas modiffiable soit on met final ou on mets le get en private et on lappelle dans le constructeur
    private String id;
    
    public Wagon(int m, String id){
        this.setId(id);
        this.setMasse(m);
    }

    public int getMasse() {
        return masse;
    }

    private void setMasse(int masse) {
        this.masse = masse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public abstract double getMasseTotale();
    
    
    
    
    
    
}
