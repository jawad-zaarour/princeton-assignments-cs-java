/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = alpha * a[i];
        }
        return result;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = a.length - 1, j = 0; i >= 0; i--, j++) {
            result[j] = a[i];
        }
        return result;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[i] = b[i];
        }
        return result;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int maxLength = Math.max(a.length, b.length);
        double[] result = new double[maxLength];
        for (int i = 0; i < maxLength; i++) {
            if (i < a.length) result[i] += a[i];
            if (i < b.length) result[i] += b[i];
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) (a.length / alpha);
        double[] result = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            result[i] = a[(int) (i * alpha)];
        }
        return result;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        // Load audio samples from files
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] piano = StdAudio.read("piano.wav");

        // Apply audio effects
        double[] amplifiedBeatbox = amplify(beatbox, 1.5);
        double[] reversedBuzzer = reverse(buzzer);
        double[] mergedChimesCow = merge(chimes, cow);
        double[] speedChangedPiano = changeSpeed(piano, 1.5);
        double[] mixedPianoBeatbox = mix(piano, beatbox);

        StdAudio.play(mixedPianoBeatbox);

        // Create audio collage
        double[] collage = merge(
                mergedChimesCow,
                mix(
                        amplifiedBeatbox,
                        merge(reversedBuzzer, speedChangedPiano)
                )
        );

        // Play the audio collage
        StdAudio.play(collage);
    }
}