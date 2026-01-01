/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
public class LesOperations
{
    private File contenu;
    
    public void add(Operation c)
    {
        contenu.enfile(c);
    }
    public Operation get(int rang)
    {
        return (Operation)contenu.getElement(rang);
    }

    public LesOperations()
    {
        contenu = new File();
    }
    
    public String toString()
    {
        return "Liste des opérations :\n"+this.contenu;
    }
}
