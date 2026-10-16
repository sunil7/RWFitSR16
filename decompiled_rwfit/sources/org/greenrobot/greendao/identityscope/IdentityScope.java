package org.greenrobot.greendao.identityscope;

/* loaded from: classes2.dex */
public interface IdentityScope<K, T> {
    void clear();

    boolean detach(K k10, T t8);

    T get(K k10);

    T getNoLock(K k10);

    void lock();

    void put(K k10, T t8);

    void putNoLock(K k10, T t8);

    void remove(Iterable<K> iterable);

    void remove(K k10);

    void reserveRoom(int i3);

    void unlock();
}
