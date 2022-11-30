package evepanel;

import evecore.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EveWinPanel extends JPanel
{
    public EveWinPanel(EvePlayer player)
    {
        super();
        setLayout(new GridBagLayout());
        setBorder(new TitledBorder("Aura"));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;

        c.gridy = 0;
        add(new JLabel("Congratulations !!!"),c);

        c.gridy++;
        add(new JLabel("You have won EVE..."),c);
        
        c.gridy++;
        add(new JLabel("Were you expecting \"Walking in stations\" ?"),c);

    }


    public void updateData(EvePlayer player)
    {
       
    }
}
