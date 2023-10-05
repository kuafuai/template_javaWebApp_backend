package com.aiassistant.model;

import java.util.List;

public class Invoice {
    private Integer id;
    private String customerName;
    private String customerAddress;
    private String customerContact;
    private List<Item> items;
    private Double totalAmount;

    public Invoice(Integer id, String customerName, String customerAddress, String customerContact, List<Item> items) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
        this.items = items;
        this.totalAmount = calculateTotalAmount();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        this.totalAmount = calculateTotalAmount();
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    private Double calculateTotalAmount() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
