package Classes.View.ImageViewer;

import Classes.Model.Flame.Flame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class View extends Canvas implements Runnable {
    private BufferedImage image;
    private Flame flame;

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

    public void setFlame(Flame flame) {
        this.flame = flame;


    }

    public Flame getFlame() {
        return this.flame;

    }

    public void drawImage() {
        if (this.getImage() != null) {
            Graphics g = this.getGraphics();
            super.paint(g);
            g.drawImage(image, 0, 0, this);

        }
    }

    @Override
    public void paint(Graphics g) {
        if (this.flame != null) {
            g.drawImage(flame, 0, 0, this);

        }
    }

    @Override
    public void run() {
        while(true) {
            this.paint(this.getGraphics());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
