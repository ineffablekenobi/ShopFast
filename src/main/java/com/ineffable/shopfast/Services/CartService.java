package com.ineffable.shopfast.Services;

import com.ineffable.shopfast.Dto.CheckoutCustomer;
import com.ineffable.shopfast.Dto.CheckoutStaff;
import com.ineffable.shopfast.Dto.RemoveFromCartRequest;
import com.ineffable.shopfast.Dto.addToCartRequest;
import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Sales.Invoice;
import com.ineffable.shopfast.Models.Shop.Cart;
import com.ineffable.shopfast.Models.Shop.Orders;
import com.ineffable.shopfast.Models.Shop.Shop;
import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.Staff;
import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Repository.SalesRepo.InvoiceRepo;
import com.ineffable.shopfast.Repository.ShopRepo.OrderRepo;
import com.ineffable.shopfast.Repository.ShopRepo.ShopRepo;
import com.ineffable.shopfast.Repository.ShopRepo.StaffRepo;
import com.ineffable.shopfast.Repository.UserRepo.CustomerRepo;
import com.ineffable.shopfast.Services.ProductService.ProductService;
import com.ineffable.shopfast.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

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

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Autowired
    private ShopRepo shopRepo;


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


    public Cart removeFromCart(RemoveFromCartRequest request) {
        User user = userService.getUserByID(request.getUserId());
        Cart cart = user.cart;
        for(int i = 0; i < cart.ordersList.size(); i++){
            if(cart.ordersList.get(i).getProductId().equals(request.getProductId())){
                cart.ordersList.remove(i);
                break;
            }
        }
        if(user instanceof Customer){
            customerRepo.save((Customer) user);
        }else if(user instanceof Staff){
            staffRepo.save((Staff) user);
        }

        return cart;
    }

    public Cart getCart(Long userid) {
        return userService.getUserByID(userid).cart;
    }


    public Invoice checkOut(CheckoutCustomer request) {

        //generate invoice
        Invoice invoice = new Invoice(true);
        invoice.setAddreess(request.getCity() +" "+request.getDistrict());
        invoice.setName(request.getName());
        invoice.setPaymentMethod(request.getPaymentMethod());
        invoice.setPhonenumber(request.getPhoneNumber());

        User user = userService.getUserByID(request.getCustomerId());
        Cart cart = user.cart;

        invoice.ordersList = new ArrayList<>();
        invoice.ordersList.addAll(cart.ordersList);

        Map<Long, Invoice> invoices = new HashMap<>();

        for(int i = 0; i < cart.ordersList.size(); i++){
            cart.ordersList.get(i).setConfirmed(true);
            Long orderQuantity = cart.ordersList.get(i).getOrderQuantity();
            Products products = productService.getProductById(cart.ordersList.get(i).getProductId());
            products.updateSold(orderQuantity);
            if(orderQuantity > products.getQuantity()){
                orderQuantity = products.getQuantity();
                cart.ordersList.get(i).setOrderQuantity(orderQuantity);
            }
            products.setQuantity(products.getQuantity() - orderQuantity);
            if(invoices.containsKey(products.getShopId())){
                invoices.get(products.getShopId()).setAddreess(request.getCity() +" "+request.getDistrict());
                invoices.get(products.getShopId()).setName(request.getName());
                invoices.get(products.getShopId()).setPaymentMethod(request.getPaymentMethod());
                invoices.get(products.getShopId()).setPhonenumber(request.getPhoneNumber());
                invoices.get(products.getShopId()).ordersList = new ArrayList<>();
                invoices.get(products.getShopId()).ordersList.add(cart.ordersList.get(i));
            }else{
                invoices.put(products.getShopId(), new Invoice());
                invoices.get(products.getShopId()).setAddreess(request.getCity() +" "+request.getDistrict());
                invoices.get(products.getShopId()).setName(request.getName());
                invoices.get(products.getShopId()).setPaymentMethod(request.getPaymentMethod());
                invoices.get(products.getShopId()).setPhonenumber(request.getPhoneNumber());
                invoices.get(products.getShopId()).ordersList = new ArrayList<>();
                invoices.get(products.getShopId()).ordersList.add(cart.ordersList.get(i));
            }

        }

        Iterator<Long> itr = invoices.keySet().iterator();

        while (itr.hasNext()){
            Long shopID = itr.next();
            Shop shop = shopRepo.findById(shopID).get();
            shop.invoiceList.add(invoices.get(shopID));
            shopRepo.save(shop);
            //invoiceRepo.save(invoices.get(shopID));
        }

        cart.ordersList.clear();
        user.cart = cart;

        Customer cst = (Customer)user;
        cst.invoiceList.add(invoice);
        customerRepo.save(cst);

        //invoiceRepo.save(invoice);

        return invoice;
    }

    public Invoice checkOut(CheckoutStaff request) {

        //generate invoice
        Invoice invoice = new Invoice();
        invoice.setAddreess(request.getCity() +" "+request.getDistrict());
        invoice.setName(request.getName());
        invoice.setPaymentMethod(request.getPaymentMethod());
        invoice.setPhonenumber(request.getPhoneNumber());

        User user = userService.getUserByID(request.getStaffId());
        Cart cart = user.cart;

        invoice.ordersList = new ArrayList<>();
        invoice.ordersList.addAll(cart.ordersList);

        Map<Long, Invoice> invoices = new HashMap<>();

        for(int i = 0; i < cart.ordersList.size(); i++){
            cart.ordersList.get(i).setConfirmed(true);
            Long orderQuantity = cart.ordersList.get(i).getOrderQuantity();
            Products products = productService.getProductById(cart.ordersList.get(i).getProductId());
            products.updateSold(orderQuantity);
            if(orderQuantity > products.getQuantity()){
                orderQuantity = products.getQuantity();
                cart.ordersList.get(i).setOrderQuantity(orderQuantity);
            }
            products.setQuantity(products.getQuantity() - orderQuantity);
            if(invoices.containsKey(products.getShopId())){
                invoices.get(products.getShopId()).setAddreess(request.getCity() +" "+request.getDistrict());
                invoices.get(products.getShopId()).setName(request.getName());
                invoices.get(products.getShopId()).setPaymentMethod(request.getPaymentMethod());
                invoices.get(products.getShopId()).setPhonenumber(request.getPhoneNumber());
                invoices.get(products.getShopId()).ordersList = new ArrayList<>();
                invoices.get(products.getShopId()).ordersList.add(cart.ordersList.get(i));
            }else{
                invoices.put(products.getShopId(), new Invoice());
                invoices.get(products.getShopId()).setAddreess(request.getCity() +" "+request.getDistrict());
                invoices.get(products.getShopId()).setName(request.getName());
                invoices.get(products.getShopId()).setPaymentMethod(request.getPaymentMethod());
                invoices.get(products.getShopId()).setPhonenumber(request.getPhoneNumber());
                invoices.get(products.getShopId()).ordersList = new ArrayList<>();
                invoices.get(products.getShopId()).ordersList.add(cart.ordersList.get(i));
            }

        }

        Iterator<Long> itr = invoices.keySet().iterator();

        while (itr.hasNext()){
            Long shopID = itr.next();
            Shop shop = shopRepo.findById(shopID).get();
            shop.invoiceList.add(invoices.get(shopID));
            shopRepo.save(shop);
            //invoiceRepo.save(invoices.get(shopID));
        }

        cart.ordersList.clear();

        user.cart = cart;

        staffRepo.save((Staff) user);

        invoice.setInvoiceForDB(true);
        invoiceRepo.save(invoice);

        return invoice;
    }


}
