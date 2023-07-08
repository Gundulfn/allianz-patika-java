package filmmanagement;

public class Category {
    private String name;
    private int filmCount;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseFilmCount() {
        this.filmCount++;
    }

    public int getFilmCount() {
        return filmCount;
    }

    @Override
    public String toString() {
        return getName();
    }
}