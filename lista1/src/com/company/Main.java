package com.company;

public class Main {
    public static void main(String[] args) {
        String text = "";
        for(int i = 0; i < args.length; i++) {
            text += args[i] + " ";
        }
        Cezar cezar = new Cezar();
        System.out.println(cezar.cypher(text));
    }
}
