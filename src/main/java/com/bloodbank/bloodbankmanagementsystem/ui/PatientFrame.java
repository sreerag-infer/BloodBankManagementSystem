/*
 * Blood Bank Management System
 * PatientFrame — Professional Medical UI
 */
package com.bloodbank.bloodbankmanagementsystem.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Sreerag
 */
public class PatientFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(PatientFrame.class.getName());

    public PatientFrame() {
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
        setTitle("Blood Bank — Patient Management");
        setResizable(false);

        JPanel root = MedicalTheme.createDarkPanel();
        root.setLayout(new BorderLayout());
        root.setPreferredSize(new Dimension(820, 580));

        root.add(MedicalTheme.createHeaderPanel("Patient Management", "Register, update and manage patients"),
                BorderLayout.NORTH);

        JPanel body = new JPanel(new BorderLayout(0, 16));
        body.setOpaque(false);
        body.setBorder(new EmptyBorder(20, 24, 20, 24));

        // Form card
        JPanel formCard = MedicalTheme.createCardPanel();
        formCard.setLayout(new BorderLayout());
        formCard.setBorder(new EmptyBorder(20, 24, 20, 24));

        JPanel formGrid = new JPanel(new GridLayout(4, 2, 16, 12));
        formGrid.setOpaque(false);

        JLabel lblName = MedicalTheme.styleLabel(new JLabel("Patient Name"));
        JLabel lblDisease = MedicalTheme.styleLabel(new JLabel("Diagnosis / Disease"));
        JLabel lblPhone = MedicalTheme.styleLabel(new JLabel("Phone Number"));
        JLabel lblGroup = MedicalTheme.styleLabel(new JLabel("Blood Group"));

        txtName.setText("");
        MedicalTheme.styleTextField(txtName);
        txtDisease.setText("");
        MedicalTheme.styleTextField(txtDisease);
        txtPhone.setText("");
        MedicalTheme.styleTextField(txtPhone);
        MedicalTheme.styleComboBox(cmbBloodGroup);

        formGrid.add(lblName);
        formGrid.add(txtName);
        formGrid.add(lblDisease);
        formGrid.add(txtDisease);
        formGrid.add(lblPhone);
        formGrid.add(txtPhone);
        formGrid.add(lblGroup);
        formGrid.add(cmbBloodGroup);

        JPanel btnBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btnBar.setOpaque(false);
        btnBar.setBorder(new EmptyBorder(14, 0, 0, 0));

        MedicalTheme.styleButton(btnInsert, MedicalTheme.BtnType.PRIMARY);
        MedicalTheme.styleButton(btnUpdate, MedicalTheme.BtnType.SECONDARY);
        MedicalTheme.styleButton(btnDelete, MedicalTheme.BtnType.DANGER);
        MedicalTheme.styleButton(btnView, MedicalTheme.BtnType.OUTLINE);

        btnInsert.setText("➕  Add Patient");
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

        JLabel tableTitle = new JLabel("  Patient Records");
        tableTitle.setFont(MedicalTheme.FONT_HEADING);
        tableTitle.setForeground(MedicalTheme.TEXT_SECONDARY);
        tableTitle.setBorder(new EmptyBorder(0, 0, 10, 0));

        MedicalTheme.styleTable(tblPatient);
        MedicalTheme.styleScrollPane(scrollPatient);
        scrollPatient.setViewportView(tblPatient);

        tableCard.add(tableTitle, BorderLayout.NORTH);
        tableCard.add(scrollPatient, BorderLayout.CENTER);

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
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDisease = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbBloodGroup = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        scrollPatient = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Patient Management");
        jLabel2.setText("Name");
        txtName.setText("jTextField1");
        jLabel3.setText("Disease");
        txtDisease.setText("jTextField1");
        jLabel4.setText("Phone");
        txtPhone.setText("jTextField1");
        txtPhone.addActionListener(this::txtPhoneActionPerformed);
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
        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null } },
                new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
        tblPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientMouseClicked(evt);
            }
        });
        scrollPatient.setViewportView(tblPatient);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPhoneActionPerformed
    }// GEN-LAST:event_txtPhoneActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = tblPatient.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a patient to update.");
            return;
        }
        int patientId = (int) tblPatient.getValueAt(selectedRow, 0);
        String name = txtName.getText();
        String disease = txtDisease.getText();
        String phone = txtPhone.getText();
        String selected = cmbBloodGroup.getSelectedItem().toString();
        int groupId = Integer.parseInt(selected.split(" - ")[0]);
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            java.sql.PreparedStatement ps = con
                    .prepareStatement("UPDATE Patient SET name=?, disease=?, phone=?, group_id=? WHERE patient_id=?");
            ps.setString(1, name);
            ps.setString(2, disease);
            ps.setString(3, phone);
            ps.setInt(4, groupId);
            ps.setInt(5, patientId);
            ps.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Patient Updated Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInsertActionPerformed
        String name = txtName.getText();
        String disease = txtDisease.getText();
        String phone = txtPhone.getText();
        String selected = cmbBloodGroup.getSelectedItem().toString();
        int groupId = Integer.parseInt(selected.split(" - ")[0]);
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            java.sql.PreparedStatement ps = con
                    .prepareStatement("INSERT INTO Patient (name, disease, phone, group_id) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, disease);
            ps.setString(3, phone);
            ps.setInt(4, groupId);
            ps.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Patient Inserted Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnInsertActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnViewActionPerformed
        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();
            String sql = "SELECT p.patient_id, p.name, p.disease, p.phone, b.group_name FROM Patient p JOIN BloodGroup b ON p.group_id = b.group_id";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
            model.addColumn("Patient ID");
            model.addColumn("Name");
            model.addColumn("Disease");
            model.addColumn("Phone");
            model.addColumn("Blood Group");
            while (rs.next()) {
                model.addRow(new Object[] { rs.getInt("patient_id"), rs.getString("name"), rs.getString("disease"),
                        rs.getString("phone"), rs.getString("group_name") });
            }
            tblPatient.setModel(model);
            MedicalTheme.styleTable(tblPatient);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnViewActionPerformed

    private void tblPatientMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblPatientMouseClicked
        int selectedRow = tblPatient.getSelectedRow();
        if (selectedRow != -1) {
            String name = tblPatient.getValueAt(selectedRow, 1).toString();
            String disease = tblPatient.getValueAt(selectedRow, 2).toString();
            String phone = tblPatient.getValueAt(selectedRow, 3).toString();
            String groupName = tblPatient.getValueAt(selectedRow, 4).toString();
            txtName.setText(name);
            txtDisease.setText(disease);
            txtPhone.setText(phone);
            for (int i = 0; i < cmbBloodGroup.getItemCount(); i++) {
                if (cmbBloodGroup.getItemAt(i).contains(groupName)) {
                    cmbBloodGroup.setSelectedIndex(i);
                    break;
                }
            }
        }
    }// GEN-LAST:event_tblPatientMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblPatient.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a patient to delete.");
            return;
        }
        int patientId = (int) tblPatient.getValueAt(selectedRow, 0);
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this patient?",
                "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection
                        .getConnection();
                java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM Patient WHERE patient_id = ?");
                ps.setInt(1, patientId);
                ps.executeUpdate();
                javax.swing.JOptionPane.showMessageDialog(this, "Patient Deleted Successfully");
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
        java.awt.EventQueue.invokeLater(() -> new PatientFrame().setVisible(true));
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
    private javax.swing.JScrollPane scrollPatient;
    private javax.swing.JTable tblPatient;
    private javax.swing.JTextField txtDisease;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
