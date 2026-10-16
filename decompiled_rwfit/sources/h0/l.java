package h0;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.i0;
import androidx.camera.core.impl.h0;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import t.f1;

/* loaded from: classes.dex */
public final class l extends e {
    public TextureView e;

    /* renamed from: f, reason: collision with root package name */
    public SurfaceTexture f14241f;

    /* renamed from: g, reason: collision with root package name */
    public n0.i f14242g;

    /* renamed from: h, reason: collision with root package name */
    public f1 f14243h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14244i;

    /* renamed from: j, reason: collision with root package name */
    public SurfaceTexture f14245j;

    /* renamed from: k, reason: collision with root package name */
    public AtomicReference f14246k;

    /* renamed from: l, reason: collision with root package name */
    public h0 f14247l;

    @Override // h0.e
    public final View a() {
        return this.e;
    }

    @Override // h0.e
    public final Bitmap b() {
        TextureView textureView = this.e;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.e.getBitmap();
    }

    @Override // h0.e
    public final void c() {
        if (!this.f14244i || this.f14245j == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.e.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.f14245j;
        if (surfaceTexture != surfaceTexture2) {
            this.e.setSurfaceTexture(surfaceTexture2);
            this.f14245j = null;
            this.f14244i = false;
        }
    }

    @Override // h0.e
    public final void d() {
        this.f14244i = true;
    }

    @Override // h0.e
    public final void e(f1 f1Var, h0 h0Var) {
        Size size = f1Var.f18320b;
        this.f14221a = size;
        this.f14247l = h0Var;
        FrameLayout frameLayout = this.f14222b;
        size.getClass();
        TextureView textureView = new TextureView(frameLayout.getContext());
        this.e = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.f14221a.getWidth(), this.f14221a.getHeight()));
        this.e.setSurfaceTextureListener(new k(this, 0));
        frameLayout.removeAllViews();
        frameLayout.addView(this.e);
        f1 f1Var2 = this.f14243h;
        if (f1Var2 != null) {
            f1Var2.c();
        }
        this.f14243h = f1Var;
        Executor c9 = a1.g.c(this.e.getContext());
        i0 i0Var = new i0(19, this, f1Var);
        n0.j jVar = f1Var.f18327j.f1607c;
        if (jVar != null) {
            jVar.a(i0Var, c9);
        }
        h();
    }

    @Override // h0.e
    public final ob.a g() {
        return ve.a(new af.a(this, 17));
    }

    public final void h() {
        SurfaceTexture surfaceTexture;
        Size size = this.f14221a;
        if (size == null || (surfaceTexture = this.f14241f) == null || this.f14243h == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.f14221a.getHeight());
        Surface surface = new Surface(this.f14241f);
        f1 f1Var = this.f14243h;
        n0.i a3 = ve.a(new c0.b(11, this, surface));
        this.f14242g = a3;
        a3.f16358b.a(new androidx.camera.camera2.internal.compat.b(this, surface, a3, f1Var, 4), a1.g.c(this.e.getContext()));
        this.f14224d = true;
        f();
    }
}
