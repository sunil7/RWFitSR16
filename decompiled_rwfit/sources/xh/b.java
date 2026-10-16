package xh;

import kotlin.jvm.internal.e;
import okio.SegmentedByteString;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f19828a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c9) {
        if ('0' <= c9 && '9' >= c9) {
            return c9 - '0';
        }
        if ('a' <= c9 && 'f' >= c9) {
            return c9 - 'W';
        }
        if ('A' <= c9 && 'F' >= c9) {
            return c9 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c9);
    }

    public static final int b(SegmentedByteString segmentedByteString, int i3) {
        int i10;
        int[] binarySearch = segmentedByteString.getDirectory$okio();
        int i11 = i3 + 1;
        int length = segmentedByteString.getSegments$okio().length;
        e.f(binarySearch, "$this$binarySearch");
        int i12 = length - 1;
        int i13 = 0;
        while (true) {
            if (i13 <= i12) {
                i10 = (i13 + i12) >>> 1;
                int i14 = binarySearch[i10];
                if (i14 >= i11) {
                    if (i14 <= i11) {
                        break;
                    }
                    i12 = i10 - 1;
                } else {
                    i13 = i10 + 1;
                }
            } else {
                i10 = (-i13) - 1;
                break;
            }
        }
        return i10 >= 0 ? i10 : ~i10;
    }
}
