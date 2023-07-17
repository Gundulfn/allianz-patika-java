package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
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

    public void addDatesToProposal(Proposal proposal, Date startDate, Date endDate, Date expireDate){
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
}
