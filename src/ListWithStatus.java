import java.util.ArrayList;
import java.util.List;

public class ListWithStatus<T> {

    DataStatus status;
    List<T> dataList;

    public ListWithStatus() {

    }

    public ListWithStatus(DataStatus status) {
        this.status = status;
        this.dataList = new ArrayList<>();
    }

    public DataStatus getStatus() {
        return status;
    }

    public List<T> getDataList() {
        return dataList;
    }
}
