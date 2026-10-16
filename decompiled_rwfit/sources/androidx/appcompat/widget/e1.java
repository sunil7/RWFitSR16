package androidx.appcompat.widget;

import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoNr;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthNr;

/* loaded from: classes.dex */
public abstract /* synthetic */ class e1 {
    public static /* bridge */ /* synthetic */ CellIdentityNr g(Object obj) {
        return (CellIdentityNr) obj;
    }

    public static /* bridge */ /* synthetic */ CellInfoNr h(CellInfo cellInfo) {
        return (CellInfoNr) cellInfo;
    }

    public static /* bridge */ /* synthetic */ CellSignalStrengthNr j(CellSignalStrength cellSignalStrength) {
        return (CellSignalStrengthNr) cellSignalStrength;
    }

    public static /* bridge */ /* synthetic */ boolean v(CellInfo cellInfo) {
        return cellInfo instanceof CellInfoNr;
    }
}
