package com.example.test.ui.mine.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.widget.NestedScrollView;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.SwitchBean;
import com.example.test.presenter.main.d0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import f6.e1;
import f6.x0;
import java.util.ArrayList;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes.dex */
public final class o implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8139a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f8140b;

    public /* synthetic */ o(XXBaseActivity xXBaseActivity, int i3) {
        this.f8139a = i3;
        this.f8140b = xXBaseActivity;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }

    @Override // a7.e
    public final void B() {
        XXBaseActivity xXBaseActivity = this.f8140b;
        switch (this.f8139a) {
            case 0:
                final MyQrCodeActivity myQrCodeActivity = (MyQrCodeActivity) xXBaseActivity;
                com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.mine.activity.MyQrCodeActivity$initView$1$onRightEvent$1
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public final String invoke(String it) {
                        Bitmap bitmap;
                        kotlin.jvm.internal.e.f(it, "it");
                        MyQrCodeActivity myQrCodeActivity2 = MyQrCodeActivity.this;
                        int i3 = MyQrCodeActivity.E;
                        NestedScrollView nestedScrollView = ((x0) myQrCodeActivity2.f7247z.getValue()).f13438d;
                        int childCount = nestedScrollView.getChildCount();
                        int i10 = 0;
                        for (int i11 = 0; i11 < childCount; i11++) {
                            i10 += nestedScrollView.getChildAt(i11).getHeight();
                        }
                        int f2 = com.example.baselibrary.utils.b.f(nestedScrollView.getContext(), 20.0f) + i10;
                        if (f2 > 0) {
                            bitmap = Bitmap.createBitmap(nestedScrollView.getWidth(), f2, Bitmap.Config.RGB_565);
                            kotlin.jvm.internal.e.e(bitmap, "createBitmap(...)");
                            nestedScrollView.draw(new Canvas(bitmap));
                        } else {
                            bitmap = null;
                        }
                        if (bitmap == null) {
                            return null;
                        }
                        MyQrCodeActivity myQrCodeActivity3 = MyQrCodeActivity.this;
                        Object obj = com.example.test.utils.l.f8733a;
                        return c2.a().b(myQrCodeActivity3, bitmap, System.currentTimeMillis() + ".jpg");
                    }
                }, new oh.l() { // from class: com.example.test.ui.mine.activity.MyQrCodeActivity$initView$1$onRightEvent$2
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return eh.g.f12633a;
                    }

                    public final void invoke(String str) {
                        if (str != null) {
                            aa.a(MyQrCodeActivity.this, str);
                        }
                    }
                });
                break;
            case 6:
                int i3 = PrivacySafeActivity.E;
                PrivacySafeActivity privacySafeActivity = (PrivacySafeActivity) xXBaseActivity;
                com.example.test.presenter.mine.p pVar = (com.example.test.presenter.mine.p) privacySafeActivity.I0();
                eh.b bVar = privacySafeActivity.f7247z;
                boolean itemOpen = ((e1) bVar.getValue()).f12822d.getItemOpen();
                boolean itemOpen2 = ((e1) bVar.getValue()).e.getItemOpen();
                boolean itemOpen3 = ((e1) bVar.getValue()).f12821c.getItemOpen();
                pVar.getClass();
                ArrayList arrayList = new ArrayList();
                SwitchBean switchBean = new SwitchBean();
                switchBean.setParaName("isPerson");
                switchBean.setParaValue(itemOpen ? "1" : "0");
                arrayList.add(switchBean);
                SwitchBean switchBean2 = new SwitchBean();
                switchBean2.setParaName("isSport");
                switchBean2.setParaValue(itemOpen2 ? "1" : "0");
                arrayList.add(switchBean2);
                SwitchBean switchBean3 = new SwitchBean();
                switchBean3.setParaName("isHealth");
                switchBean3.setParaValue(itemOpen3 ? "1" : "0");
                arrayList.add(switchBean3);
                c6.d dVar = c6.d.f3392c;
                dVar.getClass();
                RequestBody.Companion companion = RequestBody.Companion;
                MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
                String z5 = com.example.baselibrary.utils.b.z(arrayList);
                kotlin.jvm.internal.e.e(z5, "toJson(...)");
                rg.l<HttpModel<String>> saveSwitch = ((UserApi) dVar.f113a).saveSwitch(companion.create(parse, z5));
                kotlin.jvm.internal.e.e(saveSwitch, "saveSwitch(...)");
                rg.l w8 = com.example.baselibrary.utils.b.w(saveSwitch);
                PrivacySafeActivity privacySafeActivity2 = (PrivacySafeActivity) ((h7.i) pVar.f7255a);
                privacySafeActivity2.getClass();
                w8.subscribe(new d0(arrayList, pVar, privacySafeActivity2, w0.d(), 6));
                break;
        }
    }

    @Override // a7.e
    public final void u0() {
        switch (this.f8139a) {
            case 0:
                ((MyQrCodeActivity) this.f8140b).onBackPressed();
                break;
            case 1:
                ((AboutActivity) this.f8140b).onBackPressed();
                break;
            case 2:
                ((AccountSafeActivity) this.f8140b).onBackPressed();
                break;
            case 3:
                ((BackgroudHelpActivity) this.f8140b).onBackPressed();
                break;
            case 4:
                ((DebugActivity) this.f8140b).onBackPressed();
                break;
            case 5:
                ((FeedBackActivity) this.f8140b).onBackPressed();
                break;
            case 6:
                ((PrivacySafeActivity) this.f8140b).onBackPressed();
                break;
            case 7:
                ((RingContactActivity) this.f8140b).onBackPressed();
                break;
            case 8:
                ((SelectActivity) this.f8140b).onBackPressed();
                break;
            default:
                ((WebContentActivity) this.f8140b).onBackPressed();
                break;
        }
    }
}
