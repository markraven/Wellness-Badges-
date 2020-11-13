package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.ProductsServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductServicesRepository extends JpaRepository<ProductsServices, Long> {
}
