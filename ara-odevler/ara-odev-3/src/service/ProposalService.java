package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProposalService {

    VehicleService vehicleService = new VehicleService();

    final BigDecimal FIRST_DAMAGE_PRICE_RATE = BigDecimal.valueOf(0.1d);
    final BigDecimal SECOND_DAMAGE_PRICE_RATE = BigDecimal.valueOf(0.4);
    final BigDecimal FINAL_DAMAGE_PRICE_RATE = BigDecimal.valueOf(0.8);
    final BigDecimal FIRST_DAMAGE_PRICE_LIMIT = new BigDecimal(4000);
    final BigDecimal SECOND_DAMAGE_PRICE_LIMIT = new BigDecimal(8000);

    public Proposal createProposal() {
        Proposal proposal = new Proposal();
        return proposal;
    }

    public void addInsuranceCompanyToProposal(Proposal proposal, InsuranceCompany insuranceCompany) {
        proposal.setCompany(insuranceCompany);
    }

    public void addVehicleToProposal(Proposal proposal, Vehicle vehicle) {
        proposal.setVehicle(vehicle);
    }

    public void addOfferPriceToProposal(Proposal proposal, BigDecimal offerPrice) {
        BigDecimal vehicleTotalDamagePrice = vehicleService.getTotalAccidentDamagePrice(proposal.getVehicle());
        offerPrice = calculateOfferPriceAccordingToAccidentDamage(offerPrice, vehicleTotalDamagePrice);

        proposal.setOfferPrice(offerPrice);
    }

    private BigDecimal calculateOfferPriceAccordingToAccidentDamage(BigDecimal offerPrice, BigDecimal accidentDamage) {
        if (accidentDamage.compareTo(BigDecimal.ZERO) >= 0
                && accidentDamage.compareTo(FIRST_DAMAGE_PRICE_LIMIT) <= 0) {
            offerPrice = offerPrice.add(offerPrice.multiply(FIRST_DAMAGE_PRICE_RATE));
        } else if (accidentDamage.compareTo(FIRST_DAMAGE_PRICE_LIMIT) > 0
                && accidentDamage.compareTo(SECOND_DAMAGE_PRICE_LIMIT) <= 0) {
            offerPrice = offerPrice.add(offerPrice.multiply(SECOND_DAMAGE_PRICE_RATE));
        } else{
            offerPrice = offerPrice.add(offerPrice.multiply(FINAL_DAMAGE_PRICE_RATE));
        }

        return BigDecimalRoundService.round(offerPrice);
    }

    public void addDatesToProposal(Proposal proposal, LocalDate startDate, LocalDate endDate, LocalDate expireDate) {
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
    }

    public void setIsApprovedStateOfProposal(Proposal proposal, boolean state) {
        proposal.setApproved(state);
    }

    public void addDiscountPriceToProposal(Proposal proposal, BigDecimal discountPrice) {
        proposal.setDiscountPrice(discountPrice);
    }

    public BigDecimal getDiscountedPrice(Proposal proposal) {
        BigDecimal discountedPrice = BigDecimal.ZERO;
        if (proposal.getDiscountPrice() != null) {
            discountedPrice = proposal.getOfferPrice();
        }

        if (proposal.getDiscountPrice() != null)
            discountedPrice = discountedPrice.subtract(proposal.getDiscountPrice());

        return discountedPrice;
    }
}
