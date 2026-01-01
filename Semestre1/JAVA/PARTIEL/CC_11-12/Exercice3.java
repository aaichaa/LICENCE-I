public class Exercice3
{ public static void main (String [] args)
{
    int ordi;
    char choixjoueur = 0, choixordi = 0;
    do{
        System.out.println("Entrer votre choix:");
        choixjoueur = Lire.c();
        ordi = (int)(1 + 3 * Math.random()); 
      
        if(ordi == 1){
         choixordi = 'P';
        }else if(ordi == 2){
         choixordi = 'C';
        }else if(ordi == 3){
        choixordi = 'A';}
      
    // Comparer les choix et déterminer le gagnant ou s'il y a égalité
    if (choixjoueur == choixordi) {
        System.out.println("egalite, recommencez !");
    } else if ((choixjoueur == 'P' && choixordi == 'C') ||
               (choixjoueur == 'C' && choixordi == 'A') ||
               (choixjoueur == 'A' && choixordi == 'P')) {
        System.out.println("Le joueur a gagne ! L ordi avait prit " + choixordi);
        break; // Sortir de la boucle, le joueur a gagné
    } else {
        System.out.println("L'ordinateur a gagne !");
        break; // Sortir de la boucle, l'ordinateur a gagné
    }

} while (choixjoueur == choixordi); // La boucle continue tant qu'il y a égalité
}
}
