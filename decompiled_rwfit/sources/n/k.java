package n;

import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.y1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16235a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16236b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16237c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f16238d;
    public final /* synthetic */ Object e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f16239f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f16240g;

    public /* synthetic */ k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i3) {
        this.f16235a = i3;
        this.f16236b = obj;
        this.f16237c = obj2;
        this.f16238d = obj3;
        this.e = obj4;
        this.f16239f = obj5;
        this.f16240g = obj6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16235a) {
            case 0:
                androidx.camera.camera2.internal.i iVar = (androidx.camera.camera2.internal.i) this.f16236b;
                iVar.getClass();
                StringBuilder sb2 = new StringBuilder("Use case ");
                String str = (String) this.f16237c;
                sb2.append(str);
                sb2.append(" UPDATED");
                iVar.s(sb2.toString(), null);
                iVar.f1238a.J(str, (s1) this.f16238d, (a2) this.e, (androidx.camera.core.impl.h) this.f16239f, (ArrayList) this.f16240g);
                iVar.J();
                break;
            case 1:
                androidx.camera.camera2.internal.i iVar2 = (androidx.camera.camera2.internal.i) this.f16236b;
                iVar2.getClass();
                StringBuilder sb3 = new StringBuilder("Use case ");
                String str2 = (String) this.f16237c;
                sb3.append(str2);
                sb3.append(" ACTIVE");
                iVar2.s(sb3.toString(), null);
                LinkedHashMap linkedHashMap = (LinkedHashMap) iVar2.f1238a.f8774c;
                y1 y1Var = (y1) linkedHashMap.get(str2);
                s1 s1Var = (s1) this.f16238d;
                a2 a2Var = (a2) this.e;
                androidx.camera.core.impl.h hVar = (androidx.camera.core.impl.h) this.f16239f;
                ArrayList arrayList = (ArrayList) this.f16240g;
                if (y1Var == null) {
                    y1Var = new y1(s1Var, a2Var, hVar, arrayList);
                    linkedHashMap.put(str2, y1Var);
                }
                y1Var.f1533f = true;
                iVar2.f1238a.J(str2, s1Var, a2Var, hVar, arrayList);
                iVar2.J();
                break;
            default:
                ((androidx.camera.core.impl.e) this.f16236b).c((androidx.camera.core.impl.v) this.f16237c, (androidx.camera.core.impl.v) this.f16238d, (c0.n) this.e, (c0.n) this.f16239f, (Map.Entry) this.f16240g);
                break;
        }
    }
}
