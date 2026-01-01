/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Mobile
{
    private boolean perdu;
    public boolean isPerdu()
    {
        return this.perdu;
    }

    private void setPerdu(boolean perdu)
    {
        this.perdu = perdu;
    }
    public void setDetruit(String raison)
    {
        System.out.println(raison);
        setPerdu(true);
    }

    private Case position;

    public Case getPosition()
    {
        return position;
    }

    public void setPosition(Case position)
    {
        this.position = position;
        position.setOccupee(true);
    }
    
    private Direction directionCourante;

    /**
     * Get the value of directionCourante
     *
     * @return the value of directionCourante
     */
    public Direction getDirectionCourante()
    {
        return this.directionCourante;
    }

    /**
     * Set the value of directionCourante
     *
     * @param directionCourante new value of directionCourante
     */
    public void setDirectionCourante(Direction directionCourante)
    {
        this.directionCourante = directionCourante;
    }

    public Mobile(Case position, Direction direction)
    {
        this.setPosition(position);
        this.setDirectionCourante(direction);  
        this.setPerdu(false);
    }
    
    public Mobile(Case position)
    {
        this(position,null);
    }
}
