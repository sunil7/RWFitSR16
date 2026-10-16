package v3;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class d extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f19169a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, int i3) {
        super(i3);
        this.f19169a = eVar;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i3 = ((ByteArrayOutputStream) this).count;
        if (i3 > 0 && ((ByteArrayOutputStream) this).buf[i3 - 1] == 13) {
            i3--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i3, this.f19169a.f19171b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
