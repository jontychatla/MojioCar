package jonty.com.mojocar.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by bharatkc on 1/3/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trip implements Serializable {
    @JsonProperty("PageSize")
    private int pageSize;
    @JsonProperty("Offset")
    private int offset;
    @JsonProperty("TotalRows")
    private int totalRows;
    @JsonProperty("Data")
    private ArrayList<Data> data;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }


    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
}
