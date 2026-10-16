package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* loaded from: classes.dex */
public interface TraceListener {
    void onFinished(int i3, List<LatLng> list, int i10, int i11);

    void onRequestFailed(int i3, String str);

    void onTraceProcessing(int i3, int i10, List<LatLng> list);
}
