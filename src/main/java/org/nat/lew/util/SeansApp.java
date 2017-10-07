package org.nat.lew.util;

import org.nat.lew.entity.Seans;
import org.nat.lew.entity.dao.SeansDAO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by jan on 2017-09-30.
 */
public class SeansApp {
    public static void main(String[] args) {
        SeansDAO seansDAO = new SeansDAO();
        Seans friday = new Seans();
        friday.setTitle_of_the_movie("Matrix");
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        friday.setDate_time(LocalDateTime.parse("2017-09-30 10:30", dateTimeFormatter));



        Integer seansID = seansDAO.addSeans(friday);

        Seans dbSeans = seansDAO.getSeans(seansID);
        System.out.println(dbSeans);

        seansDAO.deleteSeans(dbSeans);

        HibernateUtil.getSessionFactory().close();
    }
}
