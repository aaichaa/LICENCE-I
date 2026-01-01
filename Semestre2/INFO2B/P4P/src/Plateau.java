/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author BOBO
 */
public class Plateau {
    private Case tab[][];

    public Plateau()
    { this.tab = new Case [4][4];
    initPlateau();
    }

    private void initPlateau()
    { for (int i=0; i<4;i++)
    for (int j=0; j<4; j++)
    this.tab[i][j]= new Case();
    }

    public boolean caseValide(int x, int y)
    { return x >=0 && x<=3 && y>=0 && y <=3;
    }

    public Case getCase(int x, int y)
    { if (caseValide(x,y))
    return tab[x][y];
    else return null;
    }

    public int getSommetCase (int x, int y)
    { if (caseValide(x,y))
    return getCase(x,y).getSommetCase();
    else return -1;
    }

    public void deposePionCase(int val, int x, int y)
    { 
        if(caseValide(x,y))
            this.tab[x][y].empilePion(val);
         // getCase(x,y).empilePion(val);
    }

    public void initPlateauJeu()
    {
        this.deposePionCase(0, 0, 0);
        this.deposePionCase(0, 0, 0);
        this.deposePionCase(0, 0, 3);
        this.deposePionCase(0, 0, 3);
        this.deposePionCase(0, 3, 0);
        this.deposePionCase(0, 3, 0);
        
        this.deposePionCase(0, 3, 3);
        this.deposePionCase(0, 3, 3);
        
    }
    
    public void afficheValPlateau()
    {
        for (int i=0; i<4;i++){
            for (int j=0; j<4;j++){
                if(this.getCase(i, j).estVide())
                    System.out.print(" VIDE ");
                else
                    for (int k=0; k<this.getCase(i, j).getNbPions();k++) 
                        System.out.print(this.getCase(i, j).getValCase(k));
            } System.out.println("");
         } System.out.print(" ");
        
    }

}
