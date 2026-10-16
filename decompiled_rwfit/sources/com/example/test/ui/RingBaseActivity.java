package com.example.test.ui;

import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.example.baselibrary.base.activity.RBaseActivity;
import com.example.baselibrary.preseneter.b;
import com.example.test.R$style;
import com.example.test.XXApplication;
import com.example.test.ui.dialog.h;
import com.example.test.utils.k;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import kotlin.a;
import kotlin.jvm.internal.e;
import l1.e2;

/* loaded from: classes.dex */
public abstract class RingBaseActivity<P extends b, B> extends RBaseActivity<P, B> {
    public final eh.b A;
    public final eh.b B;

    public RingBaseActivity() {
        a.b(new oh.a() { // from class: com.example.test.ui.RingBaseActivity$inputManager$2
            @Override // oh.a
            public final InputMethodManager invoke() {
                XXApplication xXApplication = XXApplication.f7400h;
                Object systemService = j1.a().getSystemService("input_method");
                e.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (InputMethodManager) systemService;
            }
        });
        this.A = a.b(new oh.a(this) { // from class: com.example.test.ui.RingBaseActivity$loadingDialog$2
            final /* synthetic */ RingBaseActivity<P, B> this$0;

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
        this.B = a.b(new oh.a() { // from class: com.example.test.ui.RingBaseActivity$themeStyle$2
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
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void M0() {
        Log.d("tong", "app style = " + P0());
        Integer P0 = P0();
        if (P0 != null && P0.intValue() == 0) {
            setTheme(R$style.Theme_MyApp_Black);
            return;
        }
        Integer P02 = P0();
        if (P02 != null && P02.intValue() == 1) {
            setTheme(R$style.Theme_MyApp_White);
            return;
        }
        Integer P03 = P0();
        if (P03 != null && P03.intValue() == 2) {
            setTheme(R$style.Theme_MyApp_Pink);
        } else {
            setTheme(R$style.Theme_MyApp_Black);
        }
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void N0() {
        Integer P0 = P0();
        if (P0 != null && P0.intValue() == 0) {
            new e2(getWindow(), H0()).b(false);
            new e2(getWindow(), H0()).a(false);
            return;
        }
        Integer P02 = P0();
        if (P02 != null && P02.intValue() == 1) {
            new e2(getWindow(), H0()).b(true);
            new e2(getWindow(), H0()).a(true);
            return;
        }
        Integer P03 = P0();
        if (P03 != null && P03.intValue() == 2) {
            new e2(getWindow(), H0()).b(true);
            new e2(getWindow(), H0()).a(true);
        } else {
            new e2(getWindow(), H0()).b(false);
            new e2(getWindow(), H0()).a(false);
        }
    }

    public final h O0() {
        return (h) this.A.getValue();
    }

    public final Integer P0() {
        return (Integer) this.B.getValue();
    }

    public final void Q0(int i3) {
        try {
            O0().a(i3);
            O0().c(0);
            if (O0().isShowing()) {
                return;
            }
            O0().show();
        } catch (Throwable th2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScanQrCodeActivity", l0.n("弹窗出错 ", th2.getLocalizedMessage()));
        }
    }

    public final void b0() {
        if (O0().isShowing()) {
            O0().dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        I0().i();
    }
}
