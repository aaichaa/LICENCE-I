
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author BOBO
 */
public class P4P extends javax.swing.JFrame {

    private LesJoueurs listeJ;
    private Joueur joueur1;
    private Joueur joueur2;
    private int joueurCourant; // numéro du joueur courant
    private Jeu lejeu;
    private Plateau PJeu;
    private LesParties lp;

    private int xsel, ysel; // indices (xsel,ysel) de la case sélectionnée
// par un joueur lors de son tour de jeu, case où il dépose son pion
    private Case caseCourante; // caseCourante - copie de la case sélectionnée pour le tour du joueur
    private int nbPionsDepot; // nombre de pions de cette caseCourante, i.e. nombre de pions à égrainer

    private int xd, yd; // position (xd, yd) où le joueur a effectué son dernier dépôt
    private int pxd, pyd; // position (pxd, pyd) : position précédente du dernier dépôt
// effectué (pour éviter les retours en arrière)
    private int compt; // compteur pour compter le nombre de coups d'une partie
    private boolean selection; // indicateur pour savoir si c'est le début du tour d'un joueur,
// ou s'il est en cours d'égrainage
    private boolean finPartie; // indicateur pour savoir si la partie est terminée
    private int nbgj1; // nombre de galets du joueur1
    private int nbgj2; // nombre de galets du joueur2
    private int xa, ya;

    /**
     * Creates new form P4P
     */
    public P4P() {
        initComponents();
        initPanneau();
        this.listeJ = new LesJoueurs();
        this.lp = new LesParties();
        this.listeJ.creationJoueursTest(this.lp);
        this.joueur1 = this.listeJ.getJoueur(0);
        this.joueur2 = this.listeJ.getJoueur(1);
        this.lejeu = new Jeu();
        this.PJeu = lejeu.getPlateau();
        this.PJeu.afficheValPlateau();
        this.joueurCourant = 1;
        this.nbgj1 = 8;
        this.nbgj2 = 8;
        this.compt = 0;
        this.caseCourante = null;
        this.selection = false;
        this.finPartie = false;
        Message.setText("C'est au joueur 1 de jouer");
        afficheJoueurs();
        affichePanneau();
    }

    public void afficheJoueurs() {
        LPseudoJ1.setText(joueur1.getPseudo());
        BPhotoJ1.setIcon(this.joueur1.getPhoto());
        LPseudoJ2.setText(joueur2.getPseudo());
        BPhotoJ2.setIcon(this.joueur2.getPhoto());

    }

