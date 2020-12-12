/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime_surgical;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import javax.swing.*;
/**
 *
 * @author Mahmudul Hasan
 */
public class Sales_due_paid extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers
     */
    public Sales_due_paid() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Bank.setVisible(false);
        comShop.setVisible(false);
        lbShop.setVisible(false);
        lbCustomer.setVisible(false);
        txtCustomer.setVisible(false);
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
        customerType = new javax.swing.JComboBox<>();
        comShop = new javax.swing.JComboBox<>();
        lbShop = new javax.swing.JLabel();
        txtBill = new javax.swing.JTextField();
        rbBank = new javax.swing.JRadioButton();
        rbCash = new javax.swing.JRadioButton();
        Bank = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        comBankName = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JTextField();
        lbCustomer = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        billPanel = new javax.swing.JPanel();
        headerPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(null);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(230, 610, 130, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Customer Type:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 140, 140, 40);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sales Collection");

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

        customerType.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        customerType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Permanent", "Customer" }));
        customerType.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                customerTypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        customerType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerTypeActionPerformed(evt);
            }
        });
        jPanel1.add(customerType);
        customerType.setBounds(160, 140, 290, 40);

        comShop.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comShop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comShop);
        comShop.setBounds(160, 250, 290, 40);

        lbShop.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbShop.setForeground(new java.awt.Color(255, 255, 255));
        lbShop.setText("Shop/Hospital:");
        jPanel1.add(lbShop);
        lbShop.setBounds(20, 250, 140, 40);

        txtBill.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtBill);
        txtBill.setBounds(160, 290, 290, 40);

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
        jPanel1.add(rbBank);
        rbBank.setBounds(150, 370, 120, 40);

        buttonGroup1.add(rbCash);
        rbCash.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        rbCash.setForeground(new java.awt.Color(255, 255, 255));
        rbCash.setText("Cash");
        rbCash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCashMouseClicked(evt);
            }
        });
        jPanel1.add(rbCash);
        rbCash.setBounds(20, 370, 110, 40);

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

        jPanel1.add(Bank);
        Bank.setBounds(20, 430, 420, 120);

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(80, 610, 130, 40);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bill no.");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(20, 290, 140, 40);

        txtCustomer.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtCustomer);
        txtCustomer.setBounds(160, 250, 290, 40);

        lbCustomer.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbCustomer.setForeground(new java.awt.Color(255, 255, 255));
        lbCustomer.setText("Customer Name:");
        jPanel1.add(lbCustomer);
        lbCustomer.setBounds(20, 250, 140, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 510, 770);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        billPanel.setBackground(new java.awt.Color(255, 255, 255));
        billPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        billPanel.setLayout(null);

        headerPane.setBackground(new java.awt.Color(255, 255, 255));
        headerPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 102), 3));
        headerPane.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Kalpurush", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("প্রাইম সার্জিক্যাল এন্ড সায়েন্টিফিক");
        headerPane.add(jLabel1);
        jLabel1.setBounds(140, 20, 480, 60);

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Prime Surgical & Scientific");
        headerPane.add(jLabel2);
        jLabel2.setBounds(190, 70, 310, 40);

        jLabel4.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel4.setText(" ট্রাংক রোড, ফেনী।");
        headerPane.add(jLabel4);
        jLabel4.setBounds(290, 120, 130, 30);

        jLabel10.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 51));
        jLabel10.setText("Email: primesugicall95@gmail.com");
        headerPane.add(jLabel10);
        jLabel10.setBounds(380, 140, 320, 30);

        jLabel42.setIcon(new javax.swing.ImageIcon("F:\\Java 23\\JavaCodes\\Prime Surgical\\images\\minimize.png")); // NOI18N
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        headerPane.add(jLabel42);
        jLabel42.setBounds(1262, 10, 40, 40);

        jLabel43.setIcon(new javax.swing.ImageIcon("F:\\Java 23\\JavaCodes\\Prime Surgical\\images\\error.png")); // NOI18N
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel43MouseEntered(evt);
            }
        });
        headerPane.add(jLabel43);
        jLabel43.setBounds(1310, 10, 40, 40);

        jLabel11.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 51));
        jLabel11.setText("মোবাইলঃ ০১৮৮৭-০৩৩৩১১, ০১৮৬৩-৮০৮৯৮১");
        headerPane.add(jLabel11);
        jLabel11.setBounds(40, 140, 320, 30);

        jLabel12.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel12.setText("যমুনা শপিং সেন্টার(উত্তরা ব্যাংকের নিচ তলা,");
        headerPane.add(jLabel12);
        jLabel12.setBounds(80, 100, 287, 30);

        jLabel13.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel13.setText("ফেনী সরকারি বালিকা বিদ্যালয়ের উত্তর পার্শে), ");
        headerPane.add(jLabel13);
        jLabel13.setBounds(370, 100, 310, 30);

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Bill");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        headerPane.add(jPanel6);
        jPanel6.setBounds(330, 10, 80, 20);

        billPanel.add(headerPane);
        headerPane.setBounds(10, 10, 730, 180);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setText("Date:");
        billPanel.add(jLabel9);
        jLabel9.setBounds(400, 190, 50, 30);

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setText("Sl no:");
        billPanel.add(jLabel16);
        jLabel16.setBounds(10, 190, 60, 30);

        jTextField3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        billPanel.add(jTextField3);
        jTextField3.setBounds(90, 230, 650, 40);

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setText("Name:");
        billPanel.add(jLabel17);
        jLabel17.setBounds(10, 230, 80, 40);

        jTextField4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        billPanel.add(jTextField4);
        jTextField4.setBounds(90, 270, 650, 40);

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setText("Address:");
        billPanel.add(jLabel18);
        jLabel18.setBounds(10, 270, 80, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.", "Bill", "Date", "Item", "Sub total", "Discount", "Paid"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        billPanel.add(jScrollPane1);
        jScrollPane1.setBounds(10, 310, 730, 260);

        jTextField5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        billPanel.add(jTextField5);
        jTextField5.setBounds(100, 660, 640, 30);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText(".......................................");
        billPanel.add(jLabel20);
        jLabel20.setBounds(540, 704, 190, 20);

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setText("In Words:");
        billPanel.add(jLabel21);
        jLabel21.setBounds(20, 660, 80, 30);

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setText("Total Due:");
        billPanel.add(jLabel23);
        jLabel23.setBounds(470, 570, 110, 30);

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setText("Paid:");
        billPanel.add(jLabel24);
        jLabel24.setBounds(500, 600, 80, 30);

        jTextField7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        billPanel.add(jTextField7);
        jTextField7.setBounds(590, 600, 150, 30);

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("0.00");
        billPanel.add(jLabel25);
        jLabel25.setBounds(590, 570, 150, 30);

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel26.setText("Due:");
        billPanel.add(jLabel26);
        jLabel26.setBounds(500, 630, 90, 30);

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("0.00");
        billPanel.add(jLabel27);
        jLabel27.setBounds(590, 630, 150, 30);

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel28.setText("Signature");
        billPanel.add(jLabel28);
        jLabel28.setBounds(590, 720, 80, 24);

        jPanel5.add(billPanel);
        billPanel.setBounds(10, 10, 750, 750);

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(773, 20, 70, 40);

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

    private void customerTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerTypeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        // TODO add your handling code here:
        int exit=JOptionPane.showConfirmDialog(this, "Sure?","Exit",JOptionPane.YES_NO_OPTION);
        if(exit==0){
            dispose();
            System.exit(0);
        }

    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseEntered

    private void customerTypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_customerTypePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
       String s= customerType.getSelectedItem().toString();
       if(s.contains("Permanent")){
           comShop.setVisible(true);
           lbShop.setVisible(true);
           lbCustomer.setVisible(false);
           txtCustomer.setVisible(false);
       }
       else if(s.contains("Customer")){
           comShop.setVisible(false);
           lbShop.setVisible(false);
           lbCustomer.setVisible(true);
           txtCustomer.setVisible(true);
       }
       else if(s.contains("Select")){
           comShop.setVisible(false);
           lbShop.setVisible(false);
           lbCustomer.setVisible(false);
           txtCustomer.setVisible(false);
       }
        
    }//GEN-LAST:event_customerTypePopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Sales_due_paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_due_paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_due_paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_due_paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Sales_due_paid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bank;
    private javax.swing.JPanel billPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comBankName;
    private javax.swing.JComboBox<String> comShop;
    private javax.swing.JComboBox<String> customerType;
    private javax.swing.JPanel headerPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lbCustomer;
    private javax.swing.JLabel lbShop;
    private javax.swing.JRadioButton rbBank;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JTextField txtBill;
    private javax.swing.JTextField txtCustomer;
    // End of variables declaration//GEN-END:variables
}