package com.ineffable.shopfast.Services.ShopService;

import com.ineffable.shopfast.Models.Users.Staff;
import com.ineffable.shopfast.Repository.ShopRepo.StuffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuffService {
    @Autowired
    private StuffRepo stuffRepo;

    public List<Staff> getAllStuff() {
        List<Staff> list = new ArrayList<>();
        stuffRepo.findAll().forEach(list::add);
        return list;
    }

    public Long createStuff(Staff staff) {
        return stuffRepo.save(staff).getId();
    }
}
