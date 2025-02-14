package overblocks.content;

import arc.graphics.*;
import arc.math.*;
import mindustry.content.*;
import mindustry.type.*;
import overblocks.graphics.*;
import overblocks.type.*;

public class OBStatusEffects{

    public static StatusEffect dreadRust;

    public static void load(){

        dreadRust = new OBStatusEffect("dread-rust"){{
            color = OBPal.dreadRust;
            hideDetails = false;
            damagePercentage = 0.04f;
            healthMultiplier = 0.85f;
            reloadMultiplier = 0.85f;
            speedMultiplier = 0.75f;

            effect = OBFx.dreadRusting;
            transitionDamage = 8f;
        }};
    }
}
