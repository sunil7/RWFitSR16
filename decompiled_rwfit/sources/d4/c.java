package d4;

import java.io.File;

/* loaded from: classes.dex */
public final class c implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12245a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12246b;

    public /* synthetic */ c(Object obj, int i3) {
        this.f12245a = i3;
        this.f12246b = obj;
    }

    @Override // d4.q
    public final p a(Object obj, int i3, int i10, x3.f fVar) {
        switch (this.f12245a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new p(new s4.d(bArr), new l(1, bArr, (c0) this.f12246b));
            case 1:
                return new p(new s4.d(obj), new e(0, obj.toString(), (c0) this.f12246b));
            default:
                File file = (File) obj;
                return new p(new s4.d(file), new e(1, file, (c0) this.f12246b));
        }
    }

    @Override // d4.q
    public final boolean b(Object obj) {
        switch (this.f12245a) {
            case 0:
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }
}
