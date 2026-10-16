package androidx.appcompat.widget;

import android.view.View;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements l1.h1 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f867b;

    /* renamed from: c, reason: collision with root package name */
    public Object f868c = new Object[4];

    /* renamed from: a, reason: collision with root package name */
    public int f866a = 0;

    @Override // l1.h1
    public void a(View view) {
        this.f867b = true;
    }

    public void b(Object obj) {
        obj.getClass();
        c(this.f866a + 1);
        Object[] objArr = (Object[]) this.f868c;
        int i3 = this.f866a;
        this.f866a = i3 + 1;
        objArr[i3] = obj;
    }

    public void c(int i3) {
        Object[] objArr = (Object[]) this.f868c;
        int length = objArr.length;
        if (length >= i3) {
            if (this.f867b) {
                this.f868c = (Object[]) objArr.clone();
                this.f867b = false;
                return;
            }
            return;
        }
        int i10 = length + (length >> 1) + 1;
        if (i10 < i3) {
            int highestOneBit = Integer.highestOneBit(i3 - 1);
            i10 = highestOneBit + highestOneBit;
        }
        if (i10 < 0) {
            i10 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        this.f868c = Arrays.copyOf(objArr, i10);
        this.f867b = false;
    }

    public zzcs d() {
        this.f867b = true;
        return zzcs.zzg((Object[]) this.f868c, this.f866a);
    }

    @Override // l1.h1
    public void onAnimationEnd() {
        if (this.f867b) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f868c;
        actionBarContextView.f619f = null;
        super/*android.view.View*/.setVisibility(this.f866a);
    }

    @Override // l1.h1
    public void onAnimationStart() {
        super/*android.view.View*/.setVisibility(0);
        this.f867b = false;
    }
}
