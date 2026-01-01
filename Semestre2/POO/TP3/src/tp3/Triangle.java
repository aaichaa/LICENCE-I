/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author BOBO
 */



public class Triangle
{
    // le premier sommet
    private Point a;
    /**
     * modifie le premier sommet (accesseur en écriture)
     * @param p le nouveau point pour représenter ce sommet
     */
    public void setA(Point p)
    {
        testSommet(p,getB(),getC(),"A");
        this.a = p;
    }
    /**
     * retourne la référence au premier sommet (accesseur en lecture)
     * @return la référence au premier sommet
     */
    public Point getA()
    {
        return this.a;
    }

    // le second sommet
    private Point b;
    /**
     * modifie le deuxième sommet (accesseur en écriture)
     * @param p le nouveau point pour représenter ce sommet
     */
    public void setB(Point p)
    {
        testSommet(p,getA(),getC(),"B");
        this.b = p;
    }
    /**
     * retourne la référence au deuxième sommet (accesseur en lecture)
     * @return la référence au deuxième sommet
     */
    public Point getB()
    {
        return this.b;
    }

    // le troisième sommet
    private Point c;
    /**
     * modifie le troisième sommet (accesseur en écriture)
     * @param p le nouveau point pour représenter ce sommet
     */
    public void setC(Point p)
    {
        testSommet(p,getA(),getB(),"C");
        this.c = p;
    }
    /**
     * retourne la référence au troisième sommet (accesseur en lecture)
     * @return la référence au troisième sommet
     */
    public Point getC()
    {
        return this.c;
    }

    private static void testEgalite(Point p,Point autre, String qui)
    {
        if(autre!=null&&p.equals(autre))
            throw new RuntimeException(qui+" est identique à un sommet existant");
        
    }
    private static void testSommet(Point p,Point s1,Point s2,String qui)
    {
        if(p==null)
            throw new RuntimeException("Le sommet "+qui+" n'est pas défini");
        testEgalite(p,s1,qui);
        testEgalite(p,s2,qui);
    }

       
    /**
     * Constructeur du triangle à partir de ses sommets.
     * @param a le premier sommet du triangle
     * @param b le deuxième sommet du triangle
     * @param c le troisième sommet du triangle
     */
    public Triangle(Point a, Point b, Point c)
    {
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    /**
     * Constructeur du triangle à partir d'un segment de base et d'un sommet
     * 
     * @param s le segment support du triangle
     * @param p celui des sommets qui ne se situe pas sur le segment
     */
    public Triangle(Segment s,Point p)
    {
        this(s.getExt1(),s.getExt2(),p);
    }

    /**
     * Constructeur de clonage (à partir d'un autre triangle)
     * @param autre le triangle pris pour modèle
     */
    public Triangle(Triangle autre)
    {
        // les new permettent de perdre la dépendance entre les triangles… ce qui n'est pas toujours ce que l'on veut
        this(
                new Point(autre.getA()),
                new Point(autre.getB()),
                new Point(autre.getC()));
    }

    public Segment getAB()
    {
        return new Segment(this.getA(),this.getB());
    }

    public Segment getAC()
    {
        return new Segment(this.getA(),this.getC());
    }

    public Segment getBC()
    {
        return new Segment(this.getB(),this.getC());
    }

    public double getPerimetre()
    {
        return
                this.getAB().getLongueur()+
                this.getAC().getLongueur()+
                this.getBC().getLongueur();
    }
    /**
     * calcul de l'aire par la formule de Héron
     * @return l'aire du triangle
     */
    public double getAire()
    {
        double la=this.getAB().getLongueur();
        double lb=this.getAC().getLongueur();
        double lc=this.getBC().getLongueur();
        double s=(la+lb+lc)/2;

        return Math.sqrt(s*(s-la)*(s-lb)*(s-lc));
    }

    @Override
    public String toString()
    {
        return "Triangle : {"+this.getA()+","+this.getB()+","+this.getC()+"}"+"\n"+
                "  Perimetre : "+this.getPerimetre()+"\n"+
                "  Aire : "+this.getAire();
    }
    
    private boolean isEqualStrict(Triangle autre)
    {
        return this.getA().equals(autre.getA()) && this.getBC().equals(autre.getBC());
    }
    /**
     * vérification que les deux triangles sont équivalents à la permutation près de leurs sommets
     * @return un booléen vrai si la condition est remplir
     */
    public boolean equals(Triangle autre)
    {
        
        return 
                isEqualStrict(autre)||
                isEqualStrict(new Triangle(autre.getAC(),autre.getB()))||
                isEqualStrict(new Triangle(autre.getAB(),autre.getC()));
    }
}



































/*public class Triangle {
    Point A;
    Point B;
    Point C;
    
    public Triangle(Point A, Point B, Point C){
        this.A = A;
        this.B = B;
        this.C = C;
    }
    public Segment getAB(){
        return new Segment(A,B);
    }
     public Segment getAC(){
        return new Segment(A,C);
    }
      public Segment getBC(){
        return new Segment(B,C);
    }
    
    public double getPerimetreTriangle(){
       return ((getBC().getLongueur() +  getAB().getLongueur() + getAC().getLongueur()));
   }
    
   public double getAirPerimetre(){
       return((getBC().getLongueur() * getAB().getLongueur())/2);
   } 
   
   //AB && BA;  BC && CB; AC && CA
   //AA && BB; BB && CC, AA && CC  
   
   public boolean equals(Triangle autre){
       return ((this.A.equals(autre.A)) && (this.B.equals(autre.B) && (this.C.equals(autre.C)))) || 
               (this.A.equals(autre.B) && (this.B.equals(autre.C) && (this.C.equals(autre.A)))) ||
               (this.B.equals(autre.A) && (this.C.equals(autre.B) && (this.A.equals(autre.C))));
       
       
       
       //return ((this.A.equals(autre.A) && (this.A.getY().equals(autre.A.getY() &&
         
       //(this.B.getX().equals(autre.B.getX()) && ) )) );
       
       
       //return ((this.a.equals(autre.a) && this.b.equals(autre.b)) || (this.a.equals(autre.b) && this.b.equals(autre.a)));
       
   }
    
    
    
    
    
    
}*/
