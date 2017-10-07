package gui;

import org.nat.lew.entity.Movie;
import org.nat.lew.entity.dao.MovieDAO;
import org.nat.lew.util.HibernateUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by jan on 2017-09-30.
 */
public class AddFilm {

    private JTextField podajTytułFilmuTextField;
    private JTextField textField2;
    private JButton addButton;
    private JButton add2Button;
    private JTextField textField3;
    private JTextField giveYeareTextField;
    private JTextField giveDurationTextField;
    private JTextField giveDirectorTextField;
    private JButton add3Button;
    private JTextField textField4;
    private JTextField textField1;
    private JButton add4Button;
    private JPanel panel;
    private JButton addAMovie;

    public AddFilm() {


        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);
            }
        });


        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        textField4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addAMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovieDAO movieDAO = new MovieDAO();
                Movie film = new Movie();
                film.setTitle(textField3.getText());
                film.setDuration(Integer.valueOf(textField4.getText()));
                film.setYear(LocalDate.parse(textField2.getText()));
                film.setDirector(textField1.getText());

        Integer movieID = movieDAO.addMovie(film);

        Movie dbMovie = movieDAO.getMovie(movieID);
        System.out.println(dbMovie);
                HibernateUtil.getSessionFactory().close();
            }
        });
    }
    public static void main(String[] args) {
        JFrame addFilm = new JFrame("add a movie");
        addFilm.setContentPane(new AddFilm().getPanel());
        //addFilm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addFilm.pack();
        addFilm.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}
