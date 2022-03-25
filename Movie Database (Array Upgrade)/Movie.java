/*  Name: Thomas Miller
 *  Student Number: C3279309
 *  Date: 29/05/2017
 *  Lab: C05 - Wednesday, 11-1PM
 *  Task: SENG1110, Programming Assignment 2
 *  Class Name: Movie
 *  Class Description: This class is used to store a movie object including its name, director, size and duration. Also methods working with the actual number of movies currently created
 */
public class Movie {
    private String name, director; 
    private double size; 
    private int duration;
    private static int numberOfMovies = 0;

    // Constructor Method: Movie
    // Pre-Condition: N.A.
    // Post-Condition: (constructor) Initilises the name, director, duration and size of a movie to " " or 0
    // Default constructor of the movie class
    public Movie()
    {
        name = " ";
        director = " ";
        duration = 0;
        size = 0.0;
        Movie.numberOfMovies++; // Incraments the mumber of movies created overall, everytime this method is called
    }

    // Constructor Method: Movie(...)
    // Pre-Condition: A valid String name and director, double file size and integer duration
    // Post-Condition: (constructor) Initilises the name, director, duration and size of a movie to the corrisponding entered values
    // Alternate constructor of the movie class where if called with 4 variables will initilise them to the local variables of a movie
    public Movie(String newName, String newDirector, double newFileSize, int newDuration)
    {
        name = newName;
        director = newDirector;
        duration = newDuration;
        size = newFileSize;
        Movie.numberOfMovies++;
    }

    // Static Method: setMovieCount
    // Pre-Condition: An integer value
    // Post-Condition: (static void) Sets the static number of movies every created to the entered value
    // Static method to re-set the value for the number of movies created. Used to set it to 0 in most cases
    public static void setMovieCount(int value)
    {
        Movie.numberOfMovies = value;
    }

    // Static Method: removeMovieCount
    // Pre-Condition: N.A.
    // Post-Condition: (static void) Removes one from the number of movies entered static variable 
    // Static method to decrement the number of movies by one
    public static void removeMovieCount()
    {
        Movie.numberOfMovies--;
    }

    // Static Method: getNumberOfMovies
    // Pre-Condition: N.A.
    // Post-Condition: (static int) returns the number of movies ever created
    // Static method to return the count for the number of created movies
    public static int getNumberOfMovies()
    {
        return Movie.numberOfMovies;
    }

    // Method: addName
    // Pre-Condition: String newName has been initilised with a valid name
    // Post-Condition: (void) n.a.
    // Will add the name of the movie to the movie object
    public void addName(String newName)
    {
        name = newName;
    }

    // Method: addDirector
    // Pre-Condition: String newDirector has been initilised with a valid director's name
    // Post-Condition: (void) n.a.
    // Will add the name of the director to the movie object
    public void addDirector(String newDirector)
    {
        director = newDirector;
    }

    // Method: addSize
    // Pre-Condition: Double newSize has been initilised with a valid size of the movie
    // Post-Condition: (void) n.a.
    // Will add the size of the movie to the movie object
    public void addSize(double newSize)
    {
        size = newSize;
    }

    // Method: addDuration
    // Pre-Condition: Double newDuration has been initilised with the valid duration of the movie
    // Post-Condition: (void) n.a.
    // Will add the duration of the movie to the movie object
    public void addDuration(int newDuration)
    {
        duration = newDuration;
    }

    // Method: getName
    // Pre-Condition: n.a.
    // Post-Condition: (String) Returns the name of the movie
    public String getName()
    {
        return name;
    }

    // Method: getDirector
    // Pre-Condition: n.a.
    // Post-Condition: (String) Returns the director's name of the movie
    public String getDirector()
    {
        return director;
    }
    // Method: getsize
    // Pre-Condition: n.a.
    // Post-Condition: (double) Returns the size of the movie
    public double getSize()
    {
        return size;
    }
    // Method: getDuration
    // Pre-Condition: n.a.
    // Post-Condition: (double) Returns the duration of the movie
    public int getDuration()
    {
        return duration;
    }

    // Method: toString
    // Pre-Condition: n.a.
    // Post-Condition: (String) Returns the name, director, file size and duration of a movie in a string format with titles for each part
    public String toString()
    {
        return ("Movie title: "+name+System.lineSeparator()+"Director: "+director+System.lineSeparator()+"FileSize: "+size+System.lineSeparator()+"Duration: "+duration);
    }
}
