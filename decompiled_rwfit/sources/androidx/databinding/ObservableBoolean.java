package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableBoolean extends c implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new g(8);
    static final long serialVersionUID = 1;
    private boolean mValue;

    public ObservableBoolean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean get() {
        return this.mValue;
    }

    public void set(boolean z5) {
        if (z5 != this.mValue) {
            this.mValue = z5;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mValue ? 1 : 0);
    }

    public ObservableBoolean(boolean z5) {
        this.mValue = z5;
    }

    public ObservableBoolean(f... fVarArr) {
        super(fVarArr);
    }
}
