/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime_surgical;
import javax.swing.*;
/**
 *
 * @author Mahmudul Hasan
 */
public class SalesEntry extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers
     */
    public SalesEntry() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Bank.setVisible(false);
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
        txtCustomer = new javax.swing.JTextField();
        txtBill = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnPurchase = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtGR = new javax.swing.JTextField();
        comPrice = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comCustomer = new javax.swing.JComboBox<>();
        txtSR = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtProduct = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        comSR = new javax.swing.JComboBox<>();
        txtTotal1 = new javax.swing.JTextField();
        txtTotal2 = new javax.swing.JTextField();
        comCateogory = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtId1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSubTotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(null);

        txtCustomer.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtCustomer);
        txtCustomer.setBounds(160, 180, 290, 40);

        txtBill.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtBill);
        txtBill.setBounds(160, 220, 290, 40);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bill no.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 220, 140, 40);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Customer Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 180, 140, 40);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cateogory:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 300, 140, 40);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 260, 140, 40);

        btnEdit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEdit.setText("Edit");
        jPanel1.add(btnEdit);
        btnEdit.setBounds(250, 650, 130, 40);

        btnPurchase.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnPurchase.setText("Sale");
        jPanel1.add(btnPurchase);
        btnPurchase.setBounds(110, 650, 130, 40);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(190, 700, 130, 40);

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
        jLabel8.setText("Sales Entry");

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

        txtTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtTotal);
        txtTotal.setBounds(160, 500, 290, 40);

        txtPrice.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtPrice);
        txtPrice.setBounds(300, 420, 150, 40);

        txtGR.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtGR);
        txtGR.setBounds(160, 380, 290, 40);

        comPrice.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPriceActionPerformed(evt);
            }
        });
        jPanel1.add(comPrice);
        comPrice.setBounds(160, 420, 140, 40);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GR:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 380, 140, 40);

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Product Price");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 420, 140, 40);

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Product Quantity:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 460, 140, 40);

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 500, 140, 40);

        comCustomer.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(comCustomer);
        comCustomer.setBounds(160, 180, 290, 40);

        txtSR.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtSR);
        txtSR.setBounds(160, 580, 290, 40);

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("SR:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(20, 540, 140, 40);

        txtProduct.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtProduct);
        txtProduct.setBounds(160, 340, 290, 40);

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Product Name:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(20, 340, 140, 40);

        comSR.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comSR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comSRActionPerformed(evt);
            }
        });
        jPanel1.add(comSR);
        comSR.setBounds(160, 540, 290, 40);

        txtTotal1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtTotal1);
        txtTotal1.setBounds(160, 460, 140, 40);

        txtTotal2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtTotal2);
        txtTotal2.setBounds(300, 460, 150, 40);

        comCateogory.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comCateogory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comCateogory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCateogoryActionPerformed(evt);
            }
        });
        jPanel1.add(comCateogory);
        comCateogory.setBounds(160, 300, 290, 40);

        jComboBox4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Permanent", "Customer" }));
        jComboBox4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(jComboBox4);
        jComboBox4.setBounds(160, 140, 290, 40);
        jPanel1.add(txtDate);
        txtDate.setBounds(160, 260, 290, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 510, 770);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("bill no.");
        jPanel6.add(jLabel1);
        jLabel1.setBounds(70, 40, 120, 40);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("date");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(290, 40, 170, 40);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Shop/Hospital:");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(10, 80, 150, 50);

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("shop/hospital");
        jPanel6.add(jLabel14);
        jLabel14.setBounds(130, 80, 290, 50);

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show Sales", "Show Submits" }));
        jPanel6.add(jComboBox1);
        jComboBox1.setBounds(650, 10, 190, 40);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bill No:");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(10, 40, 60, 40);

        txtId1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel6.add(txtId1);
        txtId1.setBounds(620, 90, 220, 40);

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("*Search by Order/Bill no.");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(420, 90, 200, 40);

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Date:");
        jPanel6.add(jLabel25);
        jLabel25.setBounds(240, 40, 50, 40);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 0, 850, 140);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.", "GR Number", "Cateogory", "Product", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 840, 390);

        txtSubTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel5.add(txtSubTotal);
        txtSubTotal.setBounds(680, 550, 170, 30);

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sub Total:");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(590, 550, 90, 30);

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Discount:");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(590, 590, 90, 30);

        txtDiscount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel5.add(txtDiscount);
        txtDiscount.setBounds(680, 590, 170, 30);

        txtPaid.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel5.add(txtPaid);
        txtPaid.setBounds(680, 630, 170, 30);

        txtDue.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel5.add(txtDue);
        txtDue.setBounds(680, 670, 170, 30);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Due");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(590, 670, 90, 30);

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton6.setText("Submit");
        jPanel5.add(jButton6);
        jButton6.setBounds(630, 720, 170, 40);

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
        rbBank.setBounds(220, 540, 120, 40);

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
        rbCash.setBounds(90, 540, 110, 40);

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Paid");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(590, 630, 90, 30);

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

        txtAccount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Bank.add(txtAccount);
        txtAccount.setBounds(170, 50, 250, 44);

        jPanel5.add(Bank);
        Bank.setBounds(60, 580, 430, 100);

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
          String query="SELECT `bank name` FROM `bank accounts`";
          new dbConnection().getDataFromCombo(comBankName, query);
      }
    }//GEN-LAST:event_rbBankMouseClicked

    private void rbCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCashMouseClicked
        // TODO add your handling code here:
        if(rbCash.isSelected()){
          Bank.setVisible(false);
      }
    }//GEN-LAST:event_rbCashMouseClicked

    private void comPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comPriceActionPerformed

    private void comSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comSRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comSRActionPerformed

    private void comCateogoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCateogoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comCateogoryActionPerformed

    private void jComboBox4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox4PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        //comCustomer
        String query="SELECT `customer name` FROM `customers`";
        if(!jComboBox4.getSelectedItem().toString().contains("Select")){
          if(jComboBox4.getSelectedItem().toString().contains("Permanent")){
            comCustomer.setVisible(true);
            txtCustomer.setVisible(false);
            new dbConnection().getDataFromCombo(comCustomer, query);
        }else{
              comCustomer.setVisible(false);
              txtCustomer.setVisible(true);
          }
        }
        else{
            comCustomer.setVisible(false);
              txtCustomer.setVisible(true);
        }
        
    }//GEN-LAST:event_jComboBox4PopupMenuWillBecomeInvisible

    private void comBankNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comBankNamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String query="SELECT `account no` FROM `bank accounts` WHERE `bank name`='"+comBankName.getSelectedItem().toString()+"'";
        new dbConnection().getDataFromCombo(txtAccount, query);
    }//GEN-LAST:event_comBankNamePopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(SalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bank;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPurchase;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comBankName;
    private javax.swing.JComboBox<String> comCateogory;
    private javax.swing.JComboBox<String> comCustomer;
    private javax.swing.JComboBox<String> comPrice;
    private javax.swing.JComboBox<String> comSR;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox4;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbBank;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JComboBox<String> txtAccount;
    private javax.swing.JTextField txtBill;
    private javax.swing.JTextField txtCustomer;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtGR;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtSR;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    private javax.swing.JTextField txtTotal2;
    // End of variables declaration//GEN-END:variables
}
