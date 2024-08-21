package com.example.allen.dao.impl;

import com.example.allen.dao.DealDao;
import com.example.allen.dao.LockDao;
import com.example.allen.datastore.impl.DealDatastore;
import com.example.allen.datastore.impl.LockDatastore;
import com.example.allen.models.data.Deal;
import com.example.allen.models.data.Lock;
import com.example.allen.models.exceptions.AlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LockDaoImpl implements LockDao {

    private final LockDatastore lockDatastore;

    @Override
    public void acquire(Lock lock) {
        Lock dbLock = lockDatastore.setDataIfAbsent(lock.getKey(), lock);
        if(Objects.nonNull(dbLock)) {
            throw new AlreadyExistsException("Lock Already Acquired");
        }
    }

    @Override
    public void release(Lock lock) {
        lockDatastore.removeData(lock.getKey());
    }

    @Override
    public boolean exists(String lockId) {
        return Objects.nonNull(lockDatastore.getData(lockId));
    }
}
