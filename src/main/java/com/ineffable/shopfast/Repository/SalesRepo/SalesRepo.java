package com.ineffable.shopfast.Repository.SalesRepo;

import com.ineffable.shopfast.Models.Sales.SalesReport;
import org.springframework.data.repository.CrudRepository;

public interface SalesRepo extends CrudRepository<SalesReport,Long> {
}
