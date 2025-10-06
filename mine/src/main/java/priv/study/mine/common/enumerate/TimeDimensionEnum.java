package priv.study.mine.common.enumerate;

import lombok.Getter;

/**
 * 时间维度枚举
 * 
 * @author JLian
 * @date 2025年10月05日
 */
@Getter
public enum TimeDimensionEnum {


    YEAR("year", "1"),
    MONTH("month" , "2");
    
    private final String timeDimension;

    private final String code;

    TimeDimensionEnum(String timeDimension, String code) {
        this.timeDimension = timeDimension;
        this.code = code;
    }
}
