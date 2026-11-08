package tprev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class JournalApplicationTest {
    @Test
    void deuxAppelsMemeInstance() {
        JournalApplication j1 =
                JournalApplication.getInstance();

        JournalApplication j2 =
                JournalApplication.getInstance();

        assertSame(j1, j2);
    }

    @Test
    void centThreadsEcrivent() throws InterruptedException {
        JournalApplication journal =
                JournalApplication.getInstance();
        int avant = journal.getMessages().size();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final int numero = i;
            Thread t = new Thread(() -> {
                journal.ecrire("Message " + numero);
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        int apres = journal.getMessages().size();
        assertEquals(100, apres - avant);
    }
}