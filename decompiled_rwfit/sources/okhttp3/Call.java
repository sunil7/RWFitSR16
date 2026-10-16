package okhttp3;

import java.io.IOException;
import wh.f0;

/* loaded from: classes2.dex */
public interface Call extends Cloneable {

    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    f0 timeout();
}
