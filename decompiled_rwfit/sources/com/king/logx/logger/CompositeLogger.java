package com.king.logx.logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class CompositeLogger extends Logger {
    private volatile Logger[] loggerArray;
    private final ArrayList<Logger> loggers;

    public CompositeLogger() {
        super(0, 1, null);
        this.loggers = new ArrayList<>();
        this.loggerArray = new Logger[0];
    }

    public final void addLogger(Logger logger) {
        e.f(logger, "logger");
        if (logger == this) {
            throw new IllegalArgumentException(("Cannot add " + logger.getClass().getSimpleName() + " into itself.").toString());
        }
        synchronized (this.loggers) {
            this.loggers.add(logger);
            this.loggerArray = (Logger[]) this.loggers.toArray(new Logger[0]);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void d(String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.d(str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void e(String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.e(str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void i(String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.i(str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void log(int i3, String str) {
        for (Logger logger : this.loggerArray) {
            logger.log(i3, str);
        }
    }

    public final int loggerCount() {
        return this.loggerArray.length;
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public ILogger offset(int i3) {
        for (Logger logger : this.loggerArray) {
            logger.offset(i3);
        }
        return this;
    }

    public final void removeAllLoggers() {
        synchronized (this.loggers) {
            this.loggers.clear();
            this.loggerArray = new Logger[0];
        }
    }

    public final void removeLogger(Logger logger) {
        e.f(logger, "logger");
        synchronized (this.loggers) {
            if (!this.loggers.remove(logger)) {
                throw new IllegalArgumentException(("Cannot remove logger which is not added: " + logger).toString());
            }
            this.loggerArray = (Logger[]) this.loggers.toArray(new Logger[0]);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public ILogger tag(String tag) {
        e.f(tag, "tag");
        for (Logger logger : this.loggerArray) {
            logger.tag(tag);
        }
        return this;
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void v(String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.v(str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void w(String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.w(str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void wtf(String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.wtf(str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void d(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.d(th2, str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void e(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.e(th2, str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void i(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.i(th2, str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void log(int i3, Throwable th2, String str) {
        for (Logger logger : this.loggerArray) {
            logger.log(i3, th2, str);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void v(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.v(th2, str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void w(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.w(th2, str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void wtf(Throwable th2, String str, Object... args) {
        e.f(args, "args");
        for (Logger logger : this.loggerArray) {
            logger.wtf(th2, str, Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void d(Throwable th2) {
        for (Logger logger : this.loggerArray) {
            logger.d(th2);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void e(Throwable th2) {
        for (Logger logger : this.loggerArray) {
            logger.e(th2);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void i(Throwable th2) {
        for (Logger logger : this.loggerArray) {
            logger.i(th2);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void log(int i3, Throwable th2) {
        for (Logger logger : this.loggerArray) {
            logger.log(i3, th2);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void v(Throwable th2) {
        for (Logger logger : this.loggerArray) {
            logger.v(th2);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void w(Throwable th2) {
        for (Logger logger : this.loggerArray) {
            logger.w(th2);
        }
    }

    @Override // com.king.logx.logger.Logger, com.king.logx.logger.ILogger
    public void wtf(Throwable th2) {
        for (Logger logger : this.loggerArray) {
            logger.wtf(th2);
        }
    }

    public final void addLogger(Logger... loggers) {
        e.f(loggers, "loggers");
        if (loggers.length == 0) {
            return;
        }
        for (Logger logger : loggers) {
            if (logger == this) {
                throw new IllegalArgumentException(("Cannot add " + logger.getClass().getSimpleName() + " into itself.").toString());
            }
        }
        synchronized (this.loggers) {
            Collections.addAll(this.loggers, Arrays.copyOf(loggers, loggers.length));
            this.loggerArray = (Logger[]) this.loggers.toArray(new Logger[0]);
        }
    }

    @Override // com.king.logx.logger.Logger
    public void log(int i3, String str, String str2, Throwable th2) {
        throw new AssertionError();
    }
}
