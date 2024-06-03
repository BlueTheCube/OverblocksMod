package overblocks.world.blocks;

import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.world.blocks.defense.*;

public class ReflectionWall extends Wall{
    public float damageMultiplier = 6f / 4;
    public ReflectionWall(String name){
        super(name);
    }

    @Override
    public void setStats(){
        //TODO stats?
        super.setStats();
    }

    public class ReflectionWallBuild extends WallBuild{
        @Override
        public boolean collision(Bullet bullet){
            if(damageMultiplier > 0f && bullet.owner instanceof Healthc hp){
                hp.damage(bullet.damage * damageMultiplier);
            }
            return super.collision(bullet);
        }
    }
}
