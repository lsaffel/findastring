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


        findTheString(inputSearchString, inputSearchPath);

    }

    private static void findTheString(String searchString, String searchPath) throws IOException {

        // put the rest of this into a method / routine / something, I think, that can be called recursively
        File f = new File(searchPath);
        boolean stringFound;

        System.out.println("Is directory? " + f.isDirectory());

        // returns pathnames for files and directory
        File[] paths = f.listFiles();

        // testing string concat - remove **. This does work
/*
        String newFileName = "heyyou.txt";
        String newPath = searchPath + "/" + newFileName;
        System.out.println("the new path name is:");
        System.out.println(newPath);

*/


        System.out.println("---------------------------------------");

        // for each pathname in pathname array
        for(File path:paths) {

            // prints file and directory paths << temporary. ** Change this line / section
            System.out.println("the path we are searching in is:");

            System.out.println(path);

            // for any files in this directory, search for the string and if found, save / print that file name
            // for any directories in this directory, go into that directory and do this search again

            if (path.isDirectory()) {
                // do the search on the directory

                // newPath to be searched = the current path name + / + name of the directory
                // Object newPath = f + "/" + ;
//                newPath = searchPath + "/" + path;      // << this is adding the whole path, not just the end of it


                System.out.println("the new path to be searched is:");
                System.out.println(path);

                findTheString(searchString, path.toString());


                // do the search on newPath
                // ***

            } else {
                // if the string is in the file then print the name of the file
                // ***

                BufferedReader br = new BufferedReader(new FileReader(path));
                String line;
                stringFound = false;    // initialize
                while ((line = br.readLine()) != null) {
                    // check if the string searchString is in the line line

                    // if it is, print the path and file name
                    // if not, do nothing (or perhaps print "the string is not in the file" <file name here> = path (??))

                    if (line.contains(searchString)) {
                        stringFound = true;
                    }

/*
                    // the part above is not done yet **
                    System.out.println("&&&&&&&& A file was found !! Here's the name of the file:");
                    System.out.println(path);
*/

                }
                if (stringFound) {
                    System.out.println("%% woohoo woohoo %% The file DOES contain that string and the file is called:");
                    System.out.println(path);
                }

            }

        }

        System.out.println("---------------------------------------");
/*

        File dir = new File(searchPath);
        String[] children = dir.list();

        if (children == null) {
            System.out.println(searchPath);
            System.out.println("does not exist or is not a directory");
        } else {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                System.out.println("the amazing file name is:");
                System.out.println(filename);
            }
        }
*/

    }
}
