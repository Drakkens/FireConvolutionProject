package Classes.Utils;

import java.awt.*;

public class ConstraintsUtils extends GridBagConstraints {

    public ConstraintsUtils resetConstraints() {
        this.gridx = 0;
        this.gridy = 0;
        this.gridwidth = 1;
        this.gridheight = 1;
        this.weightx = 0;
        this.weighty = 0;
        this.ipadx = 0;
        this.ipady = 0;
        this.fill = GridBagConstraints.BOTH;

        return this;
    }

    public ConstraintsUtils changeConstraintsPosition(int x, int y) {
        this.gridx = x;
        this.gridy = y;

        return this;

    }

    public ConstraintsUtils changeConstraintsWeight(int weightX, int weightY) {
        this.weightx = weightX;
        this.weighty = weightY;

        return this;

    }

    public ConstraintsUtils changeConstraintsPadding(int paddingX, int paddingY) {
        this.ipadx = paddingX;
        this.ipady = paddingY;

        return this;

    }

    public ConstraintsUtils changeConstraintsDimensions(int width, int height) {
        this.gridwidth = width;
        this.gridheight = height;

        return this;

    }
}
