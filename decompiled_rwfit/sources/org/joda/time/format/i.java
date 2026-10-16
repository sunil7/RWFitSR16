package org.joda.time.format;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public class i extends h {

    /* renamed from: d, reason: collision with root package name */
    public final int f17189d;

    public i(DateTimeFieldType dateTimeFieldType, int i3, boolean z5, int i10) {
        super(dateTimeFieldType, i3, z5);
        this.f17189d = i10;
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return this.f17186b;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        int i10 = this.f17189d;
        try {
            u.a(appendable, this.f17185a.getField(aVar).get(j4), i10);
        } catch (RuntimeException unused) {
            p.n(appendable, i10);
        }
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
        DateTimeFieldType dateTimeFieldType = this.f17185a;
        boolean isSupported = jVar.isSupported(dateTimeFieldType);
        int i3 = this.f17189d;
        if (isSupported) {
            try {
                u.a(appendable, jVar.get(dateTimeFieldType), i3);
                return;
            } catch (RuntimeException unused) {
                p.n(appendable, i3);
                return;
            }
        }
        p.n(appendable, i3);
    }
}
