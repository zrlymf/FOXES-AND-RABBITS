public abstract class Animal {
    protected Location location;

    public Animal(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public abstract void act(Field field, Field updatedField);
}
