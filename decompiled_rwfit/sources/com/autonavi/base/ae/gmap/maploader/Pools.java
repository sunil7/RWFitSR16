package com.autonavi.base.ae.gmap.maploader;

/* loaded from: classes.dex */
public final class Pools {

    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T t8);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i3) {
            if (i3 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i3];
        }

        private boolean isInPool(T t8) {
            for (int i3 = 0; i3 < this.mPoolSize; i3++) {
                if (this.mPool[i3] == t8) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            int i3 = this.mPoolSize;
            if (i3 <= 0) {
                return null;
            }
            int i10 = i3 - 1;
            Object[] objArr = this.mPool;
            T t8 = (T) objArr[i10];
            objArr[i10] = null;
            this.mPoolSize = i10;
            return t8;
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public void destory() {
            int i3 = 0;
            while (true) {
                Object[] objArr = this.mPool;
                if (i3 >= objArr.length) {
                    return;
                }
                objArr[i3] = null;
                i3++;
            }
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public boolean release(T t8) {
            if (isInPool(t8)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i3 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i3 >= objArr.length) {
                return false;
            }
            objArr[i3] = t8;
            this.mPoolSize = i3 + 1;
            return true;
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i3) {
            super(i3);
            this.mLock = new Object();
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.SimplePool, com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            T t8;
            synchronized (this.mLock) {
                t8 = (T) super.acquire();
            }
            return t8;
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.SimplePool, com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public boolean release(T t8) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t8);
            }
            return release;
        }
    }

    private Pools() {
    }
}
