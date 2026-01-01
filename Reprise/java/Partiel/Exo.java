public class Exo{
public static void main(String[] args) {
    int compteur = 0,i,j,niveau =0;
    int tab []=new int [20];
    for(i = 0; i <= 19; i++){ //1
        tab[i] = (int)(3+9*Math.random());
        System.out.print(tab[i]+" ");
    }System.out.println();

    for(i = 1; i < 19; i++){  //2
        if(tab[i-1]<tab[i] && tab[i]>tab[i+1]){
            compteur = compteur +1;
        }
    } System.out.println("Le nombre de pics est:" + compteur);

    for (i = 0; i <= 19; i++) {
        boolean estCol = true; // On suppose d'abord que tab[i] est un col(et est toujous pris pour un col)
        for (j = 0; j < i; j++) {
            if (tab[j] >= tab[i]) { 
                estCol = false; // Si un seul élément précédent n'est pas plus petit
            }
        }
        if (estCol) { // Si tab[i] est toujours un col après vérification
            niveau= niveau+1;
        }
    }System.out.println("Le nombre de cols est:" + niveau);

    
    

}
}