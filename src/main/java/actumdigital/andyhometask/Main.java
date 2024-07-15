package actumdigital.andyhometask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.ArrayList;

class CreateFile {
    private String name;
    private ArrayList<Integer> noDuplicatesList;
    private ArrayList<Integer> mergedArray = new ArrayList<Integer>();

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }

    public void setRandomNumberArray(int n) {
        noDuplicatesList = new ArrayList<Integer>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            noDuplicatesList.add(random.nextInt(1000));
        }
    }

    // Getter
    public ArrayList<Integer> getRandomNumberArray() {
        return noDuplicatesList;
    }

    public ArrayList<Integer> getMergedArray() {
        return mergedArray;
    }

    // Create file method
    void create() {
        File fileObj = new File(this.name);

        try {
            if (fileObj.createNewFile()) {
                System.out.println("File created: " + fileObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating file.");
            e.printStackTrace();
        }
    }

    // Write to file method
    static void write2file(String filename, ArrayList<Integer> numbers) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < numbers.size(); i++) {
            outputWriter.write(Integer.toString(numbers.get(i)));
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

    // Read the file method
    public void readFile(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                mergedArray.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading file.");
            e.printStackTrace();
        }
    }

    // Sort method
    public ArrayList<Integer> sort() {
        Comparator<Integer> comp = (Integer a, Integer b) -> {
            return b.compareTo(a);
        };

        Collections.sort(mergedArray, comp);
        return mergedArray;
    }
}

public class Main {
    static final String FILE_1 = "test1.txt";
    static final String FILE_2 = "test2.txt";
    static final String FILE_3 = "result.txt";

    public static void main(String[] args) {
        // instance
        CreateFile file = new CreateFile();

        // create
        file.setName(FILE_1);
        file.create();
        file.setName(FILE_2);
        file.create();
        file.setName(FILE_3);
        file.create();

        // write
        file.setRandomNumberArray(100);
        try {
            file.write2file(FILE_1, file.getRandomNumberArray());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }

        file.setRandomNumberArray(100);
        try {
            file.write2file(FILE_2, file.getRandomNumberArray());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }

        // read
        file.readFile(FILE_1);
        file.readFile(FILE_2);

        // sort
        file.sort();

        // save sorted result into file
        try {
            file.write2file(FILE_3, file.getMergedArray());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}