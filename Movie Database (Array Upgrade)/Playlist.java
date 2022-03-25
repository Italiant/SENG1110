/*  Name: Thomas Miller
 *  Student Number: C3279309
 *  Date: 29/05/2017
 *  Lab: C05 - Wednesday, 11-1PM
 *  Task: SENG1110, Programming Assignment 2
 *  Class Name: Playlist
 *  Class Description: This class allows the user to create a playlist from their entered movies via adding a movie into a position in the local movie object array. It also allows the user to display a whole playlist and 
 *                     remove a movie from a playlist
 */
public class Playlist
{
    private int totalTime = 0, logicalSize = 0, logicalSizeDel = 0;
    private double totalSize = 0.0;
    private final int MAX = 4; // The initial number of movies a playlist can hold = 4
    private Movie[] movies = new Movie[MAX]; // Creates a new local movie object array
    private final int MAX_TIME = 1000; // Sets the max time a playlist can hold to 1000 mineutes 
    private final double MAX_SIZE = 20000.0; // Sets the max size a playlist can hold to 20 Gigabytes = 20,000 megabytes 

    // Method: addMovie
    // Pre-Condition: A valid Movie object from the movie database
    // Post-Condition: (void) Adds movie to local movie array, incraments totalTime and totalSize 
    // Method to add a movie into the local movie array from a valid movie in the database. Will not add a movie if the total time or size of the current array is greater than the max time and size 
    public void addMovie(Movie newMovie)
    {
        if(totalTime <= MAX_TIME && totalSize <= MAX_SIZE){ // Test if the current size and duration is less than the max before continuing 
            try // Uses try-catch block to catch the error if needed to resize the local movie array
            {
                movies[logicalSize] = newMovie; // Adds a new movie object
                totalTime += movies[logicalSize].getDuration(); // Incraments totalTime
                totalSize += movies[logicalSize].getSize(); // Incraments totalSize
                logicalSize++;
                System.out.println("Movie successfully added");
            }
            catch(Exception e)
            {
                movies = resize(movies, true); // Will rezise the local movie object array by +4
                movies[logicalSize] = newMovie;
                totalTime += movies[logicalSize].getDuration();
                totalSize += movies[logicalSize].getSize();
                logicalSize++;
                System.out.println("Movie successfully added");
            }
        }
        else
        {
            System.out.println("---Sorry this playlist is currently full---");
            System.out.println("Please delete a movie to continue");
        }
    }

    // Method: resize
    // Pre-Condition: A movie object array and a boolean variable
    // Post-Condition: (Movie[]) Resizes the movie object array inputted based on if the boolean variable is true or false
    // A method to resize a movie object array by 4 positions if true and deducts 2 if flase
    public Movie[] resize(Movie[] x, boolean add)
    {
        Movie[] y;
        if (add == true){ // If the boolean variable is true then increace the playlist by 4 else decreace it by 2
            y = new Movie[x.length + 4];
            for(int i = 0; i < x.length; i++)
            {
                y[i] = x[i];
            }
        }
        else {
            y = new Movie[x.length - 2];
            for(int i = 0; i < x.length-2; i++)
            {
                y[i] = x[i];
            }
        }
        return (y);
    }

    // Method: deletePlaylist
    // Pre-Condition: N.A.
    // Post-Condition: (void) Displays current movie object array
    // Prints out the current movie object array for a playlist by looping until the logical size
    public void displayPlaylist()
    {
        if(logicalSize == 0)
            System.out.println("Playlist is empty");
        else {
            System.out.println("Name - Director - FileSize - Duration");
            for(int i = 0; i < logicalSize; i++) // Displays each movie in the playlist via being less than the logical size
                System.out.println(movies[i].getName() +" - "+ movies[i].getDirector() +" - "+ movies[i].getSize() +"MB - "+ movies[i].getDuration()+"MIN");
            System.out.println("Total Size: "+totalSize+"MB"); // Prints out the total size and time of the playlist
            System.out.println("Total Duration: "+totalTime+"MIN"); 
        }
    }

    // Method: deleteMovie
    // Pre-Condition: A valid String for the name of a movie
    // Post-Condition: (void) Removies the movie from the local movie object arrya
    // Method to delete a movie from a playlist if the name entered is equal to an existing movie name in the array, otherwise displays that it is not in the playlist yet
    public void deleteMovie(String name)
    {
        int position;
        for(int i = 0; i < logicalSize; i++) { // Loops through the logical size of the current movie array
            if(name.equalsIgnoreCase(movies[i].getName())) { // If the name entered matches a name of any movie in the playlist then removie it
                totalTime -= movies[i].getDuration(); // Reduces the total time and size of the playlist
                totalSize -= movies[i].getSize();
                position = i;
                for(int k = position; k < logicalSize-1; k++) // Resizes the playlist now the movie has been removed from a position in the array
                    movies[k] = movies[k+1];
                System.out.println("Movie removed from playlist");
                logicalSize--;
                logicalSizeDel++;
                if(logicalSizeDel == 2) {
                    movies = resize(movies, false); // Will decreace the array by -2
                    logicalSizeDel = 0; 
                }
            }
        }
    }
}
