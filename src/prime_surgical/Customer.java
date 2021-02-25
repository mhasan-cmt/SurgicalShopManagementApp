package prime_surgical;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahmudul Hasan
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers
     */
    public Customer() {
        initComponents();
        showData("select * from `customers`");
        
    }
    
    //DECLARING CUSTOM VARIABLES
    String id,name,mobile,address,shop;
   Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/primesurgical";
    String un = "root";
    String pw = "";
    void dbConnect() {
        try {
            con = DriverManager.getConnection(url, un, pw);
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
    int dataCheck(){
        int a=0;
        if(!txtId.getText().isEmpty() && !txtName.getText().isEmpty() && !txtAddress.getText().isEmpty() && !txtMobile.getText().isEmpty() && !txtShop.getText().isEmpty()){
            a=1;
        }
        else{
            JOptionPane.showMessageDialog(this, "Enter all Data!");
        }
        
        return a;
    }
    void getData(){
        id=txtId.getText();
        name=txtName.getText();
        address=txtAddress.getText();
        mobile=txtMobile.getText();
        shop=txtShop.getText();
    }
    void addData(){
        if(dataCheck()==1){
        try {
            dbConnect();
            getData();
            String q="INSERT INTO `customers` VALUES('"+id+"','"+name+"','"+mobile+"','"+shop+"','"+address+"')";
            int a=st.executeUpdate(q);
            if(a>0){
                JOptionPane.showMessageDialog(this, "Data Added...!");
                showData("select * from `customers`");
                dataClear();
                txtId.requestFocus();
            }
            else{
                JOptionPane.showMessageDialog(this,"Failed...!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR:"+ex);
        }}
        
    }
    void showData(String s){
        try {
            dbConnect();
            DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);
            rs=st.executeQuery(s);
            while(rs.next()){
                dtm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(this, "ERROR:"+ex);
        }
        
    }
    void dataClear(){
 txtId.setText("");
 txtName.setText("");
 txtMobile.setText("");
 txtShop.setText("");
 txtAddress.setText("");
}
   void deleteData(){
       if(dataCheck()==1){
        try {
            dbConnect();
            getData();
            String q="DELETE FROM `customers` WHERE `id`='"+id+"'";
            int a=st.executeUpdate(q);
            if(a>0){
                JOptionPane.showMessageDialog(this, "Data Deleted...!");
                showData("select * from `customers`");
                dataClear();
                txtId.requestFocus();
            }
            else{
                JOptionPane.showMessageDialog(this,"Failed...!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }}
   }
   void updateData(){
       if(dataCheck()==1){
        try {
            dbConnect();
            getData();
            String q="UPDATE `customers` SET `customer name`='"+name+"',`mobile`='"+mobile+"',`shop name`='"+shop+"',`address`='"+address+"' where `id`='"+txtId.getText()+"'";
            int a=st.executeUpdate(q);
            if(a>0){
                JOptionPane.showMessageDialog(this, "Data Updated...!");
                showData("select * from `customers`");
                dataClear();
                txtId.requestFocus();
            }
            else{
                JOptionPane.showMessageDialog(this,"Failed...!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }}
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
        txtAddress = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        txtShop = new javax.swing.JTextField();
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
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 44, 60));
        jPanel1.setLayout(null);

        txtName.setBackground(new java.awt.Color(60, 80, 104));
        txtName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });
        jPanel1.add(txtName);
        txtName.setBounds(180, 170, 290, 40);

        txtAddress.setBackground(new java.awt.Color(60, 80, 104));
        txtAddress.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(204, 204, 204));
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressKeyPressed(evt);
            }
        });
        jPanel1.add(txtAddress);
        txtAddress.setBounds(180, 320, 290, 40);

        txtMobile.setBackground(new java.awt.Color(60, 80, 104));
        txtMobile.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtMobile.setForeground(new java.awt.Color(204, 204, 204));
        txtMobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMobileKeyPressed(evt);
            }
        });
        jPanel1.add(txtMobile);
        txtMobile.setBounds(180, 220, 290, 40);

        txtShop.setBackground(new java.awt.Color(60, 80, 104));
        txtShop.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtShop.setForeground(new java.awt.Color(204, 204, 204));
        txtShop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtShopKeyPressed(evt);
            }
        });
        jPanel1.add(txtShop);
        txtShop.setBounds(180, 270, 290, 40);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mobile Number:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 220, 170, 40);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Customer Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 170, 170, 40);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 320, 170, 40);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hospital/Shop Name:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 270, 169, 40);

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(310, 390, 130, 40);

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(50, 390, 130, 40);

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(180, 390, 130, 40);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(170, 470, 130, 40);

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton5.setText("Show");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(100, 430, 130, 40);

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(230, 430, 130, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

        txtId.setBackground(new java.awt.Color(60, 80, 104));
        txtId.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(204, 204, 204));
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        jPanel1.add(txtId);
        txtId.setBounds(180, 120, 290, 40);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 120, 170, 40);

        jPanel2.setBackground(new java.awt.Color(182, 169, 176));

        jLabel8.setBackground(new java.awt.Color(182, 169, 176));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Permanent Customer's Data");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 490, 90);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 470, 560);

        jPanel3.setBackground(new java.awt.Color(60, 80, 104));
        jPanel3.setLayout(null);

        jTextField1.setBackground(new java.awt.Color(60, 80, 104));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField1);
        jTextField1.setBounds(470, 40, 210, 40);

        jTextField2.setBackground(new java.awt.Color(60, 80, 104));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField2);
        jTextField2.setBounds(10, 40, 220, 40);

        jTextField3.setBackground(new java.awt.Color(60, 80, 104));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField3);
        jTextField3.setBounds(240, 40, 220, 40);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("*Select by Hospital/Shop Name");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(470, 0, 220, 40);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Select by Customer's Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(10, 0, 220, 40);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("*Select by Customer's Address");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(230, 0, 220, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(470, 0, 710, 90);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setLayout(null);

        jTable1.setBackground(new java.awt.Color(60, 80, 104));
        jTable1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer Name", "Mobile", "Hospital/Shop", "Address"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 690, 470);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(470, 90, 710, 470);

        setSize(new java.awt.Dimension(1178, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        addData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtName.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtMobile.requestFocus();
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtMobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMobileKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtShop.requestFocus();
        }
    }//GEN-LAST:event_txtMobileKeyPressed

    private void txtShopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtShopKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtAddress.requestFocus();
        }
    }//GEN-LAST:event_txtShopKeyPressed

    private void txtAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           addData();
        }
    }//GEN-LAST:event_txtAddressKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        dataClear();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        showData("select * from `customers`");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        deleteData();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
        txtId.setText(dtm.getValueAt(jTable1.getSelectedRow(), 0).toString());
        txtName.setText(dtm.getValueAt(jTable1.getSelectedRow(), 1).toString());
        txtMobile.setText(dtm.getValueAt(jTable1.getSelectedRow(), 2).toString());
        txtShop.setText(dtm.getValueAt(jTable1.getSelectedRow(), 3).toString());
        txtAddress.setText(dtm.getValueAt(jTable1.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed

    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        showData("SELECT * FROM `customers` WHERE `customer name` LIKE '%"+jTextField2.getText()+"%'");
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        showData("SELECT * FROM `customers` WHERE `address` LIKE '%"+jTextField3.getText()+"%'");
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        showData("SELECT * FROM `customers` WHERE `shop name` LIKE '%"+jTextField1.getText()+"%'");
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtShop;
    // End of variables declaration//GEN-END:variables
}
