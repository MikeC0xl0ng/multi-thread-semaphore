package multithreadsemaphore;

/**
 *
 * @author nick
 */
public class MultiThreadSemaphore {
    
    static final int NUMBER_SHARED_RESOURCES = 10;
    static final int NUMBER_Producers = 5;

    public static void main(String[] args) {
        SharedMemory [] sharedMemories = new SharedMemory[NUMBER_SHARED_RESOURCES];
        for(int i=0; i<sharedMemories.length; i++){
            sharedMemories[i] = new SharedMemory();
        }
        Producer [] producers = new Producer[NUMBER_Producers];
        for(int i=0; i<producers.length; i++){
            producers[i] = new Producer();
        }
    }
    
}
