package evepanel;

import evecore.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class EveCargoPanel extends JPanel
{
    ArrayList<JLabel> labels;
    JPanel panel;
    JScrollPane pane;

    public EveCargoPanel(EvePlayer player)
    {
        super();
        setBorder(new TitledBorder("Cargo"));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(320,240));
        
        labels = new ArrayList<JLabel>();
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for(int i=0;i<10;i++)//prepare 10 empty labels
        {
            labels.add(new JLabel(""));
            panel.add(labels.get(i));
        }

        pane = new JScrollPane(panel);
        pane.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
                
        pane.setPreferredSize(new Dimension(300,300));
        add(pane);

        updateData(player);

    }

    public void updateData(EvePlayer player)
    {        
        //add new cargo if any
        //IMPORTANT : preserve panel size !!!
        if(labels.size()<player.cargo.size())
        {
            //Dimension d = pane.getSize();

            for(int i=labels.size();i<labels.size() + (player.cargo.size()-labels.size()); i++)
            {
                labels.add(new JLabel(""));
                panel.add(labels.get(i));
            }

            //pane.setPreferredSize(d);
        }

        //reset labels
        for(int i=0;i<labels.size();i++)
        {
            labels.get(i).setText("");
        }

        //cargo could have been sorted alphabetically
        for(int i=0;i<player.cargo.size();i++)
        {
            labels.get(i).setText(player.cargo.get(i));
        }
    }
}

