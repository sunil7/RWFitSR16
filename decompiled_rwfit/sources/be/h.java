package be;

/* loaded from: classes.dex */
public final class h extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3234d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i3) {
        super(2);
        this.f3234d = i3;
    }

    @Override // jd.a
    public final String toString() {
        switch (this.f3234d) {
            case 0:
                StringBuilder sb2 = new StringBuilder("RebootDeviceResponse{rawData size =");
                byte[] bArr = this.f15405c;
                sb2.append(bArr == null ? 0 : bArr.length);
                sb2.append("\nxmOpCode=");
                sb2.append(this.f15404b);
                sb2.append("\nresult=");
                return android.support.v4.media.session.e.m(sb2, this.e, '}');
            case 1:
                return "SetDeviceNotifyAdvInfoResponse{result=" + this.e + "} " + super.toString();
            default:
                return android.support.v4.media.session.e.m(new StringBuilder("GetTargetFeatureMapResponse{mask="), this.e, '}');
        }
    }
}
