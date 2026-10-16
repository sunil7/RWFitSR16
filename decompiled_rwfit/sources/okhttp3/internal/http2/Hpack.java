package okhttp3.internal.http2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.h;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.Util;
import okio.ByteString;
import wh.c0;
import wh.j;
import wh.l;

/* loaded from: classes2.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final l source;

        public Reader(c0 c0Var, int i3) {
            this(c0Var, i3, 0, 4, null);
        }

        private final void adjustDynamicTableByteCount() {
            int i3 = this.maxDynamicTableByteCount;
            int i10 = this.dynamicTableByteCount;
            if (i3 < i10) {
                if (i3 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i10 - i3);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            Arrays.fill(headerArr, 0, headerArr.length, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i3) {
            return this.nextHeaderIndex + 1 + i3;
        }

        private final int evictToRecoverBytes(int i3) {
            int i10;
            int i11 = 0;
            if (i3 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i10 = this.nextHeaderIndex;
                    if (length < i10 || i3 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    e.c(header);
                    int i12 = header.hpackSize;
                    i3 -= i12;
                    this.dynamicTableByteCount -= i12;
                    this.headerCount--;
                    i11++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i10 + 1, headerArr, i10 + 1 + i11, this.headerCount);
                this.nextHeaderIndex += i11;
            }
            return i11;
        }

        private final ByteString getName(int i3) throws IOException {
            if (isStaticHeader(i3)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i3].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i3 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    e.c(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i3 + 1));
        }

        private final void insertIntoDynamicTable(int i3, Header header) {
            this.headerList.add(header);
            int i10 = header.hpackSize;
            if (i3 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i3)];
                e.c(header2);
                i10 -= header2.hpackSize;
            }
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i10) - i11);
            if (i3 == -1) {
                int i12 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i12 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i13 = this.nextHeaderIndex;
                this.nextHeaderIndex = i13 - 1;
                this.dynamicTable[i13] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[dynamicTableIndex(i3) + evictToRecoverBytes + i3] = header;
            }
            this.dynamicTableByteCount += i10;
        }

        private final boolean isStaticHeader(int i3) {
            return i3 >= 0 && i3 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i3) throws IOException {
            if (isStaticHeader(i3)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i3]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i3 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    e.c(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i3 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i3) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i3), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i3) throws IOException {
            this.headerList.add(new Header(getName(i3), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> v6 = h.v(this.headerList);
            this.headerList.clear();
            return v6;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            int readByte = readByte();
            boolean z5 = (readByte & 128) == 128;
            long readInt = readInt(readByte, 127);
            if (!z5) {
                return this.source.s(readInt);
            }
            j jVar = new j();
            Huffman.INSTANCE.decode(this.source, readInt, jVar);
            return jVar.s(jVar.f19654b);
        }

        public final void readHeaders() throws IOException {
            while (!this.source.D()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                }
                if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int i3, int i10) throws IOException {
            int i11 = i3 & i10;
            if (i11 < i10) {
                return i11;
            }
            int i12 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i10 + (readByte << i12);
                }
                i10 += (readByte & 127) << i12;
                i12 += 7;
            }
        }

        public Reader(c0 source, int i3, int i10) {
            e.f(source, "source");
            this.headerTableSizeSetting = i3;
            this.maxDynamicTableByteCount = i10;
            this.headerList = new ArrayList();
            this.source = e6.b(source);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public /* synthetic */ Reader(c0 c0Var, int i3, int i10, int i11, c cVar) {
            this(c0Var, i3, (i11 & 4) != 0 ? i3 : i10);
        }
    }

    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final j out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int i3, j jVar) {
            this(i3, false, jVar, 2, null);
        }

        private final void adjustDynamicTableByteCount() {
            int i3 = this.maxDynamicTableByteCount;
            int i10 = this.dynamicTableByteCount;
            if (i3 < i10) {
                if (i3 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i10 - i3);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            Arrays.fill(headerArr, 0, headerArr.length, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i3) {
            int i10;
            int i11 = 0;
            if (i3 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i10 = this.nextHeaderIndex;
                    if (length < i10 || i3 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    e.c(header);
                    i3 -= header.hpackSize;
                    int i12 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    e.c(header2);
                    this.dynamicTableByteCount = i12 - header2.hpackSize;
                    this.headerCount--;
                    i11++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i10 + 1, headerArr, i10 + 1 + i11, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i13 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i13 + 1, i13 + 1 + i11, (Object) null);
                this.nextHeaderIndex += i11;
            }
            return i11;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i3 = header.hpackSize;
            int i10 = this.maxDynamicTableByteCount;
            if (i3 > i10) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i3) - i10);
            int i11 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i11 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i12 = this.nextHeaderIndex;
            this.nextHeaderIndex = i12 - 1;
            this.dynamicTable[i12] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i3;
        }

        public final void resizeHeaderTable(int i3) {
            this.headerTableSizeSetting = i3;
            int min = Math.min(i3, 16384);
            int i10 = this.maxDynamicTableByteCount;
            if (i10 == min) {
                return;
            }
            if (min < i10) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(ByteString data) throws IOException {
            e.f(data, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.size()) {
                    j jVar = new j();
                    huffman.encode(data, jVar);
                    ByteString s7 = jVar.s(jVar.f19654b);
                    writeInt(s7.size(), 127, 128);
                    this.out.W(s7);
                    return;
                }
            }
            writeInt(data.size(), 127, 0);
            this.out.W(data);
        }

        public final void writeHeaders(List<Header> headerBlock) throws IOException {
            int i3;
            int i10;
            e.f(headerBlock, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i11 = this.smallestHeaderTableSizeSetting;
                if (i11 < this.maxDynamicTableByteCount) {
                    writeInt(i11, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = headerBlock.size();
            for (int i12 = 0; i12 < size; i12++) {
                Header header = headerBlock.get(i12);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    int intValue = num.intValue();
                    i10 = intValue + 1;
                    if (2 <= i10 && 7 >= i10) {
                        if (e.a(hpack.getSTATIC_HEADER_TABLE()[intValue].value, byteString)) {
                            i3 = i10;
                        } else if (e.a(hpack.getSTATIC_HEADER_TABLE()[i10].value, byteString)) {
                            i3 = i10;
                            i10 = intValue + 2;
                        }
                    }
                    i3 = i10;
                    i10 = -1;
                } else {
                    i3 = -1;
                    i10 = -1;
                }
                if (i10 == -1) {
                    int i13 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i13 >= length) {
                            break;
                        }
                        Header header2 = this.dynamicTable[i13];
                        e.c(header2);
                        if (e.a(header2.name, asciiLowercase)) {
                            Header header3 = this.dynamicTable[i13];
                            e.c(header3);
                            if (e.a(header3.value, byteString)) {
                                i10 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i13 - this.nextHeaderIndex);
                                break;
                            } else if (i3 == -1) {
                                i3 = (i13 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                        i13++;
                    }
                }
                if (i10 != -1) {
                    writeInt(i10, 127, 128);
                } else if (i3 == -1) {
                    this.out.Z(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || e.a(Header.TARGET_AUTHORITY, asciiLowercase)) {
                    writeInt(i3, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(i3, 15, 0);
                    writeByteString(byteString);
                }
            }
        }

        public final void writeInt(int i3, int i10, int i11) {
            if (i3 < i10) {
                this.out.Z(i3 | i11);
                return;
            }
            this.out.Z(i11 | i10);
            int i12 = i3 - i10;
            while (i12 >= 128) {
                this.out.Z(128 | (i12 & 127));
                i12 >>>= 7;
            }
            this.out.Z(i12);
        }

        public Writer(j jVar) {
            this(0, false, jVar, 3, null);
        }

        public Writer(int i3, boolean z5, j out) {
            e.f(out, "out");
            this.headerTableSizeSetting = i3;
            this.useCompression = z5;
            this.out = out;
            this.smallestHeaderTableSizeSetting = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.maxDynamicTableByteCount = i3;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Writer(int i3, boolean z5, j jVar, int i10, c cVar) {
            this((i10 & 1) != 0 ? Hpack.SETTINGS_HEADER_TABLE_SIZE : i3, (i10 & 2) != 0 ? true : z5, jVar);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, Constants.HTTP_GET);
        Header header3 = new Header(byteString, Constants.HTTP_POST);
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(FileDownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header(Constants.FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i3].name)) {
                linkedHashMap.put(headerArr2[i3].name, Integer.valueOf(i3));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        e.e(unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString name) throws IOException {
        e.f(name, "name");
        int size = name.size();
        for (int i3 = 0; i3 < size; i3++) {
            byte b3 = (byte) 65;
            byte b10 = (byte) 90;
            byte b11 = name.getByte(i3);
            if (b3 <= b11 && b10 >= b11) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
