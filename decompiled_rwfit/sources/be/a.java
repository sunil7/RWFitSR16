package be;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a extends jd.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3227d;
    public byte[] e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i3) {
        super(2);
        this.f3227d = i3;
    }

    @Override // jd.a
    public final String toString() {
        switch (this.f3227d) {
            case 0:
                return "CustomParam{data=" + ee.b.c(this.e) + '}';
            default:
                return "FirmwareUpdateBlockResponse{firmwareUpdateBlockData=" + Arrays.toString(this.e) + '}';
        }
    }
}
