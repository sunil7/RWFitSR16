package tf;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import o2.m;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    public static final ef.b f18618g = ef.b.a(b.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final a f18619a;

    /* renamed from: b, reason: collision with root package name */
    public SurfaceTexture f18620b;

    /* renamed from: c, reason: collision with root package name */
    public Surface f18621c;
    public m e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f18623f = new Object();

    /* renamed from: d, reason: collision with root package name */
    public qf.d f18622d = new qf.d();

    public b(a aVar, wf.b bVar) {
        this.f18619a = aVar;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f18622d.f17940a.f11633a);
        this.f18620b = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(bVar.f19627a, bVar.f19628b);
        this.f18621c = new Surface(this.f18620b);
        this.e = new m((byte) 0, this.f18622d.f17940a.f11633a, 7);
    }
}
