public class Exercice{
    public static void main(String[] args){
        int n,i,j;
        int tab[] = {1,2,3,4,5,6,7,8}; // un tableau avec ces valeur
        int resu [] = new int [5] ; // un tableau qui doit avoir 5 element
        int t = 8;
        for(i = 0; i < 5; i++){ //1
            int indice = (int)(t*Math.random());
            resu[i] = tab[indice];
            int temp = tab[indice];
            tab[indice] = tab[t - 1];
            tab[t - 1] = temp;
            t--;
        }
        for(i = 0; i < 5; i++){
            System.out.println(resu[i] + " ");
        }



    }
}
