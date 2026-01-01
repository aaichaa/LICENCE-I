/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp7;

/**
 *
 * @author BOBO
 */
public class Voiture extends Wagon{
    private int classe;
    private int nbPlaces;
    private Passager[] passagers;

    public Voiture(int classe, int nbPlaces, Passager[] passagers, int m, String id) {
        super(m, id);
        this.classe = classe;
        this.nbPlaces = nbPlaces;
        this.passagers = passagers;
    }
    
    

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Passager[] getPassagers() {
        return passagers;
    }

    public void setPassagers(Passager[] passagers) {
        this.passagers = passagers;
    }
    
    @Override
    public double getMasseTotale(){
        return this.getMasse();
    }
    
    public void reserver(){
        
    }
    
}
