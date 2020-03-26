package cn.xpbootcamp.gilded_rose.model;

import com.google.common.base.Objects;

import java.util.UUID;

public class Ticket {
  private String id;

  public Ticket() {
    this.id = UUID.randomUUID().toString();
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ticket ticket = (Ticket) o;
    return Objects.equal(id, ticket.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
