package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes.dex */
public final class h2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        StaggeredGridLayoutManager.SavedState savedState = new StaggeredGridLayoutManager.SavedState();
        savedState.f2500a = parcel.readInt();
        savedState.f2501b = parcel.readInt();
        int readInt = parcel.readInt();
        savedState.f2502c = readInt;
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            savedState.f2503d = iArr;
            parcel.readIntArray(iArr);
        }
        int readInt2 = parcel.readInt();
        savedState.e = readInt2;
        if (readInt2 > 0) {
            int[] iArr2 = new int[readInt2];
            savedState.f2504f = iArr2;
            parcel.readIntArray(iArr2);
        }
        savedState.f2506h = parcel.readInt() == 1;
        savedState.f2507i = parcel.readInt() == 1;
        savedState.f2508j = parcel.readInt() == 1;
        savedState.f2505g = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new StaggeredGridLayoutManager.SavedState[i3];
    }
}
