package com.example.test.ui.device.activity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.device.t0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.u0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class MoreActivity extends XXBaseActivity<t0, u0> implements f7.r, View.OnClickListener, u5.d {
    public static final /* synthetic */ int H = 0;
    public int E;
    public final int F = 1;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.MoreActivity$tipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            MoreActivity moreActivity = MoreActivity.this;
            moreActivity.getClass();
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(moreActivity);
            rVar.b(R$string.str_disconnect_tips);
            return rVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new t0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((u0) this.f7247z.getValue()).f13364a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // u5.d
    public final void I(s5.a aVar, int i3) {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View a3;
        View a10;
        View a11;
        View inflate = getLayoutInflater().inflate(R$layout.activity_more, (ViewGroup) null, false);
        int i3 = R$id.fun_power_off;
        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
        if (linearLayout != null) {
            i3 = R$id.fun_recovery;
            LinearLayout linearLayout2 = (LinearLayout) he.a(i3, inflate);
            if (linearLayout2 != null) {
                i3 = R$id.fun_restart;
                LinearLayout linearLayout3 = (LinearLayout) he.a(i3, inflate);
                if (linearLayout3 != null && (a3 = he.a((i3 = R$id.line1), inflate)) != null && (a10 = he.a((i3 = R$id.line2), inflate)) != null && (a11 = he.a((i3 = R$id.line3), inflate)) != null) {
                    i3 = R$id.titleView;
                    TitleView titleView = (TitleView) he.a(i3, inflate);
                    if (titleView != null) {
                        return new u0((LinearLayout) inflate, linearLayout, linearLayout2, linearLayout3, a3, a10, a11, titleView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        r5.b.k().q(this);
        eh.b bVar = this.f7247z;
        ((u0) bVar.getValue()).f13370h.setOnTitleListener(new t(this));
        Object obj = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (supportMenuBean != null ? supportMenuBean.isRecovery() : true) {
            ((u0) bVar.getValue()).f13366c.setVisibility(0);
            ((u0) bVar.getValue()).e.setVisibility(0);
        } else {
            ((u0) bVar.getValue()).f13366c.setVisibility(8);
            ((u0) bVar.getValue()).e.setVisibility(8);
        }
        SupportMenuBean supportMenuBean2 = d2.a().f8735a;
        if (supportMenuBean2 != null ? supportMenuBean2.isRestart() : true) {
            ((u0) bVar.getValue()).f13367d.setVisibility(0);
            ((u0) bVar.getValue()).f13368f.setVisibility(0);
        } else {
            ((u0) bVar.getValue()).f13367d.setVisibility(8);
            ((u0) bVar.getValue()).f13368f.setVisibility(8);
        }
        SupportMenuBean supportMenuBean3 = d2.a().f8735a;
        if (supportMenuBean3 != null ? supportMenuBean3.isPowerOff() : true) {
            ((u0) bVar.getValue()).f13365b.setVisibility(0);
            ((u0) bVar.getValue()).f13369g.setVisibility(0);
        } else {
            ((u0) bVar.getValue()).f13365b.setVisibility(8);
            ((u0) bVar.getValue()).f13369g.setVisibility(8);
        }
        ((u0) bVar.getValue()).f13366c.setOnClickListener(this);
        ((u0) bVar.getValue()).f13367d.setOnClickListener(this);
        ((u0) bVar.getValue()).f13365b.setOnClickListener(this);
    }

    public final com.example.test.ui.dialog.r R0() {
        return (com.example.test.ui.dialog.r) this.G.getValue();
    }

    @Override // u5.d
    public final void e0(s5.a aVar) {
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // u5.d
    public final void h0(s5.a aVar) {
    }

    @Override // u5.d
    public final void m0(s5.a aVar) {
    }

    @Override // u5.d
    public final void o() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.fun_recovery;
        if (valueOf != null && valueOf.intValue() == i3) {
            R0().b(R$string.str_device_recovery_tips);
            R0().setOnDialogListener(new a2.d(this, 23));
            R0().show();
            return;
        }
        int i10 = R$id.fun_restart;
        if (valueOf != null && valueOf.intValue() == i10) {
            R0().b(R$string.str_device_restart_tips);
            R0().setOnDialogListener(new y2.f(this, 23));
            R0().show();
            return;
        }
        int i11 = R$id.fun_power_off;
        if (valueOf != null && valueOf.intValue() == i11) {
            R0().b(R$string.str_device_shutdown_tips);
            R0().setOnDialogListener(new t(this));
            R0().show();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        WeakReference weakReference;
        super.onDestroy();
        r5.b k10 = r5.b.k();
        if (k10.m(this)) {
            Log.e("qob", "unRegisterScanBleCallback " + MoreActivity.class);
            CopyOnWriteArrayList copyOnWriteArrayList = k10.f18052a;
            Iterator it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    weakReference = null;
                    break;
                }
                weakReference = (WeakReference) it.next();
                if (weakReference.get() != null && weakReference.get() == this) {
                    break;
                }
            }
            if (weakReference != null) {
                if (weakReference.get() == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    weakReference.clear();
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
        }
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncStatusEvent(EventBusBeans.SyncStatusEvent syncStatusEvent) {
        kotlin.jvm.internal.e.f(syncStatusEvent, "syncStatusEvent");
        if (this.E > 0 && syncStatusEvent.getSyncStatus() == 1 && this.E == this.F) {
            ((t0) I0()).l();
            this.E = 0;
        }
    }

    @Override // u5.d
    public final void v(s5.a aVar) {
        b0();
        finish();
    }
}
