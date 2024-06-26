package com.example.demo.product;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
//@RequestMapping(path = "/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService studentService) {
        this.productService = studentService;
    }

    @GetMapping("/1")
    public String products(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("products", productService.ShowAll(title));
        return "test.html";
    }

    @GetMapping("/")
    public String messageSource(Model model) {
        //Product product = new Product();
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(123L,"1111111","2222222","Test","1234567890",123,213));
        model.addAttribute("products", productList);
        return "messages";
    }

    @GetMapping ("/product/{id}")
    public String infoProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product){
        productService.AddProduct(product);
        return "redirect:/";
    }

    @PostMapping("product/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.DeleteProduct(id);
        return "redirect:/";
    }

}