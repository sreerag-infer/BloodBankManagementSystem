/*
 * Blood Bank Management System
 * RequestFrame — Professional Medical UI
 */
package com.bloodbank.bloodbankmanagementsystem.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Sreerag
 */
public class RequestFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(RequestFrame.class.getName());

    public RequestFrame() {
        initComponents();
        loadBloodGroups();
        loadPatients();
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

    private void loadPatients() {
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            String sql = "SELECT patient_id, name FROM Patient";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            cmbPatient.removeAllItems();
            while (rs.next()) {
                cmbPatient.addItem(rs.getInt("patient_id") + " - " + rs.getString("name"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyTheme() {
        setTitle("Blood Bank — Request Management");
        setResizable(false);

        JPanel root = MedicalTheme.createDarkPanel();
        root.setLayout(new BorderLayout());
        root.setPreferredSize(new Dimension(860, 600));

        root.add(MedicalTheme.createHeaderPanel("Request Management", "Process and track blood supply requests"),
                BorderLayout.NORTH);

        JPanel body = new JPanel(new BorderLayout(0, 16));
        body.setOpaque(false);
        body.setBorder(new EmptyBorder(20, 24, 20, 24));

        // Form card (4 fields)
        JPanel formCard = MedicalTheme.createCardPanel();
        formCard.setLayout(new BorderLayout());
        formCard.setBorder(new EmptyBorder(20, 24, 20, 24));

        JPanel formGrid = new JPanel(new GridLayout(4, 2, 16, 12));
        formGrid.setOpaque(false);

        JLabel lblPatient = MedicalTheme.styleLabel(new JLabel("Patient"));
        JLabel lblGroup = MedicalTheme.styleLabel(new JLabel("Blood Group"));
        JLabel lblUnits = MedicalTheme.styleLabel(new JLabel("Units Required"));
        JLabel lblStatus = MedicalTheme.styleLabel(new JLabel("Status"));

        MedicalTheme.styleComboBox(cmbPatient);
        MedicalTheme.styleComboBox(cmbBloodGroup);
        txtUnits.setText("");
        MedicalTheme.styleTextField(txtUnits);
        MedicalTheme.styleComboBox(cmbStatus);

        formGrid.add(lblPatient);
        formGrid.add(cmbPatient);
        formGrid.add(lblGroup);
        formGrid.add(cmbBloodGroup);
        formGrid.add(lblUnits);
        formGrid.add(txtUnits);
        formGrid.add(lblStatus);
        formGrid.add(cmbStatus);

        JPanel btnBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btnBar.setOpaque(false);
        btnBar.setBorder(new EmptyBorder(14, 0, 0, 0));

        MedicalTheme.styleButton(btnInsert, MedicalTheme.BtnType.PRIMARY);
        MedicalTheme.styleButton(btnUpdate, MedicalTheme.BtnType.SECONDARY);
        MedicalTheme.styleButton(btnDelete, MedicalTheme.BtnType.DANGER);
        MedicalTheme.styleButton(View, MedicalTheme.BtnType.OUTLINE);

        btnInsert.setText("➕  Submit Request");
        btnUpdate.setText("✏  Update");
        btnDelete.setText("🗑  Delete");
        View.setText("🔍  Refresh");

        btnBar.add(btnInsert);
        btnBar.add(btnUpdate);
        btnBar.add(btnDelete);
        btnBar.add(View);

        formCard.add(formGrid, BorderLayout.CENTER);
        formCard.add(btnBar, BorderLayout.SOUTH);

        // Table card
        JPanel tableCard = MedicalTheme.createCardPanel();
        tableCard.setLayout(new BorderLayout());
        tableCard.setBorder(new EmptyBorder(14, 14, 14, 14));

        JLabel tableTitle = new JLabel("  Request Records");
        tableTitle.setFont(MedicalTheme.FONT_HEADING);
        tableTitle.setForeground(MedicalTheme.TEXT_SECONDARY);
        tableTitle.setBorder(new EmptyBorder(0, 0, 10, 0));

        MedicalTheme.styleTable(tblRequest);
        MedicalTheme.styleScrollPane(scrollRequest);
        scrollRequest.setViewportView(tblRequest);

        tableCard.add(tableTitle, BorderLayout.NORTH);
        tableCard.add(scrollRequest, BorderLayout.CENTER);

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
        jLabel3 = new javax.swing.JLabel();
        cmbPatient = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbBloodGroup = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtUnits = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        View = new javax.swing.JButton();
        scrollRequest = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Blood Request Management");
        jLabel3.setText("Patient");
        cmbPatient.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jLabel4.setText("Blood Group");
        cmbBloodGroup.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jLabel5.setText("Units Required");
        txtUnits.setText("jTextField1");
        jLabel6.setText("Status");
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Approved", "Rejected" }));
        btnInsert.setText("Insert");
        btnInsert.addActionListener(this::btnInsertActionPerformed);
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);
        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);
        View.setText("View");
        View.addActionListener(this::ViewActionPerformed);
        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null } },
                new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
        tblRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRequestMouseClicked(evt);
            }
        });
        scrollRequest.setViewportView(tblRequest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a request to delete.");
            return;
        }
        int requestId = (int) tblRequest.getValueAt(selectedRow, 0);
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this request?",
                "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection
                        .getConnection();
                java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM Request WHERE request_id = ?");
                ps.setInt(1, requestId);
                ps.executeUpdate();
                javax.swing.JOptionPane.showMessageDialog(this, "Request Deleted Successfully");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a request to update.");
            return;
        }
        int requestId = (int) tblRequest.getValueAt(selectedRow, 0);
        String oldStatus = tblRequest.getValueAt(selectedRow, 4).toString();
        int oldUnits = (int) tblRequest.getValueAt(selectedRow, 3);
        String patientSelected = cmbPatient.getSelectedItem().toString();
        int patientId = Integer.parseInt(patientSelected.split(" - ")[0]);
        String groupSelected = cmbBloodGroup.getSelectedItem().toString();
        int groupId = Integer.parseInt(groupSelected.split(" - ")[0]);
        int newUnits = Integer.parseInt(txtUnits.getText());
        String newStatus = cmbStatus.getSelectedItem().toString();
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            if (!oldStatus.equals("Approved") && newStatus.equals("Approved")) {
                String checkSql = "SELECT units_available FROM BloodStock WHERE group_id = ?";
                java.sql.PreparedStatement checkPs = con.prepareStatement(checkSql);
                checkPs.setInt(1, groupId);
                java.sql.ResultSet rs = checkPs.executeQuery();
                if (rs.next()) {
                    int available = rs.getInt("units_available");
                    if (available < newUnits) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Not enough stock available!");
                        con.close();
                        return;
                    }
                    java.sql.PreparedStatement updatePs = con.prepareStatement(
                            "UPDATE BloodStock SET units_available = units_available - ? WHERE group_id = ?");
                    updatePs.setInt(1, newUnits);
                    updatePs.setInt(2, groupId);
                    updatePs.executeUpdate();
                }
            } else if (oldStatus.equals("Approved") && !newStatus.equals("Approved")) {
                java.sql.PreparedStatement addPs = con.prepareStatement(
                        "UPDATE BloodStock SET units_available = units_available + ? WHERE group_id = ?");
                addPs.setInt(1, oldUnits);
                addPs.setInt(2, groupId);
                addPs.executeUpdate();
            } else if (oldStatus.equals("Approved") && newStatus.equals("Approved")) {
                int difference = newUnits - oldUnits;
                java.sql.PreparedStatement adjustPs = con.prepareStatement(
                        "UPDATE BloodStock SET units_available = units_available - ? WHERE group_id = ?");
                adjustPs.setInt(1, difference);
                adjustPs.setInt(2, groupId);
                adjustPs.executeUpdate();
            }
            java.sql.PreparedStatement updateReqPs = con.prepareStatement(
                    "UPDATE Request SET patient_id=?, group_id=?, units_required=?, status=? WHERE request_id=?");
            updateReqPs.setInt(1, patientId);
            updateReqPs.setInt(2, groupId);
            updateReqPs.setInt(3, newUnits);
            updateReqPs.setString(4, newStatus);
            updateReqPs.setInt(5, requestId);
            updateReqPs.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Request Updated Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInsertActionPerformed
        String patientSelected = cmbPatient.getSelectedItem().toString();
        int patientId = Integer.parseInt(patientSelected.split(" - ")[0]);
        String groupSelected = cmbBloodGroup.getSelectedItem().toString();
        int groupId = Integer.parseInt(groupSelected.split(" - ")[0]);
        int unitsRequired = Integer.parseInt(txtUnits.getText());
        String status = cmbStatus.getSelectedItem().toString();
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            if (status.equals("Approved")) {
                java.sql.PreparedStatement checkPs = con
                        .prepareStatement("SELECT units_available FROM BloodStock WHERE group_id = ?");
                checkPs.setInt(1, groupId);
                java.sql.ResultSet rs = checkPs.executeQuery();
                if (rs.next()) {
                    int available = rs.getInt("units_available");
                    if (available < unitsRequired) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Not enough stock available!");
                        con.close();
                        return;
                    }
                    java.sql.PreparedStatement updatePs = con.prepareStatement(
                            "UPDATE BloodStock SET units_available = units_available - ? WHERE group_id = ?");
                    updatePs.setInt(1, unitsRequired);
                    updatePs.setInt(2, groupId);
                    updatePs.executeUpdate();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No stock record found for this blood group.");
                    con.close();
                    return;
                }
            }
            java.sql.PreparedStatement insertPs = con.prepareStatement(
                    "INSERT INTO Request (patient_id, group_id, units_required, status) VALUES (?, ?, ?, ?)");
            insertPs.setInt(1, patientId);
            insertPs.setInt(2, groupId);
            insertPs.setInt(3, unitsRequired);
            insertPs.setString(4, status);
            insertPs.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Request Inserted Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnInsertActionPerformed

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ViewActionPerformed
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            String sql = "SELECT r.request_id, p.name, b.group_name, r.units_required, r.status FROM Request r JOIN Patient p ON r.patient_id = p.patient_id JOIN BloodGroup b ON r.group_id = b.group_id";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
            model.addColumn("Request ID");
            model.addColumn("Patient");
            model.addColumn("Blood Group");
            model.addColumn("Units Required");
            model.addColumn("Status");
            while (rs.next()) {
                model.addRow(new Object[] { rs.getInt("request_id"), rs.getString("name"), rs.getString("group_name"),
                        rs.getInt("units_required"), rs.getString("status") });
            }
            tblRequest.setModel(model);
            MedicalTheme.styleTable(tblRequest);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_ViewActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseClicked
    }// GEN-LAST:event_formMouseClicked

    private void tblRequestMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblRequestMouseClicked
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow != -1) {
            String patientName = tblRequest.getValueAt(selectedRow, 1).toString();
            String groupName = tblRequest.getValueAt(selectedRow, 2).toString();
            int units = (int) tblRequest.getValueAt(selectedRow, 3);
            String status = tblRequest.getValueAt(selectedRow, 4).toString();
            for (int i = 0; i < cmbPatient.getItemCount(); i++) {
                if (cmbPatient.getItemAt(i).contains(patientName)) {
                    cmbPatient.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < cmbBloodGroup.getItemCount(); i++) {
                if (cmbBloodGroup.getItemAt(i).contains(groupName)) {
                    cmbBloodGroup.setSelectedIndex(i);
                    break;
                }
            }
            txtUnits.setText(String.valueOf(units));
            cmbStatus.setSelectedItem(status);
        }
    }// GEN-LAST:event_tblRequestMouseClicked

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new RequestFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton View;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbBloodGroup;
    private javax.swing.JComboBox<String> cmbPatient;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane scrollRequest;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTextField txtUnits;
    // End of variables declaration//GEN-END:variables
}
