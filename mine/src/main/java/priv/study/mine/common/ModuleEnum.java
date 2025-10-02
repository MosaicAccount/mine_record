package priv.study.mine.common;

import lombok.Getter;

/**
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
public enum ModuleEnum {

    USER("用户模块"),
    MOVIE("电影模块"),
    TRAVEL("旅行模块"),
    BOOK("书籍模块"),
    NOTES("笔记模块"),;

    private final String module;


    ModuleEnum(String message) {
        this.module = message;
    }

}
