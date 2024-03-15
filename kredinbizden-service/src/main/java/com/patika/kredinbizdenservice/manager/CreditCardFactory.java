package com.patika.kredinbizdenservice.manager;

import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.Product;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class CreditCardFactory implements IProductFactory{
    private BigDecimal fee;
    private List<Campaign> campaignList;

    public CreditCardFactory(BigDecimal fee) {
        this.fee = fee;
        this.campaignList = new ArrayList<>();
    }
    
    @Override
    public Product createProduct() {
        return new CreditCard(fee);
    }
}
