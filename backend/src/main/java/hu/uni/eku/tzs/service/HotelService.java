package hu.uni.eku.tzs.service;

import io.swagger.annotations.ApiOperation;

import java.util.Set;

public interface HotelService {

    @ApiOperation("Creates a reservation if there's a free room for the guests")
    Object bookRoom(Object reservationCreate);

    @ApiOperation("Check-in to hotel")
    Set<Object> checkIn(Object reservation);

    @ApiOperation("A Guest purchases an item or a service")
    Object buyProductOrService(Object buy);

    @ApiOperation("Get invoice for room")
    Object getInvoiceForRoom(Long reservationId);

    @ApiOperation("Add new Product or Service")
    Object addNewBillable(Object productOrService);
}
