package evescene;

import evecore.*;
import evepanel.EveIntroPanel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import javax.swing.*;

public class EveIntroScene extends JPanel implements ActionListener
{
    BufferedImage img;

    JButton b_login;

    public EveIntroScene()
    {
        super();

        setLayout(new BorderLayout()); 
        setPreferredSize(new Dimension(900,600));

        try
        {
            img = ImageIO.read(new File("RES/IMAGES/BACKGROUNDS/bg2.jpeg"));

        }catch(Exception e) { e.printStackTrace(); }

        JPanel controls = new JPanel();
        controls.setOpaque(false);

        b_login = new JButton("Login");
        b_login.addActionListener(this);
        controls.add(b_login);

        JPanel content_panel = new JPanel();
        content_panel.setLayout(new GridBagLayout());
        content_panel.setOpaque(false);

        content_panel.add(new EveIntroPanel(null));
        add(content_panel, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == b_login)
        {
            EveGame.getPlayer().randomize();
            EveGame.setScene( new EveCreationScene() );
        }
        
    }
}
