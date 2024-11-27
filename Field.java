import java.util.ArrayList;
import java.util.List;

public class Field {
    private Object[][] field;

    public Field(int rows, int cols) {
        field = new Object[rows][cols];
    }

    public int getRows() {
        return field.length;
    }

    public int getCols() {
        return field[0].length;
    }

    public void place(Object obj, Location location) {
        field[location.getRow()][location.getCol()] = obj;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        int row = location.getRow();
        int col = location.getCol();

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < getRows() && c >= 0 && c < getCols() &&
                    (r != row || c != col)) {
                    locations.add(new Location(r, c));
                }
            }
        }
        return locations;
    }

    public Location freeAdjacentLocation(Location location) {
        for (Location adjacent : adjacentLocations(location)) {
            if (getObjectAt(adjacent) == null) {
                return adjacent;
            }
        }
        return null;
    }
}
