package org.joda.time.format;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;

/* loaded from: classes2.dex */
public final class k implements z, x {

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f17195c = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFieldType f17196a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17197b;

    public k(DateTimeFieldType dateTimeFieldType, boolean z5) {
        this.f17196a = dateTimeFieldType;
        this.f17197b = z5;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return estimatePrintedLength();
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return this.f17197b ? 6 : 20;
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        int intValue;
        Map map;
        ConcurrentHashMap concurrentHashMap = f17195c;
        Locale locale = sVar.f17218b;
        Map map2 = (Map) concurrentHashMap.get(locale);
        if (map2 == null) {
            map2 = new ConcurrentHashMap();
            concurrentHashMap.put(locale, map2);
        }
        DateTimeFieldType dateTimeFieldType = this.f17196a;
        Object[] objArr = (Object[]) map2.get(dateTimeFieldType);
        if (objArr == null) {
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(32);
            MutableDateTime.Property property = new MutableDateTime(0L, DateTimeZone.UTC).property(dateTimeFieldType);
            int minimumValueOverall = property.getMinimumValueOverall();
            int maximumValueOverall = property.getMaximumValueOverall();
            if (maximumValueOverall - minimumValueOverall > 32) {
                return ~i3;
            }
            intValue = property.getMaximumTextLength(locale);
            while (minimumValueOverall <= maximumValueOverall) {
                property.set(minimumValueOverall);
                String asShortText = property.getAsShortText(locale);
                Boolean bool = Boolean.TRUE;
                concurrentHashMap2.put(asShortText, bool);
                concurrentHashMap2.put(property.getAsShortText(locale).toLowerCase(locale), bool);
                concurrentHashMap2.put(property.getAsShortText(locale).toUpperCase(locale), bool);
                concurrentHashMap2.put(property.getAsText(locale), bool);
                concurrentHashMap2.put(property.getAsText(locale).toLowerCase(locale), bool);
                concurrentHashMap2.put(property.getAsText(locale).toUpperCase(locale), bool);
                minimumValueOverall++;
            }
            if ("en".equals(locale.getLanguage()) && dateTimeFieldType == DateTimeFieldType.era()) {
                Boolean bool2 = Boolean.TRUE;
                concurrentHashMap2.put("BCE", bool2);
                concurrentHashMap2.put("bce", bool2);
                concurrentHashMap2.put("CE", bool2);
                concurrentHashMap2.put("ce", bool2);
                intValue = 3;
            }
            map2.put(dateTimeFieldType, new Object[]{concurrentHashMap2, Integer.valueOf(intValue)});
            map = concurrentHashMap2;
        } else {
            Map map3 = (Map) objArr[0];
            intValue = ((Integer) objArr[1]).intValue();
            map = map3;
        }
        String str = (String) charSequence;
        for (int min = Math.min(str.length(), intValue + i3); min > i3; min--) {
            String charSequence2 = str.subSequence(i3, min).toString();
            if (map.containsKey(charSequence2)) {
                q c9 = sVar.c();
                c9.f17209a = dateTimeFieldType.getField(sVar.f17217a);
                c9.f17210b = 0;
                c9.f17211c = charSequence2;
                c9.f17212d = locale;
                return min;
            }
        }
        return ~i3;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        try {
            org.joda.time.b field = this.f17196a.getField(aVar);
            appendable.append(this.f17197b ? field.getAsShortText(j4, locale) : field.getAsText(j4, locale));
        } catch (RuntimeException unused) {
            appendable.append((char) 65533);
        }
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
        String str;
        try {
            DateTimeFieldType dateTimeFieldType = this.f17196a;
            if (jVar.isSupported(dateTimeFieldType)) {
                org.joda.time.b field = dateTimeFieldType.getField(jVar.getChronology());
                if (this.f17197b) {
                    str = field.getAsShortText(jVar, locale);
                } else {
                    str = field.getAsText(jVar, locale);
                }
            } else {
                str = "�";
            }
            ((StringBuilder) appendable).append((CharSequence) str);
        } catch (RuntimeException unused) {
            ((StringBuilder) appendable).append((char) 65533);
        }
    }
}
