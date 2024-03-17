package com.patika.kredinbizdenservice.manager;
import java.util.List;
public interface IProductFactory<T> {
   T createProduct(Object... args);
   List<T> getProducts();
}
