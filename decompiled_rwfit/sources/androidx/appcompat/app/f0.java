package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class f0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f471a;

    /* renamed from: b, reason: collision with root package name */
    public final String f472b;

    /* renamed from: c, reason: collision with root package name */
    public Method f473c;

    /* renamed from: d, reason: collision with root package name */
    public Context f474d;

    public f0(View view, String str) {
        this.f471a = view;
        this.f472b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f473c == null) {
            View view2 = this.f471a;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f472b;
                if (context == null) {
                    int id2 = view2.getId();
                    if (id2 == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id2) + "'";
                    }
                    StringBuilder r = android.support.v4.media.session.e.r("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    r.append(view2.getClass());
                    r.append(str);
                    throw new IllegalStateException(r.toString());
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f473c = method;
                        this.f474d = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f473c.invoke(this.f474d, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e10) {
            throw new IllegalStateException("Could not execute method for android:onClick", e10);
        }
    }
}
