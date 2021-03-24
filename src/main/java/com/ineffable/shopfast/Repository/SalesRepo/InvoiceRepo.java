package com.ineffable.shopfast.Repository.SalesRepo;

import com.ineffable.shopfast.Models.Sales.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepo extends CrudRepository<Invoice,Long> {
}
