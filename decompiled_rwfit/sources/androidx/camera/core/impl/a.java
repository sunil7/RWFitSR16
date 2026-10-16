package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final i f1342a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1343b;

    /* renamed from: c, reason: collision with root package name */
    public final Size f1344c;

    /* renamed from: d, reason: collision with root package name */
    public final t.t f1345d;
    public final List e;

    /* renamed from: f, reason: collision with root package name */
    public final m.b f1346f;

    /* renamed from: g, reason: collision with root package name */
    public final Range f1347g;

    public a(i iVar, int i3, Size size, t.t tVar, List list, m.b bVar, Range range) {
        if (iVar == null) {
            throw new NullPointerException("Null surfaceConfig");
        }
        this.f1342a = iVar;
        this.f1343b = i3;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.f1344c = size;
        if (tVar == null) {
            throw new NullPointerException("Null dynamicRange");
        }
        this.f1345d = tVar;
        if (list == null) {
            throw new NullPointerException("Null captureTypes");
        }
        this.e = list;
        this.f1346f = bVar;
        this.f1347g = range;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f1342a.equals(aVar.f1342a) || this.f1343b != aVar.f1343b || !this.f1344c.equals(aVar.f1344c) || !this.f1345d.equals(aVar.f1345d) || !this.e.equals(aVar.e)) {
            return false;
        }
        m.b bVar = aVar.f1346f;
        m.b bVar2 = this.f1346f;
        if (bVar2 == null) {
            if (bVar != null) {
                return false;
            }
        } else if (!bVar2.equals(bVar)) {
            return false;
        }
        Range range = aVar.f1347g;
        Range range2 = this.f1347g;
        return range2 == null ? range == null : range2.equals(range);
    }

    public final int hashCode() {
        int hashCode = (((((((((this.f1342a.hashCode() ^ 1000003) * 1000003) ^ this.f1343b) * 1000003) ^ this.f1344c.hashCode()) * 1000003) ^ this.f1345d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        m.b bVar = this.f1346f;
        int hashCode2 = (hashCode ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        Range range = this.f1347g;
        return hashCode2 ^ (range != null ? range.hashCode() : 0);
    }

    public final String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.f1342a + ", imageFormat=" + this.f1343b + ", size=" + this.f1344c + ", dynamicRange=" + this.f1345d + ", captureTypes=" + this.e + ", implementationOptions=" + this.f1346f + ", targetFrameRate=" + this.f1347g + "}";
    }
}
