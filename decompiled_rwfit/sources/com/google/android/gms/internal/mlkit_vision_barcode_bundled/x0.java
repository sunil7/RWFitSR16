package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class x0 implements z0 {

    /* renamed from: b, reason: collision with root package name */
    public static final g0 f9839b = new g0(3);

    /* renamed from: a, reason: collision with root package name */
    public final Object f9840a;

    public x0(z0... z0VarArr) {
        this.f9840a = z0VarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.z0
    public i1 a(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            z0 z0Var = ((z0[]) this.f9840a)[i3];
            if (z0Var.b(cls)) {
                return z0Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.z0
    public boolean b(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            if (((z0[]) this.f9840a)[i3].b(cls)) {
                return true;
            }
        }
        return false;
    }

    public void c(zzdf zzdfVar) {
        zzdf zzdfVar2;
        zzdf zzdfVar3;
        if (!zzdfVar.zzh()) {
            if (!(zzdfVar instanceof zzgd)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzdfVar.getClass())));
            }
            zzgd zzgdVar = (zzgd) zzdfVar;
            zzdfVar2 = zzgdVar.zzd;
            c(zzdfVar2);
            zzdfVar3 = zzgdVar.zze;
            c(zzdfVar3);
            return;
        }
        int binarySearch = Arrays.binarySearch(zzgd.zza, zzdfVar.zzd());
        if (binarySearch < 0) {
            binarySearch = (-(binarySearch + 1)) - 1;
        }
        ArrayDeque arrayDeque = (ArrayDeque) this.f9840a;
        int zzc = zzgd.zzc(binarySearch + 1);
        if (arrayDeque.isEmpty() || ((zzdf) arrayDeque.peek()).zzd() >= zzc) {
            arrayDeque.push(zzdfVar);
            return;
        }
        int zzc2 = zzgd.zzc(binarySearch);
        zzdf zzdfVar4 = (zzdf) arrayDeque.pop();
        while (true) {
            if (arrayDeque.isEmpty() || ((zzdf) arrayDeque.peek()).zzd() >= zzc2) {
                break;
            } else {
                zzdfVar4 = new zzgd((zzdf) arrayDeque.pop(), zzdfVar4);
            }
        }
        zzgd zzgdVar2 = new zzgd(zzdfVar4, zzdfVar);
        while (!arrayDeque.isEmpty()) {
            int binarySearch2 = Arrays.binarySearch(zzgd.zza, zzgdVar2.zzd());
            if (binarySearch2 < 0) {
                binarySearch2 = (-(binarySearch2 + 1)) - 1;
            }
            if (((zzdf) arrayDeque.peek()).zzd() >= zzgd.zzc(binarySearch2 + 1)) {
                break;
            } else {
                zzgdVar2 = new zzgd((zzdf) arrayDeque.pop(), zzgdVar2);
            }
        }
        arrayDeque.push(zzgdVar2);
    }

    public void d(int i3, Object obj, m1 m1Var) {
        z zVar = (z) this.f9840a;
        zVar.m(i3, 3);
        m1Var.i((a1) obj, zVar.f9851a);
        zVar.m(i3, 4);
    }

    public void e(int i3, Object obj, m1 m1Var) {
        a1 a1Var = (a1) obj;
        z zVar = (z) this.f9840a;
        zVar.o((i3 << 3) | 2);
        zVar.o(((p) a1Var).b(m1Var));
        m1Var.i(a1Var, zVar.f9851a);
    }

    public x0(int i3) {
        switch (i3) {
            case 1:
                this.f9840a = new ArrayDeque();
                break;
            default:
                g1 g1Var = g1.f9786c;
                x0 x0Var = new x0(g0.f9784b, f9839b);
                Charset charset = s0.f9827a;
                this.f9840a = x0Var;
                break;
        }
    }

    public x0(z zVar) {
        Charset charset = s0.f9827a;
        this.f9840a = zVar;
        zVar.f9851a = this;
    }
}
