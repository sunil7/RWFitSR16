package g9;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.z0;
import com.amap.api.maps.MapsInitializer;
import com.example.test.R$string;
import com.example.test.presenter.main.f1;
import com.example.test.ui.sport.activity.SportCountDownNewActivity;
import com.example.test.ui.testui.TRingEditCardActivity;
import com.example.test.ui.testui.TRingSportTypeNewActivity;
import com.example.test.ui.testui.x0;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.gms.internal.mlkit_vision_barcode.w1;

/* loaded from: classes.dex */
public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13997a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13998b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z0 f13999c;

    public /* synthetic */ r(z0 z0Var, int i3, int i10) {
        this.f13997a = i10;
        this.f13999c = z0Var;
        this.f13998b = i3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        final int i3 = 0;
        final int i10 = 1;
        int i11 = this.f13998b;
        z0 z0Var = this.f13999c;
        switch (this.f13997a) {
            case 0:
                s sVar = (s) z0Var;
                int i12 = sVar.f14002c;
                StyledPlayerControlView styledPlayerControlView = sVar.f14003d;
                if (i11 != i12) {
                    styledPlayerControlView.setPlaybackSpeed(sVar.f14001b[i11] / 100.0f);
                }
                styledPlayerControlView.f8992f0.dismiss();
                break;
            case 1:
                q6.a aVar = ((q6.c) z0Var).f17793b;
                if (aVar != null) {
                    Log.d("tong", "you click = " + i11);
                    int i13 = TRingEditCardActivity.G;
                    TRingEditCardActivity tRingEditCardActivity = ((com.example.test.ui.testui.u) aVar).f8315a;
                    if (((com.example.test.ui.testui.b) tRingEditCardActivity.R0().f17792a.get(i11)).f8261c == 0) {
                        ((com.example.test.ui.testui.b) tRingEditCardActivity.R0().f17792a.get(i11)).f8261c = 1;
                    } else {
                        ((com.example.test.ui.testui.b) tRingEditCardActivity.R0().f17792a.get(i11)).f8261c = 0;
                    }
                    tRingEditCardActivity.R0().notifyDataSetChanged();
                    break;
                }
                break;
            default:
                u6.u uVar = (u6.u) z0Var;
                uVar.getClass();
                if (!w1.a()) {
                    x0 x0Var = (x0) uVar.f18927c;
                    x0Var.getClass();
                    final int i14 = i11 + 7;
                    int i15 = TRingSportTypeNewActivity.G;
                    final TRingSportTypeNewActivity tRingSportTypeNewActivity = x0Var.f8327a;
                    tRingSportTypeNewActivity.getClass();
                    MapsInitializer.updatePrivacyShow(tRingSportTypeNewActivity, true, true);
                    MapsInitializer.updatePrivacyAgree(tRingSportTypeNewActivity, true);
                    if (Build.VERSION.SDK_INT < 30) {
                        v2.h hVar = new v2.h(tRingSportTypeNewActivity);
                        hVar.o("android.permission.ACTIVITY_RECOGNITION");
                        hVar.o("android.permission.BODY_SENSORS");
                        hVar.o("android.permission.WRITE_EXTERNAL_STORAGE");
                        hVar.o("android.permission.READ_EXTERNAL_STORAGE");
                        hVar.p(new nd.b() { // from class: com.example.test.ui.testui.w0
                            @Override // nd.b
                            public final void h(boolean z5) {
                                int i16 = i14;
                                TRingSportTypeNewActivity this$0 = tRingSportTypeNewActivity;
                                switch (i10) {
                                    case 0:
                                        int i17 = TRingSportTypeNewActivity.G;
                                        kotlin.jvm.internal.e.f(this$0, "this$0");
                                        if (!z5) {
                                            com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                                            break;
                                        } else {
                                            ((f1) this$0.I0()).k(1);
                                            Intent intent = new Intent(this$0, (Class<?>) SportCountDownNewActivity.class);
                                            intent.putExtra("sport_type", i16);
                                            intent.putExtra("sport_status", 1);
                                            this$0.startActivity(intent);
                                            break;
                                        }
                                    default:
                                        int i18 = TRingSportTypeNewActivity.G;
                                        kotlin.jvm.internal.e.f(this$0, "this$0");
                                        if (!z5) {
                                            com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                                            break;
                                        } else {
                                            ((f1) this$0.I0()).k(1);
                                            Intent intent2 = new Intent(this$0, (Class<?>) SportCountDownNewActivity.class);
                                            intent2.putExtra("sport_type", i16);
                                            intent2.putExtra("sport_status", 1);
                                            this$0.startActivity(intent2);
                                            break;
                                        }
                                }
                            }
                        });
                        break;
                    } else {
                        v2.h hVar2 = new v2.h(tRingSportTypeNewActivity);
                        hVar2.o("android.permission.ACTIVITY_RECOGNITION");
                        hVar2.o("android.permission.BODY_SENSORS");
                        hVar2.p(new nd.b() { // from class: com.example.test.ui.testui.w0
                            @Override // nd.b
                            public final void h(boolean z5) {
                                int i16 = i14;
                                TRingSportTypeNewActivity this$0 = tRingSportTypeNewActivity;
                                switch (i3) {
                                    case 0:
                                        int i17 = TRingSportTypeNewActivity.G;
                                        kotlin.jvm.internal.e.f(this$0, "this$0");
                                        if (!z5) {
                                            com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                                            break;
                                        } else {
                                            ((f1) this$0.I0()).k(1);
                                            Intent intent = new Intent(this$0, (Class<?>) SportCountDownNewActivity.class);
                                            intent.putExtra("sport_type", i16);
                                            intent.putExtra("sport_status", 1);
                                            this$0.startActivity(intent);
                                            break;
                                        }
                                    default:
                                        int i18 = TRingSportTypeNewActivity.G;
                                        kotlin.jvm.internal.e.f(this$0, "this$0");
                                        if (!z5) {
                                            com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                                            break;
                                        } else {
                                            ((f1) this$0.I0()).k(1);
                                            Intent intent2 = new Intent(this$0, (Class<?>) SportCountDownNewActivity.class);
                                            intent2.putExtra("sport_type", i16);
                                            intent2.putExtra("sport_status", 1);
                                            this$0.startActivity(intent2);
                                            break;
                                        }
                                }
                            }
                        });
                        break;
                    }
                }
                break;
        }
    }
}
