package com.example.test.ui;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import com.example.baselibrary.base.activity.BaseActivity;
import com.example.baselibrary.preseneter.b;
import com.example.test.R$style;
import com.example.test.XXApplication;
import com.example.test.ui.dialog.h;
import com.example.test.utils.k;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import kotlin.a;
import kotlin.jvm.internal.e;
import l1.e2;

/* loaded from: classes.dex */
public abstract class XXBaseActivity<P extends b, B> extends BaseActivity<P, B> {
    public final eh.b B = a.b(new oh.a() { // from class: com.example.test.ui.XXBaseActivity$inputManager$2
        @Override // oh.a
        public final InputMethodManager invoke() {
            XXApplication xXApplication = XXApplication.f7400h;
            Object systemService = j1.a().getSystemService("input_method");
            e.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            return (InputMethodManager) systemService;
        }
    });
    public final eh.b C = a.b(new oh.a(this) { // from class: com.example.test.ui.XXBaseActivity$loadingDialog$2
        final /* synthetic */ XXBaseActivity<P, B> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // oh.a
        public final h invoke() {
            h hVar = new h(this.this$0);
            hVar.c(8);
            return hVar;
        }
    });
    public final eh.b D = a.b(new oh.a() { // from class: com.example.test.ui.XXBaseActivity$themeStyle$2
        @Override // oh.a
        public final Integer invoke() {
            if (k.f8731b == null) {
                synchronized (k.class) {
                    k.f8731b = new k();
                }
            }
            k kVar = k.f8731b;
            if (kVar != null) {
                return Integer.valueOf(kVar.D());
            }
            return null;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public void L0(Bundle bundle) {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void N0() {
        eh.b bVar = this.D;
        Integer num = (Integer) bVar.getValue();
        if (num != null && num.intValue() == 0) {
            setTheme(R$style.Theme_MyApp_Black);
            return;
        }
        Integer num2 = (Integer) bVar.getValue();
        if (num2 != null && num2.intValue() == 1) {
            setTheme(R$style.Theme_MyApp_White);
            return;
        }
        Integer num3 = (Integer) bVar.getValue();
        if (num3 != null && num3.intValue() == 2) {
            setTheme(R$style.Theme_MyApp_Pink);
        } else {
            setTheme(R$style.Theme_MyApp_Black);
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void O0() {
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar = k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            new e2(getWindow(), H0()).b(false);
            new e2(getWindow(), H0()).a(false);
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            new e2(getWindow(), H0()).b(true);
            new e2(getWindow(), H0()).a(true);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            new e2(getWindow(), H0()).b(true);
            new e2(getWindow(), H0()).a(true);
        } else {
            new e2(getWindow(), H0()).b(false);
            new e2(getWindow(), H0()).a(false);
        }
    }

    public final h P0() {
        return (h) this.C.getValue();
    }

    public final void Q0(int i3) {
        P0().a(i3);
        P0().setCancelable(false);
        P0().c(0);
        if (P0().isShowing()) {
            return;
        }
        P0().show();
    }

    public final void V() {
        P0().c(8);
        if (P0().isShowing()) {
            return;
        }
        P0().show();
    }

    public final void b0() {
        if (P0().isShowing()) {
            P0().dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        I0().i();
    }
}
