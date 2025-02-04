package overblocks.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;
import overblocks.graphics.*;

public class OBItems {
    public static Item rosingAlloy, diseaseVector;

    public static void load(){
        rosingAlloy = new Item("rosing-alloy", Color.valueOf("AF6356")){{
            cost = 1.2f;
            hiddenOnPlanets = new Planet[]{Planets.erekir};
        }};

        diseaseVector = new Item("disease-vector", OBPal.dreadRust){{
            hiddenOnPlanets = new Planet[]{Planets.erekir};
        }};
    }
}
