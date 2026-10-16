package u5;

import android.os.Message;

/* loaded from: classes.dex */
public final class f implements c, o5.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f18885a;

    /* renamed from: b, reason: collision with root package name */
    public final a f18886b;

    /* renamed from: c, reason: collision with root package name */
    public final com.example.baselibrary.utils.e f18887c;

    public f(w5.b bVar) {
        this.f18885a = -1;
        this.f18886b = bVar;
        this.f18887c = new com.example.baselibrary.utils.e(this);
    }

    @Override // u5.c
    public final void d(int i3, int i10) {
        Message obtain = Message.obtain();
        obtain.what = i10;
        obtain.obj = Integer.valueOf(i3);
        this.f18887c.sendMessage(obtain);
    }

    @Override // u5.c
    public final byte[] e() {
        return y5.d.f20005b ? new byte[]{-8, -11, -12, -15, -16, -17, -18, -19, -20, -21, -108, 19, 22, 24, 26, 29, -23, -25, -27, -29, -32, -33, -34, -35, -31, -36, -40, -41, -90, -42, -43, -45, -46, -47, -49, -51, -53, 75, 32, 35, 38, 40, 42, 44, 65, 50, 52, -55, -57, -7, -76, -77, -78, 71, 31, 54, 59, -79, -80, -81, -82, -6, -96, -88, -89, -98, 64, 66, 68} : new byte[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 64, 65, 66, 67, 68, 69, 70, 71, 51, 52, 53, 54, 55};
    }

    @Override // u5.c
    public final /* bridge */ /* synthetic */ void f(Object obj) {
    }

    @Override // u5.c
    public final b g() {
        return this.f18886b;
    }

    @Override // u5.c
    public final void h(byte b3, byte b10) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "DeviceAnswerCallback", "onAnswer", Thread.currentThread().getName());
        Message obtain = Message.obtain();
        char[] cArr = y5.b.f20001a;
        obtain.what = b10 & 255;
        obtain.obj = Byte.valueOf(b3);
        this.f18887c.sendMessage(obtain);
    }

    @Override // o5.a
    public final void r0(Message message) {
        byte byteValue;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "DeviceAnswerCallback", "onMessage", Thread.currentThread().getName());
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "DeviceAnswerCallback", "message.obj", String.valueOf(message.obj));
        Object obj = message.obj;
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            char[] cArr = y5.b.f20001a;
            byteValue = (byte) (intValue & 255);
        } else {
            byteValue = ((Byte) obj).byteValue();
        }
        int i3 = message.what;
        char[] cArr2 = y5.b.f20001a;
        int i10 = this.f18885a;
        a aVar = this.f18886b;
        if (i3 == 0) {
            if (aVar instanceof w5.b) {
                ((w5.b) aVar).h(byteValue);
                return;
            } else {
                if (byteValue == i10) {
                    ((w5.c) aVar).c();
                    return;
                }
                return;
            }
        }
        if (aVar instanceof w5.b) {
            ((w5.b) aVar).d(byteValue, i3);
        } else if (byteValue == i10) {
            ((w5.c) aVar).a(i3);
        }
    }

    public f(int i3, a aVar) {
        this.f18885a = i3;
        this.f18886b = aVar;
        this.f18887c = new com.example.baselibrary.utils.e(this);
    }
}
