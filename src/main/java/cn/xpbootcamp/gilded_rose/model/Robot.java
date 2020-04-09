package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.CollectParcelException;
import cn.xpbootcamp.gilded_rose.exception.StoreParcelException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Robot {

  private List<Locker> lockers;

  public Robot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  public List<Locker> getLockers() {
    return lockers;
  }

  public Ticket store(Parcel beStoreParcel) {
    List<Locker> comparedList = lockers.stream()
      .sorted((Comparator<Locker>) (o1, o2) -> o2.getAvailableCapacity() - o1.getAvailableCapacity())
      .collect(Collectors.toList());
    Optional<Locker> firstAvailableLocker = comparedList.stream().filter(Locker::isAvailable).findFirst();
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
