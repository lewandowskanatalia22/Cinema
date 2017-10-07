package org.nat.lew.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table( name = "seans")

public class Seans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title_of_the_movie")
    private String title_of_the_movie;

    @Column(name = "date_time")
    private LocalDateTime date_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle_of_the_movie() {
        return title_of_the_movie;
    }

    public void setTitle_of_the_movie(String title_of_the_movie) {
        this.title_of_the_movie = title_of_the_movie;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return "Seans{" +
                "seans=" + id +
                ", title_of_the_movie='" + title_of_the_movie + '\'' +
                ", date_time=" + date_time +
                '}';
    }
}
