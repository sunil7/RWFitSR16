package j2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.transition.R$id;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f15306c = 0;

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f15307a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15308b;

    public static void a(View view, ArrayList arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        if (!this.f15308b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            int i3 = R$id.ghost_view_holder;
            ViewGroup viewGroup = this.f15307a;
            viewGroup.setTag(i3, null);
            viewGroup.getOverlay().remove(this);
            this.f15308b = false;
        }
    }
}
