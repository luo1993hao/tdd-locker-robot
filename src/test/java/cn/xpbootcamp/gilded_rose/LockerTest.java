package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.StoreParcelException;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Parcel;
import cn.xpbootcamp.gilded_rose.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTest {
  @Test
  void should_return_ticket_when_locker_available_capacity_is_not_zero() {
    //Given
    Parcel parcel = new Parcel();
    Locker locker = new Locker(20, 20);
    //When
    Ticket ticket = locker.store(parcel);
    //Then
    Assertions.assertNotNull(ticket);
  }

  @Test
  void should_locker_available_capacity_decrease_1_when_locker_available_capacity_is_not_zero() {
    //Given
    Parcel parcel = new Parcel();
    Locker locker = new Locker(20, 20);
    //When
    locker.store(parcel);
    int availableCapacity = locker.getAvailableCapacity();
    //Then
    Assertions.assertEquals(19, availableCapacity);
  }

  @Test
  void should_throw_exception_when_store_parcel_and_locker_available_capacity_is_zero() {
    //Given
    Parcel parcel = new Parcel();
    Locker locker = new Locker(20, 0);
    //When Then
    Assertions.assertThrows(StoreParcelException.class, () -> locker.store(parcel));
  }

}
