package n;

import android.util.Size;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.s1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f16137a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f16138b;

    /* renamed from: c, reason: collision with root package name */
    public final s1 f16139c;

    /* renamed from: d, reason: collision with root package name */
    public final a2 f16140d;
    public final Size e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.camera.core.impl.h f16141f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f16142g;

    public b(String str, Class cls, s1 s1Var, a2 a2Var, Size size, androidx.camera.core.impl.h hVar, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException("Null useCaseId");
        }
        this.f16137a = str;
        this.f16138b = cls;
        if (s1Var == null) {
            throw new NullPointerException("Null sessionConfig");
        }
        this.f16139c = s1Var;
        if (a2Var == null) {
            throw new NullPointerException("Null useCaseConfig");
        }
        this.f16140d = a2Var;
        this.e = size;
        this.f16141f = hVar;
        this.f16142g = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f16137a.equals(bVar.f16137a) || !this.f16138b.equals(bVar.f16138b) || !this.f16139c.equals(bVar.f16139c) || !this.f16140d.equals(bVar.f16140d)) {
            return false;
        }
        Size size = bVar.e;
        Size size2 = this.e;
        if (size2 == null) {
            if (size != null) {
                return false;
            }
        } else if (!size2.equals(size)) {
            return false;
        }
        androidx.camera.core.impl.h hVar = bVar.f16141f;
        androidx.camera.core.impl.h hVar2 = this.f16141f;
        if (hVar2 == null) {
            if (hVar != null) {
                return false;
            }
        } else if (!hVar2.equals(hVar)) {
            return false;
        }
        ArrayList arrayList = bVar.f16142g;
        ArrayList arrayList2 = this.f16142g;
        return arrayList2 == null ? arrayList == null : arrayList2.equals(arrayList);
    }

    public final int hashCode() {
        int hashCode = (((((((this.f16137a.hashCode() ^ 1000003) * 1000003) ^ this.f16138b.hashCode()) * 1000003) ^ this.f16139c.hashCode()) * 1000003) ^ this.f16140d.hashCode()) * 1000003;
        Size size = this.e;
        int hashCode2 = (hashCode ^ (size == null ? 0 : size.hashCode())) * 1000003;
        androidx.camera.core.impl.h hVar = this.f16141f;
        int hashCode3 = (hashCode2 ^ (hVar == null ? 0 : hVar.hashCode())) * 1000003;
        ArrayList arrayList = this.f16142g;
        return hashCode3 ^ (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final String toString() {
        return "UseCaseInfo{useCaseId=" + this.f16137a + ", useCaseType=" + this.f16138b + ", sessionConfig=" + this.f16139c + ", useCaseConfig=" + this.f16140d + ", surfaceResolution=" + this.e + ", streamSpec=" + this.f16141f + ", captureTypes=" + this.f16142g + "}";
    }
}
