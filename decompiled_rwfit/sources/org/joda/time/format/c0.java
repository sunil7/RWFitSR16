package org.joda.time.format;

import java.util.HashSet;

/* loaded from: classes2.dex */
public final class c0 extends e0 {

    /* renamed from: b, reason: collision with root package name */
    public final e0 f17160b;

    /* renamed from: c, reason: collision with root package name */
    public final h0 f17161c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f17162d;

    public c0(e0 e0Var, h0 h0Var) {
        this.f17160b = e0Var;
        this.f17161c = h0Var;
        HashSet hashSet = new HashSet();
        for (String str : e0Var.b()) {
            hashSet.add(str + new String[]{this.f17161c.f17188b}[0]);
        }
        this.f17162d = (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @Override // org.joda.time.format.e0
    public final int a(int i3) {
        return this.f17161c.f17188b.length() + this.f17160b.a(i3);
    }

    @Override // org.joda.time.format.e0
    public final String[] b() {
        return (String[]) this.f17162d.clone();
    }

    @Override // org.joda.time.format.e0
    public final int d(int i3, String str) {
        int d5 = this.f17160b.d(i3, str);
        return (d5 < 0 || (d5 = this.f17161c.d(d5, str)) < 0 || !c(d(d5, str) - d5, i3, str)) ? d5 : ~i3;
    }

    @Override // org.joda.time.format.e0
    public final void e(StringBuffer stringBuffer, int i3) {
        this.f17160b.e(stringBuffer, i3);
        stringBuffer.append(this.f17161c.f17188b);
    }

    @Override // org.joda.time.format.e0
    public final int f(int i3, String str) {
        e0 e0Var = this.f17160b;
        int f2 = e0Var.f(i3, str);
        if (f2 >= 0) {
            int d5 = e0Var.d(f2, str);
            h0 h0Var = this.f17161c;
            int f10 = h0Var.f(d5, str);
            if (f10 < 0 || !c(h0Var.d(f10, str) - f2, i3, str)) {
                return f2 > 0 ? f2 : f10;
            }
        }
        return ~i3;
    }
}
