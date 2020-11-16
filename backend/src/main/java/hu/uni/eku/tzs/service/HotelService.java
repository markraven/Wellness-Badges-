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

    Set<GuestDto> checkIn(ReservationCheckInDto reservation);

    Purchase buyProductOrService(BuyDto buyDto);

    Invoice getInvoiceForRoom(Long reservationId);

    ProductsServices addNewBillable(ProductServiceDto productServiceDto);

    List<ReservationModel> findAllReservations();
}
