package org.example;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.geom.AffineTransform;

public final class DrunkyButtonUI extends BasicButtonUI {
    private static final String CANONICAL_NAME = DrunkyButtonUI.class.getCanonicalName();
    private static final ButtonUI INSTANCE = new DrunkyButtonUI();

    static final String ID = CANONICAL_NAME + ".id";

    static {
        UIManager.put(ID, CANONICAL_NAME);
        UIManager.put(CANONICAL_NAME, DrunkyButtonUI.class);
    }

    // Called by swing
    @SuppressWarnings("unused")
    public static ComponentUI createUI(JComponent c) {
        assert c instanceof JButton : "I only know how to display buttons";
        System.out.println("They want to update ui? Well, here is my singleton");
        return INSTANCE;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        var g2 = (Graphics2D) g.create();
        try {
            AffineTransform affineTransform = AffineTransform.getRotateInstance(0.1);
            g2.setTransform(affineTransform);
            super.paint(g2, c);
        } finally {
            g2.dispose();
        }

    }
}
