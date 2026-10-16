package o4;

import android.database.Cursor;
import android.util.SparseArray;
import android.view.View;
import androidx.work.impl.WorkDatabase_Impl;
import b2.l;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.google.zxing.h;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import d4.p;
import ia.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import og.j;
import z3.v;

/* loaded from: classes.dex */
public final class e implements ia.b, j, re.a, com.bumptech.glide.load.data.d {

    /* renamed from: a, reason: collision with root package name */
    public Object f16737a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16738b;

    public /* synthetic */ e(Object obj, Object obj2) {
        this.f16738b = obj;
        this.f16737a = obj2;
    }

    public static h h(h hVar, float f2, float f10) {
        float f11 = hVar.f11247a;
        float f12 = f11 < f2 ? f11 - 1.0f : f11 + 1.0f;
        float f13 = hVar.f11248b;
        return new h(f12, f13 < f10 ? f13 - 1.0f : f13 + 1.0f);
    }

    public static h n(h hVar, h hVar2, int i3) {
        float f2 = hVar2.f11247a;
        float f10 = hVar.f11247a;
        float f11 = i3 + 1;
        float f12 = hVar2.f11248b;
        float f13 = hVar.f11248b;
        return new h(f10 + ((f2 - f10) / f11), f13 + ((f12 - f13) / f11));
    }

