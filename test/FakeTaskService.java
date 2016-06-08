import com.microsoft.azure.storage.StorageException;

import ge.edu.freeuni.sdp.bathclimate.core.TaskService;


public class FakeTaskService extends TaskService {
	@Override
	public Repository getRepository() throws StorageException {
		return FakeRepository.instance();
	}
}
