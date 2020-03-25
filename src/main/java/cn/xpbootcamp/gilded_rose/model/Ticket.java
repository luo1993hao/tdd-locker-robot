package cn.xpbootcamp.gilded_rose.model;

import java.util.UUID;

public class Ticket {
    private String id;

    public String getId() {
        return id;
    }

    public Ticket() {
        this.id = UUID.randomUUID().toString();
    }
}
