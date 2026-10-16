package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.Arrays;
import org.joda.time.format.p;
import q9.n;

/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements ReflectedParcelable {
    private final int zzb;
    private final String zzc;
    private final PendingIntent zzd;
    private final ConnectionResult zze;
    public static final Status RESULT_SUCCESS_CACHE = new Status(-1, null, null, null);
    public static final Status RESULT_SUCCESS = new Status(0, null, null, null);
    public static final Status RESULT_INTERRUPTED = new Status(14, null, null, null);
    public static final Status RESULT_INTERNAL_ERROR = new Status(8, null, null, null);
    public static final Status RESULT_TIMEOUT = new Status(15, null, null, null);
    public static final Status RESULT_CANCELED = new Status(16, null, null, null);
    public static final Status zza = new Status(17, null, null, null);
    public static final Status RESULT_DEAD_CLIENT = new Status(18, null, null, null);
    public static final Parcelable.Creator<Status> CREATOR = new androidx.databinding.g(19);

    public Status(int i3, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = i3;
        this.zzc = str;
        this.zzd = pendingIntent;
        this.zze = connectionResult;
    }

    public final void W(Activity activity, int i3) {
        if (k()) {
            PendingIntent pendingIntent = this.zzd;
            n.e(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i3, null, 0, 0, 0);
        }
    }

    public final ConnectionResult b() {
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzb == status.zzb && n.h(this.zzc, status.zzc) && n.h(this.zzd, status.zzd) && n.h(this.zze, status.zze);
    }

    public final PendingIntent h() {
        return this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze});
    }

    public final int i() {
        return this.zzb;
    }

    public final String j() {
        return this.zzc;
    }

    public final boolean k() {
        return this.zzd != null;
    }

    public final boolean l() {
        return this.zzb <= 0;
    }

    public final String toString() {
        p pVar = new p(this);
        String str = this.zzc;
        if (str == null) {
            int i3 = this.zzb;
            switch (i3) {
                case -1:
                    str = "SUCCESS_CACHE";
                    break;
                case 0:
                    str = AMapLocationStaticsEntity.SUCCESS_STATUS;
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    str = l0.j(i3, "unknown status code: ");
                    break;
                case 2:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    str = "SERVICE_DISABLED";
                    break;
                case 4:
                    str = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    str = "INVALID_ACCOUNT";
                    break;
                case 6:
                    str = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    str = "NETWORK_ERROR";
                    break;
                case 8:
                    str = "INTERNAL_ERROR";
                    break;
                case 10:
                    str = "DEVELOPER_ERROR";
                    break;
                case 13:
                    str = "ERROR";
                    break;
                case 14:
                    str = "INTERRUPTED";
                    break;
                case 15:
                    str = "TIMEOUT";
                    break;
                case 16:
                    str = "CANCELED";
                    break;
                case 17:
                    str = "API_NOT_CONNECTED";
                    break;
                case 18:
                    str = "DEAD_CLIENT";
                    break;
                case 19:
                    str = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    str = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    str = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    str = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        pVar.a(str, "statusCode");
        pVar.a(this.zzd, "resolution");
        return pVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        int i11 = this.zzb;
        u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        u.e(parcel, 2, this.zzc);
        u.d(parcel, 3, this.zzd, i3);
        u.d(parcel, 4, this.zze, i3);
        u.j(parcel, i10);
    }
}
