package com.ecommerce.productservice.service.impl;

import com.ecommerce.productservice.config.MessagingConfig;
import com.ecommerce.productservice.dto.OrderDTO;
import com.ecommerce.productservice.exception.ProductNotFoundException;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.service.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found")));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        throw new ProductNotFoundException("Product with id " + id + " not found");
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id);
    }

    @RabbitListener(queues = MessagingConfig.ORDER_QUEUE)
    public void processOrderMessage(OrderDTO orderDTO) {

        Long productId = orderDTO.getProductId();
        int orderQuantity = orderDTO.getQuantity();

        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            int currentStock = product.getStock();
            int updatedStock = currentStock - orderQuantity;
            if (updatedStock >= 0) {
                product.setStock(updatedStock);
                productRepository.save(product);
                System.out.println("Product stock updated for product ID: " + productId + ". New stock: " + updatedStock);
            } else {
                System.out.println("Insufficient stock for product ID: " + productId);
            }
        } else {
            System.out.println("Product not found for ID: " + productId);
        }
    }
}
