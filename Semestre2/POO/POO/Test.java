//class main
public class Test {

    public static void main(String[] args) {
        //intanciation du constructeur et initialiation en meme temps(toujours avec les constructeurs)
        Humain newHumain = new Humain("Diallo", "Aissatou");
        // affichage des valeurs des attributs
        System.out.println(newHumain.nom);
        System.out.println(newHumain.prenom);

    }
}