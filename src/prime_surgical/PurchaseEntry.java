package prime_surgical;

import com.toedter.calendar.JCalendar;

import java.awt.event.KeyEvent;

import java.text.SimpleDateFormat;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

/**
 *
 *
 *
 * @author Mahmudul Hasan
 *
 */
public class PurchaseEntry extends javax.swing.JFrame {

    /**
     *
     * Creates new form Suppliers
     *
     */
    public PurchaseEntry() {

        initComponents();

        initial();

    }

    String company, bill, date, cateogory, product, price, quantity, total, gr;

    void initial() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Bank.setVisible(false);

        txtPname.setVisible(false);

        getp();

        getc();

        txtBill.setText(autoBill() + 1 + "");

        txtGR.setText(autoGR() + 10 + "");

        JCalendar jc = new JCalendar();

        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

        date = sm.format(jc.getDate());

        ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).setText(date);

        txtTotal.setEditable(false);

    }

    void getp() {

        String query = "SELECT `company name` FROM `suppliers`";

        new dbConnection().getDataFromCombo(jComboBox2, query);

    }

    void getc() {

        String query = "SELECT `cateogory` FROM `product cateogory` GROUP BY `cateogory`";

        new dbConnection().getDataFromCombo(jComboBox3, query);

    }

    void getpr() {

        String query = "SELECT `product name` FROM `product cateogory` WHERE `cateogory`='" + jComboBox3.getSelectedItem().toString() + "' GROUP BY `product name`";

        new dbConnection().getDataFromCombo(comPname, query);

        //comPname
    }

    void getData() {

        try {

            company = jComboBox2.getSelectedItem().toString();

            bill = txtBill.getText();
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
            date = sm.format(txtDate.getDate());
            cateogory = jComboBox3.getSelectedItem().toString();

            if (comPname.getSelectedIndex() == 0) {

                product = txtPname.getText();

            } else {

                product = comPname.getSelectedItem().toString();

            }

            price = txtPprice.getText();

            quantity = txtQuantity.getText();

            total = txtTotal.getText();

            gr = txtGR.getText();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "ERROR:" + e);

        }

    }

    void addPurchase() {

        try {

            if (datacheck() == 1) {

                getData();

                String query = "INSERT INTO `purchaseentry` VALUES('" + bill + "','" + company + "','" + date + "','" + cateogory + "','" + product + "','" + price + "','" + quantity + "','" + total + "','" + gr + "')";

                new dbConnection().addData(query, this);

                showD();

                txtGR.setText(autoGR() + 10 + "");

                clearDataField();

                editableFalse();

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "EROR", "ERROR OCCURED:" + e, JOptionPane.ERROR_MESSAGE);

        }

    }

    int autoBill() {

        String query = "SELECT `bill no.` FROM `purchaseentry` ORDER BY `bill no.` ASC";

        return new dbConnection().autoIdorBillorGR(query);

    }

    int autoGR() {

        String query = "SELECT `gr` FROM `purchaseentry`";

        return new dbConnection().autoIdorBillorGR(query);

    }

    int datacheck() {

        int a = 0;

        String d = ((JTextField) txtDate.getDateEditor().getUiComponent()).getText();

        if (jComboBox2.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(this, "Select Company name!");

        } else if (txtBill.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Enter bill number!");

        } else if (d.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Enter Date!");

        } else if (jComboBox3.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(this, "Select Product Cateogory!");

        } else if (txtPname.getText().isEmpty() && comPname.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(this, "Enter Products Name!");

        } else if (txtPprice.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Enter Products Price!");

        } else if (txtQuantity.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Enter Products QuantitY!");

        } else if (txtGR.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Enter GR Number!");
        } else {

            a = 1;

        }

        return a;

    }

    void showD() {

        String q = "SELECT * FROM `purchaseentry` WHERE `bill no.`='" + txtBill.getText() + "'";

        new dbConnection().showDataForSalesOfficerTable(q, jTable1);

    }

    void clearDataField() {

        try {

            ((JTextField) txtDate.getDateEditor().getUiComponent()).setText("");

            jComboBox3.setSelectedIndex(0);

            txtPname.setText("");

            comPname.setSelectedIndex(0);

            txtPprice.setText("");

            txtQuantity.setText("");

            txtTotal.setText("0.00");

        } catch (Exception e) {

        }

    }

    void updateData() {

        try {

            if (datacheck() == 1) {

                getData();

                String query = "UPDATE `purchaseentry` SET `bill no.`='" + bill + "',`company`='" + company + "',`date`='" + date + "',`cateogory`'" + cateogory + "',`product name`='" + product + "',`price`='" + price + "',`quantity`='" + quantity + "',`total`='" + total + "',`gr`='" + gr + "'";

                new dbConnection().updateData(query, this);

                showD();

            }

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(this, "ERROR:" + e);

        }

    }

    void editableFalse() {

        jComboBox2.setEnabled(false);

        txtBill.setEditable(false);

        txtDate.setEnabled(false);

        jComboBox3.setEnabled(false);

        txtPname.setEditable(false);

        comPname.setEnabled(false);

        txtPprice.setEditable(false);

        txtQuantity.setEditable(false);

        txtTotal.setEditable(false);

        txtGR.setEditable(false);

    }

    void editableTrue() {

        jComboBox2.setEnabled(true);

        txtBill.setEditable(true);

        txtDate.setEnabled(true);

        jComboBox3.setEnabled(true);

        txtPname.setEditable(true);

        comPname.setEnabled(true);

        txtPprice.setEditable(true);

        txtQuantity.setEditable(true);

        txtTotal.setEditable(true);

        txtGR.setEditable(true);

    }

    /**
     *
     * This method is called from within the constructor to initialize the form.
     *
     * WARNING: Do NOT modify this code. The content of this method is always
     *
     * regenerated by the Form Editor.
     *
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {



        buttonGroup1 = new javax.swing.ButtonGroup();

        jPanel1 = new javax.swing.JPanel();

        txtBill = new javax.swing.JTextField();

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

        txtGR = new javax.swing.JTextField();

        txtTotal = new javax.swing.JTextField();

        txtPname = new javax.swing.JTextField();

        txtPprice = new javax.swing.JTextField();

        comPname = new javax.swing.JComboBox<>();

        jLabel10 = new javax.swing.JLabel();

        jLabel11 = new javax.swing.JLabel();

        jLabel12 = new javax.swing.JLabel();

        jLabel13 = new javax.swing.JLabel();

        txtDate = new com.toedter.calendar.JDateChooser();

        rbPprice = new javax.swing.JRadioButton();

        rbPname = new javax.swing.JRadioButton();

        txtQuantity = new javax.swing.JTextField();

        jComboBox2 = new javax.swing.JComboBox<>();

        jComboBox3 = new javax.swing.JComboBox<>();

        jPanel5 = new javax.swing.JPanel();

        jPanel6 = new javax.swing.JPanel();

        jLabel1 = new javax.swing.JLabel();

        jLabel3 = new javax.swing.JLabel();

        jLabel9 = new javax.swing.JLabel();

        jLabel14 = new javax.swing.JLabel();

        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel15 = new javax.swing.JLabel();

        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        txtId1 = new javax.swing.JTextField();

        jLabel16 = new javax.swing.JLabel();

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

        comAccountnumber = new javax.swing.JComboBox<>();



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setUndecorated(true);

        getContentPane().setLayout(null);



        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setLayout(null);



        txtBill.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        txtBill.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                txtBillActionPerformed(evt);

            }

        });

        txtBill.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {

                txtBillPropertyChange(evt);

            }

        });

        jPanel1.add(txtBill);

        txtBill.setBounds(160, 190, 290, 40);



        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Date:");

        jPanel1.add(jLabel2);

        jLabel2.setBounds(20, 230, 140, 40);



        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Bill no:");

        jPanel1.add(jLabel4);

        jLabel4.setBounds(20, 190, 140, 40);



        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Product Name:");

        jPanel1.add(jLabel6);

        jLabel6.setBounds(20, 310, 140, 40);



        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Cateogory:");

        jPanel1.add(jLabel7);

        jLabel7.setBounds(20, 270, 140, 40);



        btnEdit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        btnEdit.setText("Edit");

        btnEdit.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btnEditActionPerformed(evt);

            }

        });

        jPanel1.add(btnEdit);

        btnEdit.setBounds(340, 580, 130, 40);



        btnPurchase.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        btnPurchase.setText("Purchase");

        btnPurchase.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btnPurchaseActionPerformed(evt);

            }

        });

        jPanel1.add(btnPurchase);

        btnPurchase.setBounds(60, 580, 130, 40);



        btnClear.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        btnClear.setText("Clear");

        btnClear.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btnClearActionPerformed(evt);

            }

        });

        jPanel1.add(btnClear);

        btnClear.setBounds(200, 580, 130, 40);



        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jButton4.setText("Exit");

        jButton4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jButton4ActionPerformed(evt);

            }

        });

        jPanel1.add(jButton4);

        jButton4.setBounds(260, 630, 130, 40);



        btnDelete.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        btnDelete.setText("Delete");

        jPanel1.add(btnDelete);

        btnDelete.setBounds(120, 630, 130, 40);



        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jPanel4.setLayout(null);

        jPanel1.add(jPanel4);

        jPanel4.setBounds(490, 80, 0, 500);



        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Company:");

        jPanel1.add(jLabel5);

        jLabel5.setBounds(20, 150, 140, 40);



        jPanel2.setBackground(new java.awt.Color(102, 102, 102));



        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setText("Purchase Entry");



        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);

        jPanel2.setLayout(jPanel2Layout);

        jPanel2Layout.setHorizontalGroup(

            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)

        );

        jPanel2Layout.setVerticalGroup(

            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)

        );



        jPanel1.add(jPanel2);

        jPanel2.setBounds(0, 0, 510, 60);



        txtGR.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel1.add(txtGR);

        txtGR.setBounds(160, 470, 290, 40);



        txtTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        txtTotal.setText("0.00");

        jPanel1.add(txtTotal);

        txtTotal.setBounds(160, 430, 290, 40);



        txtPname.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel1.add(txtPname);

        txtPname.setBounds(160, 310, 290, 40);



        txtPprice.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        txtPprice.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                txtPpriceActionPerformed(evt);

            }

        });

        jPanel1.add(txtPprice);

        txtPprice.setBounds(160, 350, 290, 40);



        comPname.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        comPname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        comPname.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                comPnameActionPerformed(evt);

            }

        });

        jPanel1.add(comPname);

        comPname.setBounds(160, 310, 290, 40);



        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Product Price:");

        jPanel1.add(jLabel10);

        jLabel10.setBounds(20, 350, 140, 40);



        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Product Quantity:");

        jPanel1.add(jLabel11);

        jLabel11.setBounds(20, 390, 140, 40);



        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Total:");

        jPanel1.add(jLabel12);

        jLabel12.setBounds(20, 430, 140, 40);



        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("GR:");

        jPanel1.add(jLabel13);

        jLabel13.setBounds(20, 470, 140, 40);

        jPanel1.add(txtDate);

        txtDate.setBounds(160, 230, 290, 40);



        rbPprice.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        rbPprice.setForeground(new java.awt.Color(255, 255, 255));

        rbPprice.setText("New");

        rbPprice.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                rbPpriceMouseClicked(evt);

            }

        });

        jPanel1.add(rbPprice);

        rbPprice.setBounds(450, 350, 60, 40);



        rbPname.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        rbPname.setForeground(new java.awt.Color(255, 255, 255));

        rbPname.setText("New");

        rbPname.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                rbPnameMouseClicked(evt);

            }

        });

        jPanel1.add(rbPname);

        rbPname.setBounds(450, 310, 60, 40);



        txtQuantity.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {

                txtQuantityKeyPressed(evt);

            }

            public void keyReleased(java.awt.event.KeyEvent evt) {

                txtQuantityKeyReleased(evt);

            }

        });

        jPanel1.add(txtQuantity);

        txtQuantity.setBounds(160, 390, 290, 40);



        jComboBox2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {

            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {

            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {

                jComboBox2PopupMenuWillBecomeInvisible(evt);

            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {

            }

        });

        jPanel1.add(jComboBox2);

        jComboBox2.setBounds(160, 150, 290, 40);



        jComboBox3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jComboBox3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {

            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {

            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {

                jComboBox3PopupMenuWillBecomeInvisible(evt);

            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {

            }

        });

        jPanel1.add(jComboBox3);

        jComboBox3.setBounds(160, 270, 290, 40);



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

        jPanel6.add(jLabel1);

        jLabel1.setBounds(80, 40, 130, 40);



        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Date:");

        jPanel6.add(jLabel3);

        jLabel3.setBounds(340, 10, 60, 40);



        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Company Name:");

        jPanel6.add(jLabel9);

        jLabel9.setBounds(10, 80, 150, 40);



        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));

        jPanel6.add(jLabel14);

        jLabel14.setBounds(160, 80, 310, 40);



        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Purchase Entries", "Purchase Submits" }));

        jPanel6.add(jComboBox1);

        jComboBox1.setBounds(650, 10, 190, 40);



        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Bill No:");

        jPanel6.add(jLabel15);

        jLabel15.setBounds(10, 40, 60, 40);

        jPanel6.add(jDateChooser2);

        jDateChooser2.setBounds(400, 10, 240, 40);



        txtId1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        txtId1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                txtId1ActionPerformed(evt);

            }

        });

        txtId1.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {

                txtId1KeyPressed(evt);

            }

        });

        jPanel6.add(txtId1);

        txtId1.setBounds(670, 80, 170, 40);



        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("*Search by Order/Bill no.");

        jPanel6.add(jLabel16);

        jLabel16.setBounds(470, 80, 200, 40);



        jPanel5.add(jPanel6);

        jPanel6.setBounds(0, 0, 850, 140);



        jTable1.setModel(new javax.swing.table.DefaultTableModel(

            new Object [][] {



            },

            new String [] {

                "Bill no.", "Company ", "Date", "Cateogory", "Product Name", "Price", "Quantity", "Total", "GR"

            }

        ));

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                jTable1MouseClicked(evt);

            }

        });

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

        jLabel18.setBounds(590, 580, 90, 30);



        txtDiscount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel5.add(txtDiscount);

        txtDiscount.setBounds(680, 580, 170, 30);



        txtPaid.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel5.add(txtPaid);

        txtPaid.setBounds(680, 610, 170, 30);



        txtDue.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel5.add(txtDue);

        txtDue.setBounds(680, 640, 170, 30);



        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setText("Due");

        jPanel5.add(jLabel20);

        jLabel20.setBounds(590, 640, 90, 30);



        jButton6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jButton6.setText("Submit");

        jButton6.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jButton6ActionPerformed(evt);

            }

        });

        jPanel5.add(jButton6);

        jButton6.setBounds(610, 710, 240, 40);



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

        jLabel21.setBounds(590, 610, 90, 30);



        Bank.setBackground(new java.awt.Color(0, 153, 153));

        Bank.setBorder(new javax.swing.border.MatteBorder(null));

        Bank.setLayout(null);



        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));

        jLabel22.setText("Bank Name:");

        Bank.add(jLabel22);

        jLabel22.setBounds(10, 10, 150, 40);



        comBankName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

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

        comBankName.setBounds(160, 10, 250, 40);



        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setText("Account Number:");

        Bank.add(jLabel19);

        jLabel19.setBounds(10, 50, 150, 40);



        comAccountnumber.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        comAccountnumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        Bank.add(comAccountnumber);

        comAccountnumber.setBounds(160, 50, 250, 40);



        jPanel5.add(Bank);

        Bank.setBounds(90, 590, 420, 100);



        getContentPane().add(jPanel5);

        jPanel5.setBounds(510, 0, 860, 770);



        setSize(new java.awt.Dimension(1366, 768));

        setLocationRelativeTo(null);

    }// </editor-fold>//GEN-END:initComponents


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // TODO add your handling code here:
        if (!jComboBox2.isEnabled()) {

            JOptionPane.showMessageDialog(this, "Submit Data to exit!");

        } else {

            this.dispose();

        }

    }//GEN-LAST:event_jButton4ActionPerformed


    private void rbBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBankActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_rbBankActionPerformed


    private void rbBankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbBankMouseClicked

        // TODO add your handling code here:
        if (rbBank.isSelected()) {

            Bank.setVisible(true);

            String query = "SELECT `bank name` FROM `bank accounts`";

            new dbConnection().getDataFromCombo(comBankName, query);

        }

    }//GEN-LAST:event_rbBankMouseClicked


    private void rbCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCashMouseClicked

        // TODO add your handling code here:
        if (rbCash.isSelected()) {

            Bank.setVisible(false);

        }

    }//GEN-LAST:event_rbCashMouseClicked


    private void comPnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPnameActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_comPnameActionPerformed


    private void rbPnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPnameMouseClicked

        // TODO add your handling code here:
        if (rbPname.isSelected()) {

            txtPname.setVisible(true);

        } else if (!rbPname.isSelected()) {

            txtPname.setVisible(false);

        }

    }//GEN-LAST:event_rbPnameMouseClicked


    private void rbPpriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPpriceMouseClicked

        // TODO add your handling code here:
        if (rbPprice.isSelected()) {

            txtPprice.setText("");

        }

    }//GEN-LAST:event_rbPpriceMouseClicked


    private void jComboBox3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox3PopupMenuWillBecomeInvisible

        // TODO add your handling code here:
        getpr();

    }//GEN-LAST:event_jComboBox3PopupMenuWillBecomeInvisible


    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed

        // TODO add your handling code here:
        addPurchase();

    }//GEN-LAST:event_btnPurchaseActionPerformed


    private void comBankNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comBankNamePopupMenuWillBecomeInvisible

        // TODO add your handling code here:
        String query = "SELECT `account no` FROM `bank accounts` WHERE `bank name`='" + comBankName.getSelectedItem().toString() + "'";

        new dbConnection().getDataFromCombo(comAccountnumber, query);

    }//GEN-LAST:event_comBankNamePopupMenuWillBecomeInvisible


    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible

        // TODO add your handling code here:
        if (!jComboBox2.getSelectedItem().toString().contains("Select")) {

            jLabel14.setText(jComboBox2.getSelectedItem().toString());

        }


    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible


    private void txtBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillActionPerformed

        // TODO add your handling code here:
        jLabel1.setText(txtBill.getText());

    }//GEN-LAST:event_txtBillActionPerformed


    private void txtBillPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtBillPropertyChange

        // TODO add your handling code here:
        jLabel1.setText(txtBill.getText());

    }//GEN-LAST:event_txtBillPropertyChange


    private void txtQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyPressed

        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            double Lprice = Double.parseDouble(txtPprice.getText());

            double LQuantity = Double.parseDouble(txtQuantity.getText());

            txtTotal.setText(Lprice * LQuantity + "");

        }

    }//GEN-LAST:event_txtQuantityKeyPressed


    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        // TODO add your handling code here:
        clearDataField();

    }//GEN-LAST:event_btnClearActionPerformed


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

        String Lbill = dtm.getValueAt(jTable1.getSelectedRow(), 0).toString();

        String Lcompany = dtm.getValueAt(jTable1.getSelectedRow(), 1).toString();

        String Ldate = dtm.getValueAt(jTable1.getSelectedRow(), 2).toString();

        String Lcat = dtm.getValueAt(jTable1.getSelectedRow(), 3).toString();

        String Lproduct = dtm.getValueAt(jTable1.getSelectedRow(), 4).toString();

        String Lprice = dtm.getValueAt(jTable1.getSelectedRow(), 5).toString();

        String Lquantity = dtm.getValueAt(jTable1.getSelectedRow(), 6).toString();

        String Ltotal = dtm.getValueAt(jTable1.getSelectedRow(), 7).toString();

        String Lgr = dtm.getValueAt(jTable1.getSelectedRow(), 8).toString();

        jLabel1.setText(Lbill);

        jLabel14.setText(Lcompany);

        jComboBox2.setSelectedItem(Lcompany);

        ((JTextField) txtDate.getDateEditor().getUiComponent()).setText(Ldate);

        jComboBox3.setSelectedItem(Lcat);

        txtPname.setText(Lproduct);

        comPname.setSelectedItem(Lproduct);

        txtPprice.setText(Lprice);

        txtQuantity.setText(Lquantity);

        txtTotal.setText(Ltotal);

        txtGR.setText(Lgr);

    }//GEN-LAST:event_jTable1MouseClicked


    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        // TODO add your handling code here:
        updateData();

    }//GEN-LAST:event_btnEditActionPerformed


    private void txtId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId1ActionPerformed


    }//GEN-LAST:event_txtId1ActionPerformed


    private void txtId1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId1KeyPressed

        // TODO add your handling code here:
        if (!txtId1.getText().isEmpty()) {

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                if (jComboBox1.getSelectedItem() == "Purchase Entries") {

                    String q = "SELECT * FROM `purchaseentry` WHERE `bill no.`='" + txtId1.getText() + "'";

                    new dbConnection().showDataForSalesOfficerTable(q, jTable1);

                } else if (jComboBox1.getSelectedItem() == "Purchase Submits") {

                    JOptionPane.showMessageDialog(this, "No DATA Found!");

                }
            }
        }

    }//GEN-LAST:event_txtId1KeyPressed


    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        // TODO add your handling code here:
        editableTrue();

    }//GEN-LAST:event_jButton6ActionPerformed


    private void txtPpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPpriceActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_txtPpriceActionPerformed


    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased

        // TODO add your handling code here:
        if (!txtQuantity.getText().isEmpty()) {

            double Lprice = Double.parseDouble(txtPprice.getText());

            double LQuantity = Double.parseDouble(txtQuantity.getText());

            txtTotal.setText(Lprice * LQuantity + "");

        }


    }//GEN-LAST:event_txtQuantityKeyReleased

    /**
     *
     * @param args the command line arguments
     *
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

            java.util.logging.Logger.getLogger(PurchaseEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(PurchaseEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(PurchaseEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(PurchaseEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new PurchaseEntry().setVisible(true);

            }

        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JPanel Bank;

    private javax.swing.JButton btnClear;

    private javax.swing.JButton btnDelete;

    private javax.swing.JButton btnEdit;

    private javax.swing.JButton btnPurchase;

    private javax.swing.ButtonGroup buttonGroup1;

    private javax.swing.JComboBox<String> comAccountnumber;

    private javax.swing.JComboBox<String> comBankName;

    private javax.swing.JComboBox<String> comPname;

    private javax.swing.JButton jButton4;

    private javax.swing.JButton jButton6;

    private javax.swing.JComboBox<String> jComboBox1;

    private javax.swing.JComboBox<String> jComboBox2;

    private javax.swing.JComboBox<String> jComboBox3;

    private com.toedter.calendar.JDateChooser jDateChooser2;

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

    private javax.swing.JRadioButton rbPname;

    private javax.swing.JRadioButton rbPprice;

    private javax.swing.JTextField txtBill;

    private com.toedter.calendar.JDateChooser txtDate;

    private javax.swing.JTextField txtDiscount;

    private javax.swing.JTextField txtDue;

    private javax.swing.JTextField txtGR;

    private javax.swing.JTextField txtId1;

    private javax.swing.JTextField txtPaid;

    private javax.swing.JTextField txtPname;

    private javax.swing.JTextField txtPprice;

    private javax.swing.JTextField txtQuantity;

    private javax.swing.JTextField txtSubTotal;

    private javax.swing.JTextField txtTotal;

    // End of variables declaration//GEN-END:variables
}
