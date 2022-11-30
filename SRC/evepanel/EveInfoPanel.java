package evepanel;

import evecore.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EveInfoPanel extends JPanel
{

    JLabel name_lbl;
    JLabel race_lbl;
    JLabel corporation_lbl;
    JLabel ship_lbl;

    public EveInfoPanel(EvePlayer player)
    {
        super();

        setBorder(new TitledBorder("Info"));
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(320,120));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;

        c.ipadx = 10;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;

        c.gridy = 0;
        add(new JLabel("Name"),c);

        c.gridy++;
        add(new JLabel("Race"),c);

        c.gridy++;
        add(new JLabel("Corp"),c);

        c.gridy++;
        add(new JLabel("Ship"),c);


        c.anchor = GridBagConstraints.EAST;
        c.gridx = 1;

        c.gridy = 0;
        name_lbl = new JLabel("");
        add(name_lbl,c);

        c.gridy++;
        race_lbl = new JLabel("");
        add(race_lbl,c);

        c.gridy++;
        corporation_lbl = new JLabel("");
        add(corporation_lbl,c);

        c.gridy++;
        ship_lbl = new JLabel("");
        add(ship_lbl,c);
 
        updateData(player);

    }


    public void updateData(EvePlayer player)
    {
        name_lbl.setText(player.name);
        race_lbl.setText(player.race);
        corporation_lbl.setText(player.corporation);
        ship_lbl.setText(player.ship);
    }
}
