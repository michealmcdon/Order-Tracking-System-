//package com.sales.controllers;
//
//import java.util.*;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.sales.models.Product;
//
//public class ProductController {
//
//    @Autowired
//    ProductService ps;
//
//    @RequestMapping(value = "/showProd.html")
//    public String allProducts(Model model) {
//        ArrayList<Product> product = ps.findAll();
//
//        model.addAttribute("product", product);
//
//        return "AllProducts";
//
//    }
//
//    //Get mapping request
//    @RequestMapping(value = "addprod.html", method = RequestMethod.GET)
//    public String addproduct(Model model) {
//        ArrayList<Product> product = ps.findAll();
//        Map<String, Integer> productList = new LinkedHashMap<String, Integer>();
//        for (Product p : product) {
//            productList.put(p.getpDesc(), p.getQtyInStock());
//        }
//
//        model.addAttribute("productList", productList);
//        Product p = new Product();
//        model.addAttribute("nProd", p);
//
//        return "addProduct";
//    }
//
//    @RequestMapping(value = "addprod.html", method = RequestMethod.POST)
//    public String addPersonPost(@ModelAttribute("nProd") @Valid Product p, BindingResult result) {
//        if (result.hasErrors()) {
//            ps.save(p);
//
//            return "redirect:showProd.html";
//        }
//
//        return "index";
//    }
//}
