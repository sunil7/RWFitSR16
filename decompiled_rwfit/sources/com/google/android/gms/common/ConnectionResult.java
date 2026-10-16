package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.u;
import com.tencent.connect.common.Constants;
import ha.d;
import java.util.Arrays;
import org.joda.time.format.p;
import q9.n;

/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int API_DISABLED = 23;
    public static final int API_DISABLED_FOR_CONNECTION = 24;
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final int DEVELOPER_ERROR = 10;

    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final int UNKNOWN = -1;

    /* renamed from: a, reason: collision with root package name */
    public final int f9070a;
    private final int zzb;
    private final PendingIntent zzc;
    private final String zzd;
    public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new d(11);

    public ConnectionResult(int i3, int i10, PendingIntent pendingIntent, String str) {
        this.f9070a = i3;
        this.zzb = i10;
        this.zzc = pendingIntent;
        this.zzd = str;
    }

    public static String l(int i3) {
        if (i3 == 99) {
            return "UNFINISHED";
        }
        if (i3 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i3) {
            case -1:
                return Constants.APP_VERSION_UNKNOWN;
            case 0:
                return AMapLocationStaticsEntity.SUCCESS_STATUS;
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i3) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return l0.k(i3, "UNKNOWN_ERROR_CODE(", ")");
                }
        }
    }

    public final int b() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.zzb == connectionResult.zzb && n.h(this.zzc, connectionResult.zzc) && n.h(this.zzd, connectionResult.zzd);
    }

    public final String h() {
        return this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final PendingIntent i() {
        return this.zzc;
    }

    public final boolean j() {
        return (this.zzb == 0 || this.zzc == null) ? false : true;
    }

    public final boolean k() {
        return this.zzb == 0;
    }

    public final String toString() {
        p pVar = new p(this);
        pVar.a(l(this.zzb), "statusCode");
        pVar.a(this.zzc, "resolution");
        pVar.a(this.zzd, "message");
        return pVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9070a);
        int i11 = this.zzb;
        u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        u.d(parcel, 3, this.zzc, i3);
        u.e(parcel, 4, this.zzd);
        u.j(parcel, i10);
    }

    public ConnectionResult(int i3) {
        this(1, i3, null, null);
    }

    public ConnectionResult(int i3, PendingIntent pendingIntent) {
        this(1, i3, pendingIntent, null);
    }
}
