package org.joda.time.format;

/* loaded from: classes2.dex */
public final class y implements x {

    /* renamed from: a, reason: collision with root package name */
    public final x f17260a;

    public y(x xVar) {
        this.f17260a = xVar;
    }

    public static y a(x xVar) {
        if (xVar instanceof t) {
            return ((t) xVar).f17225a;
        }
        if (xVar instanceof y) {
            return (y) xVar;
        }
        if (xVar == null) {
            return null;
        }
        return new y(xVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            return this.f17260a.equals(((y) obj).f17260a);
        }
        return false;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17260a.estimateParsedLength();
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        return this.f17260a.parseInto(sVar, charSequence, i3);
    }
}
