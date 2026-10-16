package zd;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class c extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final int f20395d;
    public final int e;

    public c(int i3, int i10) {
        super(1);
        this.f20395d = i3;
        this.e = i10;
    }

    @Override // jd.a
    public byte[] a() {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(ee.b.i(this.f20395d));
        allocate.put(ee.b.h(this.e));
        return allocate.array();
    }

    @Override // jd.a
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FirmwareUpdateBlockParam{nextUpdateBlockOffsetAddr=");
        sb2.append(this.f20395d);
        sb2.append(", nextUpdateBlockLen=");
        return android.support.v4.media.session.e.m(sb2, this.e, '}');
    }
}
