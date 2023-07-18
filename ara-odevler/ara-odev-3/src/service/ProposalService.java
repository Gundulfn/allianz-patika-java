package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ProposalService {

    public Proposal createProposal(){
        Proposal proposal = new Proposal();
        return proposal;
    }

    public void addInsuranceCompanyToProposal(Proposal proposal, InsuranceCompany insuranceCompany){
        proposal.setCompany(insuranceCompany);
    }

    public void addVehicleToProposal(Proposal proposal, Vehicle vehicle){
        proposal.setVehicle(vehicle);
    }

    public void addOfferPriceToProposal(Proposal proposal, BigDecimal offerPrice){
        proposal.setOfferPrice(offerPrice);
    }

    public void addDatesToProposal(Proposal proposal, LocalDate startDate, LocalDate endDate, LocalDate expireDate){
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
    }

    public void setIsApprovedStateOfProposal(Proposal proposal, boolean state){
        proposal.setApproved(state);
    }

    public void addDiscountPriceToProposal(Proposal proposal, BigDecimal discountPrice){
        proposal.setDiscountPrice(discountPrice);
    }

    public BigDecimal getDiscountedPrice(Proposal proposal){
        BigDecimal discountedPrice = BigDecimal.ZERO;
        if(proposal.getDiscountPrice() != null){
            discountedPrice = proposal.getOfferPrice();
        }

        if(proposal.getDiscountPrice() != null)
            discountedPrice = discountedPrice.subtract(proposal.getDiscountPrice());

        return discountedPrice;
    }
}
