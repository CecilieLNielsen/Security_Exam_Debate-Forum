package Service.Interfaces;

import Models.DTO.ThreadDTO;
import Models.DTO.ThreadWithCommentsDTO;

import java.util.List;

public interface IThreadService {
    int createThread(ThreadDTO thread);

    List<ThreadDTO> getAllThreads();

    ThreadWithCommentsDTO getThreadWithCommentsById(int id);

    int updateThread(ThreadDTO thread);

    void deleteThread(int id);
}
