/*  Name: Thomas Miller
 *  Student Number: C3279309
 *  Date: 29/05/2017
 *  Lab: C05 - Wednesday, 11-1PM
 *  Task: SENG1110, Programming Assignment 2
 *  Class Name: MovieDatabase
 *  Class Description: This class enables movies to be entered into the local allMovies array of movie objects, and be deleted, edited, sorted, saved to a file, tested for duplicants and all displayed in a list.
 *                     Also included is methods to resize the allMovies array when it gets full or too small, find the position of a movie in the array and return an entire movie object in the array.
 */
import java.util.*;
import java.io.*;
public class MovieDatabase {
    Scanner console = new Scanner(System.in);
    private final int MAX = 4; 
    private int logicalSize = 0;
    private int logicalSizeDel = 0;
    private Movie[] allMovies = new Movie[MAX];

    // Method: resize
    // Pre-Condition: A movie object array and a boolean variable
    // Post-Condition: (Movie[]) Resizes the movie object array inputted based on if the boolean variable is true or false
    // A method to resize a movie object array by 4 positions if true and deducts 2 if flase
    public Movie[] resize(Movie[] x, boolean add)
    {
        Movie[] y;
        if (add){
            y = new Movie[x.length + 4]; // If boolean variable is true then resizes the physical length of the movie array by 4 positions
            for(int i = 0; i < x.length; i++)
            {
                y[i] = x[i];
            }
        }
        else {
            y = new Movie[x.length - 2]; // If false then decreace by 2
            for(int i = 0; i < x.length-2; i++)
            {
                y[i] = x[i]; // Save as new array
            }
        }
        return (y); // Retrun new array to be saved to the origional array
    }

    // Method: testMovie
    // Pre-Condition: A String for the name and director, a double for the fileSize and an integer for the duration
    // Post-Condition: (boolean) Returns true if movie exists
    // Method to test if a movie already exists in the movie database by comparing all current movies to eachother and if any have exactly the same name, director, filesize and duration then it will return true otherwise false
    public boolean testMovie(String name, String director, double fileSize, int duration)
    {
        for (int i = 0; i < logicalSize; i++)
        {
            if(name.equalsIgnoreCase(allMovies[i].getName()) && director.equalsIgnoreCase(allMovies[i].getDirector()) && fileSize == allMovies[i].getSize() && duration == allMovies[i].getDuration()) { 
                return true; // If the name, director, fileSize or duration of a movie are equal to the just entered one then return true - it already exists
            }
        }
        return false; // If found no match then just return false
    }

    // Method: addMovie
    // Pre-Condition: Strings for new name and director and doubles for new size and duration have been initilised with a valid 
    //                inputs from the user in interface class
    // Post-Condition: (void) Sends the collected data to be stored into a movie object
    // Will send the name, director, size and duration to a movie object
    public void addMovie(String newName, String newDirector, double newSize, int newDuration)
    {
        try
        {
            allMovies[logicalSize] = new Movie(newName, newDirector, newSize, newDuration);
            logicalSize++;
        }
        catch(Exception e)
        {
            allMovies = resize(allMovies, true);
            Movie.removeMovieCount();
            allMovies[logicalSize] = new Movie(newName, newDirector, newSize, newDuration);
            logicalSize++;
        }       
    }

    // Method: displayMovies
    // Pre-Condition: N.A.
    // Post-Condition: (void) Based on the logicalSize prints all movie information for all movies currently in array 'allMovies[]'
    // Will Display all movies currently stored in the logicalSize of the allMovies array
    public void displayMovies()
    {
        System.out.println("Number of movies in database: "+Movie.getNumberOfMovies()); // Uses static variable from Movie class to display the number of movies currently created overall
        if(logicalSize > 0)
            System.out.println("Name - Director - FileSize - Duration");

        for(int i = 0; i < logicalSize; i++) // Loops through logical size of array and displays all movie information each loop for each movie
        {
            System.out.println(allMovies[i].getName() +" - "+ allMovies[i].getDirector() +" - "+ allMovies[i].getSize() +"MB - "+ allMovies[i].getDuration()+"MIN");
        }
    }

