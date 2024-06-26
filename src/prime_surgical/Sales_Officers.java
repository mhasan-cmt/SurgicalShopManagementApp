package prime_surgical;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahmudul Hasan
 */
public class Sales_Officers extends javax.swing.JFrame {

    /**
     *Creates new form Suppliers
    */
    public Sales_Officers() {
        initComponents();
        show1();
        
    }
    /**
     * custom variable, defined by developer.
     */
    String id,name,mobile,address,salary,position,joining,reffarel,refMobile;
    /**
     * this method is for getting data.
     */
    void getdata(){
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
       id= txtId.getText();
       name=txtName.getText();
       mobile=txtMobile.getText();
       address=txtAddress.getText();
       salary=txtSalary.getText();
       position=txtPosition.getText();
       joining=sm.format(jDateChooser1.getDate());
       reffarel=txtRefferance.getText();
       refMobile=txtRefMobile.getText(); 
    }
    /**
     * this method is for checking the data fields are empty or not.
     * @return 
     */
    int dataCheck(){
        int a=0;
        if(txtId.getText().isEmpty()){
            txtId.requestFocus();
        }
        else if(txtName.getText().isEmpty()){
            txtName.requestFocus();
        }
        else if(txtMobile.getText().isEmpty()){
            txtMobile.requestFocus();
        }
        else if(txtAddress.getText().isEmpty()){
            txtAddress.requestFocus();
        }
        else if(txtSalary.getText().isEmpty()){
            txtSalary.requestFocus();
        }
        else if(txtPosition.getText().isEmpty()){
            txtPosition.requestFocus();
        }
        else if(txtRefferance.getText().isEmpty()){
            txtRefferance.requestFocus();
        }
        else if(txtRefMobile.getText().isEmpty()){
            txtRefMobile.requestFocus();
        }
        else {
            a=1;
        }
        return  a;
    }
    //show data
    void show1(){
         dbConnection d=new dbConnection();
        d.dbconnect();
        String q="SELECT * FROM `salesOfficer`";
        d.showDataForSalesOfficerTable(q, jTable1);
    }
    void clearData(){
    txtId.setText("");
    txtName.setText("");
    txtMobile.setText("");
    txtAddress.setText("");
    txtSalary.setText("");
    txtPosition.setText("");
    ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText("");
    txtRefferance.setText("");
    txtRefMobile.setText(""); 
    }
    void update(){
        dbConnection d=new dbConnection();
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
        String q="UPDATE `salesofficer` SET `id`='"+txtId.getText()+"' ,`sales_name`='"+txtName.getText()+"', `sales_mobile`='"+txtMobile.getText()+"',`sales_address`='"+txtAddress.getText()+"',`sales_salary`='"+txtSalary.getText()+"',`sales_position`='"+txtPosition.getText()+"',`sales_ref`='"+txtRefferance.getText()+"', `sales_ref_mobile`='"+txtRefMobile.getText()+"' WHERE  `id`='"+txtId.getText()+"'";
        d.updateData(q, this);
        show1();
    }
    void delete(){
        dbConnection d=new dbConnection();
        String q="DELETE FROM `salesofficer` WHERE `id`='"+txtId.getText()+"'";
        int de=JOptionPane.showConfirmDialog(this, "This will delete whole row!","Delete",JOptionPane.YES_NO_OPTION);
        if(de==0){
        d.updateData(q, this);
            show1();
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

        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRefMobile = new javax.swing.JTextField();
        txtRefferance = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(3, 32, 60));
        jPanel1.setLayout(null);

        txtName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtName);
        txtName.setBounds(170, 120, 370, 40);

        txtSalary.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtSalary);
        txtSalary.setBounds(170, 270, 370, 40);

        txtMobile.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtMobile);
        txtMobile.setBounds(170, 170, 370, 40);

        txtAddress.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtAddress);
        txtAddress.setBounds(170, 220, 370, 40);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mobile Number:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 170, 140, 40);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 120, 140, 40);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Salary:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 270, 140, 40);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 220, 140, 40);

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(410, 320, 130, 40);

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(130, 320, 130, 40);

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(270, 320, 130, 40);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(830, 320, 130, 40);

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton5.setText("Show");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(550, 320, 130, 40);

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(690, 320, 130, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

        txtId.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtId);
        txtId.setBounds(170, 70, 370, 40);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 70, 140, 40);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sales Officers(SR) Data");

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 739, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1360, 60);

        jPanel3.setBackground(new java.awt.Color(3, 32, 60));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(null);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField2);
        jTextField2.setBounds(210, 0, 390, 50);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Search by SR Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(10, 10, 200, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 370, 1350, 50);

        txtRefMobile.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtRefMobile.setText("N/A");
        jPanel1.add(txtRefMobile);
        txtRefMobile.setBounds(690, 220, 370, 40);

        txtRefferance.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtRefferance.setText("N/A");
        jPanel1.add(txtRefferance);
        txtRefferance.setBounds(690, 170, 370, 40);

        txtPosition.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtPosition);
        txtPosition.setBounds(690, 70, 370, 40);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Position:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(550, 70, 140, 40);

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Reffarel Person:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(550, 170, 140, 40);

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mobile Number:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(550, 220, 140, 40);

        jTable1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Mobile", "Address", "Salary", "Position", "Joining date", "Refferal Person", "Mobie No."
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 420, 1350, 340);
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(690, 110, 370, 60);

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Joining Date:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(550, 120, 140, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1370, 770);

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(dataCheck()==1){
            if(new dbConnection().singledata("SELECT `id` FROM `salesofficer` WHERE id='"+txtId.getText()+"'").isEmpty()){
              new dbConnection().dbconnect();
        getdata();
        String q="INSERT INTO `salesOfficer` VALUES('"+id+"','"+name+"','"+mobile+"','"+address+"','"+salary+"'"
                + ",'"+position+"','"+joining+"','"+reffarel+"','"+refMobile+"')";
        new dbConnection().addData(q, this);
            show1();
            clearData();  
            }
            else{
              JOptionPane.showMessageDialog(this, "Already a officer exists for this id!");
            }
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       show1();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here
        if(dataCheck()==1){
            update();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // clicked for get data
        DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
    txtId.setText(dtm.getValueAt(jTable1.getSelectedRow(),0).toString());
    txtName.setText(dtm.getValueAt(jTable1.getSelectedRow(),1).toString());
    txtMobile.setText(dtm.getValueAt(jTable1.getSelectedRow(),2).toString());
    txtAddress.setText(dtm.getValueAt(jTable1.getSelectedRow(),3).toString());
    txtSalary.setText(dtm.getValueAt(jTable1.getSelectedRow(),4).toString());
    txtPosition.setText(dtm.getValueAt(jTable1.getSelectedRow(),5).toString());
    ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText(dtm.getValueAt(jTable1.getSelectedRow(), 6).toString());
    txtRefferance.setText(dtm.getValueAt(jTable1.getSelectedRow(),7).toString());
    txtRefMobile.setText(dtm.getValueAt(jTable1.getSelectedRow(),8).toString()); 
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        String search=jTextField2.getText();
        String query="SELECT * FROM `salesOfficer` where `sales_name` LIKE  '%"+search+"%'";
        new dbConnection().showDataForSalesOfficerTable(query, jTable1);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyPressed

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
            java.util.logging.Logger.getLogger(Sales_Officers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_Officers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_Officers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_Officers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales_Officers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtRefMobile;
    private javax.swing.JTextField txtRefferance;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
