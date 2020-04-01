package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.model.Locker;
import cn.xpbootcamp.gilded_rose.model.Parcel;
import cn.xpbootcamp.gilded_rose.model.Robot;
import cn.xpbootcamp.gilded_rose.model.Ticket;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {
    @Test
    void should_return_ticket_when_locker_capacity_available_given_parcel_and_robot() {
        //given
        Robot robot = new Robot(Lists.newArrayList(new Locker(10)));
        Parcel beStoreParcel = new Parcel();
        //when
        Ticket ticket = robot.store(beStoreParcel);
        //then
        Assertions.assertNotNull(ticket);

    }
}
