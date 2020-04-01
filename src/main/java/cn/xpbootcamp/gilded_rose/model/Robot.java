package cn.xpbootcamp.gilded_rose.model;

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
        throw new StoreParcelException("locker is full");
    }

}
