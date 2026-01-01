
import javax.swing.ImageIcon;


public class PeintureIA {
    private String titre;
    private String generateur;
    private String auteur;
    private ImageIcon peinture;

    public PeintureIA(String titre, String generateur) {
        this.titre = titre;
        this.generateur = generateur;
        this.auteur="Inconnu";
        this.peinture=new ImageIcon(getClass().getResource("/Img/ImageDefaut.jpg"));
    }
    public PeintureIA(){
        this.titre = "Saisi";
        this.generateur = "MyEdit";
        this.auteur = "inconnu";
    }
    public String getTitre() {return titre;}
    public void setTitre(String titre) {this.titre = titre;}
    public String getGenerateur() { return this.generateur; }
    public void setGenerateur(String generateur) { this.generateur = generateur; }
    public String getAuteur() {return auteur;}
    public void setAuteur(String auteur) {this.auteur = auteur;}
    public ImageIcon getPeinture() {return peinture;}
    public void setPeinture(ImageIcon peinture) {this.peinture = peinture;}

    public String toString() {
        String s="";
        s+="Titre : "+this.titre+"\n";
        s+="Génerateur : "+this.generateur+"\n";
        s+="Auteur : "+this.auteur+"\n";   
        return s;
    }
    
    
}
