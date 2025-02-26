import java.util.ArrayList;
import java.util.Scanner;

public class SimpleMovie {
    private String title;
    private String actorsData;
    private ArrayList<String> actors;
    private ArrayList<String> kevinBaconMovies = new ArrayList<>();


    public SimpleMovie(String t, String a) {
        title = t;
        actorsData = a;
        actors = new ArrayList<String>();
        String[] tempActors = actorsData.split(":");
        for (int i = 0; i < tempActors.length; i++) {
            actors.add(tempActors[i]);
        }

    }

    public boolean searchCast(String searchTerm) {
        Scanner scanner = new Scanner(System.in);

        // prevent case sensitivity
        searchTerm = searchTerm.toLowerCase();

        // arraylist to hold search results
        ArrayList<String> results = new ArrayList<String>();

        // search through ALL movies in collection
        for (int i = 0; i < actors.size(); i++) {
            String actorName = actors.get(i);
            actorName = actorName.toLowerCase();

            if (actorName.contains(searchTerm)) {
                //add the Movie objest to the results list
                results.add(actors.get(i));
                return true;
            }
        }
        return false;
    }

    public static ArrayList<SimpleMovie> kevinBaconMovies(){
        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        ArrayList<SimpleMovie> kevinBaconMovies = new ArrayList<SimpleMovie>();

        assert movies != null;
        for (SimpleMovie movie : movies){
            if (movie.searchCast("Kevin Bacon")){
                kevinBaconMovies.add(movie);
            }
        }
        return kevinBaconMovies;
    }

    public static ArrayList<SimpleMovie> specificActorMovies(String actor){
        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        ArrayList<SimpleMovie> actorMovies = new ArrayList<SimpleMovie>();

        assert movies != null;
        for (SimpleMovie movie : movies){
            if (movie.searchCast(actor)){
                actorMovies.add(movie);
            }
        }
        return actorMovies;
    }

    public static boolean actorKevinBaconFirst(String actor){
        ArrayList<SimpleMovie> specificActorMovies = specificActorMovies(actor);
        ArrayList<SimpleMovie> kevinBaconMovies = kevinBaconMovies();

        for (SimpleMovie movie : specificActorMovies){
            for (SimpleMovie movie2 : kevinBaconMovies){
                if (movie == movie2){
                    return true;
                }
            }
        }

        return false;
    }

    public String toString() {
        return "Title: " + title + "\n" + "Actors: " + actors + "\n";
    }
}
