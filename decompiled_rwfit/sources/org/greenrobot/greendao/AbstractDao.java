package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;
import r5.a;
import rx.schedulers.Schedulers;

/* loaded from: classes2.dex */
public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;

    /* renamed from: db, reason: collision with root package name */
    protected final Database f16956db;
    protected final IdentityScope<K, T> identityScope;
    protected final IdentityScopeLong<T> identityScopeLong;
    protected final boolean isStandardSQLite;
    protected final int pkOrdinal;
    private volatile RxDao<T, K> rxDao;
    private volatile RxDao<T, K> rxDaoPlain;
    protected final AbstractDaoSession session;
    protected final TableStatements statements;

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void deleteByKeyInsideSynchronized(K k10, DatabaseStatement databaseStatement) {
        if (k10 instanceof Long) {
            databaseStatement.bindLong(1, ((Long) k10).longValue());
        } else {
            if (k10 == 0) {
                throw new DaoException("Cannot delete entity, key is null");
            }
            databaseStatement.bindString(1, k10.toString());
        }
        databaseStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        ArrayList arrayList;
        IdentityScope<K, T> identityScope;
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        this.f16956db.beginTransaction();
        try {
            synchronized (deleteStatement) {
                IdentityScope<K, T> identityScope2 = this.identityScope;
                if (identityScope2 != null) {
                    identityScope2.lock();
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                if (iterable != null) {
                    try {
                        Iterator<T> it = iterable.iterator();
                        while (it.hasNext()) {
                            K keyVerified = getKeyVerified(it.next());
                            deleteByKeyInsideSynchronized(keyVerified, deleteStatement);
                            if (arrayList != null) {
                                arrayList.add(keyVerified);
                            }
                        }
                    } catch (Throwable th2) {
                        IdentityScope<K, T> identityScope3 = this.identityScope;
                        if (identityScope3 != null) {
                            identityScope3.unlock();
                        }
                        throw th2;
                    }
                }
                if (iterable2 != null) {
                    for (K k10 : iterable2) {
                        deleteByKeyInsideSynchronized(k10, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(k10);
                        }
                    }
                }
                IdentityScope<K, T> identityScope4 = this.identityScope;
                if (identityScope4 != null) {
                    identityScope4.unlock();
                }
            }
            this.f16956db.setTransactionSuccessful();
            if (arrayList != null && (identityScope = this.identityScope) != null) {
                identityScope.remove((Iterable) arrayList);
            }
        } finally {
            this.f16956db.endTransaction();
        }
    }

    private long executeInsert(T t8, DatabaseStatement databaseStatement, boolean z5) {
        long insertInsideTx;
        if (this.f16956db.isDbLockedByCurrentThread()) {
            insertInsideTx = insertInsideTx(t8, databaseStatement);
        } else {
            this.f16956db.beginTransaction();
            try {
                insertInsideTx = insertInsideTx(t8, databaseStatement);
                this.f16956db.setTransactionSuccessful();
            } finally {
                this.f16956db.endTransaction();
            }
        }
        if (z5) {
            updateKeyAfterInsertAndAttach(t8, insertInsideTx, true);
        }
        return insertInsideTx;
    }

    private void executeInsertInTx(DatabaseStatement databaseStatement, Iterable<T> iterable, boolean z5) {
        this.f16956db.beginTransaction();
        try {
            synchronized (databaseStatement) {
                IdentityScope<K, T> identityScope = this.identityScope;
                if (identityScope != null) {
                    identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                        for (T t8 : iterable) {
                            bindValues(sQLiteStatement, (SQLiteStatement) t8);
                            if (z5) {
                                updateKeyAfterInsertAndAttach(t8, sQLiteStatement.executeInsert(), false);
                            } else {
                                sQLiteStatement.execute();
                            }
                        }
                    } else {
                        for (T t10 : iterable) {
                            bindValues(databaseStatement, (DatabaseStatement) t10);
                            if (z5) {
                                updateKeyAfterInsertAndAttach(t10, databaseStatement.executeInsert(), false);
                            } else {
                                databaseStatement.execute();
                            }
                        }
                    }
                    IdentityScope<K, T> identityScope2 = this.identityScope;
                    if (identityScope2 != null) {
                        identityScope2.unlock();
                    }
                } catch (Throwable th2) {
                    IdentityScope<K, T> identityScope3 = this.identityScope;
                    if (identityScope3 != null) {
                        identityScope3.unlock();
                    }
                    throw th2;
                }
            }
            this.f16956db.setTransactionSuccessful();
        } finally {
            this.f16956db.endTransaction();
        }
    }

    private long insertInsideTx(T t8, DatabaseStatement databaseStatement) {
        synchronized (databaseStatement) {
            try {
                if (!this.isStandardSQLite) {
                    bindValues(databaseStatement, (DatabaseStatement) t8);
                    return databaseStatement.executeInsert();
                }
                SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                bindValues(sQLiteStatement, (SQLiteStatement) t8);
                return sQLiteStatement.executeInsert();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int numRows = cursorWindow.getNumRows() + cursorWindow.getStartPosition();
        int i3 = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            if (i3 + 1 >= numRows) {
                CursorWindow moveToNextUnlocked = moveToNextUnlocked(cursor);
                if (moveToNextUnlocked == null) {
                    return;
                }
                numRows = moveToNextUnlocked.getNumRows() + moveToNextUnlocked.getStartPosition();
            } else if (!cursor.moveToNext()) {
                return;
            }
            i3 += 2;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor cursor) {
        this.identityScope.unlock();
        try {
            if (cursor.moveToNext()) {
                return ((CrossProcessCursor) cursor).getWindow();
            }
            this.identityScope.lock();
            return null;
        } finally {
            this.identityScope.lock();
        }
    }

    public void assertSinglePk() {
        if (this.config.pkColumns.length == 1) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this);
        sb2.append(" (");
        throw new DaoException(a.f(sb2, this.config.tablename, ") does not have a single-column primary key"));
    }

    public void attachEntity(T t8) {
    }

    public abstract void bindValues(SQLiteStatement sQLiteStatement, T t8);

    public abstract void bindValues(DatabaseStatement databaseStatement, T t8);

    public long count() {
        return this.statements.getCountStatement().simpleQueryForLong();
    }

    public void delete(T t8) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t8));
    }

    public void deleteAll() {
        a.j(new StringBuilder("DELETE FROM '"), this.config.tablename, "'", this.f16956db);
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public void deleteByKey(K k10) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.f16956db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k10, deleteStatement);
            }
        } else {
            this.f16956db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k10, deleteStatement);
                }
                this.f16956db.setTransactionSuccessful();
            } finally {
                this.f16956db.endTransaction();
            }
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.remove((IdentityScope<K, T>) k10);
        }
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal(null, iterable);
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public boolean detach(T t8) {
        if (this.identityScope == null) {
            return false;
        }
        return this.identityScope.detach(getKeyVerified(t8), t8);
    }

    public void detachAll() {
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public Database getDatabase() {
        return this.f16956db;
    }

    public abstract K getKey(T t8);

    public K getKeyVerified(T t8) {
        K key = getKey(t8);
        if (key != null) {
            return key;
        }
        if (t8 == null) {
            throw new NullPointerException("Entity may not be null");
        }
        throw new DaoException("Entity has no key");
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    public TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public abstract boolean hasKey(T t8);

    public long insert(T t8) {
        return executeInsert(t8, this.statements.getInsertStatement(), true);
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public long insertOrReplace(T t8) {
        return executeInsert(t8, this.statements.getInsertOrReplaceStatement(), true);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z5) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z5);
    }

    public long insertWithoutSettingPk(T t8) {
        return executeInsert(t8, this.statements.getInsertOrReplaceStatement(), false);
    }

    public abstract boolean isEntityUpdateable();

    public T load(K k10) {
        T t8;
        assertSinglePk();
        if (k10 == null) {
            return null;
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        return (identityScope == null || (t8 = identityScope.get(k10)) == null) ? loadUniqueAndCloseCursor(this.f16956db.rawQuery(this.statements.getSelectByKey(), new String[]{k10.toString()})) : t8;
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.f16956db.rawQuery(this.statements.getSelectAll(), null));
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<T> loadAllFromCursor(android.database.Cursor r7) {
        /*
            r6 = this;
            int r0 = r7.getCount()
            if (r0 != 0) goto Lc
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        Lc:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            boolean r2 = r7 instanceof android.database.CrossProcessCursor
            r3 = 0
            if (r2 == 0) goto L4b
            r2 = r7
            android.database.CrossProcessCursor r2 = (android.database.CrossProcessCursor) r2
            android.database.CursorWindow r2 = r2.getWindow()
            if (r2 == 0) goto L49
            int r4 = r2.getNumRows()
            if (r4 != r0) goto L2c
            org.greenrobot.greendao.internal.FastCursor r7 = new org.greenrobot.greendao.internal.FastCursor
            r7.<init>(r2)
            r4 = 1
            goto L4d
        L2c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Window vs. result size: "
            r4.<init>(r5)
            int r5 = r2.getNumRows()
            r4.append(r5)
            java.lang.String r5 = "/"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            org.greenrobot.greendao.DaoLog.d(r4)
        L49:
            r4 = r3
            goto L4d
        L4b:
            r2 = 0
            goto L49
        L4d:
            boolean r5 = r7.moveToFirst()
            if (r5 == 0) goto L8a
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            if (r5 == 0) goto L5f
            r5.lock()
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            r5.reserveRoom(r0)
        L5f:
            if (r4 != 0) goto L6d
            if (r2 == 0) goto L6d
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L6d
            r6.loadAllUnlockOnWindowBounds(r7, r2, r1)     // Catch: java.lang.Throwable -> L6b
            goto L7a
        L6b:
            r7 = move-exception
            goto L82
        L6d:
            java.lang.Object r0 = r6.loadCurrent(r7, r3, r3)     // Catch: java.lang.Throwable -> L6b
            r1.add(r0)     // Catch: java.lang.Throwable -> L6b
            boolean r0 = r7.moveToNext()     // Catch: java.lang.Throwable -> L6b
            if (r0 != 0) goto L6d
        L7a:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r7 = r6.identityScope
            if (r7 == 0) goto L8a
            r7.unlock()
            return r1
        L82:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope
            if (r0 == 0) goto L89
            r0.unlock()
        L89:
            throw r7
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.AbstractDao.loadAllFromCursor(android.database.Cursor):java.util.List");
    }

    public T loadByRowId(long j4) {
        return loadUniqueAndCloseCursor(this.f16956db.rawQuery(this.statements.getSelectByRowId(), new String[]{Long.toString(j4)}));
    }

    public final T loadCurrent(Cursor cursor, int i3, boolean z5) {
        if (this.identityScopeLong != null) {
            if (i3 != 0 && cursor.isNull(this.pkOrdinal + i3)) {
                return null;
            }
            long j4 = cursor.getLong(this.pkOrdinal + i3);
            IdentityScopeLong<T> identityScopeLong = this.identityScopeLong;
            T t8 = z5 ? identityScopeLong.get2(j4) : identityScopeLong.get2NoLock(j4);
            if (t8 != null) {
                return t8;
            }
            T readEntity = readEntity(cursor, i3);
            attachEntity(readEntity);
            if (z5) {
                this.identityScopeLong.put2(j4, readEntity);
                return readEntity;
            }
            this.identityScopeLong.put2NoLock(j4, readEntity);
            return readEntity;
        }
        if (this.identityScope == null) {
            if (i3 != 0 && readKey(cursor, i3) == null) {
                return null;
            }
            T readEntity2 = readEntity(cursor, i3);
            attachEntity(readEntity2);
            return readEntity2;
        }
        K readKey = readKey(cursor, i3);
        if (i3 != 0 && readKey == null) {
            return null;
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        T noLock = z5 ? identityScope.get(readKey) : identityScope.getNoLock(readKey);
        if (noLock != null) {
            return noLock;
        }
        T readEntity3 = readEntity(cursor, i3);
        attachEntity(readKey, readEntity3, z5);
        return readEntity3;
    }

    public final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i3) {
        return abstractDao.loadCurrent(cursor, i3, true);
    }

    public T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    public List<T> queryRaw(String str, String... strArr) {
        return loadAllAndCloseCursor(this.f16956db.rawQuery(this.statements.getSelectAll() + str, strArr));
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return Query.internalCreate(this, this.statements.getSelectAll() + str, collection.toArray());
    }

    public abstract T readEntity(Cursor cursor, int i3);

    public abstract void readEntity(Cursor cursor, T t8, int i3);

    public abstract K readKey(Cursor cursor, int i3);

    public void refresh(T t8) {
        assertSinglePk();
        K keyVerified = getKeyVerified(t8);
        Cursor rawQuery = this.f16956db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (!rawQuery.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t8.getClass() + " with key " + keyVerified);
            }
            if (rawQuery.isLast()) {
                readEntity(rawQuery, t8, 0);
                attachEntity(keyVerified, t8, true);
            } else {
                throw new DaoException("Expected unique result, but count was " + rawQuery.getCount());
            }
        } finally {
            rawQuery.close();
        }
    }

    @Experimental
    public RxDao<T, K> rx() {
        if (this.rxDao == null) {
            this.rxDao = new RxDao<>(this, Schedulers.io());
        }
        return this.rxDao;
    }

    @Experimental
    public RxDao<T, K> rxPlain() {
        if (this.rxDaoPlain == null) {
            this.rxDaoPlain = new RxDao<>(this);
        }
        return this.rxDaoPlain;
    }

    public void save(T t8) {
        if (hasKey(t8)) {
            update(t8);
        } else {
            insert(t8);
        }
    }

    public void saveInTx(T... tArr) {
        saveInTx(Arrays.asList(tArr));
    }

    public void update(T t8) {
        assertSinglePk();
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        if (this.f16956db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                try {
                    if (this.isStandardSQLite) {
                        updateInsideSynchronized((AbstractDao<T, K>) t8, (SQLiteStatement) updateStatement.getRawStatement(), true);
                    } else {
                        updateInsideSynchronized((AbstractDao<T, K>) t8, updateStatement, true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return;
        }
        this.f16956db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized((AbstractDao<T, K>) t8, updateStatement, true);
            }
            this.f16956db.setTransactionSuccessful();
        } finally {
            this.f16956db.endTransaction();
        }
    }

    public void updateInTx(Iterable<T> iterable) {
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        this.f16956db.beginTransaction();
        try {
            synchronized (updateStatement) {
                IdentityScope<K, T> identityScope = this.identityScope;
                if (identityScope != null) {
                    identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) updateStatement.getRawStatement();
                        Iterator<T> it = iterable.iterator();
                        while (it.hasNext()) {
                            updateInsideSynchronized((AbstractDao<T, K>) it.next(), sQLiteStatement, false);
                        }
                    } else {
                        Iterator<T> it2 = iterable.iterator();
                        while (it2.hasNext()) {
                            updateInsideSynchronized((AbstractDao<T, K>) it2.next(), updateStatement, false);
                        }
                    }
                    IdentityScope<K, T> identityScope2 = this.identityScope;
                    if (identityScope2 != null) {
                        identityScope2.unlock();
                    }
                } catch (Throwable th2) {
                    IdentityScope<K, T> identityScope3 = this.identityScope;
                    if (identityScope3 != null) {
                        identityScope3.unlock();
                    }
                    throw th2;
                }
            }
            this.f16956db.setTransactionSuccessful();
            this.f16956db.endTransaction();
            e = null;
        } catch (RuntimeException e) {
            e = e;
            try {
                this.f16956db.endTransaction();
            } catch (RuntimeException e10) {
                DaoLog.w("Could not end transaction (rethrowing initial exception)", e10);
                throw e;
            }
        } catch (Throwable th3) {
            this.f16956db.endTransaction();
            throw th3;
        }
        if (e != null) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateInsideSynchronized(T t8, DatabaseStatement databaseStatement, boolean z5) {
        bindValues(databaseStatement, (DatabaseStatement) t8);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t8);
        if (key instanceof Long) {
            databaseStatement.bindLong(length, ((Long) key).longValue());
        } else {
            if (key == null) {
                throw new DaoException("Cannot update entity without key - was it inserted before?");
            }
            databaseStatement.bindString(length, key.toString());
        }
        databaseStatement.execute();
        attachEntity(key, t8, z5);
    }

    public abstract K updateKeyAfterInsert(T t8, long j4);

    public void updateKeyAfterInsertAndAttach(T t8, long j4, boolean z5) {
        if (j4 != -1) {
            attachEntity(updateKeyAfterInsert(t8, j4), t8, z5);
        } else {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
        }
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        Database database = daoConfig.f16959db;
        this.f16956db = database;
        this.isStandardSQLite = database.getRawDatabase() instanceof SQLiteDatabase;
        IdentityScopeLong<T> identityScopeLong = (IdentityScope<K, T>) daoConfig.getIdentityScope();
        this.identityScope = identityScopeLong;
        if (identityScopeLong instanceof IdentityScopeLong) {
            this.identityScopeLong = identityScopeLong;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = daoConfig.statements;
        Property property = daoConfig.pkProperty;
        this.pkOrdinal = property != null ? property.ordinal : -1;
    }

    public final void attachEntity(K k10, T t8, boolean z5) {
        attachEntity(t8);
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope == null || k10 == null) {
            return;
        }
        if (z5) {
            identityScope.put(k10, t8);
        } else {
            identityScope.putNoLock(k10, t8);
        }
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal(null, Arrays.asList(kArr));
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void saveInTx(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        int i3 = 0;
        int i10 = 0;
        while (it.hasNext()) {
            if (hasKey(it.next())) {
                i3++;
            } else {
                i10++;
            }
        }
        if (i3 <= 0 || i10 <= 0) {
            if (i10 > 0) {
                insertInTx(iterable);
                return;
            } else {
                if (i3 > 0) {
                    updateInTx(iterable);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList(i3);
        ArrayList arrayList2 = new ArrayList(i10);
        for (T t8 : iterable) {
            if (hasKey(t8)) {
                arrayList.add(t8);
            } else {
                arrayList2.add(t8);
            }
        }
        this.f16956db.beginTransaction();
        try {
            updateInTx(arrayList);
            insertInTx(arrayList2);
            this.f16956db.setTransactionSuccessful();
        } finally {
            this.f16956db.endTransaction();
        }
    }

    public void insertInTx(Iterable<T> iterable, boolean z5) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z5);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateInsideSynchronized(T t8, SQLiteStatement sQLiteStatement, boolean z5) {
        bindValues(sQLiteStatement, (SQLiteStatement) t8);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t8);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            sQLiteStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        sQLiteStatement.execute();
        attachEntity(key, t8, z5);
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }
}