    // Method: deleteMovie
    // Pre-Condition: A String name of any movie 
    // Post-Condition: (void) If the name matches any known movie in the array then it will overwrite its position in the array thus removing it and move all positions back one spot to its location. Reduces the physical array size by one.
    // Method to delete a movie from the allMovies array 
    public void deleteMovie(String name)
    {
        int test = findPosition(name); // First tests to see if movie name matches any existing movie name
        if(test == -1)
            System.out.println("---Sorry this movies does not exist---");
        else { // If the movie does exist then remove it 
            int position;
            for(int i = 0; i < logicalSize; i++) // Traverses logical size of allMovies array
            {
                if(name.equalsIgnoreCase(allMovies[i].getName())) { // If the name entered is equal to the name of a movie in the array
                    position = i;
                    for(int k = position; k < logicalSize-1; k++)
                        allMovies[k] = allMovies[k+1]; // Method to overwrite a position in the array
                    System.out.println("Movie Deleted");
                    logicalSize--;
                    Movie.removeMovieCount();
                    logicalSizeDel++;
                }
            }
            if(logicalSizeDel == 2) { // Will reduce the physical size of the allMovies array by 2 if 2 movies have been deleted 
                allMovies = resize(allMovies, false);
                logicalSizeDel = 0; 
            }
        }
    }

    // Method: findPosition
    // Pre-Condition: A valid String name of a movie
    // Post-Condition: (int) Returns the position of the array that the movie is located in else rturns -1 if not in array
    // Method to test every position of the array of movies and capture the position if the entered name is a match and resturns that or -1 if not found
    public int findPosition(String name)
    {
        int position = -1;
        for(int i = 0; i < logicalSize; i++)
        {
            if(name.equalsIgnoreCase(allMovies[i].getName())) {
                position = i;
                return position;
            }
        }
        return position;
    }

    // Method: sendMovieObject
    // Pre-Condition: A valid integer of the position of the array that the movie is located in
    // Post-Condition: (Movie) Returms the entire movie object defined by the entered psoition 
    // Method to return an entire movie object 
    public Movie sendMovieObject(int position)
    {
        return allMovies[position];
    }

    // Method: editMovie
    // Pre-Condition: A valid String name of the movie and an integer number between 1-4
    // Post-Condition: (void) Changes the value stored in either a movie name, director, file size or duration based on the value of the integer entered
    // Method to edit a movie, seperated in parts defined by 1-4 numbers
    public void editMovie(String name, int part)
    {
        for(int i = 0; i < logicalSize; i++)
        {
            if(name.equalsIgnoreCase(allMovies[i].getName())) {
                System.out.println("Current movie information: ");
                System.out.println(allMovies[i].getName() +" - "+ allMovies[i].getDirector() +" - "+ allMovies[i].getSize() +"MB - "+ allMovies[i].getDuration()+"MIN");
                if(part == 1){ // Edit movie name
                    System.out.println("Enter the new name of the movie: ");
                    String newName = console.nextLine();
                    allMovies[i].addName(newName); // Updates movie name from String newName entered
                }
                else if(part == 2){ // Edit movie director
                    System.out.println("Enter the new director of the movie: ");
                    String newDirector = console.nextLine();
                    allMovies[i].addDirector(newDirector); 
                }
                else if(part == 3){ // Edit movie file size
                    System.out.println("Enter the new file size of the movie: ");
                    double newSize = console.nextDouble();
                    allMovies[i].addSize(newSize); 
                }
                else if(part == 4){ // Edit movie duration
                    System.out.println("Enter the new duration of the movie: ");
                    int newDuration = console.nextInt();
                    allMovies[i].addDuration(newDuration); 
                }
                else {
                    System.out.println("*Invalid Input*");
                }
                System.out.println("Updated movie information: "); // After an edit has been made it displays the updated movie information
                System.out.println("Name - Director - FileSize - Duration");
                System.out.println(allMovies[i].getName() +" - "+ allMovies[i].getDirector() +" - "+ allMovies[i].getSize() +"MB - "+ allMovies[i].getDuration()+"MIN");
            }
        }
    }

