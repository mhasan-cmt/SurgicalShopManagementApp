/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime_surgical;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahmudul Hasan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
   
    public Login() {
        initComponents();
        users();
    } 
    String user,pass;
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
    void getData(){
    user=txtUser.getText();
    pass=txtPassword.getText();
}
    void login(){
        try {
            dbConnect();
            getData();
            String query= "SELECT * FROM `LoginUsers` WHERE `user`='"+user+"' AND `password`='"+pass+"'";
            rs=st.executeQuery(query);
            if(rs.next()){
                new HomePage().setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Username or Password did not matched!");
                txtPassword.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void users(){
        try {
            dbConnect();
            String q="SELECT `user` FROM `LoginUsers` ";
            rs=st.executeQuery(q);
            while(rs.next()){
                comUser.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        comUser = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 102), 2));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Kalpurush", 1, 33)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("এন্ড ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 70, 60, 40);

        jLabel2.setFont(new java.awt.Font("Kalpurush", 1, 33)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("সায়েন্টিফিক");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 110, 300, 50);

        jLabel3.setFont(new java.awt.Font("Kalpurush", 1, 33)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("প্রাইম সার্জিক্যাল ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 20, 320, 60);

        jLabel4.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel4.setText("ট্রাংক রোড, ফেনী।");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 260, 130, 50);

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 27)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Prime Surgical & Scientific");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 150, 320, 50);

        jLabel6.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel6.setText("যমুনা শপিং সেন্টার(উত্তরা ব্যাংকের নিচ তলা,");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 200, 290, 50);

        jLabel7.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel7.setText(" ফেনী সরকারি বালিকা বিদ্যালয়ের উত্তর পার্শে), ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 230, 310, 50);

        jLabel8.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 51));
        jLabel8.setText("মোবাইলঃ ০১৮৮৭-০৩৩৩১১, ০১৮৬৩-৮০৮৯৮১");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 330, 310, 30);

        jLabel9.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 51));
        jLabel9.setText("Email: primesugicall95@gmail.com");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 370, 310, 26);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 340, 430);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        txtUser.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtUser.setText("Enter User Name");
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });
        jPanel2.add(txtUser);
        txtUser.setBounds(50, 60, 370, 70);

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel11.setText("Password:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(50, 130, 200, 40);

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel12.setText("User Name:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(50, 20, 200, 40);

        jButton2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButton2.setText("Sign in");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(50, 270, 120, 40);

        jButton3.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(190, 270, 120, 40);

        jButton4.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButton4.setText("Add User");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(320, 270, 120, 40);

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jPanel2.add(txtPassword);
        txtPassword.setBounds(50, 170, 370, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(340, 100, 460, 330);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sign In");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(30, 30, 120, 40);

        comUser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        comUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User" }));
        comUser.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comUserPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel3.add(comUser);
        comUser.setBounds(280, 30, 160, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(340, 0, 460, 100);

        setSize(new java.awt.Dimension(799, 433));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int exit=JOptionPane.showConfirmDialog(this, "Sure?","Exit",JOptionPane.YES_NO_OPTION);
        if(exit==0){
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        // TODO add your handling code here:
        txtUser.setText("");
    }//GEN-LAST:event_txtUserMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comUserPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comUserPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        txtUser.setText(comUser.getSelectedItem().toString());
    }//GEN-LAST:event_comUserPopupMenuWillBecomeInvisible

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtPassword.requestFocus();
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          login();  
        }
        
    }//GEN-LAST:event_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
