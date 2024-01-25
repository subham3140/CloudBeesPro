package com.cloudbees.ecommerce.app;

import com.cloudbees.ecommerce.app.model.Product;
import com.cloudbees.ecommerce.app.pojoModel.Discount;
import com.cloudbees.ecommerce.app.pojoModel.Tax;
import com.cloudbees.ecommerce.app.repository.ProductRepository;
import com.cloudbees.ecommerce.app.service.ProductService;
import com.cloudbees.ecommerce.app.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ECommerceAppApplicationTests {

	/**
	 * Testing Method Configuration;
	 **/
	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public ProductService productService() {
			return new ProductServiceImpl();
		}
	}

	@MockBean
	private ProductRepository productRepository;

	@Autowired
	private  ProductService productService;

	/**
	 * Testing Method To Create Product Data;
	 **/
	@Test
	public void whenCreated_thenReturnProduct() {
		Product product = new Product(1L, "CloudBees CI", "Turn Jenkins into a resilient, scalable, governed CI ", 1000000.0, 10);
		Mockito.when(productRepository.save(product))
				.thenReturn(product);
		Product found = productService.createProduct(product);

		assertThat(found)
				.isEqualTo(product);
	}

	/**
	 * Testing Method To Update Product Data;
	 **/
	@Test
	public void whenUpdate_thenReturnProduct() {
		Product product = new Product(1L, "CloudBees CI", "Turn Jenkins into a resilient, scalable, governed CI ", 1000000.0, 10);
		Mockito.when(productRepository.findByProductId(1L))
				.thenReturn(Stream.of(product).collect(Collectors.toList()));
		Product updatedProduct = new Product(1L, "CloudBees CI", "Turn Jenkins into a resilient, scalable, governed CI ", 2000000.0, 10);
		Mockito.when(productRepository.save(any()))
				.thenReturn(updatedProduct);
		product.setPrice(2000000.0);
		Product found = productRepository.save(product);
		assertThat(product.getPrice())
				.isEqualTo(updatedProduct.getPrice());

	}

	/**
	 * Testing Method To Fetch Product Data;
	 **/
	@Test
	public void whenFindById_thenReturnProduct() {

		Long id = 1L;
		Mockito.when(productRepository.findByProductId(id))
				.thenReturn(Stream.of(new Product(1L, "CloudBees CI", "Turn Jenkins into a resilient, scalable, governed CI ", 1000000.0, 10)).collect(Collectors.toList()));
		Product found = productService.getProduct(1L);

		assertThat("CloudBees CI")
				.isEqualTo(found.getName());
	}


	/**
	 * Testing Method To Apply Discount On Product Data;
	 **/
	@Test
	public void whenApplyDiscount_thenReturnUpdatedProduct() {

		Long id = 1L;
		Mockito.when(productRepository.findByProductId(id))
				.thenReturn(Stream.of(new Product(1L, "CloudBees CI", "Turn Jenkins into a resilient, scalable, governed CI ", 1000000.0, 10)).collect(Collectors.toList()));

		Product product = productService.getProduct(1L);
		Discount discount = new Discount(10);

		Product found = productService.applyDiscount(discount, product);

		assertThat(900000.0)
				.isEqualTo(found.getPrice());
	}



	/**
	 * Testing Method To Apply Tax On Product Data;
	 **/
	@Test
	public void whenApplyTax_thenReturnUpdatedProduct() {

		Long id = 1L;
		Mockito.when(productRepository.findByProductId(id))
				.thenReturn(Stream.of(new Product(1L, "CloudBees CD", "Securely unite and advance DevOps teams, tools, and workflows across the enterprise. ", 2000000.0, 5)).collect(Collectors.toList()));

		Product product = productService.getProduct(1L);
		Tax tax = new Tax(10);

		Product found = productService.applyTax(tax, product);

		assertThat(2200000.0)
				.isEqualTo(found.getPrice());
	}


	/**
	 * Testing Method To Delete Product Data;
	 **/
	@Test
	public void whenDelete_thenReturnDeletedProduct() {

		Product product = new Product(1L, "CloudBees CI", "Turn Jenkins into a resilient, scalable, governed CI ", 1000000.0, 10);
		Mockito.when(productRepository.findByProductId(product.getProductId()))
				.thenReturn(Stream.of(product).collect(Collectors.toList()));

		productService.deleteProduct(product.getProductId());
		verify(productRepository, times(1)).delete(product);
	}

}
