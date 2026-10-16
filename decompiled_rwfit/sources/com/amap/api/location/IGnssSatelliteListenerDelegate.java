package com.amap.api.location;

import java.util.List;

/* loaded from: classes.dex */
public interface IGnssSatelliteListenerDelegate {
    void onFirstFix(int i3);

    void onSatelliteChanged(int i3, float f2, List<Object> list);

    void onStarted();

    void onStopped();
}
