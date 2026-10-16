package gf;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ff.n;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14056a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f14057b;

    /* renamed from: c, reason: collision with root package name */
    public b f14058c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14059d;

    public final void a(b bVar) {
        n nVar = (n) bVar;
        nVar.f13637g0.remove(this);
        if (!c()) {
            d(nVar);
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
        this.f14059d = false;
    }

    public final void b(a aVar) {
        ArrayList arrayList = this.f14056a;
        if (arrayList.contains(aVar)) {
            return;
        }
        arrayList.add(aVar);
        aVar.a(this, this.f14057b);
    }

    public final boolean c() {
        return this.f14057b == Integer.MAX_VALUE;
    }

    public void d(b bVar) {
    }

    public void e(b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
    }

    public void f(b bVar, CaptureRequest captureRequest, CaptureResult captureResult) {
    }

    public void g(b bVar, CaptureRequest captureRequest) {
        if (this.f14059d) {
            i(bVar);
            this.f14059d = false;
        }
    }

    public void h(b bVar) {
    }

    public void i(b bVar) {
        this.f14058c = bVar;
    }

    public final Object j(CameraCharacteristics.Key key, Object obj) {
        Object obj2 = ((n) this.f14058c).X.get(key);
        return obj2 == null ? obj : obj2;
    }

    public final void k(int i3) {
        if (i3 != this.f14057b) {
            this.f14057b = i3;
            ArrayList arrayList = this.f14056a;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((a) obj).a(this, this.f14057b);
            }
            if (this.f14057b == Integer.MAX_VALUE) {
                ((n) this.f14058c).f13637g0.remove(this);
                h(this.f14058c);
            }
        }
    }

    public final void l(b bVar) {
        this.f14058c = bVar;
        n nVar = (n) bVar;
        CopyOnWriteArrayList copyOnWriteArrayList = nVar.f13637g0;
        if (!copyOnWriteArrayList.contains(this)) {
            copyOnWriteArrayList.add(this);
        }
        if (nVar.f13631a0 != null) {
            i(bVar);
        } else {
            this.f14059d = true;
        }
    }
}
