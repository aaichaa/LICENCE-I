/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author BOBO
 */
public class Segment {
    private Point ext1;
    private Point ext2;
    
    public Point getExt1(){
        return this.ext1;
    }
     public void setExt1(Point a){
         if(a != null)
         this.ext1 = a;
         else System.out.println("Un point ne doit pas etre nul");
    }
     public Point getExt2(){
         return this.ext2;
     }
     public void setExt2(Point b){
         if(b != null)
         this.ext2 = b;
         else System.out.println("Un point ne doit pas etre nul");
    }
     

    public Segment(Point ext1, Point ext2) {
        if(ext1 != null && ext2 != null && ext1.equals(ext2) == false){
           this.ext1 = ext1;
           this.ext2 = ext2; //on pouvair juste appeler le setter a la place
        }else
             System.out.println("Points invalides");


        
    }
    
    public Segment(){
        this.ext1 = new Point();//on cree une nouvellle instance pour linitialisation (ca ne marche pas si la classe point n'a pas de constructeur standard)
        this.ext2 = new Point();
    }
    
    //QUESTION 3
    
    @Override 
    public String toString(){
        return "Segment: "+ this.ext1 + ", " + this.ext2 + " "+
             "Milieu : " + this.getMedian() + " " +
             "Longeur : " + this.getLongueur();
        //question 5L
    }
    
    //QUESTION 4
    public double getLongueur(){
        return this.ext1.getDistance(this.ext2);
    }
    
    public Point getMedian(){
        return (new Point(((this.ext1.getX() + this.ext2.getX())/2),((this.ext1.getY() + this.ext2.getY())/2)));
    }
    
    //QUESTION 8 
    public boolean equals(Segment autre){
        return ((this.ext1.equals(autre.ext1) && this.ext2.equals(autre.ext2)) || (this.ext1.equals(autre.ext2) && this.ext2.equals(autre.ext1)));
    }
    
     
     
     
     
     
    
    
    
}
