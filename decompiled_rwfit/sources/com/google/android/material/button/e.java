package com.google.android.material.button;

import android.util.Rational;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class e implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10342a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10343b;

    public /* synthetic */ e(Object obj, int i3) {
        this.f10342a = i3;
        this.f10343b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f10342a) {
            case 0:
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int compareTo = Boolean.valueOf(materialButton.f10311n).compareTo(Boolean.valueOf(materialButton2.f10311n));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f10343b;
                return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
            default:
                Rational rational = (Rational) obj2;
                Rational rational2 = (Rational) this.f10343b;
                float floatValue = ((Rational) obj).floatValue();
                float floatValue2 = rational2.floatValue();
                float f2 = floatValue > floatValue2 ? floatValue2 / floatValue : floatValue / floatValue2;
                float floatValue3 = rational.floatValue();
                float floatValue4 = rational2.floatValue();
                return Float.compare(floatValue3 > floatValue4 ? floatValue4 / floatValue3 : floatValue3 / floatValue4, f2);
        }
    }
}
