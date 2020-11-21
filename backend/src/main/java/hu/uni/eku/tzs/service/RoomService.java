package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    void initializeRooms();

    List<Room> getAllRooms();

    Optional<Room> findRoomByRoomNumber(String roomNumber);
}
