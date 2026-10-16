package k4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import t4.l;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final w3.d f15486a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f15487b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f15488c;

    /* renamed from: d, reason: collision with root package name */
    public final com.bumptech.glide.j f15489d;
    public final a4.b e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15490f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15491g;

    /* renamed from: h, reason: collision with root package name */
    public com.bumptech.glide.i f15492h;

    /* renamed from: i, reason: collision with root package name */
    public e f15493i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15494j;

    /* renamed from: k, reason: collision with root package name */
    public e f15495k;

    /* renamed from: l, reason: collision with root package name */
    public Bitmap f15496l;

    /* renamed from: m, reason: collision with root package name */
    public e f15497m;

    /* renamed from: n, reason: collision with root package name */
    public int f15498n;

    /* renamed from: o, reason: collision with root package name */
    public int f15499o;

    /* renamed from: p, reason: collision with root package name */
    public int f15500p;

    public h(com.bumptech.glide.b bVar, w3.d dVar, int i3, int i10, Bitmap bitmap) {
        f4.c cVar = f4.c.f12663b;
        a4.b bVar2 = bVar.f6908a;
        com.bumptech.glide.f fVar = bVar.f6910c;
        com.bumptech.glide.j c9 = com.bumptech.glide.b.c(fVar.getBaseContext());
        com.bumptech.glide.i a3 = com.bumptech.glide.b.c(fVar.getBaseContext()).j(Bitmap.class).a(com.bumptech.glide.j.f6944k).a(((p4.e) ((p4.e) ((p4.e) new p4.e().d(z3.h.f20239b)).s()).o(true)).h(i3, i10));
        this.f15488c = new ArrayList();
        this.f15489d = c9;
        Handler handler = new Handler(Looper.getMainLooper(), new de.j(this, 2));
        this.e = bVar2;
        this.f15487b = handler;
        this.f15492h = a3;
        this.f15486a = dVar;
        c(cVar, bitmap);
    }

    public final void a() {
        int i3;
        if (!this.f15490f || this.f15491g) {
            return;
        }
        e eVar = this.f15497m;
        if (eVar != null) {
            this.f15497m = null;
            b(eVar);
            return;
        }
        this.f15491g = true;
        w3.d dVar = this.f15486a;
        int i10 = dVar.f19510l.f19488c;
        long uptimeMillis = SystemClock.uptimeMillis() + ((i10 <= 0 || (i3 = dVar.f19509k) < 0) ? 0 : (i3 < 0 || i3 >= i10) ? -1 : ((w3.a) r2.e.get(i3)).f19483i);
        int i11 = (dVar.f19509k + 1) % dVar.f19510l.f19488c;
        dVar.f19509k = i11;
        this.f15495k = new e(this.f15487b, i11, uptimeMillis);
        com.bumptech.glide.i z5 = this.f15492h.a((p4.e) new p4.e().n(new s4.d(Double.valueOf(Math.random())))).z(dVar);
        z5.y(this.f15495k, z5);
    }

    public final void b(e eVar) {
        this.f15491g = false;
        boolean z5 = this.f15494j;
        Handler handler = this.f15487b;
        if (z5) {
            handler.obtainMessage(2, eVar).sendToTarget();
            return;
        }
        if (!this.f15490f) {
            this.f15497m = eVar;
            return;
        }
        if (eVar.f15485g != null) {
            Bitmap bitmap = this.f15496l;
            if (bitmap != null) {
                this.e.j(bitmap);
                this.f15496l = null;
            }
            e eVar2 = this.f15493i;
            this.f15493i = eVar;
            ArrayList arrayList = this.f15488c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                c cVar = (c) ((f) arrayList.get(size));
                Object callback = cVar.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    cVar.stop();
                    cVar.invalidateSelf();
                } else {
                    cVar.invalidateSelf();
                    e eVar3 = ((h) cVar.f15470a.f15469b).f15493i;
                    if ((eVar3 != null ? eVar3.e : -1) == r5.f15486a.f19510l.f19488c - 1) {
                        cVar.f15474f++;
                    }
                    int i3 = cVar.f15475g;
                    if (i3 != -1 && cVar.f15474f >= i3) {
                        cVar.stop();
                    }
                }
            }
            if (eVar2 != null) {
                handler.obtainMessage(2, eVar2).sendToTarget();
            }
        }
        a();
    }

    public final void c(x3.i iVar, Bitmap bitmap) {
        t4.f.c(iVar, "Argument must not be null");
        t4.f.c(bitmap, "Argument must not be null");
        this.f15496l = bitmap;
        this.f15492h = this.f15492h.a(new p4.e().r(iVar, true));
        this.f15498n = l.c(bitmap);
        this.f15499o = bitmap.getWidth();
        this.f15500p = bitmap.getHeight();
    }

    public void setOnEveryFrameReadyListener(g gVar) {
    }
}
