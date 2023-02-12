package org.example;

import action.Actions;
import util.AnnotationProcessor;
import util.UserInput;

public class Main {
    public static void main(String[] args)  {

        AnnotationProcessor annotationProcessor = new AnnotationProcessor();
        annotationProcessor.executeSingleton();
        System.out.println(AnnotationProcessor.CACHE.values());
        System.out.println();

        annotationProcessor.executeAutowired();
        System.out.println(AnnotationProcessor.CACHE.values());

        final Actions[] values = Actions.values();
        final String[] names = mapActionToName(values);

        while (true) {
            final int userChoice = UserInput.menu(names);
            values[userChoice].execute();
        }
    }
    private static String[] mapActionToName(final Actions[] values) {
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].getName();
        }
        return names;
    }
}