package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
        actionMenuPresenter$SavedState.openSubMenuId = parcel.readInt();
        return actionMenuPresenter$SavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new ActionMenuPresenter$SavedState[i3];
    }
}
