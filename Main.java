import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");

        int numTrue = 0;
//        for (SimpleMovie movie : movies) {
//            System.out.println(movie);
//            if (movie.searchCast("Leonardo DiCaprio")){
//                numTrue++;
//            }
//
//        }

        System.out.println(SimpleMovie.kevinBaconMovies());

        System.out.println("NUM TRUE: " + numTrue);
         System.out.println("Number of movies: " + movies.size());


    }
}