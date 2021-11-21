package multithreadsemaphore;

class Consumer {
    SharedMemory[] sharedResources;

    Consumer(SharedMemory[] sharedResources){
        this.sharedResources = sharedResources;
    }
    
}
