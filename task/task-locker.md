
### 校验
-  初始化储物柜时，总容量大于等于可用量，并且都大于等于0
-  票据具有一次性与独立性

### 业务流程
- 存包
  - 正常

    - 一个容量为n（n>0）的储物柜，当前储物量为0，当存入一个包裹 ，然后储物柜可用容量减1,并且返回不为空的票据

  - 异常

    - 一个容量为n（随机数）的储物柜，当前储物量为n，存入 一个 包裹，储物柜容量为n，提示储物柜已满

      

- 取包

  - 正常
    - 一个容量为n>0的储物柜，当前储物量为1，当使用正确票据，储物柜容量为0，并返回包裹信息
  - 异常 
    - 票异常
      - 一个容量为n>0的储物柜，当前储物量为1，当使用非票据取物，提示无效票，柜子容量仍然为1
      - 一个容量为n>0的储物柜，当前储物量1，当使用已经使用过的票据取票，提示无效票，柜子容量为1