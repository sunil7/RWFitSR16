package hf;

import gf.e;
import gf.j;
import java.util.Arrays;
import jf.f;
import jf.i;

/* loaded from: classes2.dex */
public final class c extends gf.d {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f14320f;

    /* renamed from: g, reason: collision with root package name */
    public final j f14321g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i3) {
        super(0);
        this.f14320f = i3;
        switch (i3) {
            case 1:
                super(0);
                this.f14321g = new j(Arrays.asList(new jf.d(), new f(), new i()));
                break;
            default:
                this.f14321g = new j(Arrays.asList(new a(1), new b(1), new d(1)));
                break;
        }
    }

    @Override // gf.d
    public final e o() {
        switch (this.f14320f) {
        }
        return this.f14321g;
    }
}
