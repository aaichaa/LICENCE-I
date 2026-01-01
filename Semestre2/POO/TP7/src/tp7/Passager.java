/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp7;

/**
 *
 * @author BOBO
 */
public class Passager {
    private String nom;
    private String prenom;
    private String nomDossier;
    private Voiture voiture;
    private int numPlace;

    public Passager(String nom, String prenom, String nomDossier, Voiture voiture, int numPlace) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomDossier = nomDossier;
        this.voiture = voiture;
        this.numPlace = numPlace;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomDossier() {
        return nomDossier;
    }

    public void setNomDossier(String nomDossier) {
        this.nomDossier = nomDossier;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public int getNumPlace() {
        return numPlace;
    }

    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }
    
    
    
}
