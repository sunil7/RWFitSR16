package com.amap.api.trace;

import android.content.Context;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.l9;
import com.amap.api.col.p0003sl.n1;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.col.p0003sl.x8;
import com.amap.api.map3d.R;
import java.util.List;

/* loaded from: classes.dex */
public class LBSTraceClient {
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;

    /* renamed from: a, reason: collision with root package name */
    private static LBSTraceBase f6557a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile LBSTraceClient f6558b;
    public static final String MIN_GRASP_POINT_ERROR = n1.a(R.string.O105492_85);
    public static final String LOCATE_TIMEOUT_ERROR = n1.a(R.string.O105492_86);
    public static final String TRACE_SUCCESS = n1.a(R.string.O105492_87);

    public LBSTraceClient(Context context) throws Exception {
        a(context);
    }

    private static void a(Context context) throws Exception {
        l9 a3 = k9.a(context, v4.b());
        if (a3.f4490a != k9.e.SuccessCode) {
            throw new Exception(a3.f4491b);
        }
        if (context != null) {
            f6557a = new x8(context.getApplicationContext());
        }
    }

    public static LBSTraceClient getInstance(Context context) throws Exception {
        if (f6558b == null) {
            synchronized (LBSTraceClient.class) {
                try {
                    if (f6558b == null) {
                        a(context);
                        f6558b = new LBSTraceClient();
                    }
                } finally {
                }
            }
        }
        return f6558b;
    }

    public void destroy() {
        LBSTraceBase lBSTraceBase = f6557a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            f6557a = null;
            f6558b = null;
        }
    }

    public void queryProcessedTrace(int i3, List<TraceLocation> list, int i10, TraceListener traceListener) {
        LBSTraceBase lBSTraceBase = f6557a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i3, list, i10, traceListener);
        }
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        LBSTraceBase lBSTraceBase = f6557a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        LBSTraceBase lBSTraceBase = f6557a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }

    private LBSTraceClient() {
    }
}
