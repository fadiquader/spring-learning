package com.fadiquader.springlearning.api;

import com.fadiquader.springlearning.business.ReservationService;
import com.fadiquader.springlearning.business.RoomReservation;
import com.fadiquader.springlearning.data.Guest;
import com.fadiquader.springlearning.data.Room;
import com.fadiquader.springlearning.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public ReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false)String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("guests")
    public List<Guest> getGusts() {
        return this.reservationService.getHotelGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        this.reservationService.addGuest(guest);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return this.reservationService.getRooms();
    }
}
