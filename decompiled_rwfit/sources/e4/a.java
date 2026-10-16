package e4;

import com.bumptech.glide.load.data.l;
import com.example.test.ui.device.activity.f0;
import d4.g;
import d4.n;
import d4.o;
import d4.p;
import d4.q;
import java.util.ArrayDeque;
import x3.e;
import x3.f;

/* loaded from: classes.dex */
public final class a implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final e f12447b = e.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* renamed from: a, reason: collision with root package name */
    public final f0 f12448a;

    public a(f0 f0Var) {
        this.f12448a = f0Var;
    }

    @Override // d4.q
    public final p a(Object obj, int i3, int i10, f fVar) {
        g gVar = (g) obj;
        f0 f0Var = this.f12448a;
        if (f0Var != null) {
            o a3 = o.a(gVar);
            n nVar = (n) f0Var.f7859b;
            Object a10 = nVar.a(a3);
            ArrayDeque arrayDeque = o.f12278b;
            synchronized (arrayDeque) {
                arrayDeque.offer(a3);
            }
            g gVar2 = (g) a10;
            if (gVar2 == null) {
                nVar.f(o.a(gVar), gVar);
            } else {
                gVar = gVar2;
            }
        }
        return new p(gVar, new l(gVar, ((Integer) fVar.c(f12447b)).intValue()));
    }

    @Override // d4.q
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        return true;
    }
}
