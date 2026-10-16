package a8;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;
import androidx.emoji2.text.j;
import com.example.test.ui.device.activity.i0;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.q0;
import d4.m;
import d4.q;
import d4.r;
import d4.x;
import de.o;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import n.g0;

/* loaded from: classes.dex */
public final class c implements j, r {

    /* renamed from: a, reason: collision with root package name */
    public Context f123a;

    public c(Context context, int i3) {
        switch (i3) {
            case 2:
                this.f123a = context;
                break;
            default:
                this.f123a = context.getApplicationContext();
                break;
        }
    }

    public static c d(Context context) {
        c cVar = new c();
        cVar.f123a = context;
        return cVar;
    }

    @Override // androidx.emoji2.text.j
    public void a(q0 q0Var) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new androidx.camera.camera2.internal.compat.h(this, 2, q0Var, threadPoolExecutor));
    }

    public d b() {
        Context context = this.f123a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        d dVar = new d();
        dVar.f124a = c8.a.a(f.f130a);
        yh.i iVar = new yh.i(context);
        dVar.f125b = iVar;
        dVar.f126c = c8.a.a(new y(iVar, 8, new b8.e(iVar, 0), false));
        dh.a a3 = c8.a.a(new i0(new b8.e(dVar.f125b, 1), 19));
        dVar.f127d = a3;
        eb.e eVar = new eb.e(11);
        yh.i iVar2 = dVar.f125b;
        o oVar = new o(iVar2, 20, a3, eVar);
        dh.a aVar = dVar.f124a;
        dh.a aVar2 = dVar.f126c;
        androidx.camera.core.impl.e eVar2 = new androidx.camera.core.impl.e(aVar, aVar2, oVar, a3, a3, 8);
        g0 g0Var = new g0(iVar2, aVar2, a3, oVar, aVar, a3);
        v2.h hVar = new v2.h();
        hVar.f19146a = aVar;
        hVar.f19147b = a3;
        hVar.f19148c = oVar;
        hVar.f19149d = a3;
        dVar.e = c8.a.a(new o(eVar2, 4, g0Var, hVar));
        return dVar;
    }

    @Override // d4.r
    public q c(x xVar) {
        return new m(this.f123a, 1);
    }

    public int e() {
        Configuration configuration = this.f123a.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i10 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600) {
            return 5;
        }
        if (i3 > 960 && i10 > 720) {
            return 5;
        }
        if (i3 > 720 && i10 > 960) {
            return 5;
        }
        if (i3 >= 500) {
            return 4;
        }
        if (i3 > 640 && i10 > 480) {
            return 4;
        }
        if (i3 <= 480 || i10 <= 640) {
            return i3 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int f() {
        int[] iArr = R$styleable.ActionBar;
        int i3 = R$attr.actionBarStyle;
        Context context = this.f123a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i3, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!this.f123a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs)) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }
}
