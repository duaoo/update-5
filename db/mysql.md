
### 一、存储引擎
> MyISAM和InnoDB。5.5之前默认MyISAM，之后默认InnoDB。
> MyISAM特性全文索引，压缩，空间函数，但不支持事务和行级锁，崩溃后无法恢复，适合读密集的情况。

##### 两者对比：

1. 行级锁支持

   MyISAM只有表级锁（table-level locking），而InnoDB支持行级锁（row-level locking）和表级锁，默认我行级锁。

2. 事务和奔溃后安全恢复支持

   MyISAM强调性能，每次原子性查询，执行速度比InnoDB更快，但不支持事务。

   InnoDB支持事务，外部键等功能。具有事务（commint）、回滚（rollabck）和崩溃修复能力（crash recovery capabilities）的事务安全（transaction-safe（ACID compliant））型表。

3. 外键支持

   MyISAM不支持，InnoDB支持。

4. MVCC支持

   仅InnaDB支持。应对高并发事务，MVCC比单纯的加锁更高效。

   只在`READ COMMITTED`和`REPEATABLE READ`两个隔离级别下工作。

   可以使用`乐观锁(optimistic)`和`悲观锁(pessimistic)`来实现。