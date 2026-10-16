package com.example.test.ui.device.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dh.imagepick.ImagePickClient;
import com.dh.imagepick.crop.CropImageView;
import com.example.test.R$drawable;
import com.example.test.ui.device.adapter.ColorAdapter;
import com.example.test.ui.device.model.ColorSelectModel;
import com.tencent.connect.common.Constants;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements nd.b, OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomDialActivity f7864a;

    public /* synthetic */ i(CustomDialActivity customDialActivity) {
        this.f7864a = customDialActivity;
    }

    @Override // nd.b
    public void h(boolean z5) {
        int i3 = CustomDialActivity.U;
        final CustomDialActivity customDialActivity = this.f7864a;
        if (z5) {
            int width = customDialActivity.V0().getWidth();
            int height = customDialActivity.V0().getHeight();
            int dialType = customDialActivity.V0().getDialType();
            oh.l lVar = new oh.l() { // from class: com.example.test.ui.device.activity.CustomDialActivity$onClick$3$1
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String path) {
                    kotlin.jvm.internal.e.f(path, "path");
                    CustomDialActivity customDialActivity2 = CustomDialActivity.this;
                    customDialActivity2.O = path;
                    ((f6.t) customDialActivity2.f7247z.getValue()).f13326m.setCanPress(true);
                    int dialType2 = CustomDialActivity.this.V0().getDialType();
                    z3.h hVar = z3.h.f20239b;
                    if (dialType2 == 1) {
                        CustomDialActivity customDialActivity3 = CustomDialActivity.this;
                        ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(customDialActivity3).n(path).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(CustomDialActivity.R0(customDialActivity3).f13319f);
                        return;
                    }
                    float f2 = kotlin.jvm.internal.e.a(CustomDialActivity.this.U0().getDeviceClazz(), Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) ? 30.0f : 16.0f;
                    CustomDialActivity customDialActivity4 = CustomDialActivity.this;
                    ImageView imageView = CustomDialActivity.R0(customDialActivity4).f13319f;
                    CustomDialActivity customDialActivity5 = CustomDialActivity.this;
                    customDialActivity5.getClass();
                    ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(customDialActivity4).n(path).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).a(p4.e.t(new g4.v(com.example.baselibrary.utils.b.f(customDialActivity5, f2)))).e(R$drawable.bg_dial_item)).x(imageView);
                }
            };
            CustomDialActivity$onClick$3$2 errorBack = new oh.l() { // from class: com.example.test.ui.device.activity.CustomDialActivity$onClick$3$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String error) {
                    kotlin.jvm.internal.e.f(error, "error");
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                }
            };
            kotlin.jvm.internal.e.f(errorBack, "errorBack");
            CropImageView.Style style = dialType == 1 ? CropImageView.Style.CIRCLE : CropImageView.Style.RECTANGLE;
            com.dh.imagepick.work.c with = ImagePickClient.with(customDialActivity);
            with.getClass();
            f5.a a3 = com.dh.imagepick.work.c.a(new f5.b(with).i());
            kotlin.jvm.internal.e.f(style, "style");
            a3.f12665c = width;
            a3.f12666d = height;
            a3.e = style;
            a3.h(new com.example.test.utils.o(errorBack, lVar, 1));
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = CustomDialActivity.U;
        CustomDialActivity this$0 = this.f7864a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        this$0.T = false;
        Iterator it = this$0.S0().iterator();
        while (it.hasNext()) {
            ((ColorSelectModel) it.next()).setSelected(false);
        }
        ((ColorSelectModel) this$0.S0().get(i3)).setSelected(true);
        this$0.T0().setColor(((ColorSelectModel) this$0.S0().get(i3)).getColor());
        ((f6.t) this$0.f7247z.getValue()).f13321h.setContentColor(Color.parseColor(((ColorSelectModel) this$0.S0().get(i3)).getColor()));
        ((ColorAdapter) this$0.N.getValue()).notifyItemRangeChanged(0, this$0.S0().size());
    }
}
