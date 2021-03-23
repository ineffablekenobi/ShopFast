package com.ineffable.shopfast.Services;

import com.ineffable.shopfast.Dto.addToCartRequest;
import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Shop.Cart;
import com.ineffable.shopfast.Models.Shop.Orders;
import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.Staff;
import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Repository.ShopRepo.OrderRepo;
import com.ineffable.shopfast.Repository.ShopRepo.StaffRepo;
import com.ineffable.shopfast.Repository.UserRepo.CustomerRepo;
import com.ineffable.shopfast.Services.ProductService.ProductService;
import com.ineffable.shopfast.Services.UserService.CustomerService;
import com.ineffable.shopfast.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;

@Service
public class addToCartService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private StaffRepo staffRepo;

    public Cart addToCart(addToCartRequest request) {
        User user = userService.getUserByID(request.getUserId());
        Cart cart = user.cart;
        if(cart == null){
            cart = new Cart();
        }

        boolean exist = false;
        int index = -1;
        for(int i = 0; i< cart.ordersList.size(); i++){
            Orders order = cart.ordersList.get(i);
            if(order.getProductId().equals(request.getOrders().getProductId())){
                index = i;
                exist = true;
                break;
            }
        }

        if(exist){
            cart.ordersList.get(index).setOrderQuantity(request.getOrders().getOrderQuantity());
            orderRepo.save(cart.ordersList.get(index));
        }else {
            Orders order = orderRepo.save(request.getOrders());
            cart.ordersList.add(order);
        }
        user.cart = cart;

        if(user instanceof Customer){
            customerRepo.save((Customer) user);
        }else if( user instanceof Staff){
            staffRepo.save((Staff) user);
        }

        return cart;
    }
}
