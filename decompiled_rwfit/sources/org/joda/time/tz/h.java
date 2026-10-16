package org.joda.time.tz;

import java.util.Collections;
import java.util.Set;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f17277a = Collections.singleton("UTC");

    @Override // org.joda.time.tz.g
    public final DateTimeZone a(String str) {
        if ("UTC".equalsIgnoreCase(str)) {
            return DateTimeZone.UTC;
        }
        return null;
    }

    @Override // org.joda.time.tz.g
    public final Set b() {
        return f17277a;
    }
}
