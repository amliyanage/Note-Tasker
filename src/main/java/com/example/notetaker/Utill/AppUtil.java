package com.example.notetaker.Utill;

import java.util.UUID;

public class AppUtil {
    public static String createNoteId() {
        return UUID.randomUUID().toString();
    }
}
