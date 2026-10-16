package com.example.test.ui.device.activity;

import android.provider.Settings;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.device.model.MessageModel;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import f6.m1;

/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements OnItemChildClickListener, s6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RingMessagePushActivity f7845a;

    public /* synthetic */ a0(RingMessagePushActivity ringMessagePushActivity) {
        this.f7845a = ringMessagePushActivity;
    }

    @Override // s6.b
    public void c(int i3, boolean z5) {
        RingMessagePushActivity this$0 = this.f7845a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        int i10 = RingMessagePushActivity.H;
        ((MessageModel) this$0.R0().get(i3)).setSelected(z5);
        ((m1) this$0.f7247z.getValue()).f13120c.setItemOpen(this$0.U0());
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = RingMessagePushActivity.H;
        RingMessagePushActivity this$0 = this.f7845a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a();
        String packageName = j1.a().getApplicationContext().getPackageName();
        String string = Settings.Secure.getString(j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
        boolean z5 = false;
        if (string != null) {
            kotlin.jvm.internal.e.c(packageName);
            z5 = kotlin.text.m.c(string, packageName, false);
        }
        if (z5) {
            return;
        }
        this$0.T0().b(R$string.str_msg_tips);
        this$0.T0().show();
    }
}
