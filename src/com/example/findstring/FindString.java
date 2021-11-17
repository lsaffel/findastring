package com.example.findstring;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;       // Import the Scanner class

public class FindString {

    public static void main(String[] args) throws IOException {
        // input the string to search for and the path

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter the string to search for:");
        String inputSearchString = myObj.nextLine();  // Read in the string to search for

        System.out.println("The string entered is:");
        System.out.println(inputSearchString);

        System.out.println("Enter the path to search:");
        String inputSearchPath = myObj.nextLine();  // Read in the path to search

        System.out.println("The search path entered is:");
        System.out.println(inputSearchPath);
        System.out.println("---------------------------------------");

        System.out.println("The files (including paths) that contain the search string are the following");
        System.out.println("or if there are no files containing the search string, then this will be blank:");

        findTheString(inputSearchString, inputSearchPath);

    }

    private static void findTheString(String searchString, String searchPath) throws IOException {

        File f = new File(searchPath);
        boolean stringFound;

        // returns pathnames for files and directory
        File[] paths = f.listFiles();



        // for each pathname in pathname array
        for(File path:paths) {
            // For any files in this directory, search for the string and if found, print that file name
            // For any directories in this directory, go into that directory and do this search again

            if (path.isDirectory()) {
                // what we're pointing at is a directory, so do a recursive search on the directory

                findTheString(searchString, path.toString());

            } else {
                // if the string is in the file then print the name of the file

                BufferedReader br = new BufferedReader(new FileReader(path));
                String line;
                stringFound = false;    // initialize
                while ((line = br.readLine()) != null) {
                    // check if the string searchString is in the line line in the file
                    // if it is, print the path and file name
                    // if the string is not in that line of the file, then do nothing

                    if (line.contains(searchString)) {
                        stringFound = true;
                    }
                }
                if (stringFound) {
//                    System.out.println("%% woohoo woohoo %% The file DOES contain that string and the file is called:");
                    System.out.println(path);
                }
            }
        }
    }
}
