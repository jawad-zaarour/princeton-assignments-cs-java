/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        System.out.println(
                (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) ||
                        (Math.pow(a, 2) == Math.pow(c, 2) + Math.pow(b, 2)) ||
                        (Math.pow(b, 2) == Math.pow(c, 2) + Math.pow(a, 2))
        );
    }
}
