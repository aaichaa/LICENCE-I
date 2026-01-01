public class Personne {
    
    //attributs
    private int id;
    private String nom;
    private String prenom;
    private int age;
   
    //constructeurs
    public Personne(int id, String nom, String prenom, int age){ //avec parametres
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    public Personne(){// par defaut
        this.id = 1;
        this.nom = "DIALLO";
        this.prenom = "Aissatou Bobo";
        this.age = 20;

    }
    //getters et setters 
    public int getId(){
        return id;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age >= 0){
            this.age = age;
        }else{
            System.out.println("c'est invalide, merci");
        }
    }

    //creation d'un contructeur

}
    
