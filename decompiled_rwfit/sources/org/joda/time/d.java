package org.joda.time;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.format.m;
import org.joda.time.format.p;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f17124a;

    /* renamed from: b, reason: collision with root package name */
    public static final org.joda.time.format.b f17125b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("GMT", "UTC");
        hashMap.put("WET", "WET");
        hashMap.put("CET", "CET");
        hashMap.put("MET", "CET");
        hashMap.put("ECT", "CET");
        hashMap.put("EET", "EET");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("HST", "Pacific/Honolulu");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("MST", "America/Denver");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("EST", "America/New_York");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("NST", "Pacific/Auckland");
        f17124a = Collections.unmodifiableMap(hashMap);
        BaseChronology baseChronology = new BaseChronology() { // from class: org.joda.time.DateTimeZone$LazyInit$1
            private static final long serialVersionUID = -3128740902654445468L;

            @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
            public DateTimeZone getZone() {
                return null;
            }

            @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
            public String toString() {
                return DateTimeZone$LazyInit$1.class.getName();
            }

            @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
            public a withUTC() {
                return this;
            }

            @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
            public a withZone(DateTimeZone dateTimeZone) {
                return this;
            }
        };
        p pVar = new p();
        pVar.d(new m(null, null, 4, true));
        f17125b = pVar.r().h(baseChronology);
    }
}
