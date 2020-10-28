package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PutMapping("/book-room")
    public Object bookRoom(@RequestBody Object reservationCreate) {
        return hotelService.bookRoom(reservationCreate);
    }

    @PostMapping("/check-in")
    public Set<Object> checkIn(@RequestBody Object reservationSearch) {
        return hotelService.checkIn(reservationSearch);
    }

    @PostMapping("/buy")
    public Object buy(@RequestBody Object buy) {
        return hotelService.buyProductOrService(buy);
    }

    @GetMapping("/book-out")
    public Object getInvoice(@RequestParam Long reservationId) {
        return hotelService.getInvoiceForRoom(reservationId);
    }

    @PutMapping("/add-product-service")
    public Object addProduct(@RequestBody Object productOrService) {
        return hotelService.addNewBillable(productOrService);
    }

}
