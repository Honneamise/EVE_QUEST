package evepanel;

import evecore.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class EveStatsPanel extends JPanel
{
    JLabel intelligence_lbl;
    JLabel charisma_lbl;
    JLabel perception_lbl;
    JLabel memory_lbl;
    JLabel willpower_lbl;

    public EveStatsPanel(EvePlayer player)
    {
        super();

        setBorder(new TitledBorder("Stats"));
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(140,140));

        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 10;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;

        c.gridy = 0;
        add(new JLabel("Charisma"),c);

        c.gridy++;
        add(new JLabel("Intelligence"),c);

        c.gridy++;
        add(new JLabel("Memory"),c);

        c.gridy++;
        add(new JLabel("Perception"),c);

        c.gridy++;
        add(new JLabel("Willpower"),c);

        c.anchor = GridBagConstraints.EAST;
        c.gridx = 1;

        c.gridy = 0;
        charisma_lbl = new JLabel("");
        add(charisma_lbl,c);

        c.gridy++;
        intelligence_lbl = new JLabel("");
        add(intelligence_lbl,c);

        c.gridy++;
        memory_lbl = new JLabel("");
        add(memory_lbl,c);

        c.gridy++;
        perception_lbl = new JLabel("");
        add(perception_lbl,c);

        c.gridy++;
        willpower_lbl = new JLabel("");
        add(willpower_lbl,c);

        updateData(player);

    }


    public void updateData(EvePlayer player)
    {
        charisma_lbl.setText("" + player.charisma);
        intelligence_lbl.setText("" + player.intelligence);
        memory_lbl.setText("" + player.memory);
        perception_lbl.setText("" + player.perception);
        willpower_lbl.setText("" + player.willpower);
    }
}

