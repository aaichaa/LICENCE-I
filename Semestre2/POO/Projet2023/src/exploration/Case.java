/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public abstract class Case
{
    private boolean vue;
    
    public boolean isVue()
    {
        return vue;
    }

    public void setVue(boolean vue)
    {
        this.vue = vue;
    }
    
    private static char getNumChar(int num){return (char)('A'+num-1);}
    
    private Plateau plateau;
    
    protected Plateau getPlateau()
    {
        return this.plateau;
    }

    private void setPlateau(Plateau plateau)
    {
        this.plateau = plateau;
    }

    private int lig;
    public int getLig()
    {
        return this.lig;
    }
    public char getLigchar(){return Case.getNumChar(this.getLig());}

    private void setLig(int lig)
    {
        this.lig = lig;
    }

    private int col;
    public int getCol()
    {
        return this.col;
    }
    public char getColchar(){return Case.getNumChar(this.getCol());}

    private void setCol(int col)
    {
        this.col = col;
    }

    private boolean visible;
    public boolean isVisible()
    {
        return this.visible||Plateau.VISIBLE;
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
    
    private boolean occupee;
    
    public boolean isOccupee()
    {
        return this.occupee || (this.visible&&Plateau.VISIBLE);
    }

    public void setOccupee(boolean occupee)
    {
        this.occupee = occupee;
        this.setVisible(true);
    }
    public void place(Joueur j)
    {
        j.setPosition(this);
    }

    public void propagePierre(Joueur j,Direction d)
    {
        System.out.println(this.getNom());
        Case suivante = this.getSuivante(d);
        //System.out.println(this.getNom()+" -> "+suivante.getNom());
        if(this.isVue()) System.out.println("Boucle ! Pierre perdue");
        else
        {
            this.setVue(true);
            suivante.propagePierre(j,d);
            this.setVue(false);
        }
    }
    // ALTERNATIVE AVEC UNE PIERRE DE TYPE MOBILE
    public void placePierre(Pierre p)
    {
        Case suivante = this.getSuivante(p.getDirectionCourante());
        if(this!=suivante)
        {
            
        }
    }

    public abstract String getSymbole();
    
    @Override
    public  String toString()
    {
        String motif = this.getSymbole();
        if(this.isOccupee())motif = motif+"♜";
        else motif = motif+motif;
        if(this.isVisible()) return motif;
        else return "  ";
    }
    
    public String getNom(){return "("+this.getLigchar()+","+this.getColchar()+")";}
    
    public Case getSuivante(Direction d)
    {
        Case suivante = this.getPlateau().get(this.getLig()+d.getdLig(), this.getCol()+d.getdCol());
        if(suivante == null || this.isVue()) return this;
        else return suivante;
    }

    public Case(Plateau plateau, int lig, int col)
    {
        this.setPlateau(plateau);
        this.setLig(lig);
        this.setCol(col);
        this.setVisible(false);
        this.setVue(false);
    }
    
}
