/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {
        Client client=new Client("Joël","Savelli","0658090327",new Adresse(7,"bis","rue","Jules BLAIZET",21300,"CHENÔVE"));

        Compte compte1=client.nouveauCompte("0290000856V",200);
        compte1.versement(350);
        compte1.ajoutCarte("58484029");
        compte1.retrait(-10);
        compte1.retrait(10);

        Compte compte2=client.nouveauCompte("03456782789C");
        compte1.virement(compte2, 220);
        compte2.virement(compte1, 2000);
        compte2.cloture();
        compte2.versement(1000);

        System.out.println(client);
    }  
}
