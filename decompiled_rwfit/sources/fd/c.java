package fd;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import androidx.recyclerview.widget.j2;
import ef.i;
import i6.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.UUID;
import n.m0;

/* loaded from: classes.dex */
public final class c implements h, nd.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13568a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final int f13569b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13570c;

    /* renamed from: d, reason: collision with root package name */
    public final Serializable f13571d;
    public Object e;

    /* JADX WARN: Type inference failed for: r2v3, types: [ef.i[], java.io.Serializable] */
    public c(j2 j2Var, b bVar) {
        this.f13570c = j2Var;
        int i3 = j2Var.f2638b;
        this.f13569b = i3;
        this.e = bVar;
        this.f13571d = new i[i3 + 2];
    }

    public void a(i iVar) {
        if (iVar != null) {
            d dVar = (d) iVar;
            j2[] j2VarArr = (j2[]) dVar.f12630c;
            for (j2 j2Var : j2VarArr) {
                if (j2Var != null) {
                    j2Var.c();
                }
            }
            j2 j2Var2 = (j2) this.f13570c;
            dVar.R(j2VarArr, j2Var2);
            b bVar = (b) dVar.f12629b;
            boolean z5 = dVar.e;
            com.google.zxing.h hVar = z5 ? bVar.f13561b : bVar.f13563d;
            com.google.zxing.h hVar2 = z5 ? bVar.f13562c : bVar.e;
            int z6 = dVar.z((int) hVar.f11248b);
            int z8 = dVar.z((int) hVar2.f11248b);
            int i3 = -1;
            int i10 = 0;
            int i11 = 1;
            while (z6 < z8) {
                j2 j2Var3 = j2VarArr[z6];
                if (j2Var3 != null) {
                    int i12 = j2Var3.f2641f;
                    int i13 = i12 - i3;
                    if (i13 == 0) {
                        i10++;
                    } else {
                        if (i13 == 1) {
                            i11 = Math.max(i11, i10);
                            i3 = j2Var3.f2641f;
                        } else if (i13 < 0 || i12 >= j2Var2.f2641f || i13 > z6) {
                            j2VarArr[z6] = null;
                        } else {
                            if (i11 > 2) {
                                i13 *= i11 - 2;
                            }
                            boolean z10 = i13 >= z6;
                            for (int i14 = 1; i14 <= i13 && !z10; i14++) {
                                z10 = j2VarArr[z6 - i14] != null;
                            }
                            if (z10) {
                                j2VarArr[z6] = null;
                            } else {
                                i3 = j2Var3.f2641f;
                            }
                        }
                        i10 = 1;
                    }
                }
                z6++;
            }
        }
    }

    @Override // nd.b
    public void h(boolean z5) {
        if (z5 && ((nd.d) this.e).isAdded()) {
            nd.d.a((Activity) this.f13570c, nd.c.b("android.permission.ACCESS_BACKGROUND_LOCATION"), new gc.b(16), new m0(this, 2));
        }
    }

    @Override // nd.b
    public void i() {
        nd.d dVar = (nd.d) this.e;
        if (dVar.isAdded()) {
            ArrayList arrayList = (ArrayList) this.f13571d;
            int[] iArr = new int[arrayList.size()];
            Arrays.fill(iArr, -1);
            dVar.onRequestPermissionsResult(this.f13569b, (String[]) arrayList.toArray(new String[0]), iArr);
        }
    }

    @Override // i6.h
    public void j(Object obj) {
        i6.i callback = (i6.i) obj;
        kotlin.jvm.internal.e.f(callback, "callback");
        callback.f((BluetoothDevice) this.f13570c, this.f13569b, (UUID) this.f13571d, (byte[]) this.e);
    }

    public String toString() {
        switch (this.f13568a) {
            case 0:
                i[] iVarArr = (i[]) this.f13571d;
                i iVar = iVarArr[0];
                int i3 = this.f13569b;
                if (iVar == null) {
                    iVar = iVarArr[i3 + 1];
                }
                Formatter formatter = new Formatter();
                for (int i10 = 0; i10 < ((j2[]) iVar.f12630c).length; i10++) {
                    try {
                        formatter.format("CW %3d:", Integer.valueOf(i10));
                        for (int i11 = 0; i11 < i3 + 2; i11++) {
                            i iVar2 = iVarArr[i11];
                            if (iVar2 == null) {
                                formatter.format("    |   ", new Object[0]);
                            } else {
                                j2 j2Var = ((j2[]) iVar2.f12630c)[i10];
                                if (j2Var == null) {
                                    formatter.format("    |   ", new Object[0]);
                                } else {
                                    formatter.format(" %3d|%3d", Integer.valueOf(j2Var.f2641f), Integer.valueOf(j2Var.e));
                                }
                            }
                        }
                        formatter.format("%n", new Object[0]);
                    } catch (Throwable th2) {
                        try {
                            formatter.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                String formatter2 = formatter.toString();
                formatter.close();
                return formatter2;
            default:
                return super.toString();
        }
    }

    public c(BluetoothDevice bluetoothDevice, int i3, UUID uuid, byte[] bArr) {
        this.f13570c = bluetoothDevice;
        this.f13569b = i3;
        this.f13571d = uuid;
        this.e = bArr;
    }

    public c(nd.d dVar, Activity activity, ArrayList arrayList, int i3) {
        this.e = dVar;
        this.f13570c = activity;
        this.f13571d = arrayList;
        this.f13569b = i3;
    }
}
