package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.entity.ProductsServices;
import hu.uni.eku.tzs.dao.entity.Purchase;
import hu.uni.eku.tzs.dao.entity.Reservation;
import hu.uni.eku.tzs.model.*;

import java.time.LocalDate;
import java.util.Set;

public interface HotelService {

    Reservation bookRoom(LocalDate startDate, LocalDate endDate, int guests);

    Set<GuestDto> checkIn(ReservationCheckInDto reservation);

    Purchase buyProductOrService(BuyDto buyDto);

    Invoice getInvoiceForRoom(Long reservationId);

    ProductsServices addNewBillable(ProductServiceDto productServiceDto);
}
