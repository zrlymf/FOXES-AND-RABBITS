public class SimulatorView {
    public void showStatus(Field field) {
        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getCols(); col++) {
                Object obj = field.getObjectAt(new Location(row, col));
                if (obj instanceof Fox) {
                    System.out.print("F ");
                } else if (obj instanceof Rabbit) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
