public class Exercice1 {

    public static void main(String[]args){

        int nombreAdultes = 0;
        int nombreEnfants = 0;
        
        // Utilisation de la boucle for pour lire les âges de 20 personnes
        for (int i = 0; i < 5; i++) {
            System.out.print("Entrez l'âge de la personne " + (i + 1) + " : ");
            int age = Lire.i();
            
            // Classification en adulte ou enfant
            if (age >= 18) {
                nombreAdultes++;
            } else {
                nombreEnfants++;
            }
        }
          // Affichage des résultats
          System.out.println("Nombre d'adultes : " + nombreAdultes);
          System.out.println("Nombre d'enfants : " + nombreEnfants);
    }
}