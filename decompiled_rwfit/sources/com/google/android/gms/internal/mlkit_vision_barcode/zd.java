package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class zd {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9700a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Method f9701b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9702c = false;

    /* renamed from: d, reason: collision with root package name */
    public static Field f9703d;

    public static boolean a(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int indexOfKey;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = l1.y0.f15739d;
        l1.y0 y0Var = (l1.y0) view.getTag(R$id.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (y0Var == null) {
            y0Var = new l1.y0();
            y0Var.f15740a = null;
            y0Var.f15741b = null;
            y0Var.f15742c = null;
            view.setTag(R$id.tag_unhandled_key_event_manager, y0Var);
        }
        WeakReference weakReference2 = y0Var.f15742c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        y0Var.f15742c = new WeakReference(keyEvent);
        if (y0Var.f15741b == null) {
            y0Var.f15741b = new SparseArray();
        }
        SparseArray sparseArray = y0Var.f15741b;
        if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
            sparseArray.removeAt(indexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !l1.k0.b(view2) || (arrayList = (ArrayList) view2.getTag(R$id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        throw android.support.v4.media.session.e.c(size, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(l1.o r6, android.view.View r7, android.view.Window.Callback r8, android.view.KeyEvent r9) {
        /*
            r0 = 0
            if (r6 != 0) goto L5
            goto Le4
        L5:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L10
            boolean r6 = r6.t(r9)
            return r6
        L10:
            boolean r1 = r8 instanceof android.app.Activity
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L82
            android.app.Activity r8 = (android.app.Activity) r8
            r8.onUserInteraction()
            android.view.Window r6 = r8.getWindow()
            r7 = 8
            boolean r7 = r6.hasFeature(r7)
            if (r7 == 0) goto L65
            android.app.ActionBar r7 = r8.getActionBar()
            int r1 = r9.getKeyCode()
            r4 = 82
            if (r1 != r4) goto L65
            if (r7 == 0) goto L65
            boolean r1 = com.google.android.gms.internal.mlkit_vision_barcode.zd.f9700a
            if (r1 != 0) goto L4d
            java.lang.Class r1 = r7.getClass()     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.String r4 = "onMenuKeyEvent"
            java.lang.Class<android.view.KeyEvent> r5 = android.view.KeyEvent.class
            java.lang.Class[] r5 = new java.lang.Class[]{r5}     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L4b
            com.google.android.gms.internal.mlkit_vision_barcode.zd.f9701b = r1     // Catch: java.lang.NoSuchMethodException -> L4b
        L4b:
            com.google.android.gms.internal.mlkit_vision_barcode.zd.f9700a = r3
        L4d:
            java.lang.reflect.Method r1 = com.google.android.gms.internal.mlkit_vision_barcode.zd.f9701b
            if (r1 == 0) goto L62
            java.lang.Object[] r4 = new java.lang.Object[]{r9}     // Catch: java.lang.Throwable -> L62
            java.lang.Object r7 = r1.invoke(r7, r4)     // Catch: java.lang.Throwable -> L62
            if (r7 != 0) goto L5c
            goto L62
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L62
            boolean r0 = r7.booleanValue()     // Catch: java.lang.Throwable -> L62
        L62:
            if (r0 == 0) goto L65
            goto L81
        L65:
            boolean r7 = r6.superDispatchKeyEvent(r9)
            if (r7 == 0) goto L6c
            goto L81
        L6c:
            android.view.View r6 = r6.getDecorView()
            boolean r7 = l1.z0.c(r6, r9)
            if (r7 == 0) goto L77
            goto L81
        L77:
            if (r6 == 0) goto L7d
            android.view.KeyEvent$DispatcherState r2 = r6.getKeyDispatcherState()
        L7d:
            boolean r3 = r9.dispatch(r8, r2, r8)
        L81:
            return r3
        L82:
            boolean r1 = r8 instanceof android.app.Dialog
            if (r1 == 0) goto Ld5
            android.app.Dialog r8 = (android.app.Dialog) r8
            boolean r6 = com.google.android.gms.internal.mlkit_vision_barcode.zd.f9702c
            if (r6 != 0) goto L9b
            java.lang.Class<android.app.Dialog> r6 = android.app.Dialog.class
            java.lang.String r7 = "mOnKeyListener"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r7)     // Catch: java.lang.NoSuchFieldException -> L99
            com.google.android.gms.internal.mlkit_vision_barcode.zd.f9703d = r6     // Catch: java.lang.NoSuchFieldException -> L99
            r6.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L99
        L99:
            com.google.android.gms.internal.mlkit_vision_barcode.zd.f9702c = r3
        L9b:
            java.lang.reflect.Field r6 = com.google.android.gms.internal.mlkit_vision_barcode.zd.f9703d
            if (r6 == 0) goto La6
            java.lang.Object r6 = r6.get(r8)     // Catch: java.lang.IllegalAccessException -> La6
            android.content.DialogInterface$OnKeyListener r6 = (android.content.DialogInterface.OnKeyListener) r6     // Catch: java.lang.IllegalAccessException -> La6
            goto La7
        La6:
            r6 = r2
        La7:
            if (r6 == 0) goto Lb4
            int r7 = r9.getKeyCode()
            boolean r6 = r6.onKey(r8, r7, r9)
            if (r6 == 0) goto Lb4
            goto Ld4
        Lb4:
            android.view.Window r6 = r8.getWindow()
            boolean r7 = r6.superDispatchKeyEvent(r9)
            if (r7 == 0) goto Lbf
            goto Ld4
        Lbf:
            android.view.View r6 = r6.getDecorView()
            boolean r7 = l1.z0.c(r6, r9)
            if (r7 == 0) goto Lca
            goto Ld4
        Lca:
            if (r6 == 0) goto Ld0
            android.view.KeyEvent$DispatcherState r2 = r6.getKeyDispatcherState()
        Ld0:
            boolean r3 = r9.dispatch(r8, r2, r8)
        Ld4:
            return r3
        Ld5:
            if (r7 == 0) goto Ldd
            boolean r7 = l1.z0.c(r7, r9)
            if (r7 != 0) goto Le3
        Ldd:
            boolean r6 = r6.t(r9)
            if (r6 == 0) goto Le4
        Le3:
            return r3
        Le4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zd.b(l1.o, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }
}
