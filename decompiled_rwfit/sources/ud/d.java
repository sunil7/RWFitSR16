package ud;

import android.support.v4.media.session.e;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int f19061a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19062b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19063c;

    /* renamed from: d, reason: collision with root package name */
    public int f19064d;

    public d(String str, int i3, boolean z5) {
        this.f19061a = i3;
        this.f19062b = str;
        this.f19063c = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f19061a == dVar.f19061a && Objects.equals(this.f19062b, dVar.f19062b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f19061a), this.f19062b);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ReConnectDevMsg{way=");
        sb2.append(this.f19061a);
        sb2.append(", address='");
        sb2.append(this.f19062b);
        sb2.append("', isUseADV=");
        sb2.append(this.f19063c);
        sb2.append(", state=");
        return e.m(sb2, this.f19064d, '}');
    }
}
