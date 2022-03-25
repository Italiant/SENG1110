/*  Name: Thomas Miller
 *  Student Number: C3279309
 *  Date: 18/04/2017
 *  Class Name: MovieDatabase
 *  Class Description: This class includes methods to add a movie, test one for duplicates, remove a movie, 
 *                     return a list of currently inputted movies, returns indavidual movies and movie objects
 */
public class MovieDatabase
{
    /* This class is able to hold four movie objects at one time which have been set to null */
    private Movie movie1 = null; 
    private Movie movie2 = null; 
    private Movie movie3 = null; 
    private Movie movie4 = null;

    // Method: addMovie
    // Pre-Condition: Strings for new name and director and doubles for new size and duration have been initilised with a valid 
    //                inputs from the user in interface class
    // Post-Condition: (void) Sends the collected data to be stored into a movie object
    // Will send the name, director, size and duration to a movie object
    public void addMovie(String newName, String newDirector, double newSize, int newDuration)
    {
        if (movie1 != null && movie2 != null && movie3 != null && movie4 !=null) // Will check if database is full
            System.out.println("Sorry the movie database is currently full");
        else if(movie1 == null)
        {
            /* Movie 1 */
            movie1 = new Movie(); // Creates a new movie object
            movie1.addName(newName);
            movie1.addDirector(newDirector);
            movie1.addSize(newSize);
            movie1.addDuration(newDuration);
        }
        else if(movie2 == null)
        {
            /* Movie 2 */
            movie2 = new Movie();
            movie2.addName(newName);
            movie2.addDirector(newDirector);
            movie2.addSize(newSize);
            movie2.addDuration(newDuration);
        }
        else if(movie3 == null)
        {
            /* Movie 3 */
            movie3 = new Movie();
            movie3.addName(newName);
            movie3.addDirector(newDirector);
            movie3.addSize(newSize);
            movie3.addDuration(newDuration);
        }
        else if(movie4 == null)
        {
            /* Movie 4 */
            movie4 = new Movie();
            movie4.addName(newName);
            movie4.addDirector(newDirector);
            movie4.addSize(newSize);
            movie4.addDuration(newDuration);
        }
    }

    // Method: testMovie
    // Pre-Condition: n.a. 
    // Post-Condition: (String) Will return the line: "Sorry this movie already exists" if any movies are found to be duplicants
    // Tests for duplicant movie inputs and removes them from the database for all possable combinations
    public String testMovie()
    {
        String name1 = "";
        if(movie1 != null && movie2 != null)
            if(movie1.getName().equalsIgnoreCase(movie2.getName())){ // Compares the string of the name of movie1 to the name
                name1 = "Sorry this movie already exists";           // of movie2
                movie2 = null;} // if they are the same then removes the movie from database
        if(movie1 != null && movie3 != null) 
            if(movie1.getName().equalsIgnoreCase(movie3.getName())){ // Compares for movie1 and movie3
                name1 = "Sorry this movie already exists";
                movie3 = null;}
        if(movie1 != null && movie4 != null)
            if(movie1.getName().equalsIgnoreCase(movie4.getName())){ // movie1 & movie4
                name1 = "Sorry this movie already exists";
                movie4 = null;}
        if(movie2 != null && movie3 != null)
            if(movie2.getName().equalsIgnoreCase(movie3.getName())){ // movie2 & movie3
                name1 = "Sorry this movie already exists";
                movie3 = null;}
        if(movie2 != null && movie4 != null)
            if(movie2.getName().equalsIgnoreCase(movie4.getName())){ // movie2 & movie4 
                name1 = "Sorry this movie already exists";
                movie4 = null;}
        if(movie3 != null && movie4 != null)
            if(movie3.getName().equalsIgnoreCase(movie4.getName())){ // movie3 & movie4
                name1 = "Sorry this movie already exists";
                movie4 = null;}
        return name1;
    }

    // Method: removeMovie
    // Pre-Condition: String name has been initilised with a valid name of a movie
    // Post-Condition: (void) n.a.
    // Will remove a movie from the database based on the name of it entered by the user
    public void removeMovie(String name)
    {
        if(movie1 != null || movie2 != null || movie3 != null || movie4 != null)
            if(movie1 != null && name.equalsIgnoreCase(movie1.getName())){ // Compares the name to the name of movie1
                movie1 = null; // Removes the movie data by setting it to null again 
                System.out.println("Movie removed"); // Tells user that movies has been removed
            } // Same for movie2
            else if(movie2 != null && name.equalsIgnoreCase(movie2.getName())){
                movie2 = null;
                System.out.println("Movie removed");
            }
            else if(movie3 != null && name.equalsIgnoreCase(movie3.getName())){
                movie3 = null;
                System.out.println("Movie removed");
            }
            else if(movie4 != null && name.equalsIgnoreCase(movie4.getName())){
                movie4 = null;
                System.out.println("Movie removed");
            }
            else 
                System.out.println("Sorry this movie does not exist");
    }
    // Method: getallmoviedata
    // Pre-Condition: n.a.
    // Post-Condition: (String) Will return all the data of all the movies currently in the database
    // Returns each movie's name, director, size and duration to the interface class
    public String getallmoviedata()
    {
        String names = " ",
        mov1 = " ",
        mov2 = " ",
        mov3 = " ",
        mov4 = " ";

        /* Returns the name, director, size and duration of that movie from the movie class */
        if (movie1 != null)
            mov1 = (movie1.getName() +" "+ movie1.getDirector() +" "+ movie1.getSize() +" "+ movie1.getDuration());
        if (movie2 != null)
            mov2 = (movie2.getName() +" "+ movie2.getDirector() +" "+ movie2.getSize() +" "+ movie2.getDuration());
        if (movie3 != null)
            mov3 = (movie3.getName() +" "+ movie3.getDirector() +" "+ movie3.getSize() +" "+ movie3.getDuration());
        if (movie4 != null)
            mov4 = (movie4.getName() +" "+ movie4.getDirector() +" "+ movie4.getSize() +" "+ movie4.getDuration());

        names = (mov1 +"\n"+ mov2 +"\n"+ mov3 +"\n"+ mov4); // Creates a string including all of the current movies 

        return names;
    }   

