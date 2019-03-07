package geeks.fr.geeks.linked.list;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static String URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s";
    private static String URL_WITH_PAGE_NO = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%d";

    private static Gson gson = new Gson();

    class MovieDictionary {
        private String page;
        private Integer per_page;
        private Integer total;
        private Integer total_pages;
        private List<Movie> data;

        public MovieDictionary() {
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public Integer getPer_page() {
            return per_page;
        }

        public void setPer_page(Integer per_page) {
            this.per_page = per_page;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(Integer total_pages) {
            this.total_pages = total_pages;
        }

        public List<Movie> getData() {
            return data;
        }

        public void setData(List<Movie> data) {
            this.data = data;
        }
    }

    class Movie {
        private String Poster;
        private String Title;
        private String Type;
        private Integer Year;
        private String imdbID;

        public Movie(){

        }

        public String getPoster() {
            return Poster;
        }

        public void setPoster(String poster) {
            Poster = poster;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public Integer getYear() {
            return Year;
        }

        public void setYear(Integer year) {
            Year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }
    }



    static String[] getMovieTitles(String substr) {
        List<String> movieTitles = new ArrayList<String>();

        MovieDictionary movieDictionary = getMovieDictionaryFromUrl(substr);
        for(int i = 1; i <= movieDictionary.getTotal_pages(); i++){
            MovieDictionary dictionary = getMovieDictionaryFromUrl(substr, i);
            List<Movie> movies = dictionary.getData();

            if(movies!= null && movies.size() > 0){
                for(Movie movie : movies){
                    if(movie.getTitle() != null)
                        movieTitles.add(movie.getTitle());
                }
            }
        }

        Collections.sort(movieTitles);
        return movieTitles.toArray(new String[0]);
    }

    static MovieDictionary getMovieDictionaryFromUrl(String subStr){
        return getMovieDictionaryFromUrl(subStr, null);
    }

    static MovieDictionary getMovieDictionaryFromUrl(String subStr, Integer pageNumber){
        try{
            String urlLink;
            if(pageNumber != null){
                urlLink = String.format(URL_WITH_PAGE_NO, subStr, pageNumber);
            } else {
                urlLink = String.format(URL, subStr);
            }

            URL url = new URL(urlLink);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            return gson.fromJson(sb.toString(), MovieDictionary.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args){
        String[] result = getMovieTitles("spiderman");
        for(String s : result){
            System.out.println(s);
        }
    }
}
