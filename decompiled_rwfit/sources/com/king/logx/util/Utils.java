package com.king.logx.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;

/* loaded from: classes.dex */
public final class Utils {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_TAG_LENGTH = 23;

    public static final class Companion {
        public /* synthetic */ Companion(c cVar) {
            this();
        }

        public final String createStackElementTag(StackTraceElement element) {
            e.f(element, "element");
            String className = element.getClassName();
            e.e(className, "element.className");
            String z5 = m.z(className);
            int i3 = m.i(z5, '$', 0, 6);
            if (i3 == -1) {
                return z5;
            }
            String substring = z5.substring(0, i3);
            e.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final String getStackTraceString(Throwable t8) {
            e.f(t8, "t");
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            t8.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            e.e(stringWriter2, "sw.toString()");
            return stringWriter2;
        }

        private Companion() {
        }
    }

    private Utils() {
        throw new AssertionError();
    }
}
