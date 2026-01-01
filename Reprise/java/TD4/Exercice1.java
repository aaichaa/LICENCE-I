public class Exercice1{
    public static void main (String args [])
    {
        int i,j, n;
        //do{
        System.out.println("Entrez n");
        n = Lire.i();
        //}while(n < 4);
        for (i = 1; i <= n; i++){
            for(j = 1; j <= n; j++){
               /* if(i%2!=0 && j%2!=0)
                {
                    System.out.print("*");
                }else if(i%2==0 && j%2==0){
                    System.out.print(" ");
                }

            }*/

            if (j % 6 <= 3 && j % 6 != 0) {
                System.out.print("*");
            } else {
                // Sinon, afficher un espace ou un point
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
}