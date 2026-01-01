public class Exercice1 {
    public static void main(String[] args) {
        int tab[];
        tab = new int[10];
        for (int i = 0; i <= 9; i++) { // 1 creation dun nombre aleatoire et les stocker dans le tableau suivant
                                       // lindice i
            tab[i] = (int) (1 + 10 * Math.random());
        }

        for (int i = 0; i <= 9; i++) { // 2 Affiche le tableau
            System.out.print(tab[i] + " ");
        }
        System.out.println(); // pour revenir a la ligne

        /*
         * for(int i = 9; i> 0; i--){ //3 Decaler vers la droite et remettre le dernier
         * a lindice 0
         * int temp = tab[i-1];
         * tab[i-1]=tab[i];
         * tab[i]=temp;
         * }System.out.println();
         * for(int i = 0; i<= 9; i++){
         * System.out.print(tab[i] + " ");
         * }
         * 
         * for(int j = 0; j <= 9; j++){ //4 Affichage des permutations circulaires
         * for(int i = 9; i> 0; i--){ // en decrementant on prend le dernier et on
         * lechange de la droite vers la gauche jusq lindice 0
         * int temp = tab[i-1];
         * tab[i-1]=tab[i];
         * tab[i]=temp;
         * }System.out.println();
         * for(int i = 0; i<= 9; i++){
         * System.out.print(tab[i] + " ");
         * }
         * 
         * }
         */
        for (int i = 0; i < 9; i++) { // 5  on fait lechange de deux cases consecutives 
                                      // on s'arrete a 9 parce q a lindice 9 ya pas de i + 1;
            if (tab[i] > tab[i + 1]) {
                int temp = tab[i];
                tab[i] = tab[i + 1];
                tab[i + 1] = temp;
            }
        }

        for (int i = 0; i <= 9; i++) {
            System.out.print(tab[i] + " ");
        }

        for (int j = 0; j <= 9; j++) { // 6 afficher par ordre croissant
            for (int i = 0; i < 9; i++) { // on s'arrete a 9 parce q a lindice 9 ya pas de i + 1
                if (tab[i] > tab[i + 1]) {
                    int temp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;
                }
            }
        }System.out.println();
        for (int i = 0; i <= 9; i++) {
            System.out.print(tab[i] + " ");
        }

    }
}