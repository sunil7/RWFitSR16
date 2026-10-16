package androidx.recyclerview.widget;

import android.util.SparseIntArray;

/* loaded from: classes.dex */
public abstract class c0 {
    final SparseIntArray mSpanIndexCache = new SparseIntArray();
    final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
    private boolean mCacheSpanIndices = false;
    private boolean mCacheSpanGroupIndices = false;

    public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i3) {
        int size = sparseIntArray.size() - 1;
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            if (sparseIntArray.keyAt(i11) < i3) {
                i10 = i11 + 1;
            } else {
                size = i11 - 1;
            }
        }
        int i12 = i10 - 1;
        if (i12 < 0 || i12 >= sparseIntArray.size()) {
            return -1;
        }
        return sparseIntArray.keyAt(i12);
    }

    public int getCachedSpanGroupIndex(int i3, int i10) {
        if (!this.mCacheSpanGroupIndices) {
            return getSpanGroupIndex(i3, i10);
        }
        int i11 = this.mSpanGroupIndexCache.get(i3, -1);
        if (i11 != -1) {
            return i11;
        }
        int spanGroupIndex = getSpanGroupIndex(i3, i10);
        this.mSpanGroupIndexCache.put(i3, spanGroupIndex);
        return spanGroupIndex;
    }

    public int getCachedSpanIndex(int i3, int i10) {
        if (!this.mCacheSpanIndices) {
            return getSpanIndex(i3, i10);
        }
        int i11 = this.mSpanIndexCache.get(i3, -1);
        if (i11 != -1) {
            return i11;
        }
        int spanIndex = getSpanIndex(i3, i10);
        this.mSpanIndexCache.put(i3, spanIndex);
        return spanIndex;
    }

    public int getSpanGroupIndex(int i3, int i10) {
        int i11;
        int i12;
        int i13;
        int findFirstKeyLessThan;
        if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i3)) == -1) {
            i11 = 0;
            i12 = 0;
            i13 = 0;
        } else {
            i12 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
            i13 = findFirstKeyLessThan + 1;
            i11 = getSpanSize(findFirstKeyLessThan) + getCachedSpanIndex(findFirstKeyLessThan, i10);
            if (i11 == i10) {
                i12++;
                i11 = 0;
            }
        }
        int spanSize = getSpanSize(i3);
        while (i13 < i3) {
            int spanSize2 = getSpanSize(i13);
            i11 += spanSize2;
            if (i11 == i10) {
                i12++;
                i11 = 0;
            } else if (i11 > i10) {
                i12++;
                i11 = spanSize2;
            }
            i13++;
        }
        return i11 + spanSize > i10 ? i12 + 1 : i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getSpanIndex(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.getSpanSize(r6)
            r1 = 0
            if (r0 != r7) goto L8
            return r1
        L8:
            boolean r2 = r5.mCacheSpanIndices
            if (r2 == 0) goto L20
            android.util.SparseIntArray r2 = r5.mSpanIndexCache
            int r2 = findFirstKeyLessThan(r2, r6)
            if (r2 < 0) goto L20
            android.util.SparseIntArray r3 = r5.mSpanIndexCache
            int r3 = r3.get(r2)
            int r4 = r5.getSpanSize(r2)
            int r4 = r4 + r3
            goto L30
        L20:
            r2 = r1
            r4 = r2
        L22:
            if (r2 >= r6) goto L33
            int r3 = r5.getSpanSize(r2)
            int r4 = r4 + r3
            if (r4 != r7) goto L2d
            r4 = r1
            goto L30
        L2d:
            if (r4 <= r7) goto L30
            r4 = r3
        L30:
            int r2 = r2 + 1
            goto L22
        L33:
            int r0 = r0 + r4
            if (r0 > r7) goto L37
            return r4
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.c0.getSpanIndex(int, int):int");
    }

    public abstract int getSpanSize(int i3);

    public void invalidateSpanGroupIndexCache() {
        this.mSpanGroupIndexCache.clear();
    }

    public void invalidateSpanIndexCache() {
        this.mSpanIndexCache.clear();
    }

    public boolean isSpanGroupIndexCacheEnabled() {
        return this.mCacheSpanGroupIndices;
    }

    public boolean isSpanIndexCacheEnabled() {
        return this.mCacheSpanIndices;
    }

    public void setSpanGroupIndexCacheEnabled(boolean z5) {
        if (!z5) {
            this.mSpanGroupIndexCache.clear();
        }
        this.mCacheSpanGroupIndices = z5;
    }

    public void setSpanIndexCacheEnabled(boolean z5) {
        if (!z5) {
            this.mSpanGroupIndexCache.clear();
        }
        this.mCacheSpanIndices = z5;
    }
}
