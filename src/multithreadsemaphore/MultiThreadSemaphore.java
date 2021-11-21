package multithreadsemaphore;

/**
 *
 * @author nick
 */
public class MultiThreadSemaphore {
    
    static final int NUMBER_SHARED_RESOURCES = 10;
    static final int NUMBER_PRODUCERS = 5;

    public static void main(String[] args) {
        SharedMemory [] sharedResources = new SharedMemory[NUMBER_SHARED_RESOURCES];
        for(int i=0; i<sharedResources.length; i++){
            sharedResources[i] = new SharedMemory();
        }
        Producer [] producers = new Producer[NUMBER_PRODUCERS];
        for(int i=0; i<producers.length; i++){
            producers[i] = new Producer(sharedResources);
        }
        for(int i=0; i<producers.length; i++){
            producers[i].start();
        }
    }
    
}
