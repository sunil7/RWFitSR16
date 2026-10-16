package oe;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.j1;
import androidx.recyclerview.widget.w1;
import androidx.recyclerview.widget.z1;
import com.example.test.ui.device.activity.ScheduleActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.ef;
import com.littlejerk.rvdivider.DividerHelper$DividerType;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class b extends g1 {

    /* renamed from: a, reason: collision with root package name */
    public he.b f16922a;

    @Override // androidx.recyclerview.widget.g1
    public final void e(Rect rect, View view, RecyclerView recyclerView, w1 w1Var) {
        DividerHelper$DividerType a3 = ef.a(recyclerView);
        switch (a.f16921a[a3.ordinal()]) {
            case 1:
            case 2:
                he.b bVar = this.f16922a;
                Objects.requireNonNull(recyclerView.getAdapter(), "RecyclerView请设置Adapter");
                int itemCount = recyclerView.getAdapter().getItemCount();
                z1 L = RecyclerView.L(view);
                int absoluteAdapterPosition = L != null ? L.getAbsoluteAdapterPosition() : -1;
                if (((b9.a) bVar.f14317d) != null) {
                    int i3 = ScheduleActivity.I;
                }
                if (((b9.a) bVar.e) != null) {
                    int i10 = ScheduleActivity.I;
                }
                int i11 = bVar.f14314a;
                if (a3 == DividerHelper$DividerType.LINEAR_VERTICAL) {
                    if (absoluteAdapterPosition == itemCount - 1) {
                        i11 = 0;
                    }
                    if (absoluteAdapterPosition < itemCount) {
                        rect.set(0, 0, 0, i11);
                        return;
                    }
                    return;
                }
                if (absoluteAdapterPosition == itemCount - 1) {
                    i11 = 0;
                }
                if (absoluteAdapterPosition < itemCount) {
                    rect.set(0, 0, i11, 0);
                    return;
                }
                return;
            case 3:
            case 4:
                throw new ClassCastException();
            case 5:
            case 6:
                throw new ClassCastException();
            default:
                super.e(rect, view, recyclerView, w1Var);
                return;
        }
    }

    @Override // androidx.recyclerview.widget.g1
    public final void f(Canvas canvas, RecyclerView recyclerView) {
        int i3 = a.f16921a[ef.a(recyclerView).ordinal()];
        int i10 = 0;
        if (i3 == 1) {
            he.b bVar = this.f16922a;
            canvas.save();
            Objects.requireNonNull(recyclerView.getAdapter(), "RecyclerView请设置Adapter");
            int itemCount = recyclerView.getAdapter().getItemCount() - 1;
            int paddingTop = recyclerView.getPaddingTop();
            int paddingBottom = recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            while (i10 < childCount) {
                View childAt = recyclerView.getChildAt(i10);
                j1 j1Var = (j1) childAt.getLayoutParams();
                j1Var.f2633a.getLayoutPosition();
                if (((b9.a) bVar.e) != null) {
                    int i11 = ScheduleActivity.I;
                }
                if (((ColorDrawable) bVar.f14316c) == null) {
                    bVar.f14316c = new ColorDrawable(bVar.f14315b);
                }
                ColorDrawable colorDrawable = (ColorDrawable) bVar.f14316c;
                int height = recyclerView.getHeight() - paddingBottom;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) j1Var).rightMargin;
                int i12 = bVar.f14314a + right;
                if (i10 < itemCount) {
                    colorDrawable.setBounds(right, paddingTop, i12, height);
                    colorDrawable.draw(canvas);
                } else {
                    colorDrawable.setBounds(right, paddingTop, right, height);
                }
                i10++;
            }
            canvas.restore();
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                throw new ClassCastException();
            }
            if (i3 == 4) {
                throw new ClassCastException();
            }
            return;
        }
        he.b bVar2 = this.f16922a;
        canvas.save();
        Objects.requireNonNull(recyclerView.getAdapter(), "RecyclerView请设置Adapter");
        int itemCount2 = recyclerView.getAdapter().getItemCount() - 1;
        int paddingLeft = recyclerView.getPaddingLeft();
        int paddingRight = recyclerView.getPaddingRight();
        int childCount2 = recyclerView.getChildCount();
        while (i10 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i10);
            j1 j1Var2 = (j1) childAt2.getLayoutParams();
            j1Var2.f2633a.getLayoutPosition();
            if (((b9.a) bVar2.e) != null) {
                int i13 = ScheduleActivity.I;
            }
            if (((ColorDrawable) bVar2.f14316c) == null) {
                bVar2.f14316c = new ColorDrawable(bVar2.f14315b);
            }
            ColorDrawable colorDrawable2 = (ColorDrawable) bVar2.f14316c;
            int width = recyclerView.getWidth() - paddingRight;
            int bottom = childAt2.getBottom() + ((ViewGroup.MarginLayoutParams) j1Var2).bottomMargin;
            int i14 = bVar2.f14314a + bottom;
            if (i10 < itemCount2) {
                colorDrawable2.setBounds(paddingLeft, bottom, width, i14);
            } else {
                colorDrawable2.setBounds(paddingLeft, bottom, width, bottom);
            }
            colorDrawable2.draw(canvas);
            i10++;
        }
        canvas.restore();
    }
}
