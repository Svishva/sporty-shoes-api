package com.sportyshoes.services;

import static com.sportyshoes.utils.CollectionUtils.isEmpty;
import static com.sportyshoes.utils.RandomDataGeneratorUtil.getUniqueId;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sportyshoes.daos.ProductDao;
import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.exceptions.MyResourceNotCreatedException;
import com.sportyshoes.exceptions.MyResourceNotDeletedException;
import com.sportyshoes.exceptions.MyResourceNotFoundException;
import com.sportyshoes.exceptions.MyResourceNotUpdatedException;
import com.sportyshoes.models.Product;

@Component
public class ProductService {

	private ProductDao productDao;

	public ProductService(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	public List<Product> getAllProducts() throws MyResourceNotFoundException {
		try {
			List<Product> products = this.productDao.getAllProducts();

			if (products == null || products.isEmpty()) {
				throw new MyResourceNotFoundException("No Product found");
			}
			return products;
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("Something went wrong when fetching the Product record!");
		}
	}

	public List<Product> searchProductByName(String name) throws MyResourceNotFoundException {
		try {

			List<Product> products = this.productDao.searchProductByName(name);

			if (products == null || products.isEmpty()) {
				throw new MyResourceNotFoundException("No Product found");
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("No Records Found!");
		}
	}

	public List<Product> searchProductByProductId(String productId) throws MyResourceNotFoundException {
		try {

			List<Product> products = this.productDao.searchProductByProductId(productId);

			if (products == null || products.isEmpty()) {
				throw new MyResourceNotFoundException("No Product found");
			}

			return products;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("No Records Found!");
		}
	}

	public void addProduct(Product product) throws MyResourceNotCreatedException {
		try {

			if (product != null && product.getProductId() == null) {
				product.setProductId(getUniqueId());
			}
			Integer recordsInserted = this.productDao.addProduct(product);

			if (recordsInserted == 0) {
				throw new MyResourceNotCreatedException("Could not create new product record!");
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotCreatedException("Something went wrong when creating new product record!");
		}
	}

	public void updateProduct(Product product) throws MyResourceNotFoundException, MyResourceNotUpdatedException {
		try {
			Product productOld = searchProductByProductId(product.getProductId()).get(0);
			if (productOld == null) {
				throw new MyResourceNotFoundException(
						String.format("No product found with ID %s!", product.getProductId()));
			}

			if (product.getName() != null) {
				productOld.setName(product.getName());
			}

			if (product.getMsrp() != null) {
				productOld.setMsrp(product.getMsrp());
			}

			if (product.getQuantityInStock() != null) {
				productOld.setQuantityInStock(product.getQuantityInStock());
			}

			if (product.getProductVendor() != null) {
				productOld.setProductVendor(product.getProductVendor());
			}

			Integer recordsUpdated = this.productDao.updateProduct(productOld);
			if (recordsUpdated == 0) {
				throw new MyResourceNotUpdatedException(
						String.format("Details of Product with ID %s not updated!", product.getProductId()));
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotUpdatedException("Something went wrong when updating the Product record");
		}
	}

	public void deleteProduct(String productId) throws MyResourceNotDeletedException {
		try {

			if (isEmpty(productId)) {
				throw new Exception("Invalid Request");
			}

			Integer recordsDeleted = this.productDao.deleteProductById(productId);
			if (recordsDeleted == 0) {
				throw new MyResourceNotDeletedException(
						String.format("PRODUCT record with ID %d not deleted!", productId));
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotDeletedException("Something went wrong when deleting the PRODUCT record");
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyResourceNotDeletedException("Something went wrong when deleting the PRODUCT record");
		}

	}

}
