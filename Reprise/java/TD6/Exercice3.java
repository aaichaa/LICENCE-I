public class Exercice3{
    public static void main (String [] args){
        int n,i,j;

        System.out.println("Entrez n");
        n = Lire.i();
        int tab [][] = new int [n+1][n+1];
        for(i = 1 ; i <= n; i++){
            for(j = 0; j< i; j++){
                if(i == j || j == 0){
                    tab[i][j] = 1;
                }else  tab[i][j] = tab[i-1][j] + tab[i-1][j-1];
            }
        }
        for(i = 0 ; i <= n; i++){
            for(j = 0; j< i; j++){

                System.out.print(tab[i][j] + " ");
            }
            System.out.println();

    }

}
}