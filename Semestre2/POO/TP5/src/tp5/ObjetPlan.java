/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5;

/**
 *
 * @author BOBO
 */
public abstract class ObjetPlan extends ObjetGeom{
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    public ObjetPlan(String nom)
    {
        super(nom);
    }
    public abstract double getPerimetre();
    public abstract double getAire();

}
    

