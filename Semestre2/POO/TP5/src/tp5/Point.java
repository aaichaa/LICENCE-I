/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5;

/**
 *
 * @author BOBO
 */
public class Point extends ObjetGeom{
    //QUESTION 1
    private double x;
    private double y;
    
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    public Point(double x, double y,String nom) {
        super(nom);
        this.x = x;
        this.y = y;
        
    }
    public Point(String nom){
        super(nom);
        this.x = 1;
        this.y = 1;
    }
    public Point(Point autre,String nom){
        this(autre.getX(),autre.getY(),nom );
        
        /*setX(p.getX());
        setY(p.getY());*/
    }
        public Point(Point autre){
        this(autre, autre.getNom()+"'");
        
        /*setX(p.getX());
        setY(p.getY());*/
    }
    
    
    
    
    //question 3
    @Override
    public String toString(){
        return super.toString()+" "+ this.x + "," + this.y;
           
    }
    
    //question 4 
  public double getDistance(Point autre){
    return Math.sqrt(((autre.getX() - this.getX())*(autre.getX() - this.getX())) + ((autre.getY()-this.getY())*(autre.getY()-this.getY())));
  }
  
  
  //question 8
  
  public boolean equals(Point autre){
      return (this.x == autre.x && this.y == autre.y);
  }
    
    
    
    
    
    
}
