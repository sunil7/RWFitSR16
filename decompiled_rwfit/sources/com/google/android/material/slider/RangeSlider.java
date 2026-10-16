package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.w;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RangeSlider extends BaseSlider<RangeSlider, Object, Object> {

    /* renamed from: b0, reason: collision with root package name */
    public float f10756b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f10757c0;

    public static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator<RangeSliderState> CREATOR = new j();
        private float minSeparation;
        private int separationUnit;

        public RangeSliderState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeFloat(this.minSeparation);
            parcel.writeInt(this.separationUnit);
        }

        public RangeSliderState(Parcel parcel) {
            super(parcel.readParcelable(RangeSliderState.class.getClassLoader()));
            this.minSeparation = parcel.readFloat();
            this.separationUnit = parcel.readInt();
        }
    }

    public RangeSlider(Context context) {
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

    @Override // com.google.android.material.slider.BaseSlider
    public float getMinSeparation() {
        return this.f10756b0;
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

    @Override // com.google.android.material.slider.BaseSlider
    public float getValueFrom() {
        return this.E;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getValueTo() {
        return this.F;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public List<Float> getValues() {
        return super.getValues();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        RangeSliderState rangeSliderState = (RangeSliderState) parcelable;
        super.onRestoreInstanceState(rangeSliderState.getSuperState());
        this.f10756b0 = rangeSliderState.minSeparation;
        int i3 = rangeSliderState.separationUnit;
        this.f10757c0 = i3;
        setSeparationUnit(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public final Parcelable onSaveInstanceState() {
        RangeSliderState rangeSliderState = new RangeSliderState(super.onSaveInstanceState());
        rangeSliderState.minSeparation = this.f10756b0;
        rangeSliderState.separationUnit = this.f10757c0;
        return rangeSliderState;
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

    public void setMinSeparation(float f2) {
        this.f10756b0 = f2;
        this.f10757c0 = 0;
        setSeparationUnit(0);
    }

    public void setMinSeparationValue(float f2) {
        this.f10756b0 = f2;
        this.f10757c0 = 1;
        setSeparationUnit(1);
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

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(Float... fArr) {
        super.setValues(fArr);
    }

    public RangeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(List<Float> list) {
        super.setValues(list);
    }

    public RangeSlider(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray d5 = w.d(context, attributeSet, R$styleable.RangeSlider, i3, BaseSlider.f10727a0, new int[0]);
        if (d5.hasValue(R$styleable.RangeSlider_values)) {
            TypedArray obtainTypedArray = d5.getResources().obtainTypedArray(d5.getResourceId(R$styleable.RangeSlider_values, 0));
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < obtainTypedArray.length(); i10++) {
                arrayList.add(Float.valueOf(obtainTypedArray.getFloat(i10, -1.0f)));
            }
            setValues(arrayList);
        }
        this.f10756b0 = d5.getDimension(R$styleable.RangeSlider_minSeparation, 0.0f);
        d5.recycle();
    }
}
