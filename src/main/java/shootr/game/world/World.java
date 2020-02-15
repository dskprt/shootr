package shootr.game.world;

import shootr.game.entity.Entity;

import java.util.*;

public class World {

    public List<Map<Integer, Entity>> entities;

    public World() {
        this.entities = new ArrayList<>();
    }

    public void addEntity(int id, Entity entity) {
        this.entities.add(Collections.singletonMap(id, entity));
    }
}
