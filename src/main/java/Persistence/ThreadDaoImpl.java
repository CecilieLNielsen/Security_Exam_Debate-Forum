package Persistence;

import Models.ThreadDTO;
import Models.ThreadWithCommentsDTO;
import Persistence.DAO.ThreadDao;

import java.util.List;

public class ThreadDaoImpl implements ThreadDao {
    @Override
    public int createThread(ThreadDTO thread) {
        return 0;
    }

    @Override
    public List<ThreadDTO> getAllThreads() {
        return null;
    }

    @Override
    public ThreadDTO getThreadById(int id) {
        return null;
    }

    @Override
    public ThreadWithCommentsDTO getThreadWithCommentsById(int id) {
        return null;
    }

    @Override
    public int updateThread(ThreadDTO thread) {
        return 0;
    }

    @Override
    public void deleteThread(int id) {

    }
}
