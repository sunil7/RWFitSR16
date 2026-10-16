package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2675a;

    /* renamed from: b, reason: collision with root package name */
    public int f2676b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2677c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2678d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2679f;

    public n0(int i3) {
        this.f2675a = i3;
        switch (i3) {
            case 1:
                this.f2676b = 0;
                this.f2677c = false;
                this.e = 3000;
                break;
            default:
                d();
                break;
        }
    }

    public void a() {
        this.e = this.f2677c ? ((androidx.emoji2.text.g) this.f2679f).j() : ((androidx.emoji2.text.g) this.f2679f).n();
    }

    public void b(int i3, View view) {
        if (this.f2677c) {
            int e = ((androidx.emoji2.text.g) this.f2679f).e(view);
            androidx.emoji2.text.g gVar = (androidx.emoji2.text.g) this.f2679f;
            this.e = (Integer.MIN_VALUE == gVar.f2029a ? 0 : gVar.o() - gVar.f2029a) + e;
        } else {
            this.e = ((androidx.emoji2.text.g) this.f2679f).h(view);
        }
        this.f2676b = i3;
    }

    public void c(int i3, View view) {
        androidx.emoji2.text.g gVar = (androidx.emoji2.text.g) this.f2679f;
        int o3 = Integer.MIN_VALUE == gVar.f2029a ? 0 : gVar.o() - gVar.f2029a;
        if (o3 >= 0) {
            b(i3, view);
            return;
        }
        this.f2676b = i3;
        if (!this.f2677c) {
            int h4 = ((androidx.emoji2.text.g) this.f2679f).h(view);
            int n4 = h4 - ((androidx.emoji2.text.g) this.f2679f).n();
            this.e = h4;
            if (n4 > 0) {
                int j4 = (((androidx.emoji2.text.g) this.f2679f).j() - Math.min(0, (((androidx.emoji2.text.g) this.f2679f).j() - o3) - ((androidx.emoji2.text.g) this.f2679f).e(view))) - (((androidx.emoji2.text.g) this.f2679f).f(view) + h4);
                if (j4 < 0) {
                    this.e -= Math.min(n4, -j4);
                    return;
                }
                return;
            }
            return;
        }
        int j10 = (((androidx.emoji2.text.g) this.f2679f).j() - o3) - ((androidx.emoji2.text.g) this.f2679f).e(view);
        this.e = ((androidx.emoji2.text.g) this.f2679f).j() - j10;
        if (j10 > 0) {
            int f2 = this.e - ((androidx.emoji2.text.g) this.f2679f).f(view);
            int n8 = ((androidx.emoji2.text.g) this.f2679f).n();
            int min = f2 - (Math.min(((androidx.emoji2.text.g) this.f2679f).h(view) - n8, 0) + n8);
            if (min < 0) {
                this.e = Math.min(j10, -min) + this.e;
            }
        }
    }

    public void d() {
        this.f2676b = -1;
        this.e = Integer.MIN_VALUE;
        this.f2677c = false;
        this.f2678d = false;
    }

    public final String toString() {
        switch (this.f2675a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("AnchorInfo{mPosition=");
                sb2.append(this.f2676b);
                sb2.append(", mCoordinate=");
                sb2.append(this.e);
                sb2.append(", mLayoutFromEnd=");
                sb2.append(this.f2677c);
                sb2.append(", mValid=");
                return android.support.v4.media.session.e.o(sb2, this.f2678d, '}');
            default:
                StringBuilder sb3 = new StringBuilder("BluetoothOTAConfigure{priority=");
                sb3.append(this.f2676b);
                sb3.append(", isUseReconnect=");
                sb3.append(this.f2677c);
                sb3.append(", isUseAuthDevice=");
                sb3.append(this.f2678d);
                sb3.append(", bleIntervalMs=500, timeoutMs=");
                sb3.append(this.e);
                sb3.append(", isUseJLServer=false, firmwareFilePath='");
                return r5.a.f(sb3, (String) this.f2679f, "', scanFilterData='null', mtu=20, isNeedChangeMtu=false, bleScanMode=0, firmwareFileData= 0, snGenerator=null, isPriorityCallbackOtaFinish=false}");
        }
    }
}
