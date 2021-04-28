package com.escaperooms.application;


import com.escaperooms.spaceodyssey.Prompter;

import java.util.Scanner;

class EscapeRoomPrompter {
    Prompter prompter = new Prompter(new Scanner(System.in));

    String getPrompt(String message, String regex, String errorMessage) {
        return prompter.prompt(message, regex, errorMessage);
    }

}