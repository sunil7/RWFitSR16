package be;

/* loaded from: classes.dex */
public final class c extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final int f3229d;

    public c(int i3) {
        super(2);
        this.f3229d = i3;
    }

    @Override // jd.a
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ExitUpdateModeResponse{rawData size =");
        byte[] bArr = this.f15405c;
        sb2.append(bArr == null ? 0 : bArr.length);
        sb2.append("\nxmOpCode=");
        sb2.append(this.f15404b);
        sb2.append("\nresult=");
        return android.support.v4.media.session.e.m(sb2, this.f3229d, '}');
    }
}
