package qa;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class g implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f17890a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChipGroup f17891b;

    public g(ChipGroup chipGroup) {
        this.f17891b = chipGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.f17891b;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                WeakHashMap weakHashMap = z0.f15748a;
                view2.setId(i0.a());
            }
            Chip chip = (Chip) view2;
            if (chip.isChecked()) {
                ((ChipGroup) view).c(chip.getId());
            }
            chip.setOnCheckedChangeListenerInternal(chipGroup.f10383i);
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f17890a;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        if (view == this.f17891b && (view2 instanceof Chip)) {
            ((Chip) view2).setOnCheckedChangeListenerInternal(null);
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f17890a;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
