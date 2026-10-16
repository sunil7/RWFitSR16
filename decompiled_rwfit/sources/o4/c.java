package o4;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.b0;
import androidx.work.impl.WorkDatabase_Impl;
import b2.l;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.mlkit_vision_barcode.g0;
import com.google.android.gms.internal.mlkit_vision_barcode.gf;
import com.google.android.gms.internal.mlkit_vision_barcode.j0;
import com.google.android.gms.internal.mlkit_vision_barcode.jf;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.download.g;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import ia.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import o2.p;
import o2.r;
import o2.s;
import og.i;
import og.k;
import og.m;
import vg.o;

/* loaded from: classes.dex */
public final class c implements i, k, s, vh.c, vg.b {

    /* renamed from: a, reason: collision with root package name */
    public Object f16732a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16733b;

    public c(String str, String str2) {
        Object[] objArr = {str, 23};
        if (str.length() > 23) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        this.f16732a = str;
        this.f16733b = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    public rb.b a() {
        return new rb.b((String) this.f16732a, ((HashMap) this.f16733b) == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap((HashMap) this.f16733b)));
    }

    public void b(jf jfVar) {
        j jVar = new j(9, this, jfVar);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            jVar.run();
        } else {
            ((Handler) this.f16733b).post(jVar);
        }
    }

    public boolean c(int i3) {
        if (i3 == 0) {
            o6.b(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i3));
            return false;
        }
        re.a aVar = (re.a) this.f16732a;
        if (j(aVar.L(i3))) {
            o6.b(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i3));
            return false;
        }
        aVar.remove(i3);
        aVar.o(i3);
        return true;
    }

    @Override // og.k
    public void d(m mVar, int i3) {
        int headerCount = i3 - ((SwipeRecyclerView) this.f16732a).getHeaderCount();
        if (headerCount >= 0) {
            ((k) this.f16733b).d(mVar, headerCount);
        }
    }

    public Long e(String str) {
        l b3 = l.b(1, "SELECT long_value FROM Preference where `key`=?");
        b3.bindString(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f16732a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            Long l3 = null;
            if (g10.moveToFirst() && !g10.isNull(0)) {
                l3 = Long.valueOf(g10.getLong(0));
            }
            return l3;
        } finally {
            g10.close();
            b3.c();
        }
    }

    public long f(int i3) {
        re.a aVar = (re.a) this.f16732a;
        FileDownloadModel L = aVar.L(i3);
        long j4 = 0;
        if (L != null) {
            int a3 = L.a();
            if (a3 <= 1) {
                return L.j();
            }
            ArrayList J = aVar.J(i3);
            if (J.size() == a3) {
                int size = J.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = J.get(i10);
                    i10++;
                    ve.a aVar2 = (ve.a) obj;
                    j4 += aVar2.f19234d - aVar2.f19233c;
                }
                return j4;
            }
        }
        return 0L;
    }

    public ArrayList g(String str) {
        l b3 = l.b(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        if (str == null) {
            b3.bindNull(1);
        } else {
            b3.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f16732a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            ArrayList arrayList = new ArrayList(g10.getCount());
            while (g10.moveToNext()) {
                arrayList.add(g10.getString(0));
            }
            return arrayList;
        } finally {
            g10.close();
            b3.c();
        }
    }

    public void h(x2.c cVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f16732a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((x2.b) this.f16733b).e(cVar);
            workDatabase_Impl.h();
        } finally {
            workDatabase_Impl.f();
        }
    }

    @Override // vg.b
    public void i(Object obj, Object obj2) {
        ((Map) obj).put(((o) this.f16733b).apply(obj2), ((o) this.f16732a).apply(obj2));
    }

    @Override // vh.c
    public Iterator iterator() {
        return new vh.b(this);
    }

    public boolean j(FileDownloadModel fileDownloadModel) {
        boolean z5;
        if (fileDownloadModel != null) {
            b0 b0Var = (b0) this.f16733b;
            int h4 = fileDownloadModel.h();
            synchronized (b0Var) {
                com.liulishuo.filedownloader.download.d dVar = (com.liulishuo.filedownloader.download.d) ((SparseArray) b0Var.f873b).get(h4);
                if (dVar != null) {
                    if (dVar.h()) {
                        z5 = true;
                    }
                }
                z5 = false;
            }
            if (fileDownloadModel.k() < 0) {
                if (z5) {
                }
            } else if (!z5) {
                o6.a(6, this, null, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(fileDownloadModel.h()), Byte.valueOf(fileDownloadModel.k()));
                return false;
            }
            return true;
        }
        return false;
    }

    public void k(int i3, View view) {
        int headerCount = i3 - ((SwipeRecyclerView) this.f16732a).getHeaderCount();
        if (headerCount >= 0) {
            ((c) ((i) this.f16733b)).k(headerCount, view);
        }
    }

    public boolean l(int i3) {
        FileDownloadModel L = ((re.a) this.f16732a).L(i3);
        int i10 = 0;
        if (L == null) {
            return false;
        }
        L.D((byte) -2);
        b0 b0Var = (b0) this.f16733b;
        b0Var.d();
        synchronized (b0Var) {
            try {
                com.liulishuo.filedownloader.download.d dVar = (com.liulishuo.filedownloader.download.d) ((SparseArray) b0Var.f873b).get(i3);
                if (dVar != null) {
                    dVar.f11423s = true;
                    com.liulishuo.filedownloader.download.e eVar = dVar.f11418m;
                    if (eVar != null) {
                        eVar.f11431f = true;
                        g gVar = eVar.e;
                        if (gVar != null) {
                            gVar.f11460m = true;
                        }
                    }
                    ArrayList arrayList = (ArrayList) dVar.f11417l.clone();
                    int size = arrayList.size();
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        com.liulishuo.filedownloader.download.e eVar2 = (com.liulishuo.filedownloader.download.e) obj;
                        if (eVar2 != null) {
                            eVar2.f11431f = true;
                            g gVar2 = eVar2.e;
                            if (gVar2 != null) {
                                gVar2.f11460m = true;
                            }
                        }
                    }
                    ((ThreadPoolExecutor) b0Var.f874c).remove(dVar);
                }
                ((SparseArray) b0Var.f873b).remove(i3);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }

    public void m() {
        ArrayList arrayList;
        int i3;
        b0 b0Var = (b0) this.f16733b;
        synchronized (b0Var) {
            b0Var.d();
            arrayList = new ArrayList();
            i3 = 0;
            for (int i10 = 0; i10 < ((SparseArray) b0Var.f873b).size(); i10++) {
                SparseArray sparseArray = (SparseArray) b0Var.f873b;
                arrayList.add(Integer.valueOf(((com.liulishuo.filedownloader.download.d) sparseArray.get(sparseArray.keyAt(i10))).f11408b.h()));
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            l(((Integer) obj).intValue());
        }
    }

    public void n(gf gfVar) {
        ((androidx.lifecycle.b0) this.f16732a).i(gfVar);
        boolean z5 = gfVar instanceof r;
        androidx.work.impl.utils.futures.b bVar = (androidx.work.impl.utils.futures.b) this.f16733b;
        if (z5) {
            bVar.j((r) gfVar);
        } else if (gfVar instanceof p) {
            bVar.k(((p) gfVar).f16722a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void o(java.lang.String r18, java.lang.String r19, boolean r20, int r21, int r22, int r23, boolean r24, com.liulishuo.filedownloader.model.FileDownloadHeader r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.c.o(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.liulishuo.filedownloader.model.FileDownloadHeader, boolean):void");
    }

    public void p(g0 g0Var) {
        if (((HashMap) this.f16733b) == null) {
            this.f16733b = new HashMap();
        }
        ((HashMap) this.f16733b).put(j0.class, g0Var);
    }

    public void q(boolean z5, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (((Map) this.f16732a)) {
            hashMap = new HashMap((Map) this.f16732a);
        }
        synchronized (((Map) this.f16733b)) {
            hashMap2 = new HashMap((Map) this.f16733b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z5 || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z5 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((ia.g) entry2.getKey()).b(new ApiException(status));
            }
        }
    }

    public String r(String str) {
        String str2 = (String) this.f16733b;
        return str2 == null ? str : str2.concat(str);
    }

    public c(int i3) {
        int i10;
        switch (i3) {
            case 1:
                this.f16732a = new ArrayList();
                this.f16733b = new Handler(Looper.getMainLooper());
                break;
            case 2:
                this.f16732a = Collections.synchronizedMap(new WeakHashMap());
                this.f16733b = Collections.synchronizedMap(new WeakHashMap());
                break;
            case 5:
                this.f16732a = new androidx.lifecycle.b0();
                this.f16733b = new androidx.work.impl.utils.futures.b();
                n(s.P0);
                break;
            case 7:
                n9.b bVar = n9.b.f16438d;
                this.f16732a = new SparseIntArray();
                this.f16733b = bVar;
                break;
            case 11:
                de.i iVar = com.liulishuo.filedownloader.download.c.f11405a;
                this.f16732a = iVar.e();
                if (((eb.e) iVar.f().f16381b) == null) {
                    i10 = ye.c.f20115a.e;
                } else {
                    i10 = ye.c.f20115a.e;
                }
                int i11 = i10;
                b0 b0Var = new b0();
                b0Var.f873b = new SparseArray();
                b0Var.f872a = 0;
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ye.b("Network"));
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                b0Var.f874c = threadPoolExecutor;
                this.f16733b = b0Var;
                break;
            default:
                this.f16732a = new AtomicReference();
                this.f16733b = new m0.b();
                break;
        }
    }

    public c(WorkDatabase_Impl workDatabase_Impl, int i3) {
        switch (i3) {
            case 13:
                this.f16732a = workDatabase_Impl;
                this.f16733b = new x2.b(workDatabase_Impl, 5);
                break;
            default:
                this.f16732a = workDatabase_Impl;
                this.f16733b = new x2.b(workDatabase_Impl, 1);
                break;
        }
    }

    public c(o oVar, o oVar2) {
        this.f16732a = oVar;
        this.f16733b = oVar2;
    }
}
