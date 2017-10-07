package gui;

import javax.swing.*;

/**
 * Created by jan on 2017-09-30.
 */
public class Główny_Widok extends JFrame {
    private MovieDetails movieDetails;

    public Główny_Widok() {
        movieDetails = new MovieDetails(this);
        add(movieDetails.getMowieReservation());
    }

    public static void main(String[] args) {
        JFrame główny_widok = new JFrame("Movie Reservation");
        MovieDetails movieDetails= new MovieDetails(główny_widok);
        movieDetails.viewInit();
        główny_widok.setContentPane(movieDetails.getMowieReservation());
        główny_widok.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        główny_widok.pack();
        główny_widok.setVisible(true);

//     MovieDetails menu=new MovieDetails();
//     centreFrame (menu);
//     menu.setV

}}
