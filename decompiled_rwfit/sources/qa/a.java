package qa;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.R$string;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a extends p1.b {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Chip f17860q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Chip chip, Chip chip2) {
        super(chip2);
        this.f17860q = chip;
    }

    @Override // p1.b
    public final int n(float f2, float f10) {
        RectF closeIconTouchBounds;
        int i3 = Chip.f10361u;
        Chip chip = this.f17860q;
        if (!chip.d()) {
            return 0;
        }
        closeIconTouchBounds = chip.getCloseIconTouchBounds();
        return closeIconTouchBounds.contains(f2, f10) ? 1 : 0;
    }

    @Override // p1.b
    public final void o(ArrayList arrayList) {
        c cVar;
        arrayList.add(0);
        int i3 = Chip.f10361u;
        Chip chip = this.f17860q;
        if (!chip.d() || (cVar = chip.e) == null || !cVar.K || chip.f10367h == null) {
            return;
        }
        arrayList.add(1);
    }

    @Override // p1.b
    public final boolean s(int i3, int i10, Bundle bundle) {
        boolean z5 = false;
        if (i10 == 16) {
            Chip chip = this.f17860q;
            if (i3 == 0) {
                return chip.performClick();
            }
            if (i3 == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.f10367h;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z5 = true;
                }
                chip.f10376q.x(1, 1);
            }
        }
        return z5;
    }

    @Override // p1.b
    public final void t(m1.d dVar) {
        Chip chip = this.f17860q;
        boolean e = chip.e();
        AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
        accessibilityNodeInfo.setCheckable(e);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        if (chip.e() || chip.isClickable()) {
            dVar.f(chip.e() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            dVar.f("android.view.View");
        }
        accessibilityNodeInfo.setText(chip.getText());
    }

    @Override // p1.b
    public final void u(int i3, m1.d dVar) {
        Rect closeIconTouchBoundsInt;
        AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
        if (i3 != 1) {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.f10362v);
            return;
        }
        Chip chip = this.f17860q;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfo.setContentDescription(chip.getContext().getString(R$string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        closeIconTouchBoundsInt = chip.getCloseIconTouchBoundsInt();
        accessibilityNodeInfo.setBoundsInParent(closeIconTouchBoundsInt);
        dVar.b(m1.c.f15925g);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
    }

    @Override // p1.b
    public final void v(int i3, boolean z5) {
        if (i3 == 1) {
            Chip chip = this.f17860q;
            chip.f10372m = z5;
            chip.refreshDrawableState();
        }
    }
}
