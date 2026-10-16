package androidx.camera.core.impl;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f1382a;

    /* renamed from: b, reason: collision with root package name */
    public final List f1383b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1384c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1385d;
    public final t.t e;

    public f(g0 g0Var, List list, int i3, int i10, t.t tVar) {
        this.f1382a = g0Var;
        this.f1383b = list;
        this.f1384c = i3;
        this.f1385d = i10;
        this.e = tVar;
    }

    public static e a(g0 g0Var) {
        e eVar = new e(0);
        if (g0Var == null) {
            throw new NullPointerException("Null surface");
        }
        eVar.f1378c = g0Var;
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            throw new NullPointerException("Null sharedSurfaces");
        }
        eVar.f1379d = list;
        eVar.e = -1;
        eVar.f1380f = -1;
        eVar.f1377b = t.t.f18406d;
        return eVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f1382a.equals(fVar.f1382a) && this.f1383b.equals(fVar.f1383b) && this.f1384c == fVar.f1384c && this.f1385d == fVar.f1385d && this.e.equals(fVar.e);
    }

    public final int hashCode() {
        return ((((((((this.f1382a.hashCode() ^ 1000003) * 1000003) ^ this.f1383b.hashCode()) * (-721379959)) ^ this.f1384c) * 1000003) ^ this.f1385d) * 1000003) ^ this.e.hashCode();
    }

    public final String toString() {
        return "OutputConfig{surface=" + this.f1382a + ", sharedSurfaces=" + this.f1383b + ", physicalCameraId=null, mirrorMode=" + this.f1384c + ", surfaceGroupId=" + this.f1385d + ", dynamicRange=" + this.e + "}";
    }
}
