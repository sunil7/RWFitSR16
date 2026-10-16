package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final Range f1404f = new Range(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final Size f1405a;

    /* renamed from: b, reason: collision with root package name */
    public final t.t f1406b;

    /* renamed from: c, reason: collision with root package name */
    public final Range f1407c;

    /* renamed from: d, reason: collision with root package name */
    public final m.b f1408d;
    public final boolean e;

    public h(Size size, t.t tVar, Range range, m.b bVar, boolean z5) {
        this.f1405a = size;
        this.f1406b = tVar;
        this.f1407c = range;
        this.f1408d = bVar;
        this.e = z5;
    }

    public final e a() {
        e eVar = new e(1);
        eVar.f1378c = this.f1405a;
        eVar.f1377b = this.f1406b;
        eVar.f1379d = this.f1407c;
        eVar.e = this.f1408d;
        eVar.f1380f = Boolean.valueOf(this.e);
        return eVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.f1405a.equals(hVar.f1405a) || !this.f1406b.equals(hVar.f1406b) || !this.f1407c.equals(hVar.f1407c)) {
            return false;
        }
        m.b bVar = hVar.f1408d;
        m.b bVar2 = this.f1408d;
        if (bVar2 == null) {
            if (bVar != null) {
                return false;
            }
        } else if (!bVar2.equals(bVar)) {
            return false;
        }
        return this.e == hVar.e;
    }

    public final int hashCode() {
        int hashCode = (((((this.f1405a.hashCode() ^ 1000003) * 1000003) ^ this.f1406b.hashCode()) * 1000003) ^ this.f1407c.hashCode()) * 1000003;
        m.b bVar = this.f1408d;
        return ((hashCode ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003) ^ (this.e ? 1231 : 1237);
    }

    public final String toString() {
        return "StreamSpec{resolution=" + this.f1405a + ", dynamicRange=" + this.f1406b + ", expectedFrameRateRange=" + this.f1407c + ", implementationOptions=" + this.f1408d + ", zslDisabled=" + this.e + "}";
    }
}
