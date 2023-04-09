package com.company.gamestore.service;

import com.company.gamestore.models.Console;
import com.company.gamestore.models.Game;
import com.company.gamestore.models.Invoice;
import com.company.gamestore.models.Tshirt;
import com.company.gamestore.repositories.*;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Component
public class InvoiceServiceLayer {

    private ConsoleRepository consoleRepository;
    private FeeRepository feeRepository;
    private GameRepository gameRepository;
    private TaxRepository taxRepository;
    private TshirtRepository tshirtRepository;
    private InvoiceRepository invoiceRepository;


    @Autowired
    public InvoiceServiceLayer(
            ConsoleRepository consoleRepository,
            FeeRepository feeRepository,
            GameRepository gameRepository,
            TaxRepository taxRepository,
            TshirtRepository tshirtRepository,
            InvoiceRepository invoiceRepository
    ) {
        this.consoleRepository = consoleRepository;
        this.feeRepository = feeRepository;
        this.gameRepository = gameRepository;
        this.taxRepository = taxRepository;
        this.tshirtRepository = tshirtRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public Invoice saveInvoice(InvoiceViewModel invoiceViewModel) {
        // ensure valid request

        if (invoiceViewModel.getQuantity() == null || invoiceViewModel.getQuantity() < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        // ensure state is valid
        if (invoiceViewModel.getState() == null || invoiceViewModel.getState().length() != 2) {
            throw new IllegalArgumentException("State must be a 2 character abbreviation");
        }

        List<String> validStates =




    }

}
