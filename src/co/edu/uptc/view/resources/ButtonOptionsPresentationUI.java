package co.edu.uptc.view.resources;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class ButtonOptionsPresentationUI extends BasicButtonUI {

    private boolean isMouseOver = false;
    private boolean isBorderPainted = false;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(new Font("Segoe UI", Font.BOLD, 20));
                button.setForeground(Color.WHITE);
                isMouseOver = true;
                isBorderPainted = true;
                button.repaint();
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(new Font("Segoe UI", Font.BOLD, 20));
                button.setForeground(Color.WHITE);
                isMouseOver = false;
                isBorderPainted = false;
                button.repaint();
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        int width = c.getWidth();
        int height = c.getHeight();

        g2d.setColor(new Color(39, 39, 39));
        g2d.fillRect(0, 0, width, height);
        c.setBorder(null);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, height - 5, width, 5);
        super.paint(g, c);
    }

    @Override
    protected void installDefaults(AbstractButton button) {
        super.installDefaults(button);
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setIcon(null);
    }
}
