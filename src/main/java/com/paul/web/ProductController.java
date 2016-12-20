package com.paul.web;

import com.paul.domain.Product;
import com.paul.domain.User;
import com.paul.service.def.ProductService;
import com.paul.service.def.UserHelper;
import com.paul.web.exception.ItemNotFoundException;
import com.paul.web.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by paulzhang on 15/12/2016.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserHelper userHelper;

    @GetMapping
    public String showAllProducts(@PageableDefault(size = 15, sort = {"createDate"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) throws Exception {
        User user = userHelper.getUserFromAuthentication();
        Page<Product> productPage = productService.findAll(user, pageable);
        model.addAttribute("productPage", productPage);

        return "productList";
    }

    @GetMapping(value = "/{productId}")
    public String showOneProduct(@PathVariable Long productId, Model model) throws Exception {
        Product product = productService.findById(productId);
        User user = userHelper.getUserFromAuthentication();
        if (null == product) throw new ItemNotFoundException("Product with id: " + productId + " does not exist.");
        else model.addAttribute("product", product);
        if (product.getUser().getId() != user.getId()) throw new UnauthorizedException("Authentication needed");

        return "productDetail";
    }

    @GetMapping(value = "/{productId}/modify")
    public String modifyOneProduct(@PathVariable Long productId, Model model) throws Exception {
        Product product = productService.findById(productId);
        User user = userHelper.getUserFromAuthentication();
        if (null == product) throw new ItemNotFoundException("Product with id: " + productId + " does not exist.");
        else model.addAttribute("product", product);
        if (product.getUser().getId() != user.getId()) throw new UnauthorizedException("Authentication needed");

        return "productCreateModify";
    }

    @PostMapping(value = "/{productId}/modify")
    public String modifyOneProductOnSubmit(@PathVariable Long productId, @ModelAttribute @Valid Product product, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) return "productModify";
        User user = userHelper.getUserFromAuthentication();
        Product originalProduct = productService.findById(productId);

        if (null == originalProduct) throw new ItemNotFoundException("Product with id: " + productId + "does not exist.");
        if (originalProduct.getUser().getId() != user.getId()) throw new UnauthorizedException("Authentication needed");

        originalProduct.setLastModifyDate(new Date());
        originalProduct.setProductName(product.getProductName());
        originalProduct.setSpecs(product.getSpecs());
        originalProduct.setComment(product.getComment());
        originalProduct.setMarketPrice(product.getMarketPrice());
        originalProduct.setRetailPrice(product.getRetailPrice());

        productService.save(originalProduct);

        return "redirect:/product/" + productId;
    }

    @GetMapping
    public String showCreateNewProduct() {
        return "productCreateModify";
    }

    @PostMapping
    public String createNewProductOnSubmit(@ModelAttribute @Valid Product product, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) return "productCreate";
        User user = userHelper.getUserFromAuthentication();

        product.setUser(user);
        product.setCreateDate(new Date());

        productService.save(product);

        long id = product.getId();

        return "redirect:/product/" + id;
    }

    @GetMapping(value = "/{productId/delete}")
    public String deleteOneProduct(@PathVariable Long productId) throws Exception {
        Product product = productService.findById(productId);
        User user = userHelper.getUserFromAuthentication();
        if (null == product) throw new ItemNotFoundException("Product with id: " + productId + " does not exist.");
        if (product.getUser().getId() != user.getId()) throw new UnauthorizedException("Authentication needed");
        productService.delete(product);

        return "productList";
    }
}
