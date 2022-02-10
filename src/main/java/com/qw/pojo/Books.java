package com.qw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    // 这里用Integer可以防止空指针异常
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;
}
