package androidx.camera.core.impl;

import android.hardware.camera2.CaptureRequest;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f1351a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f1352b;

    /* renamed from: c, reason: collision with root package name */
    public final CaptureRequest.Key f1353c;

    public c(String str, Class cls, CaptureRequest.Key key) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.f1351a = str;
        if (cls == null) {
            throw new NullPointerException("Null valueClass");
        }
        this.f1352b = cls;
        this.f1353c = key;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f1351a.equals(cVar.f1351a) || !this.f1352b.equals(cVar.f1352b)) {
            return false;
        }
        CaptureRequest.Key key = cVar.f1353c;
        CaptureRequest.Key key2 = this.f1353c;
        return key2 == null ? key == null : key2.equals(key);
    }

    public final int hashCode() {
        int hashCode = (((this.f1351a.hashCode() ^ 1000003) * 1000003) ^ this.f1352b.hashCode()) * 1000003;
        CaptureRequest.Key key = this.f1353c;
        return hashCode ^ (key == null ? 0 : key.hashCode());
    }

    public final String toString() {
        return "Option{id=" + this.f1351a + ", valueClass=" + this.f1352b + ", token=" + this.f1353c + "}";
    }
}
