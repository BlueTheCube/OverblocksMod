package overblocks.type;

import arc.util.*;
import mindustry.content.*;
import mindustry.gen.*;
import mindustry.type.*;

public class OBUnitType extends UnitType{

    public @Nullable StatusEffect alwaysStatus;

    public float dodge = 0f;

    public OBUnitType(String name){
        super(name);
    }

    @Override
    public void update(Unit unit){
        if(alwaysStatus != null) unit.apply(alwaysStatus);
    }
}
