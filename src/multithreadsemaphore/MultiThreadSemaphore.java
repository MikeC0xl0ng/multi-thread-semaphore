package multithreadsemaphore;

/**
 *
 * @author nick
 */
public class MultiThreadSemaphore {
    
    static final int NUMBER_SHARED_RESOURCES = 10;

    public static void main(String[] args) {
        SharedMemory [] sharedMemory = new SharedMemory[NUMBER_SHARED_RESOURCES];
        for(int i=0; i<sharedMemory.length; i++){
            sharedMemory[i] = new SharedMemory();
        }      
    }
    
}
