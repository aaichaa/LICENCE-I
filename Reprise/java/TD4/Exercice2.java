public class Exercice2{
    public static void main(String[] args){
        int i,n,p,j,fp = 1,fn = 1,fnp = 1;
        System.out.println("Entrez n: ");
        n = Lire.i();
        for(i = 1; i <= n; i++)
        fn = fn * i;
        System.out.println("Le factorielle de n est: "+ fn);
        System.out.println("Entrez p: ");
        p = Lire.i();
        for(i = 1; i <= p; i++)
        fp = fp * i;
        System.out.println("Le factorielle de P est: "+ fp);
        
        for(i = 1; i <= (n-p); i++)
         fnp= fnp * i;

        System.out.println("Le factorielle de F(n-p) est: "+ fnp);
        System.out.println("le Cnp est : "+ fn/(fp*fnp));


        for(i = 1; i <= n; i++)
        {
            
        }
    }
}