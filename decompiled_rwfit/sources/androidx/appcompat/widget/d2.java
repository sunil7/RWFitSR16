package androidx.appcompat.widget;

import android.database.DataSetObserver;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class d2 extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f885a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f886b;

    public /* synthetic */ d2(Object obj, int i3) {
        this.f885a = i3;
        this.f886b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f885a) {
            case 0:
                ListPopupWindow listPopupWindow = (ListPopupWindow) this.f886b;
                if (listPopupWindow.f779z.isShowing()) {
                    listPopupWindow.d();
                    break;
                }
                break;
            case 1:
                ((TabLayout) this.f886b).i();
                break;
            case 2:
                ((ViewPager) this.f886b).e();
                break;
            default:
                i3 i3Var = (i3) this.f886b;
                i3Var.f16682a = true;
                i3Var.notifyDataSetChanged();
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f885a) {
            case 0:
                ((ListPopupWindow) this.f886b).dismiss();
                break;
            case 1:
                ((TabLayout) this.f886b).i();
                break;
            case 2:
                ((ViewPager) this.f886b).e();
                break;
            default:
                i3 i3Var = (i3) this.f886b;
                i3Var.f16682a = false;
                i3Var.notifyDataSetInvalidated();
                break;
        }
    }
}
