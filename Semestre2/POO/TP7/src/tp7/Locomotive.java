/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp7;

/**
 *
 * @author BOBO
 */
public class Locomotive {
    private int masse;
    private String id;
    
    

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
    
    public Locomotive(int m,String id){
        this.masse = m;
        this.id = id;
    }
    
    
    
}
