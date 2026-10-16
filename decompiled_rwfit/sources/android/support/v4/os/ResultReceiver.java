package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.databinding.g;
import b.b;
import b.c;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new g(16);

    /* renamed from: a, reason: collision with root package name */
    public b f330a;

    public void a(int i3, Bundle bundle) {
    }

    public final void b(int i3, Bundle bundle) {
        b bVar = this.f330a;
        if (bVar != null) {
            try {
                bVar.x(i3, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        synchronized (this) {
            try {
                if (this.f330a == null) {
                    this.f330a = new c(this);
                }
                parcel.writeStrongBinder(this.f330a.asBinder());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
