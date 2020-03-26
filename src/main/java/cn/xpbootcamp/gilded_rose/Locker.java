package cn.xpbootcamp.gilded_rose;

public class Locker {
  private int capacity;
  private int availableCapacity;

  public Locker(int capacity) {
    this.capacity = capacity;
    this.availableCapacity = capacity;
  }

  public Ticket store(Parcel parcel) {
    this.availableCapacity = this.availableCapacity - 1;
    return new Ticket();
  }

  public int getAvailableCapacity() {
    return availableCapacity;
  }
}
