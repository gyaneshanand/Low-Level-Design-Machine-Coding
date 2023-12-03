package LibraryManagementService.service;

import LibraryManagementService.model.Library;

import java.util.PriorityQueue;

public class RackService {

    private Library library;
    private PriorityQueue<Integer> rackQueue;

    public RackService(Library library){
        this.library = library;
        this.rackQueue = library.getRackQueue();
    }

    public int getNextAvailableRack(){
        return rackQueue.poll();
    }

    public boolean emptyRack(int rackId){
        return rackQueue.add(rackId);
    }

    public int getAvaliableRackCount(){
        return rackQueue.size();
    }

}
