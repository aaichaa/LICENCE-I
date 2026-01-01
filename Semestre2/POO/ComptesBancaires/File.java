/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class File
{
    // Variable d'instance contenu : un tableau qui reference des objets et qui represente le contenu de la file (support)
    private Object[] contenu;

    /**
     * renvoie la tête de la file sans effectuer de depilage
     * @return la reference a une instance de type "Object" 
     */
    public Object getTete()
    {
        if(this.isVide())return null; // renvoie une reference null si la file est vide
        else return this.contenu[0]; // renvoie la reference au premier objet entre dans la file
    }

    /**
     * affecte la queue de la file a une instance de type Object sans ajouter d'element.
     * Cette methode n'est utilisable qu'a l'interieur de l'instance (conceptuellement, on ne peut pas changer directement le contenu de la file)
     * 
     * @param  nouveau   un nouvel objet a affecter au sommet de la file
     */
    private void setQueue(Object nouveau)
    {
        if(!this.isVide()) // n'a de sens que si la file est non vide
        {
            this.contenu[this.getTaille()-1]=nouveau;
        }
    }

    /**
     * Enfile une nouvelle instance de la classe Object en queue de file
     * 
     * @param  nouveau   Nouvel objet a enfiler.
     */   
    public void enfile(Object nouveau)
    {
        Object[] temp=new Object[this.getTaille()+1]; // creation d'un nouveau support pour la file, comportant un élément de plus
        for(int i=0;i<this.getTaille();i++)temp[i]=this.contenu[i]; // recopie l'ancien support dans le nouveau
        this.contenu=temp;
        setQueue(nouveau);
    }

    /**
     * Defile la tête de la file
     */   
    public void defile()
    {
        if(!isVide()) // depilage seulement quand la file n'est pas vide
        {
            Object[] temp=new Object[this.getTaille()-1]; // creation d'un nouveau support pour la file, comportant un élément de moins
            for(int i=0;i<temp.length;i++)temp[i]=this.contenu[i+1]; // recopie l'ancien support dans le nouveau
            this.contenu=temp;
        }
    }
    
    /**
     * restitue un élément de la file à partir de son rang >=1
     * @param  rang   rang — à partir de 1 — de l'élément à restituer 
     * @return  l'élément à restituer
     */       
    public Object getElement(int rang)
    {
        if(rang<0||rang>getTaille())return null;
        else return this.contenu[rang-1];
    }

    /**
     * indique si la file est vide ou non
     * 
     * @return  "true" si la file est vide ; "false" sinon
     */   
    public boolean isVide(){return getTaille()==0;}

    /**
     * renvoie la taille de la file
     * 
     * @return  le nombre d'elements presents dans la file
     */   
    public int getTaille()
    {
        return this.contenu.length;
    }

    /**
     * Constructeur des objets de la classe File. Uniquement le constructeur par défaut
     */
    public File()
    {
        this.contenu=new Object[0];// creation d'une file vide
    }
    
    public String toString()
    {
        String affichage="";
        for(int i=0;i<getTaille();i++){affichage=affichage+contenu[i]+"\n";}
        return affichage;
    }
}
