
package tp1;


public class LesDes {
    private int nbDes;
    
    
    public int getResultat(){
         return (int)(1 + 6*Math.random());
     
    }
    
    public LesDes(int nbDes){
        this.nbDes = nbDes;
    }
    public LesDes(){
        this.nbDes = 6;
    }
    
}
