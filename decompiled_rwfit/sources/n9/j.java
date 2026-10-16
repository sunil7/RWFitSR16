package n9;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f16454d;

    public j(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f16454d = bArr;
    }

    @Override // n9.i
    public final byte[] B() {
        return this.f16454d;
    }
}
