package application;

import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<Product> list = new ArrayList<>();
        
        System.out.print("Quantos produtos: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Product #" + i);
            System.out.print("Product type (A/L/V): ");
            char type = sc.next().charAt(0);
            System.out.print("Product price: ");
            var price = sc.nextDouble();
            System.out.print("It needs to refrigerate (y/n): ");
            char refrigerate = sc.next().charAt(0);

            extracted(list, type, price, refrigerate);

            if(price >= 25) {
                System.out.println("Product with 8% tax.");
                price = price*1.08;

            }
            else{
                System.out.println("Product with 5% tax.");
                price = price*1.05;
            }

        }

        for(Product prod : list) {
            System.out.println("Refrigerate: " + prod.getRefrigerate() + " Product: " + prod.getType() + " Price: " + prod.getPrice() + " Additional Value: " + prod.getAdditionalValue());
            if (prod.getPrice() <= 50) {
                System.out.println("Cheap product");
            }

            if (prod.getPrice() >= 100) {
                System.out.println("Expensive product");
            }

            else {
                System.out.println("Normal product");
            }
        }

        sc.close();
    }

    private static void extracted(List<Product> list, char type, double price, char refrigerate) {
        if(refrigerate == 'n'){
            if(type == 'A') {
                if(price >= 15) {
                    double additionalValue = 2.0;
                    list.add(new Product(price, type, refrigerate, additionalValue));
                }

                else {
                    double additionalValue = 5.0;
                    list.add(new Product(price, type, refrigerate, additionalValue));
                }
            }
            if(type == 'L'){
                if (price < 10){
                    double additionalValue = 1.50;
                    list.add(new Product(price, type, refrigerate, additionalValue));
                }
                if (price >= 10 && price < 30){
                    double additionalValue = 2.50;
                    list.add(new Product(price, type, refrigerate, additionalValue));
                }
                else{
                    double additionalValue = 3.00;
                    list.add(new Product(price, type, refrigerate, additionalValue));
                }
                
            }

            if(type == 'L'){
                if (price >= 30) {
                    double additionalValue = 2.50;
                    list.add(new Product(price, type, refrigerate, additionalValue));
                }
            }

        }

        else {
            if(type == 'A'){
                double additionalValue = 8.0;
                list.add(new Product(price, type, refrigerate, additionalValue));
            }

            else {
                double additionalValue = 0;
                list.add(new Product(price, type, refrigerate, additionalValue));
            }

            
        }
    }
    
}