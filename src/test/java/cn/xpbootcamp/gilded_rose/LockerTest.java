package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.FetchPackageException;
import cn.xpbootcamp.gilded_rose.exception.StorePackageException;
import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Package;
import cn.xpbootcamp.gilded_rose.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LockerTest {

    @Test
    void should_store_package_success_and_locker_available_capacity_decrease_1__when_locker_available_capacity_is_not_zero() {
        //given
        Locker locker = new Locker(5);
        Package beStoredPackage = new Package();
        //when
        Ticket packageTicket = locker.store(beStoredPackage);
        //then
        int nowLockerAvailableCapacity = locker.getAvailableCapacity();
        Assertions.assertEquals(nowLockerAvailableCapacity, 4);
        Assertions.assertNotNull(packageTicket);
    }

    @Test
    void should_throw_exception_when_store_package_but_locker_available_capacity_is_zero() {
        //given
        Locker locker = new Locker(1);
        Package beStoredPackage = new Package();
        //when
        locker.store(beStoredPackage);
        //then
        Assertions.assertThrows(StorePackageException.class, () -> locker.store(beStoredPackage));

    }

    //todo
    @Test
    void should_throw_exception_when_locker_total_capacity_is_less_than_zero() {

    }

    @Test
    void should_fetch_package_success_and_locker_available_capacity_increase_1_when_ticket_is_legal() {
        //given
        Locker locker = new Locker(1);
        Package beStoredPackage = new Package();
        Ticket packageTicket = locker.store(beStoredPackage);
        //when
        locker.fetch(packageTicket);
        //then
        Assertions.assertEquals(locker.getAvailableCapacity(), 1);

    }

    @Test
    void should_throw_exception_when_illegal_ticket_to_fetch_package() {
        //given
        Locker locker = new Locker(1);
        Package beStoredPackage = new Package();
        locker.store(beStoredPackage);
        Ticket illegalTicket = new Ticket();
        //when,then
        Assertions.assertThrows(FetchPackageException.class, () -> locker.fetch(illegalTicket));

    }

    @Test
    void should_throw_exception_when_ticket_have_been_fetch_package() {
        //given
        Locker locker = new Locker(1);
        Package beStoredPackage = new Package();
        Ticket packageTicket = locker.store(beStoredPackage);
        //when
        locker.fetch(packageTicket);
        //then,double fetch
        Assertions.assertThrows(FetchPackageException.class, () -> locker.fetch(packageTicket));
    }
}
