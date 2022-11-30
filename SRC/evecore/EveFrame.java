package evecore;

import java.awt.*;
import javax.swing.*;

public class EveFrame extends JFrame
{
    JPanel panel;

    EveFrame()
    {
        super();

        setTitle("Eve Quest");
        
        setPreferredSize(new Dimension(1280,720));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout()); 
    
        add( panel = new JPanel(), BorderLayout.CENTER);
    
        pack();

        setResizable(false);

        setLocationRelativeTo(null);
        
        setVisible(true);

    }
    
}
