package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] myArray;

        System.out.println("Select the exercise: ");
        int exercise = input.nextInt();
        if(exercise == 1) {
            firstEx();
        } else if(exercise == 2) {
            System.out.println("how many numbers will you add? ");
            int number = input.nextInt();
            myArray = secondExArray(number);
            System.out.println(secondExResult(myArray));
        } else if(exercise == 3) {
            System.out.println("In progress...");
        } else {
            System.out.println("Ummmmmm........");
        }
    }

    public static void firstEx() {
        ArrayList<Integer> otherListOfNumbers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers do you want to add?");
        int userChoice = input.nextInt();
        for(int i = 1; i <= userChoice; i++) {
            System.out.println("Enter the " + i + " value.");
            otherListOfNumbers.add(input.nextInt());
        }
        do {
            System.out.println("Do you want to add another number? N/Y");
            String choice = input.next();
            choice = choice.toLowerCase();
            if(choice.equals("y")) {
                System.out.println("Please enter a number");
                int number = input.nextInt();
                otherListOfNumbers.add(number);
            }else if(choice.equals("n")) {
                break;
            }else {
                System.out.println("ERROR: Incorrect choice. Only N/Y are allowed");
            }
        }while(true);

        double totalSum = 0;
        for(int i = 0; i < otherListOfNumbers.size(); i++) {
            totalSum += otherListOfNumbers.get(i);
        }
        Collections.sort(otherListOfNumbers);
        System.out.println("The smallest number is: " + otherListOfNumbers.get(0));
        System.out.println("The highest number is: " + otherListOfNumbers.get(otherListOfNumbers.size() - 1));
        System.out.println("The average number is: " + totalSum / otherListOfNumbers.size());
        System.out.println(otherListOfNumbers);
    }

    public static double[] secondExArray(int number) {
        Scanner input = new Scanner(System.in);
        double [] array = new double[number];
        System.out.println("Enter " + number + " values");
        for(int i = 0; i < array.length; i++) {
            array[i] = input.nextDouble();
        }
        return array;
    }

    public static double secondExResult(double [] array) {
        int n = array.length;
        int average = 0;
        double internalSum = 0;
        for(int i = 0; i < array.length; i++) {
            average += array[i];
        }
        average /= n;
        for(int i = 0; i < array.length; i++) {
            internalSum += Math.pow((array[i] - average), 2);
        }
        return (Math.sqrt(internalSum/(array.length - 1)));
    }
}
