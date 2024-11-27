public class Simulator {
    private Field field;
    private SimulatorView view;

    public Simulator(int rows, int cols) {
        field = new Field(rows, cols);
        view = new SimulatorView();
        populateField();
    }

    public void simulate(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("Step: " + (i + 1));
            Field updatedField = new Field(field.getRows(), field.getCols());
            for (int row = 0; row < field.getRows(); row++) {
                for (int col = 0; col < field.getCols(); col++) {
                    Location location = new Location(row, col);
                    Object obj = field.getObjectAt(location);
                    if (obj instanceof Animal) {
                        Animal animal = (Animal) obj;
                        animal.act(field, updatedField);
                    }
                }
            }
            field = updatedField;
            view.showStatus(field);
        }
    }

    private void populateField() {
        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getCols(); col++) {
                double random = Math.random();
                Location loc = new Location(row, col);
                if (random < 0.2) {
                    field.place(new Fox(loc), loc);
                } else if (random < 0.4) {
                    field.place(new Rabbit(loc), loc);
                }
            }
        }
    }
}
