package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.entity.ProductsServices;
import hu.uni.eku.tzs.controller.dto.ProductServiceDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductsServices addNewBillable(ProductServiceDto productServiceDto);

    List<ProductsServices> getAllProductsOrServices();

    Optional<ProductsServices> findById(Long id);
}
