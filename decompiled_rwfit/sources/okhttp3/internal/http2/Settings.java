package okhttp3.internal.http2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Arrays;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public final void clear() {
        this.set = 0;
        int[] iArr = this.values;
        int length = iArr.length;
        e.f(iArr, "<this>");
        Arrays.fill(iArr, 0, length, 0);
    }

    public final int get(int i3) {
        return this.values[i3];
    }

    public final boolean getEnablePush(boolean z5) {
        return (this.set & 4) != 0 ? this.values[2] == 1 : z5;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        return (this.set & 128) != 0 ? this.values[7] : DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public final int getMaxConcurrentStreams() {
        return (this.set & 16) != 0 ? this.values[4] : SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    public final int getMaxFrameSize(int i3) {
        return (this.set & 32) != 0 ? this.values[5] : i3;
    }

    public final int getMaxHeaderListSize(int i3) {
        return (this.set & 64) != 0 ? this.values[6] : i3;
    }

    public final boolean isSet(int i3) {
        return ((1 << i3) & this.set) != 0;
    }

    public final void merge(Settings other) {
        e.f(other, "other");
        for (int i3 = 0; i3 < 10; i3++) {
            if (other.isSet(i3)) {
                set(i3, other.get(i3));
            }
        }
    }

    public final Settings set(int i3, int i10) {
        if (i3 >= 0) {
            int[] iArr = this.values;
            if (i3 < iArr.length) {
                this.set = (1 << i3) | this.set;
                iArr[i3] = i10;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
