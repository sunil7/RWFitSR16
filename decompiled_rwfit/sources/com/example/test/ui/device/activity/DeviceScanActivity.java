package com.example.test.ui.device.activity;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.database.table.User;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.DeviceScanAdapter;
import com.example.test.ui.device.model.BleDeviceModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class DeviceScanActivity extends XXBaseActivity<com.example.test.presenter.device.u, f6.w> implements f7.f {
    public static final /* synthetic */ int I = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DeviceScanActivity$deviceAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final DeviceScanAdapter invoke() {
            DeviceScanActivity deviceScanActivity = DeviceScanActivity.this;
            int i3 = DeviceScanActivity.I;
            return new DeviceScanAdapter(deviceScanActivity.S0());
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DeviceScanActivity$devices$2
        @Override // oh.a
        public final List<BleDeviceModel> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DeviceScanActivity$gpsTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(DeviceScanActivity.this);
            rVar.b(R$string.str_gps_open);
            rVar.setOnDialogListener(new y2.f(DeviceScanActivity.this, 14));
            return rVar;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DeviceScanActivity$bleTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(DeviceScanActivity.this);
            rVar.b(R$string.str_ble_open);
            rVar.setOnDialogListener(new a2.d(DeviceScanActivity.this, 14));
            return rVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.u(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.w) this.f7247z.getValue()).f13412a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_device_scan, (ViewGroup) null, false);
        int i3 = R$id.deviceList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.titleView;
            TitleView titleView = (TitleView) he.a(i3, inflate);
            if (titleView != null) {
                return new f6.w((LinearLayout) inflate, recyclerView, titleView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.u) I0()).k();
        if (R0()) {
            ((f6.w) this.f7247z.getValue()).f13414c.a();
            ((com.example.test.presenter.device.u) I0()).getClass();
            com.example.test.presenter.device.u.l();
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((f6.w) bVar.getValue()).f13414c.setOnTitleListener(new androidx.appcompat.app.t(this, 16));
        ((f6.w) bVar.getValue()).f13413b.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView = ((f6.w) bVar.getValue()).f13413b;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        recyclerView.g(g0Var.d());
        RecyclerView recyclerView2 = ((f6.w) bVar.getValue()).f13413b;
        eh.b bVar2 = this.E;
        recyclerView2.setAdapter((DeviceScanAdapter) bVar2.getValue());
        ((f6.w) bVar.getValue()).f13413b.setItemAnimator(null);
        ((DeviceScanAdapter) bVar2.getValue()).setOnItemClickListener(new y(this, 5));
    }

    public final boolean R0() {
        XXApplication xXApplication = XXApplication.f7400h;
        boolean d5 = com.example.test.utils.t.d(j1.a());
        boolean n4 = com.example.baselibrary.utils.b.n(j1.a());
        if (!n4) {
            ((com.example.test.ui.dialog.r) this.H.getValue()).show();
            return n4;
        }
        if (!d5) {
            ((com.example.test.ui.dialog.r) this.G.getValue()).show();
        }
        return d5;
    }

    public final List S0() {
        return (List) this.F.getValue();
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // f7.f
    public final void i(User user) {
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b0();
        ((com.example.test.presenter.device.u) I0()).getClass();
        com.example.test.presenter.device.u.m();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            finish();
            return;
        }
        if (status != 2) {
            if (status == 3) {
                Q0(R$string.str_binding);
                return;
            }
            if (status == 4) {
                b0();
            } else if (status != 5) {
                b0();
            } else {
                b0();
            }
        }
    }

    @Override // f7.f
    public final void s0() {
        ((f6.w) this.f7247z.getValue()).f13414c.b();
    }

    @Override // f7.f
    public final void y0(BleDeviceModel bleDeviceModel) {
        Object obj;
        Iterator it = S0().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            BleDeviceModel bleDeviceModel2 = (BleDeviceModel) obj;
            if (kotlin.jvm.internal.e.a(bleDeviceModel2.getMac(), bleDeviceModel.getMac()) && kotlin.jvm.internal.e.a(bleDeviceModel2.getName(), bleDeviceModel.getName())) {
                break;
            }
        }
        BleDeviceModel bleDeviceModel3 = (BleDeviceModel) obj;
        if (bleDeviceModel3 != null) {
            S0().remove(bleDeviceModel3);
        }
        S0().add(bleDeviceModel);
        List S0 = S0();
        if (S0.size() > 1) {
            kotlin.collections.m.h(S0, new androidx.viewpager2.widget.a(3));
        }
        ((DeviceScanAdapter) this.E.getValue()).notifyItemRangeChanged(0, S0().size());
    }
}
