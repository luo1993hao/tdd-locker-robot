package cn.xpbootcamp.gilded_rose;

public class Locker {
  private int capacity;

  public Locker(int capacity) {
    this.capacity = capacity;
  }

  public Ticket store(Parcel parcel) {
    return new Ticket();
  }
}
