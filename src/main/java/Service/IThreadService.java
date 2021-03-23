package Service;

import Models.ThreadDTO;
import Models.ThreadWithCommentsDTO;

import java.util.List;

public interface IThreadService {
    public int createThread(ThreadDTO thread);
    public List<ThreadDTO> getAllThreads();
    public ThreadWithCommentsDTO getThreadWithCommentsById(int id);
    public int updateThread(ThreadDTO thread);
    public void deleteThread(int id);
}
