package zd;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f20394d;
    public final byte[] e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(byte[] bArr, int i3) {
        super(1);
        this.f20394d = i3;
        this.e = bArr;
    }

    @Override // jd.a
    public final byte[] a() {
        switch (this.f20394d) {
        }
        return this.e;
    }

    @Override // jd.a
    public String toString() {
        switch (this.f20394d) {
            case 1:
                return "InquireUpdateParam{updateFileFlagData=" + Arrays.toString(this.e) + '}';
            default:
                return super.toString();
        }
    }
}
