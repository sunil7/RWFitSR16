package d4;

import java.io.File;

/* loaded from: classes.dex */
public final class d0 implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final d0 f12251b = new d0(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12252a;

    public /* synthetic */ d0(int i3) {
        this.f12252a = i3;
    }

    @Override // d4.q
    public final p a(Object obj, int i3, int i10, x3.f fVar) {
        switch (this.f12252a) {
            case 0:
                return new p(new s4.d(obj), new d(obj, 1));
            case 1:
                File file = (File) obj;
                return new p(new s4.d(file), new d(file, 0));
            default:
                return null;
        }
    }

    @Override // d4.q
    public final boolean b(Object obj) {
        switch (this.f12252a) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }
}
