package pb;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Class f17516a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17517b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17518c;

    public i(int i3, int i10, Class cls) {
        this.f17516a = cls;
        this.f17517b = i3;
        this.f17518c = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f17516a == iVar.f17516a && this.f17517b == iVar.f17517b && this.f17518c == iVar.f17518c;
    }

    public final int hashCode() {
        return ((((this.f17516a.hashCode() ^ 1000003) * 1000003) ^ this.f17517b) * 1000003) ^ this.f17518c;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f17516a);
        sb2.append(", type=");
        int i3 = this.f17517b;
        sb2.append(i3 == 1 ? "required" : i3 == 0 ? "optional" : "set");
        sb2.append(", injection=");
        int i10 = this.f17518c;
        if (i10 == 0) {
            str = "direct";
        } else if (i10 == 1) {
            str = Const.JSON_KEY_PROVIDER;
        } else {
            if (i10 != 2) {
                throw new AssertionError(l0.j(i10, "Unsupported injection: "));
            }
            str = "deferred";
        }
        return r5.a.f(sb2, str, "}");
    }
}
