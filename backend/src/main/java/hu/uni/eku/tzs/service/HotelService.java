package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.entity.ProductsServices;
import hu.uni.eku.tzs.dao.entity.Purchase;
import hu.uni.eku.tzs.model.*;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface HotelService {

    @ApiOperation("Creates a reservation if there's a free room for the guests")
    ReservationModel bookRoom(LocalDate startDate, LocalDate endDate, int guests);

    @ApiOperation("Check-in to hotel")
    Set<GuestDto> checkIn(ReservationCheckInDto reservation);

    @ApiOperation("A Guest purchases an item or a service")
    Purchase buyProductOrService(BuyDto buyDto);

    @ApiOperation("Get invoice for room")
    Invoice getInvoiceForRoom(Long reservationId);

    @ApiOperation("Add new Product or Service")
    ProductsServices addNewBillable(ProductServiceDto productServiceDto);

    List<ReservationModel> findAllReservations();
}
