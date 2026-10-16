package androidx.camera.view;

import androidx.camera.core.impl.CameraInternal$State;
import androidx.camera.core.impl.a1;
import androidx.camera.core.impl.h0;
import androidx.camera.core.impl.u;
import androidx.camera.view.PreviewView;
import androidx.lifecycle.b0;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import de.o;
import h0.e;
import java.util.ArrayList;
import x.h;
import x.i;

/* loaded from: classes.dex */
public final class a implements a1 {

    /* renamed from: a, reason: collision with root package name */
    public final u f1583a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f1584b;

    /* renamed from: c, reason: collision with root package name */
    public PreviewView.StreamState f1585c;

    /* renamed from: d, reason: collision with root package name */
    public final e f1586d;
    public x.d e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1587f = false;

    public a(u uVar, b0 b0Var, e eVar) {
        this.f1583a = uVar;
        this.f1584b = b0Var;
        this.f1586d = eVar;
        synchronized (this) {
            this.f1585c = (PreviewView.StreamState) b0Var.d();
        }
    }

    @Override // androidx.camera.core.impl.a1
    public final void a(Object obj) {
        CameraInternal$State cameraInternal$State = (CameraInternal$State) obj;
        if (cameraInternal$State == CameraInternal$State.CLOSING || cameraInternal$State == CameraInternal$State.CLOSED || cameraInternal$State == CameraInternal$State.RELEASING || cameraInternal$State == CameraInternal$State.RELEASED) {
            b(PreviewView.StreamState.IDLE);
            if (this.f1587f) {
                this.f1587f = false;
                x.d dVar = this.e;
                if (dVar != null) {
                    dVar.cancel(false);
                    this.e = null;
                    return;
                }
                return;
            }
            return;
        }
        if ((cameraInternal$State == CameraInternal$State.OPENING || cameraInternal$State == CameraInternal$State.OPEN || cameraInternal$State == CameraInternal$State.PENDING_OPEN) && !this.f1587f) {
            b(PreviewView.StreamState.IDLE);
            ArrayList arrayList = new ArrayList();
            u uVar = this.f1583a;
            x.d b3 = x.d.b(ve.a(new h0(this, 2, uVar, arrayList)));
            h0.b bVar = new h0.b(this);
            w.a a3 = a6.a();
            b3.getClass();
            x.b f2 = i.f(b3, bVar, a3);
            h0.b bVar2 = new h0.b(this);
            x.b f10 = i.f(f2, new n6.a(bVar2, 23), a6.a());
            this.e = f10;
            o oVar = new o(this, arrayList, uVar);
            f10.a(new h(0, f10, oVar), a6.a());
            this.f1587f = true;
        }
    }

    public final void b(PreviewView.StreamState streamState) {
        synchronized (this) {
            try {
                if (this.f1585c.equals(streamState)) {
                    return;
                }
                this.f1585c = streamState;
                a0.a("StreamStateObserver", "Update Preview stream state to " + streamState);
                this.f1584b.i(streamState);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.a1
    public final void onError(Throwable th2) {
        x.d dVar = this.e;
        if (dVar != null) {
            dVar.cancel(false);
            this.e = null;
        }
        b(PreviewView.StreamState.IDLE);
    }
}
