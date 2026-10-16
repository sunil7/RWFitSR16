package org.joda.time.format;

/* loaded from: classes2.dex */
public final class e extends i {
    @Override // org.joda.time.format.h, org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        int i10;
        char charAt;
        int parseInto = super.parseInto(sVar, charSequence, i3);
        if (parseInto < 0 || parseInto == (i10 = this.f17186b + i3)) {
            return parseInto;
        }
        if (this.f17187c && ((charAt = ((String) charSequence).charAt(i3)) == '-' || charAt == '+')) {
            i10++;
        }
        return parseInto > i10 ? ~(i10 + 1) : parseInto < i10 ? ~parseInto : parseInto;
    }
}
