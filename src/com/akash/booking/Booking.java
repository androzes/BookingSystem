package com.akash.booking;

import java.awt.print.Book;

public class Booking {

   String id;
   int distance;
   BookingStatus status;
   String driverId;

   public Booking(String id, int distance) {
       this.id = id;
       status = BookingStatus.ACCEPTED;
       this.distance = distance;
       driverId = null;
   }

   public void assignDriver(String id) {
       driverId = id;
   }

   public void setStatus(BookingStatus status) {
       this.status = status;
   }

   public boolean isRequestCompleted() {
       return status == BookingStatus.COMPLETED;
   }
}
