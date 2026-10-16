package ae;

/* loaded from: classes.dex */
public final class a extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public int f262d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f263f;

    /* renamed from: g, reason: collision with root package name */
    public int f264g;

    /* renamed from: h, reason: collision with root package name */
    public int f265h;

    /* renamed from: i, reason: collision with root package name */
    public String f266i;

    /* renamed from: j, reason: collision with root package name */
    public int f267j;

    /* renamed from: k, reason: collision with root package name */
    public int f268k;

    /* renamed from: l, reason: collision with root package name */
    public int f269l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f270m;

    /* renamed from: n, reason: collision with root package name */
    public int f271n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f272o;

    /* renamed from: p, reason: collision with root package name */
    public int f273p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f274q;

    @Override // jd.a
    public final byte[] a() {
        byte[] bArr = new byte[18];
        System.arraycopy(ee.b.h(this.e), 0, bArr, 0, 2);
        System.arraycopy(ee.b.h(this.f263f), 0, bArr, 2, 2);
        System.arraycopy(ee.b.h(this.f262d), 0, bArr, 4, 2);
        bArr[6] = (byte) ((this.f264g << 4) | (this.f265h & 15));
        byte[] a3 = ee.a.a(this.f266i);
        int i3 = 7;
        if (a3 != null && a3.length == 6) {
            System.arraycopy(a3, 0, bArr, 7, a3.length);
            i3 = 13;
        }
        bArr[i3] = (byte) this.f268k;
        bArr[i3 + 1] = this.f270m ? Byte.MIN_VALUE : (byte) 0;
        bArr[i3 + 2] = this.f272o ? Byte.MIN_VALUE : (byte) 0;
        bArr[i3 + 3] = this.f274q ? Byte.MIN_VALUE : (byte) 0;
        bArr[i3 + 4] = (byte) this.f267j;
        return bArr;
    }

    @Override // jd.a
    public final String toString() {
        return "NotifyAdvInfoParam{pid=" + this.f262d + ", vid=" + this.e + ", uid=" + this.f263f + ", chipType=" + this.f264g + ", version=" + this.f265h + ", showDialog=false, edrAddr='" + this.f266i + "', seq=" + this.f267j + ", action=" + this.f268k + ", leftDeviceQuantity=" + this.f269l + ", isLeftCharging=" + this.f270m + ", rightDeviceQuantity=" + this.f271n + ", isRightCharging=" + this.f272o + ", chargingBinQuantity=" + this.f273p + ", isDeviceCharging=" + this.f274q + "} " + super.toString();
    }
}
