package d2;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f12203a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12204b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12205c;

    /* renamed from: d, reason: collision with root package name */
    public final List f12206d;
    public final List e;

    public b(String str, String str2, String str3, List list, List list2) {
        this.f12203a = str;
        this.f12204b = str2;
        this.f12205c = str3;
        this.f12206d = Collections.unmodifiableList(list);
        this.e = Collections.unmodifiableList(list2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f12203a.equals(bVar.f12203a) && this.f12204b.equals(bVar.f12204b) && this.f12205c.equals(bVar.f12205c) && this.f12206d.equals(bVar.f12206d)) {
            return this.e.equals(bVar.e);
        }
        return false;
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.f12206d.hashCode() + l0.d(l0.d(this.f12203a.hashCode() * 31, 31, this.f12204b), 31, this.f12205c)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ForeignKey{referenceTable='");
        sb2.append(this.f12203a);
        sb2.append("', onDelete='");
        sb2.append(this.f12204b);
        sb2.append("', onUpdate='");
        sb2.append(this.f12205c);
        sb2.append("', columnNames=");
        sb2.append(this.f12206d);
        sb2.append(", referenceColumnNames=");
        return l0.r(sb2, this.e, '}');
    }
}
