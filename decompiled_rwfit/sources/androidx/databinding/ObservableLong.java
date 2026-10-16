package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableLong extends c implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableLong> CREATOR = new g(14);
    static final long serialVersionUID = 1;
    private long mValue;

    public ObservableLong() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long get() {
        return this.mValue;
    }

    public void set(long j4) {
        if (j4 != this.mValue) {
            this.mValue = j4;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.mValue);
    }

    public ObservableLong(long j4) {
        this.mValue = j4;
    }

    public ObservableLong(f... fVarArr) {
        super(fVarArr);
    }
}
