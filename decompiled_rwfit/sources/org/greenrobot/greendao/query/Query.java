package org.greenrobot.greendao.query;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.apihint.Internal;
import org.greenrobot.greendao.rx.RxQuery;
import rx.schedulers.Schedulers;

/* loaded from: classes2.dex */
public class Query<T> extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;
    private volatile RxQuery rxTxIo;
    private volatile RxQuery rxTxPlain;

    public static final class QueryData<T2> extends AbstractQueryData<T2, Query<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        public QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr, int i3, int i10) {
            super(abstractDao, str, strArr);
            this.limitPosition = i3;
            this.offsetPosition = i10;
        }

        @Override // org.greenrobot.greendao.query.AbstractQueryData
        public Query<T2> createQuery() {
            return new Query<>(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> Query<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i3, int i10) {
        return new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr), i3, i10).forCurrentThread();
    }

    public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return create(abstractDao, str, objArr, -1, -1);
    }

    @Internal
    public RxQuery __InternalRx() {
        if (this.rxTxIo == null) {
            this.rxTxIo = new RxQuery(this, Schedulers.io());
        }
        return this.rxTxIo;
    }

    @Internal
    public RxQuery __internalRxPlain() {
        if (this.rxTxPlain == null) {
            this.rxTxPlain = new RxQuery(this);
        }
        return this.rxTxPlain;
    }

    public Query<T> forCurrentThread() {
        return (Query) this.queryData.forCurrentThread(this);
    }

    public List<T> list() {
        checkThread();
        return this.daoAccess.loadAllAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public CloseableListIterator<T> listIterator() {
        return listLazyUncached().listIteratorAutoClose();
    }

    public LazyList<T> listLazy() {
        checkThread();
        return new LazyList<>(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), true);
    }

    public LazyList<T> listLazyUncached() {
        checkThread();
        return new LazyList<>(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), false);
    }

    @Override // org.greenrobot.greendao.query.AbstractQueryWithLimit
    public /* bridge */ /* synthetic */ void setLimit(int i3) {
        super.setLimit(i3);
    }

    @Override // org.greenrobot.greendao.query.AbstractQueryWithLimit
    public /* bridge */ /* synthetic */ void setOffset(int i3) {
        super.setOffset(i3);
    }

    public T unique() {
        checkThread();
        return this.daoAccess.loadUniqueAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public T uniqueOrThrow() {
        T unique = unique();
        if (unique != null) {
            return unique;
        }
        throw new DaoException("No entity found for query");
    }

    private Query(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i3, int i10) {
        super(abstractDao, str, strArr, i3, i10);
        this.queryData = queryData;
    }

    @Override // org.greenrobot.greendao.query.AbstractQueryWithLimit, org.greenrobot.greendao.query.AbstractQuery
    public Query<T> setParameter(int i3, Object obj) {
        return (Query) super.setParameter(i3, obj);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public Query<T> setParameter(int i3, Date date) {
        return (Query) super.setParameter(i3, date);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public Query<T> setParameter(int i3, Boolean bool) {
        return (Query) super.setParameter(i3, bool);
    }
}
