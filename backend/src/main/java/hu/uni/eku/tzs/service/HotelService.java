package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.controller.dto.BuyDto;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import hu.uni.eku.tzs.controller.dto.ProductServiceDto;
import hu.uni.eku.tzs.controller.dto.ReservationCheckInDto;
import hu.uni.eku.tzs.dao.entity.ProductsServices;
import hu.uni.eku.tzs.model.*;

import java.time.LocalDate;
import java.util.Set;

public interface HotelService {

    ReservationModel bookRoom(LocalDate startDate, LocalDate endDate, int guests);

    Set<GuestDto> checkIn(ReservationCheckInDto reservation);

    InvoiceItem buyProductOrService(BuyDto buyDto);

    Invoice getInvoiceForRoom(Long reservationId);

    ProductsServices addNewBillable(ProductServiceDto productServiceDto);
}
