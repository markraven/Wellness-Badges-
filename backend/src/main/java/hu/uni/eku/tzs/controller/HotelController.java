package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.dao.entity.ProductsServices;
import hu.uni.eku.tzs.dao.entity.Purchase;
import hu.uni.eku.tzs.dao.entity.Reservation;
import hu.uni.eku.tzs.model.*;
import hu.uni.eku.tzs.service.HotelService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @ApiOperation("Creates a reservation if there's a free room for the guests")
    @PutMapping("/book-room")
    public Reservation bookRoom(@RequestBody ReservationCreateDto reservationCreateDto) {
        return hotelService.bookRoom(reservationCreateDto.getArrival(), reservationCreateDto.getLeave(), reservationCreateDto.getGuests());
    }

    @ApiOperation("Check-in to hotel")
    @PostMapping("/check-in")
    public Set<GuestDto> checkIn(@RequestBody ReservationCheckInDto reservationCheckInDto) {
        return hotelService.checkIn(reservationCheckInDto);
    }

    @ApiOperation("A Guest purchases an item or a service")
    @PostMapping("/buy")
    public Purchase buy(@RequestBody BuyDto buyDto) {
        return hotelService.buyProductOrService(buyDto);
    }

    @ApiOperation("Get invoice for room")
    @GetMapping("/book-out")
    public Invoice getInvoice(@RequestParam Long reservationId) {
        return hotelService.getInvoiceForRoom(reservationId);
    }

    @ApiOperation("Add new Product or Service")
    @PutMapping("/add-product-service")
    public ProductsServices addProduct(@RequestBody ProductServiceDto productServiceDto) {
        return hotelService.addNewBillable(productServiceDto);
    }

}
