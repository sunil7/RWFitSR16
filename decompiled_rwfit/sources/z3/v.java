package z3;

import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class v implements e, d {

    /* renamed from: a, reason: collision with root package name */
    public final f f20309a;

    /* renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.b f20310b;

    /* renamed from: c, reason: collision with root package name */
    public int f20311c;

    /* renamed from: d, reason: collision with root package name */
    public b f20312d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public volatile d4.p f20313f;

    /* renamed from: g, reason: collision with root package name */
    public c f20314g;

    public v(f fVar, com.bumptech.glide.load.engine.b bVar) {
        this.f20309a = fVar;
        this.f20310b = bVar;
    }

    @Override // z3.d
    public final void a(x3.c cVar, Exception exc, com.bumptech.glide.load.data.e eVar, DataSource dataSource) {
        this.f20310b.a(cVar, exc, eVar, this.f20313f.f12282c.e());
    }

    @Override // z3.e
    public final boolean b() {
        Object obj = this.e;
        if (obj != null) {
            this.e = null;
            int i3 = t4.g.f18515b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                x3.a d5 = this.f20309a.d(obj);
                n.l lVar = new n.l(d5, obj, this.f20309a.f20226i, 18, false);
                x3.c cVar = this.f20313f.f12280a;
                f fVar = this.f20309a;
                this.f20314g = new c(cVar, fVar.f20231n);
                fVar.f20225h.a().a(this.f20314g, lVar);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f20314g + ", data: " + obj + ", encoder: " + d5 + ", duration: " + t4.g.a(elapsedRealtimeNanos));
                }
                this.f20313f.f12282c.b();
                this.f20312d = new b(Collections.singletonList(this.f20313f.f12280a), this.f20309a, this);
            } catch (Throwable th2) {
                this.f20313f.f12282c.b();
                throw th2;
            }
        }
        b bVar = this.f20312d;
        if (bVar != null && bVar.b()) {
            return true;
        }
        this.f20312d = null;
        this.f20313f = null;
        boolean z5 = false;
        while (!z5 && this.f20311c < this.f20309a.b().size()) {
            ArrayList b3 = this.f20309a.b();
            int i10 = this.f20311c;
            this.f20311c = i10 + 1;
            this.f20313f = (d4.p) b3.get(i10);
            if (this.f20313f != null && (this.f20309a.f20233p.a(this.f20313f.f12282c.e()) || this.f20309a.c(this.f20313f.f12282c.a()) != null)) {
                this.f20313f.f12282c.f(this.f20309a.f20232o, new o4.e(this, this.f20313f));
                z5 = true;
            }
        }
        return z5;
    }

    @Override // z3.d
    public final void c(x3.c cVar, Object obj, com.bumptech.glide.load.data.e eVar, DataSource dataSource, x3.c cVar2) {
        this.f20310b.c(cVar, obj, eVar, this.f20313f.f12282c.e(), cVar);
    }

    @Override // z3.e
    public final void cancel() {
        d4.p pVar = this.f20313f;
        if (pVar != null) {
            pVar.f12282c.cancel();
        }
    }
}
