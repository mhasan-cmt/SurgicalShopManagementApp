package prime_surgical;

import com.toedter.calendar.JCalendar;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
        Bank.setVisible(false);;
        JCalendar jc = new JCalendar();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String m = sd.format(jc.getDate());
        lb_currentDate.setText(m);
        jTextField3.setEditable(false);
        new dbConnection().getDataFromCombo(comShop, "SELECT `customer` FROM `sales accounts` GROUP BY `customer`");
    }
    String pay, shop, bill, date, address, subTotal, paid, due;
    
    void getData() {
        if (rbBank.isSelected()) {
            pay = "Bank";
        } else if (rbCash.isSelected()) {
            pay = "Cash";
        }
        shop = comShop.getSelectedItem().toString();
        bill = txtBill.getText();
        address = jTextField4.getText();
        date = lb_currentDate.getText();
        subTotal = txtSubTotal.getText();
        paid = txtPaid.getText();
        due = txtDue.getText();
    }
    
    int blankDataCheck() {
        int check = 0;
        if (comShop.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Enter customer name!");
            
        } else if (txtBill.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Bill!");
        } else if (!rbBank.isSelected() && !rbCash.isSelected()) {
            JOptionPane.showMessageDialog(this, "Enter payment!");
            rbCash.requestFocus();
        } else if (rbBank.isSelected()) {
            if (comBankName.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Enter bank name!");
                comBankName.requestFocus();
            } else if (jComboBox1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Enter bank account number!");
            }
        } else if (jTextField3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Shop name missing!");
            jTextField3.requestFocus();
        } else if (jTextField4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address missing!");
            jTextField4.requestFocus();
        } else if (txtPaid.getText().isEmpty() || Integer.parseInt(txtPaid.getText())<0) {
            JOptionPane.showMessageDialog(this, "Paid is missing!");
            txtPaid.requestFocus();
        } else {
            check = 1;
        }
        return check;
    }
    
    void salesAccounts() {
        if (blankDataCheck() == 1) {
            DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
            if (rbCash.isSelected() || rbBank.isSelected()) {
                if (rbBank.isSelected()) {
                    getData();
                    if(Float.parseFloat(paid)>0){
                    String bankName, bankAccount;
                    bankName = comBankName.getSelectedItem().toString();
                    bankAccount = jComboBox1.getSelectedItem().toString();
                    new dbConnection().addData("INSERT INTO `sales accounts` VALUES('" + bill + "','" + "Due paid" + "','" + date + "','" + shop + "','" + "0.00" + "','" + "0.00" + "','" + pay + "','" + "0.00" + "','" + paid + "','" + due + "')", this);
                    new dbConnection().addDataWithNoMessege("INSERT INTO `bank data`(`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) VALUES('" + date + "','" + bankName + "','" + bankAccount + "','" + "Sales" + "','" + "Deposit" + "','" + paid + "')");
                    txtSubTotal.setText("0.00");
                    txtPaid.setText("0.00");
                    txtSubTotal.setText("0.00");
                    comShop.setSelectedIndex(0);
                    txtBill.setText("");
                    dm.setRowCount(0);}
                    
                } else if (rbCash.isSelected()) {
                    getData();
                    if(Float.parseFloat(paid)>0){
                    new dbConnection().addData("INSERT INTO `sales accounts` VALUES('" + bill + "','" + "Due paid" + "','" + date + "','" + shop + "','" + "0" + "','" + "0.00" + "','" + pay + "','" + "0.00" + "','" + paid + "','" + due + "')", this);
                    new dbConnection().addDataWithNoMessege("INSERT INTO `cash data`(`cash_date`,`cash_details`,`cash_status`,`cash_amount`) VALUES('" + date + "','" + "Sales" + "','" + "Credit" + "','" + paid + "')");
                    txtSubTotal.setText("0.00");
                    txtPaid.setText("0.00");
                    txtSubTotal.setText("0.00");
                    dm.setRowCount(0);  
                    }else{
                        JOptionPane.showMessageDialog(this, "Enter some amount to pay!");
                    }
                    
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select Payment method!");
            }
        }
    }

    void showAccounts() {
        shop = comShop.getSelectedItem().toString();
        new dbConnection().showPurchaseAccounts("SELECT * FROM `sales accounts` WHERE `customer`='" + shop + "'", jTable1);
        subTotal = new dbConnection().singledata("SELECT SUM(total)-SUM(`paid`) FROM `sales accounts` WHERE `customer`='" + shop + "'");
        txtSubTotal.setText(subTotal);
        txtDue.setText(subTotal);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comShop = new javax.swing.JComboBox<>();
        lbShop = new javax.swing.JLabel();
        txtBill = new javax.swing.JTextField();
        rbBank = new javax.swing.JRadioButton();
        rbCash = new javax.swing.JRadioButton();
        Bank = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        comBankName = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        billPanel = new javax.swing.JPanel();
        headerPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lb_currentDate = new javax.swing.JLabel();
        lbBill = new javax.swing.JLabel();
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
        txtPaid = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtDue = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(34, 40, 49));
        jPanel1.setLayout(null);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(90, 560, 300, 40);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(490, 80, 0, 500);

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

        comShop.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        comShop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comShop.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comShopPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(comShop);
        comShop.setBounds(170, 150, 290, 40);

        lbShop.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbShop.setForeground(new java.awt.Color(255, 255, 255));
        lbShop.setText("Customer Name:");
        jPanel1.add(lbShop);
        lbShop.setBounds(30, 150, 140, 40);

        txtBill.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBillKeyReleased(evt);
            }
        });
        jPanel1.add(txtBill);
        txtBill.setBounds(170, 200, 290, 40);

        buttonGroup1.add(rbBank);
        rbBank.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        rbBank.setForeground(new java.awt.Color(255, 255, 255));
        rbBank.setText("Bank");
        rbBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBankActionPerformed(evt);
            }
        });
        jPanel1.add(rbBank);
        rbBank.setBounds(180, 290, 120, 40);

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
        jPanel1.add(rbCash);
        rbCash.setBounds(50, 290, 110, 40);

        Bank.setBackground(new java.awt.Color(0, 153, 153));
        Bank.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Bank Name:");

        comBankName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
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

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Account Number:");

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

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
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
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
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(Bank);
        Bank.setBounds(50, 350, 420, 120);

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(90, 610, 300, 40);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bill no.");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(30, 200, 140, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 510, 770);

        jPanel5.setBackground(new java.awt.Color(3, 32, 60));
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
        jLabel1.setText("CP FRESH SHOP");
        headerPane.add(jLabel1);
        jLabel1.setBounds(140, 30, 480, 57);

        jLabel4.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel4.setText("Sonargaon Janapath, Dhaka 1230");
        headerPane.add(jLabel4);
        jLabel4.setBounds(250, 110, 250, 30);

        jLabel10.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 51));
        jLabel10.setText("Email: cpfresh.uttara@gmail.com");
        headerPane.add(jLabel10);
        jLabel10.setBounds(380, 140, 320, 30);

        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        headerPane.add(jLabel42);
        jLabel42.setBounds(1262, 10, 40, 40);

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
        jLabel12.setText("House-05, Navana oval,");
        headerPane.add(jLabel12);
        jLabel12.setBounds(190, 80, 180, 30);

        jLabel13.setFont(new java.awt.Font("Kalpurush", 0, 18)); // NOI18N
        jLabel13.setText("Ground floor, Sector-07 ");
        headerPane.add(jLabel13);
        jLabel13.setBounds(370, 80, 200, 30);

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

        lb_currentDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        billPanel.add(lb_currentDate);
        lb_currentDate.setBounds(460, 190, 250, 40);

        lbBill.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        billPanel.add(lbBill);
        lbBill.setBounds(70, 190, 60, 30);

        jTextField3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        billPanel.add(jTextField3);
        jTextField3.setBounds(90, 230, 650, 40);

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setText("Name:");
        billPanel.add(jLabel17);
        jLabel17.setBounds(10, 230, 80, 40);

        jTextField4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        billPanel.add(jTextField4);
        jTextField4.setBounds(90, 270, 650, 40);

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setText("Address:");
        billPanel.add(jLabel18);
        jLabel18.setBounds(10, 270, 80, 40);

        jTable1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL.", "Bill", "Date", "Item", "Sub total", "Paid", "Due"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        billPanel.add(jScrollPane1);
        jScrollPane1.setBounds(10, 310, 730, 260);

        jTextField5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });
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

        txtPaid.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtPaid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPaid.setText("0.00");
        txtPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaidActionPerformed(evt);
            }
        });
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaidKeyTyped(evt);
            }
        });
        billPanel.add(txtPaid);
        txtPaid.setBounds(590, 600, 140, 30);

        txtSubTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtSubTotal.setText("0.00");
        billPanel.add(txtSubTotal);
        txtSubTotal.setBounds(590, 570, 130, 30);

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel26.setText("Due:");
        billPanel.add(jLabel26);
        jLabel26.setBounds(500, 630, 90, 30);

        txtDue.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtDue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtDue.setText("0.00");
        billPanel.add(txtDue);
        txtDue.setBounds(590, 630, 130, 30);

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel28.setText("Signature");
        billPanel.add(jLabel28);
        jLabel28.setBounds(590, 720, 80, 24);

        jLabel29.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel29.setText("Date:");
        billPanel.add(jLabel29);
        jLabel29.setBounds(400, 190, 50, 40);

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setText("Bill no:");
        billPanel.add(jLabel25);
        jLabel25.setBounds(10, 190, 60, 30);

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
          salesAccounts();  
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rbBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBankActionPerformed
        // TODO add your handling code here:
        if (rbBank.isSelected()) {
            Bank.setVisible(true);
            String query = "SELECT `bank_account_name` FROM `bank accounts` group by `bank_account_name`";
            new dbConnection().getDataFromCombo(comBankName, query);
            pay = "Bank";
        }
    }//GEN-LAST:event_rbBankActionPerformed

    private void rbCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCashMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbCashMouseClicked

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
        int exit = JOptionPane.showConfirmDialog(this, "Sure?", "Exit", JOptionPane.YES_NO_OPTION);
        if (exit == 0) {
            dispose();
            System.exit(0);
        }

    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void comBankNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comBankNamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String bankName = comBankName.getSelectedItem().toString();
        String query = "SELECT `bank_account_number` FROM `bank accounts` WHERE `bank_account_name`='" + bankName + "'";
        new dbConnection().getDataFromCombo(jComboBox1, query);
    }//GEN-LAST:event_comBankNamePopupMenuWillBecomeInvisible

    private void comShopPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comShopPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (comShop.getSelectedIndex()>0) {
            showAccounts();
            shop = comShop.getSelectedItem().toString();
            jTextField3.setText(shop);
            address = new dbConnection().singledata("SELECT `address` FROM `customers` WHERE `customer name`='" + comShop.getSelectedItem().toString() + "'");
            jTextField4.setText(address);
        }
    }//GEN-LAST:event_comShopPopupMenuWillBecomeInvisible

    private void txtPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidActionPerformed

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        // TODO add your handling code here:
        try {
            double totalDue, totalpaid;
            totalDue = Double.parseDouble(txtSubTotal.getText());
            totalpaid = Double.parseDouble(txtPaid.getText());
            txtDue.setText("" + (totalDue - totalpaid));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtPaidKeyReleased

    private void txtPaidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidKeyTyped

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField5KeyPressed

    private void txtBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillKeyReleased
        // TODO add your handling code here:
        lbBill.setText(txtBill.getText());
    }//GEN-LAST:event_txtBillKeyReleased

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        // TODO add your handling code here:
        jTextField4.setText("");
    }//GEN-LAST:event_jTextField4MouseClicked

    private void rbCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCashActionPerformed
        // TODO add your handling code here:
        if (rbCash.isSelected()) {
            Bank.setVisible(false);
        }
    }//GEN-LAST:event_rbCashActionPerformed

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
    private javax.swing.JPanel headerPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel lbBill;
    private javax.swing.JLabel lbShop;
    private javax.swing.JLabel lb_currentDate;
    private javax.swing.JRadioButton rbBank;
    private javax.swing.JRadioButton rbCash;
    private javax.swing.JTextField txtBill;
    private javax.swing.JLabel txtDue;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JLabel txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
