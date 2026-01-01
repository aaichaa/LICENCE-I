public class Exercice3{
    public static void main (String args[]){
        int a, b ,delta, c;
        double x1,x2;
        System.out.println("Entrez les element de l'equation");
        a = Lire.i();
        b = Lire.i();
        c = Lire.i();
        delta = b * b -  4 * a * c;
        if(delta > 0){
            x1 = (- b - Math.sqrt(delta))/(2*a);
            x2 = (- b + Math.sqrt(delta))/(2*a);

            System.out.println(" x1 = " + x1 + " x2 = " + x2);
            
        }
        else if(delta == 0){
            x1 =  x2 =(- b )/(2*a);

            System.out.println(" x1 = " + x1);
        
        }
        else if( delta < 0 ){
            System.out.println("y a pas de solution");
        }
        
        
        


    }
}