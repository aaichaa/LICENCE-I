public class Livre {
   private String titre;
   private String auteur;
   private int nbPages;

    public Livre(){
        this.titre = "El boulevard";
        this.auteur = "Marta";
        this.nbPages = 13;

    }
    public Livre(String titre, String auteur, int nbPages){
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
    }
    public String getTitre(){
        return titre;
    }
    public String getAuteur(){
        return auteur;
    }
    public int getNbPages(){
        return nbPages;
    }
    public void setNbPages(int nbPages){
        if(nbPages > 0){
            this.nbPages = nbPages;
        }else System.out.println("Erreur veuillez inserer un vrai nbPages ");
        
    }
    public void afficheDetails(){
        System.out.println("le livre s'appelle " + titre + " a pour auteur " + auteur + " et a " + nbPages + " pages");
    }

    
}