    // Method: movie1data
    // Pre-Condition: n.a.
    // Post-Condition: (String) Just returns the data for movie1
    // Used in the interface class to display the information for each indavidual movie with the same director
    public String movie1data()
    {
        String names = " ",
        mov1 = " ";

        if (movie1 != null)
            mov1 = (movie1.getName() +" "+ movie1.getDirector() +" "+ movie1.getSize() +" "+ movie1.getDuration());

        names = (mov1);

        return names;
    }    

    // Method: movie2data
    // Pre-Condition: n.a.
    // Post-Condition: (String) Just returns the data for movie2
    // Same as movie1data
    public String movie2data()
    {
        String names = " ",
        mov2 = " ";

        if (movie2 != null)
            mov2 = (movie2.getName() +" "+ movie2.getDirector() +" "+ movie2.getSize() +" "+ movie2.getDuration());

        names = (mov2);

        return names;
    }  

    // Method: movie3data
    // Pre-Condition: n.a.
    // Post-Condition: (String) Just returns the data for movie3
    // Same as movie1data
    public String movie3data()
    {
        String names = " ",
        mov3 = " ";

        if (movie3 != null)
            mov3 = (movie3.getName() +" "+ movie3.getDirector() +" "+ movie3.getSize() +" "+ movie3.getDuration());

        names = (mov3);

        return names;
    }  

    // Method: movie4data
    // Pre-Condition: n.a.
    // Post-Condition: (String) Just returns the data for movie4
    // Same as movie1data
    public String movie4data()
    {
        String names = " ",
        mov4 = " ";

        if (movie4 != null)
            mov4 = (movie4.getName() +" "+ movie4.getDirector() +" "+ movie4.getSize() +" "+ movie4.getDuration());

        names = (mov4);

        return names;
    }  

    // Method: getallmoviedata1
    // Pre-Condition: n.a.
    // Post-Condition: (String) Will return all the data of all the movies currently in the database in a numbered list
    // Used in the interface class to display the list of movies (numbered) so the user can select which ones to add to a 
    // playlist in order
    public String getallmoviedata1()
    {
        String names = " ",
        mov1 = " ",
        mov2 = " ",
        mov3 = " ",
        mov4 = " ";

        if (movie1 != null)
            mov1 = (movie1.getName() +" "+ movie1.getDirector() +" "+ movie1.getSize() +" "+ movie1.getDuration());
        if (movie2 != null)
            mov2 = (movie2.getName() +" "+ movie2.getDirector() +" "+ movie2.getSize() +" "+ movie2.getDuration());
        if (movie3 != null)
            mov3 = (movie3.getName() +" "+ movie3.getDirector() +" "+ movie3.getSize() +" "+ movie3.getDuration());
        if (movie4 != null)
            mov4 = (movie4.getName() +" "+ movie4.getDirector() +" "+ movie4.getSize() +" "+ movie4.getDuration());

        names = ("1) "+mov1 +"\n"+ "2) "+mov2 +"\n"+ "3) "+mov3 +"\n"+ "4) "+mov4); // Same as getallmoviedata besides this line which adds the numbers along side each movie

        return names;
    }    

    // Method: getMovie1
    // Pre-Condition: n.a.
    // Post-Condition: (String) Returns the movie object 'movie1'
    public Movie getMovie1()
    {
        return movie1;
    }

    // Method: getMovie2
    // Pre-Condition: n.a.
    // Post-Condition: (String) Returns the movie object 'movie2'
    public Movie getMovie2()
    {
        return movie2;
    }

    // Method: getMovie3
    // Pre-Condition: n.a.
    // Post-Condition: (String) Returns the movie object 'movie3'
    public Movie getMovie3()
    {
        return movie3;
    }

    // Method: getMovie4
    // Pre-Condition: n.a.
    // Post-Condition: (String) Returns the movie object 'movie4'
    public Movie getMovie4()
    {
        return movie4;
    }
}
