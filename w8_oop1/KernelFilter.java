/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    private static final double[][] IDENTITY_KERNEL = {
            { 0, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 0 }
    };

    private static final double[][] GAUSSIAN_KERNEL = {
            { 1 / 16.0, 2 / 16.0, 1 / 16.0 },
            { 2 / 16.0, 4 / 16.0, 2 / 16.0 },
            { 1 / 16.0, 2 / 16.0, 1 / 16.0 }
    };

    private static final double[][] SHARPEN_KERNEL = {
            { 0, -1, 0 },
            { -1, 5, -1 },
            { 0, -1, 0 }
    };

    private static final double[][] LAPLACIAN_KERNEL = {
            { -1, -1, -1 },
            { -1, +8, -1 },
            { -1, -1, -1 }
    };

    private static final double[][] EMBOSS_KERNEL = {
            { -2, -1, 0 },
            { -1, 1, 1 },
            { 0, 1, 2 }
    };

    private static final double[][] MOTION_BLUR_KERNEL = {
            { 1 / 9.0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1 / 9.0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 1 / 9.0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1 / 9.0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1 / 9.0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1 / 9.0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 1 / 9.0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1 / 9.0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 1 / 9.0 }
    };

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return conv(picture, IDENTITY_KERNEL);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        return conv(picture, GAUSSIAN_KERNEL);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        return conv(picture, SHARPEN_KERNEL);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        return conv(picture, LAPLACIAN_KERNEL);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        return conv(picture, EMBOSS_KERNEL);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        return conv(picture, MOTION_BLUR_KERNEL);
    }

    private static Picture conv(Picture picture, double[][] kernel) {
        int width = picture.width();
        int height = picture.height();
        Picture result = new Picture(width, height);
        int offset = kernel.length / 2;

        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                double[] rgb = { 0, 0, 0 };

                for (int i = -offset; i <= offset; i++) {
                    for (int j = -offset; j <= offset; j++) {
                        int x = (row + i + width) % width;
                        int y = (col + j + height) % height;

                        Color color = picture.get(x, y);

                        rgb[0] += kernel[i + offset][j + offset] * color.getRed();
                        rgb[1] += kernel[i + offset][j + offset] * color.getGreen();
                        rgb[2] += kernel[i + offset][j + offset] * color.getBlue();
                    }
                }

                int r = (int) Math.round(Math.min(Math.max(rgb[0], 0), 255));
                int g = (int) Math.round(Math.min(Math.max(rgb[1], 0), 255));
                int b = (int) Math.round(Math.min(Math.max(rgb[2], 0), 255));

                result.set(row, col, new Color(r, g, b));
            }
        }

        return result;
    }

    // Test client
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        Picture identityPicture = identity(picture);
        Picture gaussianPicture = gaussian(picture);
        Picture sharpenPicture = sharpen(picture);
        Picture laplacianPicture = laplacian(picture);
        Picture embossPicture = emboss(picture);
        Picture motionBlurPicture = motionBlur(picture);

        picture.show();
        identityPicture.show();
        gaussianPicture.show();
        sharpenPicture.show();
        laplacianPicture.show();
        embossPicture.show();
        motionBlurPicture.show();
    }
}
