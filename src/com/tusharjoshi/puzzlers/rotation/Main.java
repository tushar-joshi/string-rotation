package com.tusharjoshi.puzzlers.rotation;

/**
 *
 * @author Tushar Joshi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        char[] text = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};

        for (int index = 0; index < text.length + 1; index++) {
            RotationBuffer buffer = new RotationBuffer(text);
            String original = buffer.toString();
            buffer.rotate(index);
            System.out.println(
                    String.format(
                            "Original: %s, k: %2d, Rotated: %s", 
                            original, 
                            index, 
                            buffer.toString()
                    )
            );
        }
    }

}
