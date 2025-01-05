package VehicleRentalSystem.service;

import VehicleRentalSystem.model.Branch;

import java.util.List;

public interface BranchService {

    public Branch addBranch(String branchName);
    public boolean allocatePrice(String branchName, String vehicleType, float price);
    public Branch getBranchByName(String name);
    public List<Branch> getBranches();
}
