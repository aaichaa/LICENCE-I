/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp7;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BOBO
 */
public class Train {
    private String id;
    private ArrayList<Ligne> ligne;
    private Locomotive loco;
    private ArrayList<Wagon> wagons;
    private Date date;
    
    //a chaque fois quon doit creer une liste vide on doit pas lappeller dans le parametre du contructeur et on doit faire le 
    //new ArrayList dans le setter qui est private et apres on lapppelle dans le constructeur
    //Le setter ne doit pas avoir de parametres
    
    public Train(String id, Locomotive loco,Date date, ArrayList<Ligne> ligne){
        this.setId(id);
        this.setLoco(loco);
        this.setLigne(ligne);
        this.setDate(date);
        this.setWagons();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Ligne> getLigne() {
        return ligne;
    }

    public void setLigne(ArrayList<Ligne> ligne) {
        this.ligne = ligne;
    }

    public Locomotive getLoco() {
        return loco;
    }

    public void setLoco(Locomotive loco) {
        this.loco = loco;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    private void setWagons() {
        this.wagons = new ArrayList<>(); 
    }
    
    public void AjoutWagon(Wagon w){
        this.wagons.add(w);
    }
    
    public void retireWagon(Wagon w){
        this.wagons.remove(this.wagons.size()-1);
    }
    public double getMasseTotale(){
        int somme = 0;
        for(int i = 0; i<this.wagons.size();i++)
            somme += this.wagons.get(i).getMasseTotale();
        return somme;
    }
    
    
    public void MdifAjoutWagon(Wagon w){
        if((this.getMasseTotale() + w.getMasseTotale())<=this.getLoco().getMasse())
            this.wagons.add(w);
        else
            System.out.println("Erreur");
            
        }
    }
    
    
    
    
    

