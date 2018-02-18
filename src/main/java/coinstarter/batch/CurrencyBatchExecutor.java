package coinstarter.batch;

import coinstarter.domain.currency.repository.CurrencyRepository;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class CurrencyBatchExecutor {

    private final static int CORE_POOL_SIZE = 1;

    private final ScheduledThreadPoolExecutor batchExecutorService;

    public CurrencyBatchExecutor(CurrencyRepository repository, CurrencyBatchProperties properties) {
        this.batchExecutorService = new ScheduledThreadPoolExecutor(CORE_POOL_SIZE,
                                                                    new DefaultThreadFactory("currency batch", true),
                                                                    new ThreadPoolExecutor.DiscardPolicy());
        this.batchExecutorService.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        this.batchExecutorService.setRemoveOnCancelPolicy(true);
        this.batchExecutorService.scheduleWithFixedDelay(new CurrencyBatchThread(repository),
                                                         properties.getInitialDelay(),
                                                         properties.getPeriod(),
                                                         MILLISECONDS);
    }

    public static final class DefaultThreadFactory implements ThreadFactory {

        private final String threadName;
        private final boolean daemon;

        DefaultThreadFactory(String threadName, boolean daemon) {
            this.threadName = threadName;
            this.daemon = daemon;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, threadName);
            thread.setDaemon(daemon);
            return thread;
        }
    }
}
