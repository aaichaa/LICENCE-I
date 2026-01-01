/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hadja
 */
public class Transfert extends Action {
 private Joueur cible;
 private String fp;
 private LesPersonnages cartestransferees;

    public Joueur getJoueurCible() {
        return this.cible;
    }
    public LesPersonnages getCartestransferees() {
        return this.cartestransferees;
    }
    public Transfert(Joueur j,Joueur jc,String f ){
        super(j,"Transfert de cartes");
        this.cible=jc;
        this.fp=f;
        this.cartestransferees= new LesPersonnages();
    }
    public int execute(){
        int res;
        if(this.fp!=null){
            this.cartestransferees=this.cible.getPaquet().retirePersosFamille(this.fp);
            this.getJoueurCourant().getPaquet().ajoutePersos(this.cartestransferees);
            this.setDeroulement(this.getJoueurCourant().getPseudo()+" a pris les personnages de la famille "+this.fp+" à "+this.cible.getPseudo());
        }
        res=this.cartestransferees.getTaille();
        return res;
    }
}
