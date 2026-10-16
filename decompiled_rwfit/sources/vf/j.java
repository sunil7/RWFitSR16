package vf;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.R$id;
import com.otaliastudios.cameraview.R$layout;
import h0.k;
import java.util.concurrent.ExecutionException;
import pe.o;

/* loaded from: classes2.dex */
public final class j extends a {

    /* renamed from: j, reason: collision with root package name */
    public View f19260j;

    @Override // vf.a
    public final void a() {
        ((TextureView) this.f19237b).post(new o(this, 9));
    }

    @Override // vf.a
    public final Object d() {
        return ((TextureView) this.f19237b).getSurfaceTexture();
    }

    @Override // vf.a
    public final Class e() {
        return SurfaceTexture.class;
    }

    @Override // vf.a
    public final View f() {
        return this.f19260j;
    }

    @Override // vf.a
    public final View h(Context context, CameraView cameraView) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.cameraview_texture_view, (ViewGroup) cameraView, false);
        cameraView.addView(inflate, 0);
        TextureView textureView = (TextureView) inflate.findViewById(R$id.texture_view);
        textureView.setSurfaceTextureListener(new k(this, 1));
        this.f19260j = inflate;
        return textureView;
    }

    @Override // vf.a
    public final void l(int i3) {
        this.f19242h = i3;
        ia.g gVar = new ia.g();
        ((TextureView) this.f19237b).post(new androidx.activity.f(this, i3, gVar, 6));
        try {
            xc.a(gVar.f14382a);
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // vf.a
    public final boolean o() {
        return true;
    }
}
