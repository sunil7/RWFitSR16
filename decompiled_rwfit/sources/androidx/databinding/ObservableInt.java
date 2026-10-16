package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableInt extends c implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new g(13);
    static final long serialVersionUID = 1;
    private int mValue;

    public ObservableInt() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mValue;
    }

    public void set(int i3) {
        if (i3 != this.mValue) {
            this.mValue = i3;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mValue);
    }

    public ObservableInt(int i3) {
        this.mValue = i3;
    }

    public ObservableInt(f... fVarArr) {
        super(fVarArr);
    }
}
