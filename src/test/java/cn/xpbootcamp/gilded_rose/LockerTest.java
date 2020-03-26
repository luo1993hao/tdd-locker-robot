package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTest {
  @Test
  void should_return_ticket_when_locker_available_capacity_is_not_zero() {
    //Given
    Parcel parcel = new Parcel();
    Locker locker = new Locker(20);
    //When
    Ticket ticket = locker.store(parcel);
    //Then
    Assertions.assertNotNull(ticket);
  }

  @Test
  void should_locker_available_capacity_decrease_1_when_locker_available_capacity_is_not_zero() {
    //Given
    Parcel parcel = new Parcel();
    Locker locker = new Locker(20);
    //When
    locker.store(parcel);
    int availableCapacity = locker.getAvailableCapacity();
    //Then
    Assertions.assertEquals(19, availableCapacity);
  }


}
