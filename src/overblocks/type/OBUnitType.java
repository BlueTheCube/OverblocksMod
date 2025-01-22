package overblocks.type;

import arc.math.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.type.*;
import overblocks.world.meta.*;
import overblocks.gen.*;

public class OBUnitType extends UnitType {

    public @Nullable StatusEffect alwaysStatus;

    public float dodge = 0f;

    @SuppressWarnings("unchecked")
    public <T extends Unit> OBUnitType(String name, Class<T> type) {
        super(name);
        constructor = EntityRegistry.content(name, type, n -> EntityMapping.map(this.name));
        if (constructor == null) throw new IllegalArgumentException("Unit entity class `" + type + "` not registered.");
    }


    @Override
    public void setStats() {
        super.setStats();
        if (dodge > 0){
            stats.add(OBStats.dodge, Mathf.round(dodge * 100) + "%");
        }
    }

    @Override
    public void update(Unit unit) {
        if(alwaysStatus != null) unit.apply(alwaysStatus);
    }
}
