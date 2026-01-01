

import java.util.ArrayList;
import javax.swing.ImageIcon;



public class GalerieArt extends javax.swing.JFrame {
    private ArrayList<PeintureIA> lstIA;
    private final String tabGen[]={"MyEdit","MidJourney","Dalle-e","Fotor","Craiyon"};
    
    public GalerieArt() {
        initComponents();
        this.lstIA=new ArrayList<>();
        creationPeinturesTest();
        initListeGenerateurs();
        afficheInfos(this.lstIA,"Peintures de la galerie");
    }

    public String[] getTabGen() {
        return tabGen;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Phaut = new javax.swing.JPanel();
        LTitre = new javax.swing.JLabel();
        PGauche = new javax.swing.JPanel();
        BPeintures = new javax.swing.JButton();
        LGenerateur = new javax.swing.JLabel();
        ListeGenerateurs = new javax.swing.JComboBox<>();
        LNumero = new javax.swing.JLabel();
        Numero = new javax.swing.JTextField();
        BChercher = new javax.swing.JButton();
        PCentre = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        BPeinture = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MVisiter = new javax.swing.JMenu();
        MGenerateurs = new javax.swing.JMenuItem();
        MArtistes = new javax.swing.JMenuItem();
        MGestion = new javax.swing.JMenu();
        MAjouter = new javax.swing.JMenuItem();
        MModifier = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LTitre.setText("Galerie d'art IA");
        Phaut.add(LTitre);

        getContentPane().add(Phaut, java.awt.BorderLayout.NORTH);

        PGauche.setLayout(new java.awt.GridLayout(10, 1));

        BPeintures.setText("Peintures");
        BPeintures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPeinturesActionPerformed(evt);
            }
        });
        PGauche.add(BPeintures);

        LGenerateur.setText("Génrateur ?");
        PGauche.add(LGenerateur);

        ListeGenerateurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeGenerateursActionPerformed(evt);
            }
        });
        PGauche.add(ListeGenerateurs);

        LNumero.setText("Numéro ?");
        PGauche.add(LNumero);
        PGauche.add(Numero);

        BChercher.setText("Chercher");
        BChercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BChercherActionPerformed(evt);
            }
        });
        PGauche.add(BChercher);

        getContentPane().add(PGauche, java.awt.BorderLayout.WEST);

        PCentre.setLayout(new java.awt.GridLayout(2, 1));

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        PCentre.add(jScrollPane1);
        PCentre.add(BPeinture);

        getContentPane().add(PCentre, java.awt.BorderLayout.CENTER);

        MVisiter.setText("Visiter");

        MGenerateurs.setText("Générateurs");
        MVisiter.add(MGenerateurs);

        MArtistes.setText("Artistes");
        MVisiter.add(MArtistes);

        jMenuBar1.add(MVisiter);

        MGestion.setText("Gestion");

        MAjouter.setText("Ajouter");
        MAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAjouterActionPerformed(evt);
            }
        });
        MGestion.add(MAjouter);

        MModifier.setText("Modifier");
        MGestion.add(MModifier);

        jMenuBar1.add(MGestion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void creationPeinturesTest() 
{
    PeintureIA p= new PeintureIA("Souris","Dalle-e");
    p.setAuteur("Lucie");
    p.setPeinture(new ImageIcon(getClass().getResource("/Img/SourisD.jpg")));
    lstIA.add(p);
     p= new PeintureIA("Joueur","Dalle-e");
    p.setAuteur("Lucie");
    p.setPeinture(new ImageIcon(getClass().getResource("/Img/JoueurD.jpg")));
    lstIA.add(p);
    p= new PeintureIA("Fille","MyEdit");
    p.setAuteur("Julie");
    p.setPeinture(new ImageIcon(getClass().getResource("/Img/FilleME.png")));
    lstIA.add(p);
    p= new PeintureIA("Champignon","Craiyon");
    p.setAuteur("Paul");
    p.setPeinture(new ImageIcon(getClass().getResource("/Img/ChampignonC.png")));
    lstIA.add(p);
}

private void initListeGenerateurs()
{
    for (int i=0; i<tabGen.length; i++)
        ListeGenerateurs.addItem(tabGen[i]);
}
        
    
    public ArrayList<PeintureIA> rechPeintures(String gen)
    {   ArrayList<PeintureIA> lpgen= new ArrayList<>();
        for (int i=0; i<this.lstIA.size();i++)
        {   PeintureIA p= this.lstIA.get(i);
            if (this.lstIA.get(i).getGenerateur().equals(gen))
                lpgen.add(p);
        }
        return lpgen;
    }
    
    private void ListeGenerateursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeGenerateursActionPerformed
    int ind = ListeGenerateurs.getSelectedIndex();
    String gen = ListeGenerateurs.getSelectedItem().toString();
    
    ArrayList<PeintureIA> lst=this.rechPeintures(gen);
    afficheInfos(lst, "Peintures du générateur : "+gen);
    this.BPeinture.setIcon(null);

    }//GEN-LAST:event_ListeGenerateursActionPerformed

    private void BChercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BChercherActionPerformed
        // TODO add your handling code here:
         if ( ! (Numero.getText().equals("")))
        {
        int num = Integer.parseInt(Numero.getText());
        if (num >=1 && num <= this.lstIA.size())
        {
        PeintureIA p=this.lstIA.get(num-1);
        Edition.setText("Peinture sélectionnée\n\n");
        Edition.append(p.toString());
        this.BPeinture.setIcon(this.lstIA.get(num-1).getPeinture());
        }
        }
    }//GEN-LAST:event_BChercherActionPerformed

    private void BPeinturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPeinturesActionPerformed
        // TODO add your handling code here:
       afficheInfos(this.lstIA, "Peintures de la galerie");
       this.BPeinture.setIcon(null);
            
    }//GEN-LAST:event_BPeinturesActionPerformed

    private void MAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAjouterActionPerformed
        // TODO add your handling code here:
        SaisiePeintureDlg diag = new SaisiePeintureDlg(this,true);
        diag.setVisible(true);
        if(diag.getOk() == true){
            PeintureIA p = diag.getPn(); 
            this.lstIA.add(p);
        }
        
        
        
    }//GEN-LAST:event_MAjouterActionPerformed

private void afficheInfos(ArrayList<PeintureIA> lp, String mess)
{   Edition.setText(mess+"\n\n");
    for (int i=0; i<lp.size(); i++)
           {   Edition.append("Peinture N° : "+(i+1)+"\n");
               Edition.append(lp.get(i).toString()+"\n");
            }
}
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GalerieArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GalerieArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GalerieArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GalerieArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GalerieArt pt= new GalerieArt();
                pt.setSize(800,600);
                pt.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BChercher;
    private javax.swing.JButton BPeinture;
    private javax.swing.JButton BPeintures;
    private javax.swing.JTextArea Edition;
    private javax.swing.JLabel LGenerateur;
    private javax.swing.JLabel LNumero;
    private javax.swing.JLabel LTitre;
    private javax.swing.JComboBox<String> ListeGenerateurs;
    private javax.swing.JMenuItem MAjouter;
    private javax.swing.JMenuItem MArtistes;
    private javax.swing.JMenuItem MGenerateurs;
    private javax.swing.JMenu MGestion;
    private javax.swing.JMenuItem MModifier;
    private javax.swing.JMenu MVisiter;
    private javax.swing.JTextField Numero;
    private javax.swing.JPanel PCentre;
    private javax.swing.JPanel PGauche;
    private javax.swing.JPanel Phaut;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
