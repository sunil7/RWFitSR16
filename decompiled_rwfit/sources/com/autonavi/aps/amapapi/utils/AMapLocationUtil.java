package com.autonavi.aps.amapapi.utils;

import android.os.Bundle;
import com.amap.api.location.AMapLocation;

/* loaded from: classes.dex */
public class AMapLocationUtil {
    public static void cacheLocationType(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        Bundle extras = aMapLocation.getExtras();
        if (extras == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(AMapLocation.LBS_REAL_LOCATION_TYPE, aMapLocation.getLocationType());
            aMapLocation.setExtras(bundle);
        } else {
            if (extras.containsKey(AMapLocation.LBS_REAL_LOCATION_TYPE)) {
                return;
            }
            extras.putInt(AMapLocation.LBS_REAL_LOCATION_TYPE, aMapLocation.getLocationType());
        }
    }
}
