package oa;

import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.sf;
import com.google.android.gms.internal.mlkit_vision_barcode.xb;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class a extends sf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f16906a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f16906a = bottomSheetBehavior;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int a(int i3, View view) {
        return view.getLeft();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int b(int i3, View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f16906a;
        return xb.a(i3, bottomSheetBehavior.y(), bottomSheetBehavior.C ? bottomSheetBehavior.M : bottomSheetBehavior.A);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int d() {
        BottomSheetBehavior bottomSheetBehavior = this.f16906a;
        return bottomSheetBehavior.C ? bottomSheetBehavior.M : bottomSheetBehavior.A;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void h(int i3) {
        if (i3 == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f16906a;
            if (bottomSheetBehavior.E) {
                bottomSheetBehavior.C(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void i(View view, int i3, int i10) {
        this.f16906a.v(i10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void j(View view, float f2, float f10) {
        int i3;
        int i10 = 6;
        BottomSheetBehavior bottomSheetBehavior = this.f16906a;
        if (f10 < 0.0f) {
            if (bottomSheetBehavior.f10273b) {
                i3 = bottomSheetBehavior.f10293x;
            } else {
                int top = view.getTop();
                int i11 = bottomSheetBehavior.f10294y;
                if (top > i11) {
                    i3 = i11;
                } else {
                    i3 = bottomSheetBehavior.y();
                }
            }
            i10 = 3;
        } else if (bottomSheetBehavior.C && bottomSheetBehavior.E(view, f10)) {
            if (Math.abs(f2) >= Math.abs(f10) || f10 <= 500.0f) {
                if (view.getTop() <= (bottomSheetBehavior.y() + bottomSheetBehavior.M) / 2) {
                    if (bottomSheetBehavior.f10273b) {
                        i3 = bottomSheetBehavior.f10293x;
                    } else if (Math.abs(view.getTop() - bottomSheetBehavior.y()) < Math.abs(view.getTop() - bottomSheetBehavior.f10294y)) {
                        i3 = bottomSheetBehavior.y();
                    } else {
                        i3 = bottomSheetBehavior.f10294y;
                    }
                    i10 = 3;
                }
            }
            i3 = bottomSheetBehavior.M;
            i10 = 5;
        } else if (f10 == 0.0f || Math.abs(f2) > Math.abs(f10)) {
            int top2 = view.getTop();
            if (!bottomSheetBehavior.f10273b) {
                int i12 = bottomSheetBehavior.f10294y;
                if (top2 < i12) {
                    if (top2 < Math.abs(top2 - bottomSheetBehavior.A)) {
                        i3 = bottomSheetBehavior.y();
                        i10 = 3;
                    } else {
                        i3 = bottomSheetBehavior.f10294y;
                    }
                } else if (Math.abs(top2 - i12) < Math.abs(top2 - bottomSheetBehavior.A)) {
                    i3 = bottomSheetBehavior.f10294y;
                } else {
                    i3 = bottomSheetBehavior.A;
                    i10 = 4;
                }
            } else if (Math.abs(top2 - bottomSheetBehavior.f10293x) < Math.abs(top2 - bottomSheetBehavior.A)) {
                i3 = bottomSheetBehavior.f10293x;
                i10 = 3;
            } else {
                i3 = bottomSheetBehavior.A;
                i10 = 4;
            }
        } else {
            if (bottomSheetBehavior.f10273b) {
                i3 = bottomSheetBehavior.A;
            } else {
                int top3 = view.getTop();
                if (Math.abs(top3 - bottomSheetBehavior.f10294y) < Math.abs(top3 - bottomSheetBehavior.A)) {
                    i3 = bottomSheetBehavior.f10294y;
                } else {
                    i3 = bottomSheetBehavior.A;
                }
            }
            i10 = 4;
        }
        bottomSheetBehavior.F(view, i10, i3, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final boolean k(int i3, View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f16906a;
        int i10 = bottomSheetBehavior.F;
        if (i10 == 1 || bottomSheetBehavior.T) {
            return false;
        }
        if (i10 == 3 && bottomSheetBehavior.R == i3) {
            WeakReference weakReference = bottomSheetBehavior.O;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        WeakReference weakReference2 = bottomSheetBehavior.N;
        return weakReference2 != null && weakReference2.get() == view;
    }
}
