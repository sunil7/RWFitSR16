package x5;

import android.os.Message;
import android.util.Log;
import com.example.blesdk.bean.BleSendBean;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class c implements o5.a, u5.d {
    public static c e;

    /* renamed from: a, reason: collision with root package name */
    public int f19801a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final com.example.baselibrary.utils.e f19802b = new com.example.baselibrary.utils.e(this);

    /* renamed from: c, reason: collision with root package name */
    public final LinkedList f19803c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    public final a f19804d;

    public c() {
        a aVar = new a();
        aVar.f19785a = 1;
        aVar.f19786b = 1;
        aVar.f19787c = (byte) 0;
        aVar.f19788d = (byte) 0;
        aVar.e = (byte) 0;
        aVar.f19789f = (byte) 0;
        aVar.f19790g = 0;
        aVar.f19793j = 0;
        this.f19804d = aVar;
        Log.e("qob", "CmdHandlerJLUtils init");
        r5.b.k().q(this);
    }

    public static c b() {
        if (e == null) {
            synchronized (c.class) {
                e = new c();
            }
        }
        return e;
    }

    public static boolean c(byte b3) {
        return b3 != 7;
    }

    @Override // u5.d
    public final void I(s5.a aVar, int i3) {
    }

    public final synchronized void a(byte b3, byte[] bArr) {
        try {
            if (c(b3)) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "加入等待指令--> ", y5.b.h(bArr));
            } else {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "加入等待指令--> ", "文件传输");
            }
            BleSendBean bleSendBean = new BleSendBean();
            bleSendBean.sendMsgId = b3;
            bleSendBean.willSendData = bArr;
            if (b3 == 17) {
                bleSendBean.receivedFECmd = 255;
            }
            if (b3 != 17) {
                this.f19803c.add(bleSendBean);
            } else if (this.f19803c.size() > 0) {
                BleSendBean bleSendBean2 = (BleSendBean) this.f19803c.get(0);
                if (bleSendBean2.gattWriteFinish == 2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "队列顶部指令 未收到ACK 写已回调,直接替代 " + ((int) bleSendBean2.sendMsgId));
                    this.f19803c.set(0, bleSendBean);
                } else if (bleSendBean2.gattWriteFinish == 1) {
                    bleSendBean2.receivedFECmd = 1;
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "队列顶部指令 未收到ACK 写未回调,等回调赋值0x01直接直出队列 " + ((int) bleSendBean2.sendMsgId));
                    this.f19803c.add(1, bleSendBean);
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "添加应答指令到队列111 " + ((int) bleSendBean2.sendMsgId));
                    this.f19803c.add(0, bleSendBean);
                }
            } else {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "添加应答指令到队列222 " + ((int) b3));
                this.f19803c.add(0, bleSendBean);
            }
            d();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void d() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "nextCmd " + this.f19803c.size());
        try {
            if (this.f19803c.size() > 0) {
                if (this.f19803c.get(0) == null) {
                    this.f19803c.remove(0);
                    d();
                    return;
                }
                BleSendBean bleSendBean = (BleSendBean) this.f19803c.get(0);
                byte[] bArr = bleSendBean.willSendData;
                if (bArr == null) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "指令异常为空，移除指令");
                    this.f19803c.remove(0);
                    d();
                    return;
                }
                if (!r5.b.k().f18054c) {
                    b.I0().F0(bleSendBean.sendMsgId);
                    return;
                }
                if (bleSendBean.gattWriteFinish == 1) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "队列顶部指令 还Write未完成需等待 " + ((int) bleSendBean.sendMsgId));
                    return;
                }
                if (bleSendBean.receivedFECmd == 0 && bleSendBean.gattWriteFinish == 2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "队列顶部指令 0xFE未完成需等待");
                    return;
                }
                if (bArr.length < 7 || !c(bArr[6])) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "发送指令--> ", "文件传输 len: " + bArr.length);
                } else if (y5.b.h(bArr).length() > 100) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "发送指令--> ", Integer.valueOf(y5.b.h(bArr).length()));
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "发送指令--> ", y5.b.h(bArr));
                }
                bleSendBean.gattWriteFinish = 1;
                boolean s7 = r5.b.k().s(bArr);
                if (bArr[2] == -1) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "应答指令不等超时，等write完成释放发送通道");
                } else if (!s7) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "发送指令失败重发");
                }
            }
        } catch (Throwable th2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "NEXT CMD ERROR " + th2.getMessage());
            this.f19802b.postDelayed(new m5.a(this, 17), (long) r5.b.k().f18064n);
        }
    }

    public final synchronized void e() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "popQueue 移除发送等待队列 " + this.f19803c.size());
        this.f19803c.remove(0);
        this.f19801a = 0;
        d();
    }

    @Override // u5.d
    public final void e0(s5.a aVar) {
    }

    public final void f(byte b3, byte b10, byte b11, byte b12, byte[] bArr) {
        if (b3 != 17 || this.f19803c.size() <= 0) {
            return;
        }
        BleSendBean bleSendBean = (BleSendBean) this.f19803c.get(0);
        StringBuilder q5 = android.support.v4.media.session.e.q(b10, "removeCmdCache cmdId = ", " sendMsgId ");
        q5.append(bleSendBean.sendMsgId & 255);
        q5.append("  gattWriteFinish ");
        q5.append(bleSendBean.gattWriteFinish);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", q5.toString());
        LinkedList linkedList = this.f19803c;
        if (linkedList.size() > 0) {
            BleSendBean bleSendBean2 = (BleSendBean) linkedList.get(0);
            byte[] bArr2 = bleSendBean2.willSendData;
            if ((b10 == 7 && b11 == 1 && bleSendBean2.sendMsgId == -9) || ((b10 == 7 && b11 == 11 && bleSendBean2.sendMsgId == -86) || ((b10 == 7 && b11 == 4 && bleSendBean2.sendMsgId == -10) || ((b10 == 7 && b11 == 12 && bleSendBean2.sendMsgId == 21) || (bArr2[6] == b10 && bArr2[7] == b11 && bArr2[8] == b12))))) {
                bleSendBean.receivedFECmd = 1;
                if (bleSendBean.gattWriteFinish == 2) {
                    e();
                    return;
                }
                return;
            }
        }
        if (!c(b10)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "队列当前正在等待回复指令不匹配，继续等待 文件传输当前缓存数量 " + this.f19803c.size());
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "队列当前正在等待回复指令不匹配，继续等待 dataBody = " + y5.b.h(bArr) + "当前缓存数量 " + this.f19803c.size());
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x012c, code lost:
    
        r11 = 183;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void g(byte r10, byte[] r11, boolean... r12) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.c.g(byte, byte[], boolean[]):void");
    }

    @Override // u5.d
    public final void h0(s5.a aVar) {
    }

    @Override // u5.d
    public final void m0(s5.a aVar) {
    }

    @Override // u5.d
    public final void o() {
    }

    @Override // o5.a
    public final void r0(Message message) {
        int i3 = this.f19801a;
        if (i3 < 2) {
            this.f19801a = i3 + 1;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", r5.a.e(new StringBuilder("命令发送第"), this.f19801a, "次超时，重发"));
            if (this.f19803c.size() > 0 && this.f19803c.get(0) != null) {
                BleSendBean bleSendBean = (BleSendBean) this.f19803c.get(0);
                byte[] bArr = bleSendBean.willSendData;
                if (bArr == null || bArr.length < 3 || !c(bArr[2])) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "重发当前指令 文件传输");
                } else {
                    bleSendBean.gattWriteFinish = 0;
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "重发当前指令 " + y5.b.h(bleSendBean.willSendData));
                }
            }
        } else {
            this.f19801a = 0;
            b.I0().E0(message.what);
            if (this.f19803c.size() > 0) {
                BleSendBean bleSendBean2 = (BleSendBean) this.f19803c.remove(0);
                byte[] bArr2 = bleSendBean2.willSendData;
                if (bArr2 == null || bArr2.length < 3 || !c(bArr2[2])) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "发送三次超时移除等待当前指令 --> 文件传输");
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "发送三次超时移除等待当前指令 --> " + y5.b.h(bleSendBean2.willSendData));
                }
            }
        }
        d();
    }

    @Override // u5.d
    public final void v(s5.a aVar) {
        StringBuilder sb2 = new StringBuilder("onDisConnect ");
        LinkedList linkedList = this.f19803c;
        sb2.append(linkedList.size());
        Log.e("CmdHandlerJLUtils", sb2.toString());
        b I0 = b.I0();
        I0.f19797c = -1;
        I0.f19798d = -1;
        if (linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                BleSendBean bleSendBean = (BleSendBean) it.next();
                byte[] bArr = bleSendBean.willSendData;
                byte b3 = bleSendBean.sendMsgId;
                if (b3 == -9 || b3 == -85 || b3 == -10 || b3 == -86 || b3 == 21) {
                    r5.c.h().n(true, new byte[]{7, 2, bArr[2]});
                    break;
                }
                b.I0().F0(bleSendBean.sendMsgId);
            }
            linkedList.clear();
        } else if (r5.c.h().f18084k > 1) {
            r5.c.h().o(true, new byte[]{7, 2, 0}, (byte) 0);
        }
        this.f19801a = 0;
    }
}
