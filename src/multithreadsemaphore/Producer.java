package multithreadsemaphore;

class Producer extends Thread{
    SharedMemory [] sharedResources;
    int threadNumber;
    
    
    public Producer(int threadNumber, SharedMemory [] sharedResources){
        this.sharedResources = sharedResources;
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run(){
        while(true){
            System.out.println("Producer " + threadNumber + ": starting...");
            for(int i=0; i<sharedResources.length; i++){
                SharedMemory sharedResource = sharedResources[i];
                System.out.println("Producer " + threadNumber + ": trying access to resource #" + i);
                boolean accessGranted = sharedResource.tryAccess();
                if(accessGranted){
                    System.out.println("Producer " + threadNumber + ": access granted to resource #" + i);
                    int value = sharedResources[i].value;
                    if(value == -1){
                        System.out.println("Producer " + threadNumber + ": working with the resource #" + i);
                        sharedResource.value += 1;
                        try{
                            sleep(2000);
                        }catch(Exception e){}
                        sharedResource.release();
                        System.out.println("Producer " + threadNumber + ": released the resource #" + i + ", it's new value is " + sharedResources[i].value);
                    }else{
                        System.out.println("Producer " + threadNumber + ": the resource #" + i + "'s value is different from -1");                        
                        sharedResource.release();
                    }
                }else{
                    System.out.println("Producer " + threadNumber + ": no acces to resource #" + i);
                    try {
                        sleep(1000);
                    } catch (Exception e) {}
                }
                if(i == (sharedResources.length-1)){
                    i=-1;
                }
            }
            
        }
    }
    
}
