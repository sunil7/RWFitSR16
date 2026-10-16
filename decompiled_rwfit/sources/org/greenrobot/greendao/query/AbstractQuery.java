package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

/* loaded from: classes2.dex */
abstract class AbstractQuery<T> {
    protected final AbstractDao<T, ?> dao;
    protected final InternalQueryDaoAccess<T> daoAccess;
    protected final Thread ownerThread = Thread.currentThread();
    protected final String[] parameters;
    protected final String sql;

    public AbstractQuery(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.daoAccess = new InternalQueryDaoAccess<>(abstractDao);
        this.sql = str;
        this.parameters = strArr;
    }

    public static String[] toStringArray(Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = objArr[i3];
            if (obj != null) {
                strArr[i3] = obj.toString();
            } else {
                strArr[i3] = null;
            }
        }
        return strArr;
    }

    public void checkThread() {
        if (Thread.currentThread() != this.ownerThread) {
            throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
        }
    }

    public AbstractQuery<T> setParameter(int i3, Object obj) {
        checkThread();
        if (obj != null) {
            this.parameters[i3] = obj.toString();
            return this;
        }
        this.parameters[i3] = null;
        return this;
    }

    public AbstractQuery<T> setParameter(int i3, Date date) {
        return setParameter(i3, date != null ? Long.valueOf(date.getTime()) : null);
    }

    public AbstractQuery<T> setParameter(int i3, Boolean bool) {
        return setParameter(i3, bool != null ? Integer.valueOf(bool.booleanValue() ? 1 : 0) : null);
    }
}
