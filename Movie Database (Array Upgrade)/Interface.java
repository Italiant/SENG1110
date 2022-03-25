/*  Name: Thomas Miller
 *  Student Number: C3279309
 *  Date: 29/05/2017
 *  Lab: C05 - Wednesday, 11-1PM
 *  Task: SENG1110, Programming Assignment 2
 *  Class Name: Interface
 *  Class Description: This class is used as the interface of the Movie Database project (implamenting arrays). Everything that is displayed on the screen will appear in this class.
 *                     It also contains the movieDatabase object and the array of Playlists objects
 */
import java.util.*;
import java.io.*;
public class Interface {
    //  Method: run
    //  Controls the flow of the program and has code for accessing the playlists and movie database
    private void run() { 
        Scanner console = new Scanner(System.in);
        MovieDatabase database = new MovieDatabase(); // Creates a new 'MovieDatabase' object called 'database'
        final int MAX = 2; 
        int option; // Used for all the switch/case options that the user will type in
        int duration, logicalSize = 1; 
        int logicalSizeDel = 0;
        double fileSize;
        String name, director;
        Playlist[] playlists = new Playlist[MAX]; // Creates a new array of playlist objects with an initial size set to 2 which is called MAX
        do { 
            /* Main Menu */
            System.out.println("*************");
            System.out.println("  MAIN MENU  ");
            System.out.println("Movies (1)");
            System.out.println("Playlists (2)");
            System.out.println("Exit (3)");
            System.out.println("*************");
            option = console.nextInt();
            switch(option)
            {
                case 1: /* Movies */ 
                do {
                    /* Movie Menu */
                    System.out.println("**************************************************************");
                    System.out.println("                             MOVIES                           ");
                    System.out.println("Enter new movie (1)");
                    System.out.println("Display list of movies (2)");
                    System.out.println("Delete a movie (3)");
                    System.out.println("Edit a movie (4)");
                    System.out.println("Sort movies by either name, director, filesize or duration (5)");
                    System.out.println("Save the current movie database to a file (6)");
                    System.out.println("Open an existing movie database from a file (7)");
                    System.out.println("Main Menu (8)");
                    System.out.println("**************************************************************");
                    option = console.nextInt();
                    switch(option)
                    {
                        case 1: // Enters a new movie
                        console.nextLine(); // Needed to capture the buffer space before a user can enter a string with two or more words - used through out program
                        System.out.println("Name: ");
                        name = console.nextLine();
                        System.out.println("Director: ");
                        director = console.nextLine();
                        fileSize = inputDouble("File Size (MB): ", console);
                        duration = inputInt("Duration (MIN): ", console);
                        boolean isTrue = database.testMovie(name, director, fileSize, duration); // Method to check if movie already exists 
                        if(isTrue) // If it does then display message and dont add it, else then add it
                            System.out.println("---Sorry this movie already exists---");
                        else 
                            database.addMovie(name, director, fileSize, duration);
                        break;

                        case 2: // Displays a list of movies
                        database.displayMovies();
                        break;

                        case 3: // Deletes a movie
                        console.nextLine();
                        database.displayMovies();
                        System.out.println("Enter the name of the movie you wish to delete"); 
                        database.deleteMovie(console.nextLine());
                        break;

                        case 4: // Edit a movie
                        console.nextLine();
                        database.displayMovies();
                        System.out.println("Enter the name of the movie you wish to edit: ");      
                        String movieName = console.nextLine();
                        int test = database.findPosition(movieName); // Test if movie exists or not by finding its position in the database, allMovies[] array
                        if(test == -1) // It returns -1 if it is not found 
                            System.out.println("---Sorry this movies does not exist---");
                        else{
                            System.out.println("Enter which part of the movie information you wish to change: ");
                            System.out.println("Name (1)");
                            System.out.println("Director (2)");
                            System.out.println("File Size (3)");
                            System.out.println("Duration (4)");
                            int part = console.nextInt();
                            database.editMovie(movieName, part);
                        }
                        break;   

                        case 5: // Sorts movies by either name, director, filesize or duration
                        System.out.println("Choose the key for ordering the movies by: ");
                        System.out.println("Name(alphabetical) (1)");
                        System.out.println("Director (2)");
                        System.out.println("File Size (3)");
                        System.out.println("Duration (4)");
                        int choose = console.nextInt();
                        if (choose == 1){ // Sort by Name Alphabetically
                            database.sortByName();
                        }else if (choose == 2){ // Sort by Director
                            console.nextLine();
                            database.displayMovies();
                            System.out.println("Enter the name of the director you wish to sort by: ");
                            String nameDir = console.nextLine();
                            database.sortByDirector(nameDir);
                        }else if (choose == 3){ // Sort by File Size
                            database.displayMovies();
                            System.out.println("Enter the size of file size you wish to sort by (MB): ");
                            double sortSize = console.nextDouble();
                            database.sortByFileSize(sortSize);
                        }else if (choose == 4){ // Sort by Duration
                            database.displayMovies();
                            System.out.println("Enter the duration of time you wish to sort by (MIN): ");
                            int sortDur = console.nextInt();
                            database.sortByDuration(sortDur);
                        }else
                            System.out.println("*Invalid Input*");
                        break;

                        case 6: // Save the current movie database to a file
                        database.saveToFile();
                        break;

                        case 7: // Open an existing movie database from a file
                        database.inputFromFile();
                        break;

                        case 8: // Returns to main menu
                        break;

                        default: System.out.println("*Invalid Input*");
                    }
                } while(option !=8);
                break;

                case 2: /* Playlists */
                do {
                    /* Playlist Menu */
                    System.out.println("***********************************");
                    System.out.println("             PLAYLISTS             ");
                    System.out.println("Create new playlist (1)");
                    System.out.println("Add a movie to a playlist (2)");
                    System.out.println("Display list of playlists (3)");
                    System.out.println("Display a specific playlist (4)");
                    System.out.println("Delete a whole playlist (5)");
                    System.out.println("Delete a movie from a playlist (6)");
                    System.out.println("Delete movie from system (7)");
                    System.out.println("Main Menu (8)");
                    System.out.println("***********************************");
                    option = console.nextInt();
                    switch(option)
                    {
                        case 1: // Creates a new playlist
                        try{ // Uses try-catch to catch an error if a new playlist cannot be created  
                            playlists[logicalSize] = new Playlist();
                            System.out.println("You have just created playlist: "+logicalSize); // Prints out which playlist created - starts at 1
                            logicalSize++; // Increaces logical size by 1
                        }catch(Exception e) // If error exists then rezise the playlist before adding a new one 
                        {
                            playlists = resize(playlists, true);
                            playlists[logicalSize] = new Playlist();
                            System.out.println("You have just created playlist: "+logicalSize);
                            logicalSize++;
                        }
                        break;

                        case 2: // Add a movie to a playlist
                        console.nextLine();
                        for(int i = 1; i < logicalSize; i++) // Traverses the entire playlist array and displays all the ones currently created
                            System.out.println("Playlist - "+i);
                        System.out.println("Pick a playlist to add a movie to: ");
                        int choice = console.nextInt();
                        if(choice >= logicalSize || choice <= 0) // Test to see if the chosen playlist exists or not
                            System.out.println("---Sorry this playlist does not exist---");
                        else{
                            System.out.println("You have chosen playlist - "+choice);
                            System.out.println("How many movies would you like to add?: ");
                            int number = console.nextInt(); 
                            if (number <= 0)
                                System.out.println("*Invalid Input*");
                            else {
                                console.nextLine();
                                database.displayMovies(); // Displays all movies in database
                                System.out.println("Enter the names of the movies you wish to add to the playlist: ");
                                for(int i = 0; i < number; i++){ // Will allow user to enter a defined number of movies into the playlist
                                    System.out.println("Enter the name of a movie: ");
                                    int position = database.findPosition(console.nextLine()); // Test if movie exists or not in the database
                                    if(position == -1)
                                        System.out.println("---Sorry this movie does not exist---");
                                    else { // If movie exists then add it to the chosen playlist and loop again until defined number reached        
                                        playlists[choice].addMovie(database.sendMovieObject(position)); // Sends a movie object to the playlist class by using the found psoition of the movie in the database and the choice of which playlist to add it to
                                    }
                                }
                            }
                        }
                        break;

                        case 3: // Display list of playlists
                        if(logicalSize == 1)
                            System.out.println("---Sorry there are no playlists created yet---");
                        else {
                            for (int i = 1; i < logicalSize; i++)
                            {
                                System.out.println("Playlist - "+i); // Seperates playlists by headings 
                                playlists[i].displayPlaylist();
                            }
                        }
                        break; 

                        case 4: // Display a specific playlist
                        for(int i = 1; i < logicalSize; i++)
                            System.out.println("Playlist - "+i);
                        System.out.println("Pick a playlist to display: ");
                        choice = console.nextInt();
                        if(choice >= logicalSize || choice <= 0) // Test if chosen playlist exists or not
                            System.out.println("---Sorry this playlist does not exist---");
                        else{
                            System.out.println("Playlist - "+choice);
                            playlists[choice].displayPlaylist();
                        }
                        break;

                        case 5: // Delete a whole playlist
                        for (int i = 1; i < logicalSize; i++) // Displays all playlists
                        {
                            System.out.println("Playlist - "+i);
                            playlists[i].displayPlaylist();
                        }
                        System.out.println("Pick a playlist to delete: ");
                        choice = console.nextInt();
                        if(choice >= logicalSize || choice <= 0) // Test if chosen playlist exists or not
                            System.out.println("---Sorry this playlist does not exist---");
                        else {
                            for(int i = choice; i < logicalSize-1; i++) // Resizes playlist array by moving all playlists back a position to the one which was just removed
                                playlists[i] = playlists[i+1];
                            logicalSize--;
                            logicalSizeDel++;
                            System.out.println("Playlist - "+choice+" has been removed");
                            if(logicalSizeDel == 2) { // Will decreace the physical size of the playlist array by 2 when 2 playlists have been deleted 
                                playlists = resize(playlists, false);
                                logicalSizeDel = 0;
                            }
                        }
                        break;

                        case 6: // Delete a movie from a playlist
                        console.nextLine();
                        System.out.println("Pick a playlist to remove a movie from: ");
                        for(int i = 1; i < logicalSize; i++)
                            System.out.println("Playlist - "+i);
                        choice = console.nextInt();
                        if(choice >= logicalSize || choice <= 0)
                            System.out.println("---Sorry this playlist does not exist---");
                        else {
                            System.out.println("You have chosen playlist - "+choice);
                            playlists[choice].displayPlaylist(); // Displays movies in chosen playlist
                            System.out.println("Enter the name of the movie you wish to remove from the playlist: ");
                            console.nextLine();
                            playlists[choice].deleteMovie(console.nextLine()); // Deletes the movie entered from the chosen playlist
                        }
                        break;

                        case 7: // Delete movie from system
                        console.nextLine();
                        database.displayMovies();
                        System.out.println("Enter the name of the movie you wish to remove from the whole system: ");
                        String nameDel = console.nextLine();
                        int position = database.findPosition(nameDel); // Finds position of movie in the databse movie array
                        if(position == -1)
                            System.out.println("---Sorry this movie does not exist---");
                        else {
                            for(int i = 1; i < logicalSize; i++){ // Uses delete from playlist method but for all playlists
                                System.out.println("Playlist "+i+": ");
                                playlists[i].deleteMovie(nameDel); 
                            }
                            System.out.println("Movie Database: "); // Uses delete movie method from the database
                            database.deleteMovie(nameDel);
                        }
                        break;

                        case 8: // Returns to main menu
                        break;

                        default: System.out.println("Invalid Input");
                    }
                } while(option !=8);
                break;

                case 3: // Ends the program from main menu
                System.out.println("Program Shutting Down");
                break;

                default: System.out.println("*Invalid Input*");
            } 
        } while(option !=3);
    }

