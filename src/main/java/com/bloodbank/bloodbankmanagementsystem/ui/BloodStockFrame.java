/*
 * Blood Bank Management System
 * BloodStockFrame — Professional Medical UI
 */
package com.bloodbank.bloodbankmanagementsystem.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Sreerag
 */
public class BloodStockFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(BloodStockFrame.class.getName());

    public BloodStockFrame() {
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
        setTitle("Blood Bank — Blood Stock Management");
        setResizable(false);

        JPanel root = MedicalTheme.createDarkPanel();
        root.setLayout(new BorderLayout());
        root.setPreferredSize(new Dimension(820, 530));

        root.add(MedicalTheme.createHeaderPanel("Blood Stock Management", "Monitor and manage blood unit inventory"),
                BorderLayout.NORTH);

        JPanel body = new JPanel(new BorderLayout(0, 16));
        body.setOpaque(false);
        body.setBorder(new EmptyBorder(20, 24, 20, 24));

        // Form card (shorter — only 2 fields)
        JPanel formCard = MedicalTheme.createCardPanel();
        formCard.setLayout(new BorderLayout());
        formCard.setBorder(new EmptyBorder(20, 24, 20, 24));

        JPanel formGrid = new JPanel(new GridLayout(2, 2, 16, 12));
        formGrid.setOpaque(false);

        JLabel lblGroup = MedicalTheme.styleLabel(new JLabel("Blood Group"));
        JLabel lblUnits = MedicalTheme.styleLabel(new JLabel("Units Available"));

        MedicalTheme.styleComboBox(cmbBloodGroup);
        txtUnits.setText("");
        MedicalTheme.styleTextField(txtUnits);

        formGrid.add(lblGroup);
        formGrid.add(cmbBloodGroup);
        formGrid.add(lblUnits);
        formGrid.add(txtUnits);

        JPanel btnBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btnBar.setOpaque(false);
        btnBar.setBorder(new EmptyBorder(14, 0, 0, 0));

        MedicalTheme.styleButton(btnInsert, MedicalTheme.BtnType.PRIMARY);
        MedicalTheme.styleButton(btnUpdate, MedicalTheme.BtnType.SECONDARY);
        MedicalTheme.styleButton(btnDelete, MedicalTheme.BtnType.DANGER);
        MedicalTheme.styleButton(btnView, MedicalTheme.BtnType.OUTLINE);

        btnInsert.setText("➕  Add Stock");
        btnUpdate.setText("✏  Update");
        btnDelete.setText("🗑  Delete");
        btnView.setText("🔍  Refresh");

        btnBar.add(btnInsert);
        btnBar.add(btnUpdate);
        btnBar.add(btnDelete);
        btnBar.add(btnView);

        formCard.add(formGrid, BorderLayout.CENTER);
        formCard.add(btnBar, BorderLayout.SOUTH);

        // Table card
        JPanel tableCard = MedicalTheme.createCardPanel();
        tableCard.setLayout(new BorderLayout());
        tableCard.setBorder(new EmptyBorder(14, 14, 14, 14));

        JLabel tableTitle = new JLabel("  Blood Stock Records");
        tableTitle.setFont(MedicalTheme.FONT_HEADING);
        tableTitle.setForeground(MedicalTheme.TEXT_SECONDARY);
        tableTitle.setBorder(new EmptyBorder(0, 0, 10, 0));

        MedicalTheme.styleTable(tblStock);
        MedicalTheme.styleScrollPane(jScrollPane1);
        jScrollPane1.setViewportView(tblStock);

        tableCard.add(tableTitle, BorderLayout.NORTH);
        tableCard.add(jScrollPane1, BorderLayout.CENTER);

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbBloodGroup = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtUnits = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Blood Stock Management");
        jLabel2.setText("Blood Group");
        cmbBloodGroup.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jLabel3.setText("Units Available");
        txtUnits.setText("Units Available");
        txtUnits.addActionListener(this::txtUnitsActionPerformed);
        btnInsert.setText("Insert");
        btnInsert.addActionListener(this::btnInsertActionPerformed);
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);
        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);
        btnView.setText("View");
        btnView.addActionListener(this::btnViewActionPerformed);
        tblStock.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null } },
                new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
        tblStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUnitsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtUnitsActionPerformed
    }// GEN-LAST:event_txtUnitsActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInsertActionPerformed
        String selected = cmbBloodGroup.getSelectedItem().toString();
        int groupId = Integer.parseInt(selected.split(" - ")[0]);
        int units = Integer.parseInt(txtUnits.getText());
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            java.sql.PreparedStatement ps = con
                    .prepareStatement("INSERT INTO BloodStock (group_id, units_available) VALUES (?, ?)");
            ps.setInt(1, groupId);
            ps.setInt(2, units);
            ps.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Stock Inserted Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnInsertActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnViewActionPerformed
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            String sql = "SELECT s.stock_id, b.group_name, s.units_available FROM BloodStock s JOIN BloodGroup b ON s.group_id = b.group_id";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
            model.addColumn("Stock ID");
            model.addColumn("Blood Group");
            model.addColumn("Units Available");
            while (rs.next()) {
                model.addRow(new Object[] { rs.getInt("stock_id"), rs.getString("group_name"),
                        rs.getInt("units_available") });
            }
            tblStock.setModel(model);
            MedicalTheme.styleTable(tblStock);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnViewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = tblStock.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a stock record to update.");
            return;
        }
        int stockId = (int) tblStock.getValueAt(selectedRow, 0);
        String selected = cmbBloodGroup.getSelectedItem().toString();
        int groupId = Integer.parseInt(selected.split(" - ")[0]);
        int units = Integer.parseInt(txtUnits.getText());
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            java.sql.PreparedStatement ps = con
                    .prepareStatement("UPDATE BloodStock SET group_id=?, units_available=? WHERE stock_id=?");
            ps.setInt(1, groupId);
            ps.setInt(2, units);
            ps.setInt(3, stockId);
            ps.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Stock Updated Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void tblStockMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblStockMouseClicked
        int selectedRow = tblStock.getSelectedRow();
        if (selectedRow != -1) {
            String groupName = tblStock.getValueAt(selectedRow, 1).toString();
            int units = (int) tblStock.getValueAt(selectedRow, 2);
            for (int i = 0; i < cmbBloodGroup.getItemCount(); i++) {
                if (cmbBloodGroup.getItemAt(i).contains(groupName)) {
                    cmbBloodGroup.setSelectedIndex(i);
                    break;
                }
            }
            txtUnits.setText(String.valueOf(units));
        }
    }// GEN-LAST:event_tblStockMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblStock.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a stock record to delete.");
            return;
        }
        int stockId = (int) tblStock.getValueAt(selectedRow, 0);
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this stock record?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection
                        .getConnection();
                java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM BloodStock WHERE stock_id = ?");
                ps.setInt(1, stockId);
                ps.executeUpdate();
                javax.swing.JOptionPane.showMessageDialog(this, "Stock Deleted Successfully");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }// GEN-LAST:event_btnDeleteActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new BloodStockFrame().setVisible(true));
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtUnits;
    // End of variables declaration//GEN-END:variables
}
