package CourtBookingSystem.controller;

import lombok.RequiredArgsConstructor;
import CourtBookingSystem.dto.BookingConfirmationDTO;
import CourtBookingSystem.dto.BookingRequestDTO;
import CourtBookingSystem.model.Booking;
import CourtBookingSystem.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;

    @PostMapping("/create")
    public Booking newBookingRequest(@RequestBody BookingRequestDTO bookingRequest) {
        Long userId = bookingRequest.getUserId();
        Long courtId = bookingRequest.getCourtId();
        LocalDateTime bookingDateTime = LocalDateTime.parse(bookingRequest.getBookingTime());
        return bookingService.newBookingRequest(userId, courtId, bookingDateTime);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PutMapping("/confirm")
    @ResponseStatus(HttpStatus.OK)
    public void confirmBookings(@RequestBody List<BookingConfirmationDTO> requests) {
        for (BookingConfirmationDTO request : requests) {
            bookingService.confirmBooking(request.getBookingId(), request.getConfirmed());
        }
    }





}