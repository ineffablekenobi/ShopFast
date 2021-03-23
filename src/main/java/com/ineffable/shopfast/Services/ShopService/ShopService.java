package com.ineffable.shopfast.Services.ShopService;

import com.ineffable.shopfast.Models.Shop.Shop;
import com.ineffable.shopfast.Models.Users.Staff;
import com.ineffable.shopfast.Repository.ShopRepo.ShopRepo;
import com.ineffable.shopfast.Repository.ShopRepo.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private StaffRepo staffRepo;

    public Long createShop(Shop shop) {
        return shopRepo.save(shop).getId();
    }

    public List<Shop> getAllShop() {
        List<Shop> list = new ArrayList<>();
        shopRepo.findAll().forEach(list::add);
        return list;
    }

    public Shop findById(Long id) {
        Optional<Shop> shop = shopRepo.findById(id);
        return shop.orElseGet(() -> new Shop("Unknown Shop"));
    }


    public Staff assignStaff(Long staffid, Long shopid) {
        Staff stf  =  staffRepo.findById(staffid).get();
        Shop shop = shopRepo.findById(shopid).get();
        shop.staffList.add(stf);
        shopRepo.save(shop);
        return stf;
    }

    public List<Staff> getStaffs(Long id) {
        return shopRepo.findById(id).get().staffList;
    }
}
