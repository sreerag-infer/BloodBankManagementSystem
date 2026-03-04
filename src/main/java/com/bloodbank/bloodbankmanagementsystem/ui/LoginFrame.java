/*
 * Blood Bank Management System
 * LoginFrame — Professional Medical UI
 */
package com.bloodbank.bloodbankmanagementsystem.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Sreerag
 */
public class LoginFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(LoginFrame.class.getName());

    public LoginFrame() {
        initComponents();
        applyTheme();
    }

    /** Apply professional medical theme to all components */
    private void applyTheme() {
        setTitle("Blood Bank Management System — Login");
        setResizable(false);

        // ── Root content pane ──────────────────────────────────────────────
        JPanel root = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(MedicalTheme.BG_DARK);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };
        root.setPreferredSize(new Dimension(780, 480));

        // ── Left branding panel ────────────────────────────────────────────
        JPanel brandPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(0x7B1A1A),
                        0, getHeight(), new Color(0x3A0A0A));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // decorative circles
                g2.setColor(new Color(0xFF, 0xFF, 0xFF, 18));
                g2.fillOval(-60, -60, 220, 220);
                g2.fillOval(100, 280, 200, 200);
                g2.dispose();
            }
        };
        brandPanel.setPreferredSize(new Dimension(310, 0));
        brandPanel.setLayout(new GridBagLayout());
        brandPanel.setOpaque(false);

        JPanel brandContent = new JPanel();
        brandContent.setLayout(new BoxLayout(brandContent, BoxLayout.Y_AXIS));
        brandContent.setOpaque(false);

        JLabel logoIcon = new JLabel("✚");
        logoIcon.setFont(new Font("Segoe UI", Font.BOLD, 56));
        logoIcon.setForeground(new Color(0xFF, 0xFF, 0xFF, 220));
        logoIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoTitle = new JLabel("BloodBank");
        logoTitle.setFont(MedicalTheme.FONT_LOGO);
        logoTitle.setForeground(Color.WHITE);
        logoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoSub = new JLabel("Management System");
        logoSub.setFont(MedicalTheme.FONT_SUBLOGO);
        logoSub.setForeground(new Color(0xFF, 0xCC, 0xCC));
        logoSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(160, 1));
        sep.setForeground(new Color(0xFF, 0xFF, 0xFF, 60));
        sep.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tagLine = new JLabel("<html><center>Saving Lives,<br>One Drop at a Time</center></html>");
        tagLine.setFont(MedicalTheme.FONT_SMALL);
        tagLine.setForeground(new Color(0xFF, 0xCC, 0xCC));
        tagLine.setAlignmentX(Component.CENTER_ALIGNMENT);
        tagLine.setHorizontalAlignment(SwingConstants.CENTER);

        brandContent.add(logoIcon);
        brandContent.add(Box.createVerticalStrut(8));
        brandContent.add(logoTitle);
        brandContent.add(Box.createVerticalStrut(4));
        brandContent.add(logoSub);
        brandContent.add(Box.createVerticalStrut(16));
        brandContent.add(sep);
        brandContent.add(Box.createVerticalStrut(14));
        brandContent.add(tagLine);

        brandPanel.add(brandContent);

        // ── Right login card ───────────────────────────────────────────────
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setOpaque(false);
        rightPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        JPanel card = MedicalTheme.createCardPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(36, 40, 36, 40));
        card.setPreferredSize(new Dimension(360, 340));

        JLabel welcome = new JLabel("Welcome Back");
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 20));
        welcome.setForeground(MedicalTheme.TEXT_PRIMARY);
        welcome.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subWelcome = new JLabel("Please sign in to continue");
        subWelcome.setFont(MedicalTheme.FONT_SMALL);
        subWelcome.setForeground(MedicalTheme.TEXT_SECONDARY);
        subWelcome.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Username
        JLabel userLbl = new JLabel("USERNAME");
        userLbl.setFont(new Font("Segoe UI", Font.BOLD, 10));
        userLbl.setForeground(MedicalTheme.TEXT_SECONDARY);
        userLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtUsername.setText("");
        txtUsername.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtUsername.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        MedicalTheme.styleTextField(txtUsername);

        // Password
        JLabel passLbl = new JLabel("PASSWORD");
        passLbl.setFont(new Font("Segoe UI", Font.BOLD, 10));
        passLbl.setForeground(MedicalTheme.TEXT_SECONDARY);
        passLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtPassword.setText("");
        txtPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtPassword.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        MedicalTheme.stylePasswordField(txtPassword);

        // Login button
        MedicalTheme.styleButton(btnLogin, MedicalTheme.BtnType.PRIMARY);
        btnLogin.setText("  SIGN IN  ");
        btnLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        btnLogin.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel footerLbl = new JLabel("Blood Bank Management System  •  v1.0");
        footerLbl.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        footerLbl.setForeground(MedicalTheme.TEXT_SECONDARY);
        footerLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(welcome);
        card.add(Box.createVerticalStrut(4));
        card.add(subWelcome);
        card.add(Box.createVerticalStrut(28));
        card.add(userLbl);
        card.add(Box.createVerticalStrut(6));
        card.add(txtUsername);
        card.add(Box.createVerticalStrut(14));
        card.add(passLbl);
        card.add(Box.createVerticalStrut(6));
        card.add(txtPassword);
        card.add(Box.createVerticalStrut(24));
        card.add(btnLogin);
        card.add(Box.createVerticalStrut(20));
        card.add(footerLbl);

        rightPanel.add(card);

        root.add(brandPanel, BorderLayout.WEST);
        root.add(rightPanel, BorderLayout.CENTER);

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
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Blood Bank Management System");

        jLabel2.setText("Username");

        txtUsername.setText("jTextField1");

        jLabel3.setText("Password");

        txtPassword.setText("jPasswordField1");

        btnLogin.setText("Login");
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 341,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(118, 118, 118)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtPassword,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtUsername,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                71,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(147, 147, 147)
                                                                .addComponent(btnLogin)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin)
                                .addContainerGap(164, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        try {
            java.sql.Connection con = com.bloodbank.bloodbankmanagementsystem.connection.DBConnection.getConnection();

            String sql = "SELECT * FROM Login WHERE username=? AND password=?";

            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Login Successful");
                new com.bloodbank.bloodbankmanagementsystem.ui.DashboardFrame().setVisible(true);
                this.dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnLoginActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
