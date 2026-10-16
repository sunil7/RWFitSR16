package androidx.appcompat.widget;

import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.be;

/* loaded from: classes.dex */
public final class w3 extends be {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1079a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1080b;

    /* renamed from: c, reason: collision with root package name */
    public int f1081c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1082d;

    public w3(x3 x3Var, int i3) {
        this.f1079a = 0;
        this.f1082d = x3Var;
        this.f1081c = i3;
        this.f1080b = false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.be, l1.h1
    public void a(View view) {
        switch (this.f1079a) {
            case 0:
                this.f1080b = true;
                break;
        }
    }

    @Override // l1.h1
    public final void onAnimationEnd() {
        switch (this.f1079a) {
            case 0:
                if (!this.f1080b) {
                    ((x3) this.f1082d).f1109a.setVisibility(this.f1081c);
                    break;
                }
                break;
            default:
                int i3 = this.f1081c + 1;
                this.f1081c = i3;
                g.j jVar = (g.j) this.f1082d;
                if (i3 == jVar.f13735a.size()) {
                    be beVar = jVar.f13738d;
                    if (beVar != null) {
                        beVar.onAnimationEnd();
                    }
                    this.f1081c = 0;
                    this.f1080b = false;
                    jVar.e = false;
                    break;
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.be, l1.h1
    public final void onAnimationStart() {
        switch (this.f1079a) {
            case 0:
                ((x3) this.f1082d).f1109a.setVisibility(0);
                break;
            default:
                if (!this.f1080b) {
                    this.f1080b = true;
                    be beVar = ((g.j) this.f1082d).f13738d;
                    if (beVar != null) {
                        beVar.onAnimationStart();
                        break;
                    }
                }
                break;
        }
    }

    public w3(g.j jVar) {
        this.f1079a = 1;
        this.f1082d = jVar;
        this.f1080b = false;
        this.f1081c = 0;
    }
}
