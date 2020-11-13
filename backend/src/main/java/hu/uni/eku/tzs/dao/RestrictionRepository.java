package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictionRepository extends JpaRepository<Restriction, Long> {
}
