package com.king.logx.logger;

import com.king.logx.LogX;
import com.king.logx.util.Utils;
import java.util.Arrays;
import kotlin.collections.g;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class Logger implements ILogger {
    public static final String BOTTOM_BORDER = "└──────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final char BOTTOM_LEFT_CORNER = 9492;
    public static final Companion Companion = new Companion(null);
    private static final String DOUBLE_DIVIDER = "─────────────────────────────────────────────────";
    public static final char HORIZONTAL_LINE = 9474;
    public static final String INDENT = "    ";
    public static final int MAX_LOG_LENGTH = 4000;
    public static final String MIDDLE_BORDER = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final char MIDDLE_CORNER = 9500;
    public static final int MIN_STACK_OFFSET = 5;
    private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    public static final String TOP_BORDER = "┌──────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final char TOP_LEFT_CORNER = 9484;
    private final ThreadLocal<Integer> explicitOffset;
    private final ThreadLocal<String> explicitTag;
    private volatile int lastOffset;
    private final int methodOffset;

    public static final class Companion {
        public /* synthetic */ Companion(c cVar) {
            this();
        }

        private Companion() {
        }
    }

    public Logger() {
        this(0, 1, null);
    }

    private final /* synthetic */ int getOffset() {
        Integer num = this.explicitOffset.get();
        if (num == null) {
            return this.methodOffset;
        }
        this.explicitOffset.remove();
        return num.intValue();
    }

    private final /* synthetic */ String getTag() {
        String str = this.explicitTag.get();
        if (str != null) {
            this.explicitTag.remove();
            return str;
        }
        StackTraceElement[] stackTrace = getStackTrace();
        StackTraceElement stackTraceElement = (StackTraceElement) g.f(getStackOffset(stackTrace) + 1 + this.lastOffset, stackTrace);
        if (stackTraceElement != null) {
            return Utils.Companion.createStackElementTag(stackTraceElement);
        }
        return null;
    }

    private final synchronized void prepareLog(int i3, Throwable th2, String str, Object... objArr) {
        try {
            this.lastOffset = getOffset();
            String tag = getTag();
            if (isLoggable(i3, tag)) {
                if (!(objArr.length == 0)) {
                    str = formatMessage(str, objArr);
                }
                log(i3, tag, str, th2);
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // com.king.logx.logger.ILogger
    public void d(String str, Object... args) {
        e.f(args, "args");
        prepareLog(3, null, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void e(String str, Object... args) {
        e.f(args, "args");
        prepareLog(6, null, str, Arrays.copyOf(args, args.length));
    }

    public String formatMessage(String str, Object[] args) {
        e.f(args, "args");
        if (str == null) {
            return null;
        }
        Object[] copyOf = Arrays.copyOf(args, args.length);
        return String.format(str, Arrays.copyOf(copyOf, copyOf.length));
    }

    public final int getLastOffset$logx_release() {
        return this.lastOffset;
    }

    public final int getStackOffset(StackTraceElement[] trace) {
        e.f(trace, "trace");
        for (int i3 = 5; i3 < trace.length; i3++) {
            if (!LogX.Companion.getInternalIgnore$logx_release().contains(trace[i3].getClassName())) {
                return i3 - 1;
            }
        }
        return -1;
    }

    public StackTraceElement[] getStackTrace() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        e.e(stackTrace, "Throwable().stackTrace");
        return stackTrace;
    }

    @Override // com.king.logx.logger.ILogger
    public void i(String str, Object... args) {
        e.f(args, "args");
        prepareLog(4, null, str, Arrays.copyOf(args, args.length));
    }

    public boolean isLoggable(int i3, String str) {
        return true;
    }

    @Override // com.king.logx.logger.ILogger
    public void log(int i3, String str) {
        prepareLog(i3, null, str, new Object[0]);
    }

    public abstract void log(int i3, String str, String str2, Throwable th2);

    @Override // com.king.logx.logger.ILogger
    public ILogger offset(int i3) {
        this.explicitOffset.set(Integer.valueOf(i3));
        return this;
    }

    public final void setLastOffset$logx_release(int i3) {
        this.lastOffset = i3;
    }

    @Override // com.king.logx.logger.ILogger
    public ILogger tag(String tag) {
        e.f(tag, "tag");
        this.explicitTag.set(tag);
        return this;
    }

    @Override // com.king.logx.logger.ILogger
    public void v(String str, Object... args) {
        e.f(args, "args");
        prepareLog(2, null, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void w(String str, Object... args) {
        e.f(args, "args");
        prepareLog(5, null, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void wtf(String str, Object... args) {
        e.f(args, "args");
        prepareLog(7, null, str, Arrays.copyOf(args, args.length));
    }

    public Logger(int i3) {
        this.methodOffset = i3;
        this.explicitOffset = new ThreadLocal<>();
        this.lastOffset = i3;
        this.explicitTag = new ThreadLocal<>();
    }

    @Override // com.king.logx.logger.ILogger
    public void d(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        prepareLog(3, th2, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void e(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        prepareLog(6, th2, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void i(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        prepareLog(4, th2, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void log(int i3, Throwable th2, String str) {
        prepareLog(i3, th2, str, new Object[0]);
    }

    @Override // com.king.logx.logger.ILogger
    public void v(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        prepareLog(2, th2, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void w(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        prepareLog(5, th2, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void wtf(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        prepareLog(7, th2, str, Arrays.copyOf(args, args.length));
    }

    @Override // com.king.logx.logger.ILogger
    public void d(Throwable th2) {
        prepareLog(3, th2, null, new Object[0]);
    }

    @Override // com.king.logx.logger.ILogger
    public void e(Throwable th2) {
        prepareLog(6, th2, null, new Object[0]);
    }

    @Override // com.king.logx.logger.ILogger
    public void i(Throwable th2) {
        prepareLog(4, th2, null, new Object[0]);
    }

    @Override // com.king.logx.logger.ILogger
    public void log(int i3, Throwable th2) {
        prepareLog(i3, th2, null, new Object[0]);
    }

    @Override // com.king.logx.logger.ILogger
    public void v(Throwable th2) {
        prepareLog(2, th2, null, new Object[0]);
    }

    @Override // com.king.logx.logger.ILogger
    public void w(Throwable th2) {
        prepareLog(5, th2, null, new Object[0]);
    }

    @Override // com.king.logx.logger.ILogger
    public void wtf(Throwable th2) {
        prepareLog(7, th2, null, new Object[0]);
    }

    public /* synthetic */ Logger(int i3, int i10, c cVar) {
        this((i10 & 1) != 0 ? 0 : i3);
    }
}
