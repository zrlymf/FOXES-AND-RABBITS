public class Fox extends Animal {
    public Fox(Location location) {
        super(location);
    }

    @Override
    public void act(Field field, Field updatedField) {
        // Cari kelinci di sekitar
        Location newLocation = huntRabbit(field, updatedField);
        if (newLocation != null) {
            updatedField.place(this, newLocation);
        }
    }

    private Location huntRabbit(Field field, Field updatedField) {
        for (Location loc : field.adjacentLocations(location)) {
            Object obj = field.getObjectAt(loc);
            if (obj instanceof Rabbit) {
                return loc; // Temukan kelinci, pindah ke lokasinya
            }
        }
        return field.freeAdjacentLocation(location); // Pindah ke lokasi bebas
    }
}
