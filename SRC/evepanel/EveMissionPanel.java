package evepanel;

import evecore.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EveMissionPanel extends JPanel
{
    JPanel panel;

    JLabel agent_lbl;

    JLabel desc_lbl;
    JLabel target_lbl;

    JLabel region_lbl;
    JLabel system_lbl;
    JLabel security_lbl;

    JProgressBar bar;

    public EveMissionPanel(EvePlayer player)
    {
        super();
        setLayout(new BorderLayout());

        //panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        panel.setBorder(new TitledBorder("Mission"));
        
        GridBagConstraints c = new GridBagConstraints();
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 10;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;

        c.gridy = 0;
        panel.add(new JLabel("Agent"),c);

        c.gridy++;
        panel.add(new JLabel("Description"),c);

        c.gridy++;
        panel.add(new JLabel("Target"),c);

        c.gridy++;
        panel.add(new JLabel("Region"),c);

        c.gridy++;
        panel.add(new JLabel("System"),c);

        c.gridy++;
        panel.add(new JLabel("Security"),c);
        
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 1;

        c.gridy = 0;
        agent_lbl = new JLabel("");
        panel.add(agent_lbl,c);

        c.gridy++;
        desc_lbl = new JLabel("");
        panel.add(desc_lbl,c);

        c.gridy++;
        target_lbl = new JLabel("");
        panel.add(target_lbl,c);

        c.gridy++;
        region_lbl = new JLabel("");
        panel.add(region_lbl,c);

        c.gridy++;
        system_lbl = new JLabel("");
        panel.add(system_lbl,c);

        c.gridy++;
        security_lbl = new JLabel("");
        panel.add(security_lbl,c);

        //bar
        bar = new JProgressBar(0,100);
        bar.setStringPainted(true);
        bar.setBorder(new TitledBorder("Progress"));
        
        //
        add(panel,BorderLayout.CENTER);
        add(bar,BorderLayout.SOUTH);

        updateData(player);
        updateBar(player);
    }


    public void updateData(EvePlayer player)
    {
        agent_lbl.setText(player.mission_agent);

        desc_lbl.setText(player.mission_desc);
        target_lbl.setText(player.mission_target);

        region_lbl.setText(player.mission_region);
        system_lbl.setText(player.mission_system);
        security_lbl.setText(player.mission_security);
        
    }

    public void updateBar(EvePlayer player)
    {
        bar.setValue(player.mission_progress);
    }
}
