package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public final class CellAgeEstimator extends AgeEstimator<Cgi> {
    public CellAgeEstimator(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public int a(Cgi cgi) {
        Cgi cgi2 = cgi;
        if (cgi2 == null) {
            return 99;
        }
        return cgi2.signalStrength;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public long b(Cgi cgi) {
        Cgi cgi2 = cgi;
        if (cgi2 == null) {
            return 0L;
        }
        return cgi2.lastUpdateUtcMills;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public String getKey(Cgi cgi) {
        return cgi == null ? "" : cgi.getCellKey();
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public void a(Cgi cgi, long j4) {
        Cgi cgi2 = cgi;
        if (cgi2 != null) {
            cgi2.lastUpdateUtcMills = j4;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public long b() {
        return Const.sCellLimitTime;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public long a() {
        return Const.sCellLimitSize;
    }
}
