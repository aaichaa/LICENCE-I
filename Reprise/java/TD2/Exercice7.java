public class Exercice7{
    public static void main(String args []){
        int M,J,A;
        String mois = " ";
        System.out.println("Entrer une date ");
        J = Lire.i();
        M = Lire.i();
        A = Lire.i();

        switch (M) {
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
             
                if(J<31){
                   J = J + 1;
                }
                   else if(M == 12)
                    {
                        J = 1; M = 1; A = A + 1;
                    }
                    else 
                    {
                        J = 1; M = 1;
                    }
            
                
                break;
                
            case 4:case 6:case 9:case 11:
                if (J < 30) {
                    J = J + 1;
                    
                }else {
                    J = J + 1; M = M + 1;
                }

                break;
                case 2: if(J < 28){
                    J = J + 1;

                }else {
                    J = 1; M = 3;
                }
                break;
        }
    
             // Obtenir le nom du mois en toutes lettres
           
             switch (M) {
                 case 1: mois = "Janvier"; break;
                 case 2: mois = "Fevrier"; break;
                 case 3: mois = "Mars"; break;
                 case 4: mois = "Avril"; break;
                 case 5: mois = "Mai"; break;
                 case 6: mois = "Juin"; break;
                 case 7: mois = "Juillet"; break;
                 case 8: mois = "Aout"; break;
                 case 9: mois = "Septembre"; break;
                 case 10: mois = "Octobre"; break;
                 case 11: mois = "Novembre"; break;
                 case 12: mois = "Decembre"; break;
             }
     
             // Afficher la date du lendemain
             System.out.println("Le " + J + " " + mois + " " + A);


    }
}
