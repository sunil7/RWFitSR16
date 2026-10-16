package com.example.test.ui.testui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.service.u1;
import com.example.test.ui.device.activity.ScanQrFamilyActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.q1;
import f6.s2;
import f6.v3;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a1 implements a7.f, t6.a, a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8257a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8258b;

    public /* synthetic */ a1(Object obj, int i3) {
        this.f8257a = i3;
        this.f8258b = obj;
    }

    private final void a() {
    }

    @Override // a7.e
    public void B() {
        switch (this.f8257a) {
            case 3:
                TRingFamilyAddFriendActivity tRingFamilyAddFriendActivity = (TRingFamilyAddFriendActivity) this.f8258b;
                tRingFamilyAddFriendActivity.getClass();
                tRingFamilyAddFriendActivity.startActivity(new Intent(tRingFamilyAddFriendActivity, (Class<?>) ScanQrFamilyActivity.class));
                break;
        }
    }

    @Override // a7.f
    public void j(int i3) {
        Object obj = this.f8258b;
        switch (this.f8257a) {
            case 0:
                final TRringHomeFragment tRringHomeFragment = (TRringHomeFragment) obj;
                if (i3 != R$id.option1) {
                    if (i3 != R$id.option2) {
                        if (i3 == R$id.barStatusIv) {
                            FragmentActivity activity = tRringHomeFragment.getActivity();
                            kotlin.jvm.internal.e.d(activity, "null cannot be cast to non-null type com.example.test.ui.testui.TMainRingActivity");
                            TMainRingActivity tMainRingActivity = (TMainRingActivity) activity;
                            eh.b bVar = tMainRingActivity.f7249z;
                            View e = ((s2) bVar.getValue()).f13301c.e(8388611);
                            if (!(e != null ? DrawerLayout.m(e) : false)) {
                                tMainRingActivity.U0();
                                ((s2) bVar.getValue()).f13301c.p();
                                break;
                            }
                        }
                    } else {
                        tRringHomeFragment.V();
                        v3 v3Var = (v3) tRringHomeFragment.f7251b;
                        if (v3Var != null) {
                            com.example.baselibrary.utils.b.x(v3Var.f13410c, new oh.l() { // from class: com.example.test.ui.testui.TRringHomeFragment$initView$2$onAction$1$1
                                {
                                    super(1);
                                }

                                @Override // oh.l
                                public final String invoke(RecyclerView recyclerView) {
                                    kotlin.jvm.internal.e.f(recyclerView, "recyclerView");
                                    Bitmap createBitmap = Bitmap.createBitmap(recyclerView.getWidth(), recyclerView.getHeight(), Bitmap.Config.ARGB_8888);
                                    kotlin.jvm.internal.e.e(createBitmap, "createBitmap(...)");
                                    recyclerView.draw(new Canvas(createBitmap));
                                    TRringHomeFragment tRringHomeFragment2 = TRringHomeFragment.this;
                                    Object obj2 = com.example.test.utils.l.f8733a;
                                    return c2.a().b(tRringHomeFragment2.f0(), createBitmap, System.currentTimeMillis() + ".jpg");
                                }
                            }, new oh.l() { // from class: com.example.test.ui.testui.TRringHomeFragment$initView$2$onAction$1$2
                                {
                                    super(1);
                                }

                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((String) obj2);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String str) {
                                    TRringHomeFragment.this.b0();
                                    if (str != null) {
                                        aa.a(TRringHomeFragment.this.f0(), str);
                                    }
                                }
                            });
                            break;
                        }
                    }
                } else if (!com.example.test.service.e.h().i()) {
                    int i10 = R$string.str_device_disconnected;
                    tRringHomeFragment.getClass();
                    com.example.baselibrary.utils.d.a(i10);
                    break;
                } else {
                    XXApplication xXApplication = XXApplication.f7400h;
                    j1.a().e = false;
                    Object obj2 = u1.f7811u;
                    q1.a().g();
                    break;
                }
                break;
            case 1:
                if (i3 == R$id.barStatusIv) {
                    ((TRingBloodOxygenDescActivity) obj).finish();
                    break;
                }
                break;
            case 2:
            case 3:
            default:
                if (i3 == R$id.barStatusIv) {
                    ((TRingThemeTypeActivity) obj).finish();
                    break;
                }
                break;
            case 4:
                if (i3 == R$id.barStatusIv) {
                    ((TRingHealthDetailActivity) obj).finish();
                    break;
                }
                break;
            case 5:
                if (i3 == R$id.barStatusIv) {
                    ((TRingHeartRateDescActivity) obj).finish();
                    break;
                }
                break;
            case 6:
                if (i3 == R$id.barStatusIv) {
                    ((TRingPCycleSettingsActivity) obj).finish();
                    break;
                }
                break;
            case 7:
                TRingPCycleStatisticsActivity tRingPCycleStatisticsActivity = (TRingPCycleStatisticsActivity) obj;
                if (i3 != R$id.barStatusIv) {
                    if (i3 == R$id.option1) {
                        tRingPCycleStatisticsActivity.getClass();
                        tRingPCycleStatisticsActivity.startActivity(new Intent(tRingPCycleStatisticsActivity, (Class<?>) TRingPCycleSettingsActivity.class));
                        break;
                    }
                } else {
                    tRingPCycleStatisticsActivity.finish();
                    break;
                }
                break;
        }
    }

    @Override // a7.e
    public void u0() {
        switch (this.f8257a) {
            case 3:
                TRingFamilyAddFriendActivity tRingFamilyAddFriendActivity = (TRingFamilyAddFriendActivity) this.f8258b;
                tRingFamilyAddFriendActivity.onBackPressed();
                tRingFamilyAddFriendActivity.finish();
                break;
            default:
                ((TringAlarmActivity) this.f8258b).onBackPressed();
                break;
        }
    }

    @Override // t6.a
    public void v(String data) {
        Date date;
        kotlin.jvm.internal.e.f(data, "data");
        TRingDateSelectView tRingDateSelectView = (TRingDateSelectView) this.f8258b;
        Calendar calendar = tRingDateSelectView.f8206b;
        if (calendar != null) {
            try {
                date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(data);
            } catch (Exception unused) {
                date = null;
            }
            if (date == null) {
                date = new Date();
            }
            calendar.setTime(date);
        }
        tRingDateSelectView.d();
    }
}
