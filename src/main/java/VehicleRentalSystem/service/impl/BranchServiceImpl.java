package VehicleRentalSystem.service.impl;

import VehicleRentalSystem.constant.PricingUnit;
import VehicleRentalSystem.constant.VehicleType;
import VehicleRentalSystem.dto.Pricing;
import VehicleRentalSystem.model.Branch;
import VehicleRentalSystem.repository.InMemoryBranchRepository;
import VehicleRentalSystem.service.BranchService;
import VehicleRentalSystem.util.pricingStrategy.PerBranchPerVehicleTypePricingStrategy;
import VehicleRentalSystem.util.pricingStrategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class BranchServiceImpl implements BranchService {

    InMemoryBranchRepository inMemoryBranchRepository;
    PricingStrategy pricingStrategy;

    public BranchServiceImpl() {
        this.pricingStrategy = new PerBranchPerVehicleTypePricingStrategy(); // Default pricing strategy
        inMemoryBranchRepository = InMemoryBranchRepository.getInstance();
    }

    public BranchServiceImpl(PricingStrategy pricingStrategy) {
        inMemoryBranchRepository = InMemoryBranchRepository.getInstance(); // We can get this from config in real production
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public Branch addBranch(String branchName) {
        Branch branch = new Branch(branchName);
        System.out.println("Branch added: " + branchName);
        return inMemoryBranchRepository.addBranch(branch);
    }

    @Override
    public boolean allocatePrice(String branchName, String vehicleType, float price) {
        Branch branch = inMemoryBranchRepository.getBranchByName(branchName);
        if (branch == null) {
            System.out.println("Branch not found: " + branchName);
            return false;
        }
        Pricing pricing = new Pricing(price, PricingUnit.HOURLY);
        if (branch.getPricing().containsKey(vehicleType)) {
            branch.getPricing().get(vehicleType).add(pricing);
        } else {
            List<Pricing> pricingList = new ArrayList<>();
            pricingList.add(pricing);
            branch.getPricing().put(VehicleType.valueOf(vehicleType), pricingList);
        }
        System.out.println("Price allocated for " + vehicleType + " at " + branchName + ": " + price);
        return true;
    }

    public Branch getBranchByName(String name) {
        return inMemoryBranchRepository.getBranchByName(name);
    }

    // Get All the branches
    public List<Branch> getBranches() {
        return inMemoryBranchRepository.getAllBranches();
    }

}
