package com.example.nasa.ui.flashcard;

import java.util.HashMap;
import java.util.List;

public class SolarSysBodiesDB {
    private static HashMap<Integer, Bodies> SSbodies = new HashMap<>();

    public static HashMap<Integer, Bodies> getBodies() {
        return SSbodies;
    }

   public static Bodies getByName(String name) {
        int i=1;
        while (i < SSbodies.size() && SSbodies.isEmpty() == false){
            if (SSbodies.get(i).getName().equals(name)) {
                return SSbodies.get(i);
            }
            i++;
        }
        return null;
   }

    public static void saveBodiesToDatabase(List<Bodies> bodiesToSave) {
        for(int i = 1; i < bodiesToSave.size(); i++) {
            Bodies body = bodiesToSave.get(i);
            SSbodies.put(i, body);
        }
        System.out.println(bodiesToSave);
    }
}
