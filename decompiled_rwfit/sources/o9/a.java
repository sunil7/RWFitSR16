package o9;

import com.example.test.utils.y;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f16840a;

    /* renamed from: b, reason: collision with root package name */
    public final y f16841b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.b f16842c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16843d;

    public a(y yVar, com.google.android.gms.common.api.b bVar, String str) {
        this.f16841b = yVar;
        this.f16842c = bVar;
        this.f16843d = str;
        this.f16840a = Arrays.hashCode(new Object[]{yVar, bVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return q9.n.h(this.f16841b, aVar.f16841b) && q9.n.h(this.f16842c, aVar.f16842c) && q9.n.h(this.f16843d, aVar.f16843d);
    }

    public final int hashCode() {
        return this.f16840a;
    }
}
