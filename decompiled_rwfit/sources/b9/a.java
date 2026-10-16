package b9;

import android.view.View;
import c1.c;
import com.example.baselibrary.base.activity.BaseActivity;
import com.example.test.XXApplication;
import com.example.test.ui.device.activity.ScanQrFamilyActivity;
import com.example.test.ui.device.activity.ScanQrMlActivity;
import com.example.test.ui.dialog.p;
import com.example.test.ui.testui.TMainBottomSleepTabView;
import com.example.test.ui.testui.TMainBottomTabView;
import com.example.test.ui.view.MainBottomTabView;
import com.example.test.utils.z0;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import de.l;
import kotlin.jvm.internal.e;
import l1.w;
import l1.x1;
import rd.d;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements w, nd.b, com.google.android.exoplayer2.a, l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3179a;

    public /* synthetic */ a(int i3) {
        this.f3179a = i3;
    }

    private final void b() {
    }

    @Override // l1.w
    public x1 P(View view, x1 x1Var) {
        switch (this.f3179a) {
            case 1:
                int i3 = BaseActivity.A;
                c f2 = x1Var.f15738a.f(7);
                e.e(f2, "getInsets(...)");
                view.setPadding(f2.f3354a, f2.f3355b, f2.f3356c, f2.f3357d);
                break;
            case 2:
                c f10 = x1Var.f15738a.f(7);
                e.e(f10, "getInsets(...)");
                view.setPadding(0, f10.f3355b, 0, 0);
                break;
            case 6:
                int i10 = ScanQrFamilyActivity.C;
                e.f(view, "view");
                c f11 = x1Var.f15738a.f(7);
                e.e(f11, "getInsets(...)");
                view.setPadding(0, f11.f3355b, 0, f11.f3357d);
                break;
            case 7:
                int i11 = ScanQrMlActivity.E;
                e.f(view, "view");
                c f12 = x1Var.f15738a.f(7);
                e.e(f12, "getInsets(...)");
                view.setPadding(0, f12.f3355b, 0, f12.f3357d);
                break;
            case 16:
                int i12 = TMainBottomSleepTabView.f8193f;
                e.f(view, "view");
                c f13 = x1Var.f15738a.f(7);
                e.e(f13, "getInsets(...)");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), f13.f3357d);
                break;
            case 17:
                int i13 = TMainBottomTabView.f8198g;
                e.f(view, "view");
                c f14 = x1Var.f15738a.f(7);
                e.e(f14, "getInsets(...)");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), f14.f3357d);
                break;
            default:
                int i14 = MainBottomTabView.f8484f;
                e.f(view, "view");
                c f15 = x1Var.f15738a.f(7);
                e.e(f15, "getInsets(...)");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), f15.f3357d);
                break;
        }
        return x1Var;
    }

    public void a() {
        switch (this.f3179a) {
            case 3:
                break;
            case 11:
                int i3 = com.example.test.ui.dialog.l.e;
                break;
            default:
                int i10 = p.e;
                break;
        }
    }

    @Override // nd.b
    public void h(boolean z5) {
        switch (this.f3179a) {
            case 4:
                if (z5) {
                    XXApplication xXApplication = XXApplication.f7400h;
                    com.example.baselibrary.utils.b.s(j1.a());
                    break;
                }
                break;
            case 5:
                if (z5) {
                    XXApplication xXApplication2 = XXApplication.f7400h;
                    com.example.baselibrary.utils.b.s(j1.a());
                    break;
                }
                break;
            case 8:
                if (z5) {
                    XXApplication xXApplication3 = XXApplication.f7400h;
                    com.example.baselibrary.utils.b.s(j1.a());
                    break;
                }
                break;
            case 13:
                if (z5) {
                    z0.d().f(true);
                    break;
                }
                break;
            case 14:
                if (z5) {
                    XXApplication xXApplication4 = XXApplication.f7400h;
                    com.example.baselibrary.utils.b.s(j1.a());
                    break;
                }
                break;
            case 15:
                if (z5) {
                    XXApplication xXApplication5 = XXApplication.f7400h;
                    com.example.baselibrary.utils.b.s(j1.a());
                    break;
                }
                break;
            case 18:
                if (z5) {
                    z0.d().f(true);
                    break;
                }
                break;
            case 19:
                if (z5) {
                    XXApplication xXApplication6 = XXApplication.f7400h;
                    com.example.baselibrary.utils.b.s(j1.a());
                    break;
                }
                break;
            default:
                if (z5) {
                    XXApplication xXApplication7 = XXApplication.f7400h;
                    com.example.baselibrary.utils.b.s(j1.a());
                    break;
                }
                break;
        }
    }

    @Override // de.l
    public void k(Object obj) {
        d dVar = (d) obj;
        switch (this.f3179a) {
            case 25:
                dVar.h();
                break;
            case 26:
                dVar.d();
                break;
            default:
                dVar.s();
                break;
        }
    }

    public /* synthetic */ a(Object obj, int i3) {
        this.f3179a = i3;
    }
}
