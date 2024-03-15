package com.patika.kredinbizdenservice.manager;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.Product;
import com.patika.kredinbizdenservice.model.VehicleLoan;

import java.math.BigDecimal;

public class LoanFactory implements IProductFactory{
    private BigDecimal amount;
    private Integer installment;
    private Double interestRate;
    private LoanType loanType;

    public LoanFactory(BigDecimal amount, Integer installment, Double interestRate, LoanType loanType) {
        this.amount = amount;
        this.installment = installment;
        this.interestRate = interestRate;
        this.loanType = loanType;
    }

    @Override
    public Product createProduct() {
       switch(loanType){
        case KONUT_KREDISI:
            return new HouseLoan(amount, installment, interestRate);
        case IHTIYAC_KREDISI:
            return new ConsumerLoan(amount, installment, interestRate);
        case ARAC_KREDISI:
            return new VehicleLoan(amount, installment, interestRate);
        default:
            throw new IllegalArgumentException("Invalid loan type");
        }
       }
    
}
