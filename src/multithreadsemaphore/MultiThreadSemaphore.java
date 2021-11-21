package multithreadsemaphore;

/**
 *
 * @author nick
 */
public class MultiThreadSemaphore {
    
    static final int NUMBER_SHARED_RESOURCES = 2;
    static final int NUMBER_PRODUCERS = 1;
    static final int NUMBER_CONSUMERS = 2;

    public static void main(String[] args) {
        SharedMemory [] sharedResources = new SharedMemory[NUMBER_SHARED_RESOURCES];
        for(int i=0; i<sharedResources.length; i++){
            sharedResources[i] = new SharedMemory();
        }
        Producer [] producers = new Producer[NUMBER_PRODUCERS];
        for(int i=0; i<producers.length; i++){
            producers[i] = new Producer(i+1, sharedResources);
        }
        Consumer [] consumers = new Consumer[NUMBER_CONSUMERS];
        for(int i=0; i<consumers.length; i++){
            consumers[i] = new Consumer(i+1, sharedResources);
        }
        for(int i=0; i<producers.length; i++){
            producers[i].start();
        }
        for(int i=0; i<consumers.length; i++){
            consumers[i].start();
        }
    }
    
}
