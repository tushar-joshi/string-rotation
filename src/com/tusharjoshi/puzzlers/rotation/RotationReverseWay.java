package com.tusharjoshi.puzzlers.rotation;

import java.util.Arrays;

/**
 *
 * @author Tushar Joshi
 */
public class RotationReverseWay {

    public static void main(String[] args) {

        char[] text = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};

        for (int index = 1; index < text.length ; index++) {
            String original = makeString(text);
            String rotated = rotate(text, index);
            System.out.println(
                    String.format(
                            "Original: %s, k: %2d, Rotated: %s", 
                            original, 
                            index, 
                            rotated)
            );
        }
    }

    public static String rotate(char[] source, int k) {
        char[] buffer = Arrays.copyOf(source, source.length);
        int rotationSize = k;
        int length = buffer.length;
        
        reverseArray(buffer, 0, length -1);
        reverseArray(buffer, 0, length - rotationSize-1);
        reverseArray(buffer, length - rotationSize, length -1);

        return makeString(buffer);
    }

    private static String makeString(char[] buffer) {
        StringBuilder builder = new StringBuilder();
        for (char ch : buffer) {
            builder.append(ch);
        }
        return builder.toString();
    }

    private static void reverseArray(char[] buffer, int start, int end) {
        int halfDist = start + (end - start)/2;
        
        for( int index = start; index <= halfDist; index++ ) {
            int a = index;
            int b = start + end - index;
            char ch = buffer[a];
            buffer[a] = buffer[b];
            buffer[b] = ch;
        }
    }

}
