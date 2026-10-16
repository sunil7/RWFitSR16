package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import n.t;

/* loaded from: classes.dex */
public final class o implements p {

    /* renamed from: a, reason: collision with root package name */
    public final List f16632a;

    /* renamed from: b, reason: collision with root package name */
    public final t f16633b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.camera.core.impl.utils.executor.b f16634c;

    /* renamed from: d, reason: collision with root package name */
    public g f16635d = null;

    public o(ArrayList arrayList, androidx.camera.core.impl.utils.executor.b bVar, t tVar) {
        this.f16632a = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f16633b = tVar;
        this.f16634c = bVar;
    }

    @Override // o.p
    public final Object a() {
        return null;
    }

    @Override // o.p
    public final void b(g gVar) {
        this.f16635d = gVar;
    }

    @Override // o.p
    public final int c() {
        return 0;
    }

    @Override // o.p
    public final CameraCaptureSession.StateCallback d() {
        return this.f16633b;
    }

    @Override // o.p
    public final List e() {
        return this.f16632a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (Objects.equals(this.f16635d, oVar.f16635d)) {
                List list = this.f16632a;
                int size = list.size();
                List list2 = oVar.f16632a;
                if (size == list2.size()) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        if (((h) list.get(i3)).equals(list2.get(i3))) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // o.p
    public final g f() {
        return this.f16635d;
    }

    @Override // o.p
    public final Executor g() {
        return this.f16634c;
    }

    @Override // o.p
    public final void h(CaptureRequest captureRequest) {
    }

    public final int hashCode() {
        int hashCode = this.f16632a.hashCode() ^ 31;
        int i3 = (hashCode << 5) - hashCode;
        g gVar = this.f16635d;
        int hashCode2 = (gVar == null ? 0 : gVar.f16622a.f16621a.hashCode()) ^ i3;
        return (hashCode2 << 5) - hashCode2;
    }
}
