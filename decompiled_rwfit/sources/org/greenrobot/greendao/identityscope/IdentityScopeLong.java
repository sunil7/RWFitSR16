package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.internal.LongHashMap;

/* loaded from: classes2.dex */
public class IdentityScopeLong<T> implements IdentityScope<Long, T> {
    private final LongHashMap<Reference<T>> map = new LongHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void clear() {
        this.lock.lock();
        try {
            this.map.clear();
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public /* bridge */ /* synthetic */ boolean detach(Long l3, Object obj) {
        return detach2(l3, (Long) obj);
    }

    public T get2(long j4) {
        this.lock.lock();
        try {
            Reference<T> reference = this.map.get(j4);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.lock.unlock();
        }
    }

    public T get2NoLock(long j4) {
        Reference<T> reference = this.map.get(j4);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void lock() {
        this.lock.lock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public /* bridge */ /* synthetic */ void put(Long l3, Object obj) {
        put3(l3, (Long) obj);
    }

    public void put2(long j4, T t8) {
        this.lock.lock();
        try {
            this.map.put(j4, new WeakReference(t8));
        } finally {
            this.lock.unlock();
        }
    }

    public void put2NoLock(long j4, T t8) {
        this.map.put(j4, new WeakReference(t8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public /* bridge */ /* synthetic */ void putNoLock(Long l3, Object obj) {
        putNoLock2(l3, (Long) obj);
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void reserveRoom(int i3) {
        this.map.reserveRoom(i3);
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void unlock() {
        this.lock.unlock();
    }

    /* renamed from: detach, reason: avoid collision after fix types in other method */
    public boolean detach2(Long l3, T t8) {
        this.lock.lock();
        try {
            if (get(l3) != t8 || t8 == null) {
                this.lock.unlock();
                return false;
            }
            remove(l3);
            this.lock.unlock();
            return true;
        } catch (Throwable th2) {
            this.lock.unlock();
            throw th2;
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public T get(Long l3) {
        return get2(l3.longValue());
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public T getNoLock(Long l3) {
        return get2NoLock(l3.longValue());
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public void put3(Long l3, T t8) {
        put2(l3.longValue(), t8);
    }

    /* renamed from: putNoLock, reason: avoid collision after fix types in other method */
    public void putNoLock2(Long l3, T t8) {
        put2NoLock(l3.longValue(), t8);
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void remove(Long l3) {
        this.lock.lock();
        try {
            this.map.remove(l3.longValue());
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void remove(Iterable<Long> iterable) {
        this.lock.lock();
        try {
            Iterator<Long> it = iterable.iterator();
            while (it.hasNext()) {
                this.map.remove(it.next().longValue());
            }
        } finally {
            this.lock.unlock();
        }
    }
}
