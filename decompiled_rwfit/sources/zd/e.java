package zd;

/* loaded from: classes.dex */
public final class e extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final int f20397d;
    public byte e;

    public e(int i3) {
        super(1);
        this.f20397d = i3;
        this.e = (byte) 0;
    }

    @Override // jd.a
    public final byte[] a() {
        byte[] bArr = new byte[5];
        System.arraycopy(ee.b.i(this.f20397d), 0, bArr, 0, 4);
        bArr[4] = this.e;
        return bArr;
    }

    @Override // jd.a
    public final String toString() {
        return android.support.v4.media.session.e.m(new StringBuilder("GetTargetInfoParam{mask="), this.f20397d, '}');
    }
}
