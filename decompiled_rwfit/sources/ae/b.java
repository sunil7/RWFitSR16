package ae;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public final class b extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f275d;
    public final int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i3, int i10) {
        super(1);
        this.f275d = i10;
        this.e = i3;
    }

    @Override // jd.a
    public final byte[] a() {
        int i3 = this.e;
        switch (this.f275d) {
            case 0:
                char[] cArr = ee.b.f12595a;
                break;
        }
        return new byte[]{(byte) i3};
    }

    @Override // jd.a
    public final String toString() {
        switch (this.f275d) {
            case 0:
                return "RequestAdvOpParam{op=" + this.e + "} " + super.toString();
            case 1:
                return "SetDeviceNotifyAdvInfoParam{op=" + this.e + "} " + super.toString();
            default:
                return e.m(new StringBuilder("RebootDeviceParam{param="), this.e, '}');
        }
    }
}
