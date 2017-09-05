package de.jdufner.tutorials.tin;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class TinGeneratorTest {

  public static void main(final String[] args) throws Exception {
    final Date start = new Date();
    final BlockingQueue<Long> queue = new LinkedBlockingQueue<>(10);
    final Collection<Thread> producersAndConsumers = new LinkedList<>();
    final long poisonPill = Long.MAX_VALUE;
    final int numberConsumers = Runtime.getRuntime().availableProcessors();
    final Producer producer = new Producer(queue, poisonPill, numberConsumers);
    Thread producerThread = new Thread(producer);
    producersAndConsumers.add(producerThread);
    producerThread.start();
    for (int consumerIndex = 0; consumerIndex < numberConsumers; consumerIndex++) {
      final Consumer consumer = new Consumer(queue, poisonPill);
      Thread consumerThread = new Thread(consumer);
      producersAndConsumers.add(consumerThread);
      consumerThread.start();
    }
    blockUntilAllThreadsDead(producersAndConsumers);
    final Date end = new Date();
    System.out.println(end.getTime() - start.getTime());
  }

  private static void blockUntilAllThreadsDead(final Collection<Thread> producersAndConsumers)
      throws InterruptedException {
    while (true) {
      boolean isAtLeastOneThreadAlive = false;
      for (Thread t : producersAndConsumers) {
        if (t.isAlive()) {
          isAtLeastOneThreadAlive = true;
        }
      }
      if (!isAtLeastOneThreadAlive) {
        return;
      } else {
        Thread.currentThread().sleep(1000);
      }
    }
  }

  public static class Producer implements Runnable {

    private final BlockingQueue<Long> queue;
    private final long poisonPill;
    private final int numberConsumer;

    public Producer(final BlockingQueue<Long> queue, final long poisonPill, final int numberConsumers) {
      this.queue = queue;
      this.poisonPill = poisonPill;
      this.numberConsumer = numberConsumers;
    }

    @Override
    public void run() {
      try {
        generate();
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
      }
    }

    private void generate() throws InterruptedException {
      for (long l = 10020345670L; l < 10123456789L; l++) {
        queue.put(l);
      }
      for (int i = 0; i < numberConsumer; i++) {
        queue.put(poisonPill);
      }
    }

  }

  public static class Consumer implements Runnable {

    private BlockingQueue<Long> queue;
    private long poisonPill;

    public Consumer(final BlockingQueue<Long> queue, long poisonPill) {
      this.queue = queue;
      this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
      try {
        testNumber();
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
      }
    }

    private void testNumber() throws InterruptedException {
      while (true) {
        long number = queue.take();
        if (number == poisonPill) {
          return;
        }
        Tin tin = new Tin(number);
        if (tin.isValid()) {
//          System.out.println(tin);
        }
      }
    }

  }

}
