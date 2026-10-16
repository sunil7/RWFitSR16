package androidx.camera.view;

import a1.g;
import android.graphics.Rect;
import android.util.Rational;
import androidx.appcompat.app.i0;
import androidx.camera.core.impl.h0;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.view.PreviewView;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import h0.e;
import h0.f;
import h0.j;
import h0.l;
import java.util.concurrent.atomic.AtomicReference;
import t.f1;
import t.w0;

/* loaded from: classes.dex */
public final class d implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewView f1597a;

    public d(PreviewView previewView) {
        this.f1597a = previewView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t.w0
    public final void b(f1 f1Var) {
        j jVar;
        if (!y5.b()) {
            g.c(this.f1597a.getContext()).execute(new i0(18, this, f1Var));
            return;
        }
        a0.a("PreviewView", "Surface requested by Preview.");
        v vVar = f1Var.f18322d;
        this.f1597a.f1574i = vVar.h();
        f fVar = this.f1597a.f1573h;
        Rect g10 = vVar.m().g();
        fVar.getClass();
        fVar.f18416a = new Rational(g10.width(), g10.height());
        synchronized (fVar) {
            fVar.f14226c = g10;
        }
        f1Var.b(g.c(this.f1597a.getContext()), new h0(this, 3, vVar, f1Var));
        PreviewView previewView = this.f1597a;
        e eVar = previewView.f1568b;
        PreviewView.ImplementationMode implementationMode = previewView.f1567a;
        if (!(eVar instanceof j) || PreviewView.b(f1Var, implementationMode)) {
            PreviewView previewView2 = this.f1597a;
            if (PreviewView.b(f1Var, previewView2.f1567a)) {
                PreviewView previewView3 = this.f1597a;
                l lVar = new l(previewView3, previewView3.f1570d);
                lVar.f14244i = false;
                lVar.f14246k = new AtomicReference();
                jVar = lVar;
            } else {
                PreviewView previewView4 = this.f1597a;
                jVar = new j(previewView4, previewView4.f1570d);
            }
            previewView2.f1568b = jVar;
        }
        u h4 = vVar.h();
        PreviewView previewView5 = this.f1597a;
        a aVar = new a(h4, previewView5.f1571f, previewView5.f1568b);
        this.f1597a.f1572g.set(aVar);
        vVar.l().e(g.c(this.f1597a.getContext()), aVar);
        this.f1597a.f1568b.e(f1Var, new h0(this, 4, aVar, vVar));
        PreviewView previewView6 = this.f1597a;
        if (previewView6.indexOfChild(previewView6.f1569c) == -1) {
            PreviewView previewView7 = this.f1597a;
            previewView7.addView(previewView7.f1569c);
        }
    }
}
