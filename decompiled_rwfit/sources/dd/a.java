package dd;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12326c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(sc.a aVar, int i3) {
        super(aVar);
        this.f12326c = i3;
    }

    @Override // a2.h
    public final String B() {
        if (((sc.a) this.f36a).f18220b != 60) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        D(sb2, 5);
        H(sb2, 45, 15);
        return sb2.toString();
    }

    @Override // dd.e
    public final void F(StringBuilder sb2, int i3) {
        switch (this.f12326c) {
            case 0:
                sb2.append("(3103)");
                break;
            default:
                if (i3 >= 10000) {
                    sb2.append("(3203)");
                    break;
                } else {
                    sb2.append("(3202)");
                    break;
                }
        }
    }

    @Override // dd.e
    public final int G(int i3) {
        switch (this.f12326c) {
            case 0:
                return i3;
            default:
                return i3 < 10000 ? i3 : i3 - 10000;
        }
    }
}
