package b4;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class h implements u4.b {

    /* renamed from: a, reason: collision with root package name */
    public final MessageDigest f3161a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.e f3162b = new u4.e();

    public h(MessageDigest messageDigest) {
        this.f3161a = messageDigest;
    }

    @Override // u4.b
    public final u4.e b() {
        return this.f3162b;
    }
}
