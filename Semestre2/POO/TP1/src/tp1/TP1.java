
package tp1;


public class TP1 {

   
    public static void main(String[] args) {
        
        LesDes De = new LesDes(3);
        LesDes des = new LesDes(6);
        System.out.println("resultat du lancé");
        System.out.println(De.getResultat());
        System.out.println(des.getResultat());
        
        // Création d'une caisse avec 100€ de solde
         Caisse caisse1 = new Caisse(100);
        System.out.println("Solde initial : " + caisse1.getSolde() + "€");

        // Dépôt de 50€
        caisse1.depot(50);

        // Retrait de 30€
        caisse1.retrait(30);

        // Tentative de retrait de 200€ (doit échouer)
        caisse1.retrait(200);

        // Tentative de modifier `solde` directement (impossible)
        // c.solde = -10; // Erreur : solde est private
        

        // Affichage du solde final
        System.out.println("Solde final : " + caisse1.getSolde() + "€");
       
        
        
       
       // caisse1.depot(10.2);
       // caisse1.solde = -10;
        //caisse1.retrait(22.1);
        //caisse1.setSolde(2222);
        //System.out.println(caisse1.getSolde());
        //caisse1.retrait(22.1);
        
        
        
    }
    
}
