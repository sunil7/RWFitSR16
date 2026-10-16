package fd;

import androidx.recyclerview.widget.j2;
import ef.i;

/* loaded from: classes.dex */
public final class d extends i {
    public final boolean e;

    public d(b bVar, boolean z5) {
        super(bVar);
        this.e = z5;
    }

    public final j2 Q() {
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        a aVar4 = new a();
        j2[] j2VarArr = (j2[]) this.f12630c;
        for (j2 j2Var : j2VarArr) {
            if (j2Var != null) {
                j2Var.c();
                int i3 = j2Var.e % 30;
                int i10 = j2Var.f2641f;
                if (!this.e) {
                    i10 += 2;
                }
                int i11 = i10 % 3;
                if (i11 == 0) {
                    aVar2.b((i3 * 3) + 1);
                } else if (i11 == 1) {
                    aVar4.b(i3 / 3);
                    aVar3.b(i3 % 3);
                } else if (i11 == 2) {
                    aVar.b(i3 + 1);
                }
            }
        }
        if (aVar.a().length == 0 || aVar2.a().length == 0 || aVar3.a().length == 0 || aVar4.a().length == 0 || aVar.a()[0] < 1 || aVar2.a()[0] + aVar3.a()[0] < 3 || aVar2.a()[0] + aVar3.a()[0] > 90) {
            return null;
        }
        j2 j2Var2 = new j2(aVar.a()[0], aVar2.a()[0], aVar3.a()[0], aVar4.a()[0], 1);
        R(j2VarArr, j2Var2);
        return j2Var2;
    }

    public final void R(j2[] j2VarArr, j2 j2Var) {
        for (int i3 = 0; i3 < j2VarArr.length; i3++) {
            j2 j2Var2 = j2VarArr[i3];
            if (j2Var2 != null) {
                int i10 = j2Var2.e % 30;
                int i11 = j2Var2.f2641f;
                if (i11 > j2Var.f2641f) {
                    j2VarArr[i3] = null;
                } else {
                    if (!this.e) {
                        i11 += 2;
                    }
                    int i12 = i11 % 3;
                    if (i12 != 0) {
                        if (i12 != 1) {
                            if (i12 == 2 && i10 + 1 != j2Var.f2638b) {
                                j2VarArr[i3] = null;
                            }
                        } else if (i10 / 3 != j2Var.f2639c || i10 % 3 != j2Var.e) {
                            j2VarArr[i3] = null;
                        }
                    } else if ((i10 * 3) + 1 != j2Var.f2640d) {
                        j2VarArr[i3] = null;
                    }
                }
            }
        }
    }

    @Override // ef.i
    public final String toString() {
        return "IsLeft: " + this.e + '\n' + super.toString();
    }
}
