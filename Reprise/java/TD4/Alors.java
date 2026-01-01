public class Alors{
    public static void main(String[] args){
        int n, i, j;
        System.out.println("Entrez n");
        n = Lire.i();
        
        for(i = 1; i <= n; i ++){
            for(j = 1; j <= n; j++){
                if (i%2 == j%2)
                {
                    System.out.print("* ");
                }else System.out.print(" ");
            }System.out.println();
        }
    }
}