public class Netbeans{
    public static void main(String [] args){
       /* int tab[] =new int [5];
        int i;
        System.out.println("Remplissez le tableau:");
        for(i = 0;i<5;i++){
            tab[i] = Lire.i();
        }
        System.out.println("le tab:");
        for(i = 0;i<5;i++){

            System.out.print(tab[i]);
        }System.out.println();
        for(int j = 0;j<5;j++){
        for(i = 0;i<4;i++){
            if(tab[i] >tab[i+1]){
                int temp = tab[i];
                tab[i] = tab[i+1];
                tab[i+1] = temp;
            }
        }
    }
        System.out.println("le new tab:");
            for(i = 0;i<5;i++){
    
                System.out.print(tab[i]);
            }
            int note;


            /*do{
                System.out.println("Entrez une note entre 0 et 20");
                note = Lire.i();

            }while(note < 0 && note > 20);
            note = 14;
            if(note >= 0 && note<10){
                System.out.println("INSUFFISANT");
            }
            else if(note >= 10 && note<12){
                System.out.println("PAS DE MENTION");
            }
            else if(note >= 12 && note<14){
                System.out.println("ASSEZ BIEN");
            }
            else if(note >= 14 && note<16){
                System.out.println("TRES BIEN");
            }else if(note >18) System.out.println("Felicitations");*/

            System.out.println("Combien de jours souhaité vous analyser:");
            int nbjour = Lire.i();
            for(int i = 1; i<=nbjour;i++){
                System.out.println("Entrez la temperature pour le jour "+ i);
                int jour = Lire.i();
            }







    }
}