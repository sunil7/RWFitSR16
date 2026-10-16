package com.google.android.material.slider;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.R$string;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends p1.b {

    /* renamed from: q, reason: collision with root package name */
    public final BaseSlider f10765q;
    public final Rect r;

    public g(BaseSlider baseSlider) {
        super(baseSlider);
        this.r = new Rect();
        this.f10765q = baseSlider;
    }

    @Override // p1.b
    public final int n(float f2, float f10) {
        int i3 = 0;
        while (true) {
            BaseSlider baseSlider = this.f10765q;
            if (i3 >= baseSlider.getValues().size()) {
                return -1;
            }
            Rect rect = this.r;
            baseSlider.t(i3, rect);
            if (rect.contains((int) f2, (int) f10)) {
                return i3;
            }
            i3++;
        }
    }

    @Override // p1.b
    public final void o(ArrayList arrayList) {
        for (int i3 = 0; i3 < this.f10765q.getValues().size(); i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
    }

    @Override // p1.b
    public final boolean s(int i3, int i10, Bundle bundle) {
        BaseSlider baseSlider = this.f10765q;
        if (!baseSlider.isEnabled()) {
            return false;
        }
        if (i10 != 4096 && i10 != 8192) {
            if (i10 != 16908349 || bundle == null || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                return false;
            }
            float f2 = bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
            int i11 = BaseSlider.f10727a0;
            if (!baseSlider.r(f2, i3)) {
                return false;
            }
            baseSlider.u();
            baseSlider.postInvalidate();
            p(i3);
            return true;
        }
        int i12 = BaseSlider.f10727a0;
        float f10 = baseSlider.J;
        if (f10 == 0.0f) {
            f10 = 1.0f;
        }
        if ((baseSlider.F - baseSlider.E) / f10 > 20) {
            f10 *= Math.round(r1 / r4);
        }
        if (i10 == 8192) {
            f10 = -f10;
        }
        if (baseSlider.i()) {
            f10 = -f10;
        }
        float floatValue = baseSlider.getValues().get(i3).floatValue() + f10;
        float valueFrom = baseSlider.getValueFrom();
        float valueTo = baseSlider.getValueTo();
        if (floatValue < valueFrom) {
            floatValue = valueFrom;
        } else if (floatValue > valueTo) {
            floatValue = valueTo;
        }
        if (!baseSlider.r(floatValue, i3)) {
            return false;
        }
        baseSlider.u();
        baseSlider.postInvalidate();
        p(i3);
        return true;
    }

    @Override // p1.b
    public final void u(int i3, m1.d dVar) {
        dVar.b(m1.c.f15933o);
        BaseSlider baseSlider = this.f10765q;
        List<Float> values = baseSlider.getValues();
        float floatValue = values.get(i3).floatValue();
        float valueFrom = baseSlider.getValueFrom();
        float valueTo = baseSlider.getValueTo();
        if (baseSlider.isEnabled()) {
            if (floatValue > valueFrom) {
                dVar.a(8192);
            }
            if (floatValue < valueTo) {
                dVar.a(4096);
            }
        }
        AccessibilityNodeInfo.RangeInfo obtain = AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, floatValue);
        AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
        accessibilityNodeInfo.setRangeInfo(obtain);
        dVar.f(SeekBar.class.getName());
        StringBuilder sb2 = new StringBuilder();
        if (baseSlider.getContentDescription() != null) {
            sb2.append(baseSlider.getContentDescription());
            sb2.append(Const.STR_MART_COMMA);
        }
        if (values.size() > 1) {
            sb2.append(i3 == baseSlider.getValues().size() - 1 ? baseSlider.getContext().getString(R$string.material_slider_range_end) : i3 == 0 ? baseSlider.getContext().getString(R$string.material_slider_range_start) : "");
            sb2.append(baseSlider.e(floatValue));
        }
        accessibilityNodeInfo.setContentDescription(sb2.toString());
        Rect rect = this.r;
        baseSlider.t(i3, rect);
        accessibilityNodeInfo.setBoundsInParent(rect);
    }
}
