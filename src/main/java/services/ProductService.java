package services;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public void getProductName(){
        System.out.println("ipad");
    }

    public void getProductFounder() {
        throw new RuntimeException("I don't know the founder");
    }

//  Design Requirement: Print owner name as "Pichai" no matter what arg passed in
//  Do the above using Aspect class
    public void printOwnerName(String ownerName){
        System.out.println(ownerName);
    }
}
