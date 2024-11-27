public class Rabbit extends Animal {
    public Rabbit(Location location) {
        super(location);
    }

    @Override
    public void act(Field field, Field updatedField) {
        Location newLocation = field.freeAdjacentLocation(location);
        if (newLocation != null) {
            updatedField.place(this, newLocation);
        }
    }
}
