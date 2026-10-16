package d2;

import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12197a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12198b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12199c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f12200d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final String f12201f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12202g;

    public a(String str, String str2, boolean z5, int i3, String str3, int i10) {
        this.f12197a = str;
        this.f12198b = str2;
        this.f12200d = z5;
        this.e = i3;
        int i11 = 5;
        if (str2 != null) {
            String upperCase = str2.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                i11 = 3;
            } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                i11 = 2;
            } else if (!upperCase.contains("BLOB")) {
                i11 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
            }
        }
        this.f12199c = i11;
        this.f12201f = str3;
        this.f12202g = i10;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.e != aVar.e || !this.f12197a.equals(aVar.f12197a) || this.f12200d != aVar.f12200d) {
                return false;
            }
            String str = this.f12201f;
            int i3 = this.f12202g;
            int i10 = aVar.f12202g;
            String str2 = aVar.f12201f;
            if (i3 == 1 && i10 == 2 && str != null && !str.equals(str2)) {
                return false;
            }
            if (i3 == 2 && i10 == 1 && str2 != null && !str2.equals(str)) {
                return false;
            }
            if (i3 != 0 && i3 == i10) {
                if (str != null) {
                    if (!str.equals(str2)) {
                        return false;
                    }
                } else if (str2 != null) {
                    return false;
                }
            }
            if (this.f12199c != aVar.f12199c) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.f12197a.hashCode() * 31) + this.f12199c) * 31) + (this.f12200d ? 1231 : 1237)) * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Column{name='");
        sb2.append(this.f12197a);
        sb2.append("', type='");
        sb2.append(this.f12198b);
        sb2.append("', affinity='");
        sb2.append(this.f12199c);
        sb2.append("', notNull=");
        sb2.append(this.f12200d);
        sb2.append(", primaryKeyPosition=");
        sb2.append(this.e);
        sb2.append(", defaultValue='");
        return r5.a.f(sb2, this.f12201f, "'}");
    }
}
