package evepanel;

import evecore.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EveIntroPanel extends JPanel
{
    public EveIntroPanel(EvePlayer player)
    {
        super();
        setLayout(new GridBagLayout());
        setBorder(new TitledBorder("Aura"));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;

        c.gridy = 0;
        add(new JLabel("Eve Quest is an hardcore game."),c);

        c.gridy++;
        add(new JLabel("Once you logged in the only way to quit is to pod yourself."),c);
        
        c.gridy++;
        add(new JLabel("Clones are not available."),c);

    }


    public void updateData(EvePlayer player)
    {
       
    }
}
