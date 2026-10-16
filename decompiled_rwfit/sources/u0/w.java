package u0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public final class w implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final x f18780a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18781b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18782c;

    public w(Context context, x xVar, XmlResourceParser xmlResourceParser) {
        this.f18781b = -1;
        this.f18782c = 17;
        this.f18780a = xVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.OnClick);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.OnClick_targetId) {
                this.f18781b = obtainStyledAttributes.getResourceId(index, this.f18781b);
            } else if (index == R$styleable.OnClick_clickAction) {
                this.f18782c = obtainStyledAttributes.getInt(index, this.f18782c);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View] */
    public final void a(MotionLayout motionLayout, int i3, x xVar) {
        int i10 = this.f18781b;
        MotionLayout motionLayout2 = motionLayout;
        if (i10 != -1) {
            motionLayout2 = motionLayout.findViewById(i10);
        }
        if (motionLayout2 == null) {
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("OnClick could not find id ");
            sb2.append(i10);
            Log.e("MotionScene", sb2.toString());
            return;
        }
        int i11 = xVar.f18786d;
        int i12 = xVar.f18785c;
        if (i11 == -1) {
            motionLayout2.setOnClickListener(this);
            return;
        }
        int i13 = this.f18782c;
        int i14 = i13 & 1;
        if (((i14 != 0 && i3 == i11) | (i14 != 0 && i3 == i11) | ((i13 & 256) != 0 && i3 == i11) | ((i13 & 16) != 0 && i3 == i12)) || ((i13 & 4096) != 0 && i3 == i12)) {
            motionLayout2.setOnClickListener(this);
        }
    }

    public final void b(MotionLayout motionLayout) {
        int i3 = this.f18781b;
        if (i3 == -1) {
            return;
        }
        View findViewById = motionLayout.findViewById(i3);
        if (findViewById != null) {
            findViewById.setOnClickListener(null);
            return;
        }
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append(" (*)  could not find id ");
        sb2.append(i3);
        Log.e("MotionScene", sb2.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onClick(android.view.View r14) {
        /*
            r13 = this;
            u0.x r14 = r13.f18780a
            androidx.constraintlayout.motion.widget.c r0 = r14.f18791j
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.f1732a
            boolean r2 = r1.B
            if (r2 != 0) goto Lc
            goto Lb6
        Lc:
            int r2 = r14.f18786d
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = -1
            if (r2 != r5) goto L34
            int r2 = r1.getCurrentState()
            if (r2 != r5) goto L20
            int r14 = r14.f18785c
            r1.G(r14)
            return
        L20:
            u0.x r5 = new u0.x
            r5.<init>(r0, r14)
            r5.f18786d = r2
            int r14 = r14.f18785c
            r5.f18785c = r14
            r1.setTransition(r5)
            r1.q(r4)
            r1.f1705g1 = r3
            return
        L34:
            u0.x r0 = r0.f1734c
            int r2 = r13.f18782c
            r6 = r2 & 1
            r7 = 1
            r8 = 0
            if (r6 != 0) goto L45
            r9 = r2 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L43
            goto L45
        L43:
            r9 = r8
            goto L46
        L45:
            r9 = r7
        L46:
            r10 = r2 & 16
            if (r10 != 0) goto L50
            r11 = r2 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L4f
            goto L50
        L4f:
            r7 = r8
        L50:
            if (r9 == 0) goto L6f
            if (r7 == 0) goto L6f
            if (r0 == r14) goto L59
            r1.setTransition(r14)
        L59:
            int r11 = r1.getCurrentState()
            int r12 = r1.getEndState()
            if (r11 == r12) goto L70
            float r11 = r1.getProgress()
            r12 = 1056964608(0x3f000000, float:0.5)
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto L6e
            goto L70
        L6e:
            r7 = r8
        L6f:
            r8 = r9
        L70:
            if (r14 != r0) goto L73
            goto L84
        L73:
            int r0 = r14.f18785c
            int r9 = r14.f18786d
            if (r9 != r5) goto L7e
            int r5 = r1.f1723x
            if (r5 == r0) goto Lb6
            goto L84
        L7e:
            int r5 = r1.f1723x
            if (r5 == r9) goto L84
            if (r5 != r0) goto Lb6
        L84:
            if (r8 == 0) goto L91
            if (r6 == 0) goto L91
            r1.setTransition(r14)
            r1.q(r4)
            r1.f1705g1 = r3
            return
        L91:
            r0 = 0
            if (r7 == 0) goto L9d
            if (r10 == 0) goto L9d
            r1.setTransition(r14)
            r1.q(r0)
            return
        L9d:
            if (r8 == 0) goto Laa
            r3 = r2 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto Laa
            r1.setTransition(r14)
            r1.setProgress(r4)
            return
        Laa:
            if (r7 == 0) goto Lb6
            r2 = r2 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto Lb6
            r1.setTransition(r14)
            r1.setProgress(r0)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.w.onClick(android.view.View):void");
    }
}
