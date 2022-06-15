package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.port.DataPort;

/**
 * Laptop.java COMP 2501 - CRN: 67139 Wednesday evenings, Spring/Summer 2022 Lab #9
 *
 * <p>Exploring Inheritance by developing a data class hierarchy.
 *
 * @author Monika Szucs
 * @author Daniel Wart
 * @version 1.2
 *     <p>This Laptop Class that will create the appropriate constructor and methods
 */
public class Laptop extends Electronic {
    private final double displaySizeInches;
    private final boolean touchPad;
    private final boolean wirelessMouse;
    private boolean batteryCharged;

    private final char[] memory = new char[MEMORY_SIZE];
    private String readOnlyMemory = "";

    private char[] keyboardBuffer;
    private int keyboardPointer = 0;

    private int dataPointer;
    private int instructionPointer;

    private static final int IMPOSSIBLE_SCREEN_SIZE = 0;
    private static final int CHEAP_LAPTOP = 1000;
    private static final int EXPENSIVE_LAPTOP = 4000;
    private static final int SMALL_TO_MEDIUM_DISPLAY_SIZE = 10;
    private static final int MEDIUM_TO_LARGE_DISPLAY_SIZE = 18;
    private static final int MEMORY_SIZE = 32;

    /**
     * This is the constructor for the Laptop Class
     *
     * @param brand this is the brand of the laptop
     * @param model this is the model of the laptop
     * @param priceCdn this is the price of the laptop
     * @param displaySizeInches this is the display size of the laptop in inches
     * @param powerCableAttached this is to see if the power cable is directly attached or not
     * @param touchPad this is to see if the laptop has a touchpad or not
     * @param wirelessMouse this is to see if the laptop is using a wireless mouse
     * @throws IllegalArgumentException this checks to see if there is an Illegal Argument Exception
     */
    public Laptop(
            final String brand,
            final String model,
            final double priceCdn,
            final boolean powerCableAttached,
            final DataPort[] dataPorts,
            final double displaySizeInches,
            final boolean touchPad,
            final boolean wirelessMouse) {
        super(brand, model, priceCdn, powerCableAttached, dataPorts);

        if (displaySizeInches <= IMPOSSIBLE_SCREEN_SIZE) {
            throw new IllegalArgumentException("This value is not valid for the display size");
        }

        this.displaySizeInches = displaySizeInches;
        this.touchPad = touchPad;
        this.wirelessMouse = wirelessMouse;
        this.batteryCharged = powerCableAttached;
    }

    public double getDisplaySizeInches() {
        return displaySizeInches;
    }

    public boolean isTouchPad() {
        return touchPad;
    }

    public boolean isWirelessMouse() {
        return wirelessMouse;
    }

    public boolean isBatteryCharged() {
        return this.batteryCharged;
    }

    public void chargeBattery() {
        if (isPowerCableAttached()) {
            batteryCharged = true;
        }
    }

    public boolean hasPower() {
        return super.hasPower() || isBatteryCharged();
    }

    public String howExpensive() {
        if (getPriceCdn() <= CHEAP_LAPTOP) {
            return "Too cheap";
        } else if (getPriceCdn() >= EXPENSIVE_LAPTOP) {
            return "Too expensive";
        } else {
            return "It is a good option";
        }
    }

    public String howBig() {
        if(getDisplaySizeInches() <= SMALL_TO_MEDIUM_DISPLAY_SIZE ) {
            return "This is a small display screen";
        } else if(getDisplaySizeInches() > SMALL_TO_MEDIUM_DISPLAY_SIZE){
            return "This is a medium display screen";
        } else if(getDisplaySizeInches() >= MEDIUM_TO_LARGE_DISPLAY_SIZE) {
            return "This is a large display screen";
        }
        return "Screen is a weird size";
    }

    public void programReadOnlyMemory(String readOnlyMemory) {
        this.readOnlyMemory = readOnlyMemory;
    }

    public char readKey() {
        if (keyboardPointer >= this.keyboardBuffer.length) {
            System.out.println("You hear the laptop make a beep");
            return 0;
        }
        var out = this.keyboardBuffer[keyboardPointer];
        keyboardPointer += 1;
        return out;
    }

    public void setKeyboardBuffer(String buffer) {
        this.keyboardBuffer = buffer.toCharArray();
        this.keyboardPointer = 0;
    }

    private void reset() {
        this.dataPointer = 0;
        this.instructionPointer = 0;
        for (int i = 0; i < this.memory.length; i++) {
            this.memory[i] = 0;
        }
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Brainfuck#Language_design">Wikipedia article on
     *     language</a>
     */
    public void runStoredProgram() {
        reset();
        while (instructionPointer < readOnlyMemory.length()) {
            var currentInstruction = readOnlyMemory.charAt(instructionPointer);
            boolean incrementInstructionPointer = true;

            if (currentInstruction == '>') {
                // increment data pointer
                this.dataPointer++;
            } else if (currentInstruction == '<') {
                // decrement data pointer
                this.dataPointer--;
            } else if (currentInstruction == '+') {
                // increment value at data pointer
                this.memory[this.dataPointer] += 1;
            } else if (currentInstruction == '-') {
                // decrement value at data pointer
                this.memory[this.dataPointer] -= 1;
            } else if (currentInstruction == '.') {
                // output value at data pointer
                printBuffer.add(this.memory[this.dataPointer]);
            } else if (currentInstruction == ',') {
                // accept one byte of input
                this.memory[this.dataPointer] = readKey();
            } else if (currentInstruction == '[') {
                // if value is zero, jump to command after matching right bracket
                if (this.memory[this.dataPointer] == 0) {
                    incrementInstructionPointer = false;
                    this.instructionPointer = findMatchingBracket(currentInstruction);
                }
            } else if (currentInstruction == ']') {
                // if value is nonzero, jump to command after matching left bracket
                if (this.memory[this.dataPointer] != 0) {
                    incrementInstructionPointer = false;
                    this.instructionPointer = findMatchingBracket(currentInstruction);
                }
            } else {
                throw new AssertionError("Invalid instruction");
            }
            if (incrementInstructionPointer) {
                this.instructionPointer++;
            }
        }
    }

    private int findMatchingBracket(char currentInstruction) {
        assert currentInstruction == '[' || currentInstruction == ']';
        int direction;
        if (currentInstruction == '[') {
            direction = 1;
        } else {
            direction = -1;
        }
        int bracketTracker = -direction;
        int currentPosition = this.instructionPointer + direction;
        while (true) {
            char checkingInstruction = this.readOnlyMemory.charAt(currentPosition);
            if (checkingInstruction == '[') {
                bracketTracker -= 1;
            } else if (checkingInstruction == ']') {
                bracketTracker += 1;
            }
            if (bracketTracker == 0) {
                return currentPosition;
            }
            currentPosition += direction;
        }
    }
}
