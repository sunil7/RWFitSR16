package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class AppCompatDelegateImpl$PanelFeatureState$SavedState implements Parcelable {
    public static final Parcelable.Creator<AppCompatDelegateImpl$PanelFeatureState$SavedState> CREATOR = new a0();

    /* renamed from: a, reason: collision with root package name */
    public int f400a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f401b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f402c;

    public static AppCompatDelegateImpl$PanelFeatureState$SavedState a(Parcel parcel, ClassLoader classLoader) {
        AppCompatDelegateImpl$PanelFeatureState$SavedState appCompatDelegateImpl$PanelFeatureState$SavedState = new AppCompatDelegateImpl$PanelFeatureState$SavedState();
        appCompatDelegateImpl$PanelFeatureState$SavedState.f400a = parcel.readInt();
        boolean z5 = parcel.readInt() == 1;
        appCompatDelegateImpl$PanelFeatureState$SavedState.f401b = z5;
        if (z5) {
            appCompatDelegateImpl$PanelFeatureState$SavedState.f402c = parcel.readBundle(classLoader);
        }
        return appCompatDelegateImpl$PanelFeatureState$SavedState;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f400a);
        parcel.writeInt(this.f401b ? 1 : 0);
        if (this.f401b) {
            parcel.writeBundle(this.f402c);
        }
    }
}
