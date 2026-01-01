package tp1;

public class Caisse {
    
    private double solde; // Attribut privé
    
    // Constructeur avec paramètre
    public Caisse(double soldeInitial){
        setSolde(soldeInitial); // Utilisation du setter privé
    }   
    
    // Constructeur par défaut (solde = 0)
    public Caisse(){
        this.solde = 0;  
    }

    // Getter pour récupérer le solde
    public double getSolde(){
        return solde;
    }

    // Setter privé pour modifier le solde UNIQUEMENT à l'initialisation
    private void setSolde(double soldeInitialSetter){
        if(soldeInitialSetter >= 0){ 
            this.solde = soldeInitialSetter;
        } else {
            System.out.println("Erreur : Solde négatif interdit.");
        }
    }
    
    // Méthode pour effectuer un retrait
    public void retrait(double montant){
        if(montant > 0 && montant <= solde){
            System.out.println("Solde avant retrait : " + solde);
            this.solde -= montant;
            System.out.println("Retrait réussi. Nouveau solde : " + solde);
        } else {
            System.out.println("Pas de retrait possible. Solde actuel : " + solde);
        }
    }

    // Méthode pour effectuer un dépôt
    public void depot(double montant){
        if(montant > 0){
            System.out.println("Solde avant dépôt : " + solde);
            this.solde += montant;
            System.out.println("Dépôt réussi. Nouveau solde : " + solde);
        } else {
            System.out.println("Dépôt impossible : le montant doit être positif.");
        }
    }
}
