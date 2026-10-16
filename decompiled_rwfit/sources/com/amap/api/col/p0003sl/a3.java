package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public interface a3 {

    public enum a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);

        a(int i3) {
        }
    }

    void a(long j4, long j10);

    void a(a aVar);

    void g();

    void onCancel();

    void onFinish();
}
