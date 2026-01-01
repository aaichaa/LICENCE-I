/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class LesComptes
{
    private File contenu;
    
    public void add(Compte c)
    {
        contenu.enfile(c);
    }
    public Compte get(int rang)
    {
        return (Compte)contenu.getElement(rang);
    }

    public LesComptes()
    {
        contenu = new File();
    }
    
    @Override
    public String toString()
    {
        return "Liste des comptes :\n============================\n"+this.contenu;
    }
    public double getSoldeTotal()
    {
        double soldeTotal=0;
        for(int i=1;i<=contenu.getTaille();i++)
        {
            soldeTotal=soldeTotal+this.get(i).getSolde();
        }
        return soldeTotal;
    }
}
