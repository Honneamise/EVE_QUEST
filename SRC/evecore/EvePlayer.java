package evecore;

import java.awt.event.*;
import java.beans.*;
import java.util.*;

public class EvePlayer implements ActionListener
{
    int seed;

    PropertyChangeSupport pcs;

    public javax.swing.Timer timer;    

    //info
    public String name;
    public String race;
	public String corporation;
    public String ship;

    //stats
    public int charisma;
    public int intelligence;
    public int memory;
    public int perception;
    public int willpower;

    //skills
    public ArrayList<String> skills;

    //data
    public int missions;
    public int skillpoints;
    public long isk;

    //expansion
    public int expansion;//index

    //cargo
    public ArrayList<String> cargo;

    //mission
    boolean std_mission;//if strue is standard mission, else sell

    public String mission_agent;
    public String mission_desc;
    public String mission_target;
    public String mission_region;
    public String mission_system;
    public String mission_security;
    public int mission_progress;

    public EvePlayer()
    {
        pcs = new PropertyChangeSupport(this);

        timer = new javax.swing.Timer(100,this);

        seed = (int)System.currentTimeMillis();

        //data
        missions = 10;
        skillpoints = 50000;
        isk = 1000000;

        //expansion
        expansion = 0;

        //cargo
        cargo =  new ArrayList<String>();

        //mission
        std_mission = true;

        mission_agent = "";
        mission_desc = "";
        mission_target = "";
        mission_region = "";
        mission_system = "";
        mission_security = "";
        mission_progress = 0;
    }

    

    /**********/
    public void addPropertyChangeListener(PropertyChangeListener pcl) 
    {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) 
    {
        pcs.removePropertyChangeListener(pcl);
    }

    /**********/
    public void randomize()
    {
        

        seed++;

		EveDb.setSeed(seed);

        //info
        name = EveDb.getRandomName();
        race = EveDb.getRandomRace();
	    corporation = EveDb.getRandomCorporation();
        ship = EveDb.getRandomShip();

        //stats
        charisma = EveDb.getRandomInt(5, 10);
        intelligence = EveDb.getRandomInt(5, 10);
        memory = EveDb.getRandomInt(5, 10);
        perception = EveDb.getRandomInt(5, 10);
        willpower = EveDb.getRandomInt(5, 10);

        //skills
        skills = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            skills.add( EveDb.getRandomSkill() );
        }

        Collections.sort(skills);

    }

    public void generateMission()
    {
        String[] tokens = {};

        mission_agent = EveDb.getRandomAgent();

        String mission = EveDb.getRandomMission();
        tokens = mission.split("-");

        mission_desc = "\""+tokens[0]+"\"";
        mission_target = tokens[1];

        String location = EveDb.getRandomLocation();
        tokens = location.split(":");

        mission_region = tokens[0];
        mission_system = tokens[1];
        mission_security = tokens[2];
        
        mission_progress = 0;
    }

    public void generateSellMission()
    {
        mission_agent = "CCP";

        mission_desc = "\"Selling trash in Jita\"";
        mission_target = "Scammers";

        mission_region = "The Forge";
        mission_system = "Jita";
        mission_security = "1.0";
        
        mission_progress = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(mission_progress<100) 
        { 
            mission_progress++; 
            pcs.firePropertyChange("mission_progress", null, mission_progress);
            return;
        }
        
        //do calculations and updates here
        timer.stop();

        //miss
        if(std_mission)
        {
            missions--;
            if(missions<=0)
            {
                expansion++;

                if(expansion>=10)
                { 
                    pcs.firePropertyChange("game_completed", null, null);
                    return;
                }
                missions = (expansion+1) * 10;
            }

            //skillpoints
            skillpoints += EveDb.getRandomInt(1, 10) * 50;//add between 50 and 500 sp
            if(skillpoints/5000>skills.size())//every 5k sp add a skill
            {
                //add random skill not in list
                String skill = "";
                do
                {
                    skill = EveDb.getRandomSkill();
                } while (skills.contains(skill));

                skills.add(skill);

                Collections.sort(skills);
            }
        }

        //cargo
        if(std_mission)//we come from standard mission
        {
            cargo.add(EveDb.getRandomLoot());
            Collections.sort(cargo);

            if(cargo.size()<15)//change this to 15 or 20
            {
                timer.setDelay(100);
                generateMission();
            }
            else
            {
                std_mission = false;
                timer.setDelay(10);
                generateSellMission();
            }
        }
        else//we come from sell mission
        {
            cargo.remove(0);

            isk += EveDb.getRandomInt(1, 10) * 1000;//add between 1k and 10k isks

            if(cargo.size()>0)
            {    
                timer.setDelay(10);
                generateSellMission();
            }
            else
            {
                std_mission = true;
                timer.setDelay(100);
                generateMission();
            }
        }

        pcs.firePropertyChange("mission_completed", null, null);

        timer.restart();
    }

}
