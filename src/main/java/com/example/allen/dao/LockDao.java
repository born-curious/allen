package com.example.allen.dao;

import com.example.allen.models.data.Lock;

public interface LockDao {

    void acquire(Lock lock);

    void release(Lock lock);

    boolean exists(String lockId);
}
