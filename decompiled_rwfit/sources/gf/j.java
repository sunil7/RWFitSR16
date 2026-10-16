package gf;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class j extends e {
    public final ArrayList e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f14065f;

    public j(List list) {
        this.e = new ArrayList(list);
        this.f14065f = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((e) it.next()).b(new c(this, 2));
        }
    }

    @Override // gf.e
    public final void d(b bVar) {
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e eVar = (e) obj;
            if (!eVar.c()) {
                eVar.d(bVar);
            }
        }
    }

    @Override // gf.e
    public final void e(b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e eVar = (e) obj;
            if (!eVar.c()) {
                eVar.e(bVar, captureRequest, totalCaptureResult);
            }
        }
    }

    @Override // gf.e
    public final void f(b bVar, CaptureRequest captureRequest, CaptureResult captureResult) {
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e eVar = (e) obj;
            if (!eVar.c()) {
                eVar.f(bVar, captureRequest, captureResult);
            }
        }
    }

    @Override // gf.e
    public final void g(b bVar, CaptureRequest captureRequest) {
        super.g(bVar, captureRequest);
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e eVar = (e) obj;
            if (!eVar.c()) {
                eVar.g(bVar, captureRequest);
            }
        }
    }

    @Override // gf.e
    public final void i(b bVar) {
        this.f14058c = bVar;
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e eVar = (e) obj;
            if (!eVar.c()) {
                eVar.i(bVar);
            }
        }
    }
}
