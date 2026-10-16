package r0;

import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.HashSet;
import q0.k;
import q0.l;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public q0.g f17969a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17970b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17971c;

    /* renamed from: d, reason: collision with root package name */
    public q0.g f17972d;
    public ArrayList e;

    /* renamed from: f, reason: collision with root package name */
    public w0.f f17973f;

    /* renamed from: g, reason: collision with root package name */
    public b f17974g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f17975h;

    public final void a(androidx.constraintlayout.core.widgets.analyzer.a aVar, int i3, ArrayList arrayList, h hVar) {
        androidx.constraintlayout.core.widgets.analyzer.h hVar2 = aVar.f1617d;
        if (hVar2.f1633c == null) {
            q0.g gVar = this.f17969a;
            if (hVar2 == gVar.f17650d || hVar2 == gVar.e) {
                return;
            }
            if (hVar == null) {
                hVar = new h();
                hVar.f17977a = null;
                hVar.f17978b = new ArrayList();
                hVar.f17977a = hVar2;
                arrayList.add(hVar);
            }
            hVar2.f1633c = hVar;
            hVar.f17978b.add(hVar2);
            androidx.constraintlayout.core.widgets.analyzer.a aVar2 = hVar2.f1637h;
            ArrayList arrayList2 = aVar2.f1623k;
            int size = arrayList2.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                d dVar = (d) obj;
                if (dVar instanceof androidx.constraintlayout.core.widgets.analyzer.a) {
                    a((androidx.constraintlayout.core.widgets.analyzer.a) dVar, i3, arrayList, hVar);
                }
            }
            androidx.constraintlayout.core.widgets.analyzer.a aVar3 = hVar2.f1638i;
            ArrayList arrayList3 = aVar3.f1623k;
            int size2 = arrayList3.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj2 = arrayList3.get(i12);
                i12++;
                d dVar2 = (d) obj2;
                if (dVar2 instanceof androidx.constraintlayout.core.widgets.analyzer.a) {
                    a((androidx.constraintlayout.core.widgets.analyzer.a) dVar2, i3, arrayList, hVar);
                }
            }
            if (i3 == 1 && (hVar2 instanceof androidx.constraintlayout.core.widgets.analyzer.g)) {
                ArrayList arrayList4 = ((androidx.constraintlayout.core.widgets.analyzer.g) hVar2).f1629k.f1623k;
                int size3 = arrayList4.size();
                int i13 = 0;
                while (i13 < size3) {
                    Object obj3 = arrayList4.get(i13);
                    i13++;
                    d dVar3 = (d) obj3;
                    if (dVar3 instanceof androidx.constraintlayout.core.widgets.analyzer.a) {
                        a((androidx.constraintlayout.core.widgets.analyzer.a) dVar3, i3, arrayList, hVar);
                    }
                }
            }
            ArrayList arrayList5 = aVar2.f1624l;
            int size4 = arrayList5.size();
            int i14 = 0;
            while (i14 < size4) {
                Object obj4 = arrayList5.get(i14);
                i14++;
                a((androidx.constraintlayout.core.widgets.analyzer.a) obj4, i3, arrayList, hVar);
            }
            ArrayList arrayList6 = aVar3.f1624l;
            int size5 = arrayList6.size();
            int i15 = 0;
            while (i15 < size5) {
                Object obj5 = arrayList6.get(i15);
                i15++;
                a((androidx.constraintlayout.core.widgets.analyzer.a) obj5, i3, arrayList, hVar);
            }
            if (i3 == 1 && (hVar2 instanceof androidx.constraintlayout.core.widgets.analyzer.g)) {
                ArrayList arrayList7 = ((androidx.constraintlayout.core.widgets.analyzer.g) hVar2).f1629k.f1624l;
                int size6 = arrayList7.size();
                while (i10 < size6) {
                    Object obj6 = arrayList7.get(i10);
                    i10++;
                    a((androidx.constraintlayout.core.widgets.analyzer.a) obj6, i3, arrayList, hVar);
                }
            }
        }
    }

    public final void b(q0.g gVar) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        float f2;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
        float f10;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4;
        ArrayList arrayList = gVar.f17685s0;
        int size = arrayList.size();
        char c9 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            q0.f fVar = (q0.f) obj;
            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar.T;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = constraintWidget$DimensionBehaviourArr[c9];
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6 = constraintWidget$DimensionBehaviourArr[1];
            if (fVar.f17658h0 == 8) {
                fVar.f17644a = true;
            } else {
                float f11 = fVar.f17680v;
                if (f11 < 1.0f && constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                    fVar.f17674q = 2;
                }
                float f12 = fVar.f17683y;
                if (f12 < 1.0f && constraintWidget$DimensionBehaviour6 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                    fVar.r = 2;
                }
                if (fVar.X > 0.0f) {
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour7 && (constraintWidget$DimensionBehaviour6 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT || constraintWidget$DimensionBehaviour6 == ConstraintWidget$DimensionBehaviour.FIXED)) {
                        fVar.f17674q = 3;
                    } else if (constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour7 && (constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT || constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.FIXED)) {
                        fVar.r = 3;
                    } else if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour7 && constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour7) {
                        if (fVar.f17674q == 0) {
                            fVar.f17674q = 3;
                        }
                        if (fVar.r == 0) {
                            fVar.r = 3;
                        }
                    }
                }
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour8 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                q0.d dVar = fVar.K;
                char c10 = c9;
                q0.d dVar2 = fVar.I;
                if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour8 && fVar.f17674q == 1 && (dVar2.f17638f == null || dVar.f17638f == null)) {
                    constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                }
                q0.d dVar3 = fVar.L;
                q0.d dVar4 = fVar.J;
                if (constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour8 && fVar.r == 1 && (dVar4.f17638f == null || dVar3.f17638f == null)) {
                    constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                }
                androidx.constraintlayout.core.widgets.analyzer.e eVar = fVar.f17650d;
                eVar.f1634d = constraintWidget$DimensionBehaviour5;
                int i10 = fVar.f17674q;
                eVar.f1631a = i10;
                androidx.constraintlayout.core.widgets.analyzer.g gVar2 = fVar.e;
                gVar2.f1634d = constraintWidget$DimensionBehaviour6;
                ArrayList arrayList2 = arrayList;
                int i11 = fVar.r;
                gVar2.f1631a = i11;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour9 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                int i12 = size;
                if ((constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour9 || constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && (constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour9 || constraintWidget$DimensionBehaviour6 == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviour6 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour10 = constraintWidget$DimensionBehaviour5;
                    int o3 = fVar.o();
                    if (constraintWidget$DimensionBehaviour10 == constraintWidget$DimensionBehaviour9) {
                        o3 = (gVar.o() - dVar2.f17639g) - dVar.f17639g;
                        constraintWidget$DimensionBehaviour10 = ConstraintWidget$DimensionBehaviour.FIXED;
                    }
                    int i13 = o3;
                    int l3 = fVar.l();
                    if (constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour9) {
                        l3 = (gVar.l() - dVar4.f17639g) - dVar3.f17639g;
                        constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.FIXED;
                    }
                    f(fVar, constraintWidget$DimensionBehaviour10, i13, constraintWidget$DimensionBehaviour6, l3);
                    fVar.f17650d.e.d(fVar.o());
                    fVar.e.e.d(fVar.l());
                    fVar.f17644a = true;
                } else {
                    q0.d[] dVarArr = fVar.Q;
                    if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour8) {
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour11 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                        if (constraintWidget$DimensionBehaviour6 != constraintWidget$DimensionBehaviour11 && constraintWidget$DimensionBehaviour6 != ConstraintWidget$DimensionBehaviour.FIXED) {
                            f2 = f11;
                            constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviour6;
                        } else if (i10 == 3) {
                            if (constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour11) {
                                f(fVar, constraintWidget$DimensionBehaviour11, 0, constraintWidget$DimensionBehaviour11, 0);
                            }
                            int l5 = fVar.l();
                            int i14 = (int) ((l5 * fVar.X) + 0.5f);
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour12 = ConstraintWidget$DimensionBehaviour.FIXED;
                            f(fVar, constraintWidget$DimensionBehaviour12, i14, constraintWidget$DimensionBehaviour12, l5);
                            fVar.f17650d.e.d(fVar.o());
                            fVar.e.e.d(fVar.l());
                            fVar.f17644a = true;
                        } else if (i10 == 1) {
                            f(fVar, constraintWidget$DimensionBehaviour11, 0, constraintWidget$DimensionBehaviour6, 0);
                            fVar.f17650d.e.f1625m = fVar.o();
                        } else {
                            constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviour6;
                            if (i10 == 2) {
                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour13 = gVar.T[c10];
                                f2 = f11;
                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour14 = ConstraintWidget$DimensionBehaviour.FIXED;
                                if (constraintWidget$DimensionBehaviour13 == constraintWidget$DimensionBehaviour14 || constraintWidget$DimensionBehaviour13 == constraintWidget$DimensionBehaviour9) {
                                    f(fVar, constraintWidget$DimensionBehaviour14, (int) ((gVar.o() * f2) + 0.5f), constraintWidget$DimensionBehaviour, fVar.l());
                                    fVar.f17650d.e.d(fVar.o());
                                    fVar.e.e.d(fVar.l());
                                    fVar.f17644a = true;
                                }
                            } else {
                                f2 = f11;
                                if (dVarArr[c10].f17638f == null || dVarArr[1].f17638f == null) {
                                    f(fVar, constraintWidget$DimensionBehaviour11, 0, constraintWidget$DimensionBehaviour, 0);
                                    fVar.f17650d.e.d(fVar.o());
                                    fVar.e.e.d(fVar.l());
                                    fVar.f17644a = true;
                                }
                            }
                        }
                    } else {
                        constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviour6;
                        f2 = f11;
                    }
                    if (constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour8 || (constraintWidget$DimensionBehaviour5 != (constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && constraintWidget$DimensionBehaviour5 != ConstraintWidget$DimensionBehaviour.FIXED)) {
                        constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour5;
                        f10 = f12;
                        constraintWidget$DimensionBehaviour3 = constraintWidget$DimensionBehaviour;
                    } else if (i11 == 3) {
                        if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour4) {
                            f(fVar, constraintWidget$DimensionBehaviour4, 0, constraintWidget$DimensionBehaviour4, 0);
                        }
                        int o8 = fVar.o();
                        float f13 = fVar.X;
                        if (fVar.Y == -1) {
                            f13 = 1.0f / f13;
                        }
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour15 = ConstraintWidget$DimensionBehaviour.FIXED;
                        f(fVar, constraintWidget$DimensionBehaviour15, o8, constraintWidget$DimensionBehaviour15, (int) ((o8 * f13) + 0.5f));
                        fVar.f17650d.e.d(fVar.o());
                        fVar.e.e.d(fVar.l());
                        fVar.f17644a = true;
                    } else {
                        constraintWidget$DimensionBehaviour3 = constraintWidget$DimensionBehaviour;
                        if (i11 == 1) {
                            f(fVar, constraintWidget$DimensionBehaviour5, 0, constraintWidget$DimensionBehaviour4, 0);
                            fVar.e.e.f1625m = fVar.l();
                        } else {
                            constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour5;
                            if (i11 == 2) {
                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour16 = gVar.T[1];
                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour17 = ConstraintWidget$DimensionBehaviour.FIXED;
                                if (constraintWidget$DimensionBehaviour16 == constraintWidget$DimensionBehaviour17 || constraintWidget$DimensionBehaviour16 == constraintWidget$DimensionBehaviour9) {
                                    f(fVar, constraintWidget$DimensionBehaviour2, fVar.o(), constraintWidget$DimensionBehaviour17, (int) ((gVar.l() * f12) + 0.5f));
                                    fVar.f17650d.e.d(fVar.o());
                                    fVar.e.e.d(fVar.l());
                                    fVar.f17644a = true;
                                } else {
                                    f10 = f12;
                                }
                            } else {
                                f10 = f12;
                                if (dVarArr[2].f17638f == null || dVarArr[3].f17638f == null) {
                                    f(fVar, constraintWidget$DimensionBehaviour4, 0, constraintWidget$DimensionBehaviour3, 0);
                                    fVar.f17650d.e.d(fVar.o());
                                    fVar.e.e.d(fVar.l());
                                    fVar.f17644a = true;
                                }
                            }
                        }
                    }
                    if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour8 && constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour8) {
                        if (i10 == 1 || i11 == 1) {
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour18 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                            f(fVar, constraintWidget$DimensionBehaviour18, 0, constraintWidget$DimensionBehaviour18, 0);
                            fVar.f17650d.e.f1625m = fVar.o();
                            fVar.e.e.f1625m = fVar.l();
                        } else if (i11 == 2 && i10 == 2) {
                            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr2 = gVar.T;
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour19 = constraintWidget$DimensionBehaviourArr2[c10];
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour20 = ConstraintWidget$DimensionBehaviour.FIXED;
                            if (constraintWidget$DimensionBehaviour19 == constraintWidget$DimensionBehaviour20 && constraintWidget$DimensionBehaviourArr2[1] == constraintWidget$DimensionBehaviour20) {
                                f(fVar, constraintWidget$DimensionBehaviour20, (int) ((gVar.o() * f2) + 0.5f), constraintWidget$DimensionBehaviour20, (int) ((gVar.l() * f10) + 0.5f));
                                fVar.f17650d.e.d(fVar.o());
                                fVar.e.e.d(fVar.l());
                                fVar.f17644a = true;
                            }
                        }
                    }
                }
                c9 = c10;
                arrayList = arrayList2;
                size = i12;
            }
        }
    }

    public final void c() {
        ArrayList arrayList = this.e;
        arrayList.clear();
        q0.g gVar = this.f17972d;
        gVar.f17650d.f();
        gVar.e.f();
        arrayList.add(gVar.f17650d);
        arrayList.add(gVar.e);
        ArrayList arrayList2 = gVar.f17685s0;
        int size = arrayList2.size();
        HashSet hashSet = null;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            q0.f fVar = (q0.f) obj;
            if (fVar instanceof k) {
                g gVar2 = new g(fVar);
                fVar.f17650d.f();
                fVar.e.f();
                gVar2.f1635f = ((k) fVar).f17718w0;
                arrayList.add(gVar2);
            } else {
                if (fVar.v()) {
                    if (fVar.f17646b == null) {
                        fVar.f17646b = new c(fVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(fVar.f17646b);
                } else {
                    arrayList.add(fVar.f17650d);
                }
                if (fVar.w()) {
                    if (fVar.f17648c == null) {
                        fVar.f17648c = new c(fVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(fVar.f17648c);
                } else {
                    arrayList.add(fVar.e);
                }
                if (fVar instanceof l) {
                    arrayList.add(new androidx.constraintlayout.core.widgets.analyzer.c(fVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            ((androidx.constraintlayout.core.widgets.analyzer.h) obj2).f();
        }
        int size3 = arrayList.size();
        int i11 = 0;
        while (i11 < size3) {
            Object obj3 = arrayList.get(i11);
            i11++;
            androidx.constraintlayout.core.widgets.analyzer.h hVar = (androidx.constraintlayout.core.widgets.analyzer.h) obj3;
            if (hVar.f1632b != gVar) {
                hVar.d();
            }
        }
        ArrayList arrayList3 = this.f17975h;
        arrayList3.clear();
        q0.g gVar3 = this.f17969a;
        e(gVar3.f17650d, 0, arrayList3);
        e(gVar3.e, 1, arrayList3);
        this.f17970b = false;
    }

    public final int d(q0.g gVar, int i3) {
        ArrayList arrayList;
        int i10;
        int i11;
        long max;
        float f2;
        q0.g gVar2 = gVar;
        ArrayList arrayList2 = this.f17975h;
        int size = arrayList2.size();
        int i12 = 0;
        long j4 = 0;
        while (i12 < size) {
            androidx.constraintlayout.core.widgets.analyzer.h hVar = ((h) arrayList2.get(i12)).f17977a;
            if (!(hVar instanceof c) ? !(i3 != 0 ? (hVar instanceof androidx.constraintlayout.core.widgets.analyzer.g) : (hVar instanceof androidx.constraintlayout.core.widgets.analyzer.e)) : ((c) hVar).f1635f != i3) {
                androidx.constraintlayout.core.widgets.analyzer.a aVar = (i3 == 0 ? gVar2.f17650d : gVar2.e).f1637h;
                androidx.constraintlayout.core.widgets.analyzer.a aVar2 = (i3 == 0 ? gVar2.f17650d : gVar2.e).f1638i;
                boolean contains = hVar.f1637h.f1624l.contains(aVar);
                androidx.constraintlayout.core.widgets.analyzer.a aVar3 = hVar.f1638i;
                boolean contains2 = aVar3.f1624l.contains(aVar2);
                long j10 = hVar.j();
                androidx.constraintlayout.core.widgets.analyzer.a aVar4 = hVar.f1637h;
                if (contains && contains2) {
                    long b3 = h.b(aVar4, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i10 = size;
                    long a3 = h.a(aVar3, 0L);
                    long j11 = b3 - j10;
                    int i13 = aVar3.f1618f;
                    arrayList = arrayList3;
                    i11 = i12;
                    if (j11 >= (-i13)) {
                        j11 += i13;
                    }
                    long j12 = (-a3) - j10;
                    long j13 = aVar4.f1618f;
                    long j14 = j12 - j13;
                    if (j14 >= j13) {
                        j14 -= j13;
                    }
                    q0.f fVar = hVar.f1632b;
                    if (i3 == 0) {
                        f2 = fVar.f17652e0;
                    } else if (i3 == 1) {
                        f2 = fVar.f17654f0;
                    } else {
                        fVar.getClass();
                        f2 = -1.0f;
                    }
                    float f10 = f2 > 0.0f ? (long) ((j11 / (1.0f - f2)) + (j14 / f2)) : 0L;
                    max = (aVar4.f1618f + ((((long) ((f10 * f2) + 0.5f)) + j10) + ((long) l0.a(1.0f, f2, f10, 0.5f)))) - aVar3.f1618f;
                } else {
                    arrayList = arrayList2;
                    i10 = size;
                    i11 = i12;
                    max = contains ? Math.max(h.b(aVar4, aVar4.f1618f), aVar4.f1618f + j10) : contains2 ? Math.max(-h.a(aVar3, aVar3.f1618f), (-aVar3.f1618f) + j10) : (hVar.j() + aVar4.f1618f) - aVar3.f1618f;
                }
            } else {
                arrayList = arrayList2;
                i10 = size;
                i11 = i12;
                max = 0;
            }
            j4 = Math.max(j4, max);
            i12 = i11 + 1;
            gVar2 = gVar;
            size = i10;
            arrayList2 = arrayList;
        }
        return (int) j4;
    }

    public final void e(androidx.constraintlayout.core.widgets.analyzer.h hVar, int i3, ArrayList arrayList) {
        androidx.constraintlayout.core.widgets.analyzer.a aVar;
        ArrayList arrayList2 = hVar.f1637h.f1623k;
        int size = arrayList2.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            aVar = hVar.f1638i;
            if (i11 >= size) {
                break;
            }
            Object obj = arrayList2.get(i11);
            i11++;
            d dVar = (d) obj;
            if (dVar instanceof androidx.constraintlayout.core.widgets.analyzer.a) {
                a((androidx.constraintlayout.core.widgets.analyzer.a) dVar, i3, arrayList, null);
            } else if (dVar instanceof androidx.constraintlayout.core.widgets.analyzer.h) {
                a(((androidx.constraintlayout.core.widgets.analyzer.h) dVar).f1637h, i3, arrayList, null);
            }
        }
        ArrayList arrayList3 = aVar.f1623k;
        int size2 = arrayList3.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList3.get(i12);
            i12++;
            d dVar2 = (d) obj2;
            if (dVar2 instanceof androidx.constraintlayout.core.widgets.analyzer.a) {
                a((androidx.constraintlayout.core.widgets.analyzer.a) dVar2, i3, arrayList, null);
            } else if (dVar2 instanceof androidx.constraintlayout.core.widgets.analyzer.h) {
                a(((androidx.constraintlayout.core.widgets.analyzer.h) dVar2).f1638i, i3, arrayList, null);
            }
        }
        if (i3 == 1) {
            ArrayList arrayList4 = ((androidx.constraintlayout.core.widgets.analyzer.g) hVar).f1629k.f1623k;
            int size3 = arrayList4.size();
            while (i10 < size3) {
                Object obj3 = arrayList4.get(i10);
                i10++;
                d dVar3 = (d) obj3;
                if (dVar3 instanceof androidx.constraintlayout.core.widgets.analyzer.a) {
                    a((androidx.constraintlayout.core.widgets.analyzer.a) dVar3, i3, arrayList, null);
                }
            }
        }
    }

    public final void f(q0.f fVar, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, int i3, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, int i10) {
        b bVar = this.f17974g;
        bVar.f17958a = constraintWidget$DimensionBehaviour;
        bVar.f17959b = constraintWidget$DimensionBehaviour2;
        bVar.f17960c = i3;
        bVar.f17961d = i10;
        this.f17973f.b(fVar, bVar);
        fVar.K(bVar.e);
        fVar.H(bVar.f17962f);
        fVar.D = bVar.f17964h;
        fVar.E(bVar.f17963g);
    }

    public final void g() {
        a aVar;
        ArrayList arrayList = this.f17969a.f17685s0;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            q0.f fVar = (q0.f) obj;
            if (!fVar.f17644a) {
                ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar.T;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviourArr[0];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviourArr[1];
                int i10 = fVar.f17674q;
                int i11 = fVar.r;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                boolean z5 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3 || (constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && i10 == 1);
                boolean z6 = constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3 || (constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1);
                androidx.constraintlayout.core.widgets.analyzer.b bVar = fVar.f17650d.e;
                boolean z8 = bVar.f1622j;
                androidx.constraintlayout.core.widgets.analyzer.b bVar2 = fVar.e.e;
                boolean z10 = bVar2.f1622j;
                if (z8 && z10) {
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.FIXED;
                    f(fVar, constraintWidget$DimensionBehaviour4, bVar.f1619g, constraintWidget$DimensionBehaviour4, bVar2.f1619g);
                    fVar.f17644a = true;
                } else if (z8 && z6) {
                    f(fVar, ConstraintWidget$DimensionBehaviour.FIXED, bVar.f1619g, constraintWidget$DimensionBehaviour3, bVar2.f1619g);
                    if (constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                        fVar.e.e.f1625m = fVar.l();
                    } else {
                        fVar.e.e.d(fVar.l());
                        fVar.f17644a = true;
                    }
                } else if (z10 && z5) {
                    f(fVar, constraintWidget$DimensionBehaviour3, bVar.f1619g, ConstraintWidget$DimensionBehaviour.FIXED, bVar2.f1619g);
                    if (constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                        fVar.f17650d.e.f1625m = fVar.o();
                    } else {
                        fVar.f17650d.e.d(fVar.o());
                        fVar.f17644a = true;
                    }
                }
                if (fVar.f17644a && (aVar = fVar.e.f1630l) != null) {
                    aVar.d(fVar.f17647b0);
                }
            }
        }
    }
}
