package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class TRingEditCardActivity extends XXBaseActivity<com.example.test.presenter.device.n, f6.b0> implements p5.a, View.OnClickListener {
    public static final /* synthetic */ int G = 0;
    public ArrayList E;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingEditCardActivity$cardAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0070 A[SYNTHETIC] */
        @Override // oh.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final q6.c invoke() {
            /*
                Method dump skipped, instructions count: 680
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.TRingEditCardActivity$cardAdapter$2.invoke():q6.c");
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 6);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.b0) this.f7247z.getValue()).f12709a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_editcard, (ViewGroup) null, false);
        int i3 = R$id.cards;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.toolbar;
            TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
            if (tRingToolBarView != null) {
                return new f6.b0((LinearLayout) inflate, recyclerView, tRingToolBarView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        Log.e("qob", "DeviceScanFragment initData");
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.b0) bVar.getValue()).f12711c.setOnViewChildListener(new u(this));
        ((f6.b0) bVar.getValue()).f12710b.setAdapter(R0());
        ((f6.b0) bVar.getValue()).f12710b.setLayoutManager(new LinearLayoutManager(1));
        new androidx.recyclerview.widget.j0(new c(R0())).h(((f6.b0) bVar.getValue()).f12710b);
        R0().setOnItemSelectClickListener(new u(this));
    }

    public final q6.c R0() {
        return (q6.c) this.F.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
