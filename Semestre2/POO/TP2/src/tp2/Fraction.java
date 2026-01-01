package tp2;


public class Fraction {
    // question 1
    private double numerateur;
    private double denominateur;
    

    
    // QUESTION 4
      public Fraction(double numerateur,double denominateur){
        //this.numerateur = numerateur; //AUSSI CA SANS LA CONTRAINTE
        //this.denominateur = denominateur; //AUSSI CA SANS LA CONTRAINTE
        if (denominateur == 0) {
            throw new IllegalArgumentException("Le dénominateur ne peut pas être 0.");
        }
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }
    public Fraction(int num){
       // this.numerateur = num;
       this(num,1);
    }  
    public Fraction(){
        // this.numerateur = 12; AUSSI CA
        //this.denominateur = 4; AUSSI CA
        this(12,4);
    }
    public Fraction(Fraction autre){
          //setNumerateur(autre.getNumerateur()); AUSSI CA 
          //setDenominateur(autre.getDenominateur()); AUSSI CA
          this(autre.getNumerateur(),autre.getDenominateur());
          
    }
  
    // QUESTION 2,3
    public double getNumerateur(){
        return numerateur;
    }
    public void setNumerateur(double numerateur){
        this.numerateur = numerateur;
    }
    public double getDenominateur(){
        return denominateur;
    }
    public void setDenominateur(double denominateur){
        if(denominateur > 0){
        this.denominateur = denominateur;
        
    }else if(denominateur < 0) {
            denominateur *= -1;
            this.denominateur = denominateur;
            setNumerateur(getNumerateur() * (-1));
        }else{
        System.out.println("Le denominateur ne doit pas etre nul");
    
        
    }
    }
         // question 5 voir les contructeur par defaut et par clonage
  
    //question 6
    public double getValeur(){
        return(this.numerateur/this.denominateur);
    }
    
    //QUESTION 7
    public Fraction getFois(int k){
        return new Fraction(this.numerateur * k,this.denominateur);
    }
    
    public Fraction getPlus(Fraction autreFrac){
        double num = this.numerateur*autreFrac.denominateur + this.denominateur * autreFrac.numerateur;
        double den = this.denominateur * autreFrac.denominateur;
        return new Fraction(num,den);
    }
    public Fraction getMoins(Fraction autreFrac){
        double num = this.numerateur*autreFrac.denominateur - this.denominateur * autreFrac.numerateur;
        double den = this.denominateur * autreFrac.denominateur;
        return new Fraction(num,den);
    }
      public Fraction getFois(Fraction autreFrac){
        double num = this.numerateur * autreFrac.numerateur;
        double den = this.denominateur * autreFrac.denominateur;
        return new Fraction(num,den);
    }
        public Fraction getSur(Fraction autreFrac){
        double num = this.numerateur * autreFrac.denominateur;
        double den = this.denominateur * autreFrac.numerateur;

        return new Fraction(num, den);
    }
        
        //question 9 
    private static double pgcd(double a, double b){
        if(a%b == 0)
            return b;
        else return pgcd(b,a%b);
    }
    
    //QUESTION 10
    public Fraction getSimplification(){
        double aux = pgcd(this.numerateur, this.denominateur);
        return new Fraction(this.numerateur/aux,this.denominateur/aux );
    }
    
    //QUESTION 11
    @Override
    public String toString(){
        if(this.denominateur == 1){
            return this.numerateur + "";// Utilisation de la concaténation pour convertir en String
        }
        else if(this.numerateur == 0){
            return "0";
        }else{
            return this.numerateur + "/" + this.denominateur;
        }
            
    }
    
    @Override
    public boolean equals(Object o)
        {
        if (this == o) return true; 
        if (o == null) return false; 
        if (this.getClass() != o.getClass()) return false;
        Fraction autre = (Fraction) o; 
        double num = autre.getSimplification().getNumerateur();
        double den = autre.getSimplification().getDenominateur();
        double nume = this.getSimplification().getNumerateur();
        double deno = this.getSimplification().getDenominateur();
        if(num == nume && den == deno){
            System.out.println("Les fractions sont identiques");
            return true;
        }else{
            System.out.println("Les fractions ne sont pas identiques");
            return false;
        }
        
        
                
        //<code pour comparer this et autre>
    } 
    
    
}
        
        
       
      
        
            
    
    

