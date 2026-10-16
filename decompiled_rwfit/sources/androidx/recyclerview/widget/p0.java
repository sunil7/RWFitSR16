package androidx.recyclerview.widget;

import android.view.View;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import java.util.List;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2694a;

    /* renamed from: b, reason: collision with root package name */
    public int f2695b;

    /* renamed from: c, reason: collision with root package name */
    public int f2696c;

    /* renamed from: d, reason: collision with root package name */
    public int f2697d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f2698f;

    /* renamed from: g, reason: collision with root package name */
    public int f2699g;

    /* renamed from: h, reason: collision with root package name */
    public int f2700h;

    /* renamed from: i, reason: collision with root package name */
    public int f2701i;

    /* renamed from: j, reason: collision with root package name */
    public int f2702j;

    /* renamed from: k, reason: collision with root package name */
    public List f2703k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2704l;

    public final void a(View view) {
        int layoutPosition;
        int size = this.f2703k.size();
        View view2 = null;
        int i3 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        for (int i10 = 0; i10 < size; i10++) {
            View view3 = ((z1) this.f2703k.get(i10)).itemView;
            j1 j1Var = (j1) view3.getLayoutParams();
            if (view3 != view && !j1Var.f2633a.isRemoved() && (layoutPosition = (j1Var.f2633a.getLayoutPosition() - this.f2697d) * this.e) >= 0 && layoutPosition < i3) {
                view2 = view3;
                if (layoutPosition == 0) {
                    break;
                } else {
                    i3 = layoutPosition;
                }
            }
        }
        if (view2 == null) {
            this.f2697d = -1;
        } else {
            this.f2697d = ((j1) view2.getLayoutParams()).f2633a.getLayoutPosition();
        }
    }

    public final View b(q1 q1Var) {
        List list = this.f2703k;
        if (list == null) {
            View view = q1Var.i(this.f2697d, Format.OFFSET_SAMPLE_RELATIVE).itemView;
            this.f2697d += this.e;
            return view;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = ((z1) this.f2703k.get(i3)).itemView;
            j1 j1Var = (j1) view2.getLayoutParams();
            if (!j1Var.f2633a.isRemoved() && this.f2697d == j1Var.f2633a.getLayoutPosition()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
