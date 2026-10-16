package com.google.android.material.slider;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.material.R$attr;

/* loaded from: classes.dex */
public class Slider extends BaseSlider<Slider, Object, Object> {
    public Slider(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public int getActiveThumbIndex() {
        return this.H;
    }

    public int getFocusedThumbIndex() {
        return this.I;
    }

    public int getHaloRadius() {
        return this.f10751z;
    }

    public ColorStateList getHaloTintList() {
        return this.P;
    }

    public int getLabelBehavior() {
        return this.f10746u;
    }

    public float getStepSize() {
        return this.J;
    }

    public float getThumbElevation() {
        return this.U.f12505a.f12499m;
    }

    public int getThumbRadius() {
        return this.f10750y;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.U.f12505a.f12491d;
    }

    public float getThumbStrokeWidth() {
        return this.U.f12505a.f12496j;
    }

    public ColorStateList getThumbTintList() {
        return this.U.f12505a.f12490c;
    }

    public ColorStateList getTickActiveTintList() {
        return this.Q;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.R;
    }

    public ColorStateList getTickTintList() {
        if (this.R.equals(this.Q)) {
            return this.Q;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.S;
    }

    public int getTrackHeight() {
        return this.f10747v;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.T;
    }

    public int getTrackSidePadding() {
        return this.f10748w;
    }

    public ColorStateList getTrackTintList() {
        if (this.T.equals(this.S)) {
            return this.S;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.M;
    }

    public float getValue() {
        return getValues().get(0).floatValue();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getValueFrom() {
        return this.E;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getValueTo() {
        return this.F;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public final boolean o() {
        if (getActiveThumbIndex() != -1) {
            return true;
        }
        setActiveThumbIndex(0);
        return true;
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z5) {
        super.setEnabled(z5);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i3) {
        super.setFocusedThumbIndex(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadius(int i3) {
        super.setHaloRadius(i3);
    }

    public void setHaloRadiusResource(int i3) {
        setHaloRadius(getResources().getDimensionPixelSize(i3));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloTintList(ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    public void setLabelBehavior(int i3) {
        if (this.f10746u != i3) {
            this.f10746u = i3;
            requestLayout();
        }
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(i iVar) {
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setStepSize(float f2) {
        super.setStepSize(f2);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevation(float f2) {
        super.setThumbElevation(f2);
    }

    public void setThumbElevationResource(int i3) {
        setThumbElevation(getResources().getDimension(i3));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadius(int i3) {
        super.setThumbRadius(i3);
    }

    public void setThumbRadiusResource(int i3) {
        setThumbRadius(getResources().getDimensionPixelSize(i3));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColor(ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    public void setThumbStrokeColorResource(int i3) {
        if (i3 != 0) {
            setThumbStrokeColor(pb.a(getContext(), i3));
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f2) {
        super.setThumbStrokeWidth(f2);
    }

    public void setThumbStrokeWidthResource(int i3) {
        if (i3 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i3));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        eb.h hVar = this.U;
        if (colorStateList.equals(hVar.f12505a.f12490c)) {
            return;
        }
        hVar.l(colorStateList);
        invalidate();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveTintList(ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveTintList(ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z5) {
        if (this.L != z5) {
            this.L = z5;
            postInvalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackActiveTintList(ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackHeight(int i3) {
        super.setTrackHeight(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValue(float f2) {
        setValues(Float.valueOf(f2));
    }

    public void setValueFrom(float f2) {
        this.E = f2;
        this.O = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.F = f2;
        this.O = true;
        postInvalidate();
    }

    public Slider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    public Slider(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.value});
        if (obtainStyledAttributes.hasValue(0)) {
            setValue(obtainStyledAttributes.getFloat(0, 0.0f));
        }
        obtainStyledAttributes.recycle();
    }
}
