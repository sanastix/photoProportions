package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));

        int a = in.nextInt();
        int b = in.nextInt();

        int m = in.nextInt();
        int n = in.nextInt();

        in.close();

        PrintWriter out = new PrintWriter("output.txt");
        String result = photoInFrame(a, b, m, n);
        out.print(result);

        out.close();

    }

    public static String photoInFrame(int a, int b, int m, int n) {
        double aspectRatioPhoto = (double) a / b;
        double aspectRatioFrame = (double) m / n;

        double maxWidth = Math.min(m, n * aspectRatioPhoto);
        double maxHeight = Math.min(n, m / aspectRatioPhoto);

        if (aspectRatioPhoto < aspectRatioFrame) {
            return String.format("%.3f %.3f", maxWidth, maxWidth / aspectRatioPhoto);
        } else {
            return String.format("%.3f %.3f", maxHeight * aspectRatioPhoto, maxHeight);
        }
    }
}