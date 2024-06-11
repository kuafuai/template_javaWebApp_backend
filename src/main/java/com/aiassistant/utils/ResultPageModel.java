import java.util.List;

public class ResultPageModel<T> {

    private Integer totalRecords;
    private Integer pageNo;
    private Integer pageSize;
    private Integer totalPage;
    private Integer firstIndex;
    private List<T> list;

    public ResultPageModel() {
    }

    public ResultPageModel(List<T> list) {
        this.list = list;
    }

    public Integer getFirstIndex() {
        return firstIndex;
    }

    public static <T> ResultPageModel<T> of(List<T> list) {
        ResultPageModel<T> resultPageModel = new ResultPageModel<>(list);
        return resultPageModel;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "ResultPageModel{" +
                "totalRecords=" + totalRecords +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", firstIndex=" + firstIndex +
                ", list=" + list +
                '}';
    }
}
