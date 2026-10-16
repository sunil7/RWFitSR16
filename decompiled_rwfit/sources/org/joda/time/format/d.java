package org.joda.time.format;

import java.util.ArrayList;
import java.util.Locale;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class d implements z, x {

    /* renamed from: a, reason: collision with root package name */
    public final z[] f17163a;

    /* renamed from: b, reason: collision with root package name */
    public final x[] f17164b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17165c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17166d;

    public d(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3 += 2) {
            Object obj = arrayList.get(i3);
            if (obj instanceof d) {
                z[] zVarArr = ((d) obj).f17163a;
                if (zVarArr != null) {
                    for (z zVar : zVarArr) {
                        arrayList2.add(zVar);
                    }
                }
            } else {
                arrayList2.add(obj);
            }
            Object obj2 = arrayList.get(i3 + 1);
            if (obj2 instanceof d) {
                x[] xVarArr = ((d) obj2).f17164b;
                if (xVarArr != null) {
                    for (x xVar : xVarArr) {
                        arrayList3.add(xVar);
                    }
                }
            } else {
                arrayList3.add(obj2);
            }
        }
        if (arrayList2.contains(null) || arrayList2.isEmpty()) {
            this.f17163a = null;
            this.f17165c = 0;
        } else {
            int size2 = arrayList2.size();
            this.f17163a = new z[size2];
            int i10 = 0;
            for (int i11 = 0; i11 < size2; i11++) {
                z zVar2 = (z) arrayList2.get(i11);
                i10 += zVar2.estimatePrintedLength();
                this.f17163a[i11] = zVar2;
            }
            this.f17165c = i10;
        }
        if (arrayList3.contains(null) || arrayList3.isEmpty()) {
            this.f17164b = null;
            this.f17166d = 0;
            return;
        }
        int size3 = arrayList3.size();
        this.f17164b = new x[size3];
        int i12 = 0;
        for (int i13 = 0; i13 < size3; i13++) {
            x xVar2 = (x) arrayList3.get(i13);
            i12 += xVar2.estimateParsedLength();
            this.f17164b[i13] = xVar2;
        }
        this.f17166d = i12;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17166d;
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return this.f17165c;
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        x[] xVarArr = this.f17164b;
        if (xVarArr == null) {
            throw new UnsupportedOperationException();
        }
        int length = xVarArr.length;
        for (int i10 = 0; i10 < length && i3 >= 0; i10++) {
            i3 = xVarArr[i10].parseInto(sVar, charSequence, i3);
        }
        return i3;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        z[] zVarArr = this.f17163a;
        if (zVarArr == null) {
            throw new UnsupportedOperationException();
        }
        Locale locale2 = locale == null ? Locale.getDefault() : locale;
        for (z zVar : zVarArr) {
            zVar.printTo(appendable, j4, aVar, i3, dateTimeZone, locale2);
        }
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
        z[] zVarArr = this.f17163a;
        if (zVarArr != null) {
            if (locale == null) {
                locale = Locale.getDefault();
            }
            for (z zVar : zVarArr) {
                zVar.printTo(appendable, jVar, locale);
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
}
