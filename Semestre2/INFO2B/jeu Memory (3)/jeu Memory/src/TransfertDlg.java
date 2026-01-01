
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author hb457449
 */
public class TransfertDlg extends javax.swing.JDialog {

    /**
     * Creates new form TransfertDlg
     */
    public TransfertDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj,int indj) {
        super(parent, modal);
        initComponents();
        this.lj = lj;
        this.indj = indj ;
        this.tc=null;
        this.ok=false;
        this.fs=null;
        initCombo(); // méthode pour remplir la liste déroulante
        indjs = 0;
        Message.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");
        Infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());
        ComboJoueurs.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ComboJoueursActionPerformed(evt);
        }
        });
        this.tc= new Transfert(this.lj.getJoueur(indj),this.lj.getJoueur(indjs),fs); 
   }
    public TransfertDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private LesJoueurs lj; //collection des joueurs, pour initialiser la liste déroulante avec les pseudos des joueurs
    private int indj; //indice joueur courant
    private Transfert tc; // cette classe sera étudiée ultérieurement – laisser l’attribut en commentaire
    private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
    private int indjs; //indice du joueur sélectionné dans la liste déroulante
    private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné

   public LesJoueurs getLj() {
        return this.lj;
    }

    public int getIndj() {
        return this.indj;
    }
    public void setLj(LesJoueurs lj) {
        this.lj = lj;
    }

    public boolean isOk() {
        return this.ok;
    }

    public int getIndjs() {
        return this.indjs;
    }
    public String getFs() {
        return this.fs;
    }

    public Transfert getTc() {
       return this.tc;
    }
    public void initCombo() {
        for(int i=0;i<this.lj.getNbJoueurs();i++){
            ComboJoueurs.addItem(lj.getJoueur(i).getPseudo());
        }
    }
    public void initPanneau(JPanel jp,LesPersonnages lp) {
        if (ComboJoueurs.getSelectedIndex() != -1) {
        jp.removeAll();
        this.repaint();
        //LesPersonnages lcs= this.lj.getJoueur(this.indjs).getPaquet();
        int t = lp.getTaille();
        int n = 1+(t-1)/4;
        jp.setLayout(new java.awt.GridLayout(4, n));
        for(int i=0; i<t;i++){
            JButton bt= new JButton();
            bt.setName(lp.getPerso(i).getFamille());
            if(jp==PanneauG){
                bt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    boutonActionPerformed(evt);
                }
            });  }          
            jp.add(bt);
        }
        this.pack();
        } 
    }
    /*public void creePanneau(){
        ArrayList<JButton> btSelectionne= new ArrayList<>();
        JButton bt;
        for(int i=0; i<PanneauG.getComponentCount(); i++){
            bt = (JButton) PanneauG.getComponent(i);
            if(bt.getBorder() != null){
                btSelectionne.add(bt);
            }
        }
        if(btSelectionne.size()!=0){
            PanneauD.removeAll();
            int t=btSelectionne.size();
            int n = 1+(t-1)/+4;
            PanneauD.setLayout(new java.awt.GridLayout(4, n));
            for(int i=0; i<btSelectionne.size();i++){
                JButton bouton = btSelectionne.get(i);
                PanneauG.remove(bouton);
                PanneauG.repaint();
                PanneauD.add(bouton);
                PanneauD.repaint();
            }
        }
        
    }
    public void dessinePanneau(JPanel jp,LesPersonnages lp){
        
        for(int i=0;i<lp.getTaille();i++){
            JButton bt=(JButton) jp.getComponent(i);
            bt.setIcon(new ImageIcon(lp.getPerso(i).getPhoto().getScaledInstance(bt.getWidth(),bt.getHeight(), Image.SCALE_SMOOTH)));
        }
    }
    /*public void creePanneau(JPanel jp,LesPersonnages lp){
        int np=lp.getTaille();
        //int t=lp.getTaille();
        int n = 1+(np-1)/4;
        jp.setLayout(new java.awt.GridLayout(4, n));
        for(int i=0;i<np;i++){
            JButton bt= new JButton();
            jp.add(bt);
        }
    }*/
    public void affichePanneau(JPanel jp,LesPersonnages lp) {
        //LesPersonnages ljp= lj.getJoueur(indjs).getPaquet();
        for(int i=0;i<lp.getTaille();i++){
            JButton bt= (JButton) jp.getComponent(i);
            bt.setIcon(new ImageIcon (lp.getPerso(i).getPhoto().getScaledInstance(bt.getWidth(),bt.getHeight(), Image.SCALE_SMOOTH)));
            //jp.add(bt);
        }
    }
     private void boutonActionPerformed(java.awt.event.ActionEvent evt)
    {
        LesPersonnages lp = lj.getJoueur(indjs).getPaquet(); 
        int t = lp.getTaille();
        JButton bt=(JButton) evt.getSource();
        fs = bt.getName(); // la proprité Name, contient ici le nom du personnage affiché sur le bouton
        for(int i = 0; i < t; i++) {
            JButton b = (JButton)(PanneauG.getComponent(i));
            if (b.getName().equals(fs))
                b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));
            else
                b.setBorder(null);
        }
        LesPersonnages lps = lp.getPersosFamille(fs);
        Infos.setText("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps);
    }
     private void ComboJoueursActionPerformed(java.awt.event.ActionEvent evt) { 
       this.indjs = ComboJoueurs.getSelectedIndex();
       
       if (indjs != -1){
       if (this.indjs == this.indj) {
       Infos.setText("Sélectionnez un joueur différent du joueur courant !");
       PanneauG.removeAll();
       PanneauG.repaint();
       }
       else {
        Infos.setText("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString());
        initPanneau(PanneauG,lj.getJoueur(indjs).getPaquet());
        affichePanneau(PanneauG,lj.getJoueur(indjs).getPaquet());
       }
       }
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        PanneauG = new javax.swing.JPanel();
        PanneauInfo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ComboJoueurs = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Infos = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        transfert = new javax.swing.JButton();
        fermer = new javax.swing.JButton();
        PanneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        PanneauG.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanneauG);

        PanneauInfo.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setLayout(new java.awt.GridLayout(6, 1));
        jPanel4.add(Message);
        jPanel4.add(jLabel1);
        jPanel4.add(jLabel3);
        jPanel4.add(jLabel5);
        jPanel4.add(jLabel6);

        PanneauInfo.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel5.add(ComboJoueurs, java.awt.BorderLayout.NORTH);

        Infos.setColumns(20);
        Infos.setRows(5);
        jScrollPane1.setViewportView(Infos);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        transfert.setText("Transfert");
        transfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfertActionPerformed(evt);
            }
        });
        jPanel6.add(transfert);

        fermer.setText("Fermer");
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });
        jPanel6.add(fermer);

        jPanel5.add(jPanel6, java.awt.BorderLayout.SOUTH);

        PanneauInfo.add(jPanel5);

        getContentPane().add(PanneauInfo);

        PanneauD.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanneauD);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transfertActionPerformed
        // TODO add your handling code here:
        this.tc=new Transfert(lj.getJoueur(indj),lj.getJoueur(indjs),fs);
        this.tc.execute();
        LesPersonnages lp=tc.getCartestransferees();
        initPanneau(PanneauD,lp);
        affichePanneau(PanneauD,lp);
        LesPersonnages lps=lj.getJoueur(indjs).getPaquet();
        initPanneau(PanneauG,lps);
        affichePanneau(PanneauG, lps);
        this.ok=true;
        transfert.setEnabled(false);
        ComboJoueurs.setEnabled(false);
    }//GEN-LAST:event_transfertActionPerformed

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        // TODO add your handling code here:
        this.dispose();
        setVisible(false);
    }//GEN-LAST:event_fermerActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TransfertDlg dialog = new TransfertDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboJoueurs;
    private javax.swing.JTextArea Infos;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel PanneauD;
    private javax.swing.JPanel PanneauG;
    private javax.swing.JPanel PanneauInfo;
    private javax.swing.JButton fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton transfert;
    // End of variables declaration//GEN-END:variables
}
