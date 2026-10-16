package b2;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class l implements SupportSQLiteQuery, SupportSQLiteProgram {

    /* renamed from: i, reason: collision with root package name */
    public static final TreeMap f3135i = new TreeMap();

    /* renamed from: a, reason: collision with root package name */
    public volatile String f3136a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f3137b;

    /* renamed from: c, reason: collision with root package name */
    public final double[] f3138c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f3139d;
    public final byte[][] e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f3140f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3141g;

    /* renamed from: h, reason: collision with root package name */
    public int f3142h;

    public l(int i3) {
        this.f3141g = i3;
        int i10 = i3 + 1;
        this.f3140f = new int[i10];
        this.f3137b = new long[i10];
        this.f3138c = new double[i10];
        this.f3139d = new String[i10];
        this.e = new byte[i10][];
    }

    public static l b(int i3, String str) {
        TreeMap treeMap = f3135i;
        synchronized (treeMap) {
            try {
                Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i3));
                if (ceilingEntry == null) {
                    l lVar = new l(i3);
                    lVar.f3136a = str;
                    lVar.f3142h = i3;
                    return lVar;
                }
                treeMap.remove(ceilingEntry.getKey());
                l lVar2 = (l) ceilingEntry.getValue();
                lVar2.f3136a = str;
                lVar2.f3142h = i3;
                return lVar2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int i3, byte[] bArr) {
        this.f3140f[i3] = 5;
        this.e[i3] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i3, double d5) {
        this.f3140f[i3] = 3;
        this.f3138c[i3] = d5;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i3, long j4) {
        this.f3140f[i3] = 2;
        this.f3137b[i3] = j4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i3) {
        this.f3140f[i3] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int i3, String str) {
        this.f3140f[i3] = 4;
        this.f3139d[i3] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i3 = 1; i3 <= this.f3142h; i3++) {
            int i10 = this.f3140f[i3];
            if (i10 == 1) {
                supportSQLiteProgram.bindNull(i3);
            } else if (i10 == 2) {
                supportSQLiteProgram.bindLong(i3, this.f3137b[i3]);
            } else if (i10 == 3) {
                supportSQLiteProgram.bindDouble(i3, this.f3138c[i3]);
            } else if (i10 == 4) {
                supportSQLiteProgram.bindString(i3, this.f3139d[i3]);
            } else if (i10 == 5) {
                supportSQLiteProgram.bindBlob(i3, this.e[i3]);
            }
        }
    }

    public final void c() {
        TreeMap treeMap = f3135i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f3141g), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i3 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i3;
                }
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void clearBindings() {
        Arrays.fill(this.f3140f, 1);
        Arrays.fill(this.f3139d, (Object) null);
        Arrays.fill(this.e, (Object) null);
        this.f3136a = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final int getArgCount() {
        return this.f3142h;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String getSql() {
        return this.f3136a;
    }
}