    private void initPanneau() {
        for (int i = 0; i < 16; i++) {
            JPanel pan = new JPanel();
            pan.setLayout(new GridLayout(2, 1));
            JButton BH = new JButton();
            BH.setName("" + i);
            BH.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    boutonActionPerformed(evt);
                }
            });

            pan.add(BH);
            JPanel PB = new JPanel();
            pan.add(PB);
            PCenter.add(pan);
        }

    }

    private void boutonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!finPartie) {
            JButton jb = (JButton) evt.getSource();
            int num = Integer.parseInt(jb.getName());
            int x = num / 4;
            int y = num - x * 4;
            MessageErreur.setText(""); // JLabel nommé MessageErreur à côté de la zone Message
            // pour afficher des messages d'erreurs pendant le jeu
            if (this.selection == false) // C'est le début d'un tour de jeu
            {
                if (PJeu.getCase(x, y).estVide()) {
                    this.MessageErreur.setText("Case vide !");
                } // Il est interdit de déposer un pion sur une case vide
                else {
                    this.compt++;
                    selection = true; // indicateur pour indiquer qu'on est au cours d'un tour de jeu (phase d'égrainage)
                    this.xsel = x;
                    this.ysel = y; // position initiale cliquée (xsel,ysel) pour le dépôt du pion du joueur
                    this.xd = x;
                    this.yd = y; // position de dépôt du galet (ici position initiale)
                    this.pxd = -1;
                    this.pyd = -1; // position précédente du dernier dépôt (ici pas de précédent)

                    this.PJeu.deposePionCase(joueurCourant, xsel, ysel); // A COMMENTER

                    // on duplique la case sélectionnée dans la case courante
                    this.caseCourante = new Case();
                    for (int i = 0; i < this.PJeu.getCase(xsel, ysel).getNbPions(); i++) {
                        this.caseCourante.empilePion(this.PJeu.getCase(xsel, ysel).getValCase(i));
                    }

                    this.nbPionsDepot = this.caseCourante.getNbPions();
                    // nombre de pions sur cette case sélectionnée (y compris le pion que l'on vient de déposer)
                    affichePanneau(); // affichage du panneau avec ce pion
                    afficheCaseCourante();
                    //affichage en partie droite de la pile des galets qui seront à déposer (pour plus de facilité pour jouer)

                    this.PJeu.getCase(xsel, ysel).videCase();
                }
            } else {
                if (this.nbPionsDepot != 0) // s'il reste des pions à poser
                {
                    this.xa = x;
                    this.ya = y; // (xa, ya) est la position choisie pour déposer (clic sur cette case par le joueur)
                    int val = this.caseCourante.getValCase(0); // récupération de la valeur du pion à déposer
                    int code;
                    code = this.lejeu.jouePion(pxd, pyd, xd, yd, xa, ya, val); // A COMMENTER
                    if (code == 0) // le pion a été déposé sur une case correcte (adjacente sans retour arrière)
                    {
                        this.nbPionsDepot--; // on décrémente le nombre de pions à déposer
                        this.caseCourante.defilePion(); // on supprime ce pion de la case initiale
                        pxd = xd;
                        pyd = yd;
                        xd = xa;
                        yd = ya; // on remet à jour les positions
                        affichePanneau();
                        afficheCaseCourante(); // on réaffiche le jeu plateau et les galets à déposer
                        if (this.nbPionsDepot == 0) // s'il n'y a plus de pions
                        {
                            traiteFinTour(); // on traite la fin du tour (changement de joueur ou fin de partie)
                        }
                    } else {
                        this.MessageErreur.setText("Mouvement Impossible");
                    }
                }
            }
        }

    }

    private void traiteFinTour() {
        this.selection = false;
        this.PJeu.afficheValPlateau(); // affichage console pour vérifier les valeurs du plateau (de type Plateau)
        if (this.lejeu.gagne(joueurCourant)) {
            Message.setText("joueur " + joueurCourant + " a gagné");
            Partie part = new Partie(this.joueur1, this.joueur2, this.compt, this.joueurCourant);
            this.lp.ajoutePartie(part);

            if (joueurCourant == 1) {
                joueur1.ajoutPartieJoue(joueur2, 1);  // Gagné
                joueur2.ajoutPartieJoue(joueur1, -1); // Perdu
            } else {
                joueur2.ajoutPartieJoue(joueur1, 1);  // Gagné
                joueur1.ajoutPartieJoue(joueur2, -1); // Perdu
            }
            

            this.compt = 0;
            this.finPartie = true;
        } else if (this.joueurCourant == 1) {
            this.joueurCourant = 2;
            if (this.nbgj2 == 0) {
                Message.setText("Match nul");
                this.finPartie = true;
            } else {
                Message.setText("C'est au joueur 2 de jouer");
            }
        } else {
            this.joueurCourant = 1;
            if (this.nbgj1 == 0) {
                Message.setText("Match nul");
                this.finPartie = true;
            } else {
                Message.setText("C'est au joueur 1 de jouer");
            }
        }
        affichePanneau();

    }

    private void affichePanneau() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = i * 4 + j;
                JPanel pan = (JPanel) PCenter.getComponent(num);
                JButton BH = (JButton) pan.getComponent(0);
                int val = this.PJeu.getSommetCase(i, j);
                //fixer la valeur du bouton BH en fonction du sommet de la case
                switch (val) {
                    case -1:
                        BH.setBackground(Color.yellow);
                        break;//case vide
                    case 0:
                        BH.setBackground(Color.orange);
                        break;//pion neutre
                    case 1:
                        BH.setBackground(Color.red);
                        break;//joueur 1
                    case 2:
                        BH.setBackground(new Color(101, 52, 0));
                        break; //joueur2
                }

                JPanel PB = (JPanel) pan.getComponent(1);
                PB.setBackground(Color.yellow);
                PB.removeAll();
                Case c = PJeu.getCase(i, j);
                int nbPions = c.getNbPions();
                PB.setLayout(new GridLayout(1, nbPions));
                for (int k = 0; k <= nbPions - 2; k++) {
                    JButton btPion = new JButton();
                    int value = c.getValCase(k);
                    //fixer la couleur du bouton pion
                    switch (value) {
                        case 0:
                            btPion.setBackground(Color.orange);
                            break;
                        case 1:
                            btPion.setBackground(Color.red);
                            break;
                        case 2:
                            btPion.setBackground(new Color(101, 52, 0));
                            break;
                    }
                    PB.add(btPion);

                }

                //this.pack();
                this.PCenter.validate();
                this.PCenter.repaint();
                // this.setSize(800, 600);

            }
        }

    }

    private void afficheCaseCourante() {
        if (this.caseCourante != null) {
            PPions.removeAll();
            //int nbPions=this.caseCourante.getNbPions();
            int nbPions = this.nbPionsDepot;
            PPions.setLayout(new GridLayout(nbPions, 1));
            for (int k = 0; k < nbPions; k++) {
                JButton panPion = new JButton();
                int v = this.caseCourante.getValCase(k);
                switch (v) {
                    case 0 ->
                        panPion.setBackground(Color.orange);
                    case 1 ->
                        panPion.setBackground(Color.red);
                    case 2 ->
                        panPion.setBackground(new Color(101, 51, 0));
                }
                PPions.add(panPion);
            }
        } else {
            PPions.removeAll();
        }
        //this.pack();
        this.PPions.validate();
        this.PPions.repaint();
        //this.setSize(800, 600);
        // this.setLocation(200, 200);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PCenter = new javax.swing.JPanel();
        PSouth = new javax.swing.JPanel();
        MessageErreur = new javax.swing.JLabel();
        Message = new javax.swing.JTextField();
        PEast = new javax.swing.JPanel();
        LDroit = new javax.swing.JLabel();
        PPions = new javax.swing.JPanel();
        PWest = new javax.swing.JPanel();
        PJoueur1 = new javax.swing.JPanel();
        PInfoJ1 = new javax.swing.JPanel();
        LJoueur1 = new javax.swing.JLabel();
        LPseudoJ1 = new javax.swing.JLabel();
        BJoueur1 = new javax.swing.JButton();
        PPhotoJ1 = new javax.swing.JPanel();
        BPhotoJ1 = new javax.swing.JButton();
        PJoueur2 = new javax.swing.JPanel();
        PInfoJ2 = new javax.swing.JPanel();
        LJoueur2 = new javax.swing.JLabel();
        LPseudoJ2 = new javax.swing.JLabel();
        BJoueur2 = new javax.swing.JButton();
        PPhotoJ2 = new javax.swing.JPanel();
        BPhotoJ2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MJeu = new javax.swing.JMenu();
        MRejoueur = new javax.swing.JMenuItem();
        MQuitter = new javax.swing.JMenuItem();
        MJoueurs = new javax.swing.JMenu();
        MSelectionner = new javax.swing.JMenuItem();
        MAjouter = new javax.swing.JMenuItem();
        MVisualiser = new javax.swing.JMenuItem();
        MStatistiques = new javax.swing.JMenu();
        MClassement = new javax.swing.JMenuItem();
        MScore = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PCenter.setLayout(new java.awt.GridLayout(4, 4));
        getContentPane().add(PCenter, java.awt.BorderLayout.CENTER);

        MessageErreur.setText("Message :");
        PSouth.add(MessageErreur);

        Message.setMinimumSize(new java.awt.Dimension(80, 22));
        Message.setPreferredSize(new java.awt.Dimension(200, 22));
        PSouth.add(Message);

        getContentPane().add(PSouth, java.awt.BorderLayout.PAGE_END);

        PEast.setLayout(new java.awt.GridLayout(4, 1));

        LDroit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LDroit.setText("Galets à déposer");
        PEast.add(LDroit);

        PPions.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout PPionsLayout = new javax.swing.GroupLayout(PPions);
        PPions.setLayout(PPionsLayout);
        PPionsLayout.setHorizontalGroup(
            PPionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PPionsLayout.setVerticalGroup(
            PPionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        PEast.add(PPions);

        getContentPane().add(PEast, java.awt.BorderLayout.LINE_END);

        PWest.setLayout(new java.awt.GridLayout(2, 1));

        PJoueur1.setLayout(new java.awt.GridLayout(2, 1));

        PInfoJ1.setLayout(new java.awt.GridLayout(3, 1));

        LJoueur1.setText("Joueur1");
        PInfoJ1.add(LJoueur1);

        LPseudoJ1.setText("Pseudo Joueur1");
        PInfoJ1.add(LPseudoJ1);

        BJoueur1.setBackground(new java.awt.Color(255, 0, 51));
        PInfoJ1.add(BJoueur1);

        PJoueur1.add(PInfoJ1);

        PPhotoJ1.setLayout(new java.awt.GridLayout(1, 1));
        PPhotoJ1.add(BPhotoJ1);

        PJoueur1.add(PPhotoJ1);

        PWest.add(PJoueur1);

        PJoueur2.setLayout(new java.awt.GridLayout(2, 1));

        PInfoJ2.setLayout(new java.awt.GridLayout(3, 1));

        LJoueur2.setText("Joueur2");
        PInfoJ2.add(LJoueur2);

        LPseudoJ2.setText("Pseudo Joueur2");
        PInfoJ2.add(LPseudoJ2);

        BJoueur2.setBackground(new java.awt.Color(153, 51, 0));
        BJoueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJoueur2ActionPerformed(evt);
            }
        });
        PInfoJ2.add(BJoueur2);

        PJoueur2.add(PInfoJ2);

        PPhotoJ2.setLayout(new java.awt.GridLayout(1, 1));
        PPhotoJ2.add(BPhotoJ2);

        PJoueur2.add(PPhotoJ2);

        PWest.add(PJoueur2);

        getContentPane().add(PWest, java.awt.BorderLayout.LINE_START);

        MJeu.setText("Jeu");

        MRejoueur.setText("Rejouer");
        MRejoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRejoueurActionPerformed(evt);
            }
        });
        MJeu.add(MRejoueur);

        MQuitter.setText("Quitter");
        MQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MQuitterActionPerformed(evt);
            }
        });
        MJeu.add(MQuitter);

        jMenuBar1.add(MJeu);

        MJoueurs.setText("Joueurs");
        MJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MJoueursActionPerformed(evt);
            }
        });

        MSelectionner.setText("Sélectionner");
        MSelectionner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSelectionnerActionPerformed(evt);
            }
        });
        MJoueurs.add(MSelectionner);

        MAjouter.setText("Ajouter");
        MAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAjouterActionPerformed(evt);
            }
        });
        MJoueurs.add(MAjouter);

        MVisualiser.setText("Visualiser");
        MVisualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MVisualiserActionPerformed(evt);
            }
        });
        MJoueurs.add(MVisualiser);

        jMenuBar1.add(MJoueurs);

        MStatistiques.setText("Statistiques");

        MClassement.setText("Classement");
        MClassement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MClassementActionPerformed(evt);
            }
        });
        MStatistiques.add(MClassement);

        MScore.setText("Scores");
        MScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MScoreActionPerformed(evt);
            }
        });
        MStatistiques.add(MScore);

        jMenuBar1.add(MStatistiques);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BJoueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJoueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BJoueur2ActionPerformed

    private void MJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MJoueursActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_MJoueursActionPerformed

    private void MAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAjouterActionPerformed
        // TODO add your handling code here:

        SaisieJoueurDlg diag = new SaisieJoueurDlg(this, true);
        diag.setVisible(true);
        if (diag.getOk() == true) // accesseur pour récupérer l’indicateur
        {
            Joueur j = diag.getJoueur(); // accesseur pour récupérer le joueur saisi
            this.listeJ.ajouteJoueur(j);
        }

    }//GEN-LAST:event_MAjouterActionPerformed

    private void MVisualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MVisualiserActionPerformed
        // TODO add your handling code here:
        VisuJoueurDlg diag = new VisuJoueurDlg(this, true, listeJ);
        diag.setVisible(true);

    }//GEN-LAST:event_MVisualiserActionPerformed

    private void MSelectionnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSelectionnerActionPerformed
        // TODO add your handling code here:
        SelectionJoueursDlg diag = new SelectionJoueursDlg(this, true, this.listeJ, this.joueur1, this.joueur2);
        diag.setVisible(true);
        if (diag.getOk()) {
            this.joueur1 = diag.getJoueur1();
            this.joueur2 = diag.getJoueur2();
            afficheJoueurs();
        }
    }//GEN-LAST:event_MSelectionnerActionPerformed

    private void MRejoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRejoueurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MRejoueurActionPerformed

    private void MQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MQuitterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MQuitterActionPerformed

    private void MClassementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MClassementActionPerformed
        // TODO add your handling code here:
        ClassementDlg diag = new ClassementDlg(this, true, this.listeJ, this.lp);
        diag.setVisible(true);
    }//GEN-LAST:event_MClassementActionPerformed

    private void MScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MScoreActionPerformed
        // TODO add your handling code here:
        ScoresDlg diag = new ScoresDlg(this, true, listeJ);
        diag.setVisible(true);
    }//GEN-LAST:event_MScoreActionPerformed

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
            java.util.logging.Logger.getLogger(P4P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P4P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P4P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P4P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P4P().setVisible(true);
                P4P frame = new P4P();
                frame.setSize(300, 300);
                // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BJoueur1;
    private javax.swing.JButton BJoueur2;
    private javax.swing.JButton BPhotoJ1;
    private javax.swing.JButton BPhotoJ2;
    private javax.swing.JLabel LDroit;
    private javax.swing.JLabel LJoueur1;
    private javax.swing.JLabel LJoueur2;
    private javax.swing.JLabel LPseudoJ1;
    private javax.swing.JLabel LPseudoJ2;
    private javax.swing.JMenuItem MAjouter;
    private javax.swing.JMenuItem MClassement;
    private javax.swing.JMenu MJeu;
    private javax.swing.JMenu MJoueurs;
    private javax.swing.JMenuItem MQuitter;
    private javax.swing.JMenuItem MRejoueur;
    private javax.swing.JMenuItem MScore;
    private javax.swing.JMenuItem MSelectionner;
    private javax.swing.JMenu MStatistiques;
    private javax.swing.JMenuItem MVisualiser;
    private javax.swing.JTextField Message;
    private javax.swing.JLabel MessageErreur;
    private javax.swing.JPanel PCenter;
    private javax.swing.JPanel PEast;
    private javax.swing.JPanel PInfoJ1;
    private javax.swing.JPanel PInfoJ2;
    private javax.swing.JPanel PJoueur1;
    private javax.swing.JPanel PJoueur2;
    private javax.swing.JPanel PPhotoJ1;
    private javax.swing.JPanel PPhotoJ2;
    private javax.swing.JPanel PPions;
    private javax.swing.JPanel PSouth;
    private javax.swing.JPanel PWest;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
