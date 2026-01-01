/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author BOBO
 */
public class Disque {
    //QUESTION 1
   private Point centre;
   private double rayon;
   
   public Point getCentre(){
       return this.centre;
   }
   public void setCentre(Point centre){
       if(centre != null){
           this.centre = centre;
       }else{
           System.out.println("Le centre ne doit pas etre nul");
       }
   }
   public double getRayon(){
       return this.rayon;
   }
   
   
   
   public void setRayon(double rayon){
       if(rayon > 0){   //POUR FAIRE UNE CONDITION ON LE FAIT AVEC CE QUI EST EN PARAMETRE PAS LE THIS DE LA CLASSE
           this.rayon = rayon;
       }else {
           System.out.println("Le rayon doit etre positif");
       }
        
   }
   
   //QUESTION 2

    public Disque(Point centre, double rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }
   
   public Disque(){
       this.centre = new Point(); //pour initialiser un attribut qui vient dune autre classe on doit creer une nouvelle instance(sans le constructeur par defaut de lautre classe ca ne marche pas)
       this.rayon = 1;
   }
   
   public Disque(Disque autre){
       setRayon(autre.getRayon());
       setCentre(new Point(autre.getCentre())); //on cree une nouvellle instance pour l'initialisation(ca ne marche pas si la classe point n'a pas de constructeur standard
       
   }
   
   //QUESTION 3
      @Override
    public String toString(){
        return "Disque : (" + this.centre + ")" +","+ this.rayon + ")" +
                " Périmètre : " + this.getPerimetre() +" " +
                " Aire : " + this.getAir();
        //QUESTION 5
    }
    
    //QUESTION 4

    public double getPerimetre(){
        return 2*Math.PI*this.rayon;

    }
    public double getAir(){
        return Math.PI*this.rayon*this.rayon;
    }
    
    public boolean isOnSurface(Point autre){
        return autre.getDistance(this.centre) == this.rayon;
    }
    
    public boolean equals (Disque autre){
        return (this.centre == autre.centre && this.rayon == autre.rayon);
    }
    
}


