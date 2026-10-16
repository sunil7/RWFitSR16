package com.example.test.ui.device.activity;

import android.content.Intent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.test.ui.device.model.MessageModel;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class z implements OnItemClickListener, s6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QrCodeManagerActivity f7900a;

    @Override // s6.b
    public void c(int i3, boolean z5) {
        QrCodeManagerActivity this$0 = this.f7900a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        int i10 = QrCodeManagerActivity.G;
        ((MessageModel) ((List) this$0.E.getValue()).get(i3)).setSelected(z5);
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = QrCodeManagerActivity.G;
        QrCodeManagerActivity this$0 = this.f7900a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        int id2 = ((MessageModel) ((List) this$0.E.getValue()).get(i3)).getId();
        Intent intent = new Intent(this$0, (Class<?>) QrCodeDetailActivity.class);
        intent.putExtra("QR_TYPE", id2);
        this$0.startActivity(intent);
    }
}
