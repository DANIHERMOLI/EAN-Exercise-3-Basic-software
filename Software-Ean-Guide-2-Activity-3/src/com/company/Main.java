package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select the exercise: ");
        int exercise = input.nextInt();
        if(exercise == 1) {
            firstEx(getIntArrayList());
        } else if(exercise == 2) {
            System.out.println("how many numbers will you add? ");
            int number = input.nextInt();
            double [] myArray = secondExArray(number);
            System.out.println(secondExResult(myArray));
        } else if(exercise == 3) {
            System.out.println("For the first group: ");
            ArrayList<String> list1 = getStrArrayList();
            System.out.println("For the second group: ");
            ArrayList<String> list2 = getStrArrayList();
            System.out.println(firstEx(list1, list2));
        } else {
            System.out.println("Ummmmmm........really?");
        }
    }

    public static ArrayList<Integer> getIntArrayList() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        System.out.println("How many numbers do you want to add?");
        int userChoice = input.nextInt();
        for (int i = 1; i <= userChoice; i++) {
            System.out.println("Enter the " + i + " value.");
            array.add(input.nextInt());
            do {
                System.out.println("Do you want to add another number? N/Y");
                String choice = input.next();
                choice = choice.toLowerCase();
                if (choice.equals("y")) {
                    System.out.println("Please enter a number");
                    int number = input.nextInt();
                    array.add(number);
                } else if (choice.equals("n")) {
                    break;
                } else {
                    System.out.println("ERROR: Incorrect choice. Only N/Y are allowed");
                }
            } while (true);
        }
        return array;
    }

    public static ArrayList<String> getStrArrayList() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> array = new ArrayList<>();
        System.out.println("How many items do you want to add?");
        int userChoice = input.nextInt();
        for (int i = 1; i <= userChoice; i++) {
            System.out.println("Enter the item number " + i + ".");
            array.add(input.next());
        }
        do {
            System.out.println("Do you want to add another item? N/Y");
            String choice = input.next();
            choice = choice.toLowerCase();
            if (choice.equals("y")) {
                System.out.println("Please enter the item");
                String item = input.next();
                array.add(item);
            } else if (choice.equals("n")) {
                break;
            } else {
                System.out.println("ERROR: Incorrect choice. Only N/Y are allowed");
            }
        } while (true);
        return array;
    }




    public static void firstEx(ArrayList<Integer> array) {
        double totalSum = 0;
        for(int i = 0; i < array.size(); i++) {
            totalSum += array.get(i);
        }
        Collections.sort(array);
        System.out.println("The smallest number is: " + array.get(0));
        System.out.println("The highest number is: " + array.get(array.size() - 1));
        System.out.println("The average number is: " + totalSum / array.size());
        System.out.println(array);
    }

    public static List firstEx(ArrayList<String> list1, ArrayList<String> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        List<String> tempList = new ArrayList<>(list1);
        tempList.removeAll(list2);
        list2.removeAll(list1);
        tempList.addAll(list2);
        Collections.sort(tempList);
        return (tempList);
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
