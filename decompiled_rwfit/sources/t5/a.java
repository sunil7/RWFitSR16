package t5;

import android.os.Handler;
import com.example.blesdk.ble.scan.ScanFilter;
import com.example.blesdk.ble.scan.ScanResult;
import com.example.blesdk.ble.scan.ScanSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import pe.o;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18527b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18528c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18529d;

    /* renamed from: f, reason: collision with root package name */
    public final List f18530f;

    /* renamed from: g, reason: collision with root package name */
    public final ScanSettings f18531g;

    /* renamed from: h, reason: collision with root package name */
    public final i f18532h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f18533i;

    /* renamed from: a, reason: collision with root package name */
    public final Object f18526a = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f18534j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final HashSet f18535k = new HashSet();

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f18536l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public final o f18537m = new o(this, 7);
    public boolean e = false;

    public a(boolean z5, boolean z6, List list, ScanSettings scanSettings, i iVar, Handler handler) {
        this.f18530f = Collections.unmodifiableList(list);
        this.f18531g = scanSettings;
        this.f18532h = iVar;
        this.f18533i = handler;
        boolean z8 = false;
        this.f18529d = (scanSettings.b() == 1 || scanSettings.p()) ? false : true;
        this.f18527b = (list.isEmpty() || (z6 && scanSettings.q())) ? false : true;
        long m10 = scanSettings.m();
        if (m10 > 0 && (!z5 || !scanSettings.o())) {
            z8 = true;
        }
        this.f18528c = z8;
        if (z8) {
            handler.postDelayed(new ia.j(17, this, handler), m10);
        }
    }

    public final void a(int i3, ScanResult scanResult) {
        boolean isEmpty;
        ScanResult scanResult2;
        if (this.e) {
            return;
        }
        if (!this.f18530f.isEmpty()) {
            Iterator it = this.f18530f.iterator();
            while (it.hasNext()) {
                if (((ScanFilter) it.next()).o(scanResult)) {
                }
            }
            return;
        }
        String address = scanResult.a().getAddress();
        if (!this.f18529d) {
            if (!this.f18528c) {
                this.f18532h.c(i3, scanResult);
                return;
            }
            synchronized (this.f18526a) {
                try {
                    if (!this.f18535k.contains(address)) {
                        this.f18534j.add(scanResult);
                        this.f18535k.add(address);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return;
        }
        synchronized (this.f18536l) {
            isEmpty = this.f18536l.isEmpty();
            scanResult2 = (ScanResult) this.f18536l.put(address, scanResult);
        }
        if (scanResult2 == null && (this.f18531g.b() & 2) > 0) {
            this.f18532h.c(2, scanResult);
        }
        if (!isEmpty || (this.f18531g.b() & 4) <= 0) {
            return;
        }
        this.f18533i.removeCallbacks(this.f18537m);
        this.f18533i.postDelayed(this.f18537m, this.f18531g.i());
    }

    public final void b(ArrayList arrayList) {
        if (this.e) {
            return;
        }
        if (this.f18527b) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ScanResult scanResult = (ScanResult) obj;
                Iterator it = this.f18530f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((ScanFilter) it.next()).o(scanResult)) {
                        arrayList2.add(scanResult);
                        break;
                    }
                }
            }
            arrayList = arrayList2;
        }
        this.f18532h.a(arrayList);
    }
}
