package com.example.doan;

import com.example.doan.model.Product;
import com.example.doan.repository.ProductRepository;
import com.example.doan.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static com.example.doan.model.Product.SEQUENCE_NAME;

@SpringBootApplication
public class DoanApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SequenceGeneratorService service;

	public static void main(String[] args) {
		SpringApplication.run(DoanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		try {
//			File file = new File("C:\\Users\\Administrator\\Downloads\\data.csv");
//			FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
//			BufferedReader br = new BufferedReader(fr);
//			String line = "";
//			String[] tempArr;
//			while((line = br.readLine()) != null) {
//				tempArr = line.split(",");
//				if(tempArr.length >1 && !tempArr[0].equals("name")){
//
//					Product product = new Product();
//					product.setId(service.getSequenceNumber(SEQUENCE_NAME));
//					product.setName(tempArr[0]);
//					product.setPrice(Integer.parseInt(tempArr[1]));
//					product.setImg(tempArr[2]);
//					productRepository.save(product);
//				}
//			}
//			br.close();
//		} catch(IOException ioe) {
//			ioe.printStackTrace();
//		}


	}
}
