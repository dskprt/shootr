package shootr.game.world;

import shootr.game.entity.Entity;

import java.util.*;

public class World {

    public List<Map<Integer, Entity>> entities;
    private List<Map<Integer, Entity>> toAdd;

    public World() {
        this.entities = new ArrayList<>();
        this.toAdd = new ArrayList<>();
    }

    public void addEntity(int id, Entity entity) {
        this.toAdd.add(Collections.singletonMap(id, entity));
    }

    public void addEntity(Entity entity) {
        this.toAdd.add(Collections.singletonMap(entities.size(), entity));
    }

    public void addAll() {
        this.entities.addAll(this.toAdd);
        this.toAdd.clear();
    }
}
