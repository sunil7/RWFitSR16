package com.example.test.service;

import com.example.blesdk.bean.sync.LogInfoBean;
import com.example.test.XXApplication;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class y implements v5.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7836a;

    public y(d0 d0Var) {
        this.f7836a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        this.f7836a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", "日志同步错误：[" + i3 + "]");
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        final List list = (List) obj;
        if (list != null) {
            final d0 d0Var = this.f7836a;
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$syncLogCallback$2$1$onResult$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((List<? extends LogInfoBean>) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(List<? extends LogInfoBean> logInfos) {
                    String str;
                    kotlin.jvm.internal.e.f(logInfos, "logInfos");
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Long.valueOf(currentTimeMillis));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(currentTimeMillis, " date translate error ", e.getMessage()));
                        str = null;
                    }
                    XXApplication xXApplication = XXApplication.f7400h;
                    FileWriter fileWriter = new FileWriter(new File(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getFilesDir() + "/logger/product/" + str + ".log").getAbsolutePath(), true);
                    for (LogInfoBean logInfoBean : logInfos) {
                        fileWriter.write(logInfoBean.getTime() + " : " + logInfoBean.getContent() + "\n");
                    }
                    fileWriter.flush();
                    fileWriter.close();
                    d0.this.getClass();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", com.google.android.gms.internal.mlkit_vision_barcode.l0.k(list.size(), "日志同步成功：[", "]"));
                }
            }, new oh.l() { // from class: com.example.test.service.DeviceMonitorService$syncLogCallback$2$1$onResult$1$2
                public final void invoke(eh.g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((eh.g) obj2);
                    return eh.g.f12633a;
                }
            });
        }
    }
}
