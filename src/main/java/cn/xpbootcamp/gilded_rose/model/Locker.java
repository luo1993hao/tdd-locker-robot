package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.StorePackageException;

public class Locker {
    private int availableCapacity;
    private int totalCapacity;

    public Locker( int totalCapacity) {
        this.availableCapacity = totalCapacity;
        this.totalCapacity = totalCapacity;
    }

    public Ticket store(Package beStoredPackage) {
        if (this.availableCapacity <=0){
            throw new StorePackageException("locker is full");
        }
        this.availableCapacity = this.availableCapacity - 1;
        //todo map ticket and package
        return new Ticket();
    }

    public int getCapacity() {
        return this.availableCapacity;

    }
}
