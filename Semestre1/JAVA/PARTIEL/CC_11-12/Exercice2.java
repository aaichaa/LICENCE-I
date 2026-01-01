    public class Exercice2
    { public static void main (String [] args)
    { 
        int n,i,j;
        System.out.println("Entrer n");
        n=Lire.i();
        for(i=1;i<=n;i++)
        { 
        for(j=1;j<=n;j++){
            if(j == 1 || j == n)
            System.out.print("*");
        else if(i == 1 || i == n)
            System.out.print("*");
        else if(j==i)
        System.out.print("*");
        else
        System.out.print(" ");

        }
        System.out.println();
    }
    }
    }
        
    