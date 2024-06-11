/**
 * @author Hamd abid
 * @date 02/22/2024
 * locks
 */

package com.hamd;

public class Lock {
    private String combination;
    private int incorrectAttempts;
    private boolean isUnlocked;

    // Default constructor
    public Lock() {
        this.combination = "0000";
        this.incorrectAttempts = 0;
        this.isUnlocked = false;
    }

    // Overloaded constructor
    public Lock(String combo) {
        this.combination = combo;
        this.incorrectAttempts = 0;
        this.isUnlocked = false;
    }

    // Getter for isUnlocked
    public boolean isUnlocked() {
        return isUnlocked;
    }

    // Attempt to unlock
    public void attemptUnlock(String combo) {
        if (combo.equals(combination)) {
            System.out.println("Click.");
            isUnlocked = true;
            incorrectAttempts = 0; // Reset incorrect attempts
        } else {
            incorrectAttempts++;
            if (incorrectAttempts >= 3) {
                System.out.println("Alarm!");
            }
        }
    }

    // Change combination
    public boolean changeCombo(String currentCombo, String newCombo) {
        if (isUnlocked && currentCombo.equals(combination) && isValidCombo(newCombo)) {
            this.combination = newCombo;
            this.isUnlocked = false; // Lock the lock
            return true;
        } else {
            return false;
        }
    }

    // Lock the lock
    public void lock() {
        this.isUnlocked = false;
    }

    // Validate combination format
    private boolean isValidCombo(String combo) {
        // Validate length and format (e.g., only digits)
        return combo.length() == 4 && combo.matches("\\d+");
    }
}
