/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package receptionist;
import java.sql.*;
import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ilham Sholahuddin
 */
public class Reservasi extends javax.swing.JFrame {

    /**
     * Creates new form Reservasi
     */
    
        public void tampilkanDataTamu() {
        try {
            Connection conn = config.DatabaseConnection.connect();
            String sql = "SELECT id_tamu, nama_tamu, email, no_tlp, alamat FROM tamu";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Tamu");
            model.addColumn("Nama Tamu");
            model.addColumn("Email");
            model.addColumn("No. Telepon");
            model.addColumn("Alamat");

            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getInt("id_tamu"),
                    rs.getString("nama_tamu"),
                    rs.getString("email"),
                    rs.getString("no_tlp"),
                    rs.getString("alamat")
                });
            }
            
            jTable1.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data tamu: " + e.getMessage());
        }
    }
        
    private void ambilTipeKamar(String nomorKamar) {
        try {
            String sql = "SELECT tipe FROM kamar WHERE nomor_kamar = ?";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nomorKamar);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jTextField7.setText(rs.getString("tipe")); // kolom tipe kamar
            } else {
                jTextField7.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil tipe kamar: " + e.getMessage());
        }
    }
    
    private void loadTabelReservasi() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Reservasi");
        model.addColumn("Nomor Kamar");
        model.addColumn("ID Tamu");
        model.addColumn("Check In");
        model.addColumn("Check Out");
        model.addColumn("Status");

        try {
            String sql = "SELECT * FROM reservasi";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    res.getInt("id_reservasi"),
                    res.getString("nomor_kamar"),
                    res.getInt("id_tamu"),
                    res.getDate("tanggal_check_in"),
                    res.getDate("tanggal_check_out"),
                    res.getString("status_reservasi")
                });
            }

            jTable2.setModel(model); // Pastikan jTable1 adalah nama JTable di GUI Anda

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
    }
    
    
    public Reservasi() {
        initComponents();
        loadTabelReservasi();
        tampilkanDataTamu();
        //tampilkan saat di klik
        jTable1.getSelectionModel().addListSelectionListener(e ->{
            if(!e.getValueIsAdjusting() && jTable1.getSelectedRow() != -1){
                int row = jTable1.getSelectedRow();
                jTextField1.setText(jTable1.getValueAt(row, 1).toString());
                jTextField2.setText(jTable1.getValueAt(row, 2).toString());
                jTextField3.setText(jTable1.getValueAt(row, 3).toString());
                jTextArea1.setText(jTable1.getValueAt(row, 4).toString());
            }
        });
        jTable2.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable2.getSelectedRow() != -1) {
                int row = jTable2.getSelectedRow();

                jTextField5.setText(jTable2.getValueAt(row, 2).toString()); // ID Tamu
                jTextField6.setText(jTable2.getValueAt(row, 1).toString()); // Nomor Kamar
                jDateChooser1.setDate(java.sql.Date.valueOf(jTable2.getValueAt(row, 3).toString())); // Check In
                jDateChooser2.setDate(java.sql.Date.valueOf(jTable2.getValueAt(row, 4).toString())); // Check Out
                jComboBox1.setSelectedItem(jTable2.getValueAt(row, 5).toString()); // Status

                // Optional: isi Tipe Kamar otomatis (jika field jTextField7 dipakai)
                ambilTipeKamar(jTable2.getValueAt(row, 1).toString());
            }
        });
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(129, 154, 145));

        jLabel1.setBackground(new java.awt.Color(129, 154, 145));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RESERVASI KAMAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(167, 193, 168));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Data Tamu");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 71, 79));
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(55, 71, 79));
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(55, 71, 79));
        jLabel5.setText("No Telepon");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(55, 71, 79));
        jLabel6.setText("Alamat");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(44, 44, 44)
                                .addComponent(jButton3)
                                .addGap(38, 38, 38)
                                .addComponent(jButton4)
                                .addGap(0, 80, Short.MAX_VALUE))
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(167, 193, 168));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Data Reservasi");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(55, 71, 79));
        jLabel9.setText("ID Tamu");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(55, 71, 79));
        jLabel10.setText("Nomor Kamar");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(55, 71, 79));
        jLabel11.setText("Tipe");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(55, 71, 79));
        jLabel12.setText("Check In");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(55, 71, 79));
        jLabel13.setText("Check Out");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(55, 71, 79));
        jLabel14.setText("Status");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton5.setText("Pilih");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Reserved", "Check-In", "Check-Out", "Cancelled" }));

        jButton7.setText("Simpan");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Hapus");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search (1).png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addComponent(jTextField7)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel4.setBackground(new java.awt.Color(167, 193, 168));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(55, 71, 79));
        jLabel7.setText("Cari");

        jButton1.setText("Temukan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(167, 193, 168));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(55, 71, 79));
        jLabel15.setText("Cari");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton6.setText("Temukan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton11.setText("Kembali");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TOMBOL SIMPAN TAMU
        String nama = jTextField1.getText().trim();
        String email = jTextField2.getText().trim();
        String notlp = jTextField3.getText().trim();
        String alamat = jTextArea1.getText().trim();

        if (nama.isEmpty() || email.isEmpty() || notlp.isEmpty() || alamat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi!");
            return;
        }

        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "INSERT INTO tamu (nama_tamu, email, no_tlp, alamat) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, notlp);
            stmt.setString(4, alamat);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data tamu berhasil disimpan.");

            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextArea1.setText("");

             tampilkanDataTamu();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan tamu: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
        String sql = "INSERT INTO reservasi (id_tamu, nomor_kamar, tanggal_check_in, tanggal_check_out, status_reservasi) VALUES (?, ?, ?, ?, ?)";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", ""); // sesuaikan user & password
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, Integer.parseInt(jTextField5.getText())); // ID Tamu
        pst.setString(2, jTextField6.getText()); // Nomor Kamar
        pst.setDate(3, new java.sql.Date(jDateChooser1.getDate().getTime())); // Check In
        pst.setDate(4, new java.sql.Date(jDateChooser2.getDate().getTime())); // Check Out
        pst.setString(5, jComboBox1.getSelectedItem().toString()); // Status

        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data reservasi berhasil disimpan!");

        // Optional: refresh table atau bersihkan form
        // loadTableReservasi(); 
        
        
        loadTabelReservasi();
        
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jComboBox1.setSelectedIndex(0);

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                // TOMBOL EDIT
        int selectedRow = jTable1.getSelectedRow();
    
        int idTamu = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());

        String nama = jTextField1.getText().trim();
        String email = jTextField2.getText().trim();
        String notlp = jTextField3.getText().trim();
        String alamat = jTextArea1.getText().trim();

        if (nama.isEmpty() || email.isEmpty() || notlp.isEmpty() || alamat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi!");
            return;
        }

        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "UPDATE tamu SET nama_tamu = ?, email = ?, no_tlp = ?, "
                    + "alamat = ? WHERE id_tamu = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, notlp);
            stmt.setString(4, alamat);
            stmt.setInt(5, idTamu);

            int updated = stmt.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Data tamu berhasil diperbarui.");
                tampilkanDataTamu();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui data tamu.");
            }
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextArea1.setText("");
                tampilkanDataTamu();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat update: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data tamu yang ingin dihapus terlebih dahulu.");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data tamu ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            int idTamu = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());

            try (Connection conn = DatabaseConnection.connect()) {
                String sql = "DELETE FROM tamu WHERE id_tamu = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idTamu);

                int deleted = stmt.executeUpdate();
                if (deleted > 0) {
                    JOptionPane.showMessageDialog(this, "Data tamu berhasil dihapus.");
                    tampilkanDataTamu(); // refresh table
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data tamu.");
                }

                // Kosongkan input field setelah penghapusan
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextArea1.setText("");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
        int row = jTable2.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin diedit dari tabel terlebih dahulu.");
            return;
        }

        // Ambil ID Reservasi dari kolom pertama tabel
        int idReservasi = Integer.parseInt(jTable2.getValueAt(row, 0).toString());

        String sql = "UPDATE reservasi SET id_tamu = ?, nomor_kamar = ?, tanggal_check_in = ?, tanggal_check_out = ?, status_reservasi = ? WHERE id_reservasi = ?";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "");
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, Integer.parseInt(jTextField5.getText())); // ID Tamu
        pst.setString(2, jTextField6.getText()); // Nomor Kamar
        pst.setDate(3, new java.sql.Date(jDateChooser1.getDate().getTime())); // Check In
        pst.setDate(4, new java.sql.Date(jDateChooser2.getDate().getTime())); // Check Out
        pst.setString(5, jComboBox1.getSelectedItem().toString()); // Status
        pst.setInt(6, idReservasi); // ID Reservasi sebagai WHERE

        int updated = pst.executeUpdate();
        if (updated > 0) {
            JOptionPane.showMessageDialog(null, "Data reservasi berhasil diupdate.");
            loadTabelReservasi(); // Refresh tabel
            // clearForm(); // Optional: hapus isi form
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada data yang diperbarui.");
        }

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengupdate data: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Tombol Cari Satu
        String keyword = jTextField4.getText().trim();

        if (keyword.isEmpty()) {
            tampilkanDataTamu();
            return;
        }

        try {
            Connection conn = config.DatabaseConnection.connect();
            String sql = "SELECT id_tamu, nama_tamu, email, no_tlp, alamat " +
                         "FROM tamu " +
                         "WHERE CAST(id_tamu AS CHAR) LIKE ? OR nama_tamu LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");

            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Tamu");
            model.addColumn("Nama Tamu");
            model.addColumn("Email");
            model.addColumn("No. Telepon");
            model.addColumn("Alamat");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_tamu"),
                    rs.getString("nama_tamu"),
                    rs.getString("email"),
                    rs.getString("no_tlp"),
                    rs.getString("alamat")
                });
            }

            jTable1.setModel(model);

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencari data tamu: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String keyword = jTextField8.getText().trim(); // asumsikan field pencarian tetap di jTextField4

        if (keyword.isEmpty()) {
            loadTabelReservasi(); // tampilkan semua data jika kosong
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "");
            String sql = "SELECT * FROM reservasi " +
                         "WHERE CAST(id_reservasi AS CHAR) LIKE ? " +
                         "OR CAST(id_tamu AS CHAR) LIKE ? " +
                         "OR nomor_kamar LIKE ? " +
                         "OR status_reservasi LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
            stmt.setString(4, "%" + keyword + "%");

            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Reservasi");
            model.addColumn("Nomor Kamar");
            model.addColumn("ID Tamu");
            model.addColumn("Check In");
            model.addColumn("Check Out");
            model.addColumn("Status");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_reservasi"),
                    rs.getString("nomor_kamar"),
                    rs.getInt("id_tamu"),
                    rs.getDate("tanggal_check_in"),
                    rs.getDate("tanggal_check_out"),
                    rs.getString("status_reservasi")
                });
            }

            jTable2.setModel(model); // asumsikan jTable2 adalah tabel reservasi

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencari data reservasi: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data reservasi yang ingin dihapus terlebih dahulu.");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this,
            "Apakah Anda yakin ingin menghapus data reservasi ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            int idReservasi = Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString());

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "")) {
                String sql = "DELETE FROM reservasi WHERE id_reservasi = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idReservasi);

                int deleted = stmt.executeUpdate();
                if (deleted > 0) {
                    JOptionPane.showMessageDialog(this, "Data reservasi berhasil dihapus.");
                    loadTabelReservasi(); // refresh tabel setelah penghapusan
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data reservasi.");
                }

                // Kosongkan form setelah penghapusan
                jTextField5.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                jDateChooser1.setDate(null);
                jDateChooser2.setDate(null);
                jComboBox1.setSelectedIndex(0);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Reservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
