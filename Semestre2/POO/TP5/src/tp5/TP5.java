/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp5;

/**
 *
 * @author BOBO
 */
public class TP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //QUESTION 3
        Point p = new Point(2,3,"P1");
        System.out.println(p.toString());
        System.out.println(new Point(p).getNom());
        
        //Disque d2 = new Disque(p1,5,"");//a refaire avec le constructeur par clonage pour que si je change le centre ca change aussi le point...
       
        //System.out.println(d2.toString());
        
        Segment S = new Segment(new Point(1,2,""),new Point(3.5,2.5,"")," ");
        
         System.out.println(S.toString());
         
         Triangle t1 = new Triangle(new Point(2,3,""),new Point(5,2,""), new Point(1,3,""),"");
         //System.out.println(t1);
         System.out.println("Le perimetre du triangle est : " + t1.getPerimetre());
         
         Segment s = new Segment(new Point(-1,3,"p1"),new Point(0,-2,"p2"),"p1_p2");
         System.out.println(s.getNom());
         
        /* 
         //qestion 4
         Segment s1 = new Segment(new Point(2,2),new Point(6,5));
         Segment s2 = new Segment(new Point(5,-3),new Point(-1,2));
        
          System.out.println("La distance est "+  s1.getLongueur()  );
          
          System.out.println("Le milieu est "+  s2.getMedian());
          
          System.out.println("Le point est dans le disque? -> "+  d2.isOnSurface(p1));
          
          //question 8
          
          
           Point p3 = new Point(3,3);
        System.out.println("Les points sont ils egaux ? " + p1.equals(p3));
        
        Disque d3 = new Disque(p1,1);
        System.out.println("Les disques sont ils egaux ? " + d3.equals(d2));
        
        Segment s4 = new Segment(new Point(6,5),new Point(2,2));
        Segment s3 = new Segment(new Point(2,2),new Point(6,5));
        System.out.println("Les segments sont ils egaux ? " + s3.equals(s4)); */
        
        
        
        
        
          
          
          
          
          
          
          
         
        
        
        
        
        
    }
    
}
