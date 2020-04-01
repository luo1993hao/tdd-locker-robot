## 存

### 存成功

- Given package, lockers and robot, when capacity avaliable, then save successfully and return ticket.
- Given package, two lockers(the first one is full and second one avaliable) and robot, when save package, then package should in the second one and return ticket.
- Given package, two lockers(both of two are avaliable) and robot, when save package, then package should in the first one and return ticket.

### 存失败

- Given package, lockers(all full, capacity run out) and  robot, when save package, then save fail throw exception. 

## 取

### 取成功

- Given ticket(valided), lockers and robot, when take package, then return package and invalidate ticket

### 取失败

- Given ticket(invalided), lockers and rebot, when take package, then take fail throw exception