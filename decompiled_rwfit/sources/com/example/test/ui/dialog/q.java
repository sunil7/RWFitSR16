package com.example.test.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$style;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class q extends Dialog implements View.OnClickListener {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f8011k = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f8012a;

    /* renamed from: b, reason: collision with root package name */
    public int f8013b;

    /* renamed from: c, reason: collision with root package name */
    public int f8014c;

    /* renamed from: d, reason: collision with root package name */
    public t6.d f8015d;
    public final eh.b e;

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f8016f;

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f8017g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f8018h;

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f8019i;

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f8020j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(final Context context) {
        super(context, R$style.bottom_dialog);
        kotlin.jvm.internal.e.f(context, "context");
        this.f8012a = -1;
        this.f8013b = -1;
        this.f8014c = -1;
        setContentView(R$layout.dialog_select_single);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        this.e = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.dialog.TimeDialog$timeFont$2
            @Override // oh.a
            public final List<String> invoke() {
                ArrayList arrayList = new ArrayList();
                arrayList.add("AM");
                arrayList.add("PM");
                return arrayList;
            }
        });
        this.f8016f = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.dialog.TimeDialog$hours$2
            {
                super(0);
            }

            @Override // oh.a
            public final List<List<String>> invoke() {
                ArrayList arrayList = new ArrayList();
                q qVar = q.this;
                int i3 = q.f8011k;
                int size = ((List) qVar.e.getValue()).size();
                for (int i10 = 0; i10 < size; i10++) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i11 = 1; i11 < 13; i11++) {
                        arrayList2.add(String.valueOf(i11));
                    }
                    arrayList.add(arrayList2);
                }
                return arrayList;
            }
        });
        this.f8017g = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.dialog.TimeDialog$hours24$2
            @Override // oh.a
            public final List<String> invoke() {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < 24; i3++) {
                    arrayList.add(String.valueOf(i3));
                }
                return arrayList;
            }
        });
        this.f8018h = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.dialog.TimeDialog$mins24$2
            {
                super(0);
            }

            @Override // oh.a
            public final List<List<String>> invoke() {
                ArrayList arrayList = new ArrayList();
                q qVar = q.this;
                int i3 = q.f8011k;
                int size = ((List) qVar.f8017g.getValue()).size();
                for (int i10 = 0; i10 < size; i10++) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i11 = 0; i11 < 60; i11++) {
                        arrayList2.add(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i11)}, 1)));
                    }
                    arrayList.add(arrayList2);
                }
                return arrayList;
            }
        });
        this.f8019i = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.dialog.TimeDialog$mins$2
            {
                super(0);
            }

            @Override // oh.a
            public final List<List<List<String>>> invoke() {
                ArrayList arrayList = new ArrayList();
                q qVar = q.this;
                int i3 = q.f8011k;
                int size = ((List) qVar.e.getValue()).size();
                q qVar2 = q.this;
                for (int i10 = 0; i10 < size; i10++) {
                    ArrayList arrayList2 = new ArrayList();
                    int size2 = ((List) ((List) qVar2.f8016f.getValue()).get(0)).size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        ArrayList arrayList3 = new ArrayList();
                        for (int i12 = 0; i12 < 60; i12++) {
                            arrayList3.add(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i12)}, 1)));
                        }
                        arrayList2.add(arrayList3);
                    }
                    arrayList.add(arrayList2);
                }
                return arrayList;
            }
        });
        this.f8020j = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.dialog.TimeDialog$opTime$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
            @Override // oh.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final s3.d invoke() {
                /*
                    r6 = this;
                    com.example.test.utils.k r0 = com.example.test.utils.k.f8731b
                    if (r0 != 0) goto L13
                    java.lang.Class<com.example.test.utils.k> r0 = com.example.test.utils.k.class
                    monitor-enter(r0)
                    com.example.test.utils.k r1 = new com.example.test.utils.k     // Catch: java.lang.Throwable -> L10
                    r1.<init>()     // Catch: java.lang.Throwable -> L10
                    com.example.test.utils.k.f8731b = r1     // Catch: java.lang.Throwable -> L10
                    monitor-exit(r0)
                    goto L13
                L10:
                    r1 = move-exception
                    monitor-exit(r0)
                    throw r1
                L13:
                    com.example.test.utils.k r0 = com.example.test.utils.k.f8731b
                    if (r0 == 0) goto L20
                    int r0 = r0.x()
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    goto L21
                L20:
                    r0 = 0
                L21:
                    if (r0 == 0) goto L4c
                    r1 = 1
                    int r0 = r0.intValue()
                    if (r0 != r1) goto L4c
                    com.example.test.utils.k r0 = com.example.test.utils.k.f8731b
                    if (r0 != 0) goto L3d
                    java.lang.Class<com.example.test.utils.k> r0 = com.example.test.utils.k.class
                    monitor-enter(r0)
                    com.example.test.utils.k r1 = new com.example.test.utils.k     // Catch: java.lang.Throwable -> L3a
                    r1.<init>()     // Catch: java.lang.Throwable -> L3a
                    com.example.test.utils.k.f8731b = r1     // Catch: java.lang.Throwable -> L3a
                    monitor-exit(r0)
                    goto L3d
                L3a:
                    r1 = move-exception
                    monitor-exit(r0)
                    throw r1
                L3d:
                    com.example.test.utils.k r0 = com.example.test.utils.k.f8731b
                    kotlin.jvm.internal.e.c(r0)
                    int r0 = r0.D()
                    if (r0 == 0) goto L4c
                    r0 = 17170444(0x106000c, float:2.4611947E-38)
                    goto L4f
                L4c:
                    r0 = 17170443(0x106000b, float:2.4611944E-38)
                L4f:
                    p3.a r1 = new p3.a
                    android.content.Context r2 = r1
                    com.example.test.ui.dialog.q r3 = r2
                    c0.b r4 = new c0.b
                    r5 = 2
                    r4.<init>(r5, r2, r3)
                    r1.<init>(r2, r4)
                    android.content.Context r2 = r1
                    android.content.res.Resources r2 = r2.getResources()
                    if (r2 == 0) goto L6b
                    int r0 = r2.getColor(r0)
                    goto L6e
                L6b:
                    r0 = -16711681(0xffffffffff00ffff, float:-1.714704E38)
                L6e:
                    q3.a r2 = r1.f17450a
                    r2.f17768v = r0
                    android.content.Context r0 = r1
                    android.content.res.Resources r0 = r0.getResources()
                    if (r0 == 0) goto L81
                    int r2 = com.example.test.R$color.color_3cfff
                    int r0 = r0.getColor(r2)
                    goto L84
                L81:
                    r0 = -7829368(0xffffffffff888888, float:NaN)
                L84:
                    q3.a r2 = r1.f17450a
                    r2.f17769w = r0
                    com.example.test.ui.dialog.q r0 = r2
                    int r2 = com.example.test.R$id.decor
                    android.view.View r0 = r0.findViewById(r2)
                    android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                    q3.a r2 = r1.f17450a
                    r2.r = r0
                    r0 = 0
                    r2.f17766t = r0
                    r0 = 1072064102(0x3fe66666, float:1.8)
                    r2.f17770x = r0
                    int r0 = com.example.test.R$layout.view_single_select
                    b9.a r2 = new b9.a
                    r3 = 3
                    r2.<init>(r3)
                    r1.b(r0, r2)
                    s3.d r0 = r1.a()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.dialog.TimeDialog$opTime$2.invoke():s3.d");
            }
        });
    }

    public final s3.d a() {
        return (s3.d) this.f8020j.getValue();
    }

    public final void b(int i3, int i10, int i11) {
        this.f8012a = i3;
        this.f8013b = i10;
        this.f8014c = i11;
        Context context = getContext();
        kotlin.jvm.internal.e.e(context, "getContext(...)");
        if (DateFormat.is24HourFormat(context)) {
            a().f((List) this.f8017g.getValue(), (List) this.f8018h.getValue(), null);
            s3.d a3 = a();
            q3.a aVar = a3.e;
            aVar.f17752d = i10;
            aVar.e = i11;
            a3.e();
            a().d();
            return;
        }
        a().f((List) this.e.getValue(), (List) this.f8016f.getValue(), (List) this.f8019i.getValue());
        s3.d a10 = a();
        q3.a aVar2 = a10.e;
        aVar2.f17752d = i3;
        aVar2.e = i10;
        aVar2.f17753f = i11;
        a10.e();
        a().d();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tvSure;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            t6.d dVar = this.f8015d;
            if (dVar != null) {
                dVar.h(this.f8012a, this.f8013b, this.f8014c);
            }
            t6.d dVar2 = this.f8015d;
            if (dVar2 != null) {
                dVar2.y();
                return;
            }
            return;
        }
        int i10 = R$id.tvCancel;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
            t6.d dVar3 = this.f8015d;
            if (dVar3 != null) {
                dVar3.y();
            }
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = (TextView) findViewById(R$id.tvCancel);
        TextView textView2 = (TextView) findViewById(R$id.tvSure);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    public final void setOnDialogTimeSelectListener(t6.d onDialogTimeSelectListener) {
        kotlin.jvm.internal.e.f(onDialogTimeSelectListener, "onDialogTimeSelectListener");
        this.f8015d = onDialogTimeSelectListener;
    }
}
