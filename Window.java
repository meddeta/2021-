/**********************************************************
 * EECS2101A: Fundamentals of Data Structures,  Fall 2023 
 * Assignment 1, Problem 3: Window.java
 * Student Name:   Melika Sherafat
 * Student EECS account:  meddeta
 * Student ID number:  218970871
 **********************************************************/



package A1;
/**
 * The {@code Window} class represents rectangular windows in a 2D space. It allows
 * for the creation of windows with specified coordinates and provides methods
 * to check for overlaps and enclosures between windows.
 *
 * @author Melika Sherafat
 * @version 1.0
 */

public class Window {
    protected double left, right, bottom, top;
    
    /**
     * Constructs a new window with the specified coordinates. The coordinates
     * must form a valid window, i.e., left < right and bottom < top.
     *
     * @param l The x-coordinate of the left edge.
     * @param r The x-coordinate of the right edge.
     * @param b The y-coordinate of the bottom edge.
     * @param t The y-coordinate of the top edge.
     * @throws InvalidWindowException If the provided coordinates do not form a
     *                                valid window.
     */

    public Window(double l, double r, double b, double t) throws InvalidWindowException {
        if (l >= r || b >= t) {
            throw new InvalidWindowException("Invalid window parameters");
        }
        left = l;
        right = r;
        bottom = b;
        top = t;
    }
    /**
     * Gets the x-coordinate of the left edge of the window.
     *
     * @return The x-coordinate of the left edge.
     */

    public double getLeft() {
        return left;
    }
    /**
     * Sets the x-coordinate of the left edge of the window. The new left value
     * must be less than the current right value.
     *
     * @param l The new x-coordinate of the left edge.
     * @throws InvalidWindowException If the new left value is greater than or
     *                                equal to the current right value.
     */
    public void setLeft(double l) throws InvalidWindowException {
        if (l >= right) {
            throw new InvalidWindowException("Invalid left value");
        }
        left = l;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double r) throws InvalidWindowException {
        if (r <= left) {
            throw new InvalidWindowException("Invalid right value");
        }
        right = r;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double b) throws InvalidWindowException {
        if (b >= top) {
            throw new InvalidWindowException("Invalid bottom value");
        }
        bottom = b;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double t) throws InvalidWindowException {
        if (t <= bottom) {
            throw new InvalidWindowException("Invalid top value");
        }
        top = t;
    }
    /**
     * Checks if the current window encloses another window {@code w}.
     *
     * @param w The window to check for enclosure.
     * @return {@code true} if the current window encloses {@code w}, {@code false}
     *         otherwise.
     */
    public boolean encloses(Window w) {
        return left <= w.left && right >= w.right && bottom <= w.bottom && top >= w.top;
    }
    /**
     * Checks if the current window overlaps with another window {@code w}.
     *
     * @param w The window to check for overlap.
     * @return {@code true} if the current window overlaps with {@code w},
     *         {@code false} otherwise.
     */
    public boolean overlaps(Window w) {
        return !(left >= w.right || right <= w.left || bottom >= w.top || top <= w.bottom);
    }
    /**
     * Calculates the number of overlapping pairs among an array of windows.
     *
     * @param windows An array of windows to check for overlaps.
     * @return The count of overlapping pairs.
     */
    public static int overlapCount(Window[] windows) {
        int count = 0;
        int n = windows.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (windows[i].overlaps(windows[j])) {
                    count++;
                }
            }
        }

        return count;
    }
    /**
     * Calculates the number of windows in an array that enclose other windows.
     *
     * @param windows An array of windows to check for enclosures.
     * @return The count of windows that enclose others.
     */
    public static int enclosureCount(Window[] windows) {
        int count = 0;
        int n = windows.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && windows[i].encloses(windows[j])) {
                    count++;
                }
            }
        }

        return count;
    }
    /**
     * The main method demonstrates the usage of the {@code Window} class by
     * creating windows and calculating overlap and enclosure counts.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {

        try {
            Window w1 = new Window(0, 5, 0, 5);
            Window w2 = new Window(1, 4, 1, 4);
            Window w3 = new Window(6, 7, 6, 7);
            Window w4 = new Window(3, 6, 3, 6);
            Window w5 = new Window(0, 2, 0, 2);

            System.out.println("Overlap Count: " + overlapCount(new Window[]{w1, w2, w3, w4, w5}));
            System.out.println("Enclosure Count: " + enclosureCount(new Window[]{w1, w2, w3, w4, w5}));
        } catch (InvalidWindowException e) {
            e.printStackTrace();
        }
    }
}

class InvalidWindowException extends Exception {
    public InvalidWindowException(String message) {
        super(message);
    }
}
