package com.tusharjoshi.puzzlers.rotation;

import java.util.Arrays;

/**
 *
 * @author Tushar Joshi
 */
public class RotationShortVersion {

    public static void main(String[] args) {

        char[] text = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};

        for (int index = 0; index < text.length + 1; index++) {
            String original = makeString(text);
            String rotated = rotate(text, index);
            System.out.println(String.format("Original: %s, k: %2d, Rotated: %s", original, index, rotated));
        }
    }

    public static String rotate(char[] source, int k) {
        char[] buffer = Arrays.copyOf(source, source.length);
        int rotationSize = k;
        int start = 0;
        int length = buffer.length;

        while ((rotationSize > 0) && (rotationSize < length) && (length - start - rotationSize > 0)) {
            while (length - start - rotationSize >= rotationSize) {
                swaptext(buffer, start, rotationSize);
                start = start + rotationSize;
            }
            if ((length != start + rotationSize) && (length - start - rotationSize < rotationSize)) {
                rotationSize = length - start - rotationSize;
                while (start <= length - 2 * rotationSize) {
                    swaptext(buffer, length - 2 * rotationSize, rotationSize);
                    length = length - rotationSize;
                }
                rotationSize = length - rotationSize;
            }
        }

        return makeString(buffer);
    }

    private static void swaptext(char[] buffer, int start, int k) {
        for (int index = start; index < start + k; index++) {
            char ch = buffer[index];
            buffer[index] = buffer[index + k];
            buffer[index + k] = ch;
        }
    }

    private static String makeString(char[] buffer) {
        StringBuilder builder = new StringBuilder();
        for (char ch : buffer) {
            builder.append(ch);
        }
        return builder.toString();
    }

}
