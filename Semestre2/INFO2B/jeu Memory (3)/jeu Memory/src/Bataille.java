/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Millimouno
 */
public class Bataille extends Action{
    private Joueur adversaire;
    public Bataille(Joueur sc, Joueur a) {
        super(sc, "Bataille");
        this.adversaire = a;
 }
    public Joueur getAdversaire() { return adversaire ; }
    public int execute(){
        int res=0;
        if(this.adversaire.getPaquet().getTaille()>0 && this.getJoueurCourant().getPaquet().getTaille()>0){
            res=-1;
            System.out.println(this.getJoueurCourant().getPaquet().getPerso(0));
            Personnage c1=this.getJoueurCourant().getPaquet().getPerso(0);
            Personnage c2=this.getAdversaire().getPaquet().getPerso(0);
            this.getJoueurCourant().getPaquet().retirePerso(c1);
            this.adversaire.getPaquet().retirePerso(c2);
            if(c1.getValeur()==c2.getValeur()){
                res=0;
                this.getJoueurCourant().getPaquet().ajoutePerso(c1);
                this.adversaire.getPaquet().ajoutePerso(c2);
            }
            else{
                if(c1.getValeur()>c2.getValeur()){
                    res=1;
                    this.getJoueurCourant().getPaquet().ajoutePerso(c1);
                    this.getJoueurCourant().getPaquet().ajoutePerso(c2);
                }
                else{  
                    //if(c1.getValeur()<c2.getValeur()){
                    res=2;
                    this.adversaire.getPaquet().ajoutePerso(c1);
                    this.adversaire.getPaquet().ajoutePerso(c2);
                    //}
                }
                
            }
            if(this.getJoueurCourant().getPaquet().getTaille()==0 || adversaire.getPaquet().getTaille()==0){
                
                if(this.getJoueurCourant().getPaquet().getTaille()==0){
                    setDeroulement("le joueur "+this.adversaire+" à gagné");
                }
                else{
                    setDeroulement("le joueur "+getJoueurCourant()+" à gagné");
                }  
            }
                    
            
        }
       return res; 
    }
}
