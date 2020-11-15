package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.dao.entity.ProductsServices;
import hu.uni.eku.tzs.dao.entity.Purchase;
import hu.uni.eku.tzs.dao.entity.Reservation;
import hu.uni.eku.tzs.model.*;
import hu.uni.eku.tzs.service.HotelService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PutMapping("/book-room")
    public ReservationModel bookRoom(@RequestBody ReservationCreateDto reservationCreateDto) {
        return hotelService.bookRoom(reservationCreateDto.getArrival(), reservationCreateDto.getLeave(), reservationCreateDto.getGuests());
    }

    @PostMapping("/check-in")
    public Set<GuestDto> checkIn(@RequestBody ReservationCheckInDto reservationCheckInDto) {
        return hotelService.checkIn(reservationCheckInDto);
    }

    @PostMapping("/buy")
    public Purchase buy(@RequestBody BuyDto buyDto) {
        return hotelService.buyProductOrService(buyDto);
    }

    @GetMapping("/book-out")
    public Invoice getInvoice(@RequestParam Long reservationId) {
        return hotelService.getInvoiceForRoom(reservationId);
    }

    @PutMapping("/add-product-service")
    public ProductsServices addProduct(@RequestBody ProductServiceDto productServiceDto) {
        return hotelService.addNewBillable(productServiceDto);
    }

    @GetMapping("/reservations")
    @ApiOperation("Get all reservations")
    public List<ReservationModel> findReservations() {
        return  hotelService.findAllReservations();
    }

}
