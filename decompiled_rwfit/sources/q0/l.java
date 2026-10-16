package q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class l extends f {

    /* renamed from: s0, reason: collision with root package name */
    public f[] f17720s0 = new f[4];

    /* renamed from: t0, reason: collision with root package name */
    public int f17721t0 = 0;

    public final void N(f fVar) {
        if (fVar == this || fVar == null) {
            return;
        }
        int i3 = this.f17721t0 + 1;
        f[] fVarArr = this.f17720s0;
        if (i3 > fVarArr.length) {
            this.f17720s0 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
        }
        f[] fVarArr2 = this.f17720s0;
        int i10 = this.f17721t0;
        fVarArr2[i10] = fVar;
        this.f17721t0 = i10 + 1;
    }

    public final void O(int i3, ArrayList arrayList, r0.i iVar) {
        for (int i10 = 0; i10 < this.f17721t0; i10++) {
            f fVar = this.f17720s0[i10];
            ArrayList arrayList2 = iVar.f17980a;
            if (!arrayList2.contains(fVar)) {
                arrayList2.add(fVar);
            }
        }
        for (int i11 = 0; i11 < this.f17721t0; i11++) {
            r0.f.b(this.f17720s0[i11], i3, arrayList, iVar);
        }
    }

    public void P() {
    }

    @Override // q0.f
    public void g(f fVar, HashMap hashMap) {
        super.g(fVar, hashMap);
        l lVar = (l) fVar;
        this.f17721t0 = 0;
        int i3 = lVar.f17721t0;
        for (int i10 = 0; i10 < i3; i10++) {
            N((f) hashMap.get(lVar.f17720s0[i10]));
        }
    }
}
