package androidx.viewpager2.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n1;

/* loaded from: classes.dex */
public final class e extends n1 {

    /* renamed from: a, reason: collision with root package name */
    public g f2973a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f2974b;

    /* renamed from: c, reason: collision with root package name */
    public final m f2975c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f2976d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f2977f;

    /* renamed from: g, reason: collision with root package name */
    public final d f2978g;

    /* renamed from: h, reason: collision with root package name */
    public int f2979h;

    /* renamed from: i, reason: collision with root package name */
    public int f2980i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2981j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2982k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2983l;

    public e(ViewPager2 viewPager2) {
        this.f2974b = viewPager2;
        m mVar = viewPager2.f2955j;
        this.f2975c = mVar;
        this.f2976d = (LinearLayoutManager) mVar.getLayoutManager();
        this.f2978g = new d();
        d();
    }

    @Override // androidx.recyclerview.widget.n1
    public final void a(int i3, RecyclerView recyclerView) {
        g gVar;
        g gVar2;
        int i10 = this.e;
        boolean z5 = true;
        if (!(i10 == 1 && this.f2977f == 1) && i3 == 1) {
            this.e = 1;
            int i11 = this.f2980i;
            if (i11 != -1) {
                this.f2979h = i11;
                this.f2980i = -1;
            } else if (this.f2979h == -1) {
                this.f2979h = this.f2976d.P0();
            }
            c(1);
            return;
        }
        if ((i10 == 1 || i10 == 4) && i3 == 2) {
            if (this.f2982k) {
                c(2);
                this.f2981j = true;
                return;
            }
            return;
        }
        if (i10 != 1 && i10 != 4) {
            z5 = false;
        }
        d dVar = this.f2978g;
        if (z5 && i3 == 0) {
            e();
            if (!this.f2982k) {
                int i12 = dVar.f2970a;
                if (i12 != -1 && (gVar2 = this.f2973a) != null) {
                    gVar2.b(i12, 0.0f, 0);
                }
            } else if (dVar.f2972c == 0) {
                int i13 = this.f2979h;
                int i14 = dVar.f2970a;
                if (i13 != i14 && (gVar = this.f2973a) != null) {
                    gVar.c(i14);
                }
            }
            c(0);
            d();
        }
        if (this.e == 2 && i3 == 0 && this.f2983l) {
            e();
            if (dVar.f2972c == 0) {
                int i15 = this.f2980i;
                int i16 = dVar.f2970a;
                if (i15 != i16) {
                    if (i16 == -1) {
                        i16 = 0;
                    }
                    g gVar3 = this.f2973a;
                    if (gVar3 != null) {
                        gVar3.c(i16);
                    }
                }
                c(0);
                d();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if ((r7 < 0) == (r5.f2974b.f2952g.F() == 1)) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // androidx.recyclerview.widget.n1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.f2982k = r6
            r5.e()
            boolean r0 = r5.f2981j
            androidx.viewpager2.widget.d r1 = r5.f2978g
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L40
            r5.f2981j = r3
            if (r8 > 0) goto L28
            if (r8 != 0) goto L30
            if (r7 >= 0) goto L18
            r7 = r6
            goto L19
        L18:
            r7 = r3
        L19:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.f2974b
            androidx.viewpager2.widget.i r8 = r8.f2952g
            int r8 = r8.F()
            if (r8 != r6) goto L25
            r8 = r6
            goto L26
        L25:
            r8 = r3
        L26:
            if (r7 != r8) goto L30
        L28:
            int r7 = r1.f2972c
            if (r7 == 0) goto L30
            int r7 = r1.f2970a
            int r7 = r7 + r6
            goto L32
        L30:
            int r7 = r1.f2970a
        L32:
            r5.f2980i = r7
            int r8 = r5.f2979h
            if (r8 == r7) goto L50
            androidx.viewpager2.widget.g r8 = r5.f2973a
            if (r8 == 0) goto L50
            r8.c(r7)
            goto L50
        L40:
            int r7 = r5.e
            if (r7 != 0) goto L50
            int r7 = r1.f2970a
            if (r7 != r2) goto L49
            r7 = r3
        L49:
            androidx.viewpager2.widget.g r8 = r5.f2973a
            if (r8 == 0) goto L50
            r8.c(r7)
        L50:
            int r7 = r1.f2970a
            if (r7 != r2) goto L55
            r7 = r3
        L55:
            float r8 = r1.f2971b
            int r0 = r1.f2972c
            androidx.viewpager2.widget.g r4 = r5.f2973a
            if (r4 == 0) goto L60
            r4.b(r7, r8, r0)
        L60:
            int r7 = r1.f2970a
            int r8 = r5.f2980i
            if (r7 == r8) goto L68
            if (r8 != r2) goto L76
        L68:
            int r7 = r1.f2972c
            if (r7 != 0) goto L76
            int r7 = r5.f2977f
            if (r7 == r6) goto L76
            r5.c(r3)
            r5.d()
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void c(int i3) {
        if ((this.e == 3 && this.f2977f == 0) || this.f2977f == i3) {
            return;
        }
        this.f2977f = i3;
        g gVar = this.f2973a;
        if (gVar != null) {
            gVar.a(i3);
        }
    }

    public final void d() {
        this.e = 0;
        this.f2977f = 0;
        d dVar = this.f2978g;
        dVar.f2970a = -1;
        dVar.f2971b = 0.0f;
        dVar.f2972c = 0;
        this.f2979h = -1;
        this.f2980i = -1;
        this.f2981j = false;
        this.f2982k = false;
        this.f2983l = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0138, code lost:
    
        r1 = r0.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013c, code lost:
    
        if (r3 >= r1) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0146, code lost:
    
        if (androidx.viewpager2.widget.b.a(r0.u(r3)) != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0148, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0152, code lost:
    
        throw new java.lang.IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0153, code lost:
    
        r1 = java.util.Locale.US;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
    
        throw new java.lang.IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(r2.f2972c, "Page can only be offset by a positive amount, not by "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012f, code lost:
    
        if (r5[r1 - 1][1] >= r6) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0136, code lost:
    
        if (r0.v() <= 1) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.e():void");
    }
}
