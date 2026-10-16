package b4;

import android.util.Log;
import androidx.appcompat.app.t;
import com.example.test.utils.y;
import ef.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import n.l;

/* loaded from: classes.dex */
public final class c implements a {

    /* renamed from: b, reason: collision with root package name */
    public final File f3149b;
    public v3.c e;

    /* renamed from: d, reason: collision with root package name */
    public final i f3151d = new i(6);

    /* renamed from: c, reason: collision with root package name */
    public final long f3150c = 262144000;

    /* renamed from: a, reason: collision with root package name */
    public final y f3148a = new y(7);

    public c(File file) {
        this.f3149b = file;
    }

    @Override // b4.a
    public final void a(x3.c cVar, l lVar) {
        b bVar;
        v3.c b3;
        boolean z5;
        String v6 = this.f3148a.v(cVar);
        i iVar = this.f3151d;
        synchronized (iVar) {
            bVar = (b) ((HashMap) iVar.f12629b).get(v6);
            if (bVar == null) {
                t tVar = (t) iVar.f12630c;
                synchronized (((ArrayDeque) tVar.f568b)) {
                    bVar = (b) ((ArrayDeque) tVar.f568b).poll();
                }
                if (bVar == null) {
                    bVar = new b();
                }
                ((HashMap) iVar.f12629b).put(v6, bVar);
            }
            bVar.f3147b++;
        }
        bVar.f3146a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + v6 + " for for Key: " + cVar);
            }
            try {
                b3 = b();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            if (b3.h(v6) != null) {
                return;
            }
            a2.g f2 = b3.f(v6);
            if (f2 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: ".concat(v6));
            }
            try {
                if (((x3.a) lVar.f16245b).e(lVar.f16246c, f2.h(), (x3.f) lVar.f16247d)) {
                    v3.c.b((v3.c) f2.f35d, f2, true);
                    f2.f32a = true;
                }
                if (!z5) {
                    try {
                        f2.a();
                    } catch (IOException unused) {
                    }
                }
            } finally {
                if (!f2.f32a) {
                    try {
                        f2.a();
                    } catch (IOException unused2) {
                    }
                }
            }
        } finally {
            this.f3151d.J(v6);
        }
    }

    public final synchronized v3.c b() {
        try {
            if (this.e == null) {
                this.e = v3.c.j(this.f3149b, this.f3150c);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.e;
    }

    @Override // b4.a
    public final File f(x3.c cVar) {
        String v6 = this.f3148a.v(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + v6 + " for for Key: " + cVar);
        }
        try {
            mc.g h4 = b().h(v6);
            if (h4 != null) {
                return ((File[]) h4.f16022b)[0];
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }
}
