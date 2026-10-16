package org.greenrobot.greendao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxTransaction;
import rx.schedulers.Schedulers;

/* loaded from: classes2.dex */
public class AbstractDaoSession {

    /* renamed from: db, reason: collision with root package name */
    private final Database f16958db;
    private final Map<Class<?>, AbstractDao<?, ?>> entityToDao = new HashMap();
    private volatile RxTransaction rxTxIo;
    private volatile RxTransaction rxTxPlain;

    public AbstractDaoSession(Database database) {
        this.f16958db = database;
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.f16958db.beginTransaction();
        try {
            V call = callable.call();
            this.f16958db.setTransactionSuccessful();
            return call;
        } finally {
            this.f16958db.endTransaction();
        }
    }

    public <V> V callInTxNoException(Callable<V> callable) {
        this.f16958db.beginTransaction();
        try {
            try {
                V call = callable.call();
                this.f16958db.setTransactionSuccessful();
                return call;
            } catch (Exception e) {
                throw new DaoException("Callable failed", e);
            }
        } finally {
            this.f16958db.endTransaction();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void delete(T t8) {
        getDao(t8.getClass()).delete(t8);
    }

    public <T> void deleteAll(Class<T> cls) {
        getDao(cls).deleteAll();
    }

    public Collection<AbstractDao<?, ?>> getAllDaos() {
        return Collections.unmodifiableCollection(this.entityToDao.values());
    }

    public AbstractDao<?, ?> getDao(Class<? extends Object> cls) {
        AbstractDao<?, ?> abstractDao = this.entityToDao.get(cls);
        if (abstractDao != null) {
            return abstractDao;
        }
        throw new DaoException("No DAO registered for " + cls);
    }

    public Database getDatabase() {
        return this.f16958db;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insert(T t8) {
        return getDao(t8.getClass()).insert(t8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insertOrReplace(T t8) {
        return getDao(t8.getClass()).insertOrReplace(t8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T, K> T load(Class<T> cls, K k10) {
        return (T) getDao(cls).load(k10);
    }

    public <T, K> List<T> loadAll(Class<T> cls) {
        return (List<T>) getDao(cls).loadAll();
    }

    public <T> QueryBuilder<T> queryBuilder(Class<T> cls) {
        return (QueryBuilder<T>) getDao(cls).queryBuilder();
    }

    public <T, K> List<T> queryRaw(Class<T> cls, String str, String... strArr) {
        return (List<T>) getDao(cls).queryRaw(str, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void refresh(T t8) {
        getDao(t8.getClass()).refresh(t8);
    }

    public <T> void registerDao(Class<T> cls, AbstractDao<T, ?> abstractDao) {
        this.entityToDao.put(cls, abstractDao);
    }

    public void runInTx(Runnable runnable) {
        this.f16958db.beginTransaction();
        try {
            runnable.run();
            this.f16958db.setTransactionSuccessful();
        } finally {
            this.f16958db.endTransaction();
        }
    }

    @Experimental
    public RxTransaction rxTx() {
        if (this.rxTxIo == null) {
            this.rxTxIo = new RxTransaction(this, Schedulers.io());
        }
        return this.rxTxIo;
    }

    @Experimental
    public RxTransaction rxTxPlain() {
        if (this.rxTxPlain == null) {
            this.rxTxPlain = new RxTransaction(this);
        }
        return this.rxTxPlain;
    }

    public AsyncSession startAsyncSession() {
        return new AsyncSession(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void update(T t8) {
        getDao(t8.getClass()).update(t8);
    }
}
