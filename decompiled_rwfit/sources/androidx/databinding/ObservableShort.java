package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableShort extends c implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new g(15);
    static final long serialVersionUID = 1;
    private short mValue;

    public ObservableShort() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public short get() {
        return this.mValue;
    }

    public void set(short s7) {
        if (s7 != this.mValue) {
            this.mValue = s7;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mValue);
    }

    public ObservableShort(short s7) {
        this.mValue = s7;
    }

    public ObservableShort(f... fVarArr) {
        super(fVarArr);
    }
}
