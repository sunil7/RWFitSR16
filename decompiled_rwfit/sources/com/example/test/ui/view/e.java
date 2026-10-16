package com.example.test.ui.view;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class e extends BaseItemProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8686a;

    public abstract void b();

    public final void f(View view) {
        switch (this.f8686a) {
            case 0:
                kotlin.jvm.internal.e.f(view, "view");
                new od.b(view).throttleFirst(1200L, TimeUnit.MILLISECONDS).subscribe(new af.a(this, 14), new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.test.ui.view.FastClickBaseItemProvider$onClick$2
                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return eh.g.f12633a;
                    }

                    public final void invoke(Throwable th2) {
                        th2.printStackTrace();
                    }
                }, 10));
                break;
            default:
                kotlin.jvm.internal.e.f(view, "view");
                new od.b(view).throttleFirst(1200L, TimeUnit.MILLISECONDS).subscribe(new o(this, 0), new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.test.ui.view.RingFastClickBaseItemProvider$onClick$2
                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return eh.g.f12633a;
                    }

                    public final void invoke(Throwable th2) {
                        th2.printStackTrace();
                    }
                }, 11));
                break;
        }
    }

    public abstract void g();

    public void i(View view) {
        kotlin.jvm.internal.e.f(view, "view");
        new od.b(view).throttleFirst(1200L, TimeUnit.MILLISECONDS).subscribe(new o(this, 1), new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.test.ui.view.RingFastClickBaseItemProvider$onClickButton$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return eh.g.f12633a;
            }

            public final void invoke(Throwable th2) {
                th2.printStackTrace();
            }
        }, 12));
    }
}
