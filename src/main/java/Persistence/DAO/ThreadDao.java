package Persistence.DAO;

import Models.ThreadDTO;
import Models.ThreadWithCommentsDTO;

import java.util.List;

public interface ThreadDao {
    public int createThread(ThreadDTO thread);
    public List<ThreadDTO> getAllThreads();
    public ThreadDTO getThreadById(int id);
    public int updateThread(ThreadDTO thread);
    public void deleteThread(int id);
}
