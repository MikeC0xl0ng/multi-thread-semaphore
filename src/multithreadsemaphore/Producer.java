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
                //System.out.println("Producer " + threadNumber + ": trying access to resource #" + i);
                if(sharedResource.tryAccess()){
                    int value = sharedResources[i].value;
                    System.out.println("Producer " + threadNumber + ": accessing resource #" + i);
                    if(value == -1){
                        System.out.println("Producer " + threadNumber + ": working with the resource #" + i);
                        sharedResource.value += 1;
                        try{
                            sleep(5000);
                        }catch(Exception e){}
                        System.out.println("Producer " + threadNumber + ": released the resource #" + i + "(" + sharedResources[i].value + ")");
                    }else{
                        //System.out.println("Producer " + threadNumber + ": the resource #" + i + "'s value is different from -1");
                    }
                    sharedResource.release();
                }
                if(i == (sharedResources.length-1)){
                    i=-1;
                }
            }
            
        }
    }
    
}
