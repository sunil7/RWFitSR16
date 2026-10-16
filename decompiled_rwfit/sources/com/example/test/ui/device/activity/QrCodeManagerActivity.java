package com.example.test.ui.device.activity;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.MessageAdapter;
import com.example.test.ui.device.model.MessageModel;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.g1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class QrCodeManagerActivity extends XXBaseActivity<com.example.test.presenter.device.n, g1> implements p5.a {
    public static final /* synthetic */ int G = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.QrCodeManagerActivity$data$2
        @Override // oh.a
        public final List<MessageModel> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessageModel(0, R$mipmap.ic_qq, R$string.str_qq, true));
            arrayList.add(new MessageModel(1, R$mipmap.ic_wechat, R$string.str_wechat, true));
            arrayList.add(new MessageModel(2, R$mipmap.ic_whatsapp, R$string.str_whatsapp, true));
            arrayList.add(new MessageModel(3, R$mipmap.ic_twitter, R$string.str_twitter, true));
            arrayList.add(new MessageModel(4, R$mipmap.ic_facebook, R$string.str_facebook, true));
            arrayList.add(new MessageModel(7, R$mipmap.ic_others, R$string.str_other, true));
            return arrayList;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.QrCodeManagerActivity$messageAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final MessageAdapter invoke() {
            QrCodeManagerActivity qrCodeManagerActivity = QrCodeManagerActivity.this;
            int i3 = QrCodeManagerActivity.G;
            MessageAdapter messageAdapter = new MessageAdapter((List) qrCodeManagerActivity.E.getValue());
            messageAdapter.setOnSwitchItemStatusListener(new z(QrCodeManagerActivity.this));
            return messageAdapter;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 2);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((g1) this.f7247z.getValue()).f12914a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_qr_code_manager, (ViewGroup) null, false);
        int i3 = R$id.messageList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.titleView;
            TitleView titleView = (TitleView) he.a(i3, inflate);
            if (titleView != null) {
                return new g1((LinearLayout) inflate, recyclerView, titleView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((g1) bVar.getValue()).f12916c.setOnTitleListener(new y2.f(this, 25));
        ((g1) bVar.getValue()).f12915b.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView = ((g1) bVar.getValue()).f12915b;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        recyclerView.g(g0Var.d());
        ((g1) bVar.getValue()).f12915b.setItemViewCacheSize(((List) this.E.getValue()).size());
        RecyclerView recyclerView2 = ((g1) bVar.getValue()).f12915b;
        eh.b bVar2 = this.F;
        recyclerView2.setAdapter((MessageAdapter) bVar2.getValue());
        ((MessageAdapter) bVar2.getValue()).setOnItemClickListener(new z(this));
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }
}
