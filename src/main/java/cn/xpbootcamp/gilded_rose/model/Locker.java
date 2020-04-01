package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.CollectParcelException;
import cn.xpbootcamp.gilded_rose.exception.StoreParcelException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private int availableCapacity;
    private Map<Ticket, Parcel> storeInformation;

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
        this.storeInformation = new HashMap<>();
    }


    public Ticket store(Parcel parcel) {
        if (this.availableCapacity <= 0) {
            throw new StoreParcelException("locker is full");
        }
        this.availableCapacity = this.availableCapacity - 1;
        Ticket ticket = new Ticket();
        storeInformation.put(ticket, parcel);
        return ticket;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public Parcel collect(Ticket ticket) {
        for (Ticket t : storeInformation.keySet()) {
            if (t.getId().equals(ticket.getId())) {
                this.availableCapacity = this.availableCapacity + 1;
                Parcel collectedParcel = storeInformation.get(t);
                storeInformation.remove(t);
                return collectedParcel;
            }
        }
        throw new CollectParcelException("ticket is illegal");
    }
}
