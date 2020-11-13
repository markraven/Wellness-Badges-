package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findByRoomNumber(String roomNumber);
}
