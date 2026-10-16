package com.example.test.ui.device.activity;

import com.example.test.R$string;
import com.example.test.service.p0;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.m1;
import f6.a1;

/* loaded from: classes.dex */
public final /* synthetic */ class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7893a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OtaActivity f7894b;

    public /* synthetic */ w(OtaActivity otaActivity, int i3) {
        this.f7893a = i3;
        this.f7894b = otaActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OtaActivity this$0 = this.f7894b;
        switch (this.f7893a) {
            case 0:
                int i3 = OtaActivity.J;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                this$0.E = false;
                eh.b bVar = this$0.f7247z;
                ((a1) bVar.getValue()).f12681b.setProgress(100.0f);
                ((a1) bVar.getValue()).f12681b.setText("100%");
                com.example.test.utils.y.u().G();
                this$0.b0();
                this$0.w0(R$string.str_upgrade_success);
                Object obj = p0.f7741g;
                m1.a().i();
                yh.d.b().e(new EventBusBeans.FirmwareEvent(-1, null));
                this$0.onBackPressed();
                break;
            default:
                int i10 = OtaActivity.J;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                com.example.test.utils.y.u().G();
                this$0.b0();
                if (!this$0.F) {
                    this$0.F = true;
                    this$0.w0(R$string.str_upgrade_fail);
                }
                eh.b bVar2 = this$0.f7247z;
                ((a1) bVar2.getValue()).f12681b.setEnable(true);
                ((a1) bVar2.getValue()).f12681b.setText(this$0.getString(R$string.str_reinstall));
                this$0.finish();
                break;
        }
    }
}
