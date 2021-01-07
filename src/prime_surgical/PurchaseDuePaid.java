package prime_surgical;
import com.toedter.calendar.JCalendar;
import java.text.SimpleDateFormat;
import javax.swing.*;
/**
 *
 * @author Mahmudul Hasan
 */
public class PurchaseDuePaid extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers
     */
    public PurchaseDuePaid() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Bank.setVisible(false);
        getCompany();
        JCalendar jc=new JCalendar();
                 SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
                 String m=sd.format(jc.getDate());
                 lbDate.setText(m);
    }
    String companyName,purchaseDate,billNo,payment,bankName,bankAccount,total,paid,due;
void getCompany(){
    new dbConnection().getDataFromCombo(comCompany, "SELECT `supplier_company_name` FROM `suppliers` GROUP BY `supplier_company_name` ORDER BY `supplier_id` ");
}
void showPurchaseAccounts(){
    if(!comCompany.getSelectedItem().equals("Select")){
companyName=comCompany.getSelectedItem().toString();
    new dbConnection().showPurchaseAccounts("SELECT * FROM `purchase accounts` WHERE `company`='"+companyName+"'", jTable1);
    txtSubTotal.setEditable(false);
    txtDue.setEditable(false);
    String subTotal=new dbConnection().singledata("SELECT SUM(`due`) FROM `purchase accounts` WHERE `company`='"+companyName+"'");
    txtSubTotal.setText(subTotal);
    txtDue.setText(subTotal);
}
}
void getData(){
    companyName=comCompany.getSelectedItem().toString();
    SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
    purchaseDate=sm.format(jDateChooser1.getDate());
    billNo=txtBill.getText();
    total=txtSubTotal.getText();
    paid=txtPaid.getText();
    due=txtDue.getText();
    if(rbBank.isSelected()){
        payment="Bank";
    }
    else if(rbCash.isSelected()){
        payment="Cash";
    }
}
int checkBlankData(){
    int check=0;
    if(comCompany.getSelectedIndex()==0){
        JOptionPane.showMessageDialog(this, "Select company name!","Error!",JOptionPane.WARNING_MESSAGE);
        comCompany.requestFocus();
    }
    else if(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Enter date!","Error!",JOptionPane.WARNING_MESSAGE);
        jDateChooser1.requestFocus();
    }
    else if(txtBill.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Enter bill no!","Error!",JOptionPane.WARNING_MESSAGE);
        txtBill.requestFocus();
    }
    else if(txtSubTotal.getText().equals("0.00") || txtSubTotal.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Sub Total is Empty!","Error!",JOptionPane.WARNING_MESSAGE);
        txtSubTotal.requestFocus();
    }
    else if(txtPaid.getText().equals("0.00") || txtPaid.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Paid is Empty!","Error!",JOptionPane.WARNING_MESSAGE);
        txtPaid.requestFocus();
    }
    else if(!rbCash.isSelected() && !rbBank.isSelected()){
        JOptionPane.showMessageDialog(this,"Payment Method is missing!","Error!",JOptionPane.WARNING_MESSAGE);
    }
    else if(rbBank.isSelected()){
        if(comBankName.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Enter Bank Name!");
            comBankName.requestFocus();
        }
        else if(txtAccount.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Enter Account Number!");
            txtAccount.requestFocus();
        }
    }
    else{
        check=1;
    }
    return check;
}
void addPurchaseAccounts(){
    if(checkBlankData()==1){
    getData();
    if(payment.equals("Bank")){
        getData();
     new dbConnection().addData("INSERT INTO `purchase accounts` VALUES('"+billNo+"','"+"Due Paid"+"','"+purchaseDate+"','"+companyName+"','"+"0"+"','"+total+"','"+payment+"','"+"0"+"','"+paid+"','"+due+"')", this);
     sendBank();
     showPurchaseAccounts();
     txtPaid.setText("0.00");
     Bank.setVisible(false);
     comCompany.setSelectedIndex(0);
     txtBill.setText("");
    }
    else if(payment.equals("Cash")){
        getData();
     new dbConnection().addData("INSERT INTO `purchase accounts` VALUES('"+billNo+"','"+"Due Paid"+"','"+purchaseDate+"','"+companyName+"','"+"0"+"','"+total+"','"+payment+"','"+"0"+"','"+paid+"','"+due+"')", this);
     sendCash();
     showPurchaseAccounts();
     txtPaid.setText("0.00");
     comCompany.setSelectedIndex(0);
     txtBill.setText("");
    }
   }
  }
