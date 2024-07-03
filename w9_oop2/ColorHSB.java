/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Objects;
import java.util.function.Predicate;

public class ColorHSB {

    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        validateColorComponents(h, s, b);
        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        validate(that, Objects::nonNull, "Color must be provided to calculate distance.");
        int dh1 = this.hue - that.hue;
        int dh2 = 360 - Math.abs(dh1);
        int ds = this.saturation - that.saturation;
        int db = this.brightness - that.brightness;
        return Math.min(dh1 * dh1, dh2 * dh2) + ds * ds + db * db;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return String.format("(%d, %d, %d)", hue, saturation, brightness);
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    private static void validateColorComponents(int h, int s, int b) {
        validate(h, v -> v >= 0 && v <= 359, "Hue must be between 0 and 359");
        validate(s, v -> v >= 0 && v <= 100, "Saturation must be between 0 and 100");
        validate(b, v -> v >= 0 && v <= 100, "Brightness must be between 0 and 100");
    }

    private static <T> void validate(T value, Predicate<T> condition, String errorMessage) {
        if (!condition.test(value)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void main(String[] args) {
        int h0 = Integer.parseInt(args[0]);
        int s0 = Integer.parseInt(args[1]);
        int b0 = Integer.parseInt(args[2]);

        ColorHSB color0 = new ColorHSB(h0, s0, b0);
        ColorHSB closestColor = color0;
        String closestName = "";
        int closetDistance = Integer.MAX_VALUE;

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB color = new ColorHSB(h, s, b);

            int distance = color0.distanceSquaredTo(color);
            if (distance < closetDistance) {
                closetDistance = distance;
                closestColor = color;
                closestName = name;
            }
        }
        StdOut.println(closestName + " " + closestColor);
    }
}
