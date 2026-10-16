package com.king.logx.logger;

import android.util.Log;
import com.king.logx.LogX;
import com.king.logx.util.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.EmptyList;
import kotlin.collections.h;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.Regex;
import kotlin.text.a;
import kotlin.text.m;

/* loaded from: classes.dex */
public class DefaultLogger extends Logger {
    private final int methodCount;
    private final int methodOffset;
    private final boolean showThreadInfo;

    public DefaultLogger() {
        this(false, 0, 0, 7, null);
    }

    private final String getSimpleClassName(String str) {
        return m.z(str);
    }

    private final void logBottomBorder(int i3, String str) {
        println(i3, str, Logger.BOTTOM_BORDER);
    }

    private final void logContent(int i3, String str, String str2) {
        Iterable iterable;
        String lineSeparator = System.lineSeparator();
        e.e(lineSeparator, "lineSeparator()");
        List<String> split = new Regex(lineSeparator).split(str2, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    iterable = h.t(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        iterable = EmptyList.INSTANCE;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            println(i3, str, "│ " + ((String) it.next()));
        }
    }

    private final void logDivider(int i3, String str) {
        println(i3, str, Logger.MIDDLE_BORDER);
    }

    private final void logHeaderContent(int i3, String str, int i10, int i11) {
        if (this.showThreadInfo) {
            println(i3, str, "│ Thread: " + Thread.currentThread().getName());
            logDivider(i3, str);
        }
        StackTraceElement[] stackTrace = getStackTrace();
        int stackOffset = getStackOffset(stackTrace) + i11;
        if (i10 + stackOffset > stackTrace.length) {
            i10 = (stackTrace.length - stackOffset) - 1;
        }
        String str2 = "";
        while (i10 > 0) {
            int i12 = i10 + stackOffset;
            if (i12 < stackTrace.length) {
                StringBuilder sb2 = new StringBuilder("│ ");
                sb2.append(str2);
                String className = stackTrace[i12].getClassName();
                e.e(className, "stackTrace[stackIndex].className");
                sb2.append(getSimpleClassName(className));
                sb2.append(".");
                sb2.append(stackTrace[i12].getMethodName());
                sb2.append("(");
                sb2.append(stackTrace[i12].getFileName());
                sb2.append(":");
                sb2.append(stackTrace[i12].getLineNumber());
                sb2.append(")");
                str2 = str2 + Logger.INDENT;
                String sb3 = sb2.toString();
                e.e(sb3, "builder.toString()");
                println(i3, str, sb3);
            }
            i10--;
        }
    }

    private final void logTopBorder(int i3, String str) {
        println(i3, str, Logger.TOP_BORDER);
    }

    @Override // com.king.logx.logger.Logger
    public boolean isLoggable(int i3, String str) {
        return LogX.Companion.isDebug$logx_release();
    }

    @Override // com.king.logx.logger.Logger
    public void log(int i3, String str, String str2, Throwable th2) {
        String valueOf = String.valueOf(str2);
        if (str2 == null || str2.length() == 0) {
            if (th2 != null) {
                valueOf = Utils.Companion.getStackTraceString(th2);
            }
        } else if (th2 != null) {
            valueOf = valueOf + '\n' + Utils.Companion.getStackTraceString(th2);
        }
        logTopBorder(i3, str);
        logHeaderContent(i3, str, this.methodCount, getLastOffset$logx_release());
        byte[] bytes = valueOf.getBytes(a.f15656a);
        e.e(bytes, "this as java.lang.String).getBytes(charset)");
        int length = bytes.length;
        if (length <= 4000) {
            if (this.methodCount > 0) {
                logDivider(i3, str);
            }
            logContent(i3, str, valueOf);
            logBottomBorder(i3, str);
            return;
        }
        if (this.methodCount > 0) {
            logDivider(i3, str);
        }
        for (int i10 = 0; i10 < length; i10 += 4000) {
            int i11 = length - i10;
            if (i11 > 4000) {
                i11 = 4000;
            }
            logContent(i3, str, new String(bytes, i10, i11, a.f15656a));
        }
        logBottomBorder(i3, str);
    }

    public void println(int i3, String str, String message) {
        e.f(message, "message");
        Log.println(i3, str, message);
    }

    public DefaultLogger(boolean z5) {
        this(z5, 0, 0, 6, null);
    }

    public DefaultLogger(boolean z5, int i3) {
        this(z5, i3, 0, 4, null);
    }

    public /* synthetic */ DefaultLogger(boolean z5, int i3, int i10, int i11, c cVar) {
        this((i11 & 1) != 0 ? true : z5, (i11 & 2) != 0 ? 2 : i3, (i11 & 4) != 0 ? 0 : i10);
    }

    public DefaultLogger(boolean z5, int i3, int i10) {
        super(i10);
        this.showThreadInfo = z5;
        this.methodCount = i3;
        this.methodOffset = i10;
    }
}
