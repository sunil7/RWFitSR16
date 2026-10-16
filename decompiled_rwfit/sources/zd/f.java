package zd;

/* loaded from: classes.dex */
public final class f extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final int f20398d;
    public final int e;

    public f(int i3, int i10) {
        super(1);
        this.f20398d = i3;
        this.e = i10;
    }

    @Override // jd.a
    public final byte[] a() {
        return new byte[]{(byte) this.f20398d, (byte) this.e};
    }

    @Override // jd.a
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("NotifyCommunicationWayParam{way=");
        sb2.append(this.f20398d);
        sb2.append("reconnect=");
        return android.support.v4.media.session.e.m(sb2, this.e, '}');
    }
}
