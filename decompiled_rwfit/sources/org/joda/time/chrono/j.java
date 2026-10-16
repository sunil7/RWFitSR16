package org.joda.time.chrono;

import java.text.DateFormatSymbols;
import java.util.Comparator;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: p, reason: collision with root package name */
    public static final ConcurrentHashMap f17097p = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String[] f17098a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f17099b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f17100c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f17101d;
    public final String[] e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f17102f;

    /* renamed from: g, reason: collision with root package name */
    public final TreeMap f17103g;

    /* renamed from: h, reason: collision with root package name */
    public final TreeMap f17104h;

    /* renamed from: i, reason: collision with root package name */
    public final TreeMap f17105i;

    /* renamed from: j, reason: collision with root package name */
    public final int f17106j;

    /* renamed from: k, reason: collision with root package name */
    public final int f17107k;

    /* renamed from: l, reason: collision with root package name */
    public final int f17108l;

    /* renamed from: m, reason: collision with root package name */
    public final int f17109m;

    /* renamed from: n, reason: collision with root package name */
    public final int f17110n;

    /* renamed from: o, reason: collision with root package name */
    public final int f17111o;

    public j(Locale locale) {
        DateFormatSymbols a3 = org.joda.time.c.a(locale);
        this.f17098a = a3.getEras();
        String[] weekdays = a3.getWeekdays();
        String[] strArr = new String[8];
        int i3 = 1;
        while (i3 < 8) {
            strArr[i3] = weekdays[i3 < 7 ? i3 + 1 : 1];
            i3++;
        }
        this.f17099b = strArr;
        String[] shortWeekdays = a3.getShortWeekdays();
        String[] strArr2 = new String[8];
        int i10 = 1;
        while (i10 < 8) {
            strArr2[i10] = shortWeekdays[i10 < 7 ? i10 + 1 : 1];
            i10++;
        }
        this.f17100c = strArr2;
        String[] months = a3.getMonths();
        String[] strArr3 = new String[13];
        for (int i11 = 1; i11 < 13; i11++) {
            strArr3[i11] = months[i11 - 1];
        }
        this.f17101d = strArr3;
        String[] shortMonths = a3.getShortMonths();
        String[] strArr4 = new String[13];
        for (int i12 = 1; i12 < 13; i12++) {
            strArr4[i12] = shortMonths[i12 - 1];
        }
        this.e = strArr4;
        this.f17102f = a3.getAmPmStrings();
        Integer[] numArr = new Integer[13];
        for (int i13 = 0; i13 < 13; i13++) {
            numArr[i13] = Integer.valueOf(i13);
        }
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        TreeMap treeMap = new TreeMap(comparator);
        this.f17103g = treeMap;
        a(treeMap, this.f17098a, numArr);
        if ("en".equals(locale.getLanguage())) {
            treeMap.put("BCE", numArr[0]);
            treeMap.put("CE", numArr[1]);
        }
        TreeMap treeMap2 = new TreeMap(comparator);
        this.f17104h = treeMap2;
        a(treeMap2, this.f17099b, numArr);
        a(treeMap2, this.f17100c, numArr);
        for (int i14 = 1; i14 <= 7; i14++) {
            treeMap2.put(String.valueOf(i14).intern(), numArr[i14]);
        }
        TreeMap treeMap3 = new TreeMap(comparator);
        this.f17105i = treeMap3;
        a(treeMap3, this.f17101d, numArr);
        a(treeMap3, this.e, numArr);
        for (int i15 = 1; i15 <= 12; i15++) {
            treeMap3.put(String.valueOf(i15).intern(), numArr[i15]);
        }
        this.f17106j = c(this.f17098a);
        this.f17107k = c(this.f17099b);
        this.f17108l = c(this.f17100c);
        this.f17109m = c(this.f17101d);
        this.f17110n = c(this.e);
        this.f17111o = c(this.f17102f);
    }

    public static void a(TreeMap treeMap, String[] strArr, Integer[] numArr) {
        int length = strArr.length;
        while (true) {
            length--;
            if (length < 0) {
                return;
            }
            String str = strArr[length];
            if (str != null) {
                treeMap.put(str, numArr[length]);
            }
        }
    }

    public static j b(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = f17097p;
        j jVar = (j) concurrentHashMap.get(locale);
        if (jVar == null) {
            jVar = new j(locale);
            j jVar2 = (j) concurrentHashMap.putIfAbsent(locale, jVar);
            if (jVar2 != null) {
                return jVar2;
            }
        }
        return jVar;
    }

    public static int c(String[] strArr) {
        int length;
        int length2 = strArr.length;
        int i3 = 0;
        while (true) {
            length2--;
            if (length2 < 0) {
                return i3;
            }
            String str = strArr[length2];
            if (str != null && (length = str.length()) > i3) {
                i3 = length;
            }
        }
    }
}
