package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.StoreParcelException;

public class Locker {
  private int capacity;
  private int availableCapacity;

  public Locker(int capacity, int availableCapacity) {
    this.capacity = capacity;
    this.availableCapacity = availableCapacity;
  }

  public Ticket store(Parcel parcel) {
    if (this.availableCapacity <= 0) {
      throw new StoreParcelException("locker is full");
    }
    this.availableCapacity = this.availableCapacity - 1;
    return new Ticket();
  }

  public int getAvailableCapacity() {
    return availableCapacity;
  }
}
