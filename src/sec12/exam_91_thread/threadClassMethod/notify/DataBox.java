package sec12.exam_91_thread.threadClassMethod.notify;

public class DataBox {
    private String data;

    public synchronized String getData(){
        if (this.data == null){
            try {
                wait();
            } catch (Exception e){}
        }
        String returnValue = data;
        System.out.println("ConsummeThread가 읽은 데이터 : " + returnValue);
        data = null;
        notify();
        return returnValue;
    }

    public synchronized void setData(String data){
        if (this.data != null){
            try {
                wait();
            } catch (Exception e){}
        }
        this.data = data;
        System.out.println("ProducerThread가 생성한 데이터 :" + data);
        notify();
    }
}
