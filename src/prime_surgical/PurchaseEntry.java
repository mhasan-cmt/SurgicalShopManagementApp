package prime_surgical;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Mahmudul Hasan
 */
public class PurchaseEntry extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers
     */
    public PurchaseEntry() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Bank.setVisible(false);
        initial();
    }
    int Ggr;
    String purchaseId, company, bill, category, product, price, quantity, total, date, gr;
    String pBill, pGR, pDate, pCompany, pItems, pTotal, pPayment, pDiscount, pPaid, pDue;
    static int bill1 = 0;

    void initial() {
        new dbConnection().getDataFromCombo(comCompany, "SELECT `supplier_company_name` FROM `suppliers`");
        String purchase_id = new dbConnection().singledata("SELECT COUNT(`purchase_id`) FROM `purchase entry`");
        int purchase_id_int = Integer.parseInt(purchase_id);
        purchase_id_int++;
        jLabel23.setText("" + purchase_id_int);
        Ggr = new dbConnection().autoIdorBillorGR("SELECT `purchase_gr` FROM `purchase entry`");
        Ggr = Ggr + 10;
        txtGR.setText("" + Ggr);
        new dbConnection().getDataFromCombo(comCateogory, "SELECT `cateogory` FROM `product cateogory` order by `cateogory_id`");
        txtTotal.setEditable(false);
        txtGR.setEditable(false);
        txtSubTotal.setEditable(false);
        txtDue.setEditable(false);
    }

    void getData() {
        purchaseId = jLabel23.getText();
        company = comCompany.getSelectedItem().toString();
        bill = txtBill.getText();
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        date = sm.format(txtDate.getDate());
        if (jRadioButton1.isSelected()) {
            product = txtProduct.getText();
        } else if (!jRadioButton1.isSelected()) {
            product = comProduct.getSelectedItem().toString();
        }
        category = comCateogory.getSelectedItem().toString();
        
        price = txtPrice.getText();
        quantity = txtQuantity.getText();
        total = txtTotal.getText();
        gr = txtGR.getText();
    }

    void purchase() {
        getData();
        new dbConnection().addData("INSERT INTO `purchase entry` VALUES('" + purchaseId + "','" + bill + "','" + company + "','" + date + "','" + gr + "','" + category + "','" + product + "','" + price + "','" + quantity + "','" + total + "')", this);
        new dbConnection().addBankOrCash("INSERT INTO `stock`(`category`,`product`,`total_purchase`,`total_sales`) VALUES('"+category+"','"+product+"','"+quantity+"','"+"0"+"')");
        showPurchase();
        comCateogory.setSelectedIndex(0);
        comProduct.setSelectedIndex(0);
        txtPrice.setText("");
        txtProduct.setText("");
        txtQuantity.setText("0");
        txtTotal.setText("0.00");
        Ggr++;
        txtGR.setText("" + Ggr);
        componentDisbled();
        String purchase_id = new dbConnection().singledata("SELECT COUNT(`purchase_id`) FROM `purchase entry`");
        int purchase_id_int = Integer.parseInt(purchase_id);
        purchase_id_int++;
        jLabel23.setText("" + purchase_id_int);
    }

    void componentDisbled() {
        txtBill.setEnabled(false);
    }

    void componentEnabled() {
        txtBill.setEnabled(true);
    }

    void showPurchase() {
        new dbConnection().showPurchaseEntry("SELECT * FROM `purchase entry` WHERE `company_name`='"+comCompany.getSelectedItem().toString()+"' AND `bill_no`='"+txtBill.getText()+"' ", jTable1);
        String total1 = new dbConnection().singledata("SELECT SUM(`total`) FROM `purchase entry` WHERE `bill_no`='" + txtBill.getText() + "'");
        txtSubTotal.setText(total1);
        txtDue.setText(total1);
        String d = ((JTextField) txtDate.getDateEditor().getUiComponent()).getText();
        ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).setText(d);
    }

    void purchaseAccounts() {
        if (rbCash.isSelected() || rbBank.isSelected()) {
            if (rbBank.isSelected()) {
                getDataForPurchaseAccounts();
                String bankName, bankAccount;
                bankName = comBankName.getSelectedItem().toString();
                bankAccount = txtAccount.getSelectedItem().toString();
                new dbConnection().addData("INSERT INTO `purchase accounts` VALUES('" + pBill + "','" + pGR + "','" + pDate + "','" + pCompany + "','" + pItems + "','" + pTotal + "','" + pPayment + "','" + pDiscount + "','" + pPaid + "','" + pDue + "')", this);
                new dbConnection().addBankOrCash("INSERT INTO `bank data`(`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) VALUES('" + pDate + "','" + bankName + "','" + bankAccount + "','" + "Purchase" + "','" + "Withdraw" + "','" + pPaid + "')");
                componentEnabled();
                Ggr = Ggr + 10;
                txtGR.setText(Ggr + "");
                bill1++;
                txtBill.setText("" + bill1);
            } else if (rbCash.isSelected()) {
                getDataForPurchaseAccounts();
                new dbConnection().addData("INSERT INTO `purchase accounts` VALUES('" + pBill + "','" + pGR + "','" + pDate + "','" + pCompany + "','" + pItems + "','" + pTotal + "','" + pPayment + "','" + pDiscount + "','" + pPaid + "','" + pDue + "')", this);
                new dbConnection().addBankOrCash("INSERT INTO `cash data`(`cash_date`,`cash_details`,`cash_status`,`cash_amount`) VALUES('" + pDate + "','" + "Purchase" + "','" + "Debit" + "','" + pPaid + "')");
                componentEnabled();
                Ggr = Ggr + 10;
                txtGR.setText(Ggr + "");
                bill1++;
                txtBill.setText("" + bill1);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select Payment method!");
        }

    }

    void getDataForPurchaseAccounts() {
        getData();
        pBill = jLabel1.getText();
        pCompany = jLabel14.getText();
        pDate = date;
        pGR = gr;
        pItems = new dbConnection().singledata("SELECT Sum(`quantity`) FROM `purchase entry` WHERE `bill_no`='" + pBill + "'");
        pTotal = new dbConnection().singledata("SELECT SUM(`total`) FROM `purchase entry` WHERE `bill_no`='" + pBill + "'");
        if (rbBank.isSelected()) {
            pPayment = "Bank";
        } else if (rbCash.isSelected()) {
            pPayment = "Cash";
        }
        if (!txtDiscount.getText().isEmpty()) {
            pDiscount = txtDiscount.getText();
        }
        if (!txtPaid.getText().isEmpty()) {
            pPaid = txtPaid.getText();
        }
        if (!txtDue.getText().isEmpty()) {
            pDue = txtDue.getText();
        }
    }

    int checkBlankData() {
        int check = 0;
        if (comCompany.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select company");
            comCompany.requestFocus();
        } else if (txtBill.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter bill number!");
            txtBill.requestFocus();
        } else if (((JTextField) txtDate.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter date!");
            txtDate.requestFocus();
        } else if (comProduct.getSelectedIndex() == 0 && txtProduct.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select Product!");
            comProduct.requestFocus();
        } else if (txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter price");
            txtPrice.requestFocus();
        } else if (txtQuantity.getText().isEmpty() || Double.parseDouble(txtQuantity.getText()) == 0.00) {
            JOptionPane.showMessageDialog(this, "Enter quantity!");
            txtQuantity.requestFocus();
        } else if (txtTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter total!");
            txtTotal.requestFocus();
        } else if (txtGR.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter gr!");
            txtGR.requestFocus();
        } else {
            check = 1;
        }
        return check;
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
        txtBill = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtGR = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        comCateogory = new javax.swing.JComboBox<>();
        comCompany = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        btnEdit1 = new javax.swing.JButton();
        btnEdit2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        comProduct = new javax.swing.JComboBox<>();
        txtProduct = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
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
        txtBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBillKeyReleased(evt);
            }
        });
        jPanel1.add(txtBill);
        txtBill.setBounds(160, 230, 290, 40);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bill no.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 230, 140, 40);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 310, 140, 40);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 270, 140, 40);

        btnEdit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEdit.setText("Delete");
        jPanel1.add(btnEdit);
        btnEdit.setBounds(100, 630, 130, 40);

        btnPurchase.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnPurchase.setText("Purchase");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });
        jPanel1.add(btnPurchase);
        btnPurchase.setBounds(50, 590, 130, 40);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(230, 630, 130, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Company Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 190, 140, 40);

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
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 510, 100);

        txtTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtTotal.setText("0.00");
        jPanel1.add(txtTotal);
        txtTotal.setBounds(160, 470, 290, 40);

        txtPrice.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtPrice);
        txtPrice.setBounds(160, 390, 290, 40);

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Product Price");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 390, 140, 40);

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Product Quantity:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 430, 140, 40);

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 470, 140, 40);

        txtGR.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtGR);
        txtGR.setBounds(160, 510, 290, 40);

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("0");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(140, 100, 130, 40);

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Product Name:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(20, 350, 140, 40);

        txtQuantity.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtQuantity.setText("0");
        txtQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQuantityMouseClicked(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });
        jPanel1.add(txtQuantity);
        txtQuantity.setBounds(160, 430, 140, 40);

        comCateogory.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comCateogory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comCateogory.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comCateogoryPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comCateogory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCateogoryActionPerformed(evt);
            }
        });
        jPanel1.add(comCateogory);
        comCateogory.setBounds(160, 310, 290, 40);

        comCompany.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comCompany.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comCompanyPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(comCompany);
        comCompany.setBounds(160, 190, 290, 40);

        txtDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDateMouseClicked(evt);
            }
        });
        jPanel1.add(txtDate);
        txtDate.setBounds(160, 270, 290, 40);

        btnEdit1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEdit1.setText("Clear");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit1);
        btnEdit1.setBounds(180, 590, 130, 40);

        btnEdit2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEdit2.setText("Edit");
        jPanel1.add(btnEdit2);
        btnEdit2.setBounds(310, 590, 130, 40);

        jRadioButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("New");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(450, 350, 59, 40);

        jRadioButton3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("New");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(450, 390, 59, 40);

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
        comProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comProductActionPerformed(evt);
            }
        });
        jPanel1.add(comProduct);
        comProduct.setBounds(160, 350, 290, 40);

        txtProduct.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(txtProduct);
        txtProduct.setBounds(160, 350, 290, 40);

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("GR:");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(20, 510, 140, 40);

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Purchase id :");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(10, 100, 120, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 520, 770);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jLabel1);
        jLabel1.setBounds(90, 10, 140, 40);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Company Name:");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(20, 50, 140, 50);

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jLabel14);
        jLabel14.setBounds(160, 50, 250, 50);

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Show Purchase", "Show purchase accounts" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel6.add(jComboBox1);
        jComboBox1.setBounds(650, 10, 190, 40);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Date:");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(270, 10, 60, 40);

        txtSearch.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel6.add(txtSearch);
        txtSearch.setBounds(620, 60, 220, 40);

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("*Search by Order/Bill no.");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(420, 60, 200, 40);
        jPanel6.add(jDateChooser1);
        jDateChooser1.setBounds(330, 10, 290, 40);

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Bill No:");
        jPanel6.add(jLabel26);
        jLabel26.setBounds(20, 10, 60, 40);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 0, 850, 110);

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.", "GR Number", "Cateogory", "Product", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 840, 430);

        txtSubTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtSubTotal.setText("0.00");
        jPanel5.add(txtSubTotal);
        txtSubTotal.setBounds(680, 540, 170, 40);

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
        txtDiscount.setText("0.00");
        txtDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDiscountMouseClicked(evt);
            }
        });
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        jPanel5.add(txtDiscount);
        txtDiscount.setBounds(680, 580, 170, 40);

        txtPaid.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtPaid.setText("0.00");
        txtPaid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPaidMouseClicked(evt);
            }
        });
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });
        jPanel5.add(txtPaid);
        txtPaid.setBounds(680, 620, 170, 40);

        txtDue.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtDue.setForeground(new java.awt.Color(204, 0, 51));
        txtDue.setText("0.00");
        jPanel5.add(txtDue);
        txtDue.setBounds(680, 660, 170, 40);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Due");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(590, 670, 90, 30);

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton6.setText("Submit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(630, 720, 180, 40);

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
        rbCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCashActionPerformed(evt);
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
        if (txtBill.isEnabled()) {
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Submit data to exit!", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void rbBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBankActionPerformed
        // TODO add your handling code here:
        if (rbBank.isSelected()) {
            Bank.setVisible(true);
            String query = "SELECT `bank_account_name` FROM `bank accounts` group by `bank_account_name`";
            new dbConnection().getDataFromCombo(comBankName, query);
        }
    }//GEN-LAST:event_rbBankActionPerformed

    private void rbBankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbBankMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_rbBankMouseClicked

    private void rbCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCashMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_rbCashMouseClicked

    private void comCateogoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCateogoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comCateogoryActionPerformed

    private void comBankNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comBankNamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String bankName = comBankName.getSelectedItem().toString();
        String query = "SELECT `bank_account_number` FROM `bank accounts` WHERE `bank_account_name`='" + bankName + "'";
        new dbConnection().getDataFromCombo(txtAccount, query);
    }//GEN-LAST:event_comBankNamePopupMenuWillBecomeInvisible

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()) {
            txtProduct.setVisible(true);
            comProduct.setVisible(false);
        } else if (!jRadioButton1.isSelected()) {
            txtProduct.setVisible(false);
            comProduct.setVisible(true);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton3.isSelected()) {
            txtPrice.setText("");
        }

    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void txtBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        // TODO add your handling code here:
        if (checkBlankData() == 1) {
            purchase();
        }
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private void comCompanyPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comCompanyPopupMenuWillBecomeInvisible
        if(comCompany.getSelectedIndex()>0){
           String companyname=comCompany.getSelectedItem().toString();
       jLabel14.setText(companyname);
        int bill_int = new dbConnection().autoIdorBillorGR("SELECT `bill_no` FROM `purchase entry` WHERE `company_name`='"+companyname+"' GROUP BY `bill_no` ");
        if(bill_int==0){
          jLabel1.setText(""+bill_int);  
        }
        bill_int++;
        bill1 = bill_int;
        txtBill.setText("" + bill_int);   
        jLabel1.setText(""+bill_int);
       }
       
    }//GEN-LAST:event_comCompanyPopupMenuWillBecomeInvisible

    private void comCateogoryPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comCateogoryPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String productCategoryId = new dbConnection().singledata("SELECT `cateogory_id` FROM `product cateogory` WHERE `cateogory`='" + comCateogory.getSelectedItem().toString() + "'");
        new dbConnection().getDataFromCombo(comProduct, "SELECT `product_name` FROM `product info` where `product_category_id`='" + productCategoryId + "'");
    }//GEN-LAST:event_comCateogoryPopupMenuWillBecomeInvisible

    private void comProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comProductActionPerformed

    private void comProductPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comProductPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String price = new dbConnection().singledata("SELECT `product_price` FROM `product info` WHERE `product_name`='" + comProduct.getSelectedItem().toString() + "'");
        txtPrice.setText(price);
    }//GEN-LAST:event_comProductPopupMenuWillBecomeInvisible

    private void txtQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantityMouseClicked
        // TODO add your handling code here:
        txtQuantity.setText("");
    }//GEN-LAST:event_txtQuantityMouseClicked

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        // TODO add your handling code here:
        try {
            double p = Double.parseDouble(txtPrice.getText());
            double q = Double.parseDouble(txtQuantity.getText());
            double t = p * q;
            txtTotal.setText("" + t);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtQuantityKeyReleased

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void rbCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCashActionPerformed
        // TODO add your handling code here:
        if (rbCash.isSelected()) {
            Bank.setVisible(false);
        }
    }//GEN-LAST:event_rbCashActionPerformed

    private void txtBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillKeyReleased
        // TODO add your handling code here:
        jLabel1.setText(txtBill.getText());
    }//GEN-LAST:event_txtBillKeyReleased

    private void txtBillPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtBillPropertyChange
        // TODO add your handling code here:
        jLabel1.setText(txtBill.getText());
    }//GEN-LAST:event_txtBillPropertyChange

    private void txtDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDiscountMouseClicked
        // TODO add your handling code here:
        txtDiscount.setText("");
    }//GEN-LAST:event_txtDiscountMouseClicked

    private void txtPaidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaidMouseClicked
        // TODO add your handling code here:
        txtPaid.setText("");
    }//GEN-LAST:event_txtPaidMouseClicked

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
        // TODO add your handling code here:
        try {
            double t, d, p;
            t = Double.parseDouble(txtSubTotal.getText());
            d = Double.parseDouble(txtDiscount.getText());
            p=Double.parseDouble(txtPaid.getText());
            double due = (t - d)-p;
            txtDue.setText("" + due);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtDiscountKeyReleased

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        // TODO add your handling code here:
        try {
            double p, d, t;
            p = Double.parseDouble(txtPaid.getText());
            d = Double.parseDouble(txtDiscount.getText());
            t = Double.parseDouble(txtSubTotal.getText());
            double due = t - d - p;
            txtDue.setText("" + due);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtPaidKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        purchaseAccounts();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateMouseClicked

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem().equals("Show Purchase")) {
            new dbConnection().showPurchaseEntry("SELECT * FROM `purchase entry`", jTable1);
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String search = txtSearch.getText();
        String companyt = new dbConnection().singledata("SELECT `company_name` FROM `purchase entry` WHERE `bill_no`='" + search + "'");
        if(jComboBox1.getSelectedIndex()==1){
        new dbConnection().showPurchaseEntry("SELECT *FROM `purchase entry` WHERE `bill_no`='" + search + "'", jTable1);
        txtTotal.setText(new dbConnection().singledata(""));
        jLabel1.setText(search);
        jLabel14.setText(companyt);}
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnEdit2;
    private javax.swing.JButton btnPurchase;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comBankName;
    private javax.swing.JComboBox<String> comCateogory;
    private javax.swing.JComboBox<String> comCompany;
    private javax.swing.JComboBox<String> comProduct;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbBank;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JComboBox<String> txtAccount;
    private javax.swing.JTextField txtBill;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtGR;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
