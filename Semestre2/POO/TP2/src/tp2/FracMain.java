/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2;

/**
 *
 * @author BOBO
 */
public class FracMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    
        Fraction frac2 = new Fraction(1,1);
        Fraction frac1 = new Fraction(1,1);
        int choix;
        boolean enchainement = false;
        double num1=1,den1=1,num2,den2;
        do{
            System.out.println("\nMenu :");
            System.out.println("1. Modifier le premier opérande");
            System.out.println("2. Modifier le deuxième opérande");
            System.out.println("3. Intervertir les opérandes");
            System.out.println("4. Enchainement des operations");
            System.out.println("5. Arret de l'enchainement des operations");
            System.out.println("6. Multiplication du premier operande par un facteur");
            System.out.println("7. Inversion du premier operande(num et den)");
            System.out.println("8. Inverser le premier opérande");
            System.out.println("9. Addition/Soustraction/Multiplication/Division des deux opérandes");
            System.out.println("10. Quitter");
            System.out.println("Faite un choix :");
            choix = Lire.i();
            
            switch(choix){


                case 1: {System.out.println("Entrez le numerateur du premier operande");
                            num1 = Lire.i();
                         System.out.println("Entrez le denominateur du premier operande");
                            den1 = Lire.i(); 
                             frac1 = new Fraction(num1,den1);
                }break;
                case 2: {System.out.println("Entrez le numerateur du deuxieme operande");
                            num2 = Lire.i();
                         System.out.println("Entrez le denominateur du deuxieme operande");
                            den2 = Lire.i(); 
                            frac2 = new Fraction(num2,den2);
                }break;
                case 3: { 
                    Fraction temp = frac1;
                    frac1 = frac2;
                    frac2 = temp;
                
                }break;
                case 4:{
                    enchainement = true;
                    System.out.println("L'enchainement est activé l'operande sera mis a jour");
                    
                }break;
                case 5:{
                    enchainement = false;
                        System.out.println("L'enchainement est desactivé l'operande ne sera mis a jour");
                }
                    
                case 6:{System.out.println("Entrez l'entier  avec lequel vous multiplié l'operande");
                    Fraction multi = frac1.getFois(Lire.i());
                    if(enchainement == true)
                    {
                    frac1 = multi; //change la fraction si ya enchainement
                    }
                    
                     System.out.println("Apres multiplication de l'operande" +multi);
                     System.out.println("Nouvelle valeur de l'operande" +frac1);
                }break;
                case 7:{
                    double temp = num1;
                    num1 = den1;
                    den1 = temp;
                     System.out.println("Apres inversion de l'operande"+ num1 +"/"+ den1);
                    
                }break;
                case 8:{
                    double numera = frac1.getSimplification().getNumerateur();
                    double denomi = frac1.getSimplification().getDenominateur();
                    
                    System.out.println("Apres simplification:" +numera + "/" + denomi );
                    
                }break;
                case 9: {
                    double num =frac1.getPlus(frac2).getNumerateur();
                    double den = frac1.getPlus(frac2).getDenominateur();
                    System.out.println("Apres l'addition des deux operandes:" + num +"/"+den);
                    double nume = frac1.getMoins(frac2).getNumerateur();
                    double deno = frac1.getMoins(frac2).getDenominateur();
                    System.out.println("Apres la soustraction des deux operandes:" + nume +"/"+deno);
                    double numera = frac1.getFois(frac2).getNumerateur();
                    double denomina = frac1.getFois(frac2).getDenominateur();
                    System.out.println("Apres la multiplication des deux operandes:" + numera +"/"+denomina);
                    double numerateur = frac1.getSur(frac2).getNumerateur();
                    double denominateur = frac1.getSur(frac2).getDenominateur();
                    System.out.println("Apres la division des deux operandes:" + numerateur +"/"+denominateur);
                    
                    
                   
                }

        }
        }while(choix !=10);
        
        
        
        
        
        
        
        
       //Fraction f1 = new Fraction(8,1);
     //System.out.println("Le numerateur est: "+ f1.getNumerateur());
     //System.out.println("Le denominateur est: "+ f1.getDenominateur());
     
    /* f1.setDenominateur(-1);// DENOM NEGATIF DONC CHANGE LE SIGNE DU NUM
     System.out.println("Le numerateur est: "+ f1.getNumerateur()); // SIGNE DU NUM CHANGE
     
     Fraction f = new Fraction(7);
     System.out.println("Le numerateur est: "+ f.getNumerateur());
     
     Fraction f2 = new Fraction();
     System.out.println("Le numerateur est: "+ f2.getDenominateur());
     
     
     Fraction f4 = new Fraction(6,5);
     Fraction f5 = new Fraction(f4);
     
      System.out.println("Le denominateur est: "+ f5.getDenominateur());*/
     
     
     //6
    /* Fraction frac = new Fraction(10,35);
      System.out.println("Le resultat est: "+ frac.getValeur());
      
      //question 7
      
      //Fraction fois = new fraction(5);
      double num = frac.getFois(2).getNumerateur();
      double den = frac.getDenominateur();
      //System.out.println("Le resultat est: "+ num + "/" + den);
      
      Fraction plus = new Fraction(5,2);
      double nume = plus.getPlus(frac).getNumerateur();
      double deno = plus.getPlus(frac).getDenominateur();
      System.out.println("Le resultat de l'addition  est: "+ nume + "/" + deno);
      
      double numer = plus.getMoins(frac).getNumerateur();
      double denom = plus.getMoins(frac).getDenominateur();
      System.out.println("Le resultat de la soustraction est: "+ numer + "/" + denom);
      
      double numera = plus.getFois(frac).getNumerateur();
      double denomi = plus.getFois(frac).getDenominateur();
      System.out.println("Le resultat de multiplication est: "+ numera + "/" + denomi);
      
      double numerate = plus.getSur(frac).getNumerateur();
      double denominat = plus.getSur(frac).getDenominateur();
      System.out.println("Le resultat de la division est: "+ numerate + "/" + denominat);
      
      //QUESTION 8
    
        Fraction tout = (new Fraction(3,2).getMoins(new Fraction(2, 5)).getFois(2))
                    .getMoins(new Fraction(4, 5).getFois(new Fraction(-3, 4)));
      System.out.println("Le resultat:"+ tout.getNumerateur()+"/"+tout.getDenominateur());
      
      //question 9
      //System.out.println("le resultat du pgcd est:"+ Fraction.pgcd(10, 8));
      
      //question 10
       Fraction f = new Fraction(10,35);
       Fraction f2 = f.getSimplification();
       double numerateur = f2.getNumerateur();
       double denominateur = f2.getDenominateur();
       System.out.println("le resultat de la simplification est:"+ numerateur + "/" + denominateur);
       //l'accès à la fonction ogcd est interdit a l'exterieur car il est en private
       
       //question 11
       //Fraction dernier = new Fraction(2,3);
        //System.out.println("ce que ca donne avec la methode toString est:"+ dernier); */
        
        
        
        //TP3
        //QUESTION 1,2
        //ToString
        
        //Fraction f1 = new Fraction(3,2);
        System.out.println(new Fraction(3,1));
        
        //Equals
        //question 1
       /* Fraction f1=new Fraction(3,4),f2=new Fraction(3,4);
        if(f1==f2)
            System.out.println("Objets Fraction identiques");
        else 
            System.out.println("Objets Fraction différents"); */
        //je crois que ça ne compare pas les valeurs des fractions mais plutot la zone memoire des deux instances
        
        //question 2,3,4
        Fraction f3=new Fraction(3,4),f4=new Fraction(3,4);
       
            System.out.println(f3.equals(f4));
        
        
        //donc celui la aussi fait la meme chose sans une fonction equals elle ne compare pas les valeurs
        //maintenant que jai fais la fonction equals ca marche, ca me retourne la comparaison des deux valeurs
        
        
      
    }
}
   
      
      
     
      
      
     
    
     
     
     
     
     

     

