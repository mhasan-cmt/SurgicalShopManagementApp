package prime_surgical;

import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 *
 * @author Mahmudul Hasan
 */
public class Puchase_Order extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers
     */
    public Puchase_Order() {
        initComponents();
        new dbConnection().getDataFromCombo(comSupplierName, "SELECT `supplier_name` FROM `suppliers` ORDER BY `supplier_id`");
        new dbConnection().getDataFromCombo(comCategory, "SELECT `cateogory` FROM `product cateogory` ORDER BY `cateogory_id`");
        orderIdIncrement();
        txtTotal.setEditable(false);
        txtPrice.setEditable(false);
        txtOrderId.setEditable(false);
    }
    //Variable declaration

    String supplier, details, orderId, orderDate, deliveryDate, category, product, price, quantity, total;
    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
    int orderIdInt = 0;

    //Custom Methods
    void orderIdIncrement() {
        orderIdInt = new dbConnection().autoIdorBillorGR("SELECT `orderId` FROM `purchaseorder` ORDER BY `orderId`");
        orderIdInt++;
        txtOrderId.setText("" + orderIdInt);
        lbOrderId.setText("" + orderIdInt);
    }

    void getData() {
        supplier = comSupplierName.getSelectedItem().toString();
        orderId = txtOrderId.getText();
        orderDate = sm.format(txtOrderDate.getDate());
        deliveryDate = sm.format(txtDeliveryDate.getDate());
        category = comCategory.getSelectedItem().toString();
        if (jRadioButton1.isSelected()) {
            product = txtProduct.getText();
            details = txtDetails.getText();
        } else {
            product = comProduct.getSelectedItem().toString();
        }
        price = txtPrice.getText();
        quantity = txtQuantity.getText();
        total = txtTotal.getText();
    }

    int blankDataCheck() {
        int check = 0;
        if (comSupplierName.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select Supplier Name!");
            comSupplierName.requestFocus();
        } else if (txtOrderId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Order Id!");
            txtOrderId.requestFocus();
        } else if (((JTextField) txtOrderDate.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Order Date!");
            txtOrderDate.requestFocus();
        } else if (((JTextField) txtDeliveryDate.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Delivery Date!");
            txtDeliveryDate.requestFocus();
        } else if (comCategory.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select Product Category!");
            comCategory.requestFocus();
        } else if (jRadioButton1.isSelected() && txtProduct.getText().isEmpty() || txtDetails.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter all details about new product!");
            txtProduct.requestFocus();
        } else if (!jRadioButton1.isSelected() && comProduct.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Enter Product Name!");
            comProduct.requestFocus();
        } else if (txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Product Price!");
            txtPrice.requestFocus();
        } else if (txtQuantity.getText().isEmpty() || Integer.parseInt(txtQuantity.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Enter Product quantity!");
            txtQuantity.requestFocus();
        } else if (txtTotal.getText().isEmpty() || Float.parseFloat(txtTotal.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Total is Missing!");
            txtTotal.requestFocus();
        } else {
            check = 1;
        }
        return check;
    }

    void order() {
        if (blankDataCheck() == 1) {
            if (jRadioButton1.isSelected()) {
                String productCategoryId = new dbConnection().singledata("SELECT `cateogory_id` FROM `product cateogory` WHERE `cateogory`='" + comCategory.getSelectedItem().toString() + "'");
                new dbConnection().addDataWithNoMessege("INSERT INTO `product info`(`product_name`,`product_price`,`product_details`,`product_category_id`) VALUES('" + txtProduct.getText() + "','" + txtPrice.getText() + "','" + txtDetails.getText() + "','" + productCategoryId + "')");
                new dbConnection().addDataWithNoMessege("INSERT INTO `sales entry`(`bill_no`,`customer_name`,`sales_date`,`sales_gr`,`category`,`product`,`price`,`quantity`,`total`) VALUES(0,0,0,0,'" + comCategory.getSelectedItem().toString() + "','" + txtProduct.getText() + "',0,0,0)");
            }
            getData();
            new dbConnection().addData("INSERT INTO `purchaseorder` VALUES('" + orderId + "','" + supplier + "','" + orderDate + "','" + deliveryDate + "','" + category + "','" + product + "','" + price + "','" + quantity + "','" + total + "')", this);
            showData(txtOrderId);
            clearFields();
        }
    }
    void clearFields(){
        comCategory.setSelectedIndex(0);
        comProduct.setSelectedIndex(0);
        txtProduct.setText("");
        txtDetails.setText("");
        txtPrice.setText("0.00");
        txtQuantity.setText("0");
        txtTotal.setText("0.00");
    }
    void showData(JTextField txt) {
        new dbConnection().showPurchaseOrders("select * from `purchaseorder` WHERE `orderId`='" + txt.getText() + "'", jTable1);
        lbOrderDate.setText(new dbConnection().singledata("SELECT `orderDate` FROM `purchaseorder` where `orderId`='" + lbOrderId.getText() + "'"));
        lbDeliveryDate.setText(new dbConnection().singledata("SELECT `deliveryDate` FROM `purchaseorder` where `orderId`='" + lbOrderId.getText() + "'"));
        lbSupplier.setText(new dbConnection().singledata("select `supplier` from `purchaseorder` WHERE `orderId`='" + txt.getText() + "'"));
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
        txtOrderId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnPurchase = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        comCategory = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDeliveryDate = new com.toedter.calendar.JDateChooser();
        txtOrderDate = new com.toedter.calendar.JDateChooser();
        txtQuantity = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnEdit1 = new javax.swing.JButton();
        comSupplierName = new javax.swing.JComboBox<>();
        comProduct = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        txtProduct = new javax.swing.JTextField();
        txtDetails = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbOrderId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbSupplier = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbOrderDate = new javax.swing.JLabel();
        lbDeliveryDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(50, 68, 105));
        jPanel1.setLayout(null);

        txtOrderId.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtOrderId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOrderIdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOrderIdKeyReleased(evt);
            }
        });
        jPanel1.add(txtOrderId);
        txtOrderId.setBounds(160, 160, 290, 50);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order Date:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 220, 140, 40);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Order Id:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 170, 140, 40);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Product Name:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 370, 140, 40);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Delivery Date:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 270, 140, 40);

        btnEdit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEdit.setText("Go to Purchase");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(260, 660, 170, 40);

        btnPurchase.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnPurchase.setText("Order");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });
        jPanel1.add(btnPurchase);
        btnPurchase.setBounds(50, 620, 140, 40);

        btnClear.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnClear.setText("Delete");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);
        btnClear.setBounds(190, 620, 140, 40);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(190, 700, 150, 40);

        btnDelete.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnDelete.setText("Clear");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(120, 660, 140, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Supplier Name:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 120, 140, 40);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Purchase Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 510, 60);

        txtTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtTotal.setText("0.00");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotal);
        txtTotal.setBounds(160, 560, 290, 50);

        comCategory.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comCategory.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comCategoryPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCategoryActionPerformed(evt);
            }
        });
        jPanel1.add(comCategory);
        comCategory.setBounds(160, 310, 290, 50);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Product Price:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 460, 140, 50);

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Product Quantity:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 520, 140, 40);

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 570, 140, 40);
        jPanel1.add(txtDeliveryDate);
        txtDeliveryDate.setBounds(160, 260, 290, 50);
        jPanel1.add(txtOrderDate);
        txtOrderDate.setBounds(160, 210, 290, 50);

        txtQuantity.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtQuantity.setText("0");
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });
        jPanel1.add(txtQuantity);
        txtQuantity.setBounds(160, 510, 290, 50);

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cateogory:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(20, 320, 140, 40);

        txtPrice.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtPrice);
        txtPrice.setBounds(160, 460, 290, 50);

        btnEdit1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEdit1.setText("Update");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit1);
        btnEdit1.setBounds(330, 620, 140, 40);

        comSupplierName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comSupplierName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comSupplierName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comSupplierNamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comSupplierNameActionPerformed(evt);
            }
        });
        jPanel1.add(comSupplierName);
        comSupplierName.setBounds(160, 120, 290, 40);

        comProduct.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comProduct.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comProductPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(comProduct);
        comProduct.setBounds(160, 360, 230, 50);

        jRadioButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("New");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(390, 360, 59, 50);

        txtProduct.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtProduct);
        txtProduct.setBounds(160, 360, 230, 50);

        txtDetails.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(txtDetails);
        txtDetails.setBounds(160, 410, 290, 50);

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Product Details:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 410, 140, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 480, 770);

        jPanel5.setBackground(new java.awt.Color(54, 74, 114));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(59, 80, 122));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(null);

        lbOrderId.setBackground(new java.awt.Color(59, 80, 122));
        lbOrderId.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbOrderId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbOrderId);
        lbOrderId.setBounds(90, 60, 210, 40);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Delivery Date:");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(370, 60, 120, 40);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Supplier Name:");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(10, 0, 130, 50);

        lbSupplier.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbSupplier);
        lbSupplier.setBounds(140, 0, 230, 50);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Order id:");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(10, 60, 90, 40);

        txtSearch.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel6.add(txtSearch);
        txtSearch.setBounds(650, 100, 200, 40);

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("*Search by Order id:");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(450, 100, 200, 40);

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Order Date:");
        jPanel6.add(jLabel24);
        jLabel24.setBounds(370, 0, 120, 60);

        lbOrderDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbOrderDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbOrderDate);
        lbOrderDate.setBounds(480, 0, 180, 50);

        lbDeliveryDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbDeliveryDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbDeliveryDate);
        lbDeliveryDate.setBounds(490, 60, 170, 40);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(10, 10, 870, 150);

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL No.", "Cateogory", "Product", "Price", "Quantity", "Total"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 880, 590);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(480, 0, 890, 770);

        setSize(new java.awt.Dimension(1372, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comCategoryActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        clearFields();
        comSupplierName.setSelectedIndex(0);
        ((JTextField) txtOrderDate.getDateEditor().getUiComponent()).setText("");
        ((JTextField) txtDeliveryDate.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        new PurchaseEntry().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void comSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comSupplierNameActionPerformed

    private void comCategoryPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comCategoryPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String productCategoryId = new dbConnection().singledata("SELECT `cateogory_id` FROM `product cateogory` WHERE `cateogory`='" + comCategory.getSelectedItem().toString() + "'");
        new dbConnection().getDataFromCombo(comProduct, "SELECT `product_name` FROM `product info` where `product_category_id`='" + productCategoryId + "'");
    }//GEN-LAST:event_comCategoryPopupMenuWillBecomeInvisible

    private void comSupplierNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comSupplierNamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (comSupplierName.getSelectedIndex() > 0) {
            lbSupplier.setText(comSupplierName.getSelectedItem().toString());
        }
    }//GEN-LAST:event_comSupplierNamePopupMenuWillBecomeInvisible

    private void txtOrderIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderIdKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtOrderIdKeyPressed

    private void txtOrderIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderIdKeyReleased
        // TODO add your handling code here:
        if (!txtOrderId.getText().isEmpty()) {
            try {
                Integer.parseInt(txtOrderId.getText());
                lbOrderId.setText(txtOrderId.getText());
            } catch (Exception e) {
                lbOrderId.setText("Invalid");
            }
        }
    }//GEN-LAST:event_txtOrderIdKeyReleased

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()) {
            txtProduct.setVisible(true);
            comProduct.setVisible(false);
            txtPrice.setEditable(true);
        } else if (!jRadioButton1.isSelected()) {
            txtProduct.setVisible(false);
            comProduct.setVisible(true);
            txtPrice.setEditable(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void txtDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetailsActionPerformed

    private void comProductPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comProductPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String price1 = new dbConnection().singledata("SELECT `product_price` FROM `product info` WHERE `product_name`='" + comProduct.getSelectedItem().toString() + "'");
        txtDetails.setText(new dbConnection().singledata("SELECT `product_details` FROM `product info` WHERE `product_name`='" + comProduct.getSelectedItem().toString() + "'"));
        txtPrice.setText(price1);
    }//GEN-LAST:event_comProductPopupMenuWillBecomeInvisible

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        order();
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        // TODO add your handling code here:
        try {
            txtTotal.setText("" + (Float.parseFloat(txtPrice.getText())) * Integer.parseInt(txtQuantity.getText()));
        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        try {
            showData(txtSearch);
            lbSupplier.setText(new dbConnection().singledata("SELECT `supplier` FROM `purchaseorder` WHERE `orderId`='"+txtSearch.getText()+"'"));
            lbOrderDate.setText(new dbConnection().singledata("SELECT `orderDate` FROM `purchaseorder` where `orderId`='" + txtSearch.getText() + "'"));
            lbDeliveryDate.setText(new dbConnection().singledata("SELECT `deliveryDate` FROM `purchaseorder` where `orderId`='" + txtSearch.getText() + "'"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "something went wrong!");
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
        order();
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit1ActionPerformed

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
            java.util.logging.Logger.getLogger(Puchase_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puchase_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puchase_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puchase_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puchase_Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnPurchase;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comCategory;
    private javax.swing.JComboBox<String> comProduct;
    private javax.swing.JComboBox<String> comSupplierName;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbDeliveryDate;
    private javax.swing.JLabel lbOrderDate;
    private javax.swing.JLabel lbOrderId;
    private javax.swing.JLabel lbSupplier;
    private com.toedter.calendar.JDateChooser txtDeliveryDate;
    private javax.swing.JTextField txtDetails;
    private com.toedter.calendar.JDateChooser txtOrderDate;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
