## 存

### 存成功

- Given parcel, lockers and robot, when capacity is 10, then save successfully and return ticket.
- Given parcel, two lockers(the first one is full and second one capacity is 10) and robot, when save parcel, then package should in the second one and return ticket.
- Given parcel, two lockers(both of two capacity are 10) and robot, when save parcel, then parcel should in the first one and return ticket.

### 存失败

- Given parcel, lockers(all full, capacity run out) and  robot, when save parcel, then save fail throw exception. 

## 取

### 取成功

- Given ticket(valid), lockers and robot, when take parcel, then return parcel and invalidate ticket

### 取失败

- Given ticket(invalided), lockers and robot, when take parcel, then take fail throw exception