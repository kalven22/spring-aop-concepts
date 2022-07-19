package org.kalven22;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var productService = context.getBean(ProductService.class);

        //calling pojo methods
        productService.getProductName();
        System.out.println("------------------");

        try {
            productService.getProductFounder();
        } catch (Exception e) {
            System.out.println("Exception Raised: " + e.getMessage());
        }
        System.out.println("------------------");

        productService.printOwnerName("Raj");
        System.out.println("------------------");
    }
}