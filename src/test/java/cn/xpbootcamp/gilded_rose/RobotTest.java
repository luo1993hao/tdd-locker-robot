package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.CollectParcelException;
import cn.xpbootcamp.gilded_rose.exception.StoreParcelException;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Parcel;
import cn.xpbootcamp.gilded_rose.model.Robot;
import cn.xpbootcamp.gilded_rose.model.Ticket;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {
    @Test
    void should_return_ticket_when_store_parcel_given_parcel_locker_with_capacity_10_and_robot() {
        //given
        Robot robot = new Robot(Lists.newArrayList(new Locker(10)));
        Parcel beStoreParcel = new Parcel();
        //when
        Ticket ticket = robot.store(beStoreParcel);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_store_in_second_one_and_return_ticket_when_store_parcel_given_parcel_and_first_one_locker_full_and_second_locker_capacity_is_10_robot() {
        //given
        Robot robot = new Robot(Lists.newArrayList(new Locker(0), new Locker(10)));
        Parcel beStoreParcel = new Parcel();

        //when
        Ticket ticket = robot.store(beStoreParcel);
        //then
        Assertions.assertNotNull(ticket);
        Locker secondLocker = robot.getLockers().get(1);
        Assertions.assertEquals(9, secondLocker.getAvailableCapacity());
    }

    @Test
    void should_store_in_first_one_and_return_ticket_when_store_parcel_given_parcel_and_both_of_two_locker_capacity_are_10_robot() {
        //given
        Robot robot = new Robot(Lists.newArrayList(new Locker(10), new Locker(10)));
        Parcel beStoreParcel = new Parcel();

        //when
        Ticket ticket = robot.store(beStoreParcel);
        //then
        Assertions.assertNotNull(ticket);
        Locker firstLocker = robot.getLockers().get(0);
        Locker secondLocker = robot.getLockers().get(1);
        Assertions.assertEquals(9, firstLocker.getAvailableCapacity());
        Assertions.assertEquals(10, secondLocker.getAvailableCapacity());
    }

    @Test
    void should_throw_exception_when_store_parcel_given_parcel_and_two_locker_capacity_are_0_robot() {
        //given
        Robot robot = new Robot(Lists.newArrayList(new Locker(0), new Locker(0)));
        Parcel beStoreParcel = new Parcel();
        //when,then
        Assertions.assertThrows(StoreParcelException.class, () -> robot.store(beStoreParcel));
    }

    @Test
    void should_throw_exception_when_store_parcel_given_parcel_and_one_locker_capacity_is_0_another_capacity_is_1_robot() {
        //given
        Robot robot = new Robot(Lists.newArrayList(new Locker(1), new Locker(0)));
        Parcel beStoreParcel = new Parcel();
        Parcel failedParcel = new Parcel();
        //when
        robot.store(beStoreParcel);
        //then
        Locker firstLocker = robot.getLockers().get(0);
        Assertions.assertEquals(0, firstLocker.getAvailableCapacity());
        Assertions.assertThrows(StoreParcelException.class, () -> robot.store(failedParcel));
    }

    @Test
      void should_return_parcel_when_collect_parcel_given_valid_ticket_and_robot() {
          //given
          Robot robot = new Robot(Lists.newArrayList(new Locker(0), new Locker(10)));
          Parcel beStoreParcel = new Parcel();
          Ticket ticket = robot.store(beStoreParcel);
          //when
          Parcel collectParcel = robot.collect(ticket);
          //then
          Assertions.assertEquals(beStoreParcel, collectParcel);
      }

    @Test
    void should_throw_exception_when_collect_parcel_given_invalided_ticket_and_robot() {
        //given
        Robot robot = new Robot(Lists.newArrayList(new Locker(0), new Locker(10)));
        Parcel beStoreParcel = new Parcel();
        robot.store(beStoreParcel);
        Ticket invalidedTicket = new Ticket();
        //when,then
        Assertions.assertThrows(CollectParcelException.class, () -> robot.collect(invalidedTicket));
    }

}
