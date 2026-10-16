package d2;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f12211a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12212b;

    /* renamed from: c, reason: collision with root package name */
    public final List f12213c;

    public d(String str, boolean z5, List list) {
        this.f12211a = str;
        this.f12212b = z5;
        this.f12213c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f12212b != dVar.f12212b || !this.f12213c.equals(dVar.f12213c)) {
            return false;
        }
        String str = this.f12211a;
        boolean startsWith = str.startsWith("index_");
        String str2 = dVar.f12211a;
        return startsWith ? str2.startsWith("index_") : str.equals(str2);
    }

    public final int hashCode() {
        String str = this.f12211a;
        return this.f12213c.hashCode() + ((((str.startsWith("index_") ? -1184239155 : str.hashCode()) * 31) + (this.f12212b ? 1 : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Index{name='");
        sb2.append(this.f12211a);
        sb2.append("', unique=");
        sb2.append(this.f12212b);
        sb2.append(", columns=");
        return l0.r(sb2, this.f12213c, '}');
    }
}
