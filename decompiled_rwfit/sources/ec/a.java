package ec;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import androidx.cardview.widget.CardView;
import be.f;
import com.example.test.service.r0;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.n1;
import com.google.gson.internal.i;
import ia.c;
import java.util.TreeSet;
import pb.p;
import t6.b;
import vg.d;
import xd.m;

/* loaded from: classes.dex */
public final class a implements b, i, pb.b, td.a, c, i8.a, nd.a, u4.c, k.a, vg.a, d {

    /* renamed from: b, reason: collision with root package name */
    public static a f12586b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12587a;

    public /* synthetic */ a(int i3) {
        this.f12587a = i3;
    }

    @Override // u4.c
    public void a(Object obj) {
    }

    @Override // k.a
    public Object apply(Object obj) {
        return obj;
    }

    public void b(y yVar, float f2) {
        l0.a aVar = (l0.a) ((Drawable) yVar.f8773b);
        CardView cardView = (CardView) yVar.f8774c;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f2 != aVar.e || aVar.f15669f != useCompatPadding || aVar.f15670g != preventCornerOverlap) {
            aVar.e = f2;
            aVar.f15669f = useCompatPadding;
            aVar.f15670g = preventCornerOverlap;
            aVar.b(null);
            aVar.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            yVar.I(0, 0, 0, 0);
            return;
        }
        l0.a aVar2 = (l0.a) ((Drawable) yVar.f8773b);
        float f10 = aVar2.e;
        float f11 = aVar2.f15665a;
        int ceil = (int) Math.ceil(l0.b.a(f10, f11, cardView.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(l0.b.b(f10, f11, cardView.getPreventCornerOverlap()));
        yVar.I(ceil, ceil2, ceil, ceil2);
    }

    @Override // i8.a
    public long c() {
        return SystemClock.elapsedRealtime();
    }

    @Override // td.a
    public Object h(vd.b bVar) {
        if (bVar instanceof m) {
            return Integer.valueOf(((f) ((m) bVar).f19230g).f3232d);
        }
        return 1;
    }

    @Override // pb.b
    public Object i(p pVar) {
        switch (this.f12587a) {
            case 8:
                return new gc.f();
            default:
                return new fc.b(pVar.b(a.class));
        }
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // vg.a
    public void run() {
    }

    @Override // t6.b
    public void s() {
        Object obj = r0.M;
        n1.a().f();
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        return new TreeSet();
    }

    public String toString() {
        switch (this.f12587a) {
            case 23:
                return "EmptyAction";
            default:
                return super.toString();
        }
    }

    @Override // ia.c
    public void w(Exception exc) {
        Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
    }
}
