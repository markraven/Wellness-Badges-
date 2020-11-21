package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.RoomRepository;
import hu.uni.eku.tzs.dao.entity.Room;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Value("${hotel.roomcount}")
    private int roomCount;

    @Value("${hotel.floors}")
    private int floors;

    @Value("${hotel.room.maxguests}")
    private int maxGuestPerRoom;


    @Override
    @PostConstruct
    public void initializeRooms() {
        if (CollectionUtils.isNotEmpty(roomRepository.findAll())) {
            return;
        }
        Set<Room> rooms = new LinkedHashSet<>();
        for (int f = 1; f <= floors; f++) {
            for (int r = 1; r <= roomCount/floors; r++) {
                rooms.add(new Room(createRoomName(f, r), (int) ((Math.random() * (maxGuestPerRoom - 1)) + 1)));
            }
        }
        for (int r = 1; r <= roomCount % floors; r++) {
            rooms.add(new Room(createRoomName(floors + 1, r), (int) ((Math.random() * (maxGuestPerRoom - 1)) + 1)));
        }
        roomRepository.saveAll(rooms);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findRoomByRoomNumber(String roomNumber) {
        return Optional.of(roomRepository.findByRoomNumber(roomNumber));
    }

    private String createRoomName(int floor, int roomNo) {
        if (roomNo >= 10) {
            return "" + floor + roomNo;
        }
        return floor + "0" + roomNo;
    }
}
