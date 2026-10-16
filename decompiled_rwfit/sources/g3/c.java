package g3;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: g, reason: collision with root package name */
    public static volatile c f13796g;

    /* renamed from: h, reason: collision with root package name */
    public static final Object f13797h = new Object();
    public final Object e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final Object f13802f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public LongSparseArray f13798a = new LongSparseArray();

    /* renamed from: b, reason: collision with root package name */
    public LongSparseArray f13799b = new LongSparseArray();

    /* renamed from: c, reason: collision with root package name */
    public LongSparseArray f13800c = new LongSparseArray();

    /* renamed from: d, reason: collision with root package name */
    public LongSparseArray f13801d = new LongSparseArray();

    public static short a(LongSparseArray longSparseArray, long j4) {
        synchronized (longSparseArray) {
            try {
                b bVar = (b) longSparseArray.get(j4);
                if (bVar == null) {
                    return (short) 0;
                }
                short max = (short) Math.max(1L, Math.min(32767L, (SystemClock.elapsedRealtime() - bVar.f13794b) / 1000));
                if (!bVar.f13795c) {
                    max = (short) (-max);
                }
                return max;
            } finally {
            }
        }
    }

    public static void b(ArrayList arrayList, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i3 = 0;
        if (longSparseArray.size() == 0) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                a aVar = (a) obj;
                b bVar = new b();
                bVar.f13793a = aVar.a();
                bVar.f13794b = elapsedRealtime;
                bVar.f13795c = false;
                longSparseArray2.put(aVar.getId(), bVar);
            }
            return;
        }
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            a aVar2 = (a) obj2;
            long id2 = aVar2.getId();
            b bVar2 = (b) longSparseArray.get(id2);
            if (bVar2 == null) {
                bVar2 = new b();
                bVar2.f13793a = aVar2.a();
                bVar2.f13794b = elapsedRealtime;
                bVar2.f13795c = true;
            } else if (bVar2.f13793a != aVar2.a()) {
                bVar2.f13793a = aVar2.a();
                bVar2.f13794b = elapsedRealtime;
                bVar2.f13795c = true;
            }
            longSparseArray2.put(id2, bVar2);
        }
    }

    public static c c() {
        if (f13796g == null) {
            synchronized (f13797h) {
                try {
                    if (f13796g == null) {
                        f13796g = new c();
                    }
                } finally {
                }
            }
        }
        return f13796g;
    }

    public final void d(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        synchronized (this.e) {
            b(arrayList, this.f13798a, this.f13799b);
            LongSparseArray longSparseArray = this.f13798a;
            this.f13798a = this.f13799b;
            this.f13799b = longSparseArray;
            longSparseArray.clear();
        }
    }

    public final void e(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        synchronized (this.f13802f) {
            b(arrayList, this.f13800c, this.f13801d);
            LongSparseArray longSparseArray = this.f13800c;
            this.f13800c = this.f13801d;
            this.f13801d = longSparseArray;
            longSparseArray.clear();
        }
    }
}
