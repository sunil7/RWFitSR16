package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public final class n implements Parcelable.ClassLoaderCreator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ViewPager2.SavedState savedState = new ViewPager2.SavedState(parcel, null);
        savedState.f2965a = parcel.readInt();
        savedState.f2966b = parcel.readInt();
        savedState.f2967c = parcel.readParcelable(null);
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new ViewPager2.SavedState[i3];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        ViewPager2.SavedState savedState = new ViewPager2.SavedState(parcel, classLoader);
        savedState.f2965a = parcel.readInt();
        savedState.f2966b = parcel.readInt();
        savedState.f2967c = parcel.readParcelable(classLoader);
        return savedState;
    }
}
