package vf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.R$id;
import com.otaliastudios.cameraview.R$layout;

/* loaded from: classes2.dex */
public final class i extends a {

    /* renamed from: l, reason: collision with root package name */
    public static final ef.b f19257l = ef.b.a(i.class.getSimpleName());

    /* renamed from: j, reason: collision with root package name */
    public boolean f19258j;

    /* renamed from: k, reason: collision with root package name */
    public View f19259k;

    @Override // vf.a
    public final Object d() {
        return ((SurfaceView) this.f19237b).getHolder();
    }

    @Override // vf.a
    public final Class e() {
        return SurfaceHolder.class;
    }

    @Override // vf.a
    public final View f() {
        return this.f19259k;
    }

    @Override // vf.a
    public final View h(Context context, CameraView cameraView) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.cameraview_surface_view, (ViewGroup) cameraView, false);
        cameraView.addView(inflate, 0);
        SurfaceView surfaceView = (SurfaceView) inflate.findViewById(R$id.surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new h(this));
        this.f19259k = inflate;
        return surfaceView;
    }
}
