package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

/* loaded from: classes2.dex */
abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {
    final AbstractDao<T, ?> dao;
    final String[] initialValues;
    final Map<Long, WeakReference<Q>> queriesForThreads = new HashMap();
    final String sql;

    public AbstractQueryData(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.sql = str;
        this.initialValues = strArr;
    }

    public abstract Q createQuery();

    public Q forCurrentThread(Q q5) {
        if (Thread.currentThread() != q5.ownerThread) {
            return forCurrentThread();
        }
        String[] strArr = this.initialValues;
        System.arraycopy(strArr, 0, q5.parameters, 0, strArr.length);
        return q5;
    }

    public void gc() {
        synchronized (this.queriesForThreads) {
            try {
                Iterator<Map.Entry<Long, WeakReference<Q>>> it = this.queriesForThreads.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().get() == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Q forCurrentThread() {
        Q q5;
        long id2 = Thread.currentThread().getId();
        synchronized (this.queriesForThreads) {
            try {
                WeakReference<Q> weakReference = this.queriesForThreads.get(Long.valueOf(id2));
                q5 = weakReference != null ? weakReference.get() : null;
                if (q5 == null) {
                    gc();
                    q5 = createQuery();
                    this.queriesForThreads.put(Long.valueOf(id2), new WeakReference<>(q5));
                } else {
                    String[] strArr = this.initialValues;
                    System.arraycopy(strArr, 0, q5.parameters, 0, strArr.length);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return q5;
    }
}
