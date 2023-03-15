package com.tasc.productmanagement.Utils;

import java.io.*;

public class FileUtils {
//    public static ArrayList<Product> readFile(){
//        ArrayList<Product> listProducts = new ArrayList<>();
//        try(FileInputStream fileInputStream = new FileInputStream(url);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))){
//            String line = null;
//            while ((line = reader.readLine()) != null){
//                String[] dataline  = line.substring(1,line.length()-1).split(",");
//                int id = Integer.parseInt(dataline[0].split("=")[1]);
//                String name = dataline[1].split("=")[1];
//                String manufacturer = dataline[2].split("=")[1];
//                String model = dataline[3].split("=")[1];
//                double price = Double.parseDouble(dataline[4].split("=")[1]);
//                Product product = new Product(id, name, manufacturer, model, price);
//                listProducts.add(product);
//            }
//            reader.close();
//            return listProducts;
//        } catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }

    public String readFile(String filename){
        try{
            FileReader reader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            String line = buffer.readLine();
            while (line != null){
                builder.append(line).append("\n");
                line = buffer.readLine();
            }
            reader.close();
            return builder.toString();
        } catch (IOException e){
            System.out.println("error file");
        }
        return null;
    }

    public void  writeFile(String filename, String content, boolean overwrite){
        try{
            FileWriter writer = new FileWriter(filename, overwrite);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
