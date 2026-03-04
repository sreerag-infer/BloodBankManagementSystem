/*
 * Blood Bank Management System
 * DonorFrame — Professional Medical UI
 */
package com.bloodbank.bloodbankmanagementsystem.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Sreerag
 */
public class DonorFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(DonorFrame.class.getName());

    public DonorFrame() {
        initComponents();
        loadBloodGroups();
        applyTheme();
    }

    private void loadBloodGroups() {
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            String sql = "SELECT group_id, group_name FROM BloodGroup";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            cmbBloodGroup.removeAllItems();
            while (rs.next()) {
                cmbBloodGroup.addItem(rs.getInt("group_id") + " - " + rs.getString("group_name"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyTheme() {
        setTitle("Blood Bank — Donor Management");
        setResizable(false);

        // ── Root ─────────────────────────────────────────────────────────────
        JPanel root = MedicalTheme.createDarkPanel();
        root.setLayout(new BorderLayout());
        root.setPreferredSize(new Dimension(820, 580));

        // ── Header ───────────────────────────────────────────────────────────
        root.add(MedicalTheme.createHeaderPanel("Donor Management", "Register, update and manage blood donors"),
                BorderLayout.NORTH);

        // ── Body (form + table) ───────────────────────────────────────────────
        JPanel body = new JPanel(new BorderLayout(0, 16));
        body.setOpaque(false);
        body.setBorder(new EmptyBorder(20, 24, 20, 24));

        // ── Form Card ────────────────────────────────────────────────────────
        JPanel formCard = MedicalTheme.createCardPanel();
        formCard.setLayout(new BorderLayout());
        formCard.setBorder(new EmptyBorder(20, 24, 20, 24));

        JPanel formGrid = new JPanel(new GridLayout(4, 2, 16, 12));
        formGrid.setOpaque(false);

        JLabel lblName = MedicalTheme.styleLabel(new JLabel("Full Name"));
        JLabel lblAge = MedicalTheme.styleLabel(new JLabel("Age"));
        JLabel lblPhone = MedicalTheme.styleLabel(new JLabel("Phone Number"));
        JLabel lblGroup = MedicalTheme.styleLabel(new JLabel("Blood Group"));

        txtName.setText("");
        MedicalTheme.styleTextField(txtName);
        txtAge.setText("");
        MedicalTheme.styleTextField(txtAge);
        txtPhone.setText("");
        MedicalTheme.styleTextField(txtPhone);
        MedicalTheme.styleComboBox(cmbBloodGroup);

        formGrid.add(lblName);
        formGrid.add(txtName);
        formGrid.add(lblAge);
        formGrid.add(txtAge);
        formGrid.add(lblPhone);
        formGrid.add(txtPhone);
        formGrid.add(lblGroup);
        formGrid.add(cmbBloodGroup);

        // Button bar
        JPanel btnBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btnBar.setOpaque(false);
        btnBar.setBorder(new EmptyBorder(14, 0, 0, 0));

        MedicalTheme.styleButton(btnInsert, MedicalTheme.BtnType.PRIMARY);
        MedicalTheme.styleButton(btnUpdate, MedicalTheme.BtnType.SECONDARY);
        MedicalTheme.styleButton(btnDelete, MedicalTheme.BtnType.DANGER);
        MedicalTheme.styleButton(btnView, MedicalTheme.BtnType.OUTLINE);

        btnInsert.setText("➕  Add Donor");
        btnUpdate.setText("✏  Update");
        btnDelete.setText("🗑  Delete");
        btnView.setText("🔍  Refresh");

        btnBar.add(btnInsert);
        btnBar.add(btnUpdate);
        btnBar.add(btnDelete);
        btnBar.add(btnView);

        formCard.add(formGrid, BorderLayout.CENTER);
        formCard.add(btnBar, BorderLayout.SOUTH);

        // ── Table Card ────────────────────────────────────────────────────────
        JPanel tableCard = MedicalTheme.createCardPanel();
        tableCard.setLayout(new BorderLayout());
        tableCard.setBorder(new EmptyBorder(14, 14, 14, 14));

        JLabel tableTitle = new JLabel("  Donor Records");
        tableTitle.setFont(MedicalTheme.FONT_HEADING);
        tableTitle.setForeground(MedicalTheme.TEXT_SECONDARY);
        tableTitle.setBorder(new EmptyBorder(0, 0, 10, 0));

        MedicalTheme.styleTable(tblDonor);
        MedicalTheme.styleScrollPane(jScrollPane2);
        jScrollPane2.setViewportView(tblDonor);

        tableCard.add(tableTitle, BorderLayout.NORTH);
        tableCard.add(jScrollPane2, BorderLayout.CENTER);

        body.add(formCard, BorderLayout.NORTH);
        body.add(tableCard, BorderLayout.CENTER);

        root.add(body, BorderLayout.CENTER);
        setContentPane(root);
        pack();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbBloodGroup = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Donor Management");
        jLabel2.setText("Name");
        txtName.setText("jTextField1");
        txtName.addActionListener(this::txtNameActionPerformed);
        jLabel3.setText("Age");
        txtAge.setText("jTextField1");
        jLabel4.setText("Phone");
        txtPhone.setText("jTextField1");
        jLabel5.setText("Blood Group");
        cmbBloodGroup.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        btnInsert.setText("Insert");
        btnInsert.addActionListener(this::btnInsertActionPerformed);
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);
        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);
        btnView.setText("View");
        btnView.addActionListener(this::btnViewActionPerformed);
        tblDonor.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null } },
                new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
        jScrollPane2.setViewportView(tblDonor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNameActionPerformed
    }// GEN-LAST:event_txtNameActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInsertActionPerformed
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String phone = txtPhone.getText();
        String selected = cmbBloodGroup.getSelectedItem().toString();
        int groupId = Integer.parseInt(selected.split(" - ")[0]);
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            String sql = "INSERT INTO Donor (name, age, phone, group_id) VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, phone);
            ps.setInt(4, groupId);
            ps.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Donor Inserted Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnInsertActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnViewActionPerformed
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            String sql = "SELECT d.donor_id, d.name, d.age, d.phone, b.group_name FROM Donor d JOIN BloodGroup b ON d.group_id = b.group_id";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Age");
            model.addColumn("Phone");
            model.addColumn("Blood Group");
            while (rs.next()) {
                model.addRow(new Object[] { rs.getInt("donor_id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("phone"), rs.getString("group_name") });
            }
            tblDonor.setModel(model);
            MedicalTheme.styleTable(tblDonor);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblDonor.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a donor to delete.");
            return;
        }
        int donorId = (int) tblDonor.getValueAt(selectedRow, 0);
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this donor?",
                "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection
                        .getConnection();
                java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM Donor WHERE donor_id = ?");
                ps.setInt(1, donorId);
                ps.executeUpdate();
                javax.swing.JOptionPane.showMessageDialog(this, "Donor Deleted Successfully");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = tblDonor.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a donor to update.");
            return;
        }
        int donorId = (int) tblDonor.getValueAt(selectedRow, 0);
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String phone = txtPhone.getText();
        String selected = cmbBloodGroup.getSelectedItem().toString();
        int groupId = Integer.parseInt(selected.split(" - ")[0]);
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            java.sql.PreparedStatement ps = con
                    .prepareStatement("UPDATE Donor SET name=?, age=?, phone=?, group_id=? WHERE donor_id=?");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, phone);
            ps.setInt(4, groupId);
            ps.setInt(5, donorId);
            ps.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Donor Updated Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnUpdateActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new DonorFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cmbBloodGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDonor;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
