package org.greenrobot.greendao.query;

import android.database.Cursor;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

/* loaded from: classes2.dex */
public class LazyList<E> implements List<E>, Closeable, AutoCloseable {
    private final Cursor cursor;
    private final InternalQueryDaoAccess<E> daoAccess;
    private final List<E> entities;
    private volatile int loadedCount;
    private final ReentrantLock lock;
    private final int size;

    public class LazyIterator implements CloseableListIterator<E> {
        private final boolean closeWhenDone;
        private int index;

        public LazyIterator(int i3, boolean z5) {
            this.index = i3;
            this.closeWhenDone = z5;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            LazyList.this.close();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < LazyList.this.size;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index >= LazyList.this.size) {
                throw new NoSuchElementException();
            }
            E e = (E) LazyList.this.get(this.index);
            int i3 = this.index + 1;
            this.index = i3;
            if (i3 == LazyList.this.size && this.closeWhenDone) {
                close();
            }
            return e;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i3 = this.index;
            if (i3 <= 0) {
                throw new NoSuchElementException();
            }
            int i10 = i3 - 1;
            this.index = i10;
            return (E) LazyList.this.get(i10);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException();
        }
    }

    public LazyList(InternalQueryDaoAccess<E> internalQueryDaoAccess, Cursor cursor, boolean z5) {
        this.cursor = cursor;
        this.daoAccess = internalQueryDaoAccess;
        int count = cursor.getCount();
        this.size = count;
        if (z5) {
            this.entities = new ArrayList(count);
            for (int i3 = 0; i3 < this.size; i3++) {
                this.entities.add(null);
            }
        } else {
            this.entities = null;
        }
        if (this.size == 0) {
            cursor.close();
        }
        this.lock = new ReentrantLock();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void checkCached() {
        if (this.entities == null) {
            throw new DaoException("This operation only works with cached lazy lists");
        }
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        loadRemaining();
        return this.entities.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        loadRemaining();
        return this.entities.containsAll(collection);
    }

    @Override // java.util.List
    public E get(int i3) {
        List<E> list = this.entities;
        if (list == null) {
            this.lock.lock();
            try {
                return loadEntity(i3);
            } finally {
            }
        }
        E e = list.get(i3);
        if (e != null) {
            return e;
        }
        this.lock.lock();
        try {
            E e10 = this.entities.get(i3);
            if (e10 == null) {
                e10 = loadEntity(i3);
                this.entities.set(i3, e10);
                this.loadedCount++;
                if (this.loadedCount == this.size) {
                    this.cursor.close();
                }
            }
            return e10;
        } finally {
        }
    }

    public int getLoadedCount() {
        return this.loadedCount;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        loadRemaining();
        return this.entities.indexOf(obj);
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isLoadedCompletely() {
        return this.loadedCount == this.size;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new LazyIterator(0, false);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        loadRemaining();
        return this.entities.lastIndexOf(obj);
    }

    public CloseableListIterator<E> listIteratorAutoClose() {
        return new LazyIterator(0, true);
    }

    public E loadEntity(int i3) {
        if (!this.cursor.moveToPosition(i3)) {
            throw new DaoException(l0.j(i3, "Could not move to cursor location "));
        }
        E loadCurrent = this.daoAccess.loadCurrent(this.cursor, 0, true);
        if (loadCurrent != null) {
            return loadCurrent;
        }
        throw new DaoException(l0.j(i3, "Loading of entity failed (null) at position "));
    }

    public void loadRemaining() {
        checkCached();
        int size = this.entities.size();
        for (int i3 = 0; i3 < size; i3++) {
            get(i3);
        }
    }

    public E peek(int i3) {
        List<E> list = this.entities;
        if (list != null) {
            return list.get(i3);
        }
        return null;
    }

    @Override // java.util.List
    public E remove(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public E set(int i3, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.List
    public List<E> subList(int i3, int i10) {
        checkCached();
        for (int i11 = i3; i11 < i10; i11++) {
            get(i11);
        }
        return this.entities.subList(i3, i10);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        loadRemaining();
        return this.entities.toArray();
    }

    @Override // java.util.List
    public void add(int i3, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public CloseableListIterator<E> listIterator() {
        return new LazyIterator(0, false);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i3) {
        return new LazyIterator(i3, false);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        loadRemaining();
        return (T[]) this.entities.toArray(tArr);
    }
}
