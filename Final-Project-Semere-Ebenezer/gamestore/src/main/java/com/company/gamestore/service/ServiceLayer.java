package com.company.gamestore.service;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.InvoiceViewModel;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

        @Autowired
        private ConsoleRepository consoleRepo;
        private GameRepository gameRepo;
        private ShirtRepository shirtRepo;
        private InvoiceRepository invoiceRepo;

        public double calculateSubtotal(InvoiceViewModel order) {
            double subtotal = 0;
            if (order.getItemType().equals("game")) {
                subtotal = gameRepo.getOne(order.getItemId()).getPrice() * order.getQuantity();
            } else if (order.getItemType().equals("shirt")) {
                subtotal = shirtRepo.getOne(order.getItemId()).getPrice() * order.getQuantity();
            } else if (order.getItemType().equals("console")) {
                subtotal = consoleRepo.getOne(order.getItemId()).getPrice() * order.getQuantity();
            }
            return subtotal;
        }

        public double calculateTax(InvoiceViewModel order) {
            double tax = 0;
            String state = order.getState();
            double subtotal = calculateSubtotal(order);

            switch(state){
                case "AL":
                case "DE":
                case "HI":
                case "IL":
                case "IN":
                case "LA":
                case "MS":
                case "MO":
                case "NJ":
                case "NM":
                case "NC":
                case "ND":
                case "TN":
                case "WA":
                case "WV":
                case "WY":
                    tax = subtotal * 0.05;
                    break;
                case "AK":
                case "AR":
                case "CA":
                case "FL":
                case "KS":
                case "MI":
                case "MN":
                case "NH":
                case "NY":
                case "PA":
                case "RI":
                case "SC":
                case "SD":
                case "VA":
                    tax = subtotal * 0.06;
                    break;
                case "AZ":
                case "CO":
                case "IA":
                case "KY":
                case "NE":
                case "NV":
                case "OH":
                case "OK":
                case "UT":
                    tax = subtotal * 0.04;
                    break;
                case "CT":
                case "ID":
                case "ME":
                case "MT":
                case "TX":
                case "WI":
                    tax = subtotal * 0.03;
                    break;
                case "GA":
                case "MD":
                case "OR":
                case "VT":
                    tax = subtotal * 0.07;
                    break;
                case "MA":
                    tax = subtotal * 0.0625;
                    break;
            }

            return tax;
        }

        public double calculateProcessingFee(InvoiceViewModel order) {
            switch (order.getItemType()) {
                case "game":
                    return 1.49;
                case "shirt":
                    return 1.98;
                case "console":
                    return 14.99;
            }
            return 0;
        }

        public double calculateTotal (InvoiceViewModel order) {
            double total;
            return total = calculateSubtotal(order) + calculateTax(order) + calculateProcessingFee(order);
        }

        public Invoice createInvoice(InvoiceViewModel order) {

            Invoice invoice = new Invoice();
            invoice.setName(order.getName());
            invoice.setStreet(order.getStreet());
            invoice.setCity(order.getCity());
            invoice.setState(order.getState());
            invoice.setZipcode(order.getZipcode());
            invoice.setItemType(order.getItemType());
            invoice.setItemId(order.getItemId());
            invoice.setQuantity(order.getQuantity());
            invoice.setSubtotal(calculateSubtotal(order));
            invoice.setTax(calculateTax(order));
            invoice.setProcessingFee(calculateProcessingFee(order));
            invoice.setTotal(calculateTotal(order));

            invoiceRepo.save(invoice);
            return invoice;
        }
    }
