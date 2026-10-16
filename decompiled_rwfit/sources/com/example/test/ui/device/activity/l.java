package com.example.test.ui.device.activity;

import android.os.Build;
import android.util.Log;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dh.imagepick.ImagePickClient;
import com.dh.imagepick.crop.CropImageView;
import com.example.test.ui.adapter.TextColourAdapter;
import com.example.test.ui.adapter.TextFontAdapter;
import com.example.test.ui.model.dial.BackgroundSelectModel;
import com.example.test.ui.model.dial.ColorSelectModel;
import com.example.test.ui.model.dial.FontSelectModel;
import com.example.test.ui.model.dial.PlacementSelectModel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements OnItemClickListener, nd.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7873a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CustomJLDialActivity f7874b;

    public /* synthetic */ l(CustomJLDialActivity customJLDialActivity, int i3) {
        this.f7873a = i3;
        this.f7874b = customJLDialActivity;
    }

    @Override // nd.b
    public void h(boolean z5) {
        int i3 = CustomJLDialActivity.U;
        final CustomJLDialActivity this$0 = this.f7874b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (z5) {
            int width = this$0.R0().getWidth();
            int height = this$0.R0().getHeight();
            int dialType = this$0.R0().getDialType();
            oh.l lVar = new oh.l() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$initView$3$3$1
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String str) {
                    CustomJLDialActivity customJLDialActivity = CustomJLDialActivity.this;
                    int i10 = CustomJLDialActivity.U;
                    Iterator it = customJLDialActivity.U0().iterator();
                    while (it.hasNext()) {
                        ((BackgroundSelectModel) it.next()).setSelected(false);
                    }
                    BackgroundSelectModel backgroundSelectModel = new BackgroundSelectModel();
                    backgroundSelectModel.setUrl(str);
                    backgroundSelectModel.setSelected(true);
                    backgroundSelectModel.setDialType(CustomJLDialActivity.this.R0().getDialType());
                    CustomJLDialActivity.this.U0().add(1, backgroundSelectModel);
                    CustomJLDialActivity customJLDialActivity2 = CustomJLDialActivity.this;
                    customJLDialActivity2.F = backgroundSelectModel;
                    customJLDialActivity2.T0().notifyItemRangeChanged(0, CustomJLDialActivity.this.U0().size());
                    CustomJLDialActivity.this.Y0(true, false, false);
                }
            };
            CustomJLDialActivity$initView$3$3$2 errorBack = new oh.l() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$initView$3$3$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String error) {
                    kotlin.jvm.internal.e.f(error, "error");
                    Log.e("CustomJLDialActivity", error);
                }
            };
            kotlin.jvm.internal.e.f(errorBack, "errorBack");
            CropImageView.Style style = dialType == 1 ? CropImageView.Style.CIRCLE : CropImageView.Style.RECTANGLE;
            com.dh.imagepick.work.c with = ImagePickClient.with(this$0);
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
        final CustomJLDialActivity this$0 = this.f7874b;
        int i10 = 1;
        switch (this.f7873a) {
            case 0:
                int i11 = CustomJLDialActivity.U;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
                if (i3 != 0) {
                    Iterator it = this$0.U0().iterator();
                    while (it.hasNext()) {
                        ((BackgroundSelectModel) it.next()).setSelected(false);
                    }
                    ((BackgroundSelectModel) this$0.U0().get(i3)).setSelected(true);
                    this$0.F = (BackgroundSelectModel) this$0.U0().get(i3);
                    this$0.T0().notifyItemRangeChanged(0, this$0.U0().size());
                    this$0.Y0(true, false, false);
                    break;
                } else if (Build.VERSION.SDK_INT < 30) {
                    v2.h hVar = new v2.h(this$0);
                    hVar.o("android.permission.WRITE_EXTERNAL_STORAGE");
                    hVar.o("android.permission.READ_EXTERNAL_STORAGE");
                    hVar.p(new l(this$0, i10));
                    break;
                } else {
                    int width = this$0.R0().getWidth();
                    int height = this$0.R0().getHeight();
                    int dialType = this$0.R0().getDialType();
                    oh.l lVar = new oh.l() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$initView$3$1
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return eh.g.f12633a;
                        }

                        public final void invoke(String str) {
                            CustomJLDialActivity customJLDialActivity = CustomJLDialActivity.this;
                            int i12 = CustomJLDialActivity.U;
                            Iterator it2 = customJLDialActivity.U0().iterator();
                            while (it2.hasNext()) {
                                ((BackgroundSelectModel) it2.next()).setSelected(false);
                            }
                            BackgroundSelectModel backgroundSelectModel = new BackgroundSelectModel();
                            backgroundSelectModel.setUrl(str);
                            backgroundSelectModel.setSelected(true);
                            backgroundSelectModel.setDialType(CustomJLDialActivity.this.R0().getDialType());
                            CustomJLDialActivity.this.U0().add(1, backgroundSelectModel);
                            CustomJLDialActivity customJLDialActivity2 = CustomJLDialActivity.this;
                            customJLDialActivity2.F = backgroundSelectModel;
                            customJLDialActivity2.T0().notifyItemRangeChanged(0, CustomJLDialActivity.this.U0().size());
                            CustomJLDialActivity.this.Y0(true, false, false);
                        }
                    };
                    CustomJLDialActivity$initView$3$2 errorBack = new oh.l() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$initView$3$2
                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return eh.g.f12633a;
                        }

                        public final void invoke(String error) {
                            kotlin.jvm.internal.e.f(error, "error");
                            Log.e("MainActivity", error);
                        }
                    };
                    kotlin.jvm.internal.e.f(errorBack, "errorBack");
                    CropImageView.Style style = dialType == 1 ? CropImageView.Style.CIRCLE : CropImageView.Style.RECTANGLE;
                    com.dh.imagepick.work.c with = ImagePickClient.with(this$0);
                    with.getClass();
                    f5.a a3 = com.dh.imagepick.work.c.a(new f5.b(with).i());
                    kotlin.jvm.internal.e.f(style, "style");
                    a3.f12665c = width;
                    a3.f12666d = height;
                    a3.e = style;
                    a3.h(new com.example.test.utils.o(errorBack, lVar, 1));
                    break;
                }
            case 1:
            default:
                int i12 = CustomJLDialActivity.U;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
                Iterator it2 = this$0.W0().iterator();
                while (it2.hasNext()) {
                    ((FontSelectModel) it2.next()).setSelected(false);
                }
                ((FontSelectModel) this$0.W0().get(i3)).setSelected(true);
                this$0.H = (FontSelectModel) this$0.W0().get(i3);
                ((TextFontAdapter) this$0.Q.getValue()).notifyItemRangeChanged(0, this$0.W0().size());
                this$0.Y0(false, true, false);
                break;
            case 2:
                int i13 = CustomJLDialActivity.U;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
                Iterator it3 = this$0.V0().iterator();
                while (it3.hasNext()) {
                    ((ColorSelectModel) it3.next()).setSelected(false);
                }
                ((ColorSelectModel) this$0.V0().get(i3)).setSelected(true);
                String color = ((ColorSelectModel) this$0.V0().get(i3)).getColor();
                kotlin.jvm.internal.e.e(color, "getColor(...)");
                this$0.E = color;
                ((TextColourAdapter) this$0.O.getValue()).notifyItemRangeChanged(0, this$0.V0().size());
                this$0.Y0(false, false, true);
                break;
            case 3:
                int i14 = CustomJLDialActivity.U;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
                ArrayList arrayList = this$0.I;
                int size = arrayList.size();
                int i15 = 0;
                while (i15 < size) {
                    Object obj = arrayList.get(i15);
                    i15++;
                    ((PlacementSelectModel) obj).setSelected(false);
                }
                ((PlacementSelectModel) arrayList.get(i3)).setSelected(true);
                this$0.G = (PlacementSelectModel) arrayList.get(i3);
                this$0.X0().notifyItemRangeChanged(0, arrayList.size());
                this$0.Y0(false, false, false);
                break;
        }
    }
}
