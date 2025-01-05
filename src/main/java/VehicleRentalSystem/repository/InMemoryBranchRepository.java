package VehicleRentalSystem.repository;

import VehicleRentalSystem.constant.PricingUnit;
import VehicleRentalSystem.constant.VehicleType;
import VehicleRentalSystem.dto.Pricing;
import VehicleRentalSystem.model.Branch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBranchRepository {

    private static Map<Integer, Branch> branches;
    private static InMemoryBranchRepository inMemoryBranchRepository;

    private InMemoryBranchRepository() {
        branches = new HashMap<>();
    }

    public static InMemoryBranchRepository getInstance() {
        if (inMemoryBranchRepository == null) {
            inMemoryBranchRepository = new InMemoryBranchRepository();
        }
        return inMemoryBranchRepository;
    }

    public Branch addBranch(Branch branch) {
        branches.put(branch.getId(), branch);
        return branch;
    }

    // Get branch by id
    public Branch getBranch(int id) {
        return branches.get(id);
    }

    // Get branch by name
    public Branch getBranchByName(String name) {
        return branches.values()
                .stream()
                .filter(branch -> branch.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    // Get All the branches
    public List<Branch> getAllBranches() {
        return new ArrayList<>(branches.values());
    }
}
