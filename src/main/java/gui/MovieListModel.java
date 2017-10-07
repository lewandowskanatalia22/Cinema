package gui;

import org.nat.lew.entity.Movie;

import javax.swing.*;
import java.util.AbstractList;
import java.util.List;

/**
 * Created by jan on 2017-10-07.
 */
public class MovieListModel extends AbstractListModel<Movie> {

    private List<Movie> movies;

    public MovieListModel(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public int getSize() {
        return movies.size();
    }

    @Override
    public Movie getElementAt(int index) {
        return movies.get(index);
    }
}