    // Method: returnLogicalSize
    // Pre-Condition: N.A.
    // Post-Condition: (int) Returns the logical size value 
    // Method to return the logical size of how mant movies are currently stored in the movie database
    public int returnLogicalSize()
    {
        return logicalSize;
    }

    // Method: sortByName
    // Pre-Condition: N.A.
    // Post-Condition: (void) Sorts and then prints all the movies in alphabetical order
    // Will Display all the movies sorted in alphabetical order
    public void sortByName()
    {
        if(logicalSize != 0) {
            String[] names = new String[logicalSize];
            for (int i = 0; i < logicalSize; i++) // Stores all names of movies into a new array called names 
                names[i] = allMovies[i].getName();
            Arrays.sort(names); // Function which sorts an array of strings in alphabetical order
            System.out.println("All movie names sorted in alphabetical order:");
            for (int i = 0; i < logicalSize; i++) // Displays all the names of the movies in alphabetical order
                System.out.println(names[i]);
        }
    }

    // Method: sortByDirector
    // Pre-Condition: A valid String name of a director of a movie 
    // Post-Condition: (void) Sorts then prints all movies with the same director name
    // Method to sort then display all movies based on the name of a director entered
    public void sortByDirector(String name)
    {
        boolean test = false;
        for (int i = 0; i < logicalSize; i++)
        {
            if(name.equalsIgnoreCase(allMovies[i].getDirector())) // Test if the director entered exists or not
                test = true;
        }
        if(test == true){
            System.out.println("All movies with director '"+name+"' are: ");
            System.out.println("Name - Director - FileSize - Duration");
            for(int i = 0; i < logicalSize; i++)
            {
                if(name.equalsIgnoreCase(allMovies[i].getDirector())) // Displays all movies by that director once found in this line
                {
                    System.out.println(allMovies[i].getName() +" - "+ allMovies[i].getDirector() +" - "+ allMovies[i].getSize() +"MB - "+ allMovies[i].getDuration()+"MIN");
                }
            }
        }
        else 
            System.out.println("---Sorry this director does not exist---");
    }

    // Method: sortByDuration
    // Pre-Condition: A valid integer value
    // Post-Condition: (void) Prints all movies with duration under the one entered
    // Method to display all movies whos duration is under the entered value
    public void sortByDuration(int sortDur)
    {
        System.out.println("Name - Director - FileSize - Duration");
        for(int i = 0; i < logicalSize; i++)
        {
            if(allMovies[i].getDuration() < sortDur) // Displays all movies whos duration fits under the duration entered
            {
                System.out.println(allMovies[i].getName() +" - "+ allMovies[i].getDirector() +" - "+ allMovies[i].getSize() +"MB - "+ allMovies[i].getDuration()+"MIN");
            }
        }
    }

    // Method: sortByFileSize
    // Pre-Condition: A vald double value
    // Post-Condition: (void) Prints all movies with file size under the one entered
    // Method to display all movies whos file size is under the entered value 
    public void sortByFileSize(double sortSize)
    {
        System.out.println("Name - Director - FileSize - Duration");
        for(int i = 0; i < logicalSize; i++)
        {
            if(allMovies[i].getSize() < sortSize) // If a movies file size is less than the value entered then print it in the list
            {
                System.out.println(allMovies[i].getName() +" - "+ allMovies[i].getDirector() +" - "+ allMovies[i].getSize() +"MB - "+ allMovies[i].getDuration()+"MIN");
            }
        }
    }

