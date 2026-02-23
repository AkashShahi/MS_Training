package day6.synchronizationandlock.ReaderWriter;

import java.util.List;

public class SharedResource {

    private List<Integer> list;

    public SharedResource(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }
}