    @Override // re.a
    public void B(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            o6.b(this, "update but model == null!", new Object[0]);
            return;
        }
        if (L(fileDownloadModel.h()) == null) {
            synchronized (((SparseArray) this.f16737a)) {
                ((SparseArray) this.f16737a).put(fileDownloadModel.h(), fileDownloadModel);
            }
        } else {
            synchronized (((SparseArray) this.f16737a)) {
                ((SparseArray) this.f16737a).remove(fileDownloadModel.h());
                ((SparseArray) this.f16737a).put(fileDownloadModel.h(), fileDownloadModel);
            }
        }
    }

    @Override // re.a
    public void F(int i3) {
        remove(i3);
    }

    @Override // re.a
    public void G(int i3, int i10, long j4) {
        synchronized (((SparseArray) this.f16738b)) {
            try {
                List<ve.a> list = (List) ((SparseArray) this.f16738b).get(i3);
                if (list == null) {
                    return;
                }
                for (ve.a aVar : list) {
                    if (aVar.f19232b == i10) {
                        aVar.f19234d = j4;
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // re.a
    public void H(int i3, long j4) {
    }

    @Override // re.a
    public void I(int i3, int i10, long j4, long j10, String str) {
    }

    @Override // re.a
    public ArrayList J(int i3) {
        List list;
        ArrayList arrayList = new ArrayList();
        synchronized (((SparseArray) this.f16738b)) {
            list = (List) ((SparseArray) this.f16738b).get(i3);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // re.a
    public FileDownloadModel L(int i3) {
        FileDownloadModel fileDownloadModel;
        synchronized (((SparseArray) this.f16737a)) {
            fileDownloadModel = (FileDownloadModel) ((SparseArray) this.f16737a).get(i3);
        }
        return fileDownloadModel;
    }

    @Override // re.a
    public void N(int i3, int i10) {
    }

    @Override // re.a
    public void O(int i3, long j4) {
    }

    public synchronized void a(yh.j jVar) {
        try {
            yh.j jVar2 = (yh.j) this.f16738b;
            if (jVar2 != null) {
                jVar2.f20167c = jVar;
                this.f16738b = jVar;
            } else {
                if (((yh.j) this.f16737a) != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f16738b = jVar;
                this.f16737a = jVar;
            }
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public ArrayList b(String str) {
        l b3 = l.b(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            b3.bindNull(1);
        } else {
            b3.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f16737a;
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

    @Override // com.bumptech.glide.load.data.d
    public void c(Exception exc) {
        v vVar = (v) this.f16738b;
        p pVar = (p) this.f16737a;
        p pVar2 = vVar.f20313f;
        if (pVar2 == null || pVar2 != pVar) {
            return;
        }
        z3.c cVar = vVar.f20314g;
        com.bumptech.glide.load.data.e eVar = pVar.f12282c;
        vVar.f20310b.a(cVar, exc, eVar, eVar.e());
    }

    @Override // re.a
    public void clear() {
        synchronized (((SparseArray) this.f16737a)) {
            ((SparseArray) this.f16737a).clear();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void d(Object obj) {
        v vVar = (v) this.f16738b;
        p pVar = (p) this.f16737a;
        p pVar2 = vVar.f20313f;
        if (pVar2 == null || pVar2 != pVar) {
            return;
        }
        z3.h hVar = vVar.f20309a.f20233p;
        if (obj != null && hVar.a(pVar.f12282c.e())) {
            vVar.e = obj;
            vVar.f20310b.l();
            return;
        }
        x3.c cVar = pVar.f12280a;
        com.bumptech.glide.load.data.e eVar = pVar.f12282c;
        vVar.f20310b.c(cVar, obj, eVar, eVar.e(), vVar.f20314g);
    }

    public synchronized List e(String str) {
        List list;
        if (!((ArrayList) this.f16737a).contains(str)) {
            ((ArrayList) this.f16737a).add(str);
        }
        list = (List) ((HashMap) this.f16738b).get(str);
        if (list == null) {
            list = new ArrayList();
            ((HashMap) this.f16738b).put(str, list);
        }
        return list;
    }

    public synchronized ArrayList f(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.f16737a;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            List<d> list = (List) ((HashMap) this.f16738b).get((String) obj);
            if (list != null) {
                for (d dVar : list) {
                    if ((dVar.f16734a.isAssignableFrom(cls) && cls2.isAssignableFrom(dVar.f16735b)) && !arrayList.contains(dVar.f16735b)) {
                        arrayList.add(dVar.f16735b);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean g(h hVar) {
        float f2 = hVar.f11247a;
        if (f2 < 0.0f) {
            return false;
        }
        sc.b bVar = (sc.b) this.f16737a;
        if (f2 > bVar.f18221a - 1) {
            return false;
        }
        float f10 = hVar.f11248b;
        return f10 > 0.0f && f10 <= ((float) (bVar.f18222b - 1));
    }

    public void i(int i3, View view) {
        int headerCount = i3 - ((SwipeRecyclerView) this.f16737a).getHeaderCount();
        if (headerCount >= 0) {
            ((e) ((j) this.f16738b)).i(headerCount, view);
        }
    }

    @Override // ia.b
    public void j(ia.f fVar) {
        ((Map) ((c) this.f16738b).f16733b).remove((g) this.f16737a);
    }

    public synchronized yh.j k() {
        yh.j jVar;
        jVar = (yh.j) this.f16737a;
        if (jVar != null) {
            yh.j jVar2 = jVar.f20167c;
            this.f16737a = jVar2;
            if (jVar2 == null) {
                this.f16738b = null;
            }
        }
        return jVar;
    }

    @Override // re.a
    public void l(int i3) {
    }

    @Override // re.a
    public void m(int i3, Exception exc, long j4) {
    }

    @Override // re.a
    public void o(int i3) {
        synchronized (((SparseArray) this.f16738b)) {
            ((SparseArray) this.f16738b).remove(i3);
        }
    }

    public int p(h hVar, h hVar2) {
        int i3 = (int) hVar.f11247a;
        int i10 = (int) hVar.f11248b;
        int i11 = (int) hVar2.f11247a;
        sc.b bVar = (sc.b) this.f16737a;
        int min = Math.min(bVar.f18222b - 1, (int) hVar2.f11248b);
        int i12 = 0;
        boolean z5 = Math.abs(min - i10) > Math.abs(i11 - i3);
        if (z5) {
            i3 = i10;
            i10 = i3;
            i11 = min;
            min = i11;
        }
        int abs = Math.abs(i11 - i3);
        int abs2 = Math.abs(min - i10);
        int i13 = (-abs) / 2;
        int i14 = i10 < min ? 1 : -1;
        int i15 = i3 >= i11 ? -1 : 1;
        boolean b3 = bVar.b(z5 ? i10 : i3, z5 ? i3 : i10);
        while (i3 != i11) {
            boolean b10 = bVar.b(z5 ? i10 : i3, z5 ? i3 : i10);
            if (b10 != b3) {
                i12++;
                b3 = b10;
            }
            i13 += abs2;
            if (i13 > 0) {
                if (i10 == min) {
                    return i12;
                }
                i10 += i14;
                i13 -= abs;
            }
            i3 += i15;
        }
        return i12;
    }

    @Override // re.a
    public void r(int i3, Exception exc) {
    }

    @Override // re.a
    public boolean remove(int i3) {
        synchronized (((SparseArray) this.f16737a)) {
            ((SparseArray) this.f16737a).remove(i3);
        }
        return true;
    }

    @Override // re.a
    public void s(int i3) {
    }

    @Override // re.a
    public void v(ve.a aVar) {
        int i3 = aVar.f19231a;
        synchronized (((SparseArray) this.f16738b)) {
            try {
                List list = (List) ((SparseArray) this.f16738b).get(i3);
                if (list == null) {
                    list = new ArrayList();
                    ((SparseArray) this.f16738b).put(i3, list);
                }
                list.add(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // re.a
    public void w(long j4, String str, String str2, int i3) {
    }

    public e(int i3) {
        switch (i3) {
            case 5:
                this.f16737a = new SparseArray();
                this.f16738b = new SparseArray();
                break;
            default:
                this.f16737a = new ArrayList();
                this.f16738b = new HashMap();
                break;
        }
    }

    public e(WorkDatabase_Impl workDatabase_Impl, int i3) {
        switch (i3) {
            case 9:
                this.f16737a = workDatabase_Impl;
                this.f16738b = new x2.b(workDatabase_Impl, 3);
                break;
            default:
                this.f16737a = workDatabase_Impl;
                this.f16738b = new x2.b(workDatabase_Impl, 0);
                break;
        }
    }

    public e(ue.d dVar) {
        this.f16738b = dVar;
        this.f16737a = new ArrayList();
        for (int i3 = 0; i3 < 5; i3++) {
            ((ArrayList) this.f16737a).add(new ue.f(this, i3));
        }
    }
}
