package com.tencent.open.c;

import android.content.Context;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class c extends FrameLayout {
    public c(Context context) {
        super(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        r5 = r5.getDisplayCutout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        r0 = r5.getBoundingRects();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.view.WindowInsets r5) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L7
            goto L42
        L7:
            if (r5 != 0) goto La
            goto L42
        La:
            android.view.DisplayCutout r5 = l1.r1.c(r5)
            if (r5 != 0) goto L11
            goto L42
        L11:
            java.util.List r0 = l1.r1.g(r5)
            if (r0 == 0) goto L42
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L1e
            goto L42
        L1e:
            int r0 = androidx.emoji2.text.v.y(r5)
            r1 = 0
            int r0 = java.lang.Math.max(r0, r1)
            int r2 = androidx.emoji2.text.v.b(r5)
            int r2 = java.lang.Math.max(r2, r1)
            int r3 = androidx.emoji2.text.v.B(r5)
            int r3 = java.lang.Math.max(r3, r1)
            int r5 = l1.r1.a(r5)
            int r5 = java.lang.Math.max(r5, r1)
            r4.setPadding(r0, r2, r3, r5)
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.c.c.a(android.view.WindowInsets):void");
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        a(windowInsets);
        return super.onApplyWindowInsets(windowInsets);
    }
}
