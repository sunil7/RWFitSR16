package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.autonavi.aps.amapapi.config.Const;
import k3.a;

/* loaded from: classes.dex */
public final class WifiAgeEstimator extends AgeEstimator<a> {
    public WifiAgeEstimator(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public int a(a aVar) {
        a aVar2 = aVar;
        return aVar2 == null ? Const.I_DEF_CGI_SIG : aVar2.f15457c;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public long b(a aVar) {
        a aVar2 = aVar;
        if (aVar2 == null) {
            return 0L;
        }
        return aVar2.f15459f;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public String getKey(a aVar) {
        if (aVar == null) {
            return "";
        }
        return aVar.f15461h + Const.STR_MART_WELL + aVar.f15455a;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public void a(a aVar, long j4) {
        a aVar2 = aVar;
        if (aVar2 != null) {
            aVar2.f15459f = j4;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public long b() {
        return Const.sWifLimitTime;
    }

    @Override // com.autonavi.aps.amapapi.restruct.AgeEstimator
    public long a() {
        return Const.sWifLimitSize;
    }
}
