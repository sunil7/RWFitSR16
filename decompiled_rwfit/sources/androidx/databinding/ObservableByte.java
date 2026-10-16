package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableByte extends c implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new g(9);
    static final long serialVersionUID = 1;
    private byte mValue;

    public ObservableByte() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte get() {
        return this.mValue;
    }

    public void set(byte b3) {
        if (b3 != this.mValue) {
            this.mValue = b3;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.mValue);
    }

    public ObservableByte(byte b3) {
        this.mValue = b3;
    }

    public ObservableByte(f... fVarArr) {
        super(fVarArr);
    }
}
