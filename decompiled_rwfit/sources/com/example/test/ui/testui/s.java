package com.example.test.ui.testui;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.ui.device.activity.ScanQrMlActivity;
import com.example.test.ui.device.model.BleDeviceModel;
import com.example.test.ui.mine.activity.AboutActivity;
import com.example.test.ui.mine.activity.MyQrCodeActivity;
import com.example.test.ui.mine.activity.PersonalJLActivity;
import com.example.test.ui.mine.activity.SettingActivity;
import f6.k1;

/* loaded from: classes.dex */
public final /* synthetic */ class s implements nd.b, OnItemClickListener, com.google.android.material.navigation.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8309a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TRingDeviceScanActivity f8310b;

    public /* synthetic */ s(TRingDeviceScanActivity tRingDeviceScanActivity, int i3) {
        this.f8309a = i3;
        this.f8310b = tRingDeviceScanActivity;
    }

    @Override // com.google.android.material.navigation.h
    public boolean a(MenuItem menuItem) {
        int i3 = TRingDeviceScanActivity.O;
        TRingDeviceScanActivity this$0 = this.f8310b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId == R$id.nav_qcoder) {
            this$0.startActivity(new Intent(this$0, (Class<?>) MyQrCodeActivity.class));
            this$0.S0();
            return true;
        }
        if (itemId == R$id.nav_persional) {
            this$0.startActivity(new Intent(this$0, (Class<?>) PersonalJLActivity.class));
            this$0.S0();
            return true;
        }
        if (itemId == R$id.nav_settings) {
            this$0.startActivity(new Intent(this$0, (Class<?>) SettingActivity.class));
            this$0.S0();
            return true;
        }
        if (itemId != R$id.nav_about) {
            return false;
        }
        this$0.startActivity(new Intent(this$0, (Class<?>) AboutActivity.class));
        this$0.S0();
        return true;
    }

    @Override // nd.b
    public void h(boolean z5) {
        View view;
        TRingDeviceScanActivity this$0 = this.f8310b;
        switch (this.f8309a) {
            case 0:
                int i3 = TRingDeviceScanActivity.O;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    this$0.w0(R$string.str_blue_permission_tips);
                    break;
                } else {
                    eh.b bVar = this$0.f7247z;
                    k1 k1Var = (k1) bVar.getValue();
                    view = k1Var != null ? k1Var.f13054h : null;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    k1 k1Var2 = (k1) bVar.getValue();
                    if (k1Var2 != null) {
                        k1Var2.f13057k.b();
                    }
                    ((com.example.test.presenter.device.u) this$0.I0()).getClass();
                    com.example.test.presenter.device.u.l();
                    break;
                }
            case 1:
                int i10 = TRingDeviceScanActivity.O;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (z5) {
                    this$0.startActivity(new Intent(this$0, (Class<?>) ScanQrMlActivity.class));
                    break;
                }
                break;
            default:
                int i11 = TRingDeviceScanActivity.O;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    this$0.w0(R$string.str_blue_permission_tips);
                    break;
                } else {
                    eh.b bVar2 = this$0.f7247z;
                    k1 k1Var3 = (k1) bVar2.getValue();
                    view = k1Var3 != null ? k1Var3.f13054h : null;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    k1 k1Var4 = (k1) bVar2.getValue();
                    if (k1Var4 != null) {
                        k1Var4.f13057k.b();
                    }
                    ((com.example.test.presenter.device.u) this$0.I0()).getClass();
                    com.example.test.presenter.device.u.l();
                    break;
                }
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = TRingDeviceScanActivity.O;
        TRingDeviceScanActivity this$0 = this.f8310b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "TRingDeviceScanActivity", "setOnItemClickListener " + i3);
        ((com.example.test.presenter.device.u) this$0.I0()).getClass();
        com.example.test.presenter.device.u.m();
        this$0.Q0(R$string.str_device_connecting);
        s5.a aVar = new s5.a();
        aVar.f18210a = ((BleDeviceModel) this$0.T0().get(i3)).getName();
        aVar.f18212c = ((BleDeviceModel) this$0.T0().get(i3)).getMac();
        aVar.f18214f = ((BleDeviceModel) this$0.T0().get(i3)).getRawDataFlag();
        aVar.f18215g = ((BleDeviceModel) this$0.T0().get(i3)).getPidType();
        Log.d(this$0.E, com.google.android.gms.internal.mlkit_vision_barcode.l0.j(((BleDeviceModel) this$0.T0().get(i3)).getPidType(), "Click device typoe = "));
        this$0.I = aVar;
        com.example.test.service.e.h().c(aVar);
    }
}
