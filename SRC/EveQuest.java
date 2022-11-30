import evecore.*;
import evescene.*;

public class EveQuest
{
    public static void main(String args[])
    {
        EveGame.init();

        EveGame.setScene(new EveLoadScene());

        EveDb.init();

        EveGame.setScene(new EveIntroScene());
    }
}