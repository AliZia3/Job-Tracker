import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class JobTracker extends javax.swing.JFrame {
    
    public JobTracker() {
        initComponents();
        Connect();
        updateTable("");
    }
    
    Connection sqlConn;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/job-tracker", "root", "I5eeY0u@03");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JobTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateTable(String searchTerm) {
        int columnCount;
        try {
            pst = sqlConn.prepareStatement("SELECT * FROM applications WHERE Jobtitle LIKE ? OR Company LIKE ? OR Term LIKE ? OR AppliedThrough LIKE ? OR Status LIKE ?");
            for (int i = 1; i <= 5; i++) {
                pst.setString(i, "%" + searchTerm + "%");
            }
            
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();
            
            DefaultTableModel dft = (DefaultTableModel) DataTable.getModel();
            dft.setRowCount(0);
            int rowCount = 0;
            
            while (rs.next()) {
            Vector columnData = new Vector();

            for (int i = 1; i <= columnCount; i++) {
                columnData.add(rs.getString(i)); // Retrieve data by column index (i)
            }

            dft.addRow(columnData);
            rowCount++;
        }
//        TotalApplicationsCount.setText(Integer.toString(rowCount));
                    
        } catch (SQLException ex) {
            Logger.getLogger(JobTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        InnerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JobTitleTextField = new javax.swing.JTextField();
        CompanyTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTable = new javax.swing.JTable();
        StatusTextField = new javax.swing.JComboBox<>();
        AppliedThroughTextField = new javax.swing.JComboBox<>();
        TermTextField = new javax.swing.JComboBox<>();
        ResetFieldsBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        PieChartBtn = new javax.swing.JButton();
        BarChartBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(26, 54, 102));
        MainPanel.setMinimumSize(new java.awt.Dimension(1200, 800));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/jobtrackericon.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Job-Tracker");

        InnerPanel.setBackground(new java.awt.Color(47, 84, 148));
        InnerPanel.setMinimumSize(new java.awt.Dimension(950, 620));
        InnerPanel.setPreferredSize(new java.awt.Dimension(950, 620));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Job Title:");
        jLabel2.setMaximumSize(null);
        jLabel2.setMinimumSize(null);
        jLabel2.setPreferredSize(null);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Company:");
        jLabel3.setMaximumSize(null);
        jLabel3.setMinimumSize(null);
        jLabel3.setPreferredSize(null);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Term:");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Applied Through:");
        jLabel5.setMaximumSize(null);
        jLabel5.setMinimumSize(null);
        jLabel5.setPreferredSize(null);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Status:");
        jLabel6.setMaximumSize(null);
        jLabel6.setMinimumSize(null);
        jLabel6.setPreferredSize(null);

        JobTitleTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        CompanyTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Job Title", "Company", "Term", "Applied Through", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DataTable);

        StatusTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        StatusTextField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select From Options...", "No Response", "Rejected", "Phone Screening", "Phone Screening Rejection", "Interview", "Interview Rejection", "Offer", "Accepted Offer", "Rejected Offer" }));
        StatusTextField.setBorder(null);

        AppliedThroughTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AppliedThroughTextField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select From Options...", "OscarPlus", "Linkedin", "Google", "Indeed", "Monster" }));
        AppliedThroughTextField.setBorder(null);

        TermTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TermTextField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select From Options...", "Summer 2023", "Fall 2023", "Winter 2024", "Summer 2024", "Fall 2024", "Winter 2025", "Summer 2025" }));
        TermTextField.setBorder(null);

        javax.swing.GroupLayout InnerPanelLayout = new javax.swing.GroupLayout(InnerPanel);
        InnerPanel.setLayout(InnerPanelLayout);
        InnerPanelLayout.setHorizontalGroup(
            InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InnerPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InnerPanelLayout.createSequentialGroup()
                        .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InnerPanelLayout.createSequentialGroup()
                                .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(InnerPanelLayout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(JobTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InnerPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AppliedThroughTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(StatusTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TermTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(52, 328, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(25, 25, 25))
        );
        InnerPanelLayout.setVerticalGroup(
            InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InnerPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JobTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CompanyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TermTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AppliedThroughTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        ResetFieldsBtn.setBackground(new java.awt.Color(47, 50, 235));
        ResetFieldsBtn.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        ResetFieldsBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetFieldsBtn.setText("Reset Fields");
        ResetFieldsBtn.setBorder(null);
        ResetFieldsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetFieldsBtnActionPerformed(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(47, 50, 235));
        AddBtn.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add");
        AddBtn.setBorder(null);
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setBackground(new java.awt.Color(47, 50, 235));
        UpdateBtn.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        UpdateBtn.setText("Update");
        UpdateBtn.setBorder(null);
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(new java.awt.Color(47, 50, 235));
        DeleteBtn.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBtn.setText("Delete");
        DeleteBtn.setBorder(null);
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        ExitBtn.setBackground(new java.awt.Color(204, 12, 53));
        ExitBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        ExitBtn.setForeground(new java.awt.Color(255, 255, 255));
        ExitBtn.setText("Exit");
        ExitBtn.setToolTipText("");
        ExitBtn.setBorder(null);
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        PieChartBtn.setBackground(new java.awt.Color(117, 23, 194));
        PieChartBtn.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        PieChartBtn.setForeground(new java.awt.Color(255, 255, 255));
        PieChartBtn.setText("Pie Chart");
        PieChartBtn.setBorder(null);
        PieChartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PieChartBtnActionPerformed(evt);
            }
        });

        BarChartBtn.setBackground(new java.awt.Color(117, 23, 194));
        BarChartBtn.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        BarChartBtn.setForeground(new java.awt.Color(255, 255, 255));
        BarChartBtn.setText("Bar Chart");
        BarChartBtn.setBorder(null);
        BarChartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarChartBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Visualization");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Search:");

        SearchTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(InnerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ResetFieldsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PieChartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BarChartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7)
                                    .addGap(25, 25, 25)))
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SearchTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(52, 52, 52))))
                        .addGap(31, 31, 31))))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ResetFieldsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(37, 37, 37)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PieChartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BarChartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(ExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                    .addComponent(InnerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        if("".equals(JobTitleTextField.getText()) || "".equals(CompanyTextField.getText()) || TermTextField.getSelectedIndex() == 0 || AppliedThroughTextField.getSelectedIndex() == 0 || StatusTextField.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(this, "Fill In All Fields");
        }
        else {
            try {
                pst = sqlConn.prepareStatement("insert into applications(JobTitle,Company,Term,AppliedThrough,Status)values(?,?,?,?,?)");
                pst.setString(1, JobTitleTextField.getText());
                pst.setString(2, CompanyTextField.getText());
                pst.setString(3, (String)TermTextField.getSelectedItem());
                pst.setString(4, (String)AppliedThroughTextField.getSelectedItem());
                pst.setString(5, (String)StatusTextField.getSelectedItem());
            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Saved");
                updateTable("");
            } catch (SQLException ex) {
                Logger.getLogger(JobTracker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        
        if("".equals(JobTitleTextField.getText()) || "".equals(CompanyTextField.getText()) || TermTextField.getSelectedIndex() == 0 || AppliedThroughTextField.getSelectedIndex() == 0 || StatusTextField.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(this, "Fill In All Fields");
        }
        else {
            try {
                DefaultTableModel dft = (DefaultTableModel) DataTable.getModel();
                int selectedIndex = DataTable.getSelectedRow();
                int id = Integer.parseInt(dft.getValueAt(selectedIndex, 0).toString());

                pst = sqlConn.prepareStatement("update applications set JobTitle=?, Company=?,Term=?, AppliedThrough=?, Status=? where id=?");
                pst.setString(1, JobTitleTextField.getText());
                pst.setString(2, CompanyTextField.getText());
                pst.setString(3, (String)TermTextField.getSelectedItem());
                pst.setString(4, (String)AppliedThroughTextField.getSelectedItem());
                pst.setString(5, (String)StatusTextField.getSelectedItem());
                pst.setInt(6, id);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Updated");
                updateTable("");

            } catch (SQLException ex) {
                Logger.getLogger(JobTracker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        try {
            DefaultTableModel dft = (DefaultTableModel) DataTable.getModel();
            int selectedIndex = DataTable.getSelectedRow();
            int id = Integer.parseInt(dft.getValueAt(selectedIndex, 0).toString());
        
            pst = sqlConn.prepareStatement("delete from applications where id=?");
            pst.setInt(1,id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Deleted");
            updateTable("");
            
        } catch (SQLException ex) {
            Logger.getLogger(JobTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void ResetFieldsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetFieldsBtnActionPerformed
        JobTitleTextField.setText("");
        CompanyTextField.setText("");
        TermTextField.setSelectedIndex(0);
        AppliedThroughTextField.setSelectedIndex(0);
        StatusTextField.setSelectedIndex(0);
        SearchTextField.setText("");
        updateTable("");

    }//GEN-LAST:event_ResetFieldsBtnActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
         if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "JobTracker", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void DataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTableMouseClicked
        DefaultTableModel dft = (DefaultTableModel) DataTable.getModel();
        int selectedIndex = DataTable.getSelectedRow();
        
        int id = Integer.parseInt(dft.getValueAt(selectedIndex, 0).toString());
        JobTitleTextField.setText(dft.getValueAt(selectedIndex, 1).toString());
        CompanyTextField.setText(dft.getValueAt(selectedIndex, 2).toString());
        TermTextField.setSelectedItem(dft.getValueAt(selectedIndex, 3));
        AppliedThroughTextField.setSelectedItem(dft.getValueAt(selectedIndex, 4));
        StatusTextField.setSelectedItem(dft.getValueAt(selectedIndex, 5));
    }//GEN-LAST:event_DataTableMouseClicked

    private void PieChartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PieChartBtnActionPerformed
        HashMap<String, Integer> company_titles = new HashMap<>();
        String current_company;
        
        try{
            pst = sqlConn.prepareStatement("select AppliedThrough from applications");
            rs = pst.executeQuery();
            
            while(rs.next()) {
                current_company = rs.getString(1);
                if (company_titles.containsKey(current_company)) {
                    company_titles.put(current_company, company_titles.get(current_company) + 1);
                } else {
                    company_titles.put(current_company, 1);
                }
            }
            GeneratePieChart(company_titles);
            
        } catch (SQLException ex) {
            Logger.getLogger(JobTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PieChartBtnActionPerformed
    private void GeneratePieChart(HashMap job_titles) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        JFreeChart chart;
        
        Set<String> job_set = job_titles.keySet();
        int frequency, width, height; 
        
        
        for (String job_name : job_set) {
            frequency = (int)job_titles.get(job_name);
            dataset.setValue(job_name, frequency);
        }
        
        chart = ChartFactory.createPieChart("Job Titles By Frequency", dataset,true,true,false);
        
        width = 800; 
        height = 800;
        
        BufferedImage rendered_chart = chart.createBufferedImage(width, height);
        
        JFrame frame = new JFrame("Job Titles - Pie Chart");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(rendered_chart)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void BarChartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarChartBtnActionPerformed
        try{
            pst = sqlConn.prepareStatement("select Term, Status from applications");
            rs = pst.executeQuery();
            
            // Initialize a HashMap to store the frequency of statuses for each term
            HashMap<String, HashMap<String, Integer>> termStatusCounts = new HashMap<>();

            while (rs.next()) {
                String term = rs.getString("Term");
                String status = rs.getString("Status");

                // Check if the term is already present in the outer HashMap
                if (!termStatusCounts.containsKey(term)) {
                    // If not, add a new inner HashMap for the term
                    termStatusCounts.put(term, new HashMap<>());
                }

                // Get the inner HashMap for the term and update the status count
                HashMap<String, Integer> statusCounts = termStatusCounts.get(term);
                statusCounts.put(status, statusCounts.getOrDefault(status, 0) + 1);
            }
            GenerateBarChart(termStatusCounts);
            
        } catch (SQLException ex) {
            Logger.getLogger(JobTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BarChartBtnActionPerformed

    private void SearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyReleased
        String searchTerm = SearchTextField.getText();
        updateTable(searchTerm);
    }//GEN-LAST:event_SearchTextFieldKeyReleased

    
    private void GenerateBarChart(HashMap<String, HashMap<String, Integer>> termStatusCounts) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart;

        // Iterate through the outer HashMap to populate the dataset
        for (String term : termStatusCounts.keySet()) {
            HashMap<String, Integer> statusCounts = termStatusCounts.get(term);

            // Iterate through the inner HashMap to add values to the dataset
            for (String status : statusCounts.keySet()) {
                int count = statusCounts.get(status);
                dataset.addValue(count, status, term);
            }
        }
        
        chart = ChartFactory.createBarChart("Statuses For Co-op Terms", "", "Frequency(#)", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        
        int width, height; 
        width = 800; 
        height = 800;
        
        BufferedImage rendered_chart = chart.createBufferedImage(width, height);
        
        JFrame frame = new JFrame("Companies - Pie Chart");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(rendered_chart)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JComboBox<String> AppliedThroughTextField;
    private javax.swing.JButton BarChartBtn;
    private javax.swing.JTextField CompanyTextField;
    private javax.swing.JTable DataTable;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JPanel InnerPanel;
    private javax.swing.JTextField JobTitleTextField;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton PieChartBtn;
    private javax.swing.JButton ResetFieldsBtn;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JComboBox<String> StatusTextField;
    private javax.swing.JComboBox<String> TermTextField;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
