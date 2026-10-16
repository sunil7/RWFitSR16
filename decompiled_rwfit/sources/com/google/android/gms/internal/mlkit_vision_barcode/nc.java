package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class nc {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f9452a = true;

    public static Drawable a(Context context, Context context2, int i3, Resources.Theme theme) {
        Context context3;
        try {
            if (f9452a) {
                if (theme != null) {
                    g.d dVar = new g.d(context2);
                    dVar.f13693b = theme;
                    context3 = dVar;
                } else {
                    context3 = context2;
                }
                return pb.b(context3, i3);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return a1.c.b(context2, i3);
        } catch (NoClassDefFoundError unused2) {
            f9452a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal threadLocal = b1.o.f3076a;
        return b1.i.a(resources, i3, theme);
    }
}
