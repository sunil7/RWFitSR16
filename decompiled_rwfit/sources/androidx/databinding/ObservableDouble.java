package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableDouble extends c implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableDouble> CREATOR = new g(11);
    static final long serialVersionUID = 1;
    private double mValue;

    public ObservableDouble() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double get() {
        return this.mValue;
    }

    public void set(double d5) {
        if (d5 != this.mValue) {
            this.mValue = d5;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeDouble(this.mValue);
    }

    public ObservableDouble(double d5) {
        this.mValue = d5;
    }

    public ObservableDouble(f... fVarArr) {
        super(fVarArr);
    }
}
