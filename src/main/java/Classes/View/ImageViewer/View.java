package Classes.View.ImageViewer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class View extends Canvas {
    private BufferedImage image;

    public View(Dimension dimension) {
        super();
        this.setSize(dimension);

    }

    public BufferedImage getImage() {
        return image;

    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.paint(getGraphics());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (this.getImage() != null) {
            g.drawImage(image, 0, 0, this);

        }
    }
}
