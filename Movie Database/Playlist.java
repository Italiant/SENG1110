/*  Name: Thomas Miller
 *  Student Number: C3279309
 *  Date: 18/04/2017
 *  Class Name: Playlist
 *  Class Description: This class allows the user to create a ordered playlist from their entered movies via the methods of 
 *                     initilising, returning and removing a playlist. The user can only create two playlists at one time
 */
public class Playlist
{
    private String movie1Data = " ", movie2Data = " ", movie3Data = " ", movie4Data = " ";

    private int totalDuration;
    private double totalSize;

    private String mov1 = "", mov2 = "", mov3 = "";

    // Method: sendMovies
    // Pre-Condition: Four movie objects are to be sent from valid movie objects in the movie class
    // Post-Condition: (void) Sets the data of all the movies to four string variables
    // Inputs the four current movies in the syatem and saves them to four local variables
    public void sendMovies(Movie movie1, Movie movie2, Movie movie3, Movie movie4)
    {
        if(movie1 != null)  // Will only work if the movies are filled/not null
            movie1Data = (movie1.getName() +" "+ movie1.getDirector() +" "+ movie1.getSize() +" "+ movie1.getDuration()); // Saves the name, director, duration and size in one sentence string to the variable movie1Data to be used in the other methods
        if(movie2 != null)
            movie2Data = (movie2.getName() +" "+ movie2.getDirector() +" "+ movie2.getSize() +" "+ movie2.getDuration());
        if(movie3 != null) 
            movie3Data = (movie3.getName() +" "+ movie3.getDirector() +" "+ movie3.getSize() +" "+ movie3.getDuration());
        if(movie4 != null)
            movie4Data = (movie4.getName() +" "+ movie4.getDirector() +" "+ movie4.getSize() +" "+ movie4.getDuration());
    }

    // Method: setPlaylist
    // Pre-Condition: Three integers (1,2,3 or 4) and four movie objects are to be sent from valid movie objects in the movie class
    // Post-Condition: (void) Initilises the order of movies the user has requestesd
    // From the three inputted numbers this method checks first for the first number entered and compares that to all four of the movies
    // entered and then saves that as the string mov1, it then repeats for the next two inputs 
    public void setPlaylist(int num1, int num2, int num3, Movie movie1, Movie movie2, Movie movie3, Movie movie4)
    {
        /* For first number */
        if(num1 == 1)
            mov1 = movie1Data;
        if(num1 == 2)
            mov1 = movie2Data;
        if(num1 == 3)
            mov1 = movie3Data;
        if(num1 == 4)
            mov1 = movie4Data;
        /* For second number */
        if(num2 == 1)
            mov2 = movie1Data;
        if(num2 == 2)
            mov2 = movie2Data;
        if(num2 == 3)
            mov2 = movie3Data;
        if(num2 == 4)
            mov2 = movie4Data;
        /* For third number */
        if(num3 == 1)
            mov3 = movie1Data;
        if(num3 == 2)
            mov3 = movie2Data;
        if(num3 == 3)
            mov3 = movie3Data;
        if(num3 == 4)
            mov3 = movie4Data;
        /* Checks for errors with the numbers */
        if(num1 > 4 || num1 < 0)
            mov1 = (" "); 
        if(num2 > 4 || num2 < 0)
            mov2 = (" ");
        if(num3 > 4 || num3 < 0)
            mov3 = (" ");
    }

