package Persistence.DAO;

import Models.ThreadDTO;
import Models.ThreadWithCommentsDTO;

import java.util.List;

public interface ThreadDao {
    int createThread(ThreadDTO thread);

    List<ThreadDTO> getAllThreads();

    ThreadWithCommentsDTO getThreadById(int id);

    int updateThread(ThreadDTO thread);

    void deleteThread(int id);
}
