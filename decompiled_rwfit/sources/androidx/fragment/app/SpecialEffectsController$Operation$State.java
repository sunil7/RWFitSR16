package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class SpecialEffectsController$Operation$State {
    public static final SpecialEffectsController$Operation$State GONE;
    public static final SpecialEffectsController$Operation$State INVISIBLE;
    public static final SpecialEffectsController$Operation$State REMOVED;
    public static final SpecialEffectsController$Operation$State VISIBLE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpecialEffectsController$Operation$State[] f2125a;

    static {
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State = new SpecialEffectsController$Operation$State("REMOVED", 0);
        REMOVED = specialEffectsController$Operation$State;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = new SpecialEffectsController$Operation$State("VISIBLE", 1);
        VISIBLE = specialEffectsController$Operation$State2;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State3 = new SpecialEffectsController$Operation$State("GONE", 2);
        GONE = specialEffectsController$Operation$State3;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State4 = new SpecialEffectsController$Operation$State("INVISIBLE", 3);
        INVISIBLE = specialEffectsController$Operation$State4;
        f2125a = new SpecialEffectsController$Operation$State[]{specialEffectsController$Operation$State, specialEffectsController$Operation$State2, specialEffectsController$Operation$State3, specialEffectsController$Operation$State4};
    }

    public static SpecialEffectsController$Operation$State from(View view) {
        return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
    }

    public static SpecialEffectsController$Operation$State valueOf(String str) {
        return (SpecialEffectsController$Operation$State) Enum.valueOf(SpecialEffectsController$Operation$State.class, str);
    }

    public static SpecialEffectsController$Operation$State[] values() {
        return (SpecialEffectsController$Operation$State[]) f2125a.clone();
    }

    public void applyState(View view) {
        int i3 = o1.f2234a[ordinal()];
        if (i3 == 1) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (t0.B(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (i3 == 2) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (i3 == 3) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (i3 != 4) {
            return;
        }
        if (t0.B(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static SpecialEffectsController$Operation$State from(int i3) {
        if (i3 == 0) {
            return VISIBLE;
        }
        if (i3 == 4) {
            return INVISIBLE;
        }
        if (i3 == 8) {
            return GONE;
        }
        throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "Unknown visibility "));
    }
}
