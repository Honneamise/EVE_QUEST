package evescene;
import java.awt.*;
import java.awt.image.*;
import java.io.File;

import javax.imageio.*;
import javax.swing.*;

public class EveLoadScene extends JPanel
{
    BufferedImage img = null;

    public EveLoadScene()
    {
        super();

        try
        {
            img = ImageIO.read(new File("RES/IMAGES/BACKGROUNDS/bg1.jpeg"));

        }catch(Exception e) { e.printStackTrace(); }

    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

}

