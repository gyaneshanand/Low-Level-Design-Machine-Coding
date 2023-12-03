package LibraryManagementService.model;

import java.util.PriorityQueue;

public class Library {

    String libraryId;
    String name;
    int rack;
    PriorityQueue<Integer> rackQueue;

    public Library(String libraryId) {
        this.name = libraryId;
    }

    public Library(String libraryId, int rack) {
        this.libraryId = libraryId;
        this.rack = rack;
        rackQueue = new PriorityQueue<>();
        addRackToLibrary(rack);
    }

    public void addRackToLibrary(int numRacks){
        for(int i=1; i<=numRacks; i++){
            rackQueue.add(i);
        }
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRack() {
        return rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }

    public PriorityQueue<Integer> getRackQueue() {
        return rackQueue;
    }
}
