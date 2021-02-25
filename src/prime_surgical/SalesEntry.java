package prime_surgical;

import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
        initial();
    }
    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
    int salesId = 0, bill = 0, gr = 0;
    String gSalesId, gCustomerName, gBill, gDate, gCategory,
            gProductName, gProductPrice, gQuantity,
            gTotal, gSrCommission, gSrName, Ggr, gPer, gItems, gPayment, gDiscount, gPaid, gDue;
//initials

    void initial() {
        new dbConnection().getDataFromCombo(comCateogory, "SELECT `cateogory` FROM `product cateogory` order by `cateogory_id`");
        Bank.setVisible(false);
        jLabel5.setText("" + autoSalesId());
        txtBill.setText("" + autoBill());
        txtBill.setEditable(false);
        txtGR.setText("" + autoGR());
        txtGR.setEditable(false);
        txtFinalPrice.setEditable(false);
        txtSRCommission.setEditable(false);
        new dbConnection().getDataFromCombo(comSR, "SELECT `sales_name` FROM `salesofficer` ORDER BY `id`");
        JCalendar jc = new JCalendar();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String m = sd.format(jc.getDate());
        lbDate.setText(m);
    }

    int autoBill() {
        bill = 0;
        bill = new dbConnection().autoIdorBillorGR("SELECT `bill_no` FROM `sales entry` group by `bill_no`");
        bill++;
        return bill;
    }

    int autoGR() {
        gr = 0;
        gr = new dbConnection().autoIdorBillorGR("SELECT `sales_gr` FROM `sales entry` group by `sales_gr`");
        gr = gr + 10;
        return gr;
    }

    int autoSalesId() {
        salesId = 0;
        salesId = new dbConnection().autoIdorBillorGR("SELECT `sales_id` FROM `sales entry`");
        salesId++;
        return salesId;
    }

    void getData() {
        gSalesId = jLabel5.getText();
        if (comCustomerType.getSelectedIndex() == 1) {
            gCustomerName = comCustomer.getSelectedItem().toString();
        } else if (comCustomerType.getSelectedIndex() == 2) {
            gCustomerName = txtCustomerName.getText();
        }
        gBill = txtBill.getText();
        gDate = sm.format(txtDate.getDate());
        gCategory = comCateogory.getSelectedItem().toString();
        gProductName = comProduct.getSelectedItem().toString();
        gQuantity = txtQuantity.getText();
        Ggr = txtGR.getText();
        gProductPrice = txtProductPrice.getText();
        gTotal = txtFinalPrice.getText();
        gSrName = comSR.getSelectedItem().toString();
        gSrCommission = txtSRCommission.getText();
    }

    void addSales() {
        getData();
        String stockNullCheck=new dbConnection().singledata("SELECT `stock` FROM `stock` WHERE stock.`product`='" + gProductName + "'");
        if(stockNullCheck.isEmpty()){
            JOptionPane.showMessageDialog(this, "Not enough product in stock!");
        }
        else{
            int stockCheck = Integer.parseInt(stockNullCheck);
        int q = Integer.parseInt(txtQuantity.getText());
        if (q<=stockCheck) {
new dbConnection().addData("INSERT INTO `sales entry` VALUES('" + gSalesId + "','" + gBill + "','" + gCustomerName + "','" + gDate + "','" + Ggr + "','" + gCategory + "','" + gProductName + "','" + gProductPrice + "','" + gQuantity + "','" + gTotal + "')", this);
            gr = autoGR();
            salesId = autoSalesId();
            txtGR.setText("" + gr);
            jLabel5.setText("" + salesId);
            txtBill.setEnabled(false);
            showSalesEntry();
            comCateogory.setSelectedIndex(0);
            comProduct.setSelectedIndex(0);
            txtPrice.setText("0.00");
            txtVAT.setText("0.0");
            txtQuantity.setText("0");
            txtFinalPrice.setText("0.00");
        } else {
            JOptionPane.showMessageDialog(this, "Not enough product in Stock!");
        }
        }
        
    }

    int blankDataCheck() {
        int check = 0;
        if (comCustomerType.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select Customer Type!");
            comCustomerType.requestFocus();
        } else if (txtCustomerName.getText().isEmpty() && comCustomer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Enter Customer Name!");
            txtCustomerName.requestFocus();
        } else if (txtBill.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter bill number!");
            txtBill.requestFocus();
        } else if (((JTextField) txtDate.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Date!");
            txtDate.requestFocus();
        } else if (comProduct.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Enter Product!");
            comProduct.requestFocus();
        } else if (txtQuantity.getText().isEmpty() || txtQuantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Enter Quantity!");
        } else if (txtFinalPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Total is missing!");
        } else {
            check = 1;
        }
        return check;
    }

    void showSalesEntry() {
        getData();
        new dbConnection().showPurchaseEntry("SELECT * FROM `sales entry` WHERE `bill_no`='" + txtBill.getText() + "'", jTable1);
        double subTotal = Double.parseDouble(new dbConnection().singledata("SELECT SUM(`total`) FROM `sales entry` WHERE `bill_no`='" + gBill + "'"));
        txtSubTotal.setText("" + subTotal);
        txtDue.setText("" + subTotal);
        txtSubTotal.setEditable(false);
        txtDue.setEditable(false);
    }

    void getSalesCommision() {
        gSrName = comSR.getSelectedItem().toString();
        gSrCommission = txtSRCommission.getText();
        gPer = txtSRPer.getText();

    }

    int checkSalesBlank() {
        int check = 0;
        if (comSR.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Enter Sales officer name!");
            comSR.requestFocus();
        } else if (txtSRPer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter percentege!");
        } else if (txtSRCommission.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Commision amount!");
        } else {
            check = 1;
        }
        return check;
    }

    void salesCommision() {
        getSalesCommision();
        getData();
        new dbConnection().addDataWithNoMessege("INSERT INTO `cost data`(`cost_date`,`cost_type`,`cost_bill`,`cost_details`,`cost_paid_by`,`cost_amount`) VALUES('" + gDate + "',\"Sales cost\",'" + txtBill.getText() + "',\"SR Commision\",\"N/A\",'" + gSrCommission + "')");
    }

    void salesAccounts() {
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        if (rbCash.isSelected() || rbBank.isSelected() || rbDue.isSelected()) {
            if (rbBank.isSelected() && accountsBlankCheck()==1) {
                if(Float.parseFloat(txtPaid.getText())>0){
                getDataForSalesAccounts();
                String bankName, bankAccount;
                bankName = comBankName.getSelectedItem().toString();
                bankAccount = txtAccount.getSelectedItem().toString();
                new dbConnection().addData("INSERT INTO `sales accounts` VALUES('" + gBill + "','" + Ggr + "','" + gDate + "','" + gCustomerName + "','" + gItems + "','" + gTotal + "','" + gPayment + "','" + gDiscount + "','" + gPaid + "','" + gDue + "')", this);
                new dbConnection().addDataWithNoMessege("INSERT INTO `bank data`(`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) VALUES('" + gDate + "','" + bankName + "','" + bankAccount + "','" + "Sales" + "','" + "Deposit" + "','" + gPaid + "')");
                bill = autoBill();
                txtBill.setText("" + bill);
                gr = autoGR();
                txtGR.setText("" + gr);
                txtBill.setEnabled(true);
                txtSubTotal.setText("0.00");
                txtPaid.setText("0.00");
                txtDiscount.setText("0.00");
                txtDue.setText("0.00");
                dm.setRowCount(0);  
                }else{
                  JOptionPane.showMessageDialog(this, "Amount should be greater than 0!");
                }
            } else if (rbCash.isSelected()) {
                if(Float.parseFloat(txtPaid.getText())>0){
                getDataForSalesAccounts();
                new dbConnection().addData("INSERT INTO `sales accounts` VALUES('" + gBill + "','" + Ggr + "','" + gDate + "','" + gCustomerName + "','" + gItems + "','" + gTotal + "','" + gPayment + "','" + gDiscount + "','" + gPaid + "','" + gDue + "')", this);
                new dbConnection().addDataWithNoMessege("INSERT INTO `cash data`(`cash_date`,`cash_details`,`cash_status`,`cash_amount`) VALUES('" + gDate + "','" + "Sales" + "','" + "Credit" + "','" + gPaid + "')");
                bill = autoBill();
                txtBill.setText("" + bill);
                gr = autoGR();
                txtGR.setText("" + gr);
                txtBill.setEnabled(true);
                txtSubTotal.setText("0.00");
                txtPaid.setText("0.00");
                txtDiscount.setText("0.00");
                txtDue.setText("0.00");
                dm.setRowCount(0);   
                }else{
                    JOptionPane.showMessageDialog(this, "Amount should be greater than 0!");
                }
            }
            else if (rbDue.isSelected()) {
                if(Float.parseFloat(txtPaid.getText())==0){
                getDataForSalesAccounts();
                new dbConnection().addData("INSERT INTO `sales accounts` VALUES('" + gBill + "','" + Ggr + "','" + gDate + "','" + gCustomerName + "','" + gItems + "','" + gTotal + "','" + gPayment + "','" + gDiscount + "','" + gPaid + "','" + gDue + "')", this);
                bill = autoBill();
                txtBill.setText("" + bill);
                gr = autoGR();
                txtGR.setText("" + gr);
                txtBill.setEnabled(true);
                txtSubTotal.setText("0.00");
                txtPaid.setText("0.00");
                txtDiscount.setText("0.00");
                txtDue.setText("0.00");
                dm.setRowCount(0);    
                }else{
                    JOptionPane.showMessageDialog(this, "Amount should be 0!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select Payment method!");
        }

    }

    void getDataForSalesAccounts() {
        gBill = txtBill.getText();
        gCustomerName =lbShop.getText();
        gDate = lbDate.getText();
        Ggr = txtGR.getText();
        gItems = new dbConnection().singledata("SELECT Sum(`quantity`) FROM `sales entry` WHERE `bill_no`='" + gBill + "'");
        gTotal = new dbConnection().singledata("SELECT SUM(`total`) FROM `sales entry` WHERE `bill_no`='" + gBill + "'");
        if (rbBank.isSelected()) {
            gPayment = "Bank";
        } 
        else if (rbCash.isSelected()) {
            gPayment = "Cash";
        }
        else if(rbDue.isSelected()){
            gPayment="Due";
        }
        gDiscount = txtDiscount.getText();
        gPaid = txtPaid.getText();
        gDue = txtDue.getText();    
    }
int accountsBlankCheck(){
    int check=0;
    if(comBankName.getSelectedIndex()==0 || txtAccount.getSelectedIndex()==0){
        JOptionPane.showMessageDialog(this, "Enter all data for bank transaction!");
        comBankName.requestFocus();
    }
    else{
        check=1;
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
        txtCustomerName = new javax.swing.JTextField();
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
        txtPrice = new javax.swing.JTextField();
        txtGR = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comCustomer = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comSR = new javax.swing.JComboBox<>();
        txtQuantity = new javax.swing.JTextField();
        txtFinalPrice = new javax.swing.JTextField();
        comCateogory = new javax.swing.JComboBox<>();
        comCustomerType = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        txtSRPer = new javax.swing.JTextField();
        txtSRCommission = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtVAT = new javax.swing.JTextField();
        comProduct = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbBill = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbShop = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSubTotal = new javax.swing.JTextField();
        jlabel1 = new javax.swing.JLabel();
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
        rbDue = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(3, 32, 60));
        jPanel1.setLayout(null);

        txtCustomerName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyReleased(evt);
            }
        });
        jPanel1.add(txtCustomerName);
        txtCustomerName.setBounds(160, 180, 340, 40);

        txtBill.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBillMouseClicked(evt);
            }
        });
        txtBill.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtBillPropertyChange(evt);
            }
        });
        txtBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBillKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBillKeyReleased(evt);
            }
        });
        jPanel1.add(txtBill);
        txtBill.setBounds(160, 220, 340, 40);

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
        btnEdit.setBounds(250, 650, 140, 40);

        btnPurchase.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnPurchase.setText("Sale");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });
        jPanel1.add(btnPurchase);
        btnPurchase.setBounds(110, 650, 140, 40);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(170, 690, 170, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 100, 180, 40);

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

        txtPrice.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtPrice.setText("0.00");
        jPanel1.add(txtPrice);
        txtPrice.setBounds(160, 380, 220, 40);

        txtGR.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtGR.setText("0");
        jPanel1.add(txtGR);
        txtGR.setBounds(160, 500, 340, 40);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GR");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 500, 140, 40);

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Product Price");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 380, 140, 40);

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Product Quantity:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 420, 140, 40);

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 460, 140, 40);

        comCustomer.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comCustomer.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comCustomerPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(comCustomer);
        comCustomer.setBounds(160, 180, 290, 40);

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("(%)");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(100, 580, 60, 40);

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Product Name");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(20, 340, 140, 40);

        comSR.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comSR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A" }));
        comSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comSRActionPerformed(evt);
            }
        });
        jPanel1.add(comSR);
        comSR.setBounds(160, 540, 340, 40);

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
        txtQuantity.setBounds(160, 420, 110, 40);

        txtFinalPrice.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtFinalPrice.setText("0.00");
        txtFinalPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFinalPriceMouseClicked(evt);
            }
        });
        jPanel1.add(txtFinalPrice);
        txtFinalPrice.setBounds(160, 460, 340, 40);

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
        comCateogory.setBounds(160, 300, 340, 40);

        comCustomerType.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comCustomerType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Permanent", "Customer" }));
        comCustomerType.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comCustomerTypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(comCustomerType);
        comCustomerType.setBounds(160, 140, 340, 40);
        jPanel1.add(txtDate);
        txtDate.setBounds(160, 260, 340, 40);

        txtSRPer.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtSRPer.setText("0");
        txtSRPer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSRPerMouseClicked(evt);
            }
        });
        txtSRPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSRPerKeyReleased(evt);
            }
        });
        jPanel1.add(txtSRPer);
        txtSRPer.setBounds(160, 580, 80, 40);

        txtSRCommission.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtSRCommission.setText("0.00");
        txtSRCommission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSRCommissionActionPerformed(evt);
            }
        });
        jPanel1.add(txtSRCommission);
        txtSRCommission.setBounds(240, 580, 200, 40);

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Customer Type:");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(20, 140, 140, 40);

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Sales Id:");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(20, 100, 70, 40);

        txtVAT.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtVAT.setText("0.00");
        txtVAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVATMouseClicked(evt);
            }
        });
        txtVAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVATKeyReleased(evt);
            }
        });
        jPanel1.add(txtVAT);
        txtVAT.setBounds(380, 380, 120, 40);

        comProduct.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comProduct.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                comProductComponentAdded(evt);
            }
        });
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
        comProduct.setBounds(160, 340, 340, 40);

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("SR:");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(20, 540, 140, 40);

        txtProductPrice.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(txtProductPrice);
        txtProductPrice.setBounds(270, 420, 230, 40);

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("F:\\Java 23\\JavaCodes\\Prime_Surgical\\src\\img\\plus.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(440, 580, 60, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 510, 770);

        jPanel5.setBackground(new java.awt.Color(3, 32, 60));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(3, 32, 60));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(null);

        lbBill.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbBill.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbBill);
        lbBill.setBounds(70, 40, 120, 40);

        lbDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbDate);
        lbDate.setBounds(290, 40, 170, 40);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Customer Name:");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(10, 80, 150, 50);

        lbShop.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbShop.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbShop);
        lbShop.setBounds(150, 80, 270, 50);

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show Sales", "Show Orders" }));
        jPanel6.add(jComboBox1);
        jComboBox1.setBounds(650, 10, 190, 40);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bill No:");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(10, 40, 60, 40);

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
        txtSearch.setBounds(600, 90, 220, 40);

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("*Search by Order/Bill no.");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(400, 90, 200, 40);

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Date:");
        jPanel6.add(jLabel25);
        jLabel25.setBounds(240, 40, 50, 40);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 0, 850, 140);

        jTable1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.", "GR Number", "Cateogory", "Product", "Price", "Quantity", "Total"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 840, 390);

        txtSubTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtSubTotal.setText("0.00");
        jPanel5.add(txtSubTotal);
        txtSubTotal.setBounds(680, 540, 170, 40);

        jlabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlabel1.setForeground(new java.awt.Color(255, 255, 255));
        jlabel1.setText("Sub Total:");
        jPanel5.add(jlabel1);
        jlabel1.setBounds(590, 540, 90, 40);

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Discount:");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(590, 580, 90, 40);

        txtDiscount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtDiscount.setText("0.00");
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        jPanel5.add(txtDiscount);
        txtDiscount.setBounds(680, 580, 170, 40);

        txtPaid.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtPaid.setText("0.00");
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });
        jPanel5.add(txtPaid);
        txtPaid.setBounds(680, 620, 170, 40);

        txtDue.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtDue.setForeground(new java.awt.Color(255, 0, 51));
        txtDue.setText("0.00");
        jPanel5.add(txtDue);
        txtDue.setBounds(680, 660, 170, 40);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Due");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(590, 660, 90, 40);

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton6.setText("Submit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(590, 720, 170, 40);

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
        jLabel21.setBounds(590, 620, 90, 40);

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
        Bank.setBounds(60, 580, 430, 100);

        buttonGroup1.add(rbDue);
        rbDue.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        rbDue.setForeground(new java.awt.Color(255, 255, 255));
        rbDue.setText("Due");
        rbDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDueActionPerformed(evt);
            }
        });
        jPanel5.add(rbDue);
        rbDue.setBounds(320, 540, 90, 40);

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
            JOptionPane.showMessageDialog(this, "Submit Data to exit!", "Error!", JOptionPane.WARNING_MESSAGE);
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

    private void comSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comSRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comSRActionPerformed

    private void comCateogoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCateogoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comCateogoryActionPerformed

    private void comCustomerTypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comCustomerTypePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        //comCustomer
        String query = "SELECT `customer name` FROM `customers`";
        if (!comCustomerType.getSelectedItem().toString().contains("Select")) {
            if (comCustomerType.getSelectedItem().toString().contains("Permanent")) {
                comCustomer.setVisible(true);
                txtCustomerName.setVisible(false);
                new dbConnection().getDataFromCombo(comCustomer, query);
            } else {
                comCustomer.setVisible(false);
                txtCustomerName.setVisible(true);
            }
        } else {
            comCustomer.setVisible(false);
            txtCustomerName.setVisible(true);
        }

    }//GEN-LAST:event_comCustomerTypePopupMenuWillBecomeInvisible

    private void comBankNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comBankNamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String query = "SELECT `bank_account_number` FROM `bank accounts` WHERE `bank_account_name`='" + comBankName.getSelectedItem().toString() + "'";
        new dbConnection().getDataFromCombo(txtAccount, query);
    }//GEN-LAST:event_comBankNamePopupMenuWillBecomeInvisible

    private void txtSRCommissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSRCommissionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSRCommissionActionPerformed

    private void rbCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCashActionPerformed
        // TODO add your handling code here:
        if (rbCash.isSelected()) {
            Bank.setVisible(false);
        }
    }//GEN-LAST:event_rbCashActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void txtBillPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtBillPropertyChange
        // TODO add your handling code here:
        lbBill.setText(txtBill.getText());
    }//GEN-LAST:event_txtBillPropertyChange

    private void txtBillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBillKeyPressed

    private void txtBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillKeyReleased
        // TODO add your handling code here:
        if (!txtBill.getText().isEmpty()) {
            int b = Integer.parseInt(txtBill.getText());
            lbBill.setText("" + b);
        }

    }//GEN-LAST:event_txtBillKeyReleased

    private void txtCustomerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyReleased
        // TODO add your handling code here:
        if (comCustomerType.getSelectedIndex() > 0) {
            try {
                String shop = txtCustomerName.getText();
                lbShop.setText(shop);
            } catch (Exception e) {
                lbShop.setText("");
            }

        }
    }//GEN-LAST:event_txtCustomerNameKeyReleased

    private void txtCustomerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyPressed
        // TODO add your handling code here:
        if (comCustomerType.getSelectedIndex() > 0) {
            try {
                String shop = txtCustomerName.getText();
                lbShop.setText(shop);
            } catch (Exception e) {
                lbShop.setText("");
            }
        }
    }//GEN-LAST:event_txtCustomerNameKeyPressed

    private void comCustomerPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comCustomerPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (comCustomer.getSelectedIndex() > 0) {
            String lCustomer = comCustomer.getSelectedItem().toString();
            lbShop.setText(lCustomer);
        }

    }//GEN-LAST:event_comCustomerPopupMenuWillBecomeInvisible

    private void comCateogoryPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comCateogoryPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String productCategoryId = new dbConnection().singledata("SELECT `cateogory_id` FROM `product cateogory` WHERE `cateogory`='" + comCateogory.getSelectedItem().toString() + "'");
        new dbConnection().getDataFromCombo(comProduct, "SELECT `product_name` FROM `product info` where `product_category_id`='" + productCategoryId + "'");
    }//GEN-LAST:event_comCateogoryPopupMenuWillBecomeInvisible

    private void comProductPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comProductPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String price = new dbConnection().singledata("SELECT `product_price` FROM `product info` WHERE `product_name`='" + comProduct.getSelectedItem().toString() + "'");
        txtPrice.setText(price);
        txtProductPrice.setText(price);
        txtFinalPrice.setText(price);
    }//GEN-LAST:event_comProductPopupMenuWillBecomeInvisible

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        // TODO add your handling code here:
        if (comProduct.getSelectedIndex() > 0) {
            try {
                double p = Double.parseDouble(txtProductPrice.getText());
                double q = Double.parseDouble(txtQuantity.getText());
                double t = p * q;
                txtFinalPrice.setText("" + t);
        } catch (Exception e) {
                float t;
                t = 0;
                float p = Float.parseFloat(txtPrice.getText());
                float v = Float.parseFloat(txtVAT.getText());
                t = p + v;
                txtFinalPrice.setText("" + t);
            }
        }
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtVATKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVATKeyReleased
        // TODO add your handling code here:
        if (comProduct.getSelectedIndex() > 0) {
            try {
                float t;
                t = 0;
                float p = Float.parseFloat(txtPrice.getText());
                int q=Integer.parseInt(txtQuantity.getText());
                float v = Float.parseFloat(txtVAT.getText());
                txtProductPrice.setText("" +(p + v));
            } catch (Exception e) {
                String price = new dbConnection().singledata("SELECT `product_price` FROM `product info` WHERE `product_name`='" + comProduct.getSelectedItem().toString() + "'");
                txtProductPrice.setText(price);
            }
        }
    }//GEN-LAST:event_txtVATKeyReleased

    private void comProductComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_comProductComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_comProductComponentAdded

    private void txtSRPerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSRPerKeyReleased
        // TODO add your handling code here:
        try {
            if (!txtFinalPrice.getText().isEmpty()) {
                double total = Double.parseDouble(txtFinalPrice.getText());
                double per = Double.parseDouble(txtSRPer.getText());
                double percentage = (total * per) / 100.0;
                txtSRCommission.setText("" + percentage);
            }
        } catch (Exception e) {
            txtSRCommission.setText("0.00");
        }
    }//GEN-LAST:event_txtSRPerKeyReleased

    private void txtFinalPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFinalPriceMouseClicked
        // TODO add your handling code here:
        txtFinalPrice.setText("");
    }//GEN-LAST:event_txtFinalPriceMouseClicked

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        // TODO add your handling code here:
        if (blankDataCheck() == 1) {
            addSales();
        }
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(!txtBill.isEnabled()){
        salesAccounts();  
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtVATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVATMouseClicked
        // TODO add your handling code here:
        txtVAT.setText("");
    }//GEN-LAST:event_txtVATMouseClicked

    private void txtQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantityMouseClicked
        // TODO add your handling code here:
        txtQuantity.setText("");
    }//GEN-LAST:event_txtQuantityMouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jPanel3.setBackground(Color.cyan);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(new Color(0, 51, 51));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        if (blankDataCheck() == 1 && checkSalesBlank() == 1) {
            salesCommision();
            comSR.setSelectedIndex(0);
            txtSRCommission.setText("0.00");
            txtSRPer.setText("0");
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtSRPerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSRPerMouseClicked
        // TODO add your handling code here:
        txtSRPer.setText("");
    }//GEN-LAST:event_txtSRPerMouseClicked

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
        // TODO add your handling code here:
        double subtotal, discount, paid, total;
        try {
            subtotal = Double.parseDouble(txtSubTotal.getText());
            discount = Double.parseDouble(txtDiscount.getText());
            paid = Double.parseDouble(txtPaid.getText());
            total = (subtotal - discount) - paid;
            txtDue.setText("" + total);
        } catch (Exception e) {
            subtotal = Double.parseDouble(txtSubTotal.getText());
            txtDue.setText("" + subtotal);
        }

    }//GEN-LAST:event_txtDiscountKeyReleased

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        // TODO add your handling code here:
        double subtotal, discount, paid;
        try {
            subtotal = Double.parseDouble(txtSubTotal.getText());
            discount = Double.parseDouble(txtDiscount.getText());
            paid = Double.parseDouble(txtPaid.getText());
            txtDue.setText("" + ((subtotal - discount) - paid));
        } catch (Exception e) {
            subtotal = Double.parseDouble(txtSubTotal.getText());
            txtDue.setText("" + subtotal);
        }
    }//GEN-LAST:event_txtPaidKeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String search = txtSearch.getText();
        if (jComboBox1.getSelectedIndex() == 0) {
            try {
                new dbConnection().showPurchaseEntry("SELECT *FROM `sales entry` WHERE `bill_no`='" + search + "'", jTable1);
                lbBill.setText(search);
//        lbShop.setText(customer); 
                txtSubTotal.setText(new dbConnection().singledata("SELECT SUM(`total`) FROM `sales entry` WHERE `bill_no`='" + search + "'"));
            } catch (Exception e) {
                lbBill.setText(txtBill.getText());
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBillMouseClicked
        // TODO add your handling code here:
        lbBill.setText(txtBill.getText());
    }//GEN-LAST:event_txtBillMouseClicked

    private void rbDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDueActionPerformed
        // TODO add your handling code here:
        Bank.setVisible(false);
    }//GEN-LAST:event_rbDueActionPerformed

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
    private javax.swing.JComboBox<String> comCustomerType;
    private javax.swing.JComboBox<String> comProduct;
    private javax.swing.JComboBox<String> comSR;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel lbBill;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbShop;
    private javax.swing.JRadioButton rbBank;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JRadioButton rbDue;
    private javax.swing.JComboBox<String> txtAccount;
    private javax.swing.JTextField txtBill;
    private javax.swing.JTextField txtCustomerName;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtFinalPrice;
    private javax.swing.JTextField txtGR;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSRCommission;
    private javax.swing.JTextField txtSRPer;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtVAT;
    // End of variables declaration//GEN-END:variables
}
