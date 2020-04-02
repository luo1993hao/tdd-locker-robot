package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.CollectParcelException;
import cn.xpbootcamp.gilded_rose.exception.StoreParcelException;

import java.util.List;
import java.util.Optional;

public class Robot {

    private List<Locker> lockers;

    public Robot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public List<Locker> getLockers() {
        return lockers;
    }

    public Ticket store(Parcel beStoreParcel) {
        Optional<Locker> firstAvailableLocker = lockers.stream().filter(Locker::isAvailable).findFirst();
        if (firstAvailableLocker.isPresent()) {
            return firstAvailableLocker.get().store(beStoreParcel);
        }
        throw new StoreParcelException("lockers are full");
    }


    public Parcel collect(Ticket ticket) {
        Optional<Parcel> ticketParcel = lockers.stream()
                .filter(x -> x.isTicketValid(ticket))
                .map(x -> x.collect(ticket)).findFirst();
        if (ticketParcel.isPresent()) {
            return ticketParcel.get();
        }
        throw new CollectParcelException("ticket is illegal");
    }
}
