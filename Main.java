import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.BufferedWriter;   // Import the FileWriter class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Random;
import java.util.stream.Collectors;
import java.util.ArrayList;

class CreateFile {
    private String name; // private = restricted access
    private ArrayList<Integer> noDuplicatesList; // private = restricted access

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }

    public void setRandomNumberArray(int n) {
        noDuplicatesList = new ArrayList<Integer>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            noDuplicatesList.add(random.nextInt(1000));
        }
    }

    // Getter
    public ArrayList<Integer> getRandomNumberArray() {
        return noDuplicatesList;
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
    static void readFile(String filename) throws IOException {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading file.");
            e.printStackTrace();
        }
    }

    // Sort method
    static void sort() {}
}

public class Main {
    static final String FILE_1="test1.txt";
    static final String FILE_2="test2.txt";

    public static void main(String[] args) {
        // instance
        CreateFile file = new CreateFile();

        // create
        file.setName(FILE_1);
        file.create();
        file.setName(FILE_2);
        file.create();

        // write
        file.setRandomNumberArray(100);
        try {
            System.out.println(file.getRandomNumberArray());
            file.write2file(FILE_1, file.getRandomNumberArray());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }

        file.setRandomNumberArray(100);
        try {
            System.out.println(file.getRandomNumberArray());
            file.write2file(FILE_2, file.getRandomNumberArray());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }

        // read
        array1 = new ArrayList<Integer>(n);
        array2 = new ArrayList<Integer>(n);

        try {
            File myObj = new File(FILE_1);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                array1.add(data);
            }
            myReader.close();
            System.out.println(array1);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading file.");
            e.printStackTrace();
        }

        try {
            File myObj = new File(FILE_2);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                array2.add(data);
            }
            myReader.close();
            System.out.println(array2);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading file.");
            e.printStackTrace();
        }

        // sort
    }
}