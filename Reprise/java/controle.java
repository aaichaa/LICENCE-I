public class controle{
    public static void main(String [] args){
        double elle = 0, lui = 0;
        double choixElle, choixLui;
        do{
            choixElle = (int)(3+5*Math.random());
            choixLui = (int)(3+5*Math.random());

            elle = elle + choixElle;
            lui = lui + choixLui;
            if(elle > 20)
            elle = 21;
            if(lui > 20)
            lui = 21;

        }while(elle < 20 && elle < 20);

        if (elle == 20 && lui == 20) {
            System.out.println("Les deux joueurs ont atteint la marche 1 en même temps, match nul !");
        }

        else if(elle >= 20){
            System.out.println("le gagnant est Elle");
            }
            else if (lui >= 20) {
                System.out.println("le gagnant est Lui");
            } 



    }
}