/*  Name: Thomas Miller
 *  Student Number: C3279309
 *  Date: 18/04/2017
 *  Class Name: Interface
 *  Class Description: This class is used as the interface of the Movie Database project. 
 *                     Everything that is displayed on the screen will appear in this class
 */
import java.util.*;

public class Interface {
    //  Method: run
    //  Controls the flow of the program and has code for accessing the playlists and movie database
    private void run() { 
        Scanner console = new Scanner(System.in);
        MovieDatabase database = new MovieDatabase(); // Creates a new 'MovieDatabase' object called 'database'
        Playlist playlist1 = null; // Initilises both playlist objects to null
        Playlist playlist2 = null;
        int option; // Used for all the switch/case options that the user will type in
        int duration; 
        double fileSize;
        String name, director;
        do { 
            /* Main Menu */
            System.out.println("*************");
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
                    System.out.println("*********************************************");
                    System.out.println("Enter new movie (1)");
                    System.out.println("Display list of movies (2)");
                    System.out.println("Delete a movie (3)");
                    System.out.println("Display list of movies from same director (4)");
                    System.out.println("Main Menu (5)");
                    System.out.println("*********************************************");
                    option = console.nextInt();
                    switch(option)
                    {
                        case 1: // Enters a new movie
                        console.nextLine();
                        System.out.println("Name: ");
                        name = console.nextLine();
                        System.out.println("Director: ");
                        director = console.nextLine();
                        fileSize = inputDouble("File Size (MB): ", console);
                        duration = inputInt("Duration (Min): ", console);
                        /* Sends the 'name, director, filesize and duration to a method in the playlist class */
                        database.addMovie(name, director, fileSize, duration); 
                        /* Prints out whether the movie is a duplicate or not */
                        System.out.println(database.testMovie());
                        break;

                        case 2: // Displays a list of movies
                        System.out.println("All movies currently in the database: ");
                        System.out.println("Name > Director > Size > Duration");
                        /* Prints out a list of all the movies currently in the database */
                        System.out.println(database.getallmoviedata());
                        break;

                        case 3: // Deletes a movie
                        console.nextLine();
                        System.out.println("Enter the name of the movie you wish to remove: ");
                        /* Removes the entered movie from just the movie database */
                        database.removeMovie(console.nextLine());
                        break;

                        case 4: // Sort movies by director
                        String director1 = " ", director2 = " ", director3 = " ", director4 = " ";
                        /* Checks if any of the movies are null before saving the director names to the variables above */
                        if(database.getMovie1() != null)
                            director1 = database.getMovie1().getDirector(); // uses the technique: 'chaining of method calls' 
                        if(database.getMovie2() != null)                    // this calls the object 'movie1' from the database class which then
                            director2 = database.getMovie2().getDirector(); // allows the call to get the director of that movie to be used 
                        if(database.getMovie3() != null)
                            director3 = database.getMovie3().getDirector();
                        if(database.getMovie4() != null)
                            director4 = database.getMovie4().getDirector();
                        console.nextLine();
                        System.out.println("Enter the name of the director you wish to sort by: ");
                        String name1 = console.nextLine();
                        /* Primary chect to see if the director exists first */
                        if((name1.equalsIgnoreCase(director1)) || name1.equalsIgnoreCase(director2) || name1.equalsIgnoreCase(director3) || name1.equalsIgnoreCase(director4)){
                            /* Checks if name1 equals director1 */
                            if(name1.equalsIgnoreCase(director1)) {
                                System.out.println("Movies with the director '" +name1+ "' are: ");
                                System.out.println("Name > Director > Size > Duration");
                                /* Prints the first movie with the same director name as the one entered */
                                System.out.println(database.movie1data());
                                /* Checks the rest of the movies to see if any of the director names match and then prints them */
                                if(director1.equalsIgnoreCase(director2))
                                    System.out.println(database.movie2data());
                                if(director1.equalsIgnoreCase(director3))
                                    System.out.println(database.movie3data());
                                if(director1.equalsIgnoreCase(director4))
                                    System.out.println(database.movie4data());
                                /* Repeats the same process for the other possibilities of matching directors */
                            }else if(name1.equalsIgnoreCase(director2)) {
                                System.out.println("Movies with the director '" +name1+ "' are: ");
                                System.out.println("Name > Director > Size > Duration");
                                System.out.println(database.movie2data());
                                if(director2.equalsIgnoreCase(director1))
                                    System.out.println(database.movie1data());
                                if(director2.equalsIgnoreCase(director3))
                                    System.out.println(database.movie3data());
                                if(director2.equalsIgnoreCase(director4))
                                    System.out.println(database.movie4data());
                            }else if(name1.equalsIgnoreCase(director3)) {
                                System.out.println("Movies with the director '" +name1+ "' are: ");
                                System.out.println("Name > Director > Size > Duration");
                                System.out.println(database.movie3data());
                                if(director3.equalsIgnoreCase(director1))
                                    System.out.println(database.movie1data());
                                if(director3.equalsIgnoreCase(director2))
                                    System.out.println(database.movie2data());
                                if(director3.equalsIgnoreCase(director4))
                                    System.out.println(database.movie4data());   
                            }else if(name1.equalsIgnoreCase(director4)) {
                                System.out.println("Movies with the director '" +name1+ "' are: ");
                                System.out.println("Name > Director > Size > Duration");
                                System.out.println(database.movie4data());
                                if(director4.equalsIgnoreCase(director1))
                                    System.out.println(database.movie1data());
                                if(director4.equalsIgnoreCase(director2))
                                    System.out.println(database.movie2data());
                                if(director4.equalsIgnoreCase(director3))
                                    System.out.println(database.movie4data());
                            }
                        }else 
                            System.out.println("Incorrect name entered");
                        break;   

                        case 5: // Enters the playlist menu
                        break;

                        default: System.out.println("Invalid option");
                    }
                } while(option !=5);
                break;

                case 2: /* Playlists */
                do {
                    /* Playlist Menu */
                    System.out.println("**********************************");
                    System.out.println("Create new playlist (1)");
                    System.out.println("Display list of playlists (2)");
                    System.out.println("Display a specific playlist (3)");
                    System.out.println("Delete a whole playlist (4)");
                    System.out.println("Delete a movie from a playlist (5)");
                    System.out.println("Delete movie from system (6)");
                    System.out.println("Main Menu (7)");
                    System.out.println("**********************************");
                    option = console.nextInt();
                    switch(option)
                    {
                        case 1: // Creates a new playlist
                        if(playlist1 == null) // Will fill 'playlist1' if not null
                        {                     // When a playlist is deleted then this method will allow the empty one to be filled
                            playlist1 = new Playlist(); // Creates a new playlist object
                            /* Sends all the movie objects to the playlist class to be used in other methods there */
                            playlist1.sendMovies(database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4());
                            int option1, option2, option3;
                            System.out.println("Enter three movies to add to a playlist in order: (1, 2, 3 or 4)");
                            System.out.println("You may not enter the same movie twice or a movie that does not exist");
                            System.out.println(database.getallmoviedata1()); // Prints the current movies in a numbered list
                            /* Allows the user to enter three numbers which will be their choice of movies in order */
                            option1 = console.nextInt();
                            if(option1 > 4 || option1 <= 0) { // Checks for invalid inputs i.e. if number is > 4 and > or = 0
                                System.out.println("Invalid Input");
                                playlist1 = null;
                                break;}
                            option2 = console.nextInt();
                            if(option2 > 4 || option2 <= 0) {
                                System.out.println("Invalid Input");
                                playlist1 = null;
                                break;}
                            option3 = console.nextInt();  
                            if(option3 > 4 || option3 <= 0) {
                                System.out.println("Invalid Input");
                                playlist1 = null;
                                break;}
                            /* Sends the selection to the playlist class and saves it in its' database */
                            playlist1.setPlaylist(option1, option2, option3, database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4());              
                            break;
                        } else if(playlist2 == null) { // Same as above but for 'playlist2'
                            playlist2 = new Playlist();
                            playlist2.sendMovies(database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4());
                            int option1, option2, option3;
                            System.out.println("Enter three movies to add to a playlist in order: (1, 2, 3 or 4)");
                            System.out.println("You may not enter the same movie twice or a movie that does not exist");
                            System.out.println(database.getallmoviedata1());
                            option1 = console.nextInt();
                            if(option1 > 4 || option1 <= 0) {
                                System.out.println("Invalid Input");
                                playlist2 = null;
                                break;}
                            option2 = console.nextInt();
                            if(option2 > 4 || option2 <= 0) {
                                System.out.println("Invalid Input");
                                playlist2 = null;
                                break;}
                            option3 = console.nextInt();  
                            if(option3 > 4 || option3 <= 0) {
                                System.out.println("Invalid Input");
                                playlist2 = null;
                                break;}
                            playlist2.setPlaylist(option1, option2, option3, database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4());
                            break;
                        } else {
                            System.out.println("All the playlists are currently full");
                            break;
                        }

                        case 2: // Displays list of playlists
                        if(playlist1 != null) // checks for null playlists to avoid errors 
                        {
                            /* If playlist is created with blank inputs then the method will detect it and not continue */
                            if(playlist1.getPlaylist(database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4()) != "Playlist is currently empty"){
                                System.out.println("Playlist 1");
                                System.out.println("Name > Director > Size > Duration");
                                /* Prints out the ordered list in playlist 1 */
                                System.out.println(playlist1.getPlaylist(database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4()));  
                            } else {
                                playlist1 = null;
                                System.out.println("Playlist 1 is currently empty");}
                        } else {
                            System.out.println("Playlist 1 is currently empty");
                        }
                        if(playlist2 != null) // Same as above but for playlist 2
                        {
                            if(playlist2.getPlaylist(database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4()) != "Playlist is currently empty"){
                                System.out.print("\n");
                                System.out.println("Playlist 2");
                                System.out.println("Name > Director > Size > Duration");
                                System.out.println(playlist2.getPlaylist(database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4()));
                            } else {
                                playlist2 = null;
                                System.out.println("Playlist 2 is currently empty");}
                        } else {
                            System.out.println("Playlist 2 is currently empty");
                        }
                        break;

                        case 3: // Displays a list in a specific playlist
                        int num;
                        System.out.println("Enter the number of the playlist you wish to view: (1 or 2)");
                        num = console.nextInt();
                        /* Will check the number inputted and display only that playlist */
                        if(num == 1) {
                            if(playlist1 != null) {
                                System.out.println("Playlist 1");
                                System.out.println("Name > Director > Size > Duration");
                                System.out.println(playlist1.getPlaylist(database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4()));
                            }
                            else
                                System.out.println("Playlist 1 is currently empty");
                        }
                        else if(num == 2) {
                            if(playlist2 != null) {
                                System.out.println("Playlist 2");
                                System.out.println("Name > Director > Size > Duration");
                                System.out.println(playlist2.getPlaylist(database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4()));
                            }
                            else
                                System.out.println("Playlist 2 is currently empty");
                        }
                        else 
                            System.out.println("Invalid Input");
                        break; 

                        case 4: // Deletes a whole playlist
                        int choice;
                        System.out.println("Enter the number of the playlist you wish to remove: (1 or 2)");
                        choice = console.nextInt();
                        if(choice == 1) {
                            /* If the playlist exists then it will remove it based on the number inputted */
                            if(playlist1 != null) 
                                playlist1 = null;
                            else    
                                System.out.println("Playlist 1 is already empty");
                        } else if(choice == 2) {
                            if(playlist2 != null) 
                                playlist2 = null;
                            else    
                                System.out.println("Playlist 2 is already empty");
                        }
                        else 
                            System.out.println("Invalid Input");
                        break;

                        case 5: // Deletes a movie from a playlist
                        console.nextLine();
                        System.out.println("Enter the name of the movie you wish to remove from a playlist: ");
                        String name2 = console.nextLine();
                        System.out.println("Enter the number of the playlist you wish to remove the movie from: ");
                        int number = console.nextInt();
                        if(number == 1){
                            if(playlist1 != null) 
                            /* Sends the name of the movie to remove to the 'removeMovie' method in the playlist class which removes it from just that playlist */
                                playlist1.removeMovie(name2, database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4());
                            else
                                System.out.println("Playlist 1 is currently empty");
                        } else if(number == 2) {
                            if(playlist2 != null)
                                playlist2.removeMovie(name2, database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4());
                            else
                                System.out.println("Playlist 2 is currently empty");
                        }
                        else 
                            System.out.println("Invalid Input");
                        break;

                        case 6: // Deletes a movie from the movie database and all playlists
                        console.nextLine();
                        System.out.println("Enter the name of the movie you wish to remove: ");
                        String name3 = console.nextLine();
                        /* These are repeted functions from the seperate remove functions above */
                        if(playlist1 != null) {// Removes the movie from playlist 1
                            System.out.println("Playlist 1:");
                            playlist1.removeMovie(name3, database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4());}
                        if(playlist2 != null) { // Removes the movie from playlist 2
                            System.out.println("Playlist 2:");
                            playlist2.removeMovie(name3, database.getMovie1(), database.getMovie2(),database.getMovie3(),database.getMovie4());}
                        if(database.getMovie1() != null || database.getMovie2() != null || database.getMovie3() != null || database.getMovie4() != null) {
                            System.out.println("Movie Database:");    
                            database.removeMovie(name3);} // Removes the movie from the movie database
                        else
                            System.out.println("Sorry this movie does not exist");
                        break;

                        case 7: // Returns to main menu
                        break;

                        default: System.out.println("Invalid option");
                    }
                } while(option !=7);
                break;

                case 3: // Ends the program from main menu
                break;

                default: System.out.println("Invalid option");
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
            System.out.println("Input Mismatch! Please enter Numbers");
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
            System.out.println("Input Mismatch! Please enter Numbers");
            console.next();
            return inputInt(prompt, console);
        }
    }
}

