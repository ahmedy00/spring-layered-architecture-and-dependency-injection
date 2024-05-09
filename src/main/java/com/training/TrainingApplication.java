package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Math.abs;

@SpringBootApplication
public class TrainingApplication {

    public static void main(String[] args) {
        int result = 0;
        char[] chars = s.toCharArray();
        if (chars.length > 0) {
            for (int i = 0; i < chars.length - 1; i++) {
                result += abs(chars[i] - chars[i+1]);
            }
        }
        System.out.println("Result is " + result);
        SpringApplication.run(TrainingApplication.class, args);
    }

}
