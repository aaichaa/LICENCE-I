public class Exercice2{
    public static void main(String[] args){
        int i,j;
        int tab[] = new int [5];
        for(i = 0; i<= 4; i++){ //1
            tab[i] = (int)(1+8*Math.random());
            System.out.print(tab[i] + " ");
        }System.out.println();
        System.out.println("entrez n");
        for(i = 0; i<= 4; i++){ 
            do{
                tab[i] = Lire.i();
            }while()
        
        }
       
        for(i = 0; i<= 4; i++){
            System.out.print(tab[i] + " ");
        }

    }
}