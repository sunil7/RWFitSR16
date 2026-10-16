package zd;

/* loaded from: classes.dex */
public final class a extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f20393d;

    public a(byte[] bArr) {
        super(1);
        this.f20393d = bArr;
    }

    @Override // jd.a
    public final byte[] a() {
        byte[] bArr = this.f20393d;
        return bArr == null ? new byte[0] : bArr;
    }

    @Override // jd.a
    public final String toString() {
        return "CustomParam{data=" + ee.b.c(this.f20393d) + '}';
    }
}
