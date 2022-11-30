package evecore;

import java.io.*;
import java.util.*;
import javax.json.*;

public class EveDb 
{
    public static Random rand;
    
    public static JsonArray agents;
    public static JsonArray corporations;
    public static JsonArray expansions;
    public static JsonArray locations;
    public static JsonArray loots;
    public static JsonArray missions;
    public static JsonArray races;
    public static JsonArray ships;
    public static JsonArray skills;

    public static JsonArray male_names;
    public static JsonArray female_names;
    public static JsonArray last_names;


    public static JsonArray loadResource(String file)
    {
        JsonArray array = null;

        try
        {
            InputStream is = new FileInputStream(file);
            
            JsonReader reader = Json.createReader(is);

            array = reader.readArray();

            reader.close();

            is.close();

        } catch (Exception e) { e.printStackTrace(); } 

        return array;

    }

    public static void init()
    {
        rand = new Random(0);

        agents          = loadResource("RES/DB/agents.json");
        corporations    = loadResource("RES/DB/corporations.json");
        expansions      = loadResource("RES/DB/expansions.json");
        locations       = loadResource("RES/DB/locations.json");
        loots           = loadResource("RES/DB/loots.json");
        missions        = loadResource("RES/DB/missions.json");
        races           = loadResource("RES/DB/races.json");
        ships           = loadResource("RES/DB/ships.json");
        skills          = loadResource("RES/DB/skills.json");

        male_names      = loadResource("RES/DB/male_names.json");
        female_names    = loadResource("RES/DB/female_names.json");
        last_names      = loadResource("RES/DB/last_names.json");
    
    }

	public static void setSeed(int seed)
    {
		rand.setSeed(seed);
	}
	
    public static int getRandomInt(int min, int max)
    {
        return rand.nextInt(max+1 - min) + min;
    } 

	public static String getRandomAgent()
    {
        return agents.getString( rand.nextInt(agents.size()) );
    } 

	public static String getRandomCorporation()
    {
        return corporations.getString( rand.nextInt(corporations.size()) );
    } 

    public static String getRandomLocation()
    {
        return locations.getString( rand.nextInt(locations.size()) );
    } 

    public static String getRandomLoot()
    {
        return loots.getString( rand.nextInt(loots.size()) );
    } 

	public static String getRandomMission()
    {
        return missions.getString( rand.nextInt(missions.size()) );
    } 

	public static String getRandomRace()
    {
        return races.getString( rand.nextInt(races.size()) );
    } 

    public static String getRandomShip()
    {
        return ships.getString( rand.nextInt(ships.size()) );
    } 

	public static String getRandomSkill()
    {
        return skills.getString( rand.nextInt(skills.size()) );
    } 

    public static String getRandomMaleName()
    {
        return male_names.getString( rand.nextInt(male_names.size()) );
    } 

    public static String getRandomFemaleName()
    {
        return female_names.getString( rand.nextInt(female_names.size()) );
    } 

    public static String getRandomLastName()
    {
        return last_names.getString( rand.nextInt(last_names.size()) );
    } 

    public static String getRandomName()
    {
        int sex = rand.nextInt() & 1;

        if(sex==0)
        {
            return getRandomMaleName() + " " + getRandomLastName();
        }
        
        return getRandomFemaleName() + " " + getRandomLastName();
    } 
}
