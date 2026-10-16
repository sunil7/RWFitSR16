package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2147a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2147a) {
            case 0:
                return new BackStackState(parcel);
            case 1:
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = new FragmentManager$LaunchedFragmentInfo();
                fragmentManager$LaunchedFragmentInfo.f2099a = parcel.readString();
                fragmentManager$LaunchedFragmentInfo.f2100b = parcel.readInt();
                return fragmentManager$LaunchedFragmentInfo;
            case 2:
                FragmentManagerState fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.e = null;
                fragmentManagerState.f2105f = new ArrayList();
                fragmentManagerState.f2106g = new ArrayList();
                fragmentManagerState.f2101a = parcel.createTypedArrayList(FragmentState.CREATOR);
                fragmentManagerState.f2102b = parcel.createStringArrayList();
                fragmentManagerState.f2103c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
                fragmentManagerState.f2104d = parcel.readInt();
                fragmentManagerState.e = parcel.readString();
                fragmentManagerState.f2105f = parcel.createStringArrayList();
                fragmentManagerState.f2106g = parcel.createTypedArrayList(Bundle.CREATOR);
                fragmentManagerState.f2107h = parcel.createTypedArrayList(FragmentManager$LaunchedFragmentInfo.CREATOR);
                return fragmentManagerState;
            default:
                return new FragmentState(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f2147a) {
            case 0:
                return new BackStackState[i3];
            case 1:
                return new FragmentManager$LaunchedFragmentInfo[i3];
            case 2:
                return new FragmentManagerState[i3];
            default:
                return new FragmentState[i3];
        }
    }
}
