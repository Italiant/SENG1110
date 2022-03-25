/*  Name: Thomas Miller
 *  Student Number: C3279309
 *  Date: 18/04/2017
 *  Class Name: Movie
 *  Class Description: This class is used to store a movie object including its name, director, size and duration
 */
public class Movie
{
    private String name, director; 
    private double size; 
    int duration;

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
}
