package com.example.test.ui;

import android.content.Context;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.baselibrary.preseneter.b;
import com.example.test.ui.dialog.h;
import kotlin.a;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class XXBaseFragment<P extends b, B> extends BaseFragment<P, B> {

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7840c = a.b(new oh.a(this) { // from class: com.example.test.ui.XXBaseFragment$loadingDialog$2
        final /* synthetic */ XXBaseFragment<P, B> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // oh.a
        public final h invoke() {
            Context requireContext = this.this$0.requireContext();
            e.e(requireContext, "requireContext(...)");
            h hVar = new h(requireContext);
            hVar.c(8);
            return hVar;
        }
    });

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void V() {
        eh.b bVar = this.f7840c;
        ((h) bVar.getValue()).c(8);
        if (((h) bVar.getValue()).isShowing()) {
            return;
        }
        ((h) bVar.getValue()).show();
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void b0() {
        ((h) this.f7840c.getValue()).dismiss();
    }
}
