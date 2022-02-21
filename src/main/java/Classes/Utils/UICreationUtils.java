package Classes.Utils;

import Classes.Model.ColorUtility.TargetColor;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    public JComboBox<Object> createComboBox(ArrayList<?> sourceArray, ActionListener actionListener) {
        JComboBox<Object> comboBox = new JComboBox<>(sourceArray.toArray());
        comboBox.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        comboBox.addActionListener(actionListener);
        container.add(comboBox, constraints);

        return comboBox;
    }

    public JSpinner createSpinner(SpinnerNumberModel spinnerNumberModel, ChangeListener changeListener) {
        JSpinner spinner = new JSpinner(spinnerNumberModel);
        spinner.addChangeListener(changeListener);
        container.add(spinner, constraints);

        return spinner;
    }

}
