package evescene;

import evecore.*;
import evepanel.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.beans.*;
import java.io.File;
import javax.imageio.*;
import javax.swing.*;

public class EveGameScene extends JPanel implements ActionListener,PropertyChangeListener
{
    BufferedImage img = null;

    //content panel
    JPanel content_panel;

    EveInfoPanel info_panel;
    EveStatsPanel stats_panel;
    EveDataPanel data_panel;
    EveSkillsPanel skills_panel;
    EveExpansionsPanel expansions_panel;
    EveMissionPanel mission_panel;
    EveCargoPanel cargo_panel;

    //controls
    JButton b_dock;

    public EveGameScene()
    {
        super();
        
        setLayout(new BorderLayout()); 

        try
        {
            img = ImageIO.read(new File("RES/IMAGES/BACKGROUNDS/bg3.jpeg"));

        }catch(Exception e) { e.printStackTrace(); }

        
        /**********/
        info_panel = new EveInfoPanel(EveGame.getPlayer());
        stats_panel = new EveStatsPanel(EveGame.getPlayer());
        data_panel = new EveDataPanel(EveGame.getPlayer());
        skills_panel = new EveSkillsPanel(EveGame.getPlayer());
        expansions_panel = new EveExpansionsPanel(EveGame.getPlayer());
        mission_panel = new EveMissionPanel(EveGame.getPlayer());
        cargo_panel = new EveCargoPanel(EveGame.getPlayer());

        content_panel = new JPanel();
        content_panel.setLayout(new GridBagLayout());
        content_panel.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();
        
        c.anchor = GridBagConstraints.CENTER;
        c.ipadx = 10;
        
        //first column
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        content_panel.add(info_panel,c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        content_panel.add(stats_panel,c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        content_panel.add(data_panel,c);
        
        c.fill = GridBagConstraints.BOTH;//
        c.gridx = 0;
        c.gridy = 3;
        content_panel.add(cargo_panel,c);

        //second colum
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 3;
        content_panel.add(skills_panel,c);

        

        //third column
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 3;
        content_panel.add(expansions_panel,c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        content_panel.add(mission_panel,c);

        add(content_panel, BorderLayout.CENTER);

        //controls
        JPanel controls_panel = new JPanel();
        controls_panel.setOpaque(false);
        
        b_dock = new JButton("Rage Quit");
        b_dock.addActionListener(this);
        controls_panel.add(b_dock);

        add(controls_panel, BorderLayout.SOUTH);

        //listen to the player's changes
        EveGame.getPlayer().addPropertyChangeListener(this);
 
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
        if(e.getSource() == b_dock)
        {
            int n = JOptionPane.showConfirmDialog(this,
                    "Really want to close Excel Simulator ?",
                    "Petition",
                    JOptionPane.YES_NO_OPTION);

            if(n!=JOptionPane.YES_OPTION){ return; }


            EveGame.getPlayer().timer.stop();

            EveGame.getPlayer().removePropertyChangeListener(this);
            
            System.exit(0);
        }    
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) 
    {
        String property = e.getPropertyName();

        switch(property)
        {
            case "mission_progress":
                mission_panel.updateBar(EveGame.getPlayer());
                break;

            case "mission_completed":
                data_panel.updateData(EveGame.getPlayer());
                mission_panel.updateData(EveGame.getPlayer());
                cargo_panel.updateData(EveGame.getPlayer());
                skills_panel.updateData(EveGame.getPlayer());
                expansions_panel.updateData(EveGame.getPlayer());
                break;

            case "game_completed":
                EveGame.getPlayer().timer.stop();
                EveGame.getPlayer().removePropertyChangeListener(this);
                EveGame.setScene(new EveWinScene());
                break;
                
            default:
                //error
                break;
        }
        
    }

}

