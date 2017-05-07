package com.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saurav on 29/4/17.
 */

public class Problem {


    public static void main(String[] args) {
        int a, b, c, d;
        List<Integer> list = new ArrayList<>();
        list.add(25626);
        list.add(25757);
        list.add(24367);
        list.add(24267);
        list.add(16);
        list.add(100);
        list.add(2);
        list.add(7277);
        d = -128;


        a = 25626;
        for (Integer i : list) {
            b = i;
            c = b - a;
            if (b == 25626) {
                System.out.println(b);
            } else if (c <= 127 && c >= -127) {
                System.out.println(c);
                a = b;
            } else {
                System.out.println(d);
                System.out.println(c);
                a = b;
            }


        }


    }
}

