package com.example.shop.service;

import com.example.shop.dtos.ProductDto;
import com.example.shop.models.Product;
import com.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean createProduct(Product product) {
        Product productFromDB = productRepository.findByName(product.getName());

        if (productFromDB != null) {
            return false;
        }

        productRepository.save(product);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> productgtList(Long idMin) {
        return em.createQuery("SELECT u FROM Product u WHERE u.id > :paramId", Product.class)
                .setParameter("paramId", idMin).getResultList();
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);

    }

    private ProductDto toDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
