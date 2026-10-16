package com.google.android.exoplayer2;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f8897c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final k f8898d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f8899a = f8897c;

    /* renamed from: b, reason: collision with root package name */
    public final k f8900b = f8898d;

    static {
        List list = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        Uri uri = Uri.EMPTY;
        f8898d = new k("com.google.android.exoplayer2.Timeline", new h(Long.MIN_VALUE), uri != null ? new j(uri, null, null, list, list) : null, new i(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f), m.f8871s);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.class.equals(obj.getClass())) {
            return false;
        }
        t tVar = (t) obj;
        return i9.g.a(this.f8899a, tVar.f8899a) && i9.g.a(this.f8900b, tVar.f8900b) && i9.g.a(null, null) && i9.g.a(null, null) && 0 == 0 && 0 == 0 && 0 == 0 && 0 == 0 && 0 == 0 && 0 == 0;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((((this.f8900b.hashCode() + ((this.f8899a.hashCode() + 217) * 31)) * 31) + 0) * 31) + 0) * 31) + ((int) (0 ^ (0 >>> 32)))) * 31) + ((int) (0 ^ (0 >>> 32)))) * 31) + ((int) (0 ^ (0 >>> 32)))) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + ((int) (0 ^ (0 >>> 32)))) * 31) + ((int) (0 ^ (0 >>> 32)))) * 31) + 0) * 31) + 0) * 31) + ((int) (0 ^ (0 >>> 32)));
    }
}
