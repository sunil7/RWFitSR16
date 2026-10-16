package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class i {
    public static void a(ArrayList arrayList) {
        HashMap hashMap = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            pb.a aVar = (pb.a) obj;
            pb.g gVar = new pb.g(aVar);
            for (Class cls : aVar.f17498a) {
                boolean z5 = aVar.f17500c == 0;
                pb.h hVar = new pb.h(cls, !z5);
                if (!hashMap.containsKey(hVar)) {
                    hashMap.put(hVar, new HashSet());
                }
                Set set = (Set) hashMap.get(hVar);
                if (!set.isEmpty() && z5) {
                    throw new IllegalArgumentException("Multiple components provide " + cls + ".");
                }
                set.add(gVar);
            }
        }
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            for (pb.g gVar2 : (Set) it.next()) {
                for (pb.i iVar : gVar2.f17511a.f17499b) {
                    if (iVar.f17518c == 0) {
                        Set<pb.g> set2 = (Set) hashMap.get(new pb.h(iVar.f17516a, iVar.f17517b == 2));
                        if (set2 != null) {
                            for (pb.g gVar3 : set2) {
                                gVar2.f17512b.add(gVar3);
                                gVar3.f17513c.add(gVar2);
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = hashMap.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            pb.g gVar4 = (pb.g) it3.next();
            if (gVar4.f17513c.isEmpty()) {
                hashSet2.add(gVar4);
            }
        }
        while (!hashSet2.isEmpty()) {
            pb.g gVar5 = (pb.g) hashSet2.iterator().next();
            hashSet2.remove(gVar5);
            i3++;
            Iterator it4 = gVar5.f17512b.iterator();
            while (it4.hasNext()) {
                pb.g gVar6 = (pb.g) it4.next();
                gVar6.f17513c.remove(gVar5);
                if (gVar6.f17513c.isEmpty()) {
                    hashSet2.add(gVar6);
                }
            }
        }
        if (i3 == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            pb.g gVar7 = (pb.g) it5.next();
            if (!gVar7.f17513c.isEmpty() && !gVar7.f17512b.isEmpty()) {
                arrayList2.add(gVar7.f17511a);
            }
        }
        throw new DependencyCycleException(arrayList2);
    }
}
