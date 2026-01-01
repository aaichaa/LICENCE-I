/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Mine extends Case
{

    private boolean active;

    public Mine(Plateau plateau, int lig, int col)
    {
        super(plateau, lig, col);
        this.setActive(true);
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    @Override
    public void place(Joueur j)
    {
        super.place(j);
        if (this.isActive())
        {
            this.setActive(false);
            j.perd("Boum ! Explosion sur une mine");
        }
    }

    @Override
    public void propagePierre(Joueur j, Direction d)
    {
        if (this.isActive())
        {
            System.out.println("Boum ! La mine a explosé. La pierre est perdue.");
            this.setVisible(true);
            this.setActive(false);
            j.decNbPierres();
        }
        else super.propagePierre(j, d);
    }

    @Override
    public String getSymbole()
    {
        return "*";
    }

}
