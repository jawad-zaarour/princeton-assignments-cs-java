/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


public class Huntingtons {

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s", "");
    }

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int n = dna.length();
        if (n < 3) return 0;
        int i = 0, max = 0, count = 0;

        while (i < n - 3) {
            String gene = dna.substring(i, i + 3);
            if (gene.equals("CAG")) {
                i += 3;
                max = Math.max(++count, max);
            }
            else {
                i++;
                count = 0;
            }
        }

        return max;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10 || maxRepeats > 180) return "not human";
        else if (maxRepeats < 36) return "normal";
        else if (maxRepeats < 40) return "high risk";
        else return "Huntington's";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String dna = removeWhitespace(new In(args[0]).readAll());
        int repeats = maxRepeats(dna);
        StdOut.println("max repeats = " + repeats);
        StdOut.println(diagnose(repeats));
    }
}

