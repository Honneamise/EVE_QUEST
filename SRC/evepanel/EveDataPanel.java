package evepanel;

import evecore.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EveDataPanel extends JPanel
{
    JLabel missions_lbl;
    JLabel skillpoints_lbl;
    JLabel isk_lbl;
    
    public EveDataPanel(EvePlayer player)
    {
        super();

        setBorder(new TitledBorder("Data"));
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(320,100));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;

        c.ipadx = 10;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;

        c.gridy = 0;
        add(new JLabel("Missions"),c);

        c.gridy++;
        add(new JLabel("Skillpoints"),c);

        c.gridy++;
        add(new JLabel("Isks"),c);

        c.anchor = GridBagConstraints.EAST;
        c.gridx = 1;

        c.gridy = 0;
        missions_lbl = new JLabel("");
        add(missions_lbl,c);

        c.gridy++;
        skillpoints_lbl = new JLabel("");
        add(skillpoints_lbl,c);

        c.gridy++;
        isk_lbl = new JLabel("");
        add(isk_lbl,c);
 
        updateData(player);

    }


    public void updateData(EvePlayer player)
    {
        missions_lbl.setText(""+player.missions);
        skillpoints_lbl.setText(String.format("%,d",player.skillpoints));
        isk_lbl.setText(String.format("%,d",player.isk));
    }
}
