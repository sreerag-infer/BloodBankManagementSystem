/*
 * Blood Bank Management System
 * DashboardFrame — Professional Medical UI
 */
package com.bloodbank.bloodbankmanagementsystem.ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Sreerag
 */
public class DashboardFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(DashboardFrame.class.getName());

    public DashboardFrame() {
        initComponents();
        applyTheme();
    }

    private void applyTheme() {
        setTitle("Blood Bank Management System — Dashboard");
        setResizable(false);

        // ── Root ─────────────────────────────────────────────────────────────
        JPanel root = MedicalTheme.createDarkPanel();
        root.setLayout(new BorderLayout());
        root.setPreferredSize(new Dimension(780, 520));

        // ── Header ───────────────────────────────────────────────────────────
        JPanel header = MedicalTheme.createHeaderPanel(
                "Blood Bank Management System",
                "Administrator Dashboard");
        root.add(header, BorderLayout.NORTH);

        // ── Center — card grid ────────────────────────────────────────────────
        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new GridBagLayout());
        center.setBorder(new EmptyBorder(36, 36, 36, 36));

        String[][] cards = {
                { "🩸", "Donor Management", "Register & manage blood donors" },
                { "🏥", "Patient Management", "Track patients & blood needs" },
                { "🧪", "Blood Stock", "Monitor blood unit inventory" },
                { "📋", "Request Management", "Process blood requests" }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        JButton[] cardButtons = { btnDonor, btnPatient, btnStock, btnRequest };

        for (int i = 0; i < cards.length; i++) {
            final JButton btn = cardButtons[i];
            final int idx = i;
            JPanel card = buildDashCard(cards[i][0], cards[i][1], cards[i][2], btn);

            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            center.add(card, gbc);
        }

        root.add(center, BorderLayout.CENTER);

        // ── Footer ────────────────────────────────────────────────────────────
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 8));
        footer.setOpaque(false);
        footer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, MedicalTheme.BORDER_COLOR));
        JLabel footerLbl = new JLabel("Blood Bank Management System  •  v1.0   ");
        footerLbl.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        footerLbl.setForeground(MedicalTheme.TEXT_SECONDARY);
        footer.add(footerLbl);
        root.add(footer, BorderLayout.SOUTH);

        setContentPane(root);
        pack();
        setLocationRelativeTo(null);
    }

    /** Build a single dashboard navigation card */
    private JPanel buildDashCard(String icon, String title, String subtitle, JButton btn) {
        JPanel card = new JPanel() {
            private boolean hovered = false;
            {
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        hovered = true;
                        repaint();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        hovered = false;
                        repaint();
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        btn.doClick();
                    }
                });
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color bg = hovered ? new Color(0x1E3A6E) : MedicalTheme.BG_CARD;
                g2.setColor(bg);
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 14, 14));
                Color border = hovered ? MedicalTheme.ACCENT_RED : MedicalTheme.BG_CARD_BORDER;
                g2.setColor(border);
                g2.setStroke(new BasicStroke(hovered ? 2f : 1f));
                g2.draw(new RoundRectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2, 14, 14));
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setPreferredSize(new Dimension(300, 150));
        card.setLayout(new BorderLayout(0, 0));

        // Hide the actual JButton (it still handles clicks programmatically)
        btn.setVisible(false);

        // Left accent strip
        JPanel strip = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(MedicalTheme.ACCENT_RED);
                g2.fill(new RoundRectangle2D.Float(0, 20, getWidth(), getHeight() - 40, 6, 6));
                g2.dispose();
            }
        };
        strip.setOpaque(false);
        strip.setPreferredSize(new Dimension(6, 0));

        // Content
        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(new EmptyBorder(20, 18, 20, 18));

        JLabel iconLbl = new JLabel(icon);
        iconLbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 34));
        iconLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(MedicalTheme.FONT_HEADING);
        titleLbl.setForeground(MedicalTheme.TEXT_PRIMARY);
        titleLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subLbl = new JLabel(subtitle);
        subLbl.setFont(MedicalTheme.FONT_SMALL);
        subLbl.setForeground(MedicalTheme.TEXT_SECONDARY);
        subLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel arrowLbl = new JLabel("→  Open");
        arrowLbl.setFont(new Font("Segoe UI", Font.BOLD, 11));
        arrowLbl.setForeground(MedicalTheme.ACCENT_RED);
        arrowLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        content.add(iconLbl);
        content.add(Box.createVerticalStrut(8));
        content.add(titleLbl);
        content.add(Box.createVerticalStrut(4));
        content.add(subLbl);
        content.add(Box.createVerticalGlue());
        content.add(arrowLbl);

        card.add(strip, BorderLayout.WEST);
        card.add(content, BorderLayout.CENTER);
        card.add(btn, BorderLayout.EAST); // invisible, still in layout

        return card;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnDonor = new javax.swing.JButton();
        btnPatient = new javax.swing.JButton();
        btnStock = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Dashboard");

        btnDonor.setText("Donor Management");
        btnDonor.addActionListener(this::btnDonorActionPerformed);

        btnPatient.setText("Patient Management");
        btnPatient.addActionListener(this::btnPatientActionPerformed);

        btnStock.setText("Blood Stock");
        btnStock.addActionListener(this::btnStockActionPerformed);

        btnRequest.setText("Request Management");
        btnRequest.addActionListener(this::btnRequestActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(129, 129, 129)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(btnStock,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnPatient,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                                Short.MAX_VALUE)
                                                        .addComponent(btnDonor,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnRequest,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                                Short.MAX_VALUE))))
                                .addContainerGap(134, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDonor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPatient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRequest)
                                .addContainerGap(153, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDonorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDonorActionPerformed
        new com.bloodbank.bloodbankmanagementsystem.ui.DonorFrame().setVisible(true);
    }// GEN-LAST:event_btnDonorActionPerformed

    private void btnPatientActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPatientActionPerformed
        new com.bloodbank.bloodbankmanagementsystem.ui.PatientFrame().setVisible(true);
    }// GEN-LAST:event_btnPatientActionPerformed

    private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnStockActionPerformed
        new com.bloodbank.bloodbankmanagementsystem.ui.BloodStockFrame().setVisible(true);
    }// GEN-LAST:event_btnStockActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRequestActionPerformed
        new com.bloodbank.bloodbankmanagementsystem.ui.RequestFrame().setVisible(true);
    }// GEN-LAST:event_btnRequestActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new DashboardFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonor;
    private javax.swing.JButton btnPatient;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnStock;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
