package com.patika.kredinbizdenservice.manager;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.VehicleLoan;
import java.util.List;
import java.util.ArrayList;

import java.math.BigDecimal;

public class LoanFactory implements IProductFactory<Loan>{
    private LoanType loanType;
    private List<Loan> loans;

    public LoanFactory(LoanType loanType) {
        this.loanType = loanType;
        this.loans = new ArrayList<>();
    }

    @Override
    public Loan createProduct(Object... args) {
        BigDecimal amount = (BigDecimal) args[0];
        Integer installment = (Integer) args[1];
        Double interestRate = (Double) args[2];
       switch(loanType){
        case KONUT_KREDISI:
            HouseLoan houseLoan = new HouseLoan(amount, installment, interestRate);
            loans.add(houseLoan);
            return houseLoan;  
        case IHTIYAC_KREDISI:
            ConsumerLoan consumerLoan = new ConsumerLoan(amount, installment, interestRate);
            loans.add(consumerLoan);
            return consumerLoan; 
        case ARAC_KREDISI:
            VehicleLoan vehicleLoan = new VehicleLoan(amount, installment, interestRate);
            loans.add(vehicleLoan);
            return vehicleLoan; 
        default:
            throw new IllegalArgumentException("Invalid loan type");
        }
       }

    public List<Loan> getProducts(){
        return this.loans;
    }
    
}
