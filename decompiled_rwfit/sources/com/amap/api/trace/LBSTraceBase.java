package com.amap.api.trace;

import java.util.List;

/* loaded from: classes.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i3, List<TraceLocation> list, int i10, TraceListener traceListener);

    void setLocationInterval(long j4);

    void setTraceStatusInterval(int i3);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}
