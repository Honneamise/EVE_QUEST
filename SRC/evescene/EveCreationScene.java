package evescene;

import evecore.*;
import evepanel.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.*;
import javax.swing.*;

public class EveCreationScene extends JPanel implements ActionListener
{
    BufferedImage img = null;

    //content panel
    JPanel content_panel;

    EveInfoPanel info_panel;
    EveStatsPanel stats_panel;
    EveSkillsPanel skills_panel;

    //control panel
    JPanel controls_panel;

    JButton b_randomize;
    JButton b_style;
    JButton b_undock;

    public EveCreationScene()
    {
        super();
        
        setLayout(new BorderLayout()); 
        setPreferredSize(new Dimension(900,600));

        try
        {
            img = ImageIO.read(new File("RES/IMAGES/BACKGROUNDS/bg4.jpeg"));

        }catch(Exception e) { e.printStackTrace(); }

        
        /**********/
        info_panel = new EveInfoPanel(EveGame.getPlayer());
        stats_panel = new EveStatsPanel(EveGame.getPlayer());
        skills_panel = new EveSkillsPanel(EveGame.getPlayer());

        content_panel = new JPanel();
        content_panel.setLayout(new GridBagLayout());
        content_panel.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        c.gridx = 0;
        c.gridy = 0;
        content_panel.add(info_panel,c);

        c.gridx = 1;
        c.gridy = 0;
        content_panel.add(stats_panel,c);
        
        c.gridx = 2;
        c.gridy = 0;
        content_panel.add(skills_panel,c);

        /**********/
        b_randomize = new JButton("Buy PLEX");
        b_randomize.addActionListener(this);

        b_style = new JButton("Change Fit");
        b_style.addActionListener(this);
        
        b_undock = new JButton("Undock");
        b_undock.addActionListener(this);

        controls_panel = new JPanel();
        controls_panel.setOpaque(false);

        controls_panel.add(b_randomize);
        controls_panel.add(b_style);
        controls_panel.add(b_undock);

        /**********/
        add(content_panel, BorderLayout.CENTER);
        add(controls_panel, BorderLayout.SOUTH);
    
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource() == b_randomize)
        {
            EveGame.getPlayer().randomize();

            info_panel.updateData(EveGame.getPlayer());
            stats_panel.updateData(EveGame.getPlayer());
            skills_panel.updateData(EveGame.getPlayer());
        }

        if(e.getSource() == b_style)
        {
            EveGame.changeStyle();
        }

        if(e.getSource() == b_undock)//also save the player
        {
            int n = JOptionPane.showConfirmDialog(this,
                    "Ready to be ganked ?",
                    "Downtime",
                    JOptionPane.YES_NO_OPTION);

            if(n!=JOptionPane.YES_OPTION){ return; }

            EveGame.getPlayer().generateMission();
            EveGame.setScene( new EveGameScene() );
            EveGame.getPlayer().timer.restart();
        }
    }

}

