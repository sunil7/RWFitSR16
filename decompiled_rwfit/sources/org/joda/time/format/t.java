package org.joda.time.format;

/* loaded from: classes2.dex */
public final class t implements x {

    /* renamed from: a, reason: collision with root package name */
    public final y f17225a;

    public t(y yVar) {
        this.f17225a = yVar;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17225a.f17260a.estimateParsedLength();
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        return this.f17225a.f17260a.parseInto(sVar, ((String) charSequence).toString(), i3);
    }
}
