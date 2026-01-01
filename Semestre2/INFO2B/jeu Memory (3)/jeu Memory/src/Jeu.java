/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Millimouno
 */
public class Jeu {
    private LesPersonnages lesPers; // collection des personnages utilisés pour le jeu
   private PlateauJeu monP; // plateau du jeu
    private LesJoueurs lesJ; // joueurs qui participent au jeu
    private Action act; // action accomplie par le joueur courant le cas échéant
    private int indC; // indice du joueur courant
    public Jeu(LesPersonnages lp, LesJoueurs lj, int nbc)
    { // nbc correspond au niveau de jeu qui a été sélectionné par les joueurs
        indC=0;
        lesJ=lj;
        lesPers=lp;
       monP=new PlateauJeu(nbc);
        
        act=null;
        
    }

    public LesJoueurs getLesJ() {
        return lesJ;
    }

    public void setLesJ(LesJoueurs lesJ) {
        this.lesJ = lesJ;
    }
    public Jeu(){
        this.lesPers=new LesPersonnages();
       // monP=new PlateauJeu();
        this.lesJ=new LesJoueurs();
    }
   public PlateauJeu getPlateau() { return this.monP; }
    public Action getAct() { return this.act; }
    public LesPersonnages getPersonnages(){ return this.lesPers;}
    public LesJoueurs getJoueurs(){ return this. lesJ;}
    public int getIndC(){return this. indC;}
    public void setJoueurCourant(int n){this.indC = n;}
    public Joueur getJoueurCourant()
   {return this.lesJ.getJoueur(indC);}


    public int getIndSuivant(int j)
    {return (j+1)%this.lesJ.getNbJoueurs() ; }
    public Joueur getJoueurSuivant(int j)
   {return this.lesJ.getJoueur(getIndSuivant(j)) ;}


    public boolean finJeu()
    { return this.monP.jeuVide();}

    public int nbPers() // retourne le nb total de personnages des autres joueurs
    {
        int n = 0;
        for(int i = 0; i < this.lesJ.getNbJoueurs(); i++)
        if (i !=this.indC)
        n+=this.lesJ.getJoueur(i).getNbCartes();
        return n;
    }
    public int TraiterTout(Joueur jo, int s){
        int bonus=-1;
        Personnage pers=this.lesPers.getPerso(s);
        jo.getPaquet().ajoutePerso(pers);
        String f=pers.getFamille();
        int nbf=this.lesPers.getPersosFamille(f).getTaille();
        int nbj=jo.getPaquet().getPersosFamille(f).getTaille();
        if(nbf==nbj){
            if(jo.getFamillePref().equals(f)){
                bonus=0;
               this.monP.termineJeu();
            }
            else{
                if(this.nbPers()>0){
                    if(f.equals("communs")|| f.equals("rares"))
                        bonus=1;
                    else
                        if(f.equals("alpins-femmes")||f.equals("as"))
                            bonus=3;
                        else
                            bonus=2;
                }
            }
        }
        return bonus;
    }

    
}