    // Method: saveToFile
    // Pre-Condition: N.A.
    // Post-Condition: (void) Creates a new text file called "movieDatabase.txt" in the local directory and saves all the movies currently in the database to it with titles
    // Method to create and save the entire movie database to a file in a structured format
    public void saveToFile()
    {
        String fileName = "movieDatabase.txt"; // Defines the name of the file
        PrintWriter movieDatabaseOut = null; // Creates a new PrintWriter object which allows writing to a file 
        try //  Try-catch block to capture an error when creating the file
        {
            movieDatabaseOut = new PrintWriter(fileName); // Creates the new file in the local directory named "MovieDatabase.txt" and sets it to be opened for writing 
            for(int i = 0; i < logicalSize; i++){  // For all movies currently in the database...
                if(i == logicalSize-1) // If it is the last movie in the database then do not print two lines after it which will cause an error when reading from the file again
                    movieDatabaseOut.print(allMovies[i].toString());
                else // For all other movies print the toString method in the Movie class with two lines to seperate each movie block of name, director, fileSize and duration
                    movieDatabaseOut.print((allMovies[i].toString()) + System.lineSeparator() + System.lineSeparator());
            }  
            movieDatabaseOut.close(); // Function which closes the file to preventr further errors
            System.out.println("Movie database sent to file "+fileName);
        }
        catch (IOException e) // Used to capture the error if the file was not opened or written to correctly
        {
            System.out.println ("Error opening the file: " + fileName);
            System.exit(0); // Ends the program immediately to prevent more errors with open files
        }
    }

    // Method: inputFromFile
    // Pre-Condition: N.A. 
    // Post-Condition: (void) Opens the file nammed "movieDatabase.txt" for reading and inputs all its movie information into the database without overwriting the existing database
    // Method to open the file for reading and imports all movie information in the file to the movie database
    public void inputFromFile()
    {
        String fileName = "movieDatabase.txt"; // Defines the file name
        Scanner movieDatabaseIn = null; // Creates a new Scanner object which allows reading from a file
        try // Try-catch block to catch any errors when opening the file for reading and if it dosent exist yet
        {
            movieDatabaseIn = new Scanner(new File(fileName)); // Opens the file for reading 
        }
        catch (Exception e)
        {
            System.out.println ("Error opening the file: " +fileName);
            System.exit(0); // End program to prevent errors
        }
        try{
            System.out.println("The following files were read from the file "+fileName);
            while(movieDatabaseIn.hasNextLine()){ // Will loop as long as the file has a next line to read, once it reaches the end of the file it will stop
                String line = movieDatabaseIn.next(); // Captures word Movie
                line = movieDatabaseIn.next(); // Captures word title:
                String name = movieDatabaseIn.nextLine().trim(); // Captures and saves the rest of the line to the name of the movie and trims its ends so there are no leading or trailing spaces on either side of the word
                line = movieDatabaseIn.next(); // Captures the word on the next line, Director:
                String director = movieDatabaseIn.nextLine().trim(); // Captures and saves the rest of the line to the director of the movie and trims it like the name
                line = movieDatabaseIn.next(); // Captures the word Filesize:
                double fileSize = movieDatabaseIn.nextDouble(); // Captures and saves the file size of the movie as a double and not the rest of the line
                line = movieDatabaseIn.next(); // Captures the word Duration:
                int duration = movieDatabaseIn.nextInt(); // Captures and saves the duration of the movie as an integer
                boolean isTrue = testMovie(name, director, fileSize, duration); // Method to check if movie already exists in database
                if(isTrue) // If it does then display message and dont add it, else then add it
                    System.out.println("---Sorry this movie already exists---");
                else 
                    addMovie(name, director, fileSize, duration); // Adds all the information as another position in the allMovie array
                System.out.println("Movie title: "+name); // Prints out what was read from the file 
                System.out.println("Director: "+director);
                System.out.println("File Size: "+fileSize);
                System.out.println("Duration: "+duration);
                System.out.println(""); // Seperates the blocks of movies with a space
            }
            movieDatabaseIn.close(); // Closes the file to prevent errors 
        }
        catch(Exception e) // If there was an error opening the file to read and storing information then end the program
        {
            System.out.println ("Error reading the file: " +fileName);
            System.exit(0);
        }
    }
}
