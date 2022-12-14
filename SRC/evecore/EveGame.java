package evecore;

import java.awt.*;
import javax.swing.*;
import java.awt.Font;

public class EveGame
{
    public static String[] frame_styles = {
        "com.formdev.flatlaf.intellijthemes.FlatArcIJTheme",
        //"com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatGradiantoDarkFuchsiaIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme",
        //"com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkMediumIJTheme",
        //"com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkSoftIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatNordIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatSpacegrayIJTheme",
        //"com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme",
        "com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme",

        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkContrastIJTheme",
        //"com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme",
        "com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightContrastIJTheme"
        };

    private static int style_index;

    private static EveFrame frame;

    private static EvePlayer player;
    
    public static void init()
    {
        style_index = 2;

        frame = new EveFrame();
        
        changeStyle();

        player = new EvePlayer();
    }

    public static void setScene(JPanel pnl)
    {
        frame.remove(frame.panel);

        frame.add( frame.panel = pnl, BorderLayout.CENTER );

        frame.revalidate();

        frame.pack();
        
    }

    public static EvePlayer getPlayer()
    {
        return player;
    }

    public static void changeStyle()
    {
        try
        {
            UIManager.setLookAndFeel(frame_styles[style_index]);
            
            Font f = (Font)UIManager.getLookAndFeelDefaults().get("defaultFont");
        
            f = f.deriveFont(14.0f);

            UIManager.getLookAndFeelDefaults().put("defaultFont", f);

            SwingUtilities.updateComponentTreeUI(frame);

            frame.pack();
            
        }catch(Exception ex){ ex.printStackTrace(); }

        style_index++;

        if (style_index>=frame_styles.length){ style_index=0; }

    }

    
}
