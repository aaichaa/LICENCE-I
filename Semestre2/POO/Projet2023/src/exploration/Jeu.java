/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Jeu
{

    private Joueur joueur;

    public Joueur getJoueur()
    {
        return joueur;
    }

    public void setJoueur(Joueur joueur)
    {
        this.joueur = joueur;
    }

    private Plateau grille;

    public Plateau getGrille()
    {
        return grille;
    }

    public void setGrille(Plateau grille)
    {
        this.grille = grille;
    }

    public Plateau getPlateau()
    {
        return grille;
    }

    public void setPlateau(Plateau plateau)
    {
        this.grille = plateau;
    }  
    
    public boolean isFini(){return this.getJoueur().isGagnant()||this.getJoueur().isPerdant();}

    public void joue()
    {
        int nbCoups = 0;
        Joueur joueur = this.getJoueur();
        do
        {
            System.out.println();
            Plateau.VISIBLE=false;
            System.out.println(this.getPlateau());
            
            System.out.println(joueur);
            System.out.println();
            char reponse;
            if(joueur.getNbPierres()==0)
            {
                reponse = 'a';
                System.out.println("Plus de pierres disponibles ; "+joueur.getNom()+" avance.");
            }
            else
                do
                {
                    reponse = Lire.c("Avancer ou lancer une pierre (a/p)");
                    if(reponse>='A' && reponse<='P')reponse = (char)(reponse-'a'+'A');
                }while(reponse !='a' && reponse!='p');
            Direction d = Direction.getDirectionJoueur("Choisis une direction");
                        System.out.println();
/*            Plateau.VISIBLE=true;
            System.out.println(this.getPlateau());*/

            System.out.println();
            if(reponse == 'a') {joueur.setDirectionCourante(d);joueur.avance();}
            else if(reponse == 'p') joueur.lancePierre(d);
            nbCoups++;
        }while(!isFini());
        Plateau.VISIBLE=true;
        System.out.println(this.getPlateau());
        if(this.getJoueur().isGagnant())
            System.out.println(this.getJoueur().getNom()+" a gagné en "+nbCoups+" coups.");
        else
            System.out.println(this.getJoueur().getNom()+" a perdu !");
    }
    
    public Jeu(int nbLig, int nbCol, int nbPierres,Categorie... liste)
    {
        this.setPlateau(new Plateau(nbCol,nbLig,this,liste));
        this.setJoueur(new Joueur(Lire.S("Nom du joueur"),this.getPlateau().get(1, 0),nbPierres*nbCol*nbLig/100));
        joue();
    }

}
