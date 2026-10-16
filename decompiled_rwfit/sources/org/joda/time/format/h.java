package org.joda.time.format;

import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public abstract class h implements z, x {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFieldType f17185a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17186b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17187c;

    public h(DateTimeFieldType dateTimeFieldType, int i3, boolean z5) {
        this.f17185a = dateTimeFieldType;
        this.f17186b = i3;
        this.f17187c = z5;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17186b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0060, code lost:
    
        if (r10 <= '9') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0063, code lost:
    
        r5 = r5 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int parseInto(org.joda.time.format.s r17, java.lang.CharSequence r18, int r19) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.h.parseInto(org.joda.time.format.s, java.lang.CharSequence, int):int");
    }
}
