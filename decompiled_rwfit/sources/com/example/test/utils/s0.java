package com.example.test.utils;

import android.hardware.camera2.CameraCaptureSession;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import l1.x1;

/* loaded from: classes.dex */
public final class s0 implements com.google.android.material.internal.z {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8756a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8757b;

    public /* synthetic */ s0(Object obj, boolean z5) {
        this.f8756a = z5;
        this.f8757b = obj;
    }

    public void a(String str, int i3, u0 u0Var, String... strArr) {
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) this.f8757b;
        spannableStringBuilder.append((CharSequence) str);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str2 = strArr[i10];
            int indexOf = str.toString().indexOf(str2);
            if (indexOf >= 0) {
                spannableStringBuilder.setSpan(new q0(u0Var, i10, i3), indexOf, str2.length() + indexOf, 33);
            }
        }
    }

    @Override // com.google.android.material.internal.z
    public x1 b(View view, x1 x1Var, com.google.android.material.internal.a0 a0Var) {
        int d5 = x1Var.d();
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f8757b;
        bottomSheetBehavior.r = d5;
        boolean d8 = gb.d(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (bottomSheetBehavior.f10283m) {
            int a3 = x1Var.a();
            bottomSheetBehavior.f10287q = a3;
            paddingBottom = a3 + a0Var.f10557d;
        }
        if (bottomSheetBehavior.f10284n) {
            paddingLeft = (d8 ? a0Var.f10556c : a0Var.f10554a) + x1Var.b();
        }
        if (bottomSheetBehavior.f10285o) {
            paddingRight = x1Var.c() + (d8 ? a0Var.f10554a : a0Var.f10556c);
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        boolean z5 = this.f8756a;
        if (z5) {
            bottomSheetBehavior.f10281k = x1Var.f15738a.g().f3357d;
        }
        if (!bottomSheetBehavior.f10283m && !z5) {
            return x1Var;
        }
        bottomSheetBehavior.J();
        return x1Var;
    }

    public CameraCaptureSession.CaptureCallback c(CameraCaptureSession.CaptureCallback captureCallback) {
        if (!this.f8756a) {
            return captureCallback;
        }
        androidx.camera.camera2.internal.compat.f fVar = new androidx.camera.camera2.internal.compat.f(3);
        List list = (List) this.f8757b;
        n0.i iVar = (n0.i) fVar.f1165c;
        list.add(iVar);
        Log.d("RequestMonitor", "RequestListener " + fVar + " monitoring " + this);
        iVar.f16358b.a(new androidx.camera.camera2.internal.compat.h(this, 14, fVar, iVar), a6.a());
        return new com.example.test.ui.view.b(Arrays.asList(fVar, captureCallback));
    }

    public boolean d() {
        return this.f8756a;
    }

    public ob.a e() {
        List list = (List) this.f8757b;
        if (list.isEmpty()) {
            return x.k.f19707c;
        }
        x.l lVar = new x.l(new ArrayList(new ArrayList(list)), false, a6.a());
        n.x0 x0Var = new n.x0(1);
        return x.i.d(x.i.f(lVar, new n6.a(x0Var, 23), a6.a()));
    }

    public boolean f(CharSequence charSequence, int i3) {
        if (charSequence == null || i3 < 0 || charSequence.length() - i3 < 0) {
            throw new IllegalArgumentException();
        }
        if (((j1.f) this.f8757b) == null) {
            return d();
        }
        char c9 = 2;
        for (int i10 = 0; i10 < i3 && c9 == 2; i10++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i10));
            s0 s0Var = j1.g.f15177a;
            if (directionality != 0) {
                if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case 16:
                        case 17:
                            break;
                        default:
                            c9 = 2;
                            break;
                    }
                }
                c9 = 0;
            }
            c9 = 1;
        }
        if (c9 == 0) {
            return true;
        }
        if (c9 != 1) {
            return d();
        }
        return false;
    }

    public synchronized void g(z3.s sVar, boolean z5) {
        try {
            if (!this.f8756a && !z5) {
                this.f8756a = true;
                sVar.recycle();
                this.f8756a = false;
            }
            ((Handler) this.f8757b).obtainMessage(1, sVar).sendToTarget();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void h() {
        LinkedList linkedList = new LinkedList((List) this.f8757b);
        while (!linkedList.isEmpty()) {
            ob.a aVar = (ob.a) linkedList.poll();
            Objects.requireNonNull(aVar);
            aVar.cancel(true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s0(int i3) {
        this((Object) null, false);
        switch (i3) {
            case 1:
                break;
            case 8:
                this.f8757b = new Handler(Looper.getMainLooper(), new pe.g(1));
                break;
            default:
                this.f8756a = false;
                this.f8757b = new SpannableStringBuilder();
                break;
        }
    }

    public s0(boolean z5) {
        this.f8757b = Collections.synchronizedList(new ArrayList());
        this.f8756a = z5;
    }

    public s0(j1.f fVar, boolean z5) {
        this.f8757b = fVar;
        this.f8756a = z5;
    }
}
