public class Exercice1{
public static void main(String[] args) {
    int i,choix;
    char x,y;
    String mot="", mot2="",mot3="",miroir ="";
    do{
        System.out.println("Tapez 1 pour Saisir un mot");
        System.out.println("Tapez 2 Donner le miroir du mot");
        System.out.println("Tapez 3 Remplacer toutes les occurrences d'une lettre par une autre");
        System.out.println("Tapez 4 Supprimer toutes les occurrences d'une lettre donnée dans la chaîne");
        System.out.println("Tapez 5 Determiner si le mot est un palindrome");
        System.out.println("Tapez 6 Quitter le programme");
        System.out.println("Donner votre choix");
        choix = Lire.i();
        switch (choix) {
            case 1: System.out.println("saisir un mot:");
            mot = Lire.S();   
                break;

            case 2: System.out.println("Le miroir du mot est:");
            for( i = mot.length()-1;i >= 0; i--){
                System.out.print(mot.charAt(i));
                miroir = miroir + mot.charAt(i);
            }System.out.println();break;

            case 3: System.out.println("Saisir la lettre a changer");
            x = Lire.c();
            System.out.println("Saisir la lettre a mettre");
            y = Lire.c();
            for(i = 0; i <= mot.length()-1; i++){
                if(mot.charAt(i)==x){
                    mot2=mot2+y;
                }else mot2 = mot2 + mot.charAt(i);
            }System.out.println(mot2);break;
            case 4: System.out.println("Saisir la lettre a supprimer");
            x = Lire.c();
            for(i = 0; i <= mot.length()-1; i++){
                if (mot.charAt(i)!=x) {
                    mot3=mot3+mot.charAt(i);   
                }
            }System.out.println(mot3);break;

        
            case 5:System.out.println("verification si c'est un palindrome");
            if(mot.equals(miroir)){
                System.out.println("C'est un palindrome");
            }else System.out.println("le mot n'est pas un palindrome");break;

            /*case 5:
            boolean pal = true;
            for(i = 0; i < mot.length(); i++){
                if(mot.charAt(i)!=mot.charAt(mot.length()-1-i)){
                    pal = false;
                       
                }
            }
            if(pal == true){
                
                System.out.println("C'est un palindrome");

            }else
                System.out.println("le mot n'est pas un palindrome");break */


        
            default:
                break;
        }
        

    }while(choix!=6);
    
}
}