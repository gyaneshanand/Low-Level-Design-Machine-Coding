package SimpleFulfillmentService.service;

import SimpleFulfillmentService.repository.InventoryRepository;

import java.util.HashMap;

public class InventoryService {

    InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public boolean addInventory(Integer productId, Integer amount){
        return true;
    }

    public boolean removeInventory(Integer productId){
        return true;
    }

    public HashMap<Integer, Integer> viewInventory(Integer inventoryId){

        return null;
    }
}
