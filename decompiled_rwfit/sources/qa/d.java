package qa;

import android.widget.CompoundButton;
import com.google.android.material.chip.ChipGroup;

/* loaded from: classes.dex */
public final class d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChipGroup f17889a;

    public d(ChipGroup chipGroup) {
        this.f17889a = chipGroup;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
        ChipGroup chipGroup = this.f17889a;
        if (chipGroup.f10386l) {
            return;
        }
        if (chipGroup.getCheckedChipIds().isEmpty() && chipGroup.f10382h) {
            chipGroup.d(compoundButton.getId(), true);
            chipGroup.f10385k = compoundButton.getId();
            return;
        }
        int id2 = compoundButton.getId();
        if (!z5) {
            if (chipGroup.f10385k == id2) {
                chipGroup.setCheckedId(-1);
            }
        } else {
            int i3 = chipGroup.f10385k;
            if (i3 != -1 && i3 != id2 && chipGroup.f10381g) {
                chipGroup.d(i3, false);
            }
            chipGroup.setCheckedId(id2);
        }
    }
}
