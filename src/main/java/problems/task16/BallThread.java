package problems.task16;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class BallThread extends Thread {
    private final Random random = new Random();

    private final int ballSize = 10;
    private final double alpha;
    private final int speed = 4;
    private final int posY;

    JPanel panel;
    private int posX;
    private Color color;

    BallThread(JPanel p) {
        this.panel = p;
        boolean direction = random.nextBoolean();
        if (direction) {
            posX = 0;
            alpha = 0;
        } else {
            posX = panel.getWidth() - ballSize;
            alpha = Math.PI;
        }
        posY = (int) ((panel.getHeight() - ballSize) * random.nextFloat());
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    BallThread(JPanel p, int startX, double alpha) {
        this.panel = p;
        this.alpha = alpha;
        posX = startX;
        posY = (int) ((panel.getHeight() - ballSize) * random.nextFloat());
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Override
    public void run() {
        boolean fly = true;
        while (fly) {
            posX += (int) (speed * Math.cos(alpha));
            if (posX >= panel.getWidth() - ballSize) {
                new BallThread(panel, 0, alpha).start();
                fly = false;
            } else if (posX <= 0) {
                new BallThread(panel, panel.getWidth() - ballSize, alpha).start();
                fly = false;
            }
            paint(panel.getGraphics());
        }
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillArc(posX, posY, ballSize, ballSize, 0, 360);
        g.drawArc(posX + 1, posY + 1, ballSize, ballSize, 120, 30);

        try {
            sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        g.setColor(panel.getBackground());
        g.fillArc(posX, posY, ballSize, ballSize, 0, 360);
    }
}