void sendCash(){
    getData();
    new dbConnection().addBankOrCash("INSERT INTO `cash data`(`cash_date`,`cash_details`,`cash_status`,`cash_amount`) VALUES('"+purchaseDate+"','"+"Purchase Due"+"','"+"Debit"+"','"+paid+"')");
}
void sendBank(){
    getData();
    new dbConnection().addBankOrCash("INSERT INTO `bank data`(`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) VALUES('"+purchaseDate+"','"+bankName+"','"+bankAccount+"','"+"Purchase Due"+"','"+"Withdraw"+"','"+paid+"')");
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
        lbDate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comCompany = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        txtAccount = new javax.swing.JComboBox<>();
        txtBill = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();

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
        jButton4.setBounds(200, 270, 180, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

        lbDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbDate);
        lbDate.setBounds(90, 100, 170, 50);

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

        comCompany.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comCompany.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comCompanyPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCompanyActionPerformed(evt);
            }
        });
        jPanel1.add(comCompany);
        comCompany.setBounds(170, 170, 290, 50);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Company Name");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 170, 140, 50);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 100, 50, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 510, 770);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        jTable1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.", "Bill no.", "Date", "Items", "Total", "Paid", "Due"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 850, 490);

        txtSubTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtSubTotal.setText("0.00");
        jPanel5.add(txtSubTotal);
        txtSubTotal.setBounds(680, 490, 170, 50);

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sub Total:");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(590, 490, 90, 50);

        txtPaid.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtPaid.setText("0.00");
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });
        jPanel5.add(txtPaid);
        txtPaid.setBounds(680, 540, 170, 50);

        txtDue.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtDue.setText("0.00");
        jPanel5.add(txtDue);
        txtDue.setBounds(680, 590, 170, 50);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Due");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(590, 590, 90, 50);

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton6.setText("Submit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(590, 660, 170, 40);

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
        rbBank.setBounds(200, 540, 120, 40);

        buttonGroup1.add(rbCash);
        rbCash.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        rbCash.setForeground(new java.awt.Color(255, 255, 255));
        rbCash.setText("Cash");
        rbCash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCashMouseClicked(evt);
            }
        });
        rbCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCashActionPerformed(evt);
            }
        });
        jPanel5.add(rbCash);
        rbCash.setBounds(70, 540, 110, 40);

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Paid");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(590, 550, 90, 40);

        Bank.setBackground(new java.awt.Color(0, 153, 153));
        Bank.setBorder(new javax.swing.border.MatteBorder(null));
        Bank.setLayout(null);

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Bank Name:");
        Bank.add(jLabel22);
        jLabel22.setBounds(10, 0, 150, 40);

        comBankName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comBankName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comBankNamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        Bank.add(comBankName);
        comBankName.setBounds(170, 0, 250, 40);

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Account Number:");
        Bank.add(jLabel19);
        jLabel19.setBounds(10, 50, 150, 40);

        txtAccount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        Bank.add(txtAccount);
        txtAccount.setBounds(170, 50, 250, 44);

        jPanel5.add(Bank);
        Bank.setBounds(40, 580, 430, 100);

        txtBill.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel5.add(txtBill);
        txtBill.setBounds(430, 490, 140, 40);

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Bill no.");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(370, 490, 60, 40);
        jPanel5.add(jDateChooser1);
        jDateChooser1.setBounds(70, 490, 290, 40);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Date:");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(20, 490, 60, 40);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(510, 0, 860, 770);

        setSize(new java.awt.Dimension(1371, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rbBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBankActionPerformed
        // TODO add your handling code here:
        if(rbBank.isSelected()){
          Bank.setVisible(true);
          String query="SELECT `bank_account_name` FROM `bank accounts` group by `bank_account_name`";
          new dbConnection().getDataFromCombo(comBankName, query);
      }
    }//GEN-LAST:event_rbBankActionPerformed

    private void rbBankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbBankMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbBankMouseClicked

    private void rbCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCashMouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_rbCashMouseClicked

    private void comCompanyPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comCompanyPopupMenuWillBecomeInvisible
showPurchaseAccounts();
        
    }//GEN-LAST:event_comCompanyPopupMenuWillBecomeInvisible

    private void comBankNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comBankNamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String query="SELECT `bank_account_number` FROM `bank accounts` WHERE `bank_account_name`='"+comBankName.getSelectedItem().toString()+"'";
        new dbConnection().getDataFromCombo(txtAccount, query);
    }//GEN-LAST:event_comBankNamePopupMenuWillBecomeInvisible

    private void comCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comCompanyActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        addPurchaseAccounts();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rbCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCashActionPerformed
        // TODO add your handling code here:
        if(rbCash.isSelected()){
            Bank.setVisible(false);
        }
    }//GEN-LAST:event_rbCashActionPerformed

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        // TODO add your handling code here:
        try {
         double subTotal,paid;
        subTotal=Integer.parseInt(txtSubTotal.getText());
        paid=Integer.parseInt(txtPaid.getText());
        txtDue.setText(""+(subTotal-paid));   
        } catch (Exception e) {
            double subTotal;
            subTotal=Integer.parseInt(txtSubTotal.getText());
            txtDue.setText(""+subTotal);
        }
        
    }//GEN-LAST:event_txtPaidKeyReleased

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
            java.util.logging.Logger.getLogger(PurchaseDuePaid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseDuePaid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseDuePaid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseDuePaid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new PurchaseDuePaid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bank;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comBankName;
    private javax.swing.JComboBox<String> comCompany;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JRadioButton rbBank;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JComboBox<String> txtAccount;
    private javax.swing.JTextField txtBill;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
