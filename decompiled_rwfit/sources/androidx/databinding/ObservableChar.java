package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableChar extends c implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = new g(10);
    static final long serialVersionUID = 1;
    private char mValue;

    public ObservableChar() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public char get() {
        return this.mValue;
    }

    public void set(char c9) {
        if (c9 != this.mValue) {
            this.mValue = c9;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mValue);
    }

    public ObservableChar(char c9) {
        this.mValue = c9;
    }

    public ObservableChar(f... fVarArr) {
        super(fVarArr);
    }
}
