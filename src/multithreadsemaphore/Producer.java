package multithreadsemaphore;

class Producer extends Thread{
    SharedMemory [] sharedResources;
    
    
    public Producer(SharedMemory [] sharedResources){
        this.sharedResources = sharedResources;
    }
    
    @Override
    public void run(){
        while(true){
            long threadId = Thread.currentThread().getId();
            System.out.println("Thread " + threadId + ": starting...");
            for(int i=0; i<sharedResources.length; i++){
                if(sharedResources[i].tryAccess()){
                    System.out.println("Thread " + threadId + ": inside of resource #" + i);
                    System.out.println("Thread " + threadId + ": working with the resource...");
                    sharedResources[i].value += 1;
                    try{
                        sleep(2000);
                    }catch(Exception e){}
                    System.out.println("Thread " + threadId + ": finished my work with the resource!");
                    sharedResources[i].release();
                    System.out.println("Thread " + threadId + ": released the resource!");
                    i=-1;
                }
                if(i == (sharedResources.length-1)){
                    i=0;
                }
            }
            
        }
    }
    
}
