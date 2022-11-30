package evescene;

import evepanel.EveIntroPanel;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import javax.swing.*;

public class EveWinScene extends JPanel
{
    BufferedImage img;

    public EveWinScene()
    {
        super();

        setLayout(new BorderLayout()); 
        setPreferredSize(new Dimension(900,600));

        try
        {
            img = ImageIO.read(new File("RES/IMAGES/BACKGROUNDS/bg5.jpeg"));

        }catch(Exception e) { e.printStackTrace(); }

        JPanel content_panel = new JPanel();
        content_panel.setLayout(new GridBagLayout());
        content_panel.setOpaque(false);

        content_panel.add(new EveIntroPanel(null));
        add(content_panel, BorderLayout.CENTER);
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
