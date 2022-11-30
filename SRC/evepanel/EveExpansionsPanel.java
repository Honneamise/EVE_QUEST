package evepanel;

import evecore.*;

import java.awt.Dimension;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

//use this to set expansions checked or not
class ButtonModel extends DefaultButtonModel
{
    boolean selected;

    ButtonModel(boolean selected)
    {
        this.selected = selected;
    }
        
    @Override
    public boolean isSelected() 
    {
        return selected;
    }

    @Override
    public void setSelected(boolean b) 
    {
            
    }

    @Override
    public boolean isRollover()
    {
        return false;
    }

    @Override
    public boolean isPressed() 
    {
        return false;
    }
}

public class EveExpansionsPanel extends JPanel
{
    ArrayList<JCheckBox> expansions;

    public EveExpansionsPanel(EvePlayer player)
    {
        super();

        setBorder(new TitledBorder("Expansions"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(160,260));

        expansions = new ArrayList<JCheckBox>();
        
        for(int i=0;i<EveDb.expansions.size();i++)
        {
            String name = EveDb.expansions.getString(i);

            JCheckBox b = new JCheckBox(name);
            b.setFocusable(false);
            b.setModel( new ButtonModel(false) );
            
            expansions.add(b);

            add(expansions.get(i));

        }

        updateData(player);

    }

    public void updateData(EvePlayer player)
    {
        for(int i=0;i<player.expansion;i++)
        {
            expansions.get(i).setModel(new ButtonModel(true)); 
        }
    }
}
