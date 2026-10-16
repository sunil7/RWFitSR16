package org.greenrobot.greendao.internal;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Arrays;
import org.greenrobot.greendao.DaoLog;

/* loaded from: classes2.dex */
public final class LongHashMap<T> {
    private int capacity;
    private int size;
    private Entry<T>[] table;
    private int threshold;

    public static final class Entry<T> {
        final long key;
        Entry<T> next;
        T value;

        public Entry(long j4, T t8, Entry<T> entry) {
            this.key = j4;
            this.value = t8;
            this.next = entry;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public void clear() {
        this.size = 0;
        Arrays.fill(this.table, (Object) null);
    }

    public boolean containsKey(long j4) {
        for (Entry<T> entry = this.table[((((int) (j4 >>> 32)) ^ ((int) j4)) & SubsamplingScaleImageView.TILE_SIZE_AUTO) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j4) {
                return true;
            }
        }
        return false;
    }

    public T get(long j4) {
        for (Entry<T> entry = this.table[((((int) (j4 >>> 32)) ^ ((int) j4)) & SubsamplingScaleImageView.TILE_SIZE_AUTO) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j4) {
                return entry.value;
            }
        }
        return null;
    }

    public void logStats() {
        int i3 = 0;
        for (Entry<T> entry : this.table) {
            while (entry != null) {
                entry = entry.next;
                if (entry != null) {
                    i3++;
                }
            }
        }
        DaoLog.d("load: " + (this.size / this.capacity) + ", size: " + this.size + ", capa: " + this.capacity + ", collisions: " + i3 + ", collision ratio: " + (i3 / this.size));
    }

    public T put(long j4, T t8) {
        int i3 = ((((int) (j4 >>> 32)) ^ ((int) j4)) & SubsamplingScaleImageView.TILE_SIZE_AUTO) % this.capacity;
        Entry<T> entry = this.table[i3];
        for (Entry<T> entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.key == j4) {
                T t10 = entry2.value;
                entry2.value = t8;
                return t10;
            }
        }
        this.table[i3] = new Entry<>(j4, t8, entry);
        int i10 = this.size + 1;
        this.size = i10;
        if (i10 <= this.threshold) {
            return null;
        }
        setCapacity(this.capacity * 2);
        return null;
    }

    public T remove(long j4) {
        int i3 = ((((int) (j4 >>> 32)) ^ ((int) j4)) & SubsamplingScaleImageView.TILE_SIZE_AUTO) % this.capacity;
        Entry<T> entry = this.table[i3];
        Entry<T> entry2 = null;
        while (entry != null) {
            Entry<T> entry3 = entry.next;
            if (entry.key == j4) {
                if (entry2 == null) {
                    this.table[i3] = entry3;
                } else {
                    entry2.next = entry3;
                }
                this.size--;
                return entry.value;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public void reserveRoom(int i3) {
        setCapacity((i3 * 5) / 3);
    }

    public void setCapacity(int i3) {
        Entry<T>[] entryArr = new Entry[i3];
        int length = this.table.length;
        for (int i10 = 0; i10 < length; i10++) {
            Entry<T> entry = this.table[i10];
            while (entry != null) {
                long j4 = entry.key;
                int i11 = ((((int) j4) ^ ((int) (j4 >>> 32))) & SubsamplingScaleImageView.TILE_SIZE_AUTO) % i3;
                Entry<T> entry2 = entry.next;
                entry.next = entryArr[i11];
                entryArr[i11] = entry;
                entry = entry2;
            }
        }
        this.table = entryArr;
        this.capacity = i3;
        this.threshold = (i3 * 4) / 3;
    }

    public int size() {
        return this.size;
    }

    public LongHashMap(int i3) {
        this.capacity = i3;
        this.threshold = (i3 * 4) / 3;
        this.table = new Entry[i3];
    }
}
