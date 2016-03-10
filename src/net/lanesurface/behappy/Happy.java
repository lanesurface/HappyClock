/**
 * Happy.java
 * @author Lane Surface
 * @version 1.0
 * 
 * An animation that brightens your day!
 */
package net.lanesurface.behappy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Happy extends JFrame {
    public static final int WIDTH = 1920, HEIGHT = 1080;
    public static final String WINDOW_STRING = "Be Happy!",
                               WINDOW_STRING_SUB = "Even death isn't feared " +
                                       "by those who have lived wisely.";

    private BufferedImage lotusImage;

    private int half = WIDTH / 2;
    private int hAlign = HEIGHT / 2;

    public Happy() throws IOException {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

        lotusImage = ImageIO.read(new File("lotus_flower.png"));
        setIconImage(lotusImage);
    }
    // Let's paint some happy little trees!
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.RED);

        g.setFont(new Font("Consolas", Font.PLAIN, 12));

        g.drawString(
                WINDOW_STRING,
                half - g.getFontMetrics().stringWidth(WINDOW_STRING) / 2,
                hAlign);
        g.drawString(WINDOW_STRING_SUB,
                half - g.getFontMetrics().stringWidth(WINDOW_STRING_SUB) / 2,
                hAlign + 50);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 20));

        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        String nowString = now.toString();
        g.drawString(
                nowString,
                half - g.getFontMetrics().stringWidth(nowString) / 2,
                hAlign + 25);

        g.drawImage(lotusImage, half - lotusImage.getWidth() / 2,hAlign - 60, 
                null);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 1000);

        g.dispose();
    }

    public static void main(String[] args) {
        try {
            Happy happy = new Happy();
        } catch (IOException ie) {} // Yeah... we're not going to do anything if
                                    // that happens. ^^
    }
}
