package multithreadsemaphore;

import java.util.concurrent.Semaphore;

class SharedMemory {
    
    int value;
    private Semaphore semaphore;

    public SharedMemory() {
        this.value = -1;
        this.semaphore = new Semaphore(1);
    }
    
    boolean tryAccess(){
        return semaphore.tryAcquire();
    }
    
    void release() {
        semaphore.release();
    }
}
