package gc;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.core.impl.i1;
import androidx.lifecycle.m0;
import androidx.lifecycle.p0;
import g4.n;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import pb.p;

/* loaded from: classes.dex */
public final class b implements c8.b, a7.f, com.google.gson.internal.i, pb.b, td.a, n, ia.c, i8.a, m4.f, nd.a, u4.a, p0, vg.g, yh.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14025a;

    public /* synthetic */ b(int i3) {
        this.f14025a = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0075, code lost:
    
        if (r11 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        if (r10 != (-1)) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m(t1.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gc.b.m(t1.b, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // yh.g
    public void a(Level level, String str) {
        System.out.println("[" + level + "] " + str);
    }

    @Override // m4.f
    public void b(m4.g gVar) {
    }

    @Override // i8.a
    public long c() {
        return System.currentTimeMillis();
    }

    @Override // androidx.lifecycle.p0
    public m0 d(Class cls) {
        return new x1.b();
    }

    @Override // u4.a
    public Object e() {
        return new ArrayList();
    }

    @Override // vg.g
    public void f(Object obj) {
    }

    @Override // m4.f
    public void g(m4.g gVar) {
        gVar.i();
    }

    @Override // dh.a
    public Object get() {
        return new w.e(Executors.newSingleThreadExecutor());
    }

    @Override // td.a
    public Object h(vd.b bVar) {
        switch (this.f14025a) {
            case 9:
                return Boolean.TRUE;
            default:
                if (bVar instanceof xd.e) {
                    return Integer.valueOf(((be.b) ((xd.e) bVar).f19230g).f3228d);
                }
                return 7;
        }
    }

    @Override // pb.b
    public Object i(p pVar) {
        switch (this.f14025a) {
            case 8:
                return new fc.c(pVar.c(fc.b.class));
            default:
                return new mc.c((e) pVar.a(e.class));
        }
    }

    @Override // a7.f
    public void j(int i3) {
    }

    @Override // g4.n
    public void k(a4.b bVar, Bitmap bitmap) {
    }

    @Override // yh.g
    public void l(Level level, String str, Throwable th2) {
        System.out.println("[" + level + "] " + str);
        th2.printStackTrace(System.out);
    }

    @Override // g4.n
    public void n() {
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        return new LinkedHashSet();
    }

    public String toString() {
        switch (this.f14025a) {
            case 23:
                return "EmptyConsumer";
            default:
                return super.toString();
        }
    }

    @Override // ia.c
    public void w(Exception exc) {
        Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
    }

    public b(i1 i1Var) {
        this.f14025a = 18;
        i1Var.d(UseTorchAsFlashQuirk.class);
    }

    public b(h9.b bVar) {
        this.f14025a = 3;
    }

    public b(int[] iArr, ValueAnimator valueAnimator) {
        this.f14025a = 6;
    }
}
