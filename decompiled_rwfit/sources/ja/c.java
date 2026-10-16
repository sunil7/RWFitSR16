package ja;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R$id;

/* loaded from: classes.dex */
public final class c extends Property {

    /* renamed from: a, reason: collision with root package name */
    public static final c f15388a = new c(Float.class, "childrenAlpha");

    @Override // android.util.Property
    public final Object get(Object obj) {
        Float f2 = (Float) ((ViewGroup) obj).getTag(R$id.mtrl_internal_children_alpha_tag);
        return f2 != null ? f2 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        Float f2 = (Float) obj2;
        float floatValue = f2.floatValue();
        viewGroup.setTag(R$id.mtrl_internal_children_alpha_tag, f2);
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            viewGroup.getChildAt(i3).setAlpha(floatValue);
        }
    }
}
