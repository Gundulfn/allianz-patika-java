package filmmanagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Film {
    private String filmName;
    private int publishYear;
    private String director;
    private double imdb;
    private String duration;
    private Set<Category> categoryList = new HashSet<>();
    private Set<Platform> platformList = new HashSet<>();
    private ArrayList<String> showTimeList = new ArrayList<>();

    // get-set functions
    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Set<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Set<Platform> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(Set<Platform> platformList) {
        this.platformList = platformList;
    }

    public ArrayList<String> getShowTimeList() {
        return showTimeList;
    }

    public void setShowTimeList(ArrayList<String> showTimeList) {
        this.showTimeList = showTimeList;
    }

    // addItemToList functions
    public void addCategoryToCategoryList(Category category) {
        this.categoryList.add(category);
    }

    public void addPlatformToPlatformList(Platform platform) {
        this.platformList.add(platform);
    }

    public void addShowTimeToShowTimeList(String showTime) {
        this.showTimeList.add(showTime);
    }

    // Constructors
    public Film() {
    }

    public Film(String filmName, int publishYear, String director, double imdb, String time) {
        this.filmName = filmName;
        this.publishYear = publishYear;
        this.director = director;
        this.imdb = imdb;
        this.duration = time;
    }

    public Film(String filmName, HashSet<Category> categoryList, HashSet<Platform> platformList, ArrayList<String> showTimeList) {
        this.filmName = filmName;
        this.categoryList = categoryList;
        this.platformList = platformList;
        this.showTimeList = showTimeList;
    }

    @Override
    public String toString() {
        return "Film: " + filmName +
                "\n\tPublish Year: " + publishYear +
                "\n\tDirector: " + director +
                "\n\tIMDB: " + imdb +
                "\n\tDuration: " + duration +
                "\n\tCategories: " + categoryList +
                "\n\tPlatforms: " + platformList +
                "\n\tShow Times: " + showTimeList;
    }
}