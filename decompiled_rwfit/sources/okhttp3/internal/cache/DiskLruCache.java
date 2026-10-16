package okhttp3.internal.cache;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import eh.g;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.Regex;
import kotlin.text.m;
import oh.l;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import r5.a;
import wh.a0;
import wh.c0;
import wh.f;
import wh.k;
import wh.p;
import wh.w;
import wh.x;

/* loaded from: classes2.dex */
public final class DiskLruCache implements Closeable, Flushable, AutoCloseable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private k journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            e.f(entry, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            synchronized (this.this$0) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (e.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final void commit() throws IOException {
            synchronized (this.this$0) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (e.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final void detach$okhttp() {
            if (e.a(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final a0 newSink(final int i3) {
            synchronized (this.this$0) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (!e.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        return new f();
                    }
                    if (!this.entry.getReadable$okhttp()) {
                        boolean[] zArr = this.written;
                        e.c(zArr);
                        zArr[i3] = true;
                    }
                    try {
                        return new FaultHidingSink(this.this$0.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i3)), new l() { // from class: okhttp3.internal.cache.DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // oh.l
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((IOException) obj);
                                return g.f12633a;
                            }

                            public final void invoke(IOException it) {
                                e.f(it, "it");
                                synchronized (DiskLruCache.Editor.this.this$0) {
                                    DiskLruCache.Editor.this.detach$okhttp();
                                }
                            }
                        });
                    } catch (FileNotFoundException unused) {
                        return new f();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final c0 newSource(int i3) {
            synchronized (this.this$0) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                c0 c0Var = null;
                if (!this.entry.getReadable$okhttp() || !e.a(this.entry.getCurrentEditor$okhttp(), this) || this.entry.getZombie$okhttp()) {
                    return null;
                }
                try {
                    c0Var = this.this$0.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i3));
                } catch (FileNotFoundException unused) {
                }
                return c0Var;
            }
        }
    }

    public final class Entry {
        private final List<File> cleanFiles;
        private Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache diskLruCache, String key) {
            e.f(key, "key");
            this.this$0 = diskLruCache;
            this.key = key;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb2 = new StringBuilder(key);
            sb2.append('.');
            int length = sb2.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i3 = 0; i3 < valueCount$okhttp; i3++) {
                sb2.append(i3);
                this.cleanFiles.add(new File(diskLruCache.getDirectory(), sb2.toString()));
                sb2.append(".tmp");
                this.dirtyFiles.add(new File(diskLruCache.getDirectory(), sb2.toString()));
                sb2.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final c0 newSource(int i3) {
            final c0 source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i3));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            return new p(source) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;

                @Override // wh.p, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    super.close();
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    synchronized (DiskLruCache.Entry.this.this$0) {
                        DiskLruCache.Entry.this.setLockingSourceCount$okhttp(r1.getLockingSourceCount$okhttp() - 1);
                        if (DiskLruCache.Entry.this.getLockingSourceCount$okhttp() == 0 && DiskLruCache.Entry.this.getZombie$okhttp()) {
                            DiskLruCache.Entry entry = DiskLruCache.Entry.this;
                            entry.this$0.removeEntry$okhttp(entry);
                        }
                    }
                }
            };
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> strings) throws IOException {
            e.f(strings, "strings");
            if (strings.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(strings);
                throw new KotlinNothingValueException();
            }
            try {
                int size = strings.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.lengths[i3] = Long.parseLong(strings.get(i3));
                }
            } catch (NumberFormatException unused) {
                invalidLengths(strings);
                throw new KotlinNothingValueException();
            }
        }

        public final void setLockingSourceCount$okhttp(int i3) {
            this.lockingSourceCount = i3;
        }

        public final void setReadable$okhttp(boolean z5) {
            this.readable = z5;
        }

        public final void setSequenceNumber$okhttp(long j4) {
            this.sequenceNumber = j4;
        }

        public final void setZombie$okhttp(boolean z5) {
            this.zombie = z5;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                StringBuilder sb2 = new StringBuilder("Thread ");
                Thread currentThread = Thread.currentThread();
                e.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST hold lock on ");
                sb2.append(diskLruCache);
                throw new AssertionError(sb2.toString());
            }
            if (!this.readable) {
                return null;
            }
            if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            int i3 = 0;
            try {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i10 = 0; i10 < valueCount$okhttp; i10++) {
                    arrayList.add(newSource(i10));
                }
                return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    Util.closeQuietly((c0) obj);
                }
                try {
                    this.this$0.removeEntry$okhttp(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void writeLengths$okhttp(k writer) throws IOException {
            e.f(writer, "writer");
            for (long j4 : this.lengths) {
                writer.E(32).R(j4);
            }
        }
    }

    public final class Snapshot implements Closeable, AutoCloseable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<c0> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache diskLruCache, String key, long j4, List<? extends c0> sources, long[] lengths) {
            e.f(key, "key");
            e.f(sources, "sources");
            e.f(lengths, "lengths");
            this.this$0 = diskLruCache;
            this.key = key;
            this.sequenceNumber = j4;
            this.sources = sources;
            this.lengths = lengths;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<c0> it = this.sources.iterator();
            while (it.hasNext()) {
                Util.closeQuietly(it.next());
            }
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i3) {
            return this.lengths[i3];
        }

        public final c0 getSource(int i3) {
            return this.sources.get(i3);
        }

        public final String key() {
            return this.key;
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem fileSystem, File directory, int i3, int i10, long j4, TaskRunner taskRunner) {
        e.f(fileSystem, "fileSystem");
        e.f(directory, "directory");
        e.f(taskRunner, "taskRunner");
        this.fileSystem = fileSystem;
        this.directory = directory;
        this.appVersion = i3;
        this.valueCount = i10;
        this.maxSize = j4;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        final String f2 = a.f(new StringBuilder(), Util.okHttpName, " Cache");
        this.cleanupTask = new Task(f2) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean z5;
                boolean journalRebuildRequired;
                synchronized (DiskLruCache.this) {
                    z5 = DiskLruCache.this.initialized;
                    if (!z5 || DiskLruCache.this.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        DiskLruCache.this.trimToSize();
                    } catch (IOException unused) {
                        DiskLruCache.this.mostRecentTrimFailed = true;
                    }
                    try {
                        journalRebuildRequired = DiskLruCache.this.journalRebuildRequired();
                        if (journalRebuildRequired) {
                            DiskLruCache.this.rebuildJournal$okhttp();
                            DiskLruCache.this.redundantOpCount = 0;
                        }
                    } catch (IOException unused2) {
                        DiskLruCache.this.mostRecentRebuildFailed = true;
                        DiskLruCache.this.journalWriter = e6.a(new f());
                    }
                    return -1L;
                }
            }
        };
        if (!(j4 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (!(i10 > 0)) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = new File(directory, JOURNAL_FILE);
        this.journalFileTmp = new File(directory, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(directory, JOURNAL_FILE_BACKUP);
    }

    private final synchronized void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j4, int i3, Object obj) throws IOException {
        if ((i3 & 2) != 0) {
            j4 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i3 = this.redundantOpCount;
        return i3 >= 2000 && i3 >= this.lruEntries.size();
    }

    private final k newJournalWriter() throws FileNotFoundException {
        return e6.a(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new l() { // from class: okhttp3.internal.cache.DiskLruCache$newJournalWriter$faultHidingSink$1
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IOException) obj);
                return g.f12633a;
            }

            public final void invoke(IOException it) {
                e.f(it, "it");
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (!Util.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
                    DiskLruCache.this.hasJournalErrors = true;
                    return;
                }
                StringBuilder sb2 = new StringBuilder("Thread ");
                Thread currentThread = Thread.currentThread();
                e.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST hold lock on ");
                sb2.append(diskLruCache);
                throw new AssertionError(sb2.toString());
            }
        }));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            e.e(next, "i.next()");
            Entry entry = next;
            int i3 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i10 = this.valueCount;
                while (i3 < i10) {
                    this.size += entry.getLengths$okhttp()[i3];
                    i3++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i11 = this.valueCount;
                while (i3 < i11) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i3));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i3));
                    i3++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() throws IOException {
        x b3 = e6.b(this.fileSystem.source(this.journalFile));
        try {
            String M = b3.M(Format.OFFSET_SAMPLE_RELATIVE);
            String M2 = b3.M(Format.OFFSET_SAMPLE_RELATIVE);
            String M3 = b3.M(Format.OFFSET_SAMPLE_RELATIVE);
            String M4 = b3.M(Format.OFFSET_SAMPLE_RELATIVE);
            String M5 = b3.M(Format.OFFSET_SAMPLE_RELATIVE);
            if (!e.a(MAGIC, M) || !e.a(VERSION_1, M2) || !e.a(String.valueOf(this.appVersion), M3) || !e.a(String.valueOf(this.valueCount), M4) || M5.length() > 0) {
                throw new IOException("unexpected journal header: [" + M + ", " + M2 + ", " + M4 + ", " + M5 + ']');
            }
            int i3 = 0;
            while (true) {
                try {
                    readJournalLine(b3.M(Format.OFFSET_SAMPLE_RELATIVE));
                    i3++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i3 - this.lruEntries.size();
                    if (b3.D()) {
                        this.journalWriter = newJournalWriter();
                    } else {
                        rebuildJournal$okhttp();
                    }
                    b3.close();
                    return;
                }
            }
        } finally {
        }
    }

    private final void readJournalLine(String str) throws IOException {
        String substring;
        int i3 = m.i(str, ' ', 0, 6);
        if (i3 == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i10 = i3 + 1;
        int i11 = m.i(str, ' ', i10, 4);
        if (i11 == -1) {
            substring = str.substring(i10);
            e.e(substring, "(this as java.lang.String).substring(startIndex)");
            String str2 = REMOVE;
            if (i3 == str2.length() && m.x(str, str2, false)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i10, i11);
            e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(this, substring);
            this.lruEntries.put(substring, entry);
        }
        if (i11 != -1) {
            String str3 = CLEAN;
            if (i3 == str3.length() && m.x(str, str3, false)) {
                String substring2 = str.substring(i11 + 1);
                e.e(substring2, "(this as java.lang.String).substring(startIndex)");
                List<String> v6 = m.v(substring2, new char[]{' '});
                entry.setReadable$okhttp(true);
                entry.setCurrentEditor$okhttp(null);
                entry.setLengths$okhttp(v6);
                return;
            }
        }
        if (i11 == -1) {
            String str4 = DIRTY;
            if (i3 == str4.length() && m.x(str, str4, false)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
                return;
            }
        }
        if (i11 == -1) {
            String str5 = READ;
            if (i3 == str5.length() && m.x(str, str5, false)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            if (!entry.getZombie$okhttp()) {
                removeEntry$okhttp(entry);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        try {
            if (this.initialized && !this.closed) {
                Collection<Entry> values = this.lruEntries.values();
                e.e(values, "lruEntries.values");
                Object[] array = values.toArray(new Entry[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                for (Entry entry : (Entry[]) array) {
                    if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                k kVar = this.journalWriter;
                e.c(kVar);
                kVar.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z5) throws IOException {
        e.f(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (!e.a(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        if (z5 && !entry$okhttp.getReadable$okhttp()) {
            int i3 = this.valueCount;
            for (int i10 = 0; i10 < i3; i10++) {
                boolean[] written$okhttp = editor.getWritten$okhttp();
                e.c(written$okhttp);
                if (!written$okhttp[i10]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i10))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i11 = this.valueCount;
        for (int i12 = 0; i12 < i11; i12++) {
            File file = entry$okhttp.getDirtyFiles$okhttp().get(i12);
            if (!z5 || entry$okhttp.getZombie$okhttp()) {
                this.fileSystem.delete(file);
            } else if (this.fileSystem.exists(file)) {
                File file2 = entry$okhttp.getCleanFiles$okhttp().get(i12);
                this.fileSystem.rename(file, file2);
                long j4 = entry$okhttp.getLengths$okhttp()[i12];
                long size = this.fileSystem.size(file2);
                entry$okhttp.getLengths$okhttp()[i12] = size;
                this.size = (this.size - j4) + size;
            }
        }
        entry$okhttp.setCurrentEditor$okhttp(null);
        if (entry$okhttp.getZombie$okhttp()) {
            removeEntry$okhttp(entry$okhttp);
            return;
        }
        this.redundantOpCount++;
        k kVar = this.journalWriter;
        e.c(kVar);
        if (!entry$okhttp.getReadable$okhttp() && !z5) {
            this.lruEntries.remove(entry$okhttp.getKey$okhttp());
            kVar.Q(REMOVE).E(32);
            kVar.Q(entry$okhttp.getKey$okhttp());
            kVar.E(10);
            kVar.flush();
            if (this.size <= this.maxSize || journalRebuildRequired()) {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            }
        }
        entry$okhttp.setReadable$okhttp(true);
        kVar.Q(CLEAN).E(32);
        kVar.Q(entry$okhttp.getKey$okhttp());
        entry$okhttp.writeLengths$okhttp(kVar);
        kVar.E(10);
        if (z5) {
            long j10 = this.nextSequenceNumber;
            this.nextSequenceNumber = 1 + j10;
            entry$okhttp.setSequenceNumber$okhttp(j10);
        }
        kVar.flush();
        if (this.size <= this.maxSize) {
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String str) throws IOException {
        return edit$default(this, str, 0L, 2, null);
    }

    public final synchronized void evictAll() throws IOException {
        try {
            initialize();
            Collection<Entry> values = this.lruEntries.values();
            e.e(values, "lruEntries.values");
            Object[] array = values.toArray(new Entry[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            for (Entry entry : (Entry[]) array) {
                e.e(entry, "entry");
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            k kVar = this.journalWriter;
            e.c(kVar);
            kVar.flush();
        }
    }

    public final synchronized Snapshot get(String key) throws IOException {
        e.f(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        k kVar = this.journalWriter;
        e.c(kVar);
        kVar.Q(READ).E(32).Q(key).E(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshot$okhttp;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        try {
            if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
                StringBuilder sb2 = new StringBuilder("Thread ");
                Thread currentThread = Thread.currentThread();
                e.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST hold lock on ");
                sb2.append(this);
                throw new AssertionError(sb2.toString());
            }
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th2) {
                        this.closed = false;
                        throw th2;
                    }
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        try {
            k kVar = this.journalWriter;
            if (kVar != null) {
                kVar.close();
            }
            w a3 = e6.a(this.fileSystem.sink(this.journalFileTmp));
            try {
                a3.Q(MAGIC);
                a3.E(10);
                a3.Q(VERSION_1);
                a3.E(10);
                a3.R(this.appVersion);
                a3.E(10);
                a3.R(this.valueCount);
                a3.E(10);
                a3.E(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.getCurrentEditor$okhttp() != null) {
                        a3.Q(DIRTY);
                        a3.E(32);
                        a3.Q(entry.getKey$okhttp());
                        a3.E(10);
                    } else {
                        a3.Q(CLEAN);
                        a3.E(32);
                        a3.Q(entry.getKey$okhttp());
                        entry.writeLengths$okhttp(a3);
                        a3.E(10);
                    }
                }
                a3.close();
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                }
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = newJournalWriter();
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            } finally {
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean remove(String key) throws IOException {
        e.f(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        k kVar;
        e.f(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (kVar = this.journalWriter) != null) {
                kVar.Q(DIRTY);
                kVar.E(32);
                kVar.Q(entry.getKey$okhttp());
                kVar.E(10);
                kVar.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i3 = this.valueCount;
        for (int i10 = 0; i10 < i3; i10++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i10));
            this.size -= entry.getLengths$okhttp()[i10];
            entry.getLengths$okhttp()[i10] = 0;
        }
        this.redundantOpCount++;
        k kVar2 = this.journalWriter;
        if (kVar2 != null) {
            kVar2.Q(REMOVE);
            kVar2.E(32);
            kVar2.Q(entry.getKey$okhttp());
            kVar2.E(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z5) {
        this.closed = z5;
    }

    public final synchronized void setMaxSize(long j4) {
        this.maxSize = j4;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    public final synchronized Editor edit(String key, long j4) throws IOException {
        e.f(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (j4 != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != j4)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            k kVar = this.journalWriter;
            e.c(kVar);
            kVar.Q(DIRTY).E(32).Q(key).E(10);
            kVar.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, key);
                this.lruEntries.put(key, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }
}
