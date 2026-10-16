package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableFloat extends c implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new g(12);
    static final long serialVersionUID = 1;
    private float mValue;

    public ObservableFloat() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float get() {
        return this.mValue;
    }

    public void set(float f2) {
        if (f2 != this.mValue) {
            this.mValue = f2;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.mValue);
    }

    public ObservableFloat(float f2) {
        this.mValue = f2;
    }

    public ObservableFloat(f... fVarArr) {
        super(fVarArr);
    }
}
