package com.bloodbank.bloodbankmanagementsystem.ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.*;

/**
 * MedicalTheme — shared styling utility for the Blood Bank Management System.
 * Provides colors, fonts, and helper methods to apply a professional
 * hospital/medical aesthetic to all Swing components.
 */
public class MedicalTheme {

    // ─── Color Palette ────────────────────────────────────────────────────────
    public static final Color BG_DARK = new Color(0x0A1628);
    public static final Color BG_CARD = new Color(0x132140);
    public static final Color BG_CARD_BORDER = new Color(0x1E3A6E);
    public static final Color BG_FIELD = new Color(0x1A2E50);
    public static final Color BG_TABLE_HDR = new Color(0x0D1A30);
    public static final Color BG_TABLE_ROW = new Color(0x132140);
    public static final Color BG_TABLE_ALT = new Color(0x0F1C32);
    public static final Color BG_TABLE_SEL = new Color(0x1E4080);

    public static final Color ACCENT_RED = new Color(0xC0392B);
    public static final Color ACCENT_RED_HOV = new Color(0x96281B);
    public static final Color ACCENT_BLUE = new Color(0x2980B9);
    public static final Color ACCENT_BLUE_HOV = new Color(0x1A6090);
    public static final Color ACCENT_GREEN = new Color(0x27AE60);
    public static final Color ACCENT_DARK = new Color(0x7F1C1C);
    public static final Color ACCENT_DARK_HOV = new Color(0x5C1010);
    public static final Color ACCENT_GRAY = new Color(0x2C3E50);
    public static final Color ACCENT_GRAY_HOV = new Color(0x1A252F);

    public static final Color TEXT_PRIMARY = new Color(0xFFFFFF);
    public static final Color TEXT_SECONDARY = new Color(0x8899BB);
    public static final Color TEXT_ACCENT = new Color(0xE74C3C);
    public static final Color BORDER_COLOR = new Color(0x1E3A6E);

    // ─── Fonts ────────────────────────────────────────────────────────────────
    public static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font FONT_HEADING = new Font("Segoe UI", Font.BOLD, 15);
    public static final Font FONT_LABEL = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_FIELD = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_BUTTON = new Font("Segoe UI", Font.BOLD, 13);
    public static final Font FONT_TABLE = new Font("Segoe UI", Font.PLAIN, 12);
    public static final Font FONT_SMALL = new Font("Segoe UI", Font.PLAIN, 11);
    public static final Font FONT_LOGO = new Font("Segoe UI", Font.BOLD, 28);
    public static final Font FONT_SUBLOGO = new Font("Segoe UI", Font.PLAIN, 13);

    // ─── Button Type Enum ─────────────────────────────────────────────────────
    public enum BtnType {
        PRIMARY, SECONDARY, DANGER, OUTLINE
    }

