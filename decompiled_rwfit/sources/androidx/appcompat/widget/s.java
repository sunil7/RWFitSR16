package androidx.appcompat.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class s implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1039a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1040b;

    public /* synthetic */ s(Object obj, int i3) {
        this.f1039a = i3;
        this.f1040b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        l lVar;
        h.w wVar;
        Activity activity;
        int i3 = 0;
        Object obj = this.f1040b;
        switch (this.f1039a) {
            case 0:
                ActivityChooserView activityChooserView = (ActivityChooserView) obj;
                if (activityChooserView.b()) {
                    if (!activityChooserView.isShown()) {
                        activityChooserView.getListPopupWindow().dismiss();
                        break;
                    } else {
                        activityChooserView.getListPopupWindow().d();
                        l1.d dVar = activityChooserView.f672g;
                        if (dVar != null && (lVar = dVar.f15684a) != null && (wVar = lVar.e) != null) {
                            wVar.c(lVar.f955c);
                            break;
                        }
                    }
                }
                break;
            case 1:
                AppCompatSpinner appCompatSpinner = (AppCompatSpinner) obj;
                if (!appCompatSpinner.getInternalPopup().a()) {
                    appCompatSpinner.f719f.k(i0.b(appCompatSpinner), i0.a(appCompatSpinner));
                }
                ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    h0.a(viewTreeObserver, this);
                    break;
                }
                break;
            case 2:
                o0 o0Var = (o0) obj;
                AppCompatSpinner appCompatSpinner2 = o0Var.G;
                o0Var.getClass();
                WeakHashMap weakHashMap = l1.z0.f15748a;
                if (!l1.k0.b(appCompatSpinner2) || !appCompatSpinner2.getGlobalVisibleRect(o0Var.E)) {
                    o0Var.dismiss();
                    break;
                } else {
                    o0Var.s();
                    o0Var.d();
                    break;
                }
            case 3:
                NavigationView navigationView = (NavigationView) obj;
                int[] iArr = navigationView.f10695j;
                navigationView.getLocationOnScreen(iArr);
                boolean z5 = iArr[1] == 0;
                com.google.android.material.internal.n nVar = navigationView.f10692g;
                if (nVar.f10614p != z5) {
                    nVar.f10614p = z5;
                    int i10 = (nVar.f10601b.getChildCount() == 0 && nVar.f10614p) ? nVar.r : 0;
                    NavigationMenuView navigationMenuView = nVar.f10600a;
                    navigationMenuView.setPadding(0, i10, 0, navigationMenuView.getPaddingBottom());
                }
                navigationView.setDrawTopInsetForeground(z5);
                Context context = navigationView.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity != null) {
                    navigationView.setDrawBottomInsetForeground((activity.findViewById(R.id.content).getHeight() == navigationView.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
                    break;
                }
                break;
            case 4:
                h.e eVar = (h.e) obj;
                if (eVar.a()) {
                    ArrayList arrayList = eVar.f14112h;
                    if (arrayList.size() > 0 && !((h.d) arrayList.get(0)).f14103a.f778y) {
                        View view = eVar.f14119o;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i3 < size) {
                                Object obj2 = arrayList.get(i3);
                                i3++;
                                ((h.d) obj2).f14103a.d();
                            }
                            break;
                        } else {
                            eVar.dismiss();
                            break;
                        }
                    }
                }
                break;
            default:
                h.c0 c0Var = (h.c0) obj;
                if (c0Var.a()) {
                    k2 k2Var = c0Var.f14091h;
                    if (!k2Var.f778y) {
                        View view2 = c0Var.f14096m;
                        if (view2 != null && view2.isShown()) {
                            k2Var.d();
                            break;
                        } else {
                            c0Var.dismiss();
                            break;
                        }
                    }
                }
                break;
        }
    }
}
