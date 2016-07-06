package com.tusharjoshi.puzzlers.rotation;

import java.util.Arrays;

/**
 *
 * @author Tushar Joshi
 */
public class RotationBuffer {
    
    private final char[] buffer;
    private int start;
    private int length;
    private int rotationSize;

    public RotationBuffer(char[] source) {
        this.buffer = Arrays.copyOf(source, source.length);        
    }

    public void rotate(int k) {
        
        initializeRotationValues(k);
        performRotationSwaps();
    }

    private void performRotationSwaps() {
        while( isForwardRotationNeeded() ) {
            doForwardSwaps();
            doBackwardSwapsIfNeeded();
        }
    }

    private void initializeRotationValues(int k) {
        rotationSize = k;
        start = 0;
        length = buffer.length;
    }

    private boolean isForwardRotationNeeded() {
        return (rotationSize > 0) && (rotationSize < length) && (length - start - rotationSize  > 0);
    }

    private void doForwardSwaps() {
        while (isForwardSwapPossible()) {
            swaptext(start, rotationSize);
            start = start + rotationSize;
        }
    }

    private void doBackwardSwapsIfNeeded() {
        if( isBackwardRotationNeeded()) {
            calculateBackwardRotationSize();
            doBackwardSwaps();
            calculateForwardRotationSize();
        }
    }

    private boolean isBackwardRotationNeeded() {
        return (length != start + rotationSize) && (length - start - rotationSize < rotationSize);
    }

    private void calculateBackwardRotationSize() {
        rotationSize = length - start -rotationSize;
    }

    private void doBackwardSwaps() {
        while( isBackwardSwapPossible()) {
            swaptext(length - 2*rotationSize, rotationSize);
            length = length - rotationSize;
        }
    }

    private void calculateForwardRotationSize() {
        rotationSize = length - rotationSize;
    }

    private boolean isForwardSwapPossible() {
        return length - start - rotationSize >= rotationSize;
    }

    private boolean isBackwardSwapPossible() {
        return start <= length - 2 * rotationSize;
    }

    private void swaptext(int start, int k) {
        for (int index = start; index < start + k; index++) {
            swapchar(index, k);
        }
    }

    private void swapchar(int index, int k) {
        char ch = buffer[index];
        buffer[index] = buffer[index + k];
        buffer[index + k] = ch;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for( char ch : buffer ) {
            builder.append(ch);
        }
        return builder.toString(); 
    }
    
}
