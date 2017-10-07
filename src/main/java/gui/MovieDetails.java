package gui;

import org.nat.lew.entity.Movie;
import org.nat.lew.entity.dao.MovieDAO;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by jan on 2017-09-30.
 */
public class MovieDetails {
    private JPanel mowieReservation;
    private JButton menuButton;
    private JButton logInButton;
    private JButton button2;
    private JButton seansButton;
    private JComboBox menu;
    private JButton go;
    private JPanel panell;
    private JLabel zdj;
    private JList list1;
    private JTextField lookTextField;
    private JList list2;
    private JTextField textField1;
    private JFrame parent;

    MovieDAO movieDAO = new MovieDAO();




    public MovieDetails(JFrame parent) {
        this.parent= parent;

        list2.setModel(new MovieListModel(movieDAO.getMovieList()));


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setContentPane(new AddFilm().getPanel());

                JFrame addFilm = new JFrame("add Film");
                addFilm.setContentPane(new AddFilm().getPanel());
                addFilm.pack();
                addFilm.setVisible(true);
            }
        });

        seansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogIn logIn= new LogIn();
                parent.setContentPane(logIn.getPanel2());

                JFrame logFrame = new JFrame("Log In");
                logFrame.setContentPane(logIn.getPanel2());
                logFrame.pack();
                logFrame.setVisible(true);

            }
        });


        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void viewInit(){
        menu.addItem("Monday");
        menu.addItem("Tuesday");
        menu.addItem("Wedenesday");
        menu.addItem("Thursday");
        menu.addItem("Friday");
        menu.addItem("Saturday");
        menu.addItem("Sunday");

        movieListInit();


        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Repertuar");
        listModel.addElement("Promocje");
        list1.setModel(listModel);
        try {
            String sciezka = "botoks.jpg";
            System.out.println("Scieżka "+sciezka);
            File file = new File(sciezka);
            BufferedImage bi = ImageIO.read(file);
            ImageIcon imgIcon = new ImageIcon(bi);
  Image img = getScaledImage(imgIcon.getImage(),400,200);
            ImageIcon imageIcon =new ImageIcon(img);
            zdj.setIcon(imageIcon);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public JPanel getMowieReservation() {
        return mowieReservation;
    }
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
    private void movieListInit() {
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setCellRenderer(new ListCellRenderer<Movie>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Movie> list, Movie value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel listItem = new JLabel(value.getTitle());
                listItem.setOpaque(true);
                if (isSelected)

                {
                    listItem.setBackground(list.getSelectionBackground());
                    listItem.setForeground(list.getSelectionForeground());
                }
                else
                {
                    listItem.setBackground(list.getBackground());
                    listItem.setForeground(list.getForeground());
                }
                listItem.setFont(list.getFont());
                listItem.setEnabled(list.isEnabled());
                listItem.setMinimumSize(new Dimension(100, 20));
                return listItem;
            }
        });

        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList<Movie> movieList = (JList<Movie>) e.getSource();
                Movie selectedMovie = movieList.getSelectedValue();

               //movieDuration.setText("" + selectedMovie.getDuration());
               //movieDirector.setText(selectedMovie.getDirector());
            }
        });
    }
}



