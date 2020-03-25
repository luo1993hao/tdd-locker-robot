package cn.xpbootcamp.gilded_rose;

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
        Locker locker = new Locker( 5);
        Package beStoredPackage = new Package();
        //when
        Ticket packageTicket = locker.store(beStoredPackage);
        //then
        int nowLockerAvailableCapacity = locker.getCapacity();
        Assertions.assertEquals(nowLockerAvailableCapacity, 4);
        Assertions.assertNotNull(packageTicket);
    }

    @Test()
    void should_throw_exception_when_store_package_but_locker_available_capacity_is_zero() {
        //given
        Locker locker = new Locker( 1);
        Package beStoredPackage = new Package();
        //when,then
        Assertions.assertThrows(StorePackageException.class, () -> locker.store(beStoredPackage));


    }
}
