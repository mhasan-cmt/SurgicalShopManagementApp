package prime_surgical;
import javax.swing.*;
/**
 *
 * @author Mahmudul Hasan
 */
public class Purchase_due_paid extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers
     */
    public Purchase_due_paid() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Bank.setVisible(false);
    }
    void initial(){
        String query="SELECT `company name` FROM `suppliers`";
        new dbConnection().getDataFromCombo(jComboBox3,query);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPaid = new javax.swing.JTextField();
        txtDue = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        rbBank = new javax.swing.JRadioButton();
        rbCash = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        Bank = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        comBankName = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(null);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(220, 200, 130, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Company Name:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 140, 140, 40);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Purchase Due Paid");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 510, 100);

        jComboBox3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(160, 140, 290, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 510, 770);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        txtSubTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel5.add(txtSubTotal);
        txtSubTotal.setBounds(660, 580, 170, 30);

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total Due:");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(570, 580, 90, 30);

        txtPaid.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel5.add(txtPaid);
        txtPaid.setBounds(660, 610, 170, 30);

        txtDue.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel5.add(txtDue);
        txtDue.setBounds(660, 640, 170, 30);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Due");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(570, 640, 90, 30);

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton6.setText("Submit");
        jPanel5.add(jButton6);
        jButton6.setBounds(660, 690, 170, 40);

        buttonGroup1.add(rbBank);
        rbBank.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        rbBank.setForeground(new java.awt.Color(255, 255, 255));
        rbBank.setText("Bank");
        rbBank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbBankMouseClicked(evt);
            }
        });
        rbBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBankActionPerformed(evt);
            }
        });
        jPanel5.add(rbBank);
        rbBank.setBounds(150, 580, 120, 40);

        buttonGroup1.add(rbCash);
        rbCash.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        rbCash.setForeground(new java.awt.Color(255, 255, 255));
        rbCash.setText("Cash");
        rbCash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCashMouseClicked(evt);
            }
        });
        jPanel5.add(rbCash);
        rbCash.setBounds(20, 580, 110, 40);

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Paid");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(570, 610, 90, 30);

        Bank.setBackground(new java.awt.Color(0, 153, 153));
        Bank.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Bank Name:");

        comBankName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comBankName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Account Number:");

        txtAccount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        javax.swing.GroupLayout BankLayout = new javax.swing.GroupLayout(Bank);
        Bank.setLayout(BankLayout);
        BankLayout.setHorizontalGroup(
            BankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BankLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BankLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(comBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BankLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAccount)))
                .addGap(19, 19, 19))
        );
        BankLayout.setVerticalGroup(
            BankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(BankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BankLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtAccount))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.add(Bank);
        Bank.setBounds(20, 640, 420, 120);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setLayout(null);

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL no.", "Date", "Bill no.", "Item", "Paid", "Due"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 820, 540);

        jPanel5.add(jPanel3);
        jPanel3.setBounds(10, 10, 840, 560);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(510, 0, 860, 770);

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rbBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbBankActionPerformed

    private void rbBankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbBankMouseClicked
        // TODO add your handling code here:
        if(rbBank.isSelected()){
          Bank.setVisible(true);
      }
    }//GEN-LAST:event_rbBankMouseClicked

    private void rbCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCashMouseClicked
        // TODO add your handling code here:
        if(rbCash.isSelected()){
          Bank.setVisible(false);
      }
    }//GEN-LAST:event_rbCashMouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

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
            java.util.logging.Logger.getLogger(Purchase_due_paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase_due_paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase_due_paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase_due_paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase_due_paid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bank;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comBankName;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbBank;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
