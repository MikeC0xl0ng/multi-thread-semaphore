package multithreadsemaphore;

class Consumer extends Thread{
    SharedMemory[] sharedResources;
    int threadNumber;

    Consumer(int threadNumber, SharedMemory[] sharedResources){
        this.sharedResources = sharedResources;
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run(){
        while(true){
            System.out.println("Consumer " + threadNumber + ": starting...");
            for(int i=0; i<sharedResources.length; i++){
                SharedMemory sharedResource = sharedResources[i];
                System.out.println("Consumer " + threadNumber + ": trying access to resource #" + i);
                boolean accessGranted = sharedResource.tryAccess();
                if(accessGranted){
                    System.out.println("Consumer " + threadNumber + ": access granted to resource #" + i);
                    int value = sharedResource.value;
                    if(value != -1){
                        System.out.println("Consumer " + threadNumber + ": consuming the resource #" + i);
                        sharedResource.value = -1;
                        try{
                            sleep(2000);
                        }catch(Exception e){}
                        System.out.println("Consumer " + threadNumber + ": consumed the resource #" + i);
                        sharedResource.release();
                        System.out.println("Consumer " + threadNumber + ": released the resource #" + i);
                    }else{
                        System.out.println("Consumer " + threadNumber + ": resource #" + i + "'s values wasn't changed yet");
                        sharedResource.release();
                    }                    
                }else{
                    System.out.println("Consumer " + threadNumber + ": no acces to resource #" + i);
                    try{
                        sleep(1000);
                    }catch(Exception e){}
                }
                if(i == (sharedResources.length-1)){
                    i=-1;
                }
            }
        }
    }
    
}
