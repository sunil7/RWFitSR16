package androidx.camera.core.impl;

import android.util.Size;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Size f1422a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1423b;

    /* renamed from: c, reason: collision with root package name */
    public final Size f1424c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f1425d;
    public final Size e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f1426f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f1427g;

    public j(Size size, HashMap hashMap, Size size2, HashMap hashMap2, Size size3, HashMap hashMap3, HashMap hashMap4) {
        if (size == null) {
            throw new NullPointerException("Null analysisSize");
        }
        this.f1422a = size;
        this.f1423b = hashMap;
        if (size2 == null) {
            throw new NullPointerException("Null previewSize");
        }
        this.f1424c = size2;
        this.f1425d = hashMap2;
        if (size3 == null) {
            throw new NullPointerException("Null recordSize");
        }
        this.e = size3;
        this.f1426f = hashMap3;
        this.f1427g = hashMap4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f1422a.equals(jVar.f1422a) && this.f1423b.equals(jVar.f1423b) && this.f1424c.equals(jVar.f1424c) && this.f1425d.equals(jVar.f1425d) && this.e.equals(jVar.e) && this.f1426f.equals(jVar.f1426f) && this.f1427g.equals(jVar.f1427g);
    }

    public final int hashCode() {
        return ((((((((((((this.f1422a.hashCode() ^ 1000003) * 1000003) ^ this.f1423b.hashCode()) * 1000003) ^ this.f1424c.hashCode()) * 1000003) ^ this.f1425d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f1426f.hashCode()) * 1000003) ^ this.f1427g.hashCode();
    }

    public final String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.f1422a + ", s720pSizeMap=" + this.f1423b + ", previewSize=" + this.f1424c + ", s1440pSizeMap=" + this.f1425d + ", recordSize=" + this.e + ", maximumSizeMap=" + this.f1426f + ", ultraMaximumSizeMap=" + this.f1427g + "}";
    }
}
