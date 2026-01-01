/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp7;

/**
 *
 * @author BOBO
 */
public class WagonMarch extends Wagon {
    private int masseMarch;
    private int masseMax;
    private String descriptif;
    
    public WagonMarch(int mMarch, int mMax,String d, String id, int m){
        super(m, id);
        this.setDescriptif(d);
        this.setMasseMarch(mMarch);
        this.setMasseMax(mMax);
  
    }

    public int getMasseMarch() {
        return masseMarch;
    }

    public void setMasseMarch(int masseMarch) {
        this.masseMarch = masseMarch;
    }

    public int getMasseMax() {
        return masseMax;
    }

    public void setMasseMax(int masseMax) {
        this.masseMax = masseMax;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
    
    @Override
    public double getMasseTotale(){
       return this.getMasse()+this.getMasseMarch();
    }
    
    
    
}
