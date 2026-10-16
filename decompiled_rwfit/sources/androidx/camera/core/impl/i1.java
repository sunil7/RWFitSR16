package androidx.camera.core.impl;

import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.message.BlockCompleteMessage$BlockCompleteMessageImpl;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1421a;

    public i1(int i3) {
        switch (i3) {
            case 2:
                this.f1421a = new ArrayList(2);
                break;
            case 3:
                this.f1421a = new ArrayList();
                break;
            default:
                this.f1421a = new ArrayList();
                break;
        }
    }

    public static String j(i1 i1Var) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = i1Var.f1421a;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            arrayList.add(((f1) obj).getClass().getSimpleName());
        }
        return String.join(" | ", arrayList);
    }

    public void a(pe.b bVar) {
        bVar.getClass();
        if (bVar.f17551i == 0) {
            pe.p pVar = bVar.f17550h;
            bVar.f17551i = pVar != null ? pVar.hashCode() : bVar.hashCode();
        }
        pe.i iVar = bVar.f17545b.f17555a;
        if (iVar.f17571a == null) {
            o6.b(iVar, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(iVar.f17573c.size()));
        } else {
            iVar.f17572b.getClass();
            c(bVar);
        }
    }

    public void b(og.o oVar) {
        this.f1421a.add(oVar);
    }

    public void c(pe.b bVar) {
        if (bVar.f17554l) {
            return;
        }
        synchronized (this.f1421a) {
            try {
                if (this.f1421a.contains(bVar)) {
                    o6.b(this, "already has %s", bVar);
                } else {
                    bVar.f17554l = true;
                    this.f1421a.add(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d(Class cls) {
        ArrayList arrayList = this.f1421a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (cls.isAssignableFrom(((f1) obj).getClass())) {
                return true;
            }
        }
        return false;
    }

    public int e(int i3) {
        int i10;
        synchronized (this.f1421a) {
            try {
                ArrayList arrayList = this.f1421a;
                int size = arrayList.size();
                i10 = 0;
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    if (((pe.b) obj).a() == i3) {
                        i10++;
                    }
                }
            } finally {
            }
        }
        return i10;
    }

    public f1 f(Class cls) {
        ArrayList arrayList = this.f1421a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            f1 f1Var = (f1) obj;
            if (f1Var.getClass() == cls) {
                return f1Var;
            }
        }
        return null;
    }

    public synchronized x3.h g(Class cls) {
        int size = this.f1421a.size();
        for (int i3 = 0; i3 < size; i3++) {
            o4.f fVar = (o4.f) this.f1421a.get(i3);
            if (fVar.f16739a.isAssignableFrom(cls)) {
                return fVar.f16740b;
            }
        }
        return null;
    }

    public ArrayList h(int i3) {
        byte b3;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f1421a) {
            try {
                ArrayList arrayList2 = this.f1421a;
                int size = arrayList2.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList2.get(i10);
                    i10++;
                    pe.b bVar = (pe.b) obj;
                    if ((bVar.a() == i3) && bVar.f17544a.f17558d >= 0 && (b3 = bVar.f17544a.f17558d) != 0 && b3 != 10) {
                        arrayList.add(bVar);
                    }
                }
            } finally {
            }
        }
        return arrayList;
    }

    public void i(pe.b bVar, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte n4 = messageSnapshot.n();
        synchronized (this.f1421a) {
            try {
                remove = this.f1421a.remove(bVar);
                if (remove && this.f1421a.size() == 0) {
                    n.m0 m0Var = pe.j.f17574a;
                    if (((pe.r) m0Var.f16254b).p()) {
                        m0Var.j();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!remove) {
            o6.a(6, this, null, "remove error, not exist: %s %d", bVar, Byte.valueOf(n4));
            return;
        }
        pe.i iVar = bVar.f17545b.f17555a;
        if (n4 == -4) {
            iVar.f17572b.b();
            iVar.c(messageSnapshot);
            return;
        }
        if (n4 != -3) {
            if (n4 == -2) {
                iVar.f17572b.b();
                iVar.c(messageSnapshot);
                return;
            } else {
                if (n4 != -1) {
                    return;
                }
                iVar.f17572b.b();
                iVar.c(messageSnapshot);
                return;
            }
        }
        if (messageSnapshot.n() == -3) {
            BlockCompleteMessage$BlockCompleteMessageImpl blockCompleteMessage$BlockCompleteMessageImpl = new BlockCompleteMessage$BlockCompleteMessageImpl(messageSnapshot);
            iVar.f17572b.getClass();
            iVar.c(blockCompleteMessage$BlockCompleteMessageImpl);
        } else {
            int h4 = messageSnapshot.h();
            byte n8 = messageSnapshot.n();
            int i3 = ye.e.f20123a;
            Locale locale = Locale.ENGLISH;
            throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(h4, n8, "take block completed snapshot, must has already be completed. ", " "));
        }
    }

    public i1(List list) {
        this.f1421a = new ArrayList(list);
    }
}
