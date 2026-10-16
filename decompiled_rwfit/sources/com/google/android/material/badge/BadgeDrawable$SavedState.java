package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import ha.d;

/* loaded from: classes.dex */
public final class BadgeDrawable$SavedState implements Parcelable {
    public static final Parcelable.Creator<BadgeDrawable$SavedState> CREATOR = new d(5);
    private int additionalHorizontalOffset;
    private int additionalVerticalOffset;
    private int alpha;
    private int backgroundColor;
    private int badgeGravity;
    private int badgeTextColor;
    private int contentDescriptionExceedsMaxBadgeNumberRes;
    private CharSequence contentDescriptionNumberless;
    private int contentDescriptionQuantityStrings;
    private int horizontalOffset;
    private boolean isVisible;
    private int maxCharacterCount;
    private int number;
    private int verticalOffset;

    public BadgeDrawable$SavedState(Context context) {
        this.alpha = 255;
        this.number = -1;
        int i3 = R$style.TextAppearance_MaterialComponents_Badge;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, R$styleable.TextAppearance);
        obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        ColorStateList a3 = t0.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        t0.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        t0.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i10 = R$styleable.TextAppearance_fontFamily;
        i10 = obtainStyledAttributes.hasValue(i10) ? i10 : R$styleable.TextAppearance_android_fontFamily;
        obtainStyledAttributes.getResourceId(i10, 0);
        obtainStyledAttributes.getString(i10);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        t0.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i3, R$styleable.MaterialTextAppearance);
        obtainStyledAttributes2.hasValue(R$styleable.MaterialTextAppearance_android_letterSpacing);
        obtainStyledAttributes2.getFloat(R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        obtainStyledAttributes2.recycle();
        this.badgeTextColor = a3.getDefaultColor();
        this.contentDescriptionNumberless = context.getString(R$string.mtrl_badge_numberless_content_description);
        this.contentDescriptionQuantityStrings = R$plurals.mtrl_badge_content_description;
        this.contentDescriptionExceedsMaxBadgeNumberRes = R$string.mtrl_exceed_max_badge_number_content_description;
        this.isVisible = true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.backgroundColor);
        parcel.writeInt(this.badgeTextColor);
        parcel.writeInt(this.alpha);
        parcel.writeInt(this.number);
        parcel.writeInt(this.maxCharacterCount);
        parcel.writeString(this.contentDescriptionNumberless.toString());
        parcel.writeInt(this.contentDescriptionQuantityStrings);
        parcel.writeInt(this.badgeGravity);
        parcel.writeInt(this.horizontalOffset);
        parcel.writeInt(this.verticalOffset);
        parcel.writeInt(this.additionalHorizontalOffset);
        parcel.writeInt(this.additionalVerticalOffset);
        parcel.writeInt(this.isVisible ? 1 : 0);
    }

    public BadgeDrawable$SavedState(Parcel parcel) {
        this.alpha = 255;
        this.number = -1;
        this.backgroundColor = parcel.readInt();
        this.badgeTextColor = parcel.readInt();
        this.alpha = parcel.readInt();
        this.number = parcel.readInt();
        this.maxCharacterCount = parcel.readInt();
        this.contentDescriptionNumberless = parcel.readString();
        this.contentDescriptionQuantityStrings = parcel.readInt();
        this.badgeGravity = parcel.readInt();
        this.horizontalOffset = parcel.readInt();
        this.verticalOffset = parcel.readInt();
        this.additionalHorizontalOffset = parcel.readInt();
        this.additionalVerticalOffset = parcel.readInt();
        this.isVisible = parcel.readInt() != 0;
    }
}
