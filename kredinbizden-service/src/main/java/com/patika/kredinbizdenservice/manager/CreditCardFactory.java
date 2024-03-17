package com.patika.kredinbizdenservice.manager;

import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class CreditCardFactory implements IProductFactory<CreditCard>{
    private List<Campaign> campaignList;
    private List<CreditCard> creditCards;

    public CreditCardFactory() {
        campaignList = new ArrayList<>();
        this.creditCards = new ArrayList<>();
    }
    
    @Override
    public CreditCard createProduct(Object... args) {
        BigDecimal fee = (BigDecimal) args[0];
        CreditCard creditCard = new CreditCard(fee);
        creditCards.add(creditCard);
        return creditCard;
    }

    public List<CreditCard> getProducts(){
        return this.creditCards;
    }
}
