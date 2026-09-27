package Recycle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomPanel extends JPanel {

    private JLabel label;
    private Color defaultColor = new Color(204, 204, 204);
    private Color hoverColor = new Color(102, 102, 102);
    private Color pressedColor = new Color(153, 153, 153);
    private Color activeColor = new Color(102, 102, 102);
    private static CustomPanel lastClickedPanel = null;
    private boolean isPressed = false;

    public CustomPanel() {
        // Use BorderLayout for automatic centering
        setLayout(new BorderLayout());
        setBackground(defaultColor);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        // Create centered label with optional icon support
        label = new JLabel("Custom Panel");
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.RIGHT); // Text appears to the right of the icon
        label.setVerticalTextPosition(SwingConstants.CENTER); // Text is vertically centered relative to icon
        label.setIconTextGap(5); // Gap between icon and text
        label.setOpaque(true);
        label.setBackground(defaultColor);

        // Add label to center of panel
        add(label, BorderLayout.CENTER);

        // Add mouse listeners for effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isPressed && lastClickedPanel != CustomPanel.this) {
                    setBackground(hoverColor);
                    label.setBackground(hoverColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isPressed && lastClickedPanel != CustomPanel.this) {
                    setBackground(defaultColor);
                    label.setBackground(defaultColor);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                setBackground(pressedColor);
                label.setBackground(pressedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                if (lastClickedPanel != CustomPanel.this) {
                    setBackground(hoverColor);
                    label.setBackground(hoverColor);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (lastClickedPanel != null) {
                    lastClickedPanel.setBackground(defaultColor);
                    lastClickedPanel.label.setBackground(defaultColor);
                }
                lastClickedPanel = CustomPanel.this;
                setBackground(activeColor);
                label.setBackground(activeColor);
            }
        });
    }

    // Getters and setters
    public void setText(String text) {
        label.setText(text);
        repaint();
    }

    public String getText() {
        return label.getText();
    }

    public void setIcon(Icon icon) {
        label.setIcon(icon);
        repaint();
    }

    public Icon getIcon() {
        return label.getIcon();
    }

    public void setTextFont(Font font) {
        label.setFont(font);
        repaint();
    }

    public void setTextAlignment(int alignment) {
        label.setHorizontalAlignment(alignment);
        repaint();
    }

    public void setTextForeground(Color color) {
        label.setForeground(color);
        repaint();
    }

    public void setPanelColors(Color background) {
        setBackground(background);
        label.setBackground(background);
        repaint();
    }

    public JLabel getLabel() {
        return label;
    }

    // Override paintComponent for smooth rendering
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    // Override getPreferredSize to provide default dimensions
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width = Math.max(size.width, 200); // Minimum width
        size.height = Math.max(size.height, 40); // Minimum height
        return size;
    }
}