    // ─── Button Styling ───────────────────────────────────────────────────────
    public static JButton styleButton(JButton btn, BtnType type) {
        Color normal, hover;
        switch (type) {
            case PRIMARY:
                normal = ACCENT_RED;
                hover = ACCENT_RED_HOV;
                break;
            case SECONDARY:
                normal = ACCENT_BLUE;
                hover = ACCENT_BLUE_HOV;
                break;
            case DANGER:
                normal = ACCENT_DARK;
                hover = ACCENT_DARK_HOV;
                break;
            default:
                normal = ACCENT_GRAY;
                hover = ACCENT_GRAY_HOV;
                break;
        }

        final Color normalColor = normal;
        final Color hoverColor = hover;

        btn.setFont(FONT_BUTTON);
        btn.setForeground(TEXT_PRIMARY);
        btn.setBackground(normalColor);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(new EmptyBorder(8, 20, 8, 20));

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(normalColor);
            }
        });
        return btn;
    }

    // ─── Text Field Styling ───────────────────────────────────────────────────
    public static JTextField styleTextField(JTextField tf) {
        tf.setFont(FONT_FIELD);
        tf.setForeground(TEXT_PRIMARY);
        tf.setBackground(BG_FIELD);
        tf.setCaretColor(TEXT_PRIMARY);
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1),
                new EmptyBorder(6, 10, 6, 10)));
        tf.setPreferredSize(new Dimension(200, 36));
        return tf;
    }

    public static JPasswordField stylePasswordField(JPasswordField pf) {
        pf.setFont(FONT_FIELD);
        pf.setForeground(TEXT_PRIMARY);
        pf.setBackground(BG_FIELD);
        pf.setCaretColor(TEXT_PRIMARY);
        pf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1),
                new EmptyBorder(6, 10, 6, 10)));
        pf.setPreferredSize(new Dimension(200, 36));
        return pf;
    }

    // ─── ComboBox Styling ─────────────────────────────────────────────────────
    @SuppressWarnings("unchecked")
    public static <T> JComboBox<T> styleComboBox(JComboBox<T> cmb) {
        cmb.setFont(FONT_FIELD);
        cmb.setForeground(TEXT_PRIMARY);
        cmb.setBackground(BG_FIELD);
        cmb.setPreferredSize(new Dimension(200, 36));
        cmb.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        cmb.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton btn = new JButton("▼");
                btn.setFont(new Font("Segoe UI", Font.PLAIN, 10));
                btn.setForeground(TEXT_SECONDARY);
                btn.setBackground(BG_FIELD);
                btn.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
                btn.setFocusPainted(false);
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                return btn;
            }
        });
        cmb.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBackground(isSelected ? BG_TABLE_SEL : BG_FIELD);
                setForeground(TEXT_PRIMARY);
                setFont(FONT_FIELD);
                setBorder(new EmptyBorder(4, 10, 4, 10));
                return this;
            }
        });
        return cmb;
    }

    // ─── Label Styling ────────────────────────────────────────────────────────
    public static JLabel styleLabel(JLabel lbl) {
        lbl.setFont(FONT_LABEL);
        lbl.setForeground(TEXT_SECONDARY);
        return lbl;
    }

    // ─── Table Styling ────────────────────────────────────────────────────────
    public static void styleTable(JTable table) {
        table.setFont(FONT_TABLE);
        table.setForeground(TEXT_PRIMARY);
        table.setBackground(BG_TABLE_ROW);
        table.setSelectionForeground(TEXT_PRIMARY);
        table.setSelectionBackground(BG_TABLE_SEL);
        table.setGridColor(new Color(0x1E3A6E));
        table.setRowHeight(28);
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 1));
        table.setFillsViewportHeight(true);

        // Header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setForeground(TEXT_SECONDARY);
        header.setBackground(BG_TABLE_HDR);
        header.setPreferredSize(new Dimension(header.getWidth(), 34));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, BORDER_COLOR));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        // Alternating row renderer
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tbl, Object val,
                    boolean sel, boolean focus, int row, int col) {
                super.getTableCellRendererComponent(tbl, val, sel, focus, row, col);
                if (sel) {
                    setBackground(BG_TABLE_SEL);
                    setForeground(TEXT_PRIMARY);
                } else {
                    setBackground(row % 2 == 0 ? BG_TABLE_ROW : BG_TABLE_ALT);
                    setForeground(TEXT_PRIMARY);
                }
                setBorder(new EmptyBorder(4, 10, 4, 10));
                setFont(FONT_TABLE);
                return this;
            }
        });
    }

    // ─── ScrollPane Styling ───────────────────────────────────────────────────
    public static void styleScrollPane(JScrollPane sp) {
        sp.setBackground(BG_TABLE_ROW);
        sp.getViewport().setBackground(BG_TABLE_ROW);
        sp.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));

        // Style scrollbars
        sp.getVerticalScrollBar().setUI(new DarkScrollBarUI());
        sp.getHorizontalScrollBar().setUI(new DarkScrollBarUI());
        sp.getVerticalScrollBar().setBackground(BG_DARK);
        sp.getHorizontalScrollBar().setBackground(BG_DARK);
    }

    // ─── Dark ScrollBar UI ────────────────────────────────────────────────────
    public static class DarkScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new Color(0x2C4A7C);
            this.trackColor = BG_DARK;
        }

        @Override
        protected JButton createIncreaseButton(int o) {
            return createZeroButton();
        }

        @Override
        protected JButton createDecreaseButton(int o) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(0, 0));
            return btn;
        }
    }

    // ─── Create Styled Header Panel ───────────────────────────────────────────
    public static JPanel createHeaderPanel(String title, String subtitle) {
        JPanel header = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(0x0D1A30),
                        getWidth(), 0, new Color(0x1A1A3A));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };
        header.setPreferredSize(new Dimension(0, 65));
        header.setLayout(new BorderLayout(12, 0));
        header.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, ACCENT_RED),
                new EmptyBorder(10, 20, 10, 20)));

        // Icon + text
        JLabel icon = new JLabel("✚");
        icon.setFont(new Font("Segoe UI", Font.BOLD, 26));
        icon.setForeground(ACCENT_RED);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setOpaque(false);

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(FONT_HEADING);
        titleLbl.setForeground(TEXT_PRIMARY);

        JLabel subLbl = new JLabel(subtitle);
        subLbl.setFont(FONT_SMALL);
        subLbl.setForeground(TEXT_SECONDARY);

        textPanel.add(titleLbl);
        textPanel.add(subLbl);

        header.add(icon, BorderLayout.WEST);
        header.add(textPanel, BorderLayout.CENTER);

        return header;
    }

    // ─── Dark Background Panel ────────────────────────────────────────────────
    public static JPanel createDarkPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(BG_DARK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
    }

    // ─── Card Panel (rounded dark rectangle) ─────────────────────────────────
    public static JPanel createCardPanel() {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(BG_CARD);
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 12, 12));
                g2.setColor(BG_CARD_BORDER);
                g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 12, 12));
                g2.dispose();
            }
        };
        card.setOpaque(false);
        return card;
    }

    // ─── Form Row Helper ──────────────────────────────────────────────────────
    /** Returns a JPanel with a label on the left and a component on the right */
    public static JPanel formRow(String labelText, JComponent field) {
        JPanel row = new JPanel(new BorderLayout(10, 0));
        row.setOpaque(false);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

        JLabel lbl = new JLabel(labelText);
        lbl.setFont(FONT_LABEL);
        lbl.setForeground(TEXT_SECONDARY);
        lbl.setPreferredSize(new Dimension(120, 36));

        row.add(lbl, BorderLayout.WEST);
        row.add(field, BorderLayout.CENTER);
        return row;
    }

    // ─── Section Divider Label ────────────────────────────────────────────────
    public static JLabel sectionDivider(String text) {
        JLabel lbl = new JLabel(text.toUpperCase());
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lbl.setForeground(TEXT_ACCENT);
        lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x1E3A6E)));
        return lbl;
    }
}
