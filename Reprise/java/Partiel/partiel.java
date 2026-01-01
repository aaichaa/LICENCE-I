public class partiel{
    public static void main (String [] args){
        int n,m;
        System.out.println("Veillez entrez  m ligne:");
        m = Lire.i();
        System.out.println("Veillez entrez n colonne:");
         n = Lire.i();
          for(int i = 1; i <= m; i++ ){
            for(int j = 1; j <= n; j++){
               if(i == 1 || i == m){
                System.out.print("*");
               } 
               else if (j == 1 || j == n)
               {
                System.out.print("*");
               }else System.out.print(" ");

            }System.out.println();
          }
    }
}