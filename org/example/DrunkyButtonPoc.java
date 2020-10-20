package org.example;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class DrunkyButtonPoc {


    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            var frame = new JFrame("MyApp");
            var button = new DrunkyButton("Drunky button");

            var lfIterator = Arrays.stream(UIManager.getInstalledLookAndFeels()).iterator();
            button.addActionListener(e -> {
                if (lfIterator.hasNext()) {
                    try {
                        UIManager.setLookAndFeel(lfIterator.next().getClassName());
                        SwingUtilities.updateComponentTreeUI(frame);
                        frame.pack();
                    } catch (ReflectiveOperationException | UnsupportedLookAndFeelException instantiationException) {
                        instantiationException.printStackTrace();
                    }
                }
            });
            frame.getContentPane().add(button, BorderLayout.WEST);
            frame.getContentPane().add(new JButton(("Regular button")), BorderLayout.EAST);
            frame.pack();
            frame.setVisible(true);
        });
    }


}
