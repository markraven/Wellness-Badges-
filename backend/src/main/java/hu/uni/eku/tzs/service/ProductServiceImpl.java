package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.ProductServicesRepository;
import hu.uni.eku.tzs.dao.RestrictionRepository;
import hu.uni.eku.tzs.dao.entity.ProductsServices;
import hu.uni.eku.tzs.dao.entity.Restriction;
import hu.uni.eku.tzs.controller.dto.ProductServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final RestrictionRepository restrictionRepository;
    final ProductServicesRepository productServicesRepository;

    @Override
    public ProductsServices addNewBillable(ProductServiceDto productServiceDto) {
        Restriction restriction = restrictionRepository.findAll().stream()
                .filter(restr -> restr.getDescription().equals(productServiceDto.getRestDesc()))
                .findFirst()
                .orElseGet(() -> restrictionRepository.save(
                        new Restriction(0,
                                productServiceDto.getRestDesc(),
                                productServiceDto.getMinAge(),
                                productServiceDto.getErrorMessage() != null ? productServiceDto.getErrorMessage() : String.format("Nem érte el a minimum kort %d", productServiceDto.getMinAge())
                        )
                ));
        ProductsServices productsServices = new ProductsServices();
        productsServices.setName(productServiceDto.getProductName());
        productsServices.setPrice(productServiceDto.getPrice());
        productsServices.setRestriction(restriction);
        return productServicesRepository.save(productsServices);
    }

    @Override
    public List<ProductsServices> getAllProductsOrServices() {
        return productServicesRepository.findAll();
    }

    @Override
    public Optional<ProductsServices> findById(Long id) {
        return productServicesRepository.findById(id);
    }
}
