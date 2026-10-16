package ue;

import com.liulishuo.filedownloader.message.MessageSnapshot;
import ia.j;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public volatile o4.e f19066a;

    /* renamed from: b, reason: collision with root package name */
    public volatile d f19067b;

    public final void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof a) {
            if (this.f19067b != null) {
                this.f19067b.g(messageSnapshot);
                return;
            }
            return;
        }
        if (this.f19066a != null) {
            o4.e eVar = this.f19066a;
            eVar.getClass();
            f fVar = null;
            try {
                synchronized (((ArrayList) eVar.f16737a)) {
                    try {
                        int h4 = messageSnapshot.h();
                        ArrayList arrayList = (ArrayList) eVar.f16737a;
                        int size = arrayList.size();
                        int i3 = 0;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size) {
                                break;
                            }
                            Object obj = arrayList.get(i10);
                            i10++;
                            f fVar2 = (f) obj;
                            if (fVar2.f19068a.contains(Integer.valueOf(h4))) {
                                fVar = fVar2;
                                break;
                            }
                        }
                        if (fVar == null) {
                            ArrayList arrayList2 = (ArrayList) eVar.f16737a;
                            int size2 = arrayList2.size();
                            int i11 = 0;
                            while (true) {
                                if (i11 >= size2) {
                                    break;
                                }
                                Object obj2 = arrayList2.get(i11);
                                i11++;
                                f fVar3 = (f) obj2;
                                if (fVar3.f19068a.size() <= 0) {
                                    fVar = fVar3;
                                    break;
                                } else if (i3 == 0 || fVar3.f19068a.size() < i3) {
                                    i3 = fVar3.f19068a.size();
                                    fVar = fVar3;
                                }
                            }
                        }
                        fVar.f19068a.add(Integer.valueOf(h4));
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } finally {
                fVar.f19069b.execute(new j(18, fVar, messageSnapshot));
            }
        }
    }
}
