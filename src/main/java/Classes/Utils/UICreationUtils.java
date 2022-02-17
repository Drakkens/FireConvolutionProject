package Classes.Utils;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public record UICreationUtils(JPanel container, GridBagConstraints constraints) {

    public void createButton(String content, ActionListener actionListener) {
        JButton button = new JButton(content);
        container.add(button, constraints);
        button.addActionListener(actionListener);

    }

    public void createLabel(String content) {
        JLabel label = new JLabel(content);
        container.add(label, constraints);
    }

    public void createSlider(int min, int max, ChangeListener changeListener) {
        JSlider slider = new JSlider(min, max);
        container.add(slider, constraints);
        slider.addChangeListener(changeListener);
    }

    public void createTextField(String text) {
        JTextField textField = new JTextField(text, 20);
        container.add(textField, constraints);

    }

    public void createComboBox() {

    }

}
