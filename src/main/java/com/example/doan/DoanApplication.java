package com.example.doan;

import com.example.doan.model.Product;
import com.example.doan.repository.ProductRepository;
import com.example.doan.service.SequenceGeneratorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

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
//		ObjectMapper mapper = new ObjectMapper();
//		TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>(){};
//		InputStream inputStream = TypeReference.class.getResourceAsStream("/DATA_FROM_FACEBOOK2.json");
//		try {
//			List<Product> users = mapper.readValue(inputStream,typeReference);
//			productRepository.saveAll(users);
//			System.out.println("Users Saved!");
//		} catch (IOException e){
//			System.out.println("Unable to save users: " + e.getMessage());
//		}

//		try {
//			File file = new File("D:\\DoAnTotNghiep\\crawl_data\\data.csv");
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
//					product.setCategory("cake");
//					productRepository.save(product);
//				}
//			}
//			br.close();
//		} catch(IOException ioe) {
//			ioe.printStackTrace();
//		}


	}
}
