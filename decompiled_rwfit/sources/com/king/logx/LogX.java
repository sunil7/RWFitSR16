package com.king.logx;

import com.king.logx.logger.CompositeLogger;
import com.king.logx.logger.DefaultLogger;
import com.king.logx.logger.ILogger;
import com.king.logx.logger.Logger;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.i;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class LogX {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final Companion Companion = new Companion(null);
    private static boolean isDebug = true;
    private static final List<String> internalIgnore = i.d(LogX.class.getName(), Companion.class.getName(), ILogger.class.getName(), DefaultLogger.class.getName(), CompositeLogger.class.getName(), Logger.class.getName());
    private static Logger logger = new DefaultLogger(false, 0, 0, 7, null);

    public static final class Companion implements ILogger {
        public /* synthetic */ Companion(c cVar) {
            this();
        }

        private static /* synthetic */ void getLogger$annotations() {
        }

        @Override // com.king.logx.logger.ILogger
        public void d(String str, Object... args) {
            e.f(args, "args");
            LogX.logger.d(str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void e(String str, Object... args) {
            e.f(args, "args");
            LogX.logger.e(str, Arrays.copyOf(args, args.length));
        }

        public final /* synthetic */ List getInternalIgnore$logx_release() {
            return LogX.internalIgnore;
        }

        @Override // com.king.logx.logger.ILogger
        public void i(String str, Object... args) {
            e.f(args, "args");
            LogX.logger.i(str, Arrays.copyOf(args, args.length));
        }

        public final /* synthetic */ boolean isDebug$logx_release() {
            return LogX.isDebug;
        }

        @Override // com.king.logx.logger.ILogger
        public void log(int i3, String str) {
            LogX.logger.log(i3, str);
        }

        @Override // com.king.logx.logger.ILogger
        public ILogger offset(int i3) {
            LogX.logger.offset(i3);
            return this;
        }

        public final void setDebug$logx_release(boolean z5) {
            LogX.isDebug = z5;
        }

        public final void setLogger(Logger logger) {
            e.f(logger, "logger");
            LogX.logger = logger;
        }

        @Override // com.king.logx.logger.ILogger
        public ILogger tag(String tag) {
            e.f(tag, "tag");
            LogX.logger.tag(tag);
            return this;
        }

        @Override // com.king.logx.logger.ILogger
        public void v(String str, Object... args) {
            e.f(args, "args");
            LogX.logger.v(str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void w(String str, Object... args) {
            e.f(args, "args");
            LogX.logger.w(str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void wtf(String str, Object... args) {
            e.f(args, "args");
            LogX.logger.wtf(str, Arrays.copyOf(args, args.length));
        }

        private Companion() {
        }

        @Override // com.king.logx.logger.ILogger
        public void d(Throwable th2, String str, Object... args) {
            e.f(args, "args");
            LogX.logger.d(th2, str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void e(Throwable th2, String str, Object... args) {
            e.f(args, "args");
            LogX.logger.e(th2, str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void i(Throwable th2, String str, Object... args) {
            e.f(args, "args");
            LogX.logger.i(th2, str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void log(int i3, Throwable th2, String str) {
            LogX.logger.log(i3, str);
        }

        @Override // com.king.logx.logger.ILogger
        public void v(Throwable th2, String str, Object... args) {
            e.f(args, "args");
            LogX.logger.v(th2, str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void w(Throwable th2, String str, Object... args) {
            e.f(args, "args");
            LogX.logger.w(th2, str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void wtf(Throwable th2, String str, Object... args) {
            e.f(args, "args");
            LogX.logger.wtf(th2, str, Arrays.copyOf(args, args.length));
        }

        @Override // com.king.logx.logger.ILogger
        public void d(Throwable th2) {
            LogX.logger.d(th2);
        }

        @Override // com.king.logx.logger.ILogger
        public void e(Throwable th2) {
            LogX.logger.e(th2);
        }

        @Override // com.king.logx.logger.ILogger
        public void i(Throwable th2) {
            LogX.logger.i(th2);
        }

        @Override // com.king.logx.logger.ILogger
        public void log(int i3, Throwable th2) {
            LogX.logger.log(i3, th2);
        }

        @Override // com.king.logx.logger.ILogger
        public void v(Throwable th2) {
            LogX.logger.v(th2);
        }

        @Override // com.king.logx.logger.ILogger
        public void w(Throwable th2) {
            LogX.logger.w(th2);
        }

        @Override // com.king.logx.logger.ILogger
        public void wtf(Throwable th2) {
            LogX.logger.wtf(th2);
        }
    }

    private LogX() {
        throw new AssertionError();
    }

    public static void d(String str, Object... objArr) {
        Companion.d(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        Companion.e(str, objArr);
    }

    public static void i(String str, Object... objArr) {
        Companion.i(str, objArr);
    }

    public static void log(int i3, String str) {
        Companion.log(i3, str);
    }

    public static ILogger offset(int i3) {
        return Companion.offset(i3);
    }

    public static final void setLogger(Logger logger2) {
        Companion.setLogger(logger2);
    }

    public static ILogger tag(String str) {
        return Companion.tag(str);
    }

    public static void v(String str, Object... objArr) {
        Companion.v(str, objArr);
    }

    public static void w(String str, Object... objArr) {
        Companion.w(str, objArr);
    }

    public static void wtf(String str, Object... objArr) {
        Companion.wtf(str, objArr);
    }

    public static void d(Throwable th2) {
        Companion.d(th2);
    }

    public static void e(Throwable th2) {
        Companion.e(th2);
    }

    public static void i(Throwable th2) {
        Companion.i(th2);
    }

    public static void log(int i3, Throwable th2) {
        Companion.log(i3, th2);
    }

    public static void v(Throwable th2) {
        Companion.v(th2);
    }

    public static void w(Throwable th2) {
        Companion.w(th2);
    }

    public static void wtf(Throwable th2) {
        Companion.wtf(th2);
    }

    public static void d(Throwable th2, String str, Object... objArr) {
        Companion.d(th2, str, objArr);
    }

    public static void e(Throwable th2, String str, Object... objArr) {
        Companion.e(th2, str, objArr);
    }

    public static void i(Throwable th2, String str, Object... objArr) {
        Companion.i(th2, str, objArr);
    }

    public static void log(int i3, Throwable th2, String str) {
        Companion.log(i3, th2, str);
    }

    public static void v(Throwable th2, String str, Object... objArr) {
        Companion.v(th2, str, objArr);
    }

    public static void w(Throwable th2, String str, Object... objArr) {
        Companion.w(th2, str, objArr);
    }

    public static void wtf(Throwable th2, String str, Object... objArr) {
        Companion.wtf(th2, str, objArr);
    }
}
