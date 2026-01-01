/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hadja
 */
public class PlateauJeu {
    private int tab [ ][ ]; 
   private int nbp; // nombre de personnages sur le plateau qui diminue au cours du jeu 
   private int nblig; 
   private int nbcol; 
   
   public PlateauJeu(int n) 
   {  this. nbp=n; 
       this.nblig=(int)(Math.sqrt(this.nbp*2)) ; 
       this.nbcol=this.nbp*2/this.nblig; 
       tab=new int [this.nblig][this.nbcol]; 
       initPlateauJeu(); 
   } 
    
   public PlateauJeu() {  this(4); } 
 
   public int getNblig() {   return this.nblig;  } 
   public int getNbcol() {   return this.nbcol;  } 
   public int getNbp() {   return this.nbp;  } 
 
   public int getCase(int l, int c) {   return tab[l][c];  } 
   public int getNbc() {   return this.nblig*this.nbcol/2;  }  
       
   public void initPlateauJeu() 
   {   int k=0; 
       for(int i=0; i<this.nblig; i++) 
         for(int j=0; j<this.nbcol; j++) 
            tab[i][j]=(k++)%this.nbp; 
       //melange(); 
   } 
    
   public void invalide(int l1, int c1, int l2, int c2) 
   { 
       tab[l1][c1]=-1; 
       tab[l2][c2]=-1; 
       this.nbp--;  
   } 
   public void melange() 
   {int l1,l2,c1,c2,tabE;
   for(int i=0;i<1000;i++){
       l1=(int)(Math.random()*this.nblig);
       l2=(int)(Math.random()*this.nblig);
       c1=(int)(Math.random()*this.nbcol);
       c2=(int)(Math.random()*this.nbcol);
       tabE=tab[l1][c1];
       tab[l1][c1]=tab[l2][c2];
       tab[l2][c2]=tabE;
   }
   } 
 
    
   public boolean jeuVide() 
   {return nbp==0;} 
 
   public boolean estValide(int l, int c) 
   {return tab[l][c]!=-1;
   } 
   public void termineJeu() 
   { for(int i=0;i<this.nblig;i++)
       for(int j=0;j<this.nbcol;j++)
           tab[i][j]=-1;
   }
}
