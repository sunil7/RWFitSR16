package okhttp3.internal.platform.android;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.p;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;

@SuppressSignatureCheck
/* loaded from: classes2.dex */
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = OkHttpClient.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(Http2.class.getName(), "okhttp.Http2");
        linkedHashMap.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        int size = linkedHashMap.size();
        knownLoggers = size != 0 ? size != 1 ? new LinkedHashMap<>(linkedHashMap) : p.d(linkedHashMap) : p.a();
    }

    private AndroidLog() {
    }

    private final void enableLogging(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            e.e(logger, "logger");
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String str) {
        String str2 = knownLoggers.get(str);
        if (str2 != null) {
            return str2;
        }
        e.f(str, "<this>");
        int length = str.length();
        if (23 <= length) {
            length = 23;
        }
        String substring = str.substring(0, length);
        e.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final void androidLog$okhttp(String loggerName, int i3, String message, Throwable th2) {
        int min;
        e.f(loggerName, "loggerName");
        e.f(message, "message");
        String loggerTag = loggerTag(loggerName);
        if (Log.isLoggable(loggerTag, i3)) {
            if (th2 != null) {
                StringBuilder u10 = l0.u(message, "\n");
                u10.append(Log.getStackTraceString(th2));
                message = u10.toString();
            }
            int length = message.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = m.i(message, '\n', i10, 4);
                if (i11 == -1) {
                    i11 = length;
                }
                while (true) {
                    min = Math.min(i11, i10 + 4000);
                    String substring = message.substring(i10, min);
                    e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i3, loggerTag, substring);
                    if (min >= i11) {
                        break;
                    } else {
                        i10 = min;
                    }
                }
                i10 = min + 1;
            }
        }
    }

    public final void enable() {
        for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
            enableLogging(entry.getKey(), entry.getValue());
        }
    }
}
