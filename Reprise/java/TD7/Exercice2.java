public class Exercice2{
    public static void main(String [] args){
        String numero="";
        char saisi;
        int annee,mois;
        //do {
            System.out.println("Donner un numéro de sécurité sociale:");
            
            
            do{
                System.out.println("saisi du sexe:");
                saisi = Lire.c();

            }while(saisi != '1' && saisi != '2');
            System.out.println("le nb est " + saisi);

            do{
                System.out.println("saisi de l'année de naissance:");
                annee = Lire.i();

            }while(annee >= 00 && annee >= 99);
            System.out.println("l'annee est " + annee);
            do{
                System.out.println("saisi de le mois de naissance:");
                mois = Lire.i();

            }while(mois >= 1 && annee >= 12);
            numero = numero + saisi+annee;
            //numero = numero + annee;
            System.out.println("le numero est " + numero);

           

            
            
        //}while(numero.length()!= 13);
        
    }
}