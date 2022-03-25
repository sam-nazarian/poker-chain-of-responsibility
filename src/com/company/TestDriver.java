package com.company;

import java.util.Random;

public class TestDriver {
    public static void main(String[] args) {
        Random rnd = new Random();

        for(int i=0; i<100; i++){
            int n = rnd.nextInt(5)+1;
            System.out.println(n);
        }

    }
}
