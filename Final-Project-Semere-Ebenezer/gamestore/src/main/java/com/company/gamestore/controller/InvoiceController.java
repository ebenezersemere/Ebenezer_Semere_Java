package com.company.gamestore.controller;

import com.company.gamestore.service.ServiceLayer;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    private ServiceLayer service;

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody InvoiceViewModel order){
        Invoice newInvoice = service.createInvoice(order);
        return null;
    }

}