    public static void main(String[] args)
    {
        /* Will run the interface class in a 'tidy' method */
        Interface intFace = new Interface();
        intFace.run();
    }

    // Method: inputInt
    // Pre-Condition: String prompt and a Scanner console are to be initilised from valid string sentence and Scanner object
    // Post-Condition: (int) Returns the string prompt and a request to enter a new value every time it is entered incorrectly
    // Takes in an input from the user and tests if it is an integer or not. If not the tells the user it is an input mismatch,
    // and asks the user again for the correct value and type to enter
    public static int inputInt(String prompt, Scanner console) {
        System.out.println(prompt);
        try{
            return console.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Input Mismatch! Please enter an integer");
            console.next();
            return inputInt(prompt, console);
        }
    }

    // Method: inputDouble
    // Pre-Condition: String prompt and a Scanner console are to be initilised from valid string sentence and Scanner object
    // Post-Condition: (double) Returns the string prompt and a request to enter a new value every time it is entered incorrectly
    // Takes in an input from the user and tests if it is a double or not. If not the tells the user it is an input mismatch,
    // and asks the user again for the correct value and type to enter
    public static double inputDouble(String prompt, Scanner console) {
        System.out.println(prompt);
        try{
            return console.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Input Mismatch! Please enter a double");
            console.next();
            return inputInt(prompt, console);
        }
    }

    // Method: resize
    // Pre-Condition: A playlist object array and a boolean variable
    // Post-Condition: (Playlist[]) Resizes the playlist object array inputted based on if the boolean variable is true or false
    // A method to resize a playlist object array by 4 positions if true and deducts 2 if flase
    public Playlist[] resize(Playlist[] x, boolean add)
    {
        Playlist[] y;
        if (add){
            y = new Playlist[x.length + 4];
            for(int i = 1; i < x.length; i++)
            {
                y[i] = x[i];
            }
        }
        else {
            y = new Playlist[x.length - 2];
            for(int i = 1; i < x.length-2; i++)
            {
                y[i] = x[i];
            }
        }
        return (y);
    }
}

