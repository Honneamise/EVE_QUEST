package evepanel;

import evecore.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class EveSkillsPanel extends JPanel
{
    ArrayList<JLabel> labels;
    JPanel panel;
    JScrollPane pane;

    public EveSkillsPanel(EvePlayer player)
    {
        super();
        setBorder(new TitledBorder("Skills"));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(320,240));


        labels = new ArrayList<JLabel>();
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        /*for(int i=0;i<10;i++)//prepare 10 empty labels
        {
            labels.add(new JLabel(""));
            panel.add(labels.get(i));
        }*/

        pane = new JScrollPane(panel);
        pane.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
        
        add(pane,BorderLayout.CENTER);
       
        updateData(player);

    }

    public void updateData(EvePlayer player)
    {        
        //add new skills if any
        //IMPORTANT : preserve panel size !!!
        if(labels.size()<player.skills.size())
        {
            //Dimension d = pane.getSize();

            for(int i=labels.size();i<labels.size() + (player.skills.size()-labels.size()); i++)
            {
                labels.add(new JLabel(""));
                panel.add(labels.get(i));
            }

            //pane.setPreferredSize(d);
        }

        for(int i=0;i<player.skills.size();i++)
        {
            labels.get(i).setText(player.skills.get(i));
        }
    }
}

