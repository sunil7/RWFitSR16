package com.amap.api.col.p0003sl;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class oa {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static oa f4778a = new oa();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|1|(18:3|(3:6|(1:108)(2:17|(8:19|(1:21)|22|23|24|(3:87|(4:90|(1:105)(3:92|(3:95|(1:99)(1:101)|93)|103)|104|88)|106)|26|(10:31|(1:33)|34|(4:37|(4:42|43|(4:46|(2:58|59)|55|44)|63)|64|35)|67|68|69|70|71|(1:73)(3:74|75|(3:81|82|83)(3:78|79|80)))(1:29)))|4)|112|113|24|(0)|26|(0)|31|(0)|34|(1:35)|67|68|69|70|71|(0)(0))|114|24|(0)|26|(0)|31|(0)|34|(1:35)|67|68|69|70|71|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0137 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.util.List<com.amap.api.col.p0003sl.m9> r20, boolean r21, com.amap.api.col.p0003sl.m9 r22) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.oa.a(android.content.Context, java.lang.String, java.lang.String, java.util.List, boolean, com.amap.api.col.3sl.m9):boolean");
    }

    private static JSONObject a(Thread thread) {
        if (thread.getStackTrace() == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement);
                stringBuffer.append("<br />");
            }
            jSONObject.put("stacks", stringBuffer.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