    // Method: getPlaylist
    // Pre-Condition: Four movie objects are to be sent from valid movie objects in the movie class
    // Post-Condition: (String) Returns the playlist with the total duration and size
    // Returns the list of the playlist back to the interface class. It can be called for each of the two playlists
    public String getPlaylist(Movie movie1, Movie movie2, Movie movie3, Movie movie4)
    {
        int dur1 = 0, dur2 = 0, dur3 = 0;
        double siz1 = 0, siz2 = 0, siz3 = 0;
        if(mov1 == " " && mov2 == " " && mov3 == " ")
            return ("Playlist is currently empty");
        else
        {
            /* These four blocks of if statements capture the duration and size of each of the movies and then use them in a total calculation */
            if(movie1 != null) {
                if(mov1 == movie1Data)
                {dur1 = movie1.getDuration(); siz1 = movie1.getSize();}
                if(mov2 == movie1Data)
                {dur2 = movie1.getDuration(); siz2 = movie1.getSize();}
                if(mov3 == movie1Data)
                {dur3 = movie1.getDuration(); siz3 = movie1.getSize();}
            }
            if(movie2 != null) {
                if(mov1 == movie2Data)
                {dur1 = movie2.getDuration(); siz1 = movie2.getSize();}
                if(mov2 == movie2Data)
                {dur1 = movie2.getDuration(); siz1 = movie2.getSize();}
                if(mov3 == movie2Data)
                {dur1 = movie2.getDuration(); siz1 = movie2.getSize();}
            }
            if(movie3 != null) {
                if(mov1 == movie3Data)
                {dur2 = movie3.getDuration(); siz2 = movie3.getSize();}
                if(mov2 == movie3Data)
                {dur2 = movie3.getDuration(); siz2 = movie3.getSize();}
                if(mov3 == movie3Data)
                {dur2 = movie3.getDuration(); siz2 = movie3.getSize();}
            }
            if(movie4 != null) {
                if(mov1 == movie4Data)
                {dur3 = movie4.getDuration(); siz3 = movie4.getSize();}
                if(mov2 == movie4Data)
                {dur3 = movie4.getDuration(); siz3 = movie4.getSize();}
                if(mov3 == movie4Data)
                {dur3 = movie4.getDuration(); siz3 = movie4.getSize();}
            }
            totalDuration = dur1 + dur2 + dur3; // Total calculation for duration                                                                                                     
            totalSize = siz1 + siz2 + siz3; // Total calculation for size
            return (mov1 +"\n"+ mov2 +"\n"+ mov3 +"\n"+ "Total Duration = "+ totalDuration +" mins\n"+ "Total Size = "+totalSize +" mbs"); // Prints all three movies in the playlist and then their total duration and size
        }
    }

    // Method: removeMovie
    // Pre-Condition: String name and the four movie objects again are to be initilised from a valid string
    // Post-Condition: (void) Compares and then sets the variables mov1, mov2 or mov3 to just " " thus removing the stored movie in the playlist
    //  Removes a stored movie declared by the user from the playlist
    public void removeMovie(String name, Movie movie1, Movie movie2, Movie movie3, Movie movie4)
    {
        if(movie1 != null || movie2 != null || movie3 != null || movie4 != null)
            if(movie1 != null && name.equalsIgnoreCase(movie1.getName())) {// Compares the inputted name to the name of movie1
                if(mov1 == movie1Data){
                    mov1 = " ";
                    System.out.println("Movie removed");} // Confirmation to the user that the movie has been removed from the playlist
                else if(mov2 == movie1Data){
                    mov2 = " ";
                    System.out.println("Movie removed");}
                else if(mov3 == movie1Data) {
                    mov3 = " ";
                    System.out.println("Movie removed");}
            }
            else if(movie2 != null && name.equalsIgnoreCase(movie2.getName())){
                if(mov1 == movie2Data){
                    mov1 = " ";
                    System.out.println("Movie removed");}
                else if(mov2 == movie2Data){
                    mov2 = " ";
                    System.out.println("Movie removed");}
                else if(mov3 == movie2Data) {
                    mov3 = " ";
                    System.out.println("Movie removed");}
            }
            else if(movie3 != null && name.equalsIgnoreCase(movie3.getName())){
                if(mov1 == movie3Data){
                    mov1 = " ";
                    System.out.println("Movie removed");}
                else if(mov2 == movie3Data){
                    mov2 = " ";
                    System.out.println("Movie removed");}
                else if(mov3 == movie3Data) {
                    mov3 = " ";
                    System.out.println("Movie removed");}
            }
            else if(movie4 != null && name.equalsIgnoreCase(movie4.getName())){
                if(mov1 == movie4Data){
                    mov1 = " ";
                    System.out.println("Movie removed");}
                else if(mov2 == movie4Data){
                    mov2 = " ";
                    System.out.println("Movie removed");}
                else if(mov3 == movie4Data) {
                    mov3 = " ";
                    System.out.println("Movie removed");}
            }
            else 
                System.out.println("Sorry this movie does not exist");
    }
}
