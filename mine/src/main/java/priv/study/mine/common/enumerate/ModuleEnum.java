package priv.study.mine.common.enumerate;

import lombok.Getter;

/**
 * @author JLian
* @date 2025年10月04日
 */
@Getter
public enum ModuleEnum {

    USER("用户模块", "5"),
    MOVIE("电影模块", "1"),
    TRAVEL("旅行模块", "2"),
    BOOK("书籍模块", "3"),
    NOTES("笔记模块", "4"),
    TAG("标签模块", "6");

    private final String module;

    private final String value;

    ModuleEnum(String message, String value) {
        this.module = message;
        this.value = value;
    }

}
