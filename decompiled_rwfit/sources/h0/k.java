package h0;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import ff.q;

/* loaded from: classes.dex */
public final class k implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14239a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14240b;

    public /* synthetic */ k(Object obj, int i3) {
        this.f14239a = i3;
        this.f14240b = obj;
    }

    private final void a(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i10) {
        switch (this.f14239a) {
            case 0:
                a0.a("TextureViewImpl", "SurfaceTexture available. Size: " + i3 + "x" + i10);
                l lVar = (l) this.f14240b;
                lVar.f14241f = surfaceTexture;
                if (lVar.f14242g == null) {
                    lVar.h();
                    break;
                } else {
                    lVar.f14243h.getClass();
                    a0.a("TextureViewImpl", "Surface invalidated " + lVar.f14243h);
                    lVar.f14243h.f18328k.a();
                    break;
                }
            default:
                ((vf.j) this.f14240b).b(i3, i10);
                break;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        switch (this.f14239a) {
            case 0:
                l lVar = (l) this.f14240b;
                lVar.f14241f = null;
                n0.i iVar = lVar.f14242g;
                if (iVar == null) {
                    a0.a("TextureViewImpl", "SurfaceTexture about to be destroyed");
                    break;
                } else {
                    y yVar = new y(20, this, surfaceTexture);
                    iVar.a(new x.h(0, iVar, yVar), a1.g.c(lVar.e.getContext()));
                    lVar.f14245j = surfaceTexture;
                    break;
                }
            default:
                vf.j jVar = (vf.j) this.f14240b;
                jVar.f19239d = 0;
                jVar.e = 0;
                q qVar = jVar.f19236a;
                if (qVar != null) {
                    q.T.b(1, "onSurfaceDestroyed");
                    qVar.R(false);
                    qVar.Q(false);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i10) {
        switch (this.f14239a) {
            case 0:
                a0.a("TextureViewImpl", "SurfaceTexture size changed: " + i3 + "x" + i10);
                break;
            default:
                ((vf.j) this.f14240b).c(i3, i10);
                break;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        switch (this.f14239a) {
            case 0:
                androidx.concurrent.futures.b bVar = (androidx.concurrent.futures.b) ((l) this.f14240b).f14246k.getAndSet(null);
                if (bVar != null) {
                    bVar.a(null);
                    break;
                }
                break;
        }
    }
}
