public class nombre{
    public static void main(String [] arg){
        int m,n,i, j;
        System.out.println("Veillez entrez  m ligne:");
        m = Lire.i();
        System.out.println("Veillez entrez n colonne:");
         n = Lire.i();
          for( i = 1; i <= m; i++ ){
            for( j = 1; j <= n; j++){
                System.out.print(j + " ");

            }System.out.println();
        }

    }
}