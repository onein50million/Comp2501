package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.printer;

public class InkColor {
    public enum Color {
        YELLOW,
        BLACK,
        MAGENTA,
        CYAN
    }

    private final Color color;

    public InkColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InkColor)) {
            return false;
        }
        return ((InkColor) obj).color == this.color;
    }

    @Override
    public String toString() {
        return "InkColor{" +
                "color=" + color +
                '}';
    }
}
