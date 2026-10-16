package mh;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class a extends ByteArrayOutputStream {
    public final byte[] b() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        e.e(buf, "buf");
        return buf;
    }
}
