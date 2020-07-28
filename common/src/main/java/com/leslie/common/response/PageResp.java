package com.leslie.common.response;

import com.leslie.common.util.PojoConvertUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
public class PageResp<T> {
    /**
     * 第几页
     */
    private Integer pageNum;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总记录数
     */
    private Long totalCount;
    /**
     * 当前页的数据
     */
    private List<T> dataList;

    public PageResp() {

    }

    public PageResp(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageResp(Integer pageNum, Integer pageSize, Integer totalPage, Long totalCount) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
    }

    public PageResp(Integer pageNum, Integer pageSize, Integer totalPage, Long totalCount, List<T> dataList) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.dataList = dataList;
    }

    public <U> PageResp<U> map(Function<? super T, ? extends U> converter) {
        PageResp<U> result = new PageResp<>();
        result.setPageNum(this.pageNum);
        result.setPageSize(this.pageSize);
        result.setTotalPage(this.totalPage);
        result.setTotalCount(this.totalCount);
        if (this.dataList != null && this.dataList.size() > 0) {
            result.setDataList(this.dataList.stream().map(converter).collect(Collectors.toList()));
        }
        return result;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> PageResp<T> from(Page<T> pageInfo) {
        PageResp<T> result = new PageResp<>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber() + 1);
        result.setPageSize(pageInfo.getSize());
        result.setTotalCount(pageInfo.getTotalElements());
        result.setDataList(pageInfo.getContent());
        return result;
    }

    public static <T, F> PageResp<T> from(Page<F> pageInfo, Class<T> targetClass) {
        PageResp<T> result = new PageResp<>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber() + 1);
        result.setPageSize(pageInfo.getSize());
        result.setTotalCount(pageInfo.getTotalElements());
        result.setDataList(pageInfo.map(e -> PojoConvertUtils.convertObjectToAnother(e, targetClass)).getContent());
        return result;
    }


}
