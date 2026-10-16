package com.example.test.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.example.network.base.HttpModel;
import com.example.network.bean.FirmwareInfoBean;
import com.example.test.XXApplication;
import com.example.test.ui.device.activity.OtaActivity;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class n0 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p0 f7735d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(Context context, p0 p0Var, com.example.test.utils.w0 w0Var) {
        super(context, w0Var);
        this.f7735d = p0Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        p0 p0Var = this.f7735d;
        if (i3 == 1051) {
            p0.c(p0Var);
        } else {
            p0Var.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "获取服务器版本信息错误：code " + i3 + " message " + th2.getMessage() + th2.getCause());
        }
        yh.d.b().e(new EventBusBeans.FirmwareEvent(-1, p0Var.d()));
    }

    @Override // d6.b
    public final void b(Object obj) {
        com.example.test.ui.dialog.r a3;
        HttpModel httpModel = (HttpModel) obj;
        if (httpModel != null) {
            p0 p0Var = this.f7735d;
            p0Var.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "getJLOTAFailedFirmwareInfoWithMac服务器固件版本信息返回：" + httpModel.getResults());
            Boolean isSuccess = httpModel.isSuccess();
            kotlin.jvm.internal.e.e(isSuccess, "isSuccess(...)");
            if (isSuccess.booleanValue()) {
                FirmwareInfoBean firmwareInfoBean = (FirmwareInfoBean) httpModel.getResults();
                if (httpModel.getResults() == null) {
                    yh.d.b().e(new EventBusBeans.FirmwareEvent(-1, p0Var.d()));
                    try {
                        if (p0Var.f7746f || (a3 = p0.a(p0Var)) == null) {
                            return;
                        }
                        a3.show();
                        return;
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "firmwareUpdateTips ex" + e);
                        return;
                    }
                }
                if (firmwareInfoBean != null) {
                    p0Var.d().setDeviceModel(firmwareInfoBean.getDeviceModel());
                    p0Var.d().setFromVersion(firmwareInfoBean.getFromVersion());
                    p0Var.d().setDownloadUrl(firmwareInfoBean.getDownloadUrl());
                    p0Var.d().setSummary(firmwareInfoBean.getSummary());
                    p0Var.d().setSize(firmwareInfoBean.getSize());
                    p0Var.d().setToVersion(firmwareInfoBean.getToVersion());
                    p0.b(p0Var);
                    XXApplication xXApplication = XXApplication.f7400h;
                    Activity c9 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
                    if (c9 != null) {
                        c9.startActivity(new Intent(c9, (Class<?>) OtaActivity.class));
                    }
                }
            }
        }
    }
}
