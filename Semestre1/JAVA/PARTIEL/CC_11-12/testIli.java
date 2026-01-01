public class testIli {

        public static void main(String [] arg){
            int i, j ;
           
             /*for( i = 1; i <= 5; i++ ){
                for( j = 1; j <= 6; j++){
    
                 System.out.print((((i+j) -2) % 6)+1);  
                 }
                 System.out.println();
    
                }*/
              /*   i = 1;

        while (i <= 5) {  // Boucle pour les lignes
            j = 1;  // Réinitialiser la colonne à 1 pour chaque nouvelle ligne
            while (j <= 6) {  // Boucle pour les colonnes
                // Même logique avec l'ajustement +1 pour avoir des valeurs de 1 à 6
                System.out.print(((i + j - 2) % 6) + 1 + " ");
                j = j + 1;  // Incrémenter la colonne
            }
            System.out.println();  // Nouvelle ligne après chaque ligne d'affichage
            i = i + 1;  // Incrémenter la ligne

        } */

      /*  int n = 100, S = 0, P;
        for(i = 2; i <= n; i++)
        {
          P = 5 * i;
          if(P % 5 == 0)
            S = S + P;
        }
        System.out.println("S= "+ S);*/

       /* int n = 100;  // Supposons que n soit 100
        int k = 1;    // Initialisation de k à 1 (ou n'importe quel point de départ valide)
        int s = 0;    // Variable pour accumuler la somme

        for ( i = 2; i <= n; i++) {
            if (i == 5 * k) {  // Vérifie si i est égal à un multiple de 5
                s = s + i;     // Ajoute le multiple de 5 à la somme
                k++;           // Incrémente k pour tester le prochain multiple de 5
            }
        }

        System.out.println("La somme des multiples de 5 entre 2 et " + n + " est : " + s);
         */

            int s = 0, n = 100; 
            i = 2;
         do{
            if( i%5 ==0)
             s = s + i;
             i ++;

         }while(i<=n );
        
}
}
