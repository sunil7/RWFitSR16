package h1;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f14252b = new i(new j(h.a(new Locale[0])));

    /* renamed from: a, reason: collision with root package name */
    public final j f14253a;

    public i(j jVar) {
        this.f14253a = jVar;
    }

    public static i a(String str) {
        if (str == null || str.isEmpty()) {
            return f14252b;
        }
        String[] split = str.split(Const.STR_MART_COMMA, -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i3 = 0; i3 < length; i3++) {
            localeArr[i3] = g.a(split[i3]);
        }
        return new i(new j(h.a(localeArr)));
    }

    public final int b() {
        return this.f14253a.f14254a.size();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f14253a.equals(((i) obj).f14253a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f14253a.f14254a.hashCode();
    }

    public final String toString() {
        return this.f14253a.f14254a.toString();
    }
}
