package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import z3.o;

/* loaded from: classes.dex */
public final class GlideException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public static final StackTraceElement[] f6982a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private x3.c key;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.EMPTY_LIST);
    }

    public static void a(Throwable th2, ArrayList arrayList) {
        if (!(th2 instanceof GlideException)) {
            arrayList.add(th2);
            return;
        }
        Iterator<Throwable> it = ((GlideException) th2).getCauses().iterator();
        while (it.hasNext()) {
            a(it.next(), arrayList);
        }
    }

    public static void b(List list, o oVar) {
        try {
            c(list, oVar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void c(List list, o oVar) {
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            oVar.append("Cause (");
            int i10 = i3 + 1;
            oVar.append(String.valueOf(i10));
            oVar.append(" of ");
            oVar.append(String.valueOf(size));
            oVar.append("): ");
            Throwable th2 = (Throwable) list.get(i3);
            if (th2 instanceof GlideException) {
                GlideException glideException = (GlideException) th2;
                glideException.getClass();
                d(glideException, oVar);
                b(glideException.getCauses(), new o(oVar));
            } else {
                d(th2, oVar);
            }
            i3 = i10;
        }
    }

    public static void d(Throwable th2, Appendable appendable) {
        try {
            appendable.append(th2.getClass().toString()).append(": ").append(th2.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th2);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.detailMessage);
        sb2.append(this.dataClass != null ? ", " + this.dataClass : "");
        sb2.append(this.dataSource != null ? ", " + this.dataSource : "");
        sb2.append(this.key != null ? ", " + this.key : "");
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb2.toString();
        }
        if (rootCauses.size() == 1) {
            sb2.append("\nThere was 1 root cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(rootCauses.size());
            sb2.append(" root causes:");
        }
        for (Throwable th2 : rootCauses) {
            sb2.append('\n');
            sb2.append(th2.getClass().getName());
            sb2.append('(');
            sb2.append(th2.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i3 = 0;
        while (i3 < size) {
            StringBuilder sb2 = new StringBuilder("Root cause (");
            int i10 = i3 + 1;
            sb2.append(i10);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(")");
            Log.i(str, sb2.toString(), rootCauses.get(i3));
            i3 = i10;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setLoggingDetails(x3.c cVar, DataSource dataSource) {
        setLoggingDetails(cVar, dataSource, null);
    }

    public void setOrigin(Exception exc) {
        this.exception = exc;
    }

    public GlideException(String str, Throwable th2) {
        this(str, (List<Throwable>) Collections.singletonList(th2));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        d(this, printStream);
        b(getCauses(), new o(printStream));
    }

    public void setLoggingDetails(x3.c cVar, DataSource dataSource, Class<?> cls) {
        this.key = cVar;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(f6982a);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        d(this, printWriter);
        b(getCauses(), new o(printWriter));
    }
}
