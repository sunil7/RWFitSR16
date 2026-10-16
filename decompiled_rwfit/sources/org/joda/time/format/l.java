package org.joda.time.format;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class l implements z, x {

    /* renamed from: a, reason: collision with root package name */
    public final int f17198a;

    public l(int i3) {
        this.f17198a = i3;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17198a == 1 ? 4 : 20;
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return this.f17198a == 1 ? 4 : 20;
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        Map map = (Map) atomicReference.get();
        if (map == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            DateTimeZone dateTimeZone = DateTimeZone.UTC;
            linkedHashMap.put("UT", dateTimeZone);
            linkedHashMap.put("UTC", dateTimeZone);
            linkedHashMap.put("GMT", dateTimeZone);
            org.joda.time.c.f(linkedHashMap, "EST", "America/New_York");
            org.joda.time.c.f(linkedHashMap, "EDT", "America/New_York");
            org.joda.time.c.f(linkedHashMap, "CST", "America/Chicago");
            org.joda.time.c.f(linkedHashMap, "CDT", "America/Chicago");
            org.joda.time.c.f(linkedHashMap, "MST", "America/Denver");
            org.joda.time.c.f(linkedHashMap, "MDT", "America/Denver");
            org.joda.time.c.f(linkedHashMap, "PST", "America/Los_Angeles");
            org.joda.time.c.f(linkedHashMap, "PDT", "America/Los_Angeles");
            Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
            while (true) {
                if (atomicReference.compareAndSet(null, unmodifiableMap)) {
                    map = unmodifiableMap;
                    break;
                }
                if (atomicReference.get() != null) {
                    map = (Map) atomicReference.get();
                    break;
                }
            }
        }
        String str = null;
        for (String str2 : map.keySet()) {
            if (p.o(charSequence, i3, str2) && (str == null || str2.length() > str.length())) {
                str = str2;
            }
        }
        if (str == null) {
            return ~i3;
        }
        DateTimeZone dateTimeZone2 = (DateTimeZone) map.get(str);
        sVar.f17224i = null;
        sVar.f17220d = dateTimeZone2;
        return str.length() + i3;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        long j10 = j4 - i3;
        String str = "";
        if (dateTimeZone != null) {
            int i10 = this.f17198a;
            if (i10 == 0) {
                str = dateTimeZone.getName(j10, locale);
            } else if (i10 == 1) {
                str = dateTimeZone.getShortName(j10, locale);
            }
        }
        appendable.append(str);
    }
}
