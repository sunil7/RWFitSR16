package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class TRingMuslinTargetActivity extends XXBaseActivity<com.example.test.presenter.device.u0, f6.w0> implements g7.t, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public final String E = "TRingMuslinTargetActivity";
    public Integer F = 33;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingMuslinTargetActivity$muslinOptions$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 5;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 254) {
                    return arrayList;
                }
                i3 = i10;
            }
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingMuslinTargetActivity$muslinCountSelectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.p invoke() {
            TRingMuslinTargetActivity tRingMuslinTargetActivity = TRingMuslinTargetActivity.this;
            int i3 = TRingMuslinTargetActivity.I;
            com.example.test.ui.dialog.p pVar = new com.example.test.ui.dialog.p(tRingMuslinTargetActivity, (List) tRingMuslinTargetActivity.G.getValue());
            pVar.setOnDialogDataListener(new j0(TRingMuslinTargetActivity.this));
            return pVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.u0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.w0) this.f7247z.getValue()).f13415a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_muslintarget, (ViewGroup) null, false);
        int i3 = R$id.muslintargetAv;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.nsv_data;
            if (((NestedScrollView) he.a(i3, inflate)) != null) {
                i3 = R$id.toolbar;
                TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                if (tRingToolBarView != null) {
                    return new f6.w0((ConstraintLayout) inflate, actionItemView, tRingToolBarView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        com.example.test.presenter.device.u0 u0Var = (com.example.test.presenter.device.u0) I0();
        u0Var.getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        ((TRingMuslinTargetActivity) ((g7.t) u0Var.f7255a)).S0(kVar != null ? kVar.v() : 33);
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = u0Var;
        I0.K0(eVar);
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 47);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getMuslimCountGoalRCmdJL");
        b3.g((byte) 47, new byte[]{2, 96, 16}, new boolean[0]);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.v()) : null;
        this.F = valueOf;
        Log.e("qob", "muslimTargetValue " + valueOf);
        ((f6.w0) this.f7247z.getValue()).f13416b.setHintStr(this.F + " " + getString(R$string.str_count));
        f6.w0 w0Var = (f6.w0) this.f7247z.getValue();
        if (w0Var != null) {
            w0Var.f13416b.setOnClickListener(this);
        }
        f6.w0 w0Var2 = (f6.w0) this.f7247z.getValue();
        if (w0Var2 != null) {
            w0Var2.f13417c.setOnViewChildListener(new j0(this));
        }
    }

    public final int R0() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.v()) : null;
        int size = ((List) this.G.getValue()).size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((String) ((List) this.G.getValue()).get(i3)).equals(String.valueOf(valueOf))) {
                return i3;
            }
        }
        return 0;
    }

    public final void S0(int i3) {
        Integer valueOf = Integer.valueOf(i3);
        this.F = valueOf;
        Log.e("qob", "onData muslimTargetValue " + valueOf);
        ((f6.w0) this.f7247z.getValue()).f13416b.setHintStr(i3 + " " + getString(R$string.str_count));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.muslintargetAv;
        if (valueOf != null && valueOf.intValue() == i3) {
            Log.d("tong", "select index =  " + R0());
            eh.b bVar = this.H;
            ((com.example.test.ui.dialog.p) bVar.getValue()).a(R0());
            ((com.example.test.ui.dialog.p) bVar.getValue()).show();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b0();
    }
}
