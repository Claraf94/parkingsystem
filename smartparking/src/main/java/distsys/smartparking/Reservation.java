/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smartparking;

import java.util.UUID;

public class Reservation{
    //declaring variables
    private String userID;
    private String reservationID;
    private String date;
    private String time;

    //constructor()
    public Reservation(String userID, String date, String time) {
        this.userID = userID;
        //creating a new reservationID randomly
        this.reservationID = UUID.randomUUID().toString();
        this.date = date;
        this.time = time;
    }

    //getters e Setters
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //toString method
    @Override
    public String toString() {
        return "Reservation ID: " + reservationID + "\n" +
               "User ID: " + userID + "\n" +
               "Date: " + date + "\n" +
               "Time: " + time;
    }
}
