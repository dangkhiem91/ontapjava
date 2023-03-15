package com.tasc.productmanagement;
import com.tasc.productmanagement.view.ProductViewImplement;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        ProductViewImplement productViewImplement = new ProductViewImplement();
        productViewImplement.generateMenu();
    }
}