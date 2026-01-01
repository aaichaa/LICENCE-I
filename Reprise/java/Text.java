public class Text{
    public static void main(String [] args){
        //int i,j, n = 4;
        /*for(i = 1 ; i <= n; i++ ){
            for(j = 1 ; j <= i; j++ ){
            System.out.print(i+(j-1));

            }System.out.println();

        }
        for(i = n ; i >= 1; i-- ){
            for(j = 1 ; j <= n; j++ ){
            System.out.print("*");

            }System.out.println();

            

        }
            
           int n = 5;
        for ( int i = n; i >= 1; i--) {  // Boucle pour les lignes
            for ( int j = 1; j <= i ; j++) {  // Boucle pour les colonnes
                if(j == 1 || i ==5 || i == j){
                System.out.print("* ");
                }
                else if(i%j == 0 || i == j+1){
                    System.out.print("* ");
                }
                //else System.out.println();
            }
            System.out.println();  // Sauter à la ligne après chaque ligne d'étoiles
        }  */
int n = 5;
        for ( int i = 1; i <= n; i++) {  // Boucle pour les lignes
            for ( int j = 1; j <= n ; j++) {  
                if(j >= i){
                    System.out.print(j + " ");}
               else   if(i!= j){
                System.out.print("0 ");
                }
               
                
                //else System.out.println();
            }
            System.out.println();  // Sauter à la ligne après chaque ligne d'étoiles
        } 
/*
        int s=0;
        for(i = 1 ; i <= n; i++ ){
            for(j = 1 ; j <= i; j++ ){

                if(j%2==0)
                s=s+j;
            

            }
        }System.out.println(s);*/

       /* i = 1;
        int s=0;
        j = 1;


        while (i<= n ) {
        j=1;
            do{
                if(j%2==0)
                s=s+j;
                j = j+1;

            }while(j<=i);
            i = i +1;
            
        } System.out.println(s);

        /*
        for(i = 1 ; i <= n; i++ ){
            for(j = 1 ; j <= n; j++ ){
                if(i == 1 || j == 4)
                
                System.out.print("*  ");
                else if(i == j)
                System.out.print("*  ");


            }System.out.println();
        }*/
       // int choixElle,choixLui,Elle = 316,Lui =316, gagnant;

       /* do{ code un peu erroné


            choixLui = (int)(1+5*Math.random());
            choixElle = (int)(1+5*Math.random());
            Elle = Elle - choixElle;
            Lui = Lui - choixLui;
          
              
           
        }while(Elle >= 1 || Lui >= 1);
        if(Elle == 1){
            System.out.println("le gagnant est Elle");
            }else System.out.println("le gagnant est Lui");

            do{


                choixLui = (int)(1+5*Math.random());
                choixElle = (int)(1+5*Math.random());
                Elle = Elle - choixElle;
                Lui = Lui - choixLui;

                 // Empêcher de descendre en dessous de la marche 1
                if (Elle < 1) {
                    Elle = 1;
                }
                if (Lui < 1) {
                    Lui = 1;
                }
              
                  
               
            }while(Elle > 1 && Lui > 1);
            if (Elle == 1 && Lui == 1) {
                System.out.println("Les deux joueurs ont atteint la marche 1 en même temps, match nul !");
            }

            else if(Elle == 1){
                System.out.println("le gagnant est Elle");
                }else System.out.println("le gagnant est Lui");


                int n;
String binaire ;
System . out . println (" Entrer la valeur de n:") ;
n = Lire . i () ;
binaire ="";
do
{
if( n %2==1)
binaire ="1"+ binaire ;
else
binaire ="0"+ binaire ;
n = n /2;
}
while ( n !=0) ;
System . out . println ( binaire ) ;*/



/*int i,j,n;
System.out.println(" entrer");
n = Lire.i();
for ( i = 1; i <= n; i++) {  // Boucle pour les lignes
    for ( j = 1; j <= n; j++){
        if(i == j)
        System.out.print("+ ");
        else if (j == (i+1)) {
           System.out.print("* ");
        }else System.out.print(" ");


    }System.out.println();
    }*/
    






            



    }
}
