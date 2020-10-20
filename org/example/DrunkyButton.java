package org.example;

import javax.swing.*;

public final class DrunkyButton extends JButton {

    public DrunkyButton(String text) {
        super(text);
    }

    @Override
    public String getUIClassID() {
        return DrunkyButtonUI.ID;
    }
}
