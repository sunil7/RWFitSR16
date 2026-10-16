package com.example.test.ui.main.fragment;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.database.table.User;
import com.example.test.MainActivity;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.device.u;
import com.example.test.ui.device.activity.ScanQrMlActivity;
import com.example.test.ui.device.adapter.DeviceScanAdapter;
import com.example.test.ui.device.model.BleDeviceModel;
import com.example.test.ui.dialog.r;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.utils.t;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import f6.h3;
import f6.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.g0;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class DeviceScanFragment extends BaseFragment<u, h3> implements f7.f, View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public int f8062c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f8063d = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceScanFragment$permissionTipDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.i invoke() {
            com.example.test.ui.dialog.i iVar = new com.example.test.ui.dialog.i(DeviceScanFragment.this.f0(), 2);
            iVar.setOnDialogListener(new j(DeviceScanFragment.this, 2));
            iVar.setCancelable(false);
            return iVar;
        }
    });
    public final eh.b e = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceScanFragment$rotationYAnimator$2
        {
            super(0);
        }

        @Override // oh.a
        public final ObjectAnimator invoke() {
            h3 h3Var = (h3) DeviceScanFragment.this.f7251b;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(h3Var != null ? h3Var.f12956c : null, "rotation", 0.0f, 359.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatMode(1);
            ofFloat.setRepeatCount(-1);
            return ofFloat;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f8064f = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceScanFragment$deviceAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final DeviceScanAdapter invoke() {
            return new DeviceScanAdapter(DeviceScanFragment.this.z0());
        }
    });

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f8065g = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceScanFragment$devices$2
        @Override // oh.a
        public final List<BleDeviceModel> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f8066h = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceScanFragment$loadingDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.h invoke() {
            com.example.test.ui.dialog.h hVar = new com.example.test.ui.dialog.h(DeviceScanFragment.this.f0());
            hVar.c(8);
            return hVar;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f8067i = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceScanFragment$gpsTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final r invoke() {
            r rVar = new r(DeviceScanFragment.this.f0());
            rVar.b(R$string.str_gps_open);
            rVar.setOnDialogListener(new j(DeviceScanFragment.this, 1));
            return rVar;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f8068j = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceScanFragment$bleTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final r invoke() {
            r rVar = new r(DeviceScanFragment.this.f0());
            rVar.b(R$string.str_ble_open);
            rVar.setOnDialogListener(new j(DeviceScanFragment.this, 0));
            return rVar;
        }
    });

    public final com.example.test.ui.dialog.h A0() {
        return (com.example.test.ui.dialog.h) this.f8066h.getValue();
    }

    public final com.example.test.ui.dialog.i B0() {
        return (com.example.test.ui.dialog.i) this.f8063d.getValue();
    }

    public final void C0(int i3) {
        A0().a(i3);
        A0().setCancelable(false);
        A0().c(0);
        if (A0().isShowing()) {
            return;
        }
        A0().show();
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new u(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        h3 h3Var = (h3) this.f7251b;
        if (h3Var != null) {
            return h3Var.f12954a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_device_scan, viewGroup, false);
        int i3 = R$id.deviceList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.iv_hs_refresh;
            ImageView imageView = (ImageView) he.a(i3, inflate);
            if (imageView != null) {
                i3 = R$id.iv_hs_scan_icon;
                ImageView imageView2 = (ImageView) he.a(i3, inflate);
                if (imageView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) inflate;
                    i3 = R$id.tv_hs_scan_title;
                    TextView textView = (TextView) he.a(i3, inflate);
                    if (textView != null) {
                        i3 = R$id.tv_hs_unbind_tip;
                        if (((TextView) he.a(i3, inflate)) != null) {
                            i3 = R$id.tv_hs_unbind_title;
                            if (((TextView) he.a(i3, inflate)) != null) {
                                return new h3(relativeLayout, recyclerView, imageView, imageView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void b0() {
        if (A0().isShowing()) {
            A0().dismiss();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        Log.e("qob", "DeviceScanFragment initData");
        ((u) X()).k();
    }

    @Override // f7.f
    public final void i(User user) {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceScanFragment", "initView");
        h3 h3Var = (h3) this.f7251b;
        if (h3Var != null) {
            h3Var.f12956c.setOnClickListener(this);
        }
        h3 h3Var2 = (h3) this.f7251b;
        if (h3Var2 != null) {
            h3Var2.e.setOnClickListener(this);
        }
        h3 h3Var3 = (h3) this.f7251b;
        if (h3Var3 != null) {
            h3Var3.f12957d.setOnClickListener(this);
        }
        h3 h3Var4 = (h3) this.f7251b;
        RecyclerView recyclerView = h3Var4 != null ? h3Var4.f12955b : null;
        if (recyclerView != null) {
            f0();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
        }
        h3 h3Var5 = (h3) this.f7251b;
        if (h3Var5 != null) {
            RecyclerView recyclerView2 = h3Var5.f12955b;
            g0 g0Var = new g0(f0());
            g0Var.e(getResources().getColor(R.color.transparent));
            g0Var.o(R$dimen.qb_px_10);
            recyclerView2.g(g0Var.d());
        }
        h3 h3Var6 = (h3) this.f7251b;
        RecyclerView recyclerView3 = h3Var6 != null ? h3Var6.f12955b : null;
        eh.b bVar = this.f8064f;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter((DeviceScanAdapter) bVar.getValue());
        }
        h3 h3Var7 = (h3) this.f7251b;
        RecyclerView recyclerView4 = h3Var7 != null ? h3Var7.f12955b : null;
        if (recyclerView4 != null) {
            recyclerView4.setItemAnimator(null);
        }
        ((DeviceScanAdapter) bVar.getValue()).setOnItemClickListener(new i(this, 0));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tv_hs_scan_title;
        eh.b bVar = this.f8064f;
        eh.b bVar2 = this.e;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (u0()) {
                if (!q0()) {
                    this.f8062c = 1;
                    B0().b(2);
                    B0().show();
                    return;
                } else {
                    ((ObjectAnimator) bVar2.getValue()).start();
                    z0().clear();
                    ((DeviceScanAdapter) bVar.getValue()).notifyDataSetChanged();
                    ((u) X()).getClass();
                    u.l();
                    return;
                }
            }
            return;
        }
        int i10 = R$id.iv_hs_refresh;
        if (valueOf != null && valueOf.intValue() == i10) {
            if (u0()) {
                if (!q0()) {
                    this.f8062c = 1;
                    B0().b(2);
                    B0().show();
                    return;
                } else {
                    ((ObjectAnimator) bVar2.getValue()).start();
                    z0().clear();
                    ((DeviceScanAdapter) bVar.getValue()).notifyDataSetChanged();
                    ((u) X()).getClass();
                    u.l();
                    return;
                }
            }
            return;
        }
        int i11 = R$id.iv_hs_scan_icon;
        if (valueOf != null && valueOf.intValue() == i11 && u0()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.CAMERA");
            arrayList.addAll(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
            if (nd.c.j(f0(), arrayList)) {
                startActivity(new Intent(getActivity(), (Class<?>) ScanQrMlActivity.class));
                return;
            }
            this.f8062c = 2;
            B0().b(3);
            B0().show();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Log.e("qob", "DeviceScanFragment onDestroy");
        b0();
        ((u) X()).getClass();
        u.m();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            Log.e("qob", "DeviceScanFragment DEVICE_CONNECTED");
            b0();
            MainActivity mainActivity = (MainActivity) f0();
            mainActivity.R0().n();
            ((r0) mainActivity.f7249z.getValue()).f13272b.setTabProductType(1);
            r5.a.h(mainActivity.R0().c(), "switchHeadsetFragment ", "qob");
            return;
        }
        if (status == 2) {
            Log.e("qob", "DeviceScanFragment DEVICE_CONNECTING");
            return;
        }
        if (status == 3) {
            Log.e("qob", "DeviceScanFragment DEVICE_BINDING");
            C0(R$string.str_binding);
        } else if (status == 4) {
            b0();
        } else if (status != 5) {
            b0();
        } else {
            b0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean z5) {
        super.onHiddenChanged(z5);
        Log.e("qob", "DeviceScanFragment onHiddenChanged " + z5);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Log.e("qob", "DeviceScanFragment onResume isHidden " + isHidden());
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Log.e("qob", "DeviceScanFragment onStart");
        b2.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        Log.e("qob", "DeviceScanFragment onStop");
        b2.b(this);
    }

    public final boolean q0() {
        return nd.c.j(f0(), android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
    }

    @Override // f7.f
    public final void s0() {
        ((ObjectAnimator) this.e.getValue()).cancel();
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean z5) {
        super.setUserVisibleHint(z5);
        Log.e("qob", "DeviceScanFragment setUserVisibleHint " + z5);
    }

    public final boolean u0() {
        XXApplication xXApplication = XXApplication.f7400h;
        boolean d5 = t.d(j1.a());
        boolean n4 = com.example.baselibrary.utils.b.n(j1.a());
        if (!n4) {
            ((r) this.f8068j.getValue()).show();
            return n4;
        }
        if (!d5) {
            ((r) this.f8067i.getValue()).show();
        }
        return d5;
    }

    @Override // f7.f
    public final void y0(BleDeviceModel bleDeviceModel) {
        Object obj;
        Iterator it = z0().iterator();
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
            z0().remove(bleDeviceModel3);
        }
        z0().add(bleDeviceModel);
        List z02 = z0();
        if (z02.size() > 1) {
            kotlin.collections.m.h(z02, new androidx.viewpager2.widget.a(4));
        }
        ((DeviceScanAdapter) this.f8064f.getValue()).notifyItemRangeChanged(0, z0().size());
    }

    public final List z0() {
        return (List) this.f8065g.getValue();
    }
}
