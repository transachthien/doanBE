package com.example.doan.service;

import com.example.doan.model.Product;
import com.example.doan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.doan.model.Product.SEQUENCE_NAME;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final String[] listKeyword={"Đại Học FPT",
            "FPT University",
            "Trường Đại Học FPT",
            "Trường FPT",
            "Sinh Viên FPT",
            "Students in FPT",
            "Education in FPT University",
            "Technology in FPT University",
            "IT in FPT University",
            "Computer in FPT University",
            "Engineering in FPT University",
            "Programming in FPT University",
            "Software in FPT University",
            "Innovation in FPT University",
            "Campus in FPT University",
            "Study in FPT University",
            "Degree in FPT University",
            "Learning in FPT University",
            "Career in FPT University",
            "Networking in FPT University",
            "Internship in FPT University",
            "Research in FPT University",
            "Skills in FPT University",
            "Academics in FPT University",
            "Students in FPT University",
            "Alumni in FPT University",
            "Industry in FPT University",
            "Partnership in FPT University",
            "Global in FPT University",
            "Opportunities in FPT University",
            "Entrepreneurship in FPT University",
            "Collaboration in FPT University",
            "Projects in FPT University",
            "Digital in FPT University",
            "Development in FPT University",
            "Học phí đại học FPT",
            "Giáo viên đại học FPT",
            "Phòng trọ Đại học FPT",
            "Kí túc xá đại học FPT",
            "Drama đại học FPT",
            "Câu lạc bộ Đại học FPT",
            "Thư viện đại học FPT",
            "Chỗ để xe đại học FPT",
            "Xe bus đại học FPT",
            "Tình nguyện viên đại học FPT",
            "Sự kiện đại học FPT",
            "Vấn đề của sinh viên",
            "Tuyển sinh đại học FPT",
            "Quốc phòng của sinh viên FPT",
            "Thực tập của sinh viên FPT",
            "Coursera của đại học FPT"};
    @Autowired
    private SequenceGeneratorService service;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product addProduct(Product product){
        product.setId(service.getSequenceNumber(SEQUENCE_NAME));

        return productRepository.save(product);
    }
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }
    public Product updateProduct(Product employee){
        return productRepository.save(employee);
    }
    public Product findProduct(Integer id){
        return productRepository.findEmployeeById(id).orElseThrow(()->new ProductNotFoundException("Product by id "+id+"was not found"));
    }
    public String convertStringToId(String keyword){
        String result  = "";
        int count =0;
        for(String key: this.listKeyword){
            count++;
            if(key.equals(keyword)) return result +=count;
        }

        return result;

    }
    @Transactional
    public void deleteProduct(Integer id){
        productRepository.deleteEmployeeById(id);
    }
}
