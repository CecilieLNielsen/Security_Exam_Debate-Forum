package Persistence;

import Models.ThreadDTO;
import Persistence.DAO.ThreadDao;

import java.util.ArrayList;
import java.util.List;

public class ThreadDaoImpl implements ThreadDao {

    private List<ThreadDTO> threads;

    public ThreadDaoImpl() {
        threads = new ArrayList<>();
        threads.add(new ThreadDTO(1, "JSP help", "Code", "Clay Jensen", "How to make JSP? I have been struggling with creating simple pages", "24/04/2021", "24/04/2021"));
        threads.add(new ThreadDTO(2, "Cake recipes", "Food", "Bertilda Monteson", "I need a good recipe for chocolate brownie cake", "25/04/2021", "25/04/2021"));
        threads.add(new ThreadDTO(3, "Funny cats", "Animal", "James Ford", "My cat is doing this funny thing when I put a cucumber in front of it", "25/04/2021", "26/04/2021"));
    }

    @Override
    public int createThread(ThreadDTO thread) {
        int newThreadId = 1; // Start ID hvis ingen tråde findes i systemet
        if (!threads.isEmpty()) { // Tjekker på om listen ikke er tom
            int lastThreadIndex = threads.size() - 1; // Henter index plads på den seneste tråd
            int lastThreadId = threads.get(lastThreadIndex).getId(); // Henter ID ud fra den givne indexplads
            newThreadId = lastThreadId + 1; // Autoincrement ID på næste tråd
        }
        thread.setId(newThreadId);
        threads.add(thread);
        return thread.getId();
    }

    @Override
    public List<ThreadDTO> getAllThreads() {
        return threads;
    }

    @Override
    public ThreadDTO getThreadById(int id) {
        for (ThreadDTO thread : threads) {
            if (thread.getId() == id) { // Looper igennem for at finde det tilsvarende id, hvis det findes bliver det returneret
                return thread;
            }
        }
        return null;
    }

    @Override
    public int updateThread(ThreadDTO updatedThread) {
        for (ThreadDTO existingThread : threads) {
            if (existingThread.getId() == updatedThread.getId()) {
                existingThread.setAuthor(updatedThread.getAuthor());
                existingThread.setTitle(updatedThread.getTitle());
                existingThread.setCategory(updatedThread.getCategory());
                existingThread.setDescription(updatedThread.getDescription());
                existingThread.setDateOfUpdate(updatedThread.getDateOfUpdate());
                return existingThread.getId();
            }
        }
        return -1;
    }

    @Override
    public void deleteThread(int id) {
        for (int i = 0; i < threads.size(); i++) {
            ThreadDTO thread = threads.get(i);
            if (thread.getId() == id) {
                threads.remove(i);
            }
        }

    }
}
