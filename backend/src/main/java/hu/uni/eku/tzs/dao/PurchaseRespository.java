package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Guest;
import hu.uni.eku.tzs.dao.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PurchaseRespository extends JpaRepository<Purchase, Long> {

    Set<Purchase> findAllByGuestIsIn(Set<Guest> guests);
}
