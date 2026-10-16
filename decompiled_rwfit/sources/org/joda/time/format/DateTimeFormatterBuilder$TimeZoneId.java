package org.joda.time.format;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.joda.time.DateTimeZone;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
final class DateTimeFormatterBuilder$TimeZoneId implements z, x {
    public static final DateTimeFormatterBuilder$TimeZoneId INSTANCE;
    static final int MAX_LENGTH;
    static final int MAX_PREFIX_LENGTH;

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f17145a;

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f17146b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ DateTimeFormatterBuilder$TimeZoneId[] f17147c;

    static {
        DateTimeFormatterBuilder$TimeZoneId dateTimeFormatterBuilder$TimeZoneId = new DateTimeFormatterBuilder$TimeZoneId("INSTANCE", 0);
        INSTANCE = dateTimeFormatterBuilder$TimeZoneId;
        f17147c = new DateTimeFormatterBuilder$TimeZoneId[]{dateTimeFormatterBuilder$TimeZoneId};
        f17146b = new ArrayList();
        ArrayList arrayList = new ArrayList(DateTimeZone.getAvailableIDs());
        Collections.sort(arrayList);
        f17145a = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            String str = (String) obj;
            int indexOf = str.indexOf(47);
            if (indexOf >= 0) {
                indexOf = indexOf < str.length() ? indexOf + 1 : indexOf;
                i10 = Math.max(i10, indexOf);
                String substring = str.substring(0, indexOf + 1);
                String substring2 = str.substring(indexOf);
                HashMap hashMap = f17145a;
                if (!hashMap.containsKey(substring)) {
                    hashMap.put(substring, new ArrayList());
                }
                ((List) hashMap.get(substring)).add(substring2);
            } else {
                f17146b.add(str);
            }
            i3 = Math.max(i3, str.length());
        }
        MAX_LENGTH = i3;
        MAX_PREFIX_LENGTH = i10;
    }

    public static DateTimeFormatterBuilder$TimeZoneId valueOf(String str) {
        return (DateTimeFormatterBuilder$TimeZoneId) Enum.valueOf(DateTimeFormatterBuilder$TimeZoneId.class, str);
    }

    public static DateTimeFormatterBuilder$TimeZoneId[] values() {
        return (DateTimeFormatterBuilder$TimeZoneId[]) f17147c.clone();
    }

    @Override // org.joda.time.format.x
    public int estimateParsedLength() {
        return MAX_LENGTH;
    }

    @Override // org.joda.time.format.z
    public int estimatePrintedLength() {
        return MAX_LENGTH;
    }

    @Override // org.joda.time.format.x
    public int parseInto(s sVar, CharSequence charSequence, int i3) {
        String str;
        int i10;
        String str2;
        List list = f17146b;
        int length = charSequence.length();
        int min = Math.min(length, MAX_PREFIX_LENGTH + i3);
        int i11 = i3;
        while (true) {
            if (i11 >= min) {
                str = "";
                i10 = i3;
                break;
            }
            if (charSequence.charAt(i11) == '/') {
                int i12 = i11 + 1;
                str = charSequence.subSequence(i3, i12).toString();
                i10 = str.length() + i3;
                if (i11 < length) {
                    StringBuilder t8 = l0.t(str);
                    t8.append(charSequence.charAt(i12));
                    str2 = t8.toString();
                } else {
                    str2 = str;
                }
                list = (List) f17145a.get(str2);
                if (list == null) {
                    return ~i3;
                }
            } else {
                i11++;
            }
        }
        String str3 = null;
        for (int i13 = 0; i13 < list.size(); i13++) {
            String str4 = (String) list.get(i13);
            if (p.o(charSequence, i10, str4) && (str3 == null || str4.length() > str3.length())) {
                str3 = str4;
            }
        }
        if (str3 == null) {
            return ~i3;
        }
        DateTimeZone forID = DateTimeZone.forID(str.concat(str3));
        sVar.f17224i = null;
        sVar.f17220d = forID;
        return str3.length() + i10;
    }

    @Override // org.joda.time.format.z
    public void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) throws IOException {
    }

    @Override // org.joda.time.format.z
    public void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) throws IOException {
        appendable.append(dateTimeZone != null ? dateTimeZone.getID() : "");
    }
}
