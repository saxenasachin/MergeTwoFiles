package org.example;

import exception.InvalidFileContentException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidFileContentException {
        System.out.println("Reading file 1..");
        File file1 = new File("in1.txt");
        printFile(file1);
        String file1Content = getFileContent(file1);
        if (file1Content == null) {
            throw new InvalidFileContentException("Invalid file 1");
        }
        List<Integer> list1 = convertStringToIntArray(file1Content);

        System.out.println("Reading file 2..");
        File file2 = new File("in2.txt");
        printFile(file2);
        String file2Content = getFileContent(file2);
        if (file2Content == null) {
            throw new InvalidFileContentException("Invalid file 2");
        }
        List<Integer> list2 = convertStringToIntArray(file2Content);

        List<Integer> list3 = new ArrayList<>(list1);
        list3.addAll(list2);
        Collections.sort(list3);

        File mergedFile = createFile("in3.txt");
        if (mergedFile != null) {
            writeToFile(mergedFile, convertIntListToString(list3));
            printFile(mergedFile);
        }
    }

    private static void printFile(File file) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileContent(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String st;
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {
                stringBuilder.append(st);
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Integer> convertStringToIntArray(String content) {
        List<Integer> integerArray = new ArrayList<>();
        String[] stringIntegerArray = content.split(",");
        for (String s : stringIntegerArray) {
            integerArray.add(Integer.parseInt(s));
        }
        return integerArray;
    }

    private static File createFile(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            return myObj;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }

    private static String convertIntListToString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : list) {
            stringBuilder.append(i.toString() + ',');
        }
        return stringBuilder.toString();
    }

    private static void writeToFile(File file, String content) {
        try {
            FileWriter myWriter = new FileWriter(file.getName());
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}