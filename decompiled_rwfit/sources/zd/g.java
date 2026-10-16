package zd;

/* loaded from: classes.dex */
public final class g extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final int f20399d;
    public int e;

    public g(int i3) {
        super(1);
        this.f20399d = i3;
        this.e = 0;
    }

    @Override // jd.a
    public final byte[] a() {
        int i3 = this.e;
        int i10 = this.f20399d;
        if (i3 <= 0) {
            return ee.b.i(i10);
        }
        byte[] bArr = new byte[8];
        byte[] i11 = ee.b.i(i10);
        byte[] i12 = ee.b.i(this.e);
        System.arraycopy(i11, 0, bArr, 0, 4);
        System.arraycopy(i12, 0, bArr, 4, 4);
        return bArr;
    }

    @Override // jd.a
    public final String toString() {
        return "NotifyUpdateContentSizeParam{contentSize=" + this.f20399d + ", currentProgress=" + this.e + "} " + super.toString();
    }
}